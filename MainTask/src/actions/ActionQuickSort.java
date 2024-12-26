package actions;

import algorithms.*;
import comparators.*;
import models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static utilities.FileUtilities.fileWriting;

public class ActionQuickSort {

    public static void QuickSortBus(List<Bus> buses, String sortType) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String sortField = """
                
                Выберите поля для сортировки:
                1) По номеру (by number)
                2) По модели (by model)
                3) По пробегу (by mileage)
                0) Вернуться в предыдущее меню""";
        String inputAction;
        StringBuilder infoToFile;
        boolean wasSorted = false;

        do {
            System.out.printf(sortField, "Bus", buses.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    Bus.setComp(new BusComparator.ByNumber());
//                    if (sortType.equals("additional")) {
//                    AdditionalSort.sort(buses);
//                    } else {
//                        QuickSort.sort(buses);
//                    }
                    QuickSort.sort(buses);
                    System.out.println("\nМассив отсортирован по номеру (by number).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "2":
                    Bus.setComp(new BusComparator.ByModel());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(buses);
//                    } else {
//                        QuickSort.sort(buses);
//                    }
                    QuickSort.sort(buses);
                    System.out.println("\nМассив отсортирован по модели (by model).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "3":
                    Bus.setComp(new BusComparator.ByMileage());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(buses);
//                    } else {
//                        QuickSort.sort(buses);
//                    }
                    QuickSort.sort(buses);
                    System.out.println("\nМассив отсортирован по пробегу (by mileage).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));

        if (wasSorted) {
            infoToFile = new StringBuilder();
            for (Bus it : buses) {
                infoToFile.append(it).append("\n");
            }
            fileWriting(infoToFile.toString());
        }
    }


    public static void QuickSortUser(List<User> users, String sortType) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String sortField = """
                
                Выберите поля для сортировки:
                1) По id (by id)
                2) По имени (by name)
                3) По паролю (by password)
                4) По электронной почте (by email)
                0) Вернуться в предыдущее меню""";
        String inputAction;
        StringBuilder infoToFile;
        boolean wasSorted = false;

        do {
            System.out.printf(sortField, "User", users.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    User.setComp(new UserComparator.ById());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(users);
//                    } else {
//                        QuickSort.sort(users);
//                    }
                    QuickSort.sort(users);
                    System.out.println("\nМассив отсортирован по id (by id).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "2":
                    User.setComp(new UserComparator.ByName());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(users);
//                    } else {
//                        QuickSort.sort(users);
//                    }
                    QuickSort.sort(users);
                    System.out.println("\nМассив отсортирован по имени (by name).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "3":
                    User.setComp(new UserComparator.ByPassword());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(users);
//                    } else {
//                        QuickSort.sort(users);
//                    }
                    QuickSort.sort(users);
                    System.out.println("\nМассив отсортирован по паролю (by password).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "4":
                    User.setComp(new UserComparator.ByEmail());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(users);
//                    } else {
//                        QuickSort.sort(users);
//                    }
                    QuickSort.sort(users);
                    System.out.println("\nМассив отсортирован по электронной почте (by email).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));

        if (wasSorted) {
            infoToFile = new StringBuilder();
            for (User it : users) {
                infoToFile.append(it).append("\n");
            }
            fileWriting(infoToFile.toString());
        }
    }


    public static void QuickSortStudent(List<Student> students, String sortType) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String sortField ="""
                
                Выберите поле для сортировки:
                1) По группе (by group)
                2) По среднему баллу (by average score)
                3) По зачетной книжке (by grade book)
                0) Вернуться в предыдущее меню""";
        String inputAction;
        StringBuilder infoToFile;
        boolean wasSorted = false;

        do {
            System.out.printf(sortField, "Student", students.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            switch (inputAction) {
                case "1":
                    Student.setComp(new StudentComparator.ByGroup());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(students);
//                    } else {
//                        QuickSort.sort(students);
//                    }
                    QuickSort.sort(students);
                    System.out.println("\nМассив отсортирован по группе (by group).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "2":
                    Student.setComp(new StudentComparator.ByScore());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(students);
//                    } else {
//                        QuickSort.sort(students);
//                    }
                    QuickSort.sort(students);
                    System.out.println("\nМассив отсортирован по среднему баллу (by average score).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "3":
                    Student.setComp(new StudentComparator.ByGradeBook());
//                    if (sortType.equals("additional")) {
//                        AdditionalSort.sort(students);
//                    } else {
//                        QuickSort.sort(students);
//                    }
                    QuickSort.sort(students);
                    System.out.println("\nМассив отсортирован по зачетной книжке (by grade book).");
                    inputAction = "0";
                    wasSorted = true;
                    break;

                case "0":
                    System.out.print("\nВозврат в предыдущее меню.\n");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }

        } while (!inputAction.equals("0"));

        if (wasSorted) {
            infoToFile = new StringBuilder();
            for (Student it : students) {
                infoToFile.append(it).append("\n");
            }
            fileWriting(infoToFile.toString());
        }
    }
}
