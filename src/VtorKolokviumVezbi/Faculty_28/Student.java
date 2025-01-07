package VtorKolokviumVezbi.Faculty_28;

import java.util.*;
import java.util.stream.IntStream;

public class Student {
    private String index;
    private int yearsOfStudies;
    private Map<Integer, Set<Grade>> grades;
    private boolean isGraduated;

    public Student() {
        this.grades = new HashMap<>();
        this.isGraduated=false;
    }

    public Student(String index, int yearsOfStudies) {
        this();
        this.index = index;
        this.yearsOfStudies = yearsOfStudies;
        IntStream.range(1,yearsOfStudies*2+1).forEach(term->grades.putIfAbsent(term,new HashSet<>()));
    }

    public String getIndex() {
        return index;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public int getYearsOfStudies() {
        return yearsOfStudies;
    }

    public int totalGradesPerTerm(int term) {
        return grades.getOrDefault(term, new HashSet<>()).size();
    }

    public Map<Integer, Set<Grade>> getGrades() {
        return grades;
    }

    public void addGrade(int term, String courseName, int grade) throws OperationNotAllowedException {
        if (term>yearsOfStudies*2){
            throw new OperationNotAllowedException(String.format("Term %d is not possible for student with ID %s",term,index));
        }


        if(grades.get(term).size()>=3){
            throw new OperationNotAllowedException(String.format("Student %s already has 3 grades in term %d",index,term));
        }

        Grade gradeObj=new Grade(courseName,grade);
        grades.get(term).add(gradeObj);

        if(grades.values().stream().mapToLong(Collection::size).sum() == yearsOfStudies* 6L){
            isGraduated=true;
        }
    }

    public double averageGrade(){
//        return grades.values().stream().mapToInt(gs->gs.stream().mapToInt(Grade::getGrade).sum()).sum()/(yearsOfStudies*6.0);
        return grades.values().stream().flatMap(Collection::stream).mapToInt(Grade::getGrade).average().orElse(5);
    }

    @Override
    public String toString() {
        int count=grades.values().stream().mapToInt(Set::size).sum();
        return String.format("Student: %s Courses passed: %d Average grade: %.2f",index,count,averageGrade());
    }
}
