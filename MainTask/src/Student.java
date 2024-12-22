
public class Student {
    private String group;
    private double avgScore;
    private int gradeBookNumber;

    Student(String group, double avgScore, int gradeBookNumber) {
        this.group = group;
        this.avgScore = avgScore;
        this.gradeBookNumber = gradeBookNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getGradeBookNumber() {
        return gradeBookNumber;
    }

    public void setGradeBookNumber(int gradeBookNumber) {
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


