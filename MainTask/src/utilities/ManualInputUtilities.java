package utilities;

import actions.FillActions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для считывания int, string, double ручным способом
 */
public class ManualInputUtilities {
    private static final Scanner manualScan = new Scanner(System.in);

    public static int readInt(String inputLine) {
        int number;
        do {
            System.out.print(inputLine);
            try {
                number = manualScan.nextInt();
                if (number < 0) throw new InputMismatchException();
                else if (number == 0) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                manualScan.nextLine(); // чтобы очистить ввод
                System.out.println("НЕ корректное число, повторите ввод\n");
            }
        } while(true);
        return number;
    }

    public static String readString(String inputLine) {
        String line;
        do {
            System.out.print(inputLine);
            try {
                line = manualScan.nextLine();
                if (line.isEmpty()) throw new InputMismatchException();
                else if (line.equals("0")) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Введенная строка пустая, повторите ввод\n");
            }
        } while(true);
        return line;
    }

    public static double readDouble(String inputLine) {
        double number;
        do {
            System.out.print(inputLine);
            try {
                number = manualScan.nextDouble();
                if (number < 0) throw new InputMismatchException();
                else if (number == 0) System.out.println("\nВозврат в предыдущее меню");
                break;
            } catch (InputMismatchException ex) {
                manualScan.nextLine(); // чтобы очистить ввод
                System.out.println("НЕ корректное число, повторите ввод\n");
            }
        } while(true);
        return number;
    }

    public static <T> List<T> fillManual(String modelName, FillActions.ManualReader<T> reader) {
        int arraySize = readInt(String.format("Введите размер массива %s (0 - возврат назад): ", modelName));
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
