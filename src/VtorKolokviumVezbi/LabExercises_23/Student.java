package VtorKolokviumVezbi.LabExercises_23;

import java.util.List;
import java.util.Objects;

public class Student {
    private String index;
    private List<Integer> points;
    public Student(String index, List<Integer> points) {
        this.index=index;
        this.points=points;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public String toString() {
        String passed=isPassed()?"YES":"NO";
        return String.format("%s %s %.2f",index,passed,pointsSummary());
    }

    public List<Integer> getPoints() {
        return points;
    }

    public double pointsSummary(){
        return getPoints().stream().mapToInt(i->i).sum()/10.0;
    }

    public boolean isPassed(){
        return points.size()>=8;
    }

    public int getYearOfStudy(){
        return 20-Integer.parseInt(index.substring(0,2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(index, student.index) && Objects.equals(points, student.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, points);
    }
}
