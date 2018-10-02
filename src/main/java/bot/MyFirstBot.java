package bot;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import request.coin.Coin;
import request.coin.CoinsMap;
import request.controller.GetAllCoins;
import request.controller.GetNCoins;
import request.controller.GetOneCoin;
import request.util.Constant;

import java.io.IOException;
import java.util.List;

public class MyFirstBot extends TelegramLongPollingBot {

    private static final Logger log = Logger.getLogger(MyFirstBot.class);

    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            long chat_id = update.getMessage().getChatId();
            String message_text = update.getMessage().getText();
            String user_username = update.getMessage().getChat().getUserName();

            String user_first_name = update.getMessage().getChat().getFirstName();

            if(message_text.contains("/get")) {
                String count = message_text.replaceAll("/get", "").trim();

                try {
                    List<Coin> coins = GetNCoins.run(count);

                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText(coins.toString()
                                    .replaceAll(",", "")
                                    .replaceAll("]", "")
                                    .replaceAll("\\[", "").trim());

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


            } else if(message_text.equals("/start")) {

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Hello, " + user_first_name + "!" + "\n" +
                                "Welcome to Crypto Currency bot-chat." + "\n" +
                                "Here you can get info about crypto currency in real time." + "\n" +
                                "To start writing a some string." + "\n"+
                                "For example /love" + "\n" + "\n" +
                                "If you have some problems. Please!" + "\n" +
                                "Write me @max_bubnov" + "\n" + "\n" +
                                "Thanks. Good luck!" + "\n" +
                                "Created by ©Maxim Bubnov");

                try {
                    execute(message); // Sending our message object to user
                    log.info("User join : " + user_username);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (message_text.equals("/all")) {
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
