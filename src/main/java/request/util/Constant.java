package request.util;

public interface Constant {

    String GET_ONE = "https://api.coinmarketcap.com/v1/ticker/%s/?convert=RUB";

    String GET_TEN = "https://api.coinmarketcap.com/v1/ticker/?convert=RUB&limit=10";

    String GET_N_COUNT = "https://api.coinmarketcap.com/v1/ticker/?convert=RUB&limit=%s";

    String ERROR_VAR = "Sorry, symbol is not found" + "\n" +
            "Please see this table of symbols" + "\n" +
            "____________________________________" + "\n" +
            "btc : Bitcoin" + "\n" +
            "eth : Ethereum" + "\n" +
            "xrp : XRP" + "\n" +
            "bch : Bitcoin Cash" + "\n" +
            "eos : EOS" + "\n" +
            "xlm : Stellar" + "\n" +
            "ltc : Litecoin" + "\n" +
            "usdt : Tether" + "\n" +
            "ada : Cardano" + "\n" +
            "xmr : Monero" + "\n" +
            "_____________________________________" + "\n" +
            "Bot commands:" + "\n" +
            "/all: Get info about all cryptocoinz" + "\n" +
            "/get N: Get list cryptocoinz info of size N " + "\n" +
            "_____________________________________" + "\n" +
            "   Thanks. Good wishes!";
}
