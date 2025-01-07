package CollectionBook.Streams.Faculty;

import java.util.IntSummaryStatistics;

public class Course {
    private String courseName;
    private IntSummaryStatistics statistics;

    public Course() {
        this.courseName="";
        this.statistics=new IntSummaryStatistics();
    }

    public Course(String courseName) {
        this();
        this.courseName = courseName;
    }

    public void addGrade(int grade){
        statistics.accept(grade);
    }

    @Override
    public String toString() {
        return String.format("%s %d %.2f",courseName,statistics.getCount(),statistics.getAverage());
    }

    public int getStudentsCount(){
        return (int) statistics.getCount();
    }
    public double getCourseAverageGrade(){
        return statistics.getAverage();
    }

    public String getCourseName() {
        return courseName;
    }

    public IntSummaryStatistics getStatistics() {
        return statistics;
    }
}
