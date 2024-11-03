public class Stock implements FinancialInstrument {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public FinancialInstrument clone() {
        return new Stock(this.symbol, this.price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Stock: " + symbol + ", Price: " + price);
    }
}

