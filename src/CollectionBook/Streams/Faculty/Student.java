package CollectionBook.Streams.Faculty;

import java.util.*;

public abstract class Student {
    private String id;
    private Map<Integer, List<Integer>> gradesByTerm;
    private Set<String> courses;

    public Student() {
        this.id="";
        this.gradesByTerm=new TreeMap<>();
        this.courses=new TreeSet<>();
    }

    public Student(String id) {
        this();
        this.id = id;
    }

    public String getGraduationLog(){
        return String.format("Student with ID %s graduated with average grade %.2f",id,averageGrade());
    }

    public double averageGrade(){
        return gradesByTerm.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(i->i)
                .average()
                .orElse(5.0);
    }

    public double averageGradeForTerm(int term){
        return gradesByTerm.get(term).stream()
                .mapToInt(i->i)
                .average()
                .orElse(5.0);
    }

    public abstract boolean addGrade(int term,String courseName,int grade) throws OperationNotAllowedException;

    public void validate(int term) throws OperationNotAllowedException {
        if(gradesByTerm.containsKey(term)){
            throw new OperationNotAllowedException(String.format("Term %d is not possible for student with ID %s",term,id));
        }

        if(gradesByTerm.get(term).size() == 3){
            throw new OperationNotAllowedException(String.format("Student %s already has 3 grades in term %d",id,term));
        }
    }

    public int countOfCoursesPassed(){
        return gradesByTerm.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public String getDetailedReport(){
        String newLine="\n";
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Student %s",id)).append(newLine);
        gradesByTerm.keySet().forEach(term->sb.append(getTermReport(term)).append(newLine));
        sb.append(String.format("Average grade: %.2f",averageGrade())).append(newLine);
        sb.append(String.format("Courses attended: %s",String.join(",",courses)));

        return sb.toString();
    }

    public  String getShortReport(){
        return String.format("Student %s Courses passed: %d Average grade: %.2f",id,countOfCoursesPassed(),averageGrade());
    }

    public String getTermReport(int term){
        return String.format("Term %d\nCourses: %d\nAverage grade for term: %.2f",term,gradesByTerm.get(term).size(),averageGradeForTerm(term));
    }

    public String getId() {
        return id;
    }

    public Map<Integer, List<Integer>> getGradesByTerm() {
        return gradesByTerm;
    }

    public Set<String> getCourses() {
        return courses;
    }
}
