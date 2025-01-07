package VtorKolokviumVezbi.Faculty_28;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private String name;
    private List<Student> students;
    private List<Integer> grades;

    public Course(String name) {
        this.name = name;
        students=new ArrayList<>();
        grades=new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public int numberOfStudents(){
        return students.size();
    }

    public double average(){
        return grades.stream().mapToInt(i->i).average().orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
