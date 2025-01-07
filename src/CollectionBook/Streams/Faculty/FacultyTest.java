package CollectionBook.Streams.Faculty;

import java.util.Scanner;

public class FacultyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Faculty faculty = new Faculty();
        for (int i = 1; i <= 10; i++) {
            faculty.addStudent(" student " + i,
                    ((i % 2) == 1 ? 3 : 4));
            int courseCounter = 1;
            for (int j = 1; j <= ((i % 2 == 1) ? 6 : 8); j++) {
                for (int k = 1; k <= ((j % 2 == 1) ? 2 : 3);
                     k++) {
                    int grade = sc.nextInt();
                    try {
                        faculty.addGradeToStudent(" student " + i,
                                j,
                                (" course " + courseCounter),
                                grade);
                    } catch (OperationNotAllowedException e) {
                        System.out.println(e.getMessage());
                    }
                    ++courseCounter;
                }
            }
        }
        for (int i = 11; i < 15; i++) {
            faculty.addStudent(" student " + i,
                    ((i % 2) == 1 ? 3 : 4));
            int courseCounter = 1;
            for (int j = 1; j <= ((i % 2 == 1) ? 6 : 8); j++) {
                for (int k = 1; k <= 3; k++) {
                    int grade = sc.nextInt();
                    try {
                        faculty.addGradeToStudent(" student " + i,
                                j,
                                (" course " + courseCounter),
                                grade);
                    } catch (OperationNotAllowedException e) {
                        System.out.println(e.getMessage());
                    }
                    ++courseCounter;
                }
            }
        }
        System.out.println(" LOGS ");
        System.out.println(faculty.getFacultyLogs());
        System.out.println(" DETAILED REPORT FOR STUDENT ");
        System.out.println(
                faculty.getDetailedReportForStudent(" student2 "));
        try {
            System.out.println(
                    faculty.getDetailedReportForStudent(
                            " student11 "));
            System.out.println(
                    " The graduated students should be deleted !!! ");
        } catch (NullPointerException e) {
            System.out.println(
                    " The graduated students are really deleted ");
        }
        System.out.println(" FIRST N STUDENTS ");
        faculty.printFirstNStudents(10);
        System.out.println("COURSES");
        faculty.printCourses();
    }
}
