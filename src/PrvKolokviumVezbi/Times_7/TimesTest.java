package PrvKolokviumVezbi.Times_7;

import java.io.IOException;

public class TimesTest {

    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();
        try {
            timeTable.readTimes(System.in);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("24 HOUR FORMAT");
        try {
            timeTable.writeTimes(System.out, TimeFormat.FORMAT_24);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("AM/PM FORMAT");
        try {
            timeTable.writeTimes(System.out, TimeFormat.FORMAT_24);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}