import java.util.ArrayList;

public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();

        numbers.add((byte) 10);
        numbers.add(20.5);
        numbers.add((short) 30);
        numbers.add(40.7f);
        numbers.add(5048282L);
        numbers.add(60.3);
        numbers.add(70);
        numbers.add(80.1453f);
        numbers.add(90459356928L);
        numbers.add(100.93498678926);

        ArrayList<Byte> byteNumbers = new ArrayList<>();
        ArrayList<Short> shortNumbers = new ArrayList<>();
        ArrayList<Integer> integerNumbers = new ArrayList<>();
        ArrayList<Long> longNumbers = new ArrayList<>();
        ArrayList<Float> floatNumbers = new ArrayList<>();
        ArrayList<Double> doubleNumbers = new ArrayList<>();

        System.out.print("Список чисел: ");
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Числа в форматі цілих чисел: ");
        for (Number number : numbers) {
            System.out.print(number.longValue() + " ");
        }
        System.out.println();

        System.out.print("Числа в дробному форматі: ");
        for (Number number : numbers) {
            System.out.print(String.format("%.2f", number.doubleValue()) + " ");
        }
        System.out.println();

        for (Number number : numbers) {
            if (number instanceof Byte) {
                byteNumbers.add((Byte) number);
            } else if (number instanceof Short) {
                shortNumbers.add((Short) number);
            } else if (number instanceof Integer) {
                integerNumbers.add((Integer) number);
            } else if (number instanceof Long) {
                longNumbers.add((Long) number);
            } else if (number instanceof Float) {
                floatNumbers.add((Float) number);
            } else if (number instanceof Double) {
                doubleNumbers.add((Double) number);
            }
        }

        System.out.print("Byte числа: ");
        for (Byte number : byteNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Short числа: ");
        for (Short number : shortNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Integer числа: ");
        for (Integer number : integerNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Long числа: ");
        for (Long number : longNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Float числа: ");
        for (Float number : floatNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.print("Double числа: ");
        for (Double number : doubleNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Number maxNumber = numbers.get(0);
        for (Number number : numbers) {
            if (number.doubleValue() > maxNumber.doubleValue()) {
                maxNumber = number;
            }
        }
        System.out.print("Найбільше число: " + maxNumber + "\n");
    }
}
