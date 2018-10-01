package request.util;

import org.json.simple.JSONObject;
import request.coin.Coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

public class GettingStringFromJson {

    public static void getStringFromJsonArray(StringBuffer response, HttpURLConnection connection) throws IOException {

        if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }

            connection.disconnect();
        }
    }

    public static void addCoinsToList(Iterator phonesItr, List<Coin> coins) {
        while (phonesItr.hasNext()) {
            JSONObject test = (JSONObject) phonesItr.next();

            Coin coin = new Coin();

            coin.setId((String) test.get("id"));
            coin.setName((String) test.get("name"));
            coin.setSymbol((String) test.get("symbol"));
            coin.setPrice_rub(Double.parseDouble((String) test.get("price_rub")));
            coin.setPrice_usd(Double.parseDouble((String) test.get("price_usd")));

            coins.add(coin);
        }
    }
}
