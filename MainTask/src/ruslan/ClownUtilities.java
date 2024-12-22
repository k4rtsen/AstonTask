package ruslan;

import java.util.Arrays;

public final class ClownUtilities {
    private ClownUtilities() {
    }

    /**
     * Генератор случайных чисел в заданном диапазоне
     * @param min нижняя граница
     * @param max верхняя граница
     * @return случайное сгенерированное число
     */
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Генератор номера автобуса в формате ББЧЧЧБ, где Б - латинская заглавная буква, Ч - число в dec
     * @return
     */
    public static String getRandomBusNumber() {
        return (char) getRandomNumber(65,90)+
                ""+
                getRandomNumber(100,999)+
                (char) getRandomNumber(65,90)+
                (char) getRandomNumber(65,90);
    }

//    public static <E extends Enum<E>> void getRandomFromEnum(E e) {
//        for(Enum<E> item : e.getClass().getEnumConstants()){
//            System.out.println(Arrays.toString(item.getClass().getEnumConstants()));
//        }
//        return String.valueOf(e.getClass().getEnumConstants().length);
//    }

    /**
     * Генератор случайного выбора значения из перечислений
     * @param className имя класса-перечисления
     * @return случайное значение из enum
     */
    public static String getRandomFromEnum(String className) {
        return switch (className) {
            case "BusModelEnum" -> BusModelEnum.values()[getRandomNumber(0, BusModelEnum.values().length)].toString();
            case "UserNameEnum" -> UserNameEnum.values()[getRandomNumber(0, UserNameEnum.values().length)].toString();
            default -> "";
        };
    }

    /**
     * Генерирует пароль, отвечающий сложности т.е. обязательное наличие прописной, заглавной латинских букв, цифры,
     * специального символа
     * @param len длина пароля
     * @return сгенерированный пароль
     */
    public static String getRandomUserSecret(int len) {
        String symbolsCh = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String symbolsNum = "1234567890";
        String symbolsSpec = "!@$%^&*";
        StringBuilder secret;

        do {
            secret = new StringBuilder();
            for (int i = 0; i < len; i++) {
                secret.append((symbolsCh+symbolsNum+symbolsSpec)
                        .charAt(getRandomNumber(1, (symbolsCh+symbolsNum+symbolsSpec).length())));
            }

        } while (!secret.toString().matches(".*\\d.*")
                | !secret.toString().matches(".*[" + symbolsSpec +"].*")
                | !secret.toString().matches(".*[A-Z].*")
                | !secret.toString().matches(".*[a-z].*"));

        return secret.toString();
    }

    /**
     * Генерирует почту пользователя
     * @param len длина имени почты
     * @return сгенерированную почту
     */
    public static String getRandomUserMail(int len) {
        StringBuilder mail = new StringBuilder();

        for (int i = 0; i < len; i++) {
            mail.append((char) getRandomNumber(97, 122));
        }

        return mail
                .append("@")
                .append(MailUserEnum.values()[getRandomNumber(0, MailUserEnum.values().length)])
                .append(".").append(DomainUserEnum.values()[getRandomNumber(0, DomainUserEnum.values().length)])
                .toString();
    }

    public static String getRandomStudentGroup() {
        return (char) getRandomNumber(65,70)+
                "-"+
                getRandomNumber(100,999);
    }

    public static double getRandomAverageScore(double min, double max) {
        return (double) ((Math.random() * (max - min)) + min);
    }

}
