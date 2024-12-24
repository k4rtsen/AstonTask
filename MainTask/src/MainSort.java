import algorithms.*;
import comparators.*;
import models.*;
import java.util.*;

public class MainSort {
    public static void main(String[] args) {
        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
        Random rnd = new Random();
        List<Bus> buses = Arrays.asList(
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(Integer.MAX_VALUE)).setMileage(rnd.nextInt(Integer.MAX_VALUE)).build()
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
        QuickSort.<Bus>sort(buses, new BusComparator.ByMileage());
        System.out.println("\nАвтобусы после сортировки:");
        buses.forEach(System.out::println);

        System.out.println("Бин поиск автобуса Model C по модели");
        Bus c = busBuilder.setModel("Model C").setNumber(3).setMileage(1).build();
        BinarySearch<Bus> busSearch = new BinarySearch<>();
        int index = busSearch.search(buses, c, new BusComparator.ByModel());
        String busResult = index == -1 ? "Такого автобуса нет в массиве" : "Автобус найден: " + buses.get(index);
        System.out.println(busResult);
//
//        System.out.println("\nПользователи до сортировки:");
//        users.forEach(System.out::println);
//        QuickSort.<User>sort(users, new UserComparator.ByName());
//        System.out.println("\nПользователи после сортировки:");
//        users.forEach(System.out::println);
//
//        System.out.println("\nСтуденты до сортировки:");
//        students.forEach(System.out::println);
//        QuickSort.<Student>sort(students, new StudentComparator.ByGradeBook());
//        System.out.println("\nСтуденты после сортировки:");
//        students.forEach(System.out::println);
    }

}