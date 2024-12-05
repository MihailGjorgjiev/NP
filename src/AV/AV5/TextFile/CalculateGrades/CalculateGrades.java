package AV.AV5.TextFile.CalculateGrades;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CalculateGrades {
    static final String FILE_NAME="src/AV/AV5/TextFile/CalculateGrades/grades.txt";

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Student> students=null;
        try {
            students=loadStudents(new FileInputStream((FILE_NAME)));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        Collections.sort(students);

        for(Student student:students){
            System.out.println(String.format("%s %s %c",student.getFirstName(),
                    student.getLastName(),student.getGrade()));
        }
        int[] gradeDistribution=findGradeDistribution(students);
        String outputFile=scanner.nextLine();

        try (PrintWriter writer=new PrintWriter(new FileWriter(outputFile))){
            for (int i = 0; i < gradeDistribution.length; i++) {
                writer.println(String.format("%c : %d",'A'+i,gradeDistribution[i]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static int[] findGradeDistribution(List<Student> students){
        int[] gradesDistribution=new int[5];
        for (Student student:students){
            gradesDistribution[student.getGrade()-'A']++;
        }
        return gradesDistribution;
    }
    static List<Student> loadStudents(InputStream inputStream) throws IOException {
        ArrayList<Student> students=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line= reader.readLine())!=null){
                Student student=Student.fromString(line);
                students.add(student);
            }
        }
        return students;
    }
}
