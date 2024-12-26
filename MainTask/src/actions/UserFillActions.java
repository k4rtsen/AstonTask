package actions;

import utilities.ManualInputUtilities;
import models.User;

import java.util.ArrayList;
import java.util.List;

import static utilities.ManualInputUtilities.readInt;
import static utilities.ManualInputUtilities.readString;
import static utilities.FileUtilities.readFile;
import static utilities.RandomUtilities.*;
import static utilities.RandomUtilities.getRandomUserMail;

public class UserFillActions implements FillActions<User> {

    private static final User.UserBuilder userBuilder = new User.UserBuilder();

    @Override
    public String getModelName() {
        return "User";
    }

    /**
     * Метод заполнения массива User из файла input_User.txt
    * @return массив List User
    */
    @Override
    public List<User> fillByFile() {
        String fileName = "input_User.txt";
        return readFile(fileName, (data, i) -> userBuilder
                .setId(i)
                .setName(data[0])
                .setPassword(data[1])
                .setEmail(data[2])
                .build()
        );
    }

    /**
     * Метод заполнения массива User ручным способом
     * @return массив List User
     */
    @Override
    public List<User> fillManual() {
        return ManualInputUtilities.fillManual(getModelName(), (i) -> {
            String name = readString(String.format("%s[%d] - Введите имя пользователя (0 - отмена): ",
                    getModelName(), i));
            if (name.equals("0")) return null;

            String password = readString(String.format("%s[%d] - Введите пароль пользователя (0 - отмена): ",
                    getModelName(), i));
            if (password.equals("0")) return null;

            String email = readString(String.format("%s[%d] - Введите e-mail пользователя (0 - отмена): ",
                    getModelName(), i));
            if (email.equals("0")) return null;

            return userBuilder
                    .setId(i + 1)
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
                    .build();
        });
    }

    /**
     * Метод заполнения массива User случайным образом (рандом)
     * @return массив List User
     */
    @Override
    public List<User> fillRandom() {
        int arraySize = readInt(String.format("Введите размер массива %s (0 - возврат назад): ", getModelName()));
        if (arraySize == 0) return null;

        List<User> models = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            models.add(userBuilder
                    .setId(i + 1)
                    .setName(getRandomFromEnum(getModelName()))
                    .setPassword(getRandomUserPassword())
                    .setEmail(getRandomUserMail())
                    .build());
        }
        return models;
    }
}
