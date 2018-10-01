package request.coin;

public class Coin {
   private String id;
   private String name;
   private String symbol;
   private double price_usd;
   private double price_rub;

   public void setId(String id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public void setPrice_usd(double price_usd) {
      this.price_usd = price_usd;
   }

   public void setPrice_rub(double price_rub) {
      this.price_rub = price_rub;
   }

   public String getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getSymbol() {
      return symbol;
   }

   public double getPrice_usd() {
      return price_usd;
   }

   public double getPrice_rub() {
      return price_rub;
   }

   @Override
   public String toString() {
      return String.format(
              "Name : %s" + "\n" +
                      "Symbol: %s" + "\n" +
                      "USD $: %s" + "\n" +
                      "RUB : %s" + "\n" +
                      "\n",
              getName(), getSymbol(), getPrice_usd(), getPrice_rub());
   }
}
