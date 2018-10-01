package request.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import request.coin.Coin;
import request.coin.CoinsMap;
import request.util.Connection;
import request.util.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class GetOneCoin {

    public static Coin run(String l) throws IOException {

        String lineCode = l.toUpperCase();

        String code = CoinsMap.getCoinByCode(lineCode);

        if(code.equals("unknown")) {
            System.out.println("sorry not found");
        }

        String url = String.format(Constant.GET_ONE, CoinsMap.getCoinByCode(lineCode));

        StringBuffer  response = new StringBuffer();
        HttpURLConnection connection = Connection.getConnection(url);

        getStringFromJson(response, connection);

        Gson g = new GsonBuilder().setLenient().create();

        Coin coin = g.fromJson(response.toString(), Coin.class);

        return coin;
    }

    private static void getStringFromJson(StringBuffer response, HttpURLConnection connection) throws IOException {

        if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }

            response.deleteCharAt(0);
            response.deleteCharAt(response.length()-2);

            connection.disconnect();
        }
    }
}
