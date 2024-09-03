import java.util.ArrayList;

public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20.5);
        numbers.add(30);
        numbers.add(40.7);
        numbers.add(50);
        numbers.add(60.3);
        numbers.add(70);
        numbers.add(80.1);
        numbers.add(90);
        numbers.add(100.9);

        System.out.print("Список чисел: ");
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Числа в форматі цілих чисел: ");
        for (Number number : numbers) {
            System.out.print(number.intValue() + " ");
        }
        System.out.println();

        System.out.print("Числа в дробному форматі: ");
        for (Number number : numbers) {
            System.out.print(String.format("%.2f", number.doubleValue()) + " ");
        }
        System.out.println();

        ArrayList<Integer> integerNumbers = new ArrayList<>();
        ArrayList<Double> doubleNumbers = new ArrayList<>();

        for (Number number : numbers) {
            if (number instanceof Integer) {
                integerNumbers.add((Integer) number);
            } else if (number instanceof Double) {
                doubleNumbers.add((Double) number);
            }
        }

        System.out.print("Цілі числа: ");
        for (Integer number : integerNumbers) {
            System.out.print(number + " ");
        }
        System.out.print("\n");

        System.out.print("Дробні числа: ");
        for (Double number : doubleNumbers) {
            System.out.print(number + " ");
        }
        System.out.print("\n");

        Number maxNumber = numbers.get(0);
        for (Number number : numbers) {
            if (number.doubleValue() > maxNumber.doubleValue()) {
                maxNumber = number;
            }
        }
        System.out.print("Найбільше число: " + maxNumber + "\n");
    }
}
