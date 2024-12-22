import models.Bus;
import models.Student;
import models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithms.QuickSort.*;

public class MainSortTestRandom {
    public static void main(String[] args) throws IOException {
        List<Bus> buses = readBusesFromFile("input_Bus.txt");
        List<User> users = readUsersFromFile("input_User.txt");
        List<Student> students = readStudentsFromFile("input_Student.txt");

        System.out.println("Автобусы до сортировки:");
        buses.forEach(System.out::println);
        quickSortBus(buses);
        System.out.println("\nАвтобусы после сортировки:");
        buses.forEach(System.out::println);

        System.out.println("\nПользователи до сортировки:");
        users.forEach(System.out::println);
        quickSortUser(users);
        System.out.println("\nПользователи после сортировки:");
        users.forEach(System.out::println);

        System.out.println("\nСтуденты до сортировки:");
        students.forEach(System.out::println);
        quickSortStudent(students);
        System.out.println("\nСтуденты после сортировки:");
        students.forEach(System.out::println);
    }

    private static List<Bus> readBusesFromFile(String filePath) throws IOException {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Bus bus = new Bus.BusBuilder()
                            .setModel(parts[0])
                            .setNumber(parts[1])
                            .setMileage(Integer.parseInt(parts[2]))
                            .build();
                    buses.add(bus);
                }
            }
        }
        return buses;
    }

    private static List<User> readUsersFromFile(String filePath) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    User user = new User.UserBuilder()
                            .setEmail(parts[0])
                            .setName(parts[1])
                            .setPassword(parts[2])
                            .build();
                    users.add(user);
                }
            }
        }
        return users;
    }

    private static List<Student> readStudentsFromFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Student student = new Student.StudentBuilder()
                            .setGroup(parts[0])
                            .setGradeBookNum((int) Long.parseLong(parts[1]))
                            .setScore(Double.parseDouble(parts[2]))
                            .build();
                    students.add(student);
                }
            }
        }
        return students;
    }
}
