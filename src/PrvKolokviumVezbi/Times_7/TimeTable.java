package PrvKolokviumVezbi.Times_7;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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
                        throw new UnsupportedFormatException(t);
                    }
                    int[] timestamp = Arrays.stream(t.split(regex)).mapToInt(Integer::parseInt).toArray();

                    times.add(LocalTime.of(timestamp[0], timestamp[1]));
                } catch (UnsupportedFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void writeTimes(OutputStream outputStream, TimeFormat format) throws IOException {
        if (format == TimeFormat.FORMAT_24) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for (LocalTime time : times) {
                    writer.write(String.format("%s", time));
                    writer.newLine();
                }
                writer.flush();
            }
        }
        if (format == TimeFormat.FORMAT_AMPM) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for (LocalTime time : times) {
                    if (time.getHour() == 0) {
                        writer.write(String.format("%s AM", time.plusHours(12)));
                    } else if (time.getHour() < 12) {
                        writer.write(String.format("%s AM", time));
                    } else if (time.getHour() == 12) {
                        writer.write(String.format("%s PM", time));
                    } else {
                        writer.write(String.format("%s PM", time.minusHours(12)));
                    }
                    writer.newLine();
                }

                writer.flush();
            }
        }
//        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
//            if (format == TimeFormat.FORMAT_24) {
//                for (LocalTime time : times) {
//                    writer.write(String.format("%s", time));
//                    writer.newLine();
//                }
//            }else {
//                for (LocalTime time:times){
//                    if(time.getHour() == 0){
//                        writer.write(String.format("%s AM",time.plusHours(12)));
//                    } else if (time.getHour() < 12) {
//                        writer.write(String.format("%s AM",time));
//                    }else if (time.getHour() == 12) {
//                        writer.write(String.format("%s PM", time));
//                    }else {
//                        writer.write(String.format("%s PM",time.minusHours(12)));
//                    }
//                    writer.newLine();
//                }
//            }
//            writer.flush();
//        }
    }
}