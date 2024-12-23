package comparators;

import models.User;

import java.util.Comparator;

public class UserComparator {

    public static class ById implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return user1.getId().compareTo(user2.getId());
        }
    }

    public static class ByName implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return user1.getName().compareTo(user2.getName());
        }
    }

    public static class ByPassword implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return user1.getPassword().compareTo(user2.getPassword());
        }
    }

    public static class ByEmail implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return user1.getEmail().compareTo(user2.getEmail());
        }
    }
}
