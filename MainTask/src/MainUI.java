import java.util.*;

import actions.Actions;
import actions.BusActions;
import actions.StudentActions;
import actions.UserActions;

public class MainUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String helloText = "Добро пожаловать в приложение демонстрации алгоритма \"Быстрой сортировки\"" +
                " (created by Clowns_team)";

        String baseMenu = """
                
                Выберите один из классов:
                1) Bus (Number, Model, Mileage)
                2) User (Id,Name, Password, e-mail)
                3) Student (Group Number, Average Score, Grade Book Number)
                0) Выход из приложения""";

        String inputMenu;

        System.out.println(helloText);
        do {
            System.out.println(baseMenu);
            System.out.print("================\nВведите команду: ");
            inputMenu = scanner.nextLine();

            switch (inputMenu) {
                case "1":
                    System.out.println("\nВы выбрали класс Bus (Number, Model, Mileage)");
                    modelsMenu(new BusActions());
                    break;
                case "2":
                    System.out.println("\nВы выбрали класс User (Name, Password, Mail)");
                    modelsMenu(new UserActions());
                    break;
                case "3":
                    System.out.println("\nВы выбрали класс Student (Group Number, Average Score, Grade Book Number)");
                    modelsMenu(new StudentActions());
                    break;
                case "0":
                    System.out.println("\nВыход из программы.");
                    break;
                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - для выхода).\n");
            }
        }
        while (!inputMenu.equals("0"));
    }

    private static <T> void modelsMenu(Actions<T> actions) {
        String inputClass;
        List<T> models;
        do {
            System.out.println("\nВыберите способ заполнения массива " + actions.getModelName() + ": " +
                    "\n1) Из файла" +
                    "\n2) Рандом" +
                    "\n3) Вручную" +
                    "\n0) Вернуться в главное меню");
            System.out.print("================\nВведите команду: ");
            inputClass = scanner.nextLine();

            switch (inputClass) {
                case "1":
                    System.out.println("\nВы выбрали 1 - \"Из файла\"\n");
                    models = actions.fillByFile();

                    //TODO remove inside next menu
                    if (models == null) {
                        // go to next menu
                    }
                    break;
                case "2":
                    System.out.println("\nВы выбрали 2 - \"Рандом\"\n");
                    models = actions.fillRandom();
                    break;
                case "3":
                    System.out.println("\nВы выбрали 3 - \"Вручную\"\n");
                    models = actions.fillManual();
                    break;
                case "0":
                    System.out.println("\nВозврат в предыдущее меню.");
                    break;
                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputClass.equals("0"));
    }
}
