import java.io.*;
import java.util.*;

import models.*;

import static actions.ActionMenu.*;
import static filling.ByFromFile.*;
import static filling.ByRandom.*;
import static filling.ByManual.*;

public class MainUI {
    public static void main(String[] args) throws IOException {
        String helloText = "Добро пожаловать в приложение демонстрации алгоритма \"Быстрой сортировки\"" +
                " (created by Clowns_team)";

        String baseMenu = """
                
                Выберите один из классов:
                1) Bus (Number, Model, Mileage)
                2) User (Id,Name, Password, e-mail)
                3) Student (Group Number, Average Score, Grade Book Number)
                0) Выход из приложения""";

        Scanner scanner = new Scanner(System.in);
        String inputMenu;

        System.out.println(helloText);
        do {
            System.out.println(baseMenu);
            System.out.print("================\nВведите команду: ");
            inputMenu = scanner.nextLine();

            switch (inputMenu) {
                case "1":
                    System.out.println("\nВы выбрали класс Bus (Number, Model, Mileage)");
                    modelsMenu("Bus");
                    break;

                case "2":
                    System.out.println("\nВы выбрали класс User (Name, Password, Mail)");
                    modelsMenu("User");
                    break;

                case "3":
                    System.out.println("\nВы выбрали класс Student (Group Number, Average Score, Grade Book Number)");
                    modelsMenu("Student");
                    break;

                case "0":
                    System.out.println("\nВыход из программы.");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - для выхода).\n");
            }
        }
        while (!inputMenu.equals("0"));
    }



    public static void modelsMenu(String modelName) throws IOException {
        Scanner classScan = new Scanner(System.in);
        String inputClass;
        do {
            System.out.println("\nВыберите способ заполнения массива " + modelName + ": " +
                    "\n1) Из файла" +
                    "\n2) Рандом" +
                    "\n3) Вручную" +
                    "\n0) Вернуться в главное меню");
            System.out.print("================\nВведите команду: ");
            inputClass = classScan.nextLine();

            switch (inputClass) {
                case "1":
                    System.out.println("\nВы выбрали 1 - \"Из файла\"\n");
                    fillByFile(modelName);
                    break;

                case "2":
                    System.out.println("\nВы выбрали 2 - \"Рандом\"\n");
                    fillByRandom(modelName);
                    break;

                case "3":
                    System.out.println("\nВы выбрали 3 - \"Вручную\"\n");
                    fillByManual(modelName);
                    break;

                case "0":
                    System.out.println("\nВозврат в предыдущее меню.");
                    break;

                default:
                    System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
            }
        } while (!inputClass.equals("0"));
    }



    public static void fillByRandom(String modelName) throws IOException {
            switch (modelName) {
                case "Bus":
                    List<Bus> buses = fillBusByRandom();
                    if (buses != null) {
                        actionMenuBus(buses);
                    }
                    break;

                case "User":
                    List<User> users = fillUserByRandom();
                    if (users != null) {
                        actionMenuUser(users);
                    }
                    break;

                case "Student":
                    List<Student> students = fillStudentByRandom();
                    if (students != null) {
                        actionMenuStudent(students);
                    }
                    break;
        }
    }



    public static void fillByFile(String modelName) throws IOException {
        switch (modelName) {
            case "Bus":
                List<Bus> buses = fillBusFromFile();
                if (buses != null) {
                    actionMenuBus(buses);
                }
                break;

            case "User":
                List<User> users = fillUserFromFile();
                if (users != null) {
                    actionMenuUser(users);
                }
                break;

            case "Student":
                List<Student> students = fillStudentFromFile();
                if (students != null) {
                    actionMenuStudent(students);
                }
                break;
        }
    }



    public static void fillByManual(String modelName) throws IOException {
        switch (modelName) {
            case "Bus":
                List<Bus> buses = fillBusByManual();
                if (buses != null) {
                    actionMenuBus(buses);
                }
                break;

            case "User":
                List<User> users = fillUserByManual();
                if (users != null) {
                    actionMenuUser(users);
                }
                break;

            case "Student":
                List<Student> students = fillStudentByManual();
                if (students != null) {
                    actionMenuStudent(students);
                }
                break;
        }
    }

}
