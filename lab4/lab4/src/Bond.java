public class Bond implements FinancialInstrument {
    private String issuer;
    private double interestRate;

    public Bond(String issuer, double interestRate) {
        this.issuer = issuer;
        this.interestRate = interestRate;
    }

    @Override
    public FinancialInstrument clone() {
        return new Bond(this.issuer, this.interestRate);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bond: " + issuer + ", Interest Rate: " + interestRate);
    }
}