package utilities;

import actions.FillActions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import static utilities.Validate.isPositiveDouble;
import static utilities.Validate.isPositiveInteger;

/**
 * Класс для считывания int, string, double ручным способом
 */
public class ManualInputUtilities {
    private static final Scanner manualScan = new Scanner(System.in);

    public static int readInt(String inputLine, Predicate<String> check) {
        String number;
        do {
            System.out.print(inputLine);
            try {
                number = manualScan.nextLine();
                if (!check.test(number))  throw new InputMismatchException();
                else if (number.equals("0")) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                manualScan.nextLine(); // чтобы очистить ввод
                System.out.println("НЕ корректное число, повторите ввод\n");
            }
        } while(true);
        return Integer.parseInt(number);
    }

    public static String readString(String inputLine, Predicate<String> check) {
        String line;
        do {
            System.out.print(inputLine);
            try {
                line = manualScan.nextLine();
                if (!check.test(line)) throw new InputMismatchException();
                else if (line.equals("0")) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Введенная строка пустая, повторите ввод\n");
            }
        } while(true);
        return line;
    }

    public static double readDouble(String inputLine, Predicate<String> check) {
        String number;
        do {
            System.out.print(inputLine);
            try {
                number = manualScan.nextLine();
                if (!check.test(number)) throw new InputMismatchException();
                else if (number.equals("0")) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                manualScan.nextLine(); // чтобы очистить ввод
                System.out.println("НЕ корректное число, повторите ввод\n");
            }
        } while(true);
        return Double.parseDouble(number);
    }

    public static <T> List<T> fillManual(String modelName, FillActions.ManualReader<T> reader) {
        int arraySize = readInt(String.format("Введите размер массива %s (0 - возврат назад): ", modelName),
                Validate::isPositiveInteger);
        if (arraySize == 0) return null;

        List<T> models = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            T model = reader.readModel(i);
            if (model == null) return null;
            System.out.println("Создан: " + model);
            models.add(model);
        }

        return models;
    }
}
