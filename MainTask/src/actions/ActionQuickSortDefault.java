package actions;

import algorithms.QuickSort;
import comparators.*;
import models.Bus;
import models.Student;
import models.User;

import java.io.IOException;
import java.util.List;

import static utilities.FileUtilities.fileWriting;

/**
 * Класс для сортировок по умолчанию
 */
public class ActionQuickSortDefault {
    /**
     * Сортировка автобусов по умолчанию, по пробегу
     * @param buses массив автобусов
     * @throws IOException
     */
        public static void QuickSortBusDefault(List<Bus> buses) throws IOException {
            StringBuilder infoToFile;
            Bus.setComp(new BusComparator.ByMileage());
            QuickSort.sort(buses);
            infoToFile = new StringBuilder();
            for (Bus it : buses) {
                infoToFile.append(it).append("\n");
            }
            fileWriting(infoToFile.toString());
            System.out.println("\nМассив отсортирован по умолчанию (по пробегу).");
    }

    /**
     * Сортировка пользователей по умолчанию, по id
     * @param users массив пользователей
     * @throws IOException
     */
    public static void QuickSortUserDefault(List<User> users) throws IOException {
        StringBuilder infoToFile;
        User.setComp(new UserComparator.ById());
        QuickSort.sort(users);
        infoToFile = new StringBuilder();
        for (User it : users) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по умолчанию (по id).");
    }

    /**
     * Сортировка студентов по умолчанию, по группе
     * @param students массив студентов
     * @throws IOException
     */
    public static void QuickSortStudentDefault(List<Student> students) throws IOException {
        StringBuilder infoToFile;
        Student.setComp(new StudentComparator.ByGroup());
        QuickSort.sort(students);
        infoToFile = new StringBuilder();
        for (Student it : students) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по умолчанию (по группе).");
    }
}
