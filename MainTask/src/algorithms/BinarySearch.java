package algorithms;

import models.ComparableClass;
import models.Filterable;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BinarySearch {

    public static <T extends Filterable<T>> int search(List<T> list, T target) {
        return search(list, target, 0, list.size());
    }

    private static <T extends Filterable<T>> int search(List<T> list, T target, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        int comp = list.get(middle).compTo(target);

        if (comp == 0) {
            return middle;
        } else if (comp > 0) {
            return search(list, target, low, middle - 1);
        } else {
            return search(list, target, middle + 1, high);
        }
    }
}
