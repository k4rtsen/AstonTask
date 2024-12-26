package actions;

import algorithms.BinarySearch;
import algorithms.QuickSort;
import comparators.BusComparator;
import models.Bus;

import java.util.Comparator;
import java.util.List;

import static utilities.ManualInputUtilities.readInt;
import static utilities.ManualInputUtilities.readString;
import static utilities.Constants.*;
import static utilities.FileUtilities.fileWriting;

public class BusSortSearchActions implements SortSearchActions<Bus> {

    @Override
    public String getModelName() {
        return "Bus";
    }

    @Override
    public String getSortFieldChoice() {
        return """
                
                Выберите поля для сортировки:
                1) По номеру (by number)
                2) По модели (by model)
                3) По пробегу (by mileage)
                0) Вернуться в предыдущее меню""";
    }

    /**
     * Сортировка автобусов по умолчанию, по пробегу
     * @param models массив автобусов
     */
    @Override
    public void defaultSort(List<Bus> models) {
        sortByMileage(models, "\nМассив отсортирован по умолчанию (по пробегу).");
    }

    @Override
    public void sortByFirstField(List<Bus> models) {
        StringBuilder infoToFile =  new StringBuilder();
        Bus.setComp(new BusComparator.ByNumber());
        QuickSort.sort(models);
        for (Bus it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по номеру (by number).");
    }

    @Override
    public void sortBySecondField(List<Bus> models) {
        StringBuilder infoToFile =  new StringBuilder();
        Bus.setComp(new BusComparator.ByModel());
        QuickSort.sort(models);
        for (Bus it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по модели (by model).");
    }

    @Override
    public void sortByThirdField(List<Bus> models) {
        sortByMileage(models, "\nМассив отсортирован по пробегу (by mileage).");
    }

    @Override
    public void sortByFourthField(List<Bus> models) {
        System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
    }

    @Override
    public Bus binarySearch(List<Bus> models) {
        Comparator<Bus> comp = Bus.getComp();
        Bus lookingBus;
        Bus.BusBuilder busBuilder = new Bus.BusBuilder();

        if (comp instanceof BusComparator.ByNumber) {
            int number = readInt("Введите номер автобуса (0 - отмена): ");
            if (number == 0) return null;
            lookingBus = busBuilder.setNumber(number).setModel(DEFAULT_BUS_MODEL).setMileage(DEFAULT_BUS_MILEAGE).build();
        } else if (comp instanceof BusComparator.ByModel) {
            String model = readString("Введите модель автобуса (0 - отмена): ");
            if (model.equals("0")) return null;
            lookingBus = busBuilder.setNumber(DEFAULT_BUS_NUMBER).setModel(model).setMileage(DEFAULT_BUS_MILEAGE).build();
        } else if (comp instanceof BusComparator.ByMileage) {
            int mileage = readInt("Введите пробег автобуса (0 - отмена): ");
            if (mileage == 0) return null;
            lookingBus = busBuilder.setNumber(DEFAULT_BUS_NUMBER).setModel(DEFAULT_BUS_MODEL).setMileage(mileage).build();
        } else {
            int number = readInt("Введите номер автобуса (0 - отмена): ");
            if (number == 0) return null;
            String model = readString("Введите модель автобуса (0 - отмена): ");
            if (model.equals("0")) return null;
            int mileage = readInt("Введите пробег автобуса (0 - отмена): ");
            if (mileage == 0) return null;
            lookingBus = busBuilder.setNumber(number).setModel(model).setMileage(mileage).build();
        }
        int index = BinarySearch.search(models, lookingBus);
        if (index == -1) {
            System.out.println("Искомый автобус не найден в массиве.");
            return null;
        }
        System.out.print("Автобус найден: ");
        Bus bus = models.get(index);
        fileWriting("Found " + bus);
        return bus;
    }

    private void sortByMileage(List<Bus> models, String infoLine) {
        StringBuilder infoToFile = new StringBuilder();
        Bus.setComp(new BusComparator.ByMileage());
        QuickSort.sort(models);
        for (Bus it : models) {
            infoToFile.append(it).append("\n");
        }

        fileWriting(infoToFile.toString());
        System.out.println(infoLine);
    }
}
