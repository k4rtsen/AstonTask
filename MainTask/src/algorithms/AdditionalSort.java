package algorithms;

import comparators.*;
import models.*;
import java.util.*;
import models.Filterable;

public class AdditionalSort {
    public static <T extends Filterable<T>> void sort(List<T> array) {
        List<Integer> evenIndices = new ArrayList<>();
        List<T> evenObjects = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            T object = array.get(i);
            if (isEven(object)) {
                evenIndices.add(i);
                evenObjects.add(object);
            }
        }

        sort(evenObjects, 0, evenObjects.size() - 1);

        for (int i = 0; i < evenIndices.size(); i++) {
            array.set(evenIndices.get(i), evenObjects.get(i));
        }
    }

    private static <T extends Filterable<T>> void sort(List<T> array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivot = getMedianPivot(array, lowIndex, highIndex);

            swap(array, pivot, highIndex);
            pivot = highIndex;

            int leftPointer = lowIndex;
            int rightPointer = highIndex;

            while (leftPointer < rightPointer) {

                while (array.get(leftPointer).compTo(array.get(pivot)) < 0 && leftPointer < rightPointer) {
                    leftPointer++;
                }


                while (array.get(rightPointer).compTo(array.get(pivot)) > 0 && leftPointer < rightPointer) {
                    rightPointer--;
                }

                swap(array, leftPointer, rightPointer);
            }

            swap(array, leftPointer, pivot);

            sort(array, lowIndex, leftPointer - 1);
            sort(array, leftPointer + 1, highIndex);
        }
    }

    private static <T> void swap(List<T> array, int index1, int index2) {
        T temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    private static <T> boolean isEven(T object) {
        int value = getNumericFieldValue(object);
        return value % 2 == 0;
    }

    private static <T> int getNumericFieldValue(T object) {
        if (object instanceof Bus)
            return ((Bus) object).getNumber();
        if (object instanceof Student)
            return ((Student) object).getGradeBookNumber();
        if (object instanceof User)
            return ((User) object).getId();
        throw new IllegalArgumentException("Объект этого класса не поддерживается");
    }

    private static <T> int getMedianPivot(List<T> array, int lowIndex, int highIndex) {
        int middleIndex = (int)Math.floor((highIndex - lowIndex) / 2.0);
        T firstElement = array.get(lowIndex);
        T lastElement = array.get(highIndex);
        T middleElement = array.get(middleIndex);
        Comparator<T> comparator = getComparatorByClassName(array.getFirst().getClass().getSimpleName());
        List<T> elements = Arrays.asList(firstElement, lastElement, middleElement);
        elements.sort(comparator);
        return array.indexOf(elements.get(1));
    }

    private static <T> Comparator<T> getComparatorByClassName(String className) {
        Comparator<T> comparator = null;
        switch (className) {
            case "Bus":
                comparator = (Comparator<T>) new BusComparator.ByNumber();
                break;

            case "Student":
                comparator = (Comparator<T>) new StudentComparator.ByGradeBook();
                break;

            case "User":
                comparator = (Comparator<T>) new UserComparator.ById();
                break;

            default:
                throw new IllegalArgumentException("Объект этого класса не поддерживается");
        }
        return comparator;
    }
}
