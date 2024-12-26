package actions;

import algorithms.BinarySearch;
import algorithms.QuickSort;
import comparators.UserComparator;
import models.User;

import java.util.Comparator;
import java.util.List;

import static utilities.ManualInputUtilities.readInt;
import static utilities.ManualInputUtilities.readString;
import static utilities.Constants.*;
import static utilities.FileUtilities.fileWriting;

public class UserSortSearchActions implements SortSearchActions<User> {

    @Override
    public String getModelName() {
        return "User";
    }

    @Override
    public String getSortFieldChoice() {
        return """
                
                Выберите поля для сортировки:
                1) По id (by id)
                2) По имени (by name)
                3) По паролю (by password)
                4) По электронной почте (by email)
                0) Вернуться в предыдущее меню""";
    }

    @Override
    public void defaultSort(List<User> models) {
        StringBuilder infoToFile = new StringBuilder();
//        User.setComp(new UserComparator.FullComparison.getFullComparison());
        QuickSort.sort(models);
        for (User it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        sortById(models, "\nМассив отсортирован по умолчанию.");
    }

    @Override
    public void sortByFirstField(List<User> models) {
        sortById(models,"\nМассив отсортирован по id (by id).");
    }

    @Override
    public void sortBySecondField(List<User> models) {
        StringBuilder infoToFile = new StringBuilder();
        User.setComp(new UserComparator.ByName());
        QuickSort.sort(models);
        for (User it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по имени (by name).");
    }

    @Override
    public void sortByThirdField(List<User> models) {
        StringBuilder infoToFile = new StringBuilder();
        User.setComp(new UserComparator.ByPassword());
        QuickSort.sort(models);
        for (User it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по паролю (by password).");
    }

    @Override
    public void sortByFourthField(List<User> models) {
        StringBuilder infoToFile = new StringBuilder();
        User.setComp(new UserComparator.ByEmail());
        QuickSort.sort(models);
        for (User it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println("\nМассив отсортирован по электронной почте (by email).");
    }

    @Override
    public User binarySearch(List<User> models) {
        Comparator<User> comp = User.getComp();
        User lookingUser;
        User.UserBuilder userBuilder = new User.UserBuilder();

        if (comp instanceof UserComparator.ById) {
            int id = readInt("Введите id пользователя (0 - возврат в предыдущее меню): ");
            if (id == 0) return null;
            lookingUser = userBuilder.setId(id).setName(DEFAULT_USER_NAME)
                    .setPassword(DEFAULT_USER_PASSWORD).setEmail(DEFAULT_USER_EMAIL).build();
        } else if (comp instanceof UserComparator.ByName) {
            String userName = readString("Введите имя пользователя (0 - возврат в предыдущее меню): ");
            if (userName.equals("0")) return null;
            lookingUser = userBuilder.setId(DEFAULT_USER_ID).setName(userName)
                    .setPassword(DEFAULT_USER_PASSWORD).setEmail(DEFAULT_USER_EMAIL).build();
        } else if (comp instanceof UserComparator.ByPassword) {
            String password = readString("Введите пароль пользователя (0 - возврат в предыдущее меню): ");
            if (password.equals("0")) return null;
            lookingUser = userBuilder.setId(DEFAULT_USER_ID).setName(DEFAULT_USER_NAME)
                    .setPassword(password).setEmail(DEFAULT_USER_EMAIL).build();
        } else {
            String email = readString("Введите e-mail пользователя (0 - возврат в предыдущее меню): ");
            if (email.equals("0")) return null;
            lookingUser = userBuilder.setId(DEFAULT_USER_ID).setName(DEFAULT_USER_NAME)
                    .setPassword(DEFAULT_USER_PASSWORD).setEmail(email).build();
        }

        int index = BinarySearch.search(models, lookingUser);
        if (index == -1) {
            System.out.println("Искомый пользователь не найден в массиве.");
            return null;
        }
        System.out.print("Пользователь найден: ");
        User user = models.get(index);
        fileWriting("Found " + user);
        return user;
    }

    private void sortById(List<User> models, String infoLine) {
        StringBuilder infoToFile = new StringBuilder();
        User.setComp(new UserComparator.ById());
        QuickSort.sort(models);
        for (User it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println(infoLine);
    }
}
