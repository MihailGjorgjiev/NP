package Labs.Lab5.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String id;
    private List<Integer> grades;

    public Student(String id, List<Integer> grades) {
        this.id = id;
        this.grades = new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double averageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public int numberPassedSubjects() {
        return (int) grades.stream()
                .filter(grade -> grade > 5)
                .count();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
