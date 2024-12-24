import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import models.*;

import static algorithms.QuickSort.*;
import static ruslan.ClownUtilities.*;

public class MainUI {
    public static void main(String[] args) throws IOException {
        String helloText = "Добро пожаловать в приложение демонстрации алгоритма \"Быстрой сортировки\"" +
                " (created by Clowns_team)";

        String baseMenu = """
                
                Выберите один из классов:\
                
                1) Bus (Number, Model, Mileage)\
                
                2) User (Id,Name, Password, e-mail)\
                
                3) Student (Group Number, Average Score, Grade Book Number)\
                
                0) Выход из приложения""";

        Scanner scanner = new Scanner(System.in);
        String inputMenu = "";

        System.out.println(helloText);
        do {
            System.out.println(baseMenu);
            System.out.print("================\nВведите команду: ");
            inputMenu = scanner.nextLine();

            switch (inputMenu) {
                case "1":
                    System.out.println("\nВы выбрали класс Bus (Number, Model, Mileage)\n");
                    classMenu("Bus");
                    break;
                case "2":
                    System.out.println("\nВы выбрали класс User (Name, Secret, Mail)\n");
                    classMenu("User");
                    break;
                case "3":
                    System.out.println("\nВы выбрали класс Student (Group Number, Average Score, Grade Book Number)\n");
                    classMenu("Student");
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




    static void classMenu(String className) throws IOException {
        Scanner classScan = new Scanner(System.in);
        String inputClass = "";
        do {
            System.out.println("\nВыберите способ заполнения массива " + className + ": " +
                    "\n1) Из файла" +
                    "\n2) Рандом" +
                    "\n3) Вручную" +
                    "\n0) Вернуться в главное меню");
            System.out.print("================\nВведите команду: ");
            inputClass = classScan.nextLine();

            switch (inputClass) {
                case "1":
                    System.out.println("\nВы выбрали 1 - \"Из файла\"\n");
                    fillByFile(className);
                    break;

                case "2":
                    System.out.println("\nВы выбрали 2 - \"Рандом\"\n");
                    fillByRandom(className);
                    break;

                case "3":
                    System.out.println("\nВы выбрали 3 - \"Вручную\"\n");
                    fillByManual(className);
                    break;

                case "0":
                    System.out.println("\nВозврат в предыдущее меню.");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputClass.equals("0"));
    }




    static void fillByRandom(String className) throws IOException {
        Scanner lengthScan = new Scanner(System.in);
        String inputLength;
        do {
            System.out.print("Введите размер массива " + className + " (0 - возврат назад): ");
            inputLength = lengthScan.nextLine();

            if (inputLength.matches("-?\\d+")){
                if ((inputLength.length() > 4) || (Integer.parseInt(inputLength) > 100)) {
                    System.out.println("Слишком большой массив, введите размер до 100 элементов\n");
                } else {
                    break;
                }
            } else {
                System.out.println("НЕ корректное число, повторите ввод\n");
            }

        } while (!inputLength.equals("0"));

        switch (className) {
            case "Bus":
                actionMenuBus(initRandomBus(Integer.parseInt(inputLength)));
                break;

            case "User":
                actionMenuUser(initRandomUser(Integer.parseInt(inputLength)));
                break;

            case "Student":
                actionMenuStudent(initRandomStudent(Integer.parseInt(inputLength)));
                break;
        }
    }



    static List<Bus> initRandomBus(int len) {

        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
        List<Bus> buses = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            buses.add(busBuilder
                    .setNumber(getRandomNumber(10000, 99999))
                    .setModel(getRandomFromEnum("Bus"))
                    .setMileage(getRandomNumber(10, 999999))
                    .build());
        }
        return buses;
    }




    static List<User> initRandomUser(int len) {

        User.UserBuilder userBuilder = new User.UserBuilder();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            users.add(userBuilder
                    .setId(i+1)
                    .setName(getRandomFromEnum("User"))
                    .setPassword(getRandomUserSecret(8))
                    .setEmail(getRandomUserMail(12))
                    .build());
        }
        return users;
    }




    static List<Student> initRandomStudent(int len) {

        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            students.add(studentBuilder
                    .setGroup(getRandomStudentGroup())
                    .setScore(getRandomAverageScore(1, 10))
                    .setGradeBookNum(getRandomNumber(10000, 99999))
                    .build());
        }
        return students;
    }



    static void fillByFile(String className) throws IOException {

        File file = new File(".\\MainTask\\input_" +className+ ".txt");
        int count = 1;
        int lineCount = 1;

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());

            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                String line;

                switch (className) {
                    case "Bus":
                        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
                        List<Bus> buses = new ArrayList<>();

                        while ((line = bufferedReader.readLine()) != null) {
                            String[] tmpArr = line.split(";");
                            lineCount++;

                            if (tmpArr.length == 3) {
                                buses.add(busBuilder
                                        .setNumber(Integer.parseInt(tmpArr[0]))
                                        .setModel(tmpArr[1])
                                        .setMileage(Integer.parseInt(tmpArr[2]))
                                        .build());
                                count++;
                            } else {
                                System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                        line, lineCount);
                            }
                        }
                        actionMenuBus(buses);
                        break;

                    case "User":
                        User.UserBuilder userBuilder = new User.UserBuilder();
                        List<User> users = new ArrayList<>();
                        lineCount++;

                        while ((line = bufferedReader.readLine()) != null) {
                            String[] tmpArr = line.split(";");

                            if (tmpArr.length == 3) {
                                users.add(userBuilder
                                        .setId(count)
                                        .setName(tmpArr[0])
                                        .setPassword(tmpArr[1])
                                        .setEmail(tmpArr[2])
                                        .build());
                                count++;
                            } else {
                                System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                        line, lineCount);
                            }
                        }
                        actionMenuUser(users);
                        break;

