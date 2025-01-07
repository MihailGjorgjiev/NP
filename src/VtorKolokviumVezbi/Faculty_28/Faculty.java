package VtorKolokviumVezbi.Faculty_28;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Faculty {
    private Map<String, Student> students;
    private Set<Course> courses;
    private List<String> logs;

    public Faculty() {
        this.students = new HashMap<>();
        this.courses = new TreeSet<>(Comparator.comparing(Course::numberOfStudents).thenComparing(Course::average));
        logs = new ArrayList<>();
    }

    public void addStudent(String id, int yearsOfStudies) {
        students.put(id, new Student(id, yearsOfStudies));
    }

    public void addGradeToStudent(String studentId, int term, String courseName, int grade) throws OperationNotAllowedException {
        students.get(studentId).addGrade(term, courseName, grade);
        boolean courseExists = courses.stream().anyMatch(course -> course.getName().equals(courseName));
        if (!courseExists) {
            courses.add(new Course(courseName));
        }
        for (Course c : courses) {
            if (c.getName().equals(courseName)) {
                c.addGrade(grade);
                c.addStudent(students.get(studentId));
            }
        }
        if (students.get(studentId).isGraduated()) {
            Student student = students.get(studentId);
            logs.add(String.format("Student with ID %s graduated with average grade %.2f in %d years.", student.getIndex(), student.averageGrade(), student.getYearsOfStudies()));
            students.remove(studentId);
        }
    }

    public String getFacultyLogs() {
        return String.join("\n", logs);
    }

    public String getDetailedReportForStudent(String id) {
        String newLine = "\n";
        StringBuilder sb = new StringBuilder();
        Student student = students.get(id);

        sb.append("Student: ").append(student.getIndex()).append(newLine);
        student.getGrades().forEach((key, value) -> {
            sb.append("Term ").append(key).append(newLine);
            sb.append("Courses: ").append(value.size()).append(newLine);
            sb.append("Average grade for term: ").append(String.format("%.2f", value.stream().mapToInt(Grade::getGrade).average().orElse(5.0))).append(newLine);
        });
        sb.append("Average grade: ").append(String.format("%.2f", student.averageGrade())).append(newLine);
        String courses = student.getGrades().values().stream().flatMap(Collection::stream).map(Grade::getCourseName).collect(Collectors.toCollection(TreeSet::new)).stream().collect(Collectors.joining(","));
        sb.append("Courses attended: ").append(courses);

        return sb.toString();
    }

    public void printFirstNStudents(int n) {
        students.values().stream()
                .sorted(
                        Comparator.comparing((Student student) -> student.getGrades().values().stream().mapToInt(Set::size).sum(), Comparator.reverseOrder())
                                .thenComparing(Student::averageGrade, Comparator.reverseOrder())
                                .thenComparing(Student::getIndex, Comparator.reverseOrder())

                )
                .limit(n)
                .forEach(System.out::println);
    }

    public void printCourses() {
        TreeSet<Course> coursesRevamped = new TreeSet<>(Comparator.comparing(Course::numberOfStudents).thenComparing(Course::average).thenComparing(Course::getName));
        coursesRevamped.addAll(courses);
        coursesRevamped.stream()
                .forEach(course -> {
                    String name = course.getName();
                    int totalStudents = course.numberOfStudents();
                    double average = course.average();
                    String s = String.format("%s %d %.2f", name, totalStudents, average);
                    System.out.println(s);
                });

    }
}
