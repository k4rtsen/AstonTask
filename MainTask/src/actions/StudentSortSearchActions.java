package actions;

import algorithms.BinarySearch;
import algorithms.QuickSort;
import comparators.StudentComparator;
import models.Student;

import java.util.Comparator;
import java.util.List;

import static utilities.ManualInputUtilities.*;
import static utilities.Constants.*;
import static utilities.FileUtilities.fileWriting;

public class StudentSortSearchActions implements SortSearchActions<Student> {
    @Override
    public String getModelName() {
        return "Student";
    }

    @Override
    public String getSortFieldChoice() {
        return """
                
                Выберите поле для сортировки:
                1) По группе (by group)
                2) По среднему баллу (by average score)
                3) По зачетной книжке (by grade book)
                0) Вернуться в предыдущее меню""";
    }

    /**
     * Сортировка студентов по умолчанию, по группе
     * @param models массив студентов
     */
    @Override
    public void defaultSort(List<Student> models) {
        Student.setComp(StudentComparator.FullComparison.getFullComparison());
        sort(models, "\nМассив отсортирован по умолчанию (по группе).");
    }

    @Override
    public void sortByFirstField(List<Student> models) {
        Student.setComp(new StudentComparator.ByGroup());
        sort(models, "\nМассив отсортирован по группе (by group).");
    }

    @Override
    public void sortBySecondField(List<Student> models) {
        Student.setComp(new StudentComparator.ByScore());
        sort(models, "\nМассив отсортирован по среднему баллу (by average score).");
    }

    @Override
    public void sortByThirdField(List<Student> models) {
        Student.setComp(new StudentComparator.ByGradeBook());
        sort(models, "\nМассив отсортирован по зачетной книжке (by grade book).");
    }

    @Override
    public void sortByFourthField(List<Student> models) {
        System.out.print("\nКоманда не распознана, повторите ввод (0 - возврат в предыдущее меню).\n");
    }

    @Override
    public void sort(List<Student> models, String msg) {
        StringBuilder infoToFile = new StringBuilder();
        QuickSort.sort(models);
        for (Student it : models) {
            infoToFile.append(it).append("\n");
        }
        fileWriting(infoToFile.toString());
        System.out.println(msg);
    }

    @Override
    public Student binarySearch(List<Student> models) {
        Comparator<Student> comp = Student.getComp();
        Student lookingStudent;
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();

        switch (comp) {
            case StudentComparator.ByGroup byGroup -> {
                String group = readString("Введите группу студента (0 - отмена): ");
                if (group.equals("0")) return null;
                lookingStudent = studentBuilder.setGroup(group).setScore(DEFAULT_STUDENT_SCORE)
                        .setGradeBookNum(DEFAULT_STUDENT_GRADE_BOOK_NUM).build();
            }
            case StudentComparator.ByScore byScore -> {
                double score = readDouble("Введите средний балл студента (0 - отмена): ");
                if (score == 0) return null;
                lookingStudent = studentBuilder.setGroup(DEFAULT_STUDENT_GROUP)
                        .setScore(score).setGradeBookNum(DEFAULT_STUDENT_GRADE_BOOK_NUM)
                        .build();
            }
            case StudentComparator.ByGradeBook byGradeBook -> {
                int gradeBookNum = readInt("Введите номер зачетной книжки студента (0 - отмена): ");
                if (gradeBookNum == 0) return null;
                lookingStudent = studentBuilder.setGroup(DEFAULT_STUDENT_GROUP)
                        .setScore(DEFAULT_STUDENT_SCORE).setGradeBookNum(gradeBookNum)
                        .build();
            }
            case null, default -> {
                String group = readString("Введите группу студента (0 - отмена): ");
                if (group.equals("0")) return null;
                double score = readDouble("Введите средний балл студента (0 - отмена): ");
                if (score == 0) return null;
                int gradeBookNum = readInt("Введите номер зачетной книжки студента (0 - отмена): ");
                if (gradeBookNum == 0) return null;
                lookingStudent = studentBuilder.setGroup(group).setScore(score).setGradeBookNum(gradeBookNum).build();
            }
        }

        int index = BinarySearch.search(models, lookingStudent);
        if (index == -1) {
            System.out.println("Искомый студент не найден в массиве.");
            return null;
        }
        System.out.print("Студент найден: ");
        Student student = models.get(index);
        fileWriting("Found " + student);
        return student;
    }
}
