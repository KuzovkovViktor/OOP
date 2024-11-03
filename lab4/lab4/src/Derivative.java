public class Derivative implements FinancialInstrument {
    private String type;
    private double value;

    public Derivative(String type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public FinancialInstrument clone() {
        return new Derivative(this.type, this.value);
    }

    @Override
    public void displayInfo() {
        System.out.println("Derivative: " + type + ", Value: " + value);
    }
}
