package request;

import org.json.simple.parser.ParseException;
import request.coin.Coin;
import request.controller.GetNCoins;
import request.controller.GetOneCoin;

import java.io.IOException;
import java.util.List;

public class Ssss {

    public static void main(String[] args) throws IOException, ParseException {

        String line = "/get5";
        String s = line.replaceAll("/get", "").trim();

        List<Coin> run2 = GetNCoins.run(s);
        System.out.println();
        for (Coin coin : run2) {
            System.out.println(coin);
        }


    }
}
