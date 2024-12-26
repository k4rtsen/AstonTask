package actions;

import algorithms.*;
import comparators.BusComparator;
import comparators.StudentComparator;
import comparators.UserComparator;
import models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static actions.ActionQuickSort.*;
import static actions.ActionQuickSortDefault.*;
import static actions.ActionBinarySearch.*;
import static utilities.FileUtilities.*;

public class ActionMenu {
    private static final String actionMenu = """
                
                Массив %s (содержит %d записей)
                Выберите действие:
                1) Вывести массив в консоль
                2) Отсортировать массив быстрой сортировкой (поле по умолчанию)
                3) Отсортировать массив быстрой сортировкой по определенному полю
                4) Отсортировать массив альтернативной быстрой сортировкой по определенному полю
                5) Найти элемент (бинарный поиск)
                0) Вернуться в предыдущее меню""";

    public static void actionMenuBus(List<Bus> buses) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;
        StringBuilder infoToFile;

        do {
            System.out.printf(actionMenu, "Bus", buses.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nЭлементы в массиве Bus:");
                    buses.forEach(System.out::println);
                    break;

                case "2":
                    QuickSortBusDefault(buses);
                    break;
                case "3":
                    QuickSortBus(buses, "base");
                    break;
                case "4":
                    QuickSortBus(buses, "additional");
                    break;
                case "5":
                    System.out.println(BinarySearchBus(buses));
                    break;
                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;
                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputAction.equals("0"));
    }

    public static void actionMenuUser(List<User> users) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;
        StringBuilder infoToFile;

        do {
            System.out.printf(actionMenu, "User", users.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nЭлементы в массиве User:");
                    users.forEach(System.out::println);
                    break;
                case "2":
                    QuickSortUserDefault(users);
                    break;
                case "3":
                    QuickSortUser(users, "base");
                    break;
                case "4":
                    QuickSortUser(users, "additional");
                    break;
                case "5":
                    System.out.println(BinarySearchUser(users));
                    break;
                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;
                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputAction.equals("0"));
    }

    public static void actionMenuStudent(List<Student> students) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String inputAction;
        StringBuilder infoToFile;

        do {
            System.out.printf(actionMenu, "Students", students.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    System.out.println("\nЭлементы в массиве Student:");
                    students.forEach(System.out::println);
                    break;
                case "2":
                    QuickSortStudentDefault(students);
                    break;
                case "3":
                    QuickSortStudent(students, "base");
                    break;
                case "4":
                    QuickSortStudent(students, "additional");
                    break;
                case "5":
                    System.out.println(BinarySearchStudent(students));
                    break;
                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;
                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputAction.equals("0"));
    }
}