package actions;

import algorithms.*;
import comparators.*;
import models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static utilities.FileUtilities.fileWriting;

public class ActionBinarySearch {

    public static String BinarySearchBus(List<Bus> buses) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String searchField = """
                
                Выберите поле для поиска:\
                
                1) По номеру (by number)\
                
                2) По модели (by model)\
                
                3) По пробегу (by mileage)\
                
                0) Вернуться в предыдущее меню""";
        String inputAction;
        String busResult = "";
        boolean wasFind = false;

        do {
            System.out.printf(searchField, "Bus", buses.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            if (inputAction.equals("1") | inputAction.equals("2") | inputAction.equals("3")) {
                break;
            } else if (inputAction.equals("0")) {
                return "\nВозврат в предыдущее меню.";
            }
            else {
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (true);

        actionScan = new Scanner(System.in);
        System.out.println("\nВведите искомое значение (0 - возврат в предыдущее меню): ");

        String inputSearch;
        Bus.BusBuilder busBuilder = new Bus.BusBuilder();
        Bus lookingBus;
        int index;

        inputSearch = actionScan.nextLine();

        if (inputSearch.equals("0")) {
            busResult = "\nВозврат в предыдущее меню.\n";
        }

        switch (inputAction) {
            case "1":
                lookingBus = busBuilder.setModel("1").setNumber(Integer.parseInt(inputSearch)).setMileage(1).build();
                Bus.setComp(new BusComparator.ByNumber());
                index = BinarySearch.search(buses, lookingBus);
                if (index == -1) {
                    busResult = "Искомый автобус не найден в массиве.";
                } else {
                    busResult = "Автобус найден: " + buses.get(index);
                    wasFind = true;
                }
                break;

            case "2":
                lookingBus = busBuilder.setModel(inputSearch).setNumber(3).setMileage(1).build();
                Bus.setComp(new BusComparator.ByModel());
                index = BinarySearch.search(buses, lookingBus);
                if (index == -1) {
                    busResult = "Искомый автобус не найден в массиве.";
                } else {
                    busResult = "Автобус найден: " + buses.get(index);
                    wasFind = true;
                }
                break;

            case "3":
                lookingBus = busBuilder.setModel("A").setNumber(1).setMileage(Integer.parseInt(inputSearch)).build();
                Bus.setComp(new BusComparator.ByMileage());
                index = BinarySearch.search(buses, lookingBus);
                if (index == -1) {
                    busResult = "Искомый автобус не найден в массиве.";
                } else {
                    busResult = "Автобус найден: " + buses.get(index);
                    wasFind = true;
                }
                break;

            default:
                if (inputSearch.equals("0")) {
                    busResult = "\nВозврат в предыдущее меню.";
                    break;
                }
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
        }

        if (wasFind) {
            fileWriting("Found " + busResult);
        }
        return busResult;
    }


    public static String BinarySearchUser(List<User> users) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String searchField = """
                
                Выберите поля для поиска:\
                
                1) По id (by id)\
                
                2) По имени (by name)\
                
                3) По паролю (by password)\
                
                4) По электронной почте (by email)\
                
                0) Вернуться в предыдущее меню""";
        String inputAction;
        String userResult = "";
        boolean wasFind = false;

        do {
            System.out.printf(searchField, "Bus", users.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            if (inputAction.equals("1") | inputAction.equals("2") | inputAction.equals("3") | inputAction.equals("4")) {
                break;
            } else if (inputAction.equals("0")) {
                return "\nВозврат в предыдущее меню.";
            }
            else {
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (true);

        actionScan = new Scanner(System.in);
        System.out.println("\nВведите искомое значение (0 - возврат в предыдущее меню): ");

        String inputSearch;
        User.UserBuilder userBuilder = new User.UserBuilder();
        User lookingUser;
        int index;

        inputSearch = actionScan.nextLine();

        if (inputSearch.equals("0")) {
            userResult = "\nВозврат в предыдущее меню.\n";
        }

        switch (inputAction) {
            case "1":
                lookingUser = userBuilder.setId(Integer.parseInt(inputSearch)).setName("A").setPassword("B").setEmail("F").build();
                User.setComp(new UserComparator.ById());
                index = BinarySearch.search(users, lookingUser);
                if (index == -1) {
                    userResult = "Искомый пользователь не найден в массиве.";
                } else {
                    userResult = "Пользователь найден: " + users.get(index);
                    wasFind = true;
                }
                break;

            case "2":
                lookingUser = userBuilder.setId(9999).setName(inputSearch).setPassword("B").setEmail("F").build();
                User.setComp(new UserComparator.ByName());
                index = BinarySearch.search(users, lookingUser);
                if (index == -1) {
                    userResult = "Искомый пользователь не найден в массиве.";
                } else {
                    userResult = "Пользователь найден: " + users.get(index);
                    wasFind = true;
                }
                break;

            case "3":
                lookingUser = userBuilder.setId(9999).setName("A").setPassword(inputSearch).setEmail("F").build();
                User.setComp(new UserComparator.ByPassword());
                index = BinarySearch.search(users, lookingUser);
                if (index == -1) {
                    userResult = "Искомый пользователь не найден в массиве.";
                } else {
                    userResult = "Пользователь найден: " + users.get(index);
                    wasFind = true;
                }
                break;

            case "4":
                lookingUser = userBuilder.setId(9999).setName("A").setPassword("B").setEmail(inputSearch).build();
                User.setComp(new UserComparator.ByEmail());
                index = BinarySearch.search(users, lookingUser);
                if (index == -1) {
                    userResult = "Искомый пользователь не найден в массиве.";
                } else {
                    userResult = "Пользователь найден: " + users.get(index);
                    wasFind = true;
                }
                break;

            default:
                if (inputSearch.equals("0")) {
                    userResult = "\nВозврат в предыдущее меню.";
                    break;
                }
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
        }

        if (wasFind) {
            fileWriting("Found " + userResult);
        }
        return userResult;
    }


    public static String BinarySearchStudent(List<Student> studens) throws IOException {
        Scanner actionScan = new Scanner(System.in);
        String searchField = """
                
                Выберите поле для поиска:\
                
                1) По группе (by group)\
                
                2) По среднему баллу (by average score)\
                
                3) По зачетной книжке (by grade book)\
                
                0) Вернуться в предыдущее меню""";
        String inputAction;
        String studentResult = "";
        boolean wasFind = false;

        do {
            System.out.printf(searchField, "Student", studens.size());
            System.out.print("\n================\nВведите команду: ");

            inputAction = actionScan.nextLine();
            if (inputAction.equals("1") | inputAction.equals("2") | inputAction.equals("3")) {
                break;
            } else if (inputAction.equals("0")) {
                return "\nВозврат в предыдущее меню.";
            }
            else {
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (true);

        actionScan = new Scanner(System.in);
        System.out.println("\nВведите искомое значение (0 - возврат в предыдущее меню): ");

        String inputSearch;
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        Student lookingStudent;
        int index;

        inputSearch = actionScan.nextLine();

        if (inputSearch.equals("0")) {
            studentResult = "\nВозврат в предыдущее меню.\n";
        }

        switch (inputAction) {
            case "1":
                lookingStudent = studentBuilder.setGroup(inputSearch).setScore(1.0).setGradeBookNum(1).build();
                Student.setComp(new StudentComparator.ByGroup());
                index = BinarySearch.search(studens, lookingStudent);
                if (index == -1) {
                    studentResult = "Искомый студент не найден в массиве.";
                } else {
                    studentResult = "Студент найден: " + studens.get(index);
                    wasFind = true;
                }
                break;

            case "2":
                lookingStudent = studentBuilder.setGroup("A").setScore(Double.parseDouble(inputSearch)).setGradeBookNum(1).build();
                Student.setComp(new StudentComparator.ByScore());
                index = BinarySearch.search(studens, lookingStudent);
                if (index == -1) {
                    studentResult = "Искомый студент не найден в массиве.";
                } else {
                    studentResult = "Студент найден: " + studens.get(index);
                    wasFind = true;
                }
                break;

            case "3":
                lookingStudent = studentBuilder.setGroup("A").setScore(1.0).setGradeBookNum(Integer.parseInt(inputSearch)).build();
                Student.setComp(new StudentComparator.ByGradeBook());
                index = BinarySearch.search(studens, lookingStudent);
                if (index == -1) {
                    studentResult = "Искомый студент не найден в массиве.";
                } else {
                    studentResult = "Студент найден: " + studens.get(index);
                    wasFind = true;
                }
                break;

            default:
                if (inputSearch.equals("0")) {
                    studentResult = "\nВозврат в предыдущее меню.";
                    break;
                }
                System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
        }

        if (wasFind) {
            fileWriting("Found " + studentResult);
        }
        return studentResult;
    }
}
