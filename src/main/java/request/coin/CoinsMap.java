package request.coin;

import java.util.HashMap;
import java.util.Map;

public class CoinsMap {

    public static Map<String, String> mapOfCoins = new HashMap<String, String>();

    static {
        mapOfCoins.put("BTC", "bitcoin");
        mapOfCoins.put("ETH", "ethereum");
        mapOfCoins.put("XRP", "ripple");
        mapOfCoins.put("BCH", "bitcoin-cash");
        mapOfCoins.put("EOS", "eos");
        mapOfCoins.put("XLM", "stellar");
        mapOfCoins.put("USDT", "tether");
        mapOfCoins.put("ADA", "cardano");
        mapOfCoins.put("XMR", "monero");
    }

    public static String getCoinByCode(String code) {

        if(mapOfCoins.containsKey(code))
            return mapOfCoins.get(code);
        else
            return "unknown";
    }


}
