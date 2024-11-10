package Kolokviumi2023.PrvKolokvium.FilterAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterAndSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        if (testCase == 1) { // students
            int studentScenario = Integer.parseInt(sc.nextLine());
            List<Student> students = new ArrayList<>();
            while (n > 0) {

                String line = sc.nextLine();
                String[] parts = line.split("\\s+");
                String id = parts[0];
                List<Integer> grades = Arrays.stream(parts).skip(1).map(Integer::parseInt).collect(Collectors.toList());
                students.add(new Student(id, grades));
                --n;
            }

            if (studentScenario == 1) {
                //TODO filter and sort all students who have at least 8.0 points and are at least 3rd year student
                try {
                    List<Student> result=FilterAndSort.execute(students,s ->s.labAssistantPoints()>=8.0 &&  s.getYear()>=3);
                    for(Student s:result){
                        System.out.println(s);
                    }
                } catch (EmptyResultException e) {
                    System.out.println(e.getMessage());
                }

            } else {
                //TODO filter and sort all students who have passed at least 90% of their total courses with an average grade of at least 9.0
                try {
                    List<Student> result=FilterAndSort.execute(students,s-> (double) s.grades.size() /s.totalCourses()>0.9 && s.average()>=9.0);
                    for(Student s:result){
                        System.out.println(s);
                    }
                } catch (EmptyResultException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else { //integers
            List<Integer> integers = new ArrayList<>();
            while (n > 0) {
                integers.add(Integer.parseInt(sc.nextLine()));
                --n;
            }
            try {
                List<Integer> result=FilterAndSort.execute(integers,num->num%15==0);
                for(Integer i:result){
                    System.out.println(i);
                }
            } catch (EmptyResultException e) {
                System.out.println(e.getMessage());
            }
            //TODO filter and sort all even numbers divisible with 15

        }

    }
}