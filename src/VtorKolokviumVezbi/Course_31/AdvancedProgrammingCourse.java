package VtorKolokviumVezbi.Course_31;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedProgrammingCourse {
    private Map<String, Student> studentsById;

    public AdvancedProgrammingCourse() {
        this.studentsById = new HashMap<>();
    }

    public void addStudent(Student s) {
        studentsById.put(s.getIndex(), s);
    }

    public void updateStudent(String idNumber, String activity, int points){
        Student student = studentsById.getOrDefault(idNumber, null);
        if (student == null) return;

        try {
            student.update(activity, points);
        } catch (Exception ignored) {
        }
    }

    public List<Student> getFirstNStudents(int n) {
        return studentsById.values().stream()
                .sorted(Comparator.comparing(Student::getSummaryPoints, Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> getGradeDistribution() {
        Map<Integer, Integer> distribution = studentsById.values().stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        TreeMap::new,
                        Collectors.summingInt(s -> 1)
                ));
        distribution.putIfAbsent(5,0);
        distribution.putIfAbsent(6,0);
        distribution.putIfAbsent(7,0);
        distribution.putIfAbsent(8,0);
        distribution.putIfAbsent(9,0);
        distribution.putIfAbsent(10,0);

        return distribution;
    }
    public void printStatistics(){
        DoubleSummaryStatistics dss=studentsById.values().stream()
                .filter(s->s.getGrade()>5)
                .mapToDouble(Student::getSummaryPoints)
                .summaryStatistics();

        int count= (int) dss.getCount();
        double min=dss.getMin();
        double avg=dss.getAverage();
        double max=dss.getMax();

        System.out.println(String.format("Count: %d Min: %.2f Average: %.2f Max: %.2f",count,min,avg,max));
    }
}