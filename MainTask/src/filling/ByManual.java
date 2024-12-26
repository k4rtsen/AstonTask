package filling;

import actions.Actions;
import models.Bus;
import models.Student;
import models.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static utilities.Validate.*;

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
                System.out.printf("""
                        
                        Bus[%d] - Введите номер автобуса
                        целое положительное число от 2 до 5 знаков
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (BusNumberValidate(manualInput)) {
                    number = Integer.parseInt(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }


            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        Bus[%d] - Введите модель автобуса
                        строка из латинских букв от 3 до 10 символов
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (BusModelValidate(manualInput)) {
                    model = manualInput;
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        Bus[%d] - Введите пробег автобуса
                        целое положительное число от 2 до 8 знаков
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (BusMileageValidate(manualInput)) {
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
                System.out.printf("""
                        
                        User[%d] - Введите имя пользователя
                        строка состоящая из латинских букв от 2 до 10 символов
                        (0 - отмена): \s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (UserNameValidate(manualInput)) {
                    name = manualInput;
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз.");
                }
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        User[%d] - Введите пароль пользователя
                        длина 8 символов, обязательное наличие
                        заглавной, прописной латинских букв, цифры, спец.символа !@$^&*
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (UserPasswordValidate(manualInput)) {
                    password = manualInput;
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз.");
                }
            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        User[%d] - Введите e-mail пользователя
                        <имя_почты>@<домен_почты>.<верхний_домен> где:
                        имя_почты - прописные латинские буквы и цифры от 2 до 20 символов
                        домен_почты - прописные латинские буквы и цифры от 2 до 10 символов
                        верхний_домен - латинские прописные буквы от 2 до 4 символов
                        пример - example@maildomain.com
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (UserEMailValidate(manualInput)) {
                    email = manualInput;
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз.");
                }

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
                System.out.printf("""
                        
                        Student[%d] - Введите группу студента
                        вида X-NNN, где
                        X - любая заглавная латинская буква
                        NNN - 3х значное число (001 допускается)
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (StudentGroupValidate(manualInput)) {
                    group = manualInput;
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз.");
                }

            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        Student[%d] - Введите средний балл студента
                        положительное число, целое или дробное (максимальный балл 10.0)
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (StudentAverageScoreValidate(manualInput)) {
                    averageScore = Double.parseDouble(manualInput);
                    manualInput = "true";
                } else {
                    System.out.println("Не корректные данные, попробуйте еще раз");
                }

            } while (!manualInput.equals("true"));

            do {
                System.out.printf("""
                        
                        Student[%d] - Введите номер зачетной книжки
                        студента любое положительное число от 3 до 6 символов
                        (0 - отмена):\s""", i);
                manualInput = manualScan.nextLine();
                if (manualInput.equals("0")) {
                    System.out.println("\nВозврат в предыдущее меню");
                    return null;
                }

                if (StudentGradeBookValidate(manualInput)) {
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
