import java.util.List;

public class QuickSort {

    // Быстрая сортировка для автобуса по пробегу
    public static void quickSortBus(List<Bus> buses) {
        quickSortBus(buses, 0, buses.size() - 1);
    }