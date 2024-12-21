import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainSort {
public static void main(String[] args) {
    List<Bus> buses = Arrays.asList(
            new Bus("Model A", 10000),
            new Bus("Model B", 5000),
            new Bus("Model C", 15000)
    );

    List<User> users = Arrays.asList(
            new User("Ivan"),
            new User("Anna"),
            new User("Petr")
    );

    List<Student> students = Arrays.asList(
            new Student("Maria", 4.8),
            new Student("Sergey", 3.7),
            new Student("Elena", 4.2)
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