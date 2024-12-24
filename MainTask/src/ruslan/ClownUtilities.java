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
     * Генератор номера автобуса для класса Bus в формате ББЧЧЧБ, где Б - латинская заглавная буква, Ч - число в dec
     * @return
     */
    public static String getRandomBusNumber() {
        return (char) getRandomNumber(65,90)+
                ""+
                getRandomNumber(100,999)+
                (char) getRandomNumber(65,90)+
                (char) getRandomNumber(65,90);
    }

    /**
     * Генератор случайного выбора значения из перечислений
     * @param className имя класса-перечисления
     * @return случайное значение из enum
     */
    public static String getRandomFromEnum(String className) {
        return switch (className) {
            case "Bus" -> BusModelEnum.values()[getRandomNumber(0, BusModelEnum.values().length)].toString();
            case "User" -> UserNameEnum.values()[getRandomNumber(0, UserNameEnum.values().length)].toString();
            default -> "";
        };
    }

    /**
     * Генерирует пароль для класса User, отвечающий сложности т.е. обязательное наличие прописной, заглавной латинских
     * букв, цифры, специального символа
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
     * Генерирует почту для класса User, с символом @, имени домена почты и домена верхнего уровня
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

    /**
     * Метод для генерации номера группы для класса Student
     * @return строку - номер группы в формате Б-ЧЧЧ, где Б - заглавная латинская буква, Ч - положительное число
     */
    public static String getRandomStudentGroup() {
        return (char) getRandomNumber(65,70)+
                "-"+
                getRandomNumber(100,999);
    }

    public static double getRandomAverageScore(double min, double max) {
        return Double.parseDouble(String.valueOf(((Math.random() * (max - min)) + min)).substring(0,3));
    }

}
