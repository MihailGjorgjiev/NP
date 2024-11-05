package Labs.Lab2.Contacts;

import java.util.Arrays;
import java.util.Comparator;

public class Faculty {
    private String name;
    private Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = students.clone();
    }

    public int countStudentsFromCity(String cityName) {
        return (int) Arrays.stream(students).filter(s -> s.getCity().equals(cityName)).count();
    }

    public Student getStudent(long index) {
        return Arrays.stream(students).filter(s->s.getIndex() == index).findFirst().orElse(null);
    }
    private int getNumberOfContactsOfStudent(Student s){
        return s.getPhoneContacts().length+s.getEmailContacts().length;
    }
    public double getAverageNumberOfContacts(){
        return Arrays.stream(students).mapToInt(this::getNumberOfContactsOfStudent).average().orElse(0);
    }

    public Student getStudentWithMostContacts(){
        int maxContacts= Arrays.stream(students).mapToInt(this::getNumberOfContactsOfStudent).max().orElse(0);
        return Arrays.stream(students).filter(s -> getNumberOfContactsOfStudent(s)== maxContacts).sorted(Comparator.comparingLong(Student::getIndex).reversed()).toArray(Student[]::new)[0];
    }

    @Override
    public String toString() {
        StringBuilder studentBuilder=new StringBuilder();
        for(Student student:students){
            studentBuilder.append(student).append(", ");
        }
        studentBuilder.delete(studentBuilder.length()-2,studentBuilder.length()-1);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"fakultet\":\"").append(name).append("\", \"studenti\":[").append(studentBuilder.toString()).append("]}");
        stringBuilder.deleteCharAt(stringBuilder.length()-3);
        return stringBuilder.toString();
    }
}
