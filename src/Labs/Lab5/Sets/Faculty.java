package Labs.Lab5.Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Faculty {
    private Map<String, Student> studentsMap;

    public Faculty() {
        studentsMap = new TreeMap<>();
    }

    public void addStudent(String id, List<Integer> grades) throws StudentExistsException {
        Student student = new Student(id, grades);
        if (studentsMap.containsKey(id)) {
            throw new StudentExistsException(String.format("Student with ID %s already exists", id));
        }
        studentsMap.put(id, student);
    }

    public void addGrade(String id, int grade) {
        studentsMap.get(id).addGrade(grade);
    }

    public Set<Student> getStudentsSortedByAverageGrade() {
        return studentsMap.values().stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
                                Student::averageGrade, Comparator.reverseOrder()).
                        thenComparing(Student::numberPassedSubjects, Comparator.reverseOrder()).
                        thenComparing(Student::getId, Comparator.reverseOrder()))));
    }

    public Set<Student> getStudentsSortedByCoursesPassed() {
        return studentsMap.values().stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
                                Student::numberPassedSubjects, Comparator.reverseOrder()).
                        thenComparing(Student::averageGrade, Comparator.reverseOrder()).
                        thenComparing(Student::getId, Comparator.reverseOrder()))));
    }

}
