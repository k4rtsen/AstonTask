package actions;

import algorithms.QuickSort;
import com.sun.source.tree.UsesTree;
import comparators.BusComparator;
import comparators.StudentComparator;
import comparators.UserComparator;
import models.Bus;
import models.Student;
import models.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static utilities.FileUtilities.*;

public class ActionMenu {
    static final String actionMenu = """
                
                Массив %s (содержит %d записей)\
                
                Выберите действие:\
                
                1) Вывести массив в консоль\
                
                2) Отсортировать массив быстрой сортировкой\
                
                3) Отсортировать массив по определенному полю\
                
                4) Найти элемент (бинарный поиск)\
                
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
                    QuickSort.sort(buses);
                    infoToFile = new StringBuilder();
                    for (Bus it : buses) {
                        infoToFile.append(it.toString());
                    }
                    fileWriting(infoToFile.toString());
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    System.out.print("\nОтсортировать массив по определенному полю.\n");
                    break;

                case "4":
                    System.out.print("\nНайти элемент (бинарный поиск).\n");
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
                    QuickSort.sort(users);
                    infoToFile = new StringBuilder();
                    for (User it : users) {
                        infoToFile.append(it.toString());
                    }
                    fileWriting(infoToFile.toString());
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    System.out.print("\nОтсортировать массив по определенному полю.\n");
                    break;

                case "4":
                    System.out.print("\nНайти элемент (бинарный поиск).\n");
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
                    QuickSort.sort(students);
                    infoToFile = new StringBuilder();
                    for (Student it : students) {
                        infoToFile.append(it.toString());
                    }
                    fileWriting(infoToFile.toString());
                    System.out.println("\nМассив отсортирован.");
                    break;

                case "3":
                    System.out.print("\nОтсортировать массив по определенному полю.\n");
                    break;

                case "4":
                    System.out.print("\nНайти элемент (бинарный поиск).\n");
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
