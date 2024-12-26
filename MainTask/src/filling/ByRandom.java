package filling;

import models.Bus;
import models.Student;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilities.ClownUtilities.*;

/**
 * Класс для заполнения классов Bus, User, Student случайным образом (рандом)
 */
public class ByRandom {
    /**
     * Метод заполнения массива Bus случайным образом (рандом)
     * @return массив List Bus
     */
    public static List<Bus> fillBusByRandom() {
        Scanner manualScan = new Scanner(System.in);

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

        if (inputLength.equals("0")) {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            buses.add(busBuilder
                    .setNumber(getRandomNumber(10000, 99999))
                    .setModel(getRandomFromEnum("Bus"))
                    .setMileage(getRandomNumber(10, 999999))
                    .build());
        }
        return buses;
    }

    /**
     * Метод заполнения массива User случайным образом (рандом)
     * @return массив List User
     */
    public static List<User> fillUserByRandom() {
        Scanner manualScan = new Scanner(System.in);
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

        if (inputLength.equals("0")) {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            users.add(userBuilder
                    .setId(i+1)
                    .setName(getRandomFromEnum("User"))
                    .setPassword(getRandomUserPassword())
                    .setEmail(getRandomUserMail())
                    .build());
        }
        return users;
    }

    /**
     * Метод заполнения массива Student случайным образом (рандом)
     * @return массив List Student
     */
    public static List<Student> fillStudentByRandom() {
        Scanner manualScan = new Scanner(System.in);
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

        if (inputLength.equals("0")) {
            System.out.println("\nВозврат в предыдущее меню");
            return null;
        }

        for (int i = 0; i < Integer.parseInt(inputLength); i++) {
            students.add(studentBuilder
                    .setGroup(getRandomStudentGroup())
                    .setScore(getRandomAverageScore(1, 10))
                    .setGradeBookNum(getRandomNumber(10000, 99999))
                    .build());
        }
        return students;
    }
}

