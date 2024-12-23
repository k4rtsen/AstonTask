package algorithms;

import java.util.Comparator;
import java.util.List;

public class BinarySearch <T> {

    public int search(List<T> list, T target, Comparator<T> comparator) {
        return search(list, target, comparator, 0, list.size());
    }

    private int search(List<T> list, T target, Comparator<T> comparator, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (comparator.compare(target, list.get(middle)) == 0) {
            return middle;
        } else if (comparator.compare(target, list.get(middle)) < 0) {
            return search(list, target, comparator, low, middle - 1);
        } else {
            return search(list, target, comparator, middle + 1, high);
        }
    }
}
