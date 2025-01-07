package Labs.Lab7.Faculty;

import java.time.LocalDate;

public class Student {
    private String id;
    private String course;
    private int grade;
    private LocalDate timestamp;

    public Student(String id, String course, int grade, LocalDate timestamp) {
        this.id = id;
        this.course = course;
        this.grade = grade;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }


}
