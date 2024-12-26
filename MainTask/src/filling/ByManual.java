package filling;

import models.Bus;
import models.Student;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для заполнения классов Bus, User, Student ручным способом
 */
public class ByManual {

    /**
     * Метод заполнения массива Bus ручным способом
     * @return массив List Bus
     */
    public static List<Bus> fillBusByManual() {
        String manualInput = "";
        Scanner manualScan = new Scanner(System.in);

        int number = 0;
        String model = "";
        int mileage = 0;
        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
        List<Bus> buses = new ArrayList<>();

        String inputLength;
        do {
            System.out.print("Введите размер массива Bus (0 - возврат назад): ");
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

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            do {
                System.out.printf("Bus[%d] - Введите номер автобуса (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (manualInput.matches("-?\\d+")) {
                    number = Integer.parseInt(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("Bus[%d] - Введите модель автобуса (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                model = manualInput;
                manualInput = "true";
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("Bus[%d] - Введите пробег автобуса (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (manualInput.matches("-?\\d+")) {
                    mileage = Integer.parseInt(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }
            } while (!manualInput.equals("true"));

            buses.add(busBuilder
                    .setNumber(number)
                    .setModel(model)
                    .setMileage(mileage)
                    .build());
            System.out.println("Создан: " + buses.get(i));
        }

        if (manualInput.equals("true")) {
            return buses;
        } else {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }
    }

    /**
     * Метод заполнения массива User ручным способом
     * @return массив List User
     */
    public static List<User> fillUserByManual() {
        String manualInput = "";
        Scanner manualScan = new Scanner(System.in);

        String name = "";
        String password = "";
        String email = "";
        User.UserBuilder userBuilder = new User.UserBuilder();
        List<User> users = new ArrayList<>();

        String inputLength;
        do {
            System.out.print("Введите размер массива User (0 - возврат назад): ");
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

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            do {
                System.out.printf("User[%d] - Введите имя пользователя (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                name = manualInput;
                manualInput = "true";
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("User[%d] - Введите пароль пользователя (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                password = manualInput;
                manualInput = "true";
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("User[%d] - Введите e-mail пользователя (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                email = manualInput;
                manualInput = "true";
            } while (!manualInput.equals("true"));

            users.add(userBuilder
                    .setId(i+1)
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
                    .build());
            System.out.println("Создан: " + users.get(i));
        }

        if (manualInput.equals("true")) {
            return users;
        } else {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }
    }

    /**
     * Метод заполнения массива Student ручным способом
     * @return массив List Student
     */
    public static List<Student> fillStudentByManual() {
        String manualInput = "";
        Scanner manualScan = new Scanner(System.in);

        String group = "";
        double averageScore = 0.0;
        int gradeBook = 0;
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        List<Student> students = new ArrayList<>();

        String inputLength;
        do {
            System.out.print("Введите размер массива Student (0 - возврат назад): ");
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

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            do {
                System.out.printf("Student[%d] - Введите группу студента (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                group = manualInput;
                manualInput = "true";
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("Student[%d] - Введите средний балл студента (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (manualInput.matches("-?\\d+")) {
                    averageScore = Double.parseDouble(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }


            } while (!manualInput.equals("true"));

            do {
                System.out.printf("Student[%d] - Введите номер зачетной книжки студента (0 - отмена): ", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (manualInput.matches("-?\\d+")) {
                    gradeBook = Integer.parseInt(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }
            } while (!manualInput.equals("true"));

            students.add(studentBuilder
                    .setGroup(group)
                    .setScore(averageScore)
                    .setGradeBookNum(gradeBook)
                    .build());
            System.out.println("Создан: " + students.get(i));
        }

        if (manualInput.equals("true")) {
            return students;
        } else {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }
    }
}
