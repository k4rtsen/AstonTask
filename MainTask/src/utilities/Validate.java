package utilities;

import models.*;

/**
 * Класс для валидации данных
 */
public class Validate {
    static final int USER_PASSWORD_LENGTH = 8;
    static final String SPECIAL_FOR_PASSWORD = "!@$^&*";

    /**
     * Валидация объекта Bus, поле номер (Number)
     * целое положительное число от 2 до 5 знаков
     * @param data строка для проверки
     * @return
     */
    public static boolean BusNumberValidate(String data) {
        if (data.matches("-?\\d+")) {
            if ((data.length() >= 2)
                    & (data.length() <= 5)) {
                if ((Integer.parseInt(data) > 0)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта Bus, поле модель (Model)
     * строка из латинских букв от 3 до 10 символов
     * @param data строка для проверки
     * @return
     */
    public static boolean BusModelValidate(String data) {
       if (data.matches("^[A-Za-z]+$")) {
           if ((data.length() >= 3)
                   & (data.length() <= 10)) {
               return true;
           } else return false;
       } else return false;
    }

    /**
     * Валидация объекта Bus, поле пробег (Mileage)
     * целое положительное число от 2 до 8 знаков
     * @param data строка для проверки
     * @return
     */
    public static boolean BusMileageValidate(String data) {
        if (data.matches("-?\\d+")) {
            if ((data.length() >= 2)
                    & (data.length() <= 8)) {
                 if (Integer.parseInt(data) > 0) {
                     return true;
                 } else return false;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта User, поле имя (Name)
     * строка состоящая из латинских букв от 2 до 10 символов
     * @param data строка для проверки
     * @return
     */
    public static boolean UserNameValidate(String data) {
        if (data.matches("^[A-Za-z]+$")) {
            if ((data.length() >= 2)
                    & (data.length() <= 10)) {
                return true;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта User, поле пароль (Password)
     * длина 8 символов, обязательное наличие
     * заглавной, прописной латинских букв, цифры, спец.символа !@$^&*
     * @param data строка для проверки
     * @return
     */
    public static boolean UserPasswordValidate(String data) {
        return (data.length() == USER_PASSWORD_LENGTH)
                & data.matches(".*\\d.*")
                & data.matches(".*[" + SPECIAL_FOR_PASSWORD + "].*")
                & data.matches(".*[A-Z].*")
                & data.matches(".*[a-z].*");
    }

    /**
     * Валидация объекта User, поле электронная почта (EMail)
     * имя_почты@домен_почты.верхний_домен где:
     * имя_почты - прописные латинские буквы и цифры от 2 до 20 символов
     * домен_почты - прописные латинские буквы и цифры от 2 до 10 символов
     * верхний_домен - латинские прописные буквы от 2 до 4 символов
     * пример - example@maildomain.com
     * @param data строка для проверки
     * @return
     */
    public static boolean UserEMailValidate(String data) {
        String[] tmpArr = data.split("@");
        //в почте только 1 символ @
        if (tmpArr.length == 2) {
            //имя почты только прописные латиница, от 2 до 20 символов
            if ((tmpArr[0].matches("^[a-z0-9]+$"))
                    & (tmpArr[0].length() >= 2)
                    & (tmpArr[0].length() <= 20)) {
                String[] tmpArr1 = tmpArr[1].split("\\.");
                //во 2й части почты только 1 символ .
                if (tmpArr1.length == 2) {
                    //домен почты только прописные латиница, от 2 до 10 символов
                    if ((tmpArr1[0].matches("^[a-z0-9]+$"))
                            & (tmpArr1[0].length() >= 2)
                            & (tmpArr1[0].length() <= 10)) {
                        //имя почты только прописные латиница, от 2 до 4 символов
                        if ((tmpArr1[1].length() >= 2)
                                & (tmpArr1[1].length() <= 4)
                                & (tmpArr1[1].matches("^[a-z]+$"))) {
                            return true;
                        }  else return false;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта Student, поля номера группы (Group)
     * вида X-NNN, где
     * X - любая заглавная латинская буква
     * NNN - 3х значное число (001 допускается)
     * @param data строка для проверки
     * @return
     */
    public static boolean StudentGroupValidate(String data) {
        if (data.matches("^[A-Z0-9 -]+$")) {
            String[] tmpArr = data.split("-");
            if (tmpArr.length == 2) {
                if (tmpArr[0].length() == 1) {
                    if ((tmpArr[1].length() == 3)
                            & (tmpArr[1].matches("^[0-9]+$"))) {
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта Student, поля среднего балла (AverageScore)
     * положительное число, целое или дробное (максимальный балл 10.0)
     * @param data строка для проверки
     * @return
     */
    public static boolean StudentAverageScoreValidate(String data) {
        if (data.matches("^(0|[1-9]\\d*)([.,]\\d+)?")) {
            if ((Double.parseDouble(data) > 0)
                    & (Double.parseDouble(data) <= 10)) {
                return true;
            } else return false;
        } else return false;
    }

    /**
     * Валидация объекта Student, поля зачетной книжки (GradeBook)
     * положительное число от 3 до 6 символов
     * @param data строка для проверки
     * @return
     */
    public static boolean StudentGradeBookValidate(String data) {
        if (data.matches("-?\\d+")) {
            if ((data.length() >= 3)
                    & (data.length() <= 6)) {
                if ((Integer.parseInt(data) > 0)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    /**
     * Проводит валидацию для объекта Bus
     * @param line входная строка их считываемого файла
     * @return
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
     * @return
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
     * @return
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