package request;

import org.json.simple.parser.ParseException;
import request.coin.Coin;
import request.controller.GetOneCoin;

import java.io.IOException;

public class Ssss {

    public static void main(String[] args) throws IOException, ParseException {

        Coin run = GetOneCoin.run("eee");
        System.out.println(run.getName() + " " + run.getPrice_rub());

        /*List<Coin> run = GetAllCoins.run();
        System.out.println();
        for (Coin coin : run) {
            System.out.println(coin);
        }
        */

       /* List<Coin> run2 = GetNCoins.run();
        System.out.println();
        for (Coin coin : run2) {
            System.out.println(coin);
        }*/


    }
}
