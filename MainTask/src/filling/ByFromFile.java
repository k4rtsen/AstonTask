package filling;

import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс для заполнения классов Bus, User, Student из файлов
 */
public class ByFromFile {
    /**
     * Метод заполнения массива Bus из файла input_Bus.txt
     * @return массив List Bus
     * @throws IOException
     */
    public static List<Bus> fillBusFromFile() throws IOException {
        File file = new File(".\\MainTask\\input_Bus.txt");
        List<Bus> buses = new ArrayList<>();

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());

            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                int lineCount = 1;
                String line;
                Bus.BusBuilder busBuilder = new Bus.BusBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] tmpArr = line.split(";");
                    lineCount++;

                    if (tmpArr.length == 3) {
                        buses.add(busBuilder
                                .setNumber(Integer.parseInt(tmpArr[0]))
                                .setModel(tmpArr[1])
                                .setMileage(Integer.parseInt(tmpArr[2]))
                                .build());
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
     * @throws IOException
     */
    public static List<User> fillUserFromFile() throws IOException {
        File file = new File(".\\MainTask\\input_User.txt");
        List<User> users = new ArrayList<>();

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());

            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                int count = 1;
                int lineCount = 1;
                String line;
                User.UserBuilder userBuilder = new User.UserBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] tmpArr = line.split(";");
                    lineCount++;

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
     * @throws IOException
     */
    public static List<Student> fillStudentFromFile() throws IOException {
        File file = new File(".\\MainTask\\input_Student.txt");
        List<Student> students= new ArrayList<>();

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());

            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
                int lineCount = 1;
                String line;
                Student.StudentBuilder studentBuilder = new Student.StudentBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] tmpArr = line.split(";");
                    lineCount++;

                    if (tmpArr.length == 3) {
                        students.add(studentBuilder
                                .setGroup(tmpArr[0])
                                .setScore(Double.parseDouble(tmpArr[1]))
                                .setGradeBookNum(Integer.parseInt(tmpArr[2]))
                                .build());
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
