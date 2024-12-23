package models;

public class Student {
    private final String group;
    private final Double avgScore;
    private final Integer gradeBookNumber;

    private Student(String group, Double avgScore, Integer gradeBookNumber) {
        this.group = group;
        this.avgScore = avgScore;
        this.gradeBookNumber = gradeBookNumber;
    }

    public String getGroup() {
        return group;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public Integer getGradeBookNumber() {
        return gradeBookNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", avgScore=" + avgScore +
                ", gradeBookNumber=" + gradeBookNumber +
                '}';
    }

    public static class StudentBuilder {
        private String group;
        private double avgScore;
        private int gradeBookNumber;

        public StudentBuilder setGroup(String group) {
            this.group = group;
            return this;
        }

        public StudentBuilder setScore(Double avgScore) {
            this.avgScore = avgScore;
            return this;
        }

        public StudentBuilder setGradeBookNum(Integer gradeBookNumber) {
            this.gradeBookNumber = gradeBookNumber;
            return this;
        }

        public Student build() {
            return new Student(group, avgScore, gradeBookNumber);
        }
    }
}