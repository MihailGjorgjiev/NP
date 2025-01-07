package Labs.Lab7.Faculty;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Faculty {
    private List<Record> students;

    public Faculty() {
        students = new ArrayList<>();
    }

    public void addRecord(String studentId, String courseName, int grade, LocalDate timestamp) {
        students.add(new Record(studentId, courseName, grade, timestamp));

    }

    public Map<String, Double> studentsAverageGrade() {
        return students.stream()
                .collect(Collectors.groupingBy(Record::getStudentId, TreeMap::new, Collectors.averagingDouble(Record::getGrade)));
    }

    public Map<String, Double> coursesAverageGrade() {
        return students.stream()
                .filter(student -> student.getGrade() > 5)
                .collect(Collectors.groupingBy(Record::getCourseName, TreeMap::new, Collectors.averagingDouble(Record::getGrade)));
    }

    public Map<String, Long> studentsPassedCoursesCount() {
        return students.stream()
                .filter(student -> student.getGrade() > 5)
                .collect(Collectors.groupingBy(Record::getStudentId, TreeMap::new, Collectors.counting()));
    }

    public Map<String, Long> coursesPassedStudentsCount() {
        return students.stream()
                .filter(student -> student.getGrade() > 5)
                .collect(Collectors.groupingBy(Record::getCourseName, TreeMap::new, Collectors.counting()));
    }

    public Map<String, List<String>> studentsPassedCourses() {
        return students.stream()
                .filter(student -> student.getGrade() > 5)
                .collect(Collectors.groupingBy(Record::getStudentId, TreeMap::new, Collectors.mapping(Record::getCourseName, Collectors.toList())));
    }

    public Map<String, Map<String, Double>> averageGradePerExamSession() {
        return students.stream()
                .filter(student -> student.getGrade() > 5)
                .collect(Collectors.groupingBy(student -> student.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM")),
                        Collectors.groupingBy(Record::getCourseName, TreeMap::new,
                                Collectors.averagingDouble(Record::getGrade))));

    }
}