                    case "Student":
                        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
                        List<Student> students = new ArrayList<>();

                        while ((line = bufferedReader.readLine()) != null) {
                            String[] tmpArr = line.split(";");
                            lineCount++;

                            if (tmpArr.length == 3) {
                                students.add(studentBuilder
                                        .setGroup(tmpArr[0])
                                        .setScore(Double.parseDouble(tmpArr[1]))
                                        .setGradeBookNum(Integer.parseInt(tmpArr[2]))
                                        .build());
                                count++;
                            } else {
                                System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                        line, lineCount);
                            }

                        }
                        actionMenuStudent(students);
                        break;
                }

            }
            catch (IOException  e) {
                e.printStackTrace();
            }

        } else System.out.printf("Файл %s не найден.\n", file.getCanonicalFile());
    }




    static void actionMenuBus(List<Bus> buses) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;

        String actionMenu = """
                
                Массив %s (содержит %d записей)\
                
                Выберите действие:\
                
                1) Вывести массив в консоль\
                
                2) Отсортировать массив быстрой сортировкой\
                
                3) Отсортировать массив по определенному полю\
                
                4) Найти элемент (бинарный поиск)\
                
                0) Вернуться в предыдущее меню""";

        do {
            System.out.printf(actionMenu, "Bus", buses.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nАвтобусы в массиве сортировки:");
                    buses.forEach(System.out::println);
                    break;

                case "2":
                    quickSortBus(buses);
                    for (Bus it : buses) {
                        fileWriting(it.toString());
                    }
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    break;
                case "4":
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));
    }




    static void actionMenuUser(List<User> users) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;

        String actionMenu = """
                
                Массив %s (содержит %d записей)\
                
                Выберите действие:\
                
                1) Вывести массив в консоль\
                
                2) Отсортировать массив быстрой сортировкой\
                
                3) Отсортировать массив по определенному полю\
                
                4) Найти элемент (бинарный поиск)\
                
                0) Вернуться в предыдущее меню""";

        do {
            System.out.printf(actionMenu, "User", users.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nПользователи в массиве сортировки:");
                    users.forEach(System.out::println);
                    break;

                case "2":
                    quickSortUser(users);
                    for (User it : users) {
                        fileWriting(it.toString());
                    }
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    break;
                case "4":
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));
    }




    static void actionMenuStudent(List<Student> students) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;

        String actionMenu = """
                
                Массив %s (содержит %d записей)\
                
                Выберите действие:\
                
                1) Вывести массив в консоль\
                
                2) Отсортировать массив быстрой сортировкой\
                
                3) Отсортировать массив по определенному полю\
                
                4) Найти элемент (бинарный поиск)\
                
                0) Вернуться в предыдущее меню""";

        do {
            System.out.printf(actionMenu, "Students", students.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nСтуденты в массиве сортировки:");
                    students.forEach(System.out::println);
                    break;

                case "2":
                    quickSortStudent(students);
                    for (Student it : students) {
                        fileWriting(it.toString());
                    }
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    break;
                case "4":
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));
    }




    static void fillByManual(String className) throws IOException {
        Scanner manualScan = new Scanner(System.in);
        String inputLength;
        String manualInput = "";
        do {
            System.out.print("Введите размер массива " + className + " (0 - возврат назад): ");
            inputLength = manualScan.nextLine();

            if (inputLength.matches("-?\\d+")){
                if ((inputLength.length() > 4) || (Integer.parseInt(inputLength) > 20)) {
                    System.out.println("Слишком большой массив, введите размер до 20 элементов\n");
                } else {
                    break;
                }
            } else {
                System.out.println("НЕ корректное число, повторите ввод\n");
            }

        } while (!inputLength.equals("0"));

        manualScan = new Scanner(System.in);
        switch (className) {
            case "Bus":
                Integer number = 0;
                String model = "";
                Integer mileage = 0;
                Bus.BusBuilder busBuilder = new Bus.BusBuilder();
                List<Bus> buses = new ArrayList<>();

                for (int i = 0; i < Integer.parseInt(inputLength); i++) {
                    do {
                        System.out.printf("Bus[%d] - Введите номер автобуса (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        if (manualInput.matches("-?\\d+")) {
                            number = Integer.parseInt(manualInput);
                            manualInput = "true";
                        } else {
                            System.out.println("Не корректные данные, попробуйте еще раз");
                        }
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("Bus[%d] - Введите модель автобуса (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }
                        
                        model = manualInput;
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("Bus[%d] - Введите пробег автобуса (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        if (manualInput.matches("-?\\d+")) {
                            number = Integer.parseInt(manualInput);
                            manualInput = "true";
                        } else {
                            System.out.println("Не корректные данные, попробуйте еще раз");
                        }
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    buses.add(busBuilder
                                .setNumber(number)
                                .setModel(model)
                                .setMileage(mileage)
                                .build());
                    System.out.println("Создан: " + buses.get(i));
                }

                if (manualInput.equals("true")) {
                    actionMenuBus(buses);
                    break;
                }
                break;

            case "User":
                String name = "";
                String password = "";
                String email = "";
                User.UserBuilder userBuilder = new User.UserBuilder();
                List<User> users = new ArrayList<>();

                for (int i = 0; i < Integer.parseInt(inputLength); i++) {
                    do {
                        System.out.printf("User[%d] - Введите имя пользователя (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        name = manualInput;
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("User[%d] - Введите пароль пользователя (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        password = manualInput;
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("User[%d] - Введите e-mail пользователя (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        email = manualInput;
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    users.add(userBuilder
                            .setId(i+1)
                            .setName(name)
                            .setPassword(password)
                            .setEmail(email)
                            .build());
                    System.out.println("Создан: " + users.get(i));
                }

                if (manualInput.equals("true")) {
                    actionMenuUser(users);
                    break;
                }
                break;

            case "Student":
                String group = "";
                Double averageScore = 0.0;
                Integer gradeBook = 0;
                Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
                List<Student> students = new ArrayList<>();

                for (int i = 0; i < Integer.parseInt(inputLength); i++) {
                    do {
                        System.out.printf("Student[%d] - Введите группу студента (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        group = manualInput;
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("Student[%d] - Введите средний балл студента (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        averageScore = Double.parseDouble(manualInput);
                        manualInput = "true";
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    do {
                        System.out.printf("Student[%d] - Введите номер зачетной книжки студента (0 - отмена): ", i);
                        manualInput = manualScan.nextLine();
                        if (manualInput.equals("0")) {
                            break;
                        }

                        if (manualInput.matches("-?\\d+")) {
                            gradeBook = Integer.parseInt(manualInput);
                            manualInput = "true";
                        } else {
                            System.out.println("Не корректные данные, попробуйте еще раз");
                        }
                    } while (!manualInput.equals("true"));
                    if (manualInput.equals("0")) {
                        break;
                    }

                    students.add(studentBuilder
                            .setGroup(group)
                            .setScore(averageScore)
                            .setGradeBookNum(gradeBook)
                            .build());
                    System.out.println("Создан: " + students.get(i));
                }

                if (manualInput.equals("true")) {
                    actionMenuStudent(students);
                    break;
                }
                break;
        }
    }



    static void fileWriting(String info) throws IOException {
        String filePath = ".\\MainTask\\output.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());
        } else {
            System.out.printf("Файл %s НЕ найден, создан новый.\n", file.getCanonicalFile());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(info + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
