package actions;

import utilities.ManualInputUtilities;
import models.Bus;

import java.util.ArrayList;
import java.util.List;

import static utilities.ManualInputUtilities.readInt;
import static utilities.ManualInputUtilities.readString;
import static utilities.FileUtilities.readFile;
import static utilities.RandomUtilities.getRandomFromEnum;
import static utilities.RandomUtilities.getRandomNumber;

public class BusFillActions implements FillActions<Bus> {
    private static final Bus.BusBuilder busBuilder = new Bus.BusBuilder();

    @Override
    public String getModelName() {
        return "Bus";
    }

    /**
     * Метод заполнения массива User из файла input_User.txt
     * @return массив List User
     */
    @Override
    public List<Bus> fillByFile() {
        String fileName = "MainTask/input_Bus.txt";
        //TODO add checkers for fields
        return readFile(fileName, (data, _) -> busBuilder
                .setNumber(Integer.parseInt(data[0]))
                .setModel(data[1])
                .setMileage(Integer.parseInt(data[2]))
                .build()
        );
    }

    /**
     * Метод заполнения массива Bus ручным способом
     * @return массив List Bus
     */
    @Override
    public List<Bus> fillManual() {
        return ManualInputUtilities.fillManual(getModelName(), (i) -> {
            int number = readInt(String.format("%s[%d] - Введите номер автобуса (0 - отмена): ", getModelName(), i));
            if (number == 0) return null;

            String model = readString(String.format("%s[%d] - Введите модель автобуса (0 - отмена): ", getModelName(), i));
            if (model.equals("0")) return null;

            int mileage = readInt(String.format("%s[%d] - Введите пробег автобуса (0 - отмена): ", getModelName(), i));
            if (mileage == 0) return null;

            return busBuilder.setNumber(number)
                    .setModel(model)
                    .setMileage(mileage)
                    .build();
        });
    }

    /**
     * Метод заполнения массива Bus случайным образом (рандом)
     * @return массив List Bus
     */
    @Override
    public List<Bus> fillRandom() {
        int arraySize = readInt(String.format("Введите размер массива %s (0 - возврат назад): ", getModelName()));
        if (arraySize == 0) return null;

        List<Bus> models = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            models.add(busBuilder
                    .setNumber(getRandomNumber(10000, 99999))
                    .setModel(getRandomFromEnum(getModelName()))
                    .setMileage(getRandomNumber(10, 999999))
                    .build());
        }
        return models;
    }
}
