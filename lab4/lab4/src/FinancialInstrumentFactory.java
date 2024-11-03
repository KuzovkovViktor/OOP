import java.util.HashMap;
import java.util.Map;

public class FinancialInstrumentFactory {
    private Map<String, FinancialInstrument> prototypes = new HashMap<>();

    // Реєстрація прототипу
    public void registerPrototype(String key, FinancialInstrument prototype) {
        prototypes.put(key, prototype);
    }

    // Створення нового інструменту на основі прототипу
    public FinancialInstrument createInstrument(String key) {
        FinancialInstrument prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("No prototype found for key: " + key);
    }
}
