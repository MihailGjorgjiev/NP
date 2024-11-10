package PrvKolokviumVezbi.Times_7;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeTable {
    private List<LocalTime> times;

    public TimeTable() {
        times = new ArrayList<>();
    }

    public void readTimes(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String[] timesArray = reader.lines().map(row -> row.split("\\s+")).flatMap(Arrays::stream).toArray(String[]::new);

            for (String t : timesArray) {
                try {
                    String regex;
                    if (t.contains(".")) {
                        regex = "\\.";
                    } else if (t.contains(":")) {
                        regex = ":";
                    } else {
                        throw new UnsupportedFormatException("UnsupportedFormatException: " + t);
                    }
                    int[] timestamp = Arrays.stream(t.split(regex)).mapToInt(Integer::parseInt).toArray();
                    if(!isValidTime(timestamp)){
                        throw new InvalidTimeException("InvalidTimeException: "+t);
                    }
                    times.add(LocalTime.of(timestamp[0], timestamp[1]));
                } catch (UnsupportedFormatException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidTimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            Collections.sort(times);
        }
    }

    private static boolean isValidTime(int[] time) {
        if (time[0] < 0 || time[0] > 23) {
            return false;
        }
        if (time[1] < 0 || time[1] > 59) {
            return false;
        }
        return true;
    }

    public void writeTimes(OutputStream outputStream, TimeFormat format) {
        PrintWriter writer = new PrintWriter(outputStream);
        if (format == TimeFormat.FORMAT_24) {
            for (LocalTime time : times) {
                writer.println(String.format("%5s", time.format(DateTimeFormatter.ofPattern("H:mm"))));
            }
        }
        if (format == TimeFormat.FORMAT_AMPM) {
            for (LocalTime time : times) {
                if (time.getHour() == 0) {
                    writer.println(String.format("%5s AM", time.plusHours(12).format(DateTimeFormatter.ofPattern("H:mm"))));
                } else if (time.getHour() < 12) {
                    writer.println(String.format("%5s AM", time.format(DateTimeFormatter.ofPattern("H:mm"))));
                } else if (time.getHour() == 12) {
                    writer.println(String.format("%5s PM", time.format(DateTimeFormatter.ofPattern("H:mm"))));
                } else {
                    writer.println(String.format("%5s PM", time.minusHours(12).format(DateTimeFormatter.ofPattern("H:mm"))));
                }
            }
        }
        writer.flush();
    }
}