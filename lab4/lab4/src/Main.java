public class Main {
    public static void main(String[] args) {
        FinancialInstrumentFactory factory = new FinancialInstrumentFactory();

        // Реєстрація кількох прототипів акцій
        factory.registerPrototype("AAPL", new Stock("AAPL", 150.00));
        factory.registerPrototype("GOOG", new Stock("GOOG", 2800.00));
        factory.registerPrototype("TSLA", new Stock("TSLA", 850.00));

        // Реєстрація інших прототипів (облігації, деривативи)
        factory.registerPrototype("bond", new Bond("Government", 2.5));
        factory.registerPrototype("derivative", new Derivative("Option", 1000.00));

        // Створення копій різних акцій
        FinancialInstrument appleStock = factory.createInstrument("AAPL");
        FinancialInstrument googleStock = factory.createInstrument("GOOG");
        FinancialInstrument teslaStock = factory.createInstrument("TSLA");

        FinancialInstrument bond = factory.createInstrument("bond");
        FinancialInstrument derivative = factory.createInstrument("derivative");

        // Виведення інформації
        appleStock.displayInfo();
        googleStock.displayInfo();
        teslaStock.displayInfo();
        bond.displayInfo();
        derivative.displayInfo();
    }
}

