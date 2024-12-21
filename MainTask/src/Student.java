public class Student {
    private int group;
    private double avgScore;
    private int gradeBookNumber;

    Student(int group, double avgScore, int gradeBookNumber) {
        this.group = group;
        this.avgScore = avgScore;
        this.gradeBookNumber = gradeBookNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", avgScore=" + avgScore +
                ", gradeBookNumber=" + gradeBookNumber +
                '}';
    }
}
