package algorithms;

import java.util.*;

public class QuickSort {

    // Wrapper для передачи в метод по ссылке
    static class Greatest {
        public int value;
    }

    /**
     * Быстрая сортировка
     * @param list список некоторых элементов
     * @param comp прописанный компаратор, по которому сравниваются объекты в list
     * @param <T>  класс, для которого прописан компаратор
     */
    public static <T> void sort(List<T> list, Comparator<T> comp) {
        quickSort(list, comp, 0, list.size());
    }

    private static <T> void quickSort(List<T> list, Comparator<T> comp, int left, int right) {
        if (right > left) {
            // Опорный объект, относительно которого будет строиться распределение, выбирается случайным образом
            // Можно улучшить в дальнейшем посредством увеличения количества случайных элементов и выбор среди них среднее значение
            Random rnd = new Random();
            int pivot = rnd.nextInt(right - left) + left; // диапазон [left, right)

            // вплоть до элемента greatest все эл-ты не превышают опорный, собственно с него и стоит начать делать Partition второй части
            Greatest g = new Greatest();

            // Разделение на большие и малые числа относительно выбранного ранее опорного элемента
            int p = partition(list, comp, left, right, pivot, g); // слева от p все числа меньше опорного
            quickSort(list, comp, left, p);
            quickSort(list, comp, g.value, right);
        }
    }

    private static <T> int partition(List<T> list, Comparator<T> comp, int left, int right, int supElementIndex, Greatest g) {
        // указатели на элементы e = equal, g = great
        int equal = left, great = left;

        // опорный элемент
        T pivot = list.get(supElementIndex);

        // 1. Если меньше опорного
        // 2. Если равен опорному
        // 3. Если больше опорного
        for (int i = left; i < right; i++)
        {
            // 1.
            if (comp.compare(list.get(i), pivot) < 0)
            {
                T temp = list.get(i);
                list.set(i, list.get(great));
                list.set(great, list.get(equal));
                list.set(equal, temp);
                equal++;
                great++;
                continue;
            }

            // 2.
            if (comp.compare(list.get(i), pivot) == 0)
            {
                T temp = list.get(i);
                list.set(i, list.get(great));
                list.set(great, temp);
                great++;
            }

            // 3.
            // Просто двигаем индекс еще не просмотренных элементов
            // элементы больше всегда остаются справа, поэтому не трогаем их
        }

        // сохраняем индекс элемента, который идет строго после опорного и всех ему одинаковых
        g.value = great;
        // возвращаем индекс эл-та, слева от которого все строго меньше опорного
        return equal;
    }
}

