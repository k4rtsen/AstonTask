import models.Bus;
import models.Student;
import models.User;

import java.util.Arrays;
import java.util.List;

import static algorithms.QuickSort.*;

public class MainSort {
public static void main(String[] args) {
    Bus.BusBuilder busBuilder = new Bus.BusBuilder();
    List<Bus> buses = Arrays.asList(
            busBuilder.setModel("Model A").setNumber("A100N").setMileage(10000).build(),
            busBuilder.setModel("Model B").setNumber("B100N").setMileage(5000).build(),
            busBuilder.setModel("Model C").setNumber("C100N").setMileage(15000).build()
    );

    User.UserBuilder userBuilder = new User.UserBuilder();
    List<User> users = Arrays.asList(
            userBuilder.setEmail("ivan@mail.ru").setName("Ivan").setPassword("ivanpsswd12345").build(),
            userBuilder.setEmail("anna@mail.ru").setName("Anna").setPassword("annapsswd12345").build(),
            userBuilder.setEmail("petr@mail.ru").setName("Petr").setPassword("petrpsswd12345").build()
    );

    Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
    List<Student> students = Arrays.asList(
            studentBuilder.setGroup("A12").setGradeBookNum(1234567890).setScore(4.8).build(),
            studentBuilder.setGroup("B12").setGradeBookNum(1874812740).setScore(3.7).build(),
            studentBuilder.setGroup("C12").setGradeBookNum(1209571039).setScore(4.2).build()
    );

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

}