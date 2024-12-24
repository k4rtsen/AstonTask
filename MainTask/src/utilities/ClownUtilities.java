package utilities;

import enums.BusModelEnum;
import enums.DomainUserEnum;
import enums.MailUserEnum;
import enums.UserNameEnum;

/**
 * Утилитарный класс с разными функциями
 */
public final class ClownUtilities {
    static final int USER_EMAIL_LENGTH = 12;
    static final int USER_PASSWORD_LENGTH = 8;

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
     * @return строка - номер автобуса
     */
    @Deprecated
    public static String getRandomBusNumber() {
        return (char) getRandomNumber('A', 'Z')+
                ""+
                getRandomNumber(100, 999)+
                (char) getRandomNumber('A', 'Z')+
                (char) getRandomNumber('A', 'Z');
    }

    /**
     * Генератор случайного выбора значения из перечислений
     * @param modelName имя класса-перечисления
     * @return случайное значение из enum
     */
    public static String getRandomFromEnum(String modelName) {
        return switch (modelName) {
            case "Bus" -> BusModelEnum.values()[getRandomNumber(0, BusModelEnum.values().length)].toString();
            case "User" -> UserNameEnum.values()[getRandomNumber(0, UserNameEnum.values().length)].toString();
            default -> "";
        };
    }

    /**
     * Генерирует пароль для класса User, отвечающий сложности т.е. обязательное наличие прописной, заглавной латинских
     * букв, цифры, специального символа
     * @return сгенерированный пароль
     */
    public static String getRandomUserPassword() {
        String symbolsCh = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String symbolsNum = "1234567890";
        String symbolsSpec = "!@$%^&*";
        StringBuilder password;

        do {
            password = new StringBuilder();
            for (int i = 0; i < USER_PASSWORD_LENGTH; i++) {
                password.append((symbolsCh+symbolsNum+symbolsSpec)
                        .charAt(getRandomNumber(1, (symbolsCh+symbolsNum+symbolsSpec).length())));
            }

        } while (!password.toString().matches(".*\\d.*")
                | !password.toString().matches(".*[" + symbolsSpec +"].*")
                | !password.toString().matches(".*[A-Z].*")
                | !password.toString().matches(".*[a-z].*"));

        return password.toString();
    }

    /**
     * Генерирует почту для класса User, с символом @, имени домена почты и домена верхнего уровня
     * @return сгенерированную почту
     */
    public static String getRandomUserMail() {
        StringBuilder mail = new StringBuilder();

        for (int i = 0; i < USER_EMAIL_LENGTH; i++) {
            mail.append((char) getRandomNumber('a', 'z'));
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
        return (char) getRandomNumber('A', 'Z') + "-" + getRandomNumber(100, 999);
    }

    /**
     * Генератор случайных чисел для среднего балла Student
     * @param min нижняя граница
     * @param max верхняя граница
     * @return double с точностью до 2х знаков после занятой
     */
    public static double getRandomAverageScore(double min, double max) {
        return (double) Math.round(((Math.random() * (max - min)) + min) * 100) / 100;
    }

}
