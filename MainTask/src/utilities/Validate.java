package utilities;

import models.*;

/**
 * Класс для валидации данных
 */
public class Validate {
    /**
     * Валидация объекта Bus, поле номер (Number)
     * целое положительное число от 2 до 5 знаков
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean BusNumberValidate(String data) {
        return data.matches("^[0-9]{2,5}$");
    }

    /**
     * Валидация объекта Bus, поле модель (Model)
     * строка из латинских букв от 3 до 10 символов
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean BusModelValidate(String data) {
        return data.matches("^[A-Za-z]{3,10}$");
    }

    /**
     * Валидация объекта Bus, поле пробег (Mileage)
     * целое положительное число от 2 до 8 знаков
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean BusMileageValidate(String data) {
        return data.matches("^[0-9]{2,8}$");
    }

    /**
     * Валидация объекта User, поле имя (Name)
     * строка состоящая из латинских букв от 2 до 10 символов
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean UserNameValidate(String data) {
        return data.matches("^[A-Za-z]{2,10}$");
    }

    /**
     * Валидация строки на целое, положительное число
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean PositiveIntegerValidate(String data) {
        if (data.matches("^[0-9]$")) {
            return Integer.parseInt(data) > 0;
        } else return false;
    }

    /**
     * Валидация объекта User, поле пароль (Password)
     * длина 8 символов, обязательное наличие
     * заглавной, прописной латинских букв, цифры, спец.символа !@$^&*
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean UserPasswordValidate(String data) {
        int USER_PASSWORD_LENGTH = 8;
        String SPECIAL_FOR_PASSWORD = "!@$^&*";
        String REGEX_FOR_PASSWORD_CHECK = "^(?=.*[A-Z])(?=.*["
                + SPECIAL_FOR_PASSWORD
                + "])(?=.*[0-9])(?=.*[a-z]).{"
                + USER_PASSWORD_LENGTH
                +"}$";
        return data.matches(REGEX_FOR_PASSWORD_CHECK);
    }

    /**
     * Валидация объекта User, поле электронная почта (EMail)
     * имя_почты@домен_почты.верхний_домен где:
     * имя_почты - прописные латинские буквы и цифры от 2 до 20 символов
     * домен_почты - прописные латинские буквы и цифры от 2 до 10 символов
     * верхний_домен - латинские прописные буквы от 2 до 4 символов
     * пример - example@maildomain.com
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean UserEMailValidate(String data) {
        return data.matches("^[a-z]{2,20}+@[a-z]{2,10}+.[a-z]{2,4}$");
    }

    /**
     * Валидация объекта Student, поля номера группы (Group)
     * вида X-NNN, где
     * X - любая заглавная латинская буква
     * NNN - 3х значное число (001 допускается)
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean StudentGroupValidate(String data) {
        return data.matches("^[A-Z]{1}+-[0-9]{3}$");
    }

    /**
     * Валидация объекта Student, поля среднего балла (AverageScore)
     * положительное число, целое или дробное (максимальный балл 10.0)
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean StudentAverageScoreValidate(String data) {
        if (data.matches("^(0|[1-9]\\d*)([.,]\\d+)?")) {
            return (Double.parseDouble(data) > 0)
                    & (Double.parseDouble(data) <= 10);
        } else return false;
    }

    /**
     * Валидация объекта Student, поля зачетной книжки (GradeBook)
     * положительное число от 3 до 6 символов
     * @param data строка для проверки
     * @return true or false
     */
    public static boolean StudentGradeBookValidate(String data) {
        return data.matches("^[0-9]{3,6}$");
    }

    /**
     * Проводит валидацию для объекта Bus
     * @param line входная строка их считываемого файла
     * @return экземпляр Bus или null если не прошел валидацию
     */
    public static Bus BusLineValidate(String line) {
        String[] tmpArr = line.split(";");
        if (tmpArr.length == 3) {
            if ((BusNumberValidate(tmpArr[0]))
                    & (BusModelValidate(tmpArr[1]))
                    & (BusMileageValidate(tmpArr[2]))) {

                return new Bus.BusBuilder()
                        .setNumber(Integer.parseInt(tmpArr[0]))
                        .setModel(tmpArr[1])
                        .setMileage(Integer.parseInt(tmpArr[2]))
                        .build();
            } else return null;
        } else return null;
    }

    /**
     * Проводит валидацию для объекта User
     * @param line входная строка их считываемого файла
     * @param count счетчик id
     * @return экземпляр User или null если не прошел валидацию
     */
    public static User UserLineValidate(String line, int count) {
        String[] tmpArr = line.split(";");
        if (tmpArr.length == 3) {
            if ((UserNameValidate(tmpArr[0]))
                    & (UserPasswordValidate(tmpArr[1]))
                    & (UserEMailValidate(tmpArr[2]))) {

                return new User.UserBuilder()
                        .setId(count)
                        .setName(tmpArr[0])
                        .setPassword(tmpArr[1])
                        .setEmail(tmpArr[2])
                        .build();
            } else return null;
        } else return null;
    }

    /**
     * Проводит валидацию для объекта Student
     * @param line входная строка их считываемого файла
     * @return экземпляр Student или null если не прошел валидацию
     */
    public static Student StudentLineValidate(String line) {
        String[] tmpArr = line.split(";");
        if (tmpArr.length == 3) {
            if ((StudentGroupValidate(tmpArr[0]))
                    & (StudentAverageScoreValidate(tmpArr[1]))
                    & (StudentGradeBookValidate(tmpArr[2]))) {

                return new Student.StudentBuilder()
                        .setGroup(tmpArr[0])
                        .setScore(Double.parseDouble(tmpArr[1]))
                        .setGradeBookNum(Integer.parseInt(tmpArr[2]))
                        .build();
            } else return null;
        } else return null;
    }
}