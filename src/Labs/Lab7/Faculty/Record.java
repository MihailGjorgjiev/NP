package Labs.Lab7.Faculty;

import java.time.LocalDate;

public class Record {
    String studentId;

    String courseName;

    int grade;

    LocalDate timestamp;

    public Record(String studentId, String courseName, int grade, LocalDate timestamp) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.grade = grade;
        this.timestamp = timestamp;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getGrade() {
        return grade;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String yearAndMonth() {
        return String.format("%04d-%02d", timestamp.getYear(), timestamp.getMonth().getValue());
    }
}