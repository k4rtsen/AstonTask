import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static ruslan.ClownUtilities.getRandomNumber;
import static ruslan.ClownUtilities.getRandomBusNumber;
import static ruslan.ClownUtilities.getRandomFromEnum;
import static ruslan.ClownUtilities.getRandomUserSecret;
import static ruslan.ClownUtilities.getRandomUserMail;
import static ruslan.ClownUtilities.getRandomAverageScore;
import static ruslan.ClownUtilities.getRandomStudentGroup;

public class MainUI {
    public static void main(String[] args) throws IOException {
        String str = "112dsvbsdgK";
        String symbolsSpec = "!@$%^&*";
        if(str.matches(".*[A-Z].*")
                & str.matches(".*[a-z].*")
                & str.matches(".*\\d.*")
                & str.matches(".*["+symbolsSpec+"].*")) {
            System.out.println("!!!!!!!!!!!!!!!");
        }

        System.out.println("Случайный номер автобуса: " + getRandomBusNumber());
        System.out.println("Случайный enum класса (автобус): " + getRandomFromEnum("BusModelEnum"));
        System.out.println("Случайный пробег: " + getRandomNumber(10, 999999));
        System.out.println();
        System.out.println("Случайный enum класса (Имя): " + getRandomFromEnum("UserNameEnum"));
        System.out.println("Случайный пароль пользователя: " + getRandomUserSecret(8));
        System.out.println("Случайная почта пользователя: " + getRandomUserMail(12));
        System.out.println();
        System.out.println("Случайный номер группы: " + getRandomStudentGroup());
        System.out.printf("Случайный средний балл: %.2f\n", getRandomAverageScore(1, 10));
        System.out.println("Случайный номер зачетной книжки: " + getRandomNumber(10000, 99999));

//        for (int j = 0; j < 10; j++) {
//            System.out.println(getRandomBusNumber()+";"
//                    +getRandomFromEnum("BusModelEnum")+";"
//                    +getRandomNumber(10, 999999)+";");
//        }
//        for (int j = 0; j < 10; j++) {
//            System.out.println(getRandomFromEnum("UserNameEnum")+";"
//                    +getRandomUserSecret(8)+";"
//                    +getRandomUserMail(12)+";");
//        }
//        for (int j = 0; j < 10; j++) {
//            System.out.printf(getRandomStudentGroup()+";%.2f;"
//                    +getRandomNumber(10000, 99999)+";\n",
//                    getRandomAverageScore(1, 10));
//        }




        String helloText = "Добро пожаловать в приложение демонстрации алгоритма \"Быстрой сортировки\"" +
                " (created by Clowns_team)\n";

        String baseMenu = "Выберите один из классов:" +
                "\n1) Bus (Number, Model, Mileage)" +
                "\n2) User (Name, Secret, Mail)" +
                "\n3) Student (Group Number, Average Score, Grade Book Number)" +
                "\n0) Выход из приложения";

        Scanner scanner = new Scanner(System.in);
        String inputMenu = "";

        System.out.println(helloText);
        do {
            System.out.println(baseMenu);
            System.out.print("\nВведите команду: ");
            inputMenu = scanner.nextLine();

            switch (inputMenu) {
                case "1":
                    System.out.println("Вы выбрали класс Bus (Number, Model, Mileage)\n");
                    classMenu("Bus");
                    break;
                case "2":
                    System.out.println("Вы выбрали класс User (Name, Secret, Mail)\n");
                    classMenu("User");
                    break;
                case "3":
                    System.out.println("Вы выбрали класс Student (Group Number, Average Score, Grade Book Number)\n");
                    classMenu("Student");
                    break;
                case "0":
                    System.out.println("\nВыход из программы.");
                    break;
                default:
                    System.out.println("Команда не распознана, повторите ввод (0 - для выхода).\n");
            }
        }
        while (!inputMenu.equals("0"));
    }

    static void classMenu(String className) throws IOException {
        Scanner classScan = new Scanner(System.in);
        String inputClass = "";
        do {
            System.out.println("Выберите способ заполнения массива " + className + ":" +
                    "\n1) Из файла" +
                    "\n2) Рандом" +
                    "\n3) Вручную" +
                    "\n0) Вернуться в главное меню");
            System.out.print("\nВведите команду: ");
            inputClass = classScan.nextLine();

            switch (inputClass) {
                case "1":
                    System.out.println("Вы выбрали 1 - \"Из файла\"\n");
                    fromFile(className);
                    break;
                case "2":
                    System.out.println("Вы выбрали 2 - \"Рандом\"\n");
                    initRandom(className);
                    break;
                case "3":
                    System.out.println("Вы выбрали 3 - \"Вручную\"\n");
                    break;
                case "0":
                    System.out.println("\nВозврат в предыдущее меню.");
                    break;
                default:
                    System.out.println("Команда не распознана, повторите ввод (0 - возврат в предыдещее меню).\n");
            }
        } while (!inputClass.equals("0"));
    }

    static void initRandom(String className) {
        Scanner lengthScan = new Scanner(System.in);
        String inputLength = "";
        do {
            System.out.println("Введите размер массива " + className + " (0 - возврат назад):");
            inputLength = lengthScan.nextLine();

            if (inputLength.matches("-?\\d+")){
                if ((inputLength.length() > 4) || (Integer.parseInt(inputLength) > 100)) {
                    System.out.println("Слишком большой массив, введите размер до 100 элементов");
                } else {
                    System.out.println("Корректное число");
                    break;
                }
            } else {
                System.out.println("НЕ корректное число");
            }

        } while (!inputLength.equals("0"));

        System.out.println("Погнали дальше");

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            System.out.println("Заполняем массив");
        }
    }


    static void fromFile(String className) throws IOException {

        File file = new File(".\\MainTask\\input_" +className+ ".txt");

//        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
//        System.out.println("file.getPath() " + file.getPath());
//        System.out.println("file.getCanonicalPath() " + file.getCanonicalPath());

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());
            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                String line;
                Map<Integer, Object> arrMap = new HashMap<>();

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    String[] tmpArr = line.split(";");

                    for (int i = 0; i < tmpArr.length; i++) {
                        arrMap.put(i, tmpArr[i]);
                    }
                    System.out.println("5555 " + Arrays.toString(tmpArr));
                }
                //System.out.println("6666 " + arrMap);
            }
            catch (IOException  e) {
                e.printStackTrace();
            }

        } else System.out.printf("Файл %s не найден.\n", file.getCanonicalFile());

    }
}
