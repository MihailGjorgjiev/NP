package VtorKolokviumVezbi.Faculty_28;

import java.util.Objects;

public class Grade {
    private String courseName;
    private int grade;

    public Grade(String courseName, int grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getGrade() {
        return grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return grade == grade1.grade && Objects.equals(courseName, grade1.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, grade);
    }
}
