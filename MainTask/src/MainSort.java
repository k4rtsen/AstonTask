import algorithms.*;
import comparators.BusComparator;
import models.*;
import java.util.*;

public class MainSort {
    public static void main(String[] args) {
        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
        Random rnd = new Random();
        final int RANGE = 10;//Integer.MAX_VALUE;
        List<Bus> buses = Arrays.asList(
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model A").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model B").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build(),
                busBuilder.setModel("Model C").setNumber(rnd.nextInt(RANGE)).setMileage(rnd.nextInt(RANGE)).build()
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
        QuickSort.sort(buses);
        System.out.println("\nАвтобусы после сортировки:");
        buses.forEach(System.out::println);

        System.out.println("Бин поиск автобуса Model C по модели");
        Bus lookingBus = busBuilder.setModel("Model C").setNumber(5).setMileage(3).build();
//        Bus.setComp(new BusComparator.ByNumber());
        int index = BinarySearch.search(buses, lookingBus);
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