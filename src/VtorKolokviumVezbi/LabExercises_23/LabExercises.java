package VtorKolokviumVezbi.LabExercises_23;

import java.util.*;
import java.util.stream.Collectors;

public class LabExercises {
    Map<String,List<Student>> students;

    public LabExercises() {
        students=new TreeMap<>();
    }

    public void addStudent (Student student){
        students.putIfAbsent(student.getIndex(),new ArrayList<>());
        students.get(student.getIndex()).add(student);
    }
    public void printByAveragePoints (boolean ascending, int n){
        Comparator<Student> studentComparator=
                Comparator.comparing(Student::pointsSummary)
                                .thenComparing(Student::getIndex);

        if(!ascending){
            studentComparator=studentComparator.reversed();
        }

        students.values().stream()
                .flatMap(Collection::stream)
                .sorted(studentComparator)
                .limit(n)
                .forEach(System.out::println);
    }

    public List<Student> failedStudents (){
        return students.values().stream()
                .flatMap(Collection::stream)
                .filter(student -> !student.isPassed())
                .sorted(Comparator.comparing(Student::getIndex)
                        .thenComparing(Student::pointsSummary))
                .collect(Collectors.toList());
    }

    public Map<Integer,Double> getStatisticsByYear(){
        return students.values().stream()
                .flatMap(Collection::stream)
                .filter(Student::isPassed)
                .collect(Collectors.groupingBy(Student::getYearOfStudy,Collectors.averagingDouble(Student::pointsSummary)));
    }
}
