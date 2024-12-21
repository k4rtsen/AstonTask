import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class QuickSort {

    // Быстрая сортировка для автобуса по пробегу
    public static void quickSortBus(List<Bus> buses) {
        quickSortBus(buses, 0, buses.size() - 1);
    }

    private static void quickSortBus(List<Bus> buses, int low, int high) {
        if (low < high) {
            int pi = partitionBus(buses, low, high);
            quickSortBus(buses, low, pi - 1);
            quickSortBus(buses, pi + 1, high);
        }
    }

    private static int partitionBus(List<Bus> buses, int low, int high) {
        Bus pivot = buses.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (buses.get(j).getMileage() < pivot.getMileage()) {
                i++;
                swapBus(buses, i, j);
            }
        }
        swapBus(buses, i + 1, high);
        return i + 1;
    }

    private static void swapBus(List<Bus> buses, int i, int j) {
        Bus temp = buses.get(i);
        buses.set(i, buses.get(j));
        buses.set(j, temp);
    }

    // Быстрая сортировка для пользователя по имени
    public static void quickSortUser(List<User> users) {
        quickSortUser(users, 0, users.size() - 1);
    }

    private static void quickSortUser(List<User> users, int low, int high) {
        if (low < high) {
            int pi = partitionUser(users, low, high);
            quickSortUser(users, low, pi - 1);
            quickSortUser(users, pi + 1, high);
        }
    }

    private static int partitionUser(List<User> users, int low, int high) {
        User pivot = users.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (users.get(j).getName().compareTo(pivot.getName()) < 0) {
                i++;
                swapUser(users, i, j);
            }
        }
        swapUser(users, i + 1, high);
        return i + 1;
    }

    private static void swapUser(List<User> users, int i, int j) {
        User temp = users.get(i);
        users.set(i, users.get(j));
        users.set(j, temp);
    }

    // Быстрая сортировка для студента по среднему баллу
    public static void quickSortStudent(List<Student> students) {
        quickSortStudent(students, 0, students.size() - 1);
    }

    private static void quickSortStudent(List<Student> students, int low, int high) {
        if (low < high) {
            int pi = partitionStudent(students, low, high);
            quickSortStudent(students, low, pi - 1);
            quickSortStudent(students, pi + 1, high);
        }
    }

    private static int partitionStudent(List<Student> students, int low, int high) {
        Student pivot = students.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getAvgScore() < pivot.getAvgScore()) {
                i++;
                swapStudent(students, i, j);
            }
        }
        swapStudent(students, i + 1, high);
        return i + 1;
    }

    private static void swapStudent(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }
}

