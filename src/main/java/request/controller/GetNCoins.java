package request.controller;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import request.coin.Coin;
import request.util.Connection;
import request.util.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static request.util.GettingStringFromJson.addCoinsToList;
import static request.util.GettingStringFromJson.getStringFromJsonArray;


public class GetNCoins{

    public static List<Coin> run(String s) throws IOException, ParseException {

        String url = String.format(Constant.GET_N_COUNT, s);

        StringBuffer  response = new StringBuffer();
        HttpURLConnection connection = Connection.getConnection(url);

        getStringFromJsonArray(response, connection);

        Object obj = new JSONParser().parse(response.toString());

        JSONArray jo = (JSONArray)  obj;

        Iterator phonesItr = jo.iterator();
        System.out.println("Cripto:");

        List<Coin> coins = new ArrayList<Coin>();

        addCoinsToList(phonesItr, coins);

        return coins;

    }



}
