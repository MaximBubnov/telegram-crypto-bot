package bot;

import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import request.coin.Coin;
import request.coin.CoinsMap;
import request.controller.GetAllCoins;
import request.controller.GetOneCoin;
import request.util.Constant;

import java.io.IOException;
import java.util.List;

public class MyFirstBot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            long chat_id = update.getMessage().getChatId();
            String message_text = update.getMessage().getText();

            if (message_text.equals("/all")) {
                try {
                    List<Coin> coin = GetAllCoins.run();

                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText(coin.toString()
                                    .replaceAll(",", "")
                                    .replaceAll("]", "")
                                    .replaceAll("\\[", ""));

                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                if (!CoinsMap.mapOfCoins.containsKey(message_text.toUpperCase())) {
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText(Constant.ERROR_VAR);

                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        Coin coin = GetOneCoin.run(message_text);

                        String answer = String.format(
                                "Name : %s" + "\n" +
                                        "Symbol: %s" + "\n" +
                                        "USD $: %s" + "\n" +
                                        "RUB : %s" + "\n",
                                coin.getName(), coin.getSymbol(), coin.getPrice_usd(), coin.getPrice_rub());

                        SendMessage message = new SendMessage() // Create a message object object
                                .setChatId(chat_id)
                                .setText(answer);

                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    // Return bot username
    public String getBotUsername() {
        return "max_java_first_bot";
    }

    public String getBotToken() {
        // Return bot token from BotFather
        return "626007333:AAFLVTxl1RjXj13eLJvIHzRcxFgMF8Ufo8c";
    }
}
