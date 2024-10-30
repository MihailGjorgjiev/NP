package PrvKolokvium.Times_7;

import java.io.IOException;

public class TimesTest {

    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();
        try {
            timeTable.readTimes(System.in);
        } catch (UnsupportedFormatException e) {
            System.out.println("UnsupportedFormatException: " + e.getMessage());
        } catch (InvalidTimeException e) {
            System.out.println("InvalidTimeException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("24 HOUR FORMAT");
            timeTable.writeTimes(System.out, TimeFormat.FORMAT_24);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("AM/PM FORMAT");
        try {
            timeTable.writeTimes(System.out, TimeFormat.FORMAT_AMPM);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

