package filling;

import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static utilities.Validate.*;

/**
 * Класс для заполнения классов Bus, User, Student из файлов
 */
public class ByFromFile {
    /**
     * Метод заполнения массива Bus из файла input_Bus.txt
     * @return массив List Bus
     * @throws IOException io exception
     */
    public static List<Bus> fillBusFromFile() throws IOException {
        Path file = Paths.get(".\\MainTask\\input_Bus.txt");
        List<Bus> buses = new ArrayList<>();

        if (Files.exists(file)) {
            System.out.printf("Файл %s\\%s найден.\n", file.getParent(), file.getFileName());

            try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
                int lineCount = 1;
                String line;
                Bus bus;

                while ((line = bufferedReader.readLine()) != null) {
                    lineCount++;
                    bus = BusLineValidate(line);
                    if (bus != null) {
                        buses.add(bus);
                    } else {
                        System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                line, lineCount);
                    }
                }
            }
        }
        if (buses.isEmpty()) {
            System.out.println("\nФайл пустой или отсутствует, возврат в предыдущее меню.");
            return null;
        } else {
            return buses;
        }

    }

    /**
     * Метод заполнения массива User из файла input_User.txt
     * @return массив List User
     * @throws IOException io exception
     */
    public static List<User> fillUserFromFile() throws IOException {
        Path file = Paths.get(".\\MainTask\\input_User.txt");
        List<User> users = new ArrayList<>();

        if (Files.exists(file)) {
            System.out.printf("Файл %s\\%s найден.\n", file.getParent(), file.getFileName());

            try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
                int count = 1;
                int lineCount = 1;
                String line;
                User user;

                while ((line = bufferedReader.readLine()) != null) {
                    lineCount++;

                    user = UserLineValidate(line, count);
                    if (user != null) {
                        users.add(user);
                        count++;
                    } else {
                        System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                line, lineCount);
                    }
                }
            }
        }
        if (users.isEmpty()) {
            System.out.println("\nФайл пустой или отсутствует, возврат в предыдущее меню.");
            return null;
        } else {
            return users;
        }
    }

    /**
     * Метод заполнения массива Student из файла input_Student.txt
     * @return массив List Student
     * @throws IOException io exception
     */
    public static List<Student> fillStudentFromFile() throws IOException {
        Path file = Paths.get(".\\MainTask\\input_Student.txt");
        List<Student> students= new ArrayList<>();

        if (Files.exists(file)) {
            System.out.printf("Файл %s\\%s найден.\n", file.getParent(), file.getFileName());

            try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
                int lineCount = 1;
                String line;
                Student student;

                while ((line = bufferedReader.readLine()) != null) {
                    lineCount++;

                    student = StudentLineValidate(line);
                    if (student != null) {
                        students.add(student);
                    } else {
                        System.out.printf("Строка %s (под номером %s в файле) не корректна, она будет пропущена.\n",
                                line, lineCount);
                    }
                }
            }
        }
        if (students.isEmpty()) {
            System.out.println("\nФайл пустой или отсутствует, возврат в предыдущее меню.");
            return null;
        } else {
            return students;
        }
    }
}
