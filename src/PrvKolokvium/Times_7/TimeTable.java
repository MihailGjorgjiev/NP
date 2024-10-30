package PrvKolokvium.Times_7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TimeTable {
    ArrayList<Time> timesList;

    public TimeTable() {
        timesList = new ArrayList<>();
    }

    public void readTimes(InputStream inputStream) throws IOException, UnsupportedFormatException, InvalidTimeException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] times = line.split("\\s+");
                for (String time : times) {
                    String regex;

                    if (time.contains(":")) {
                        regex = ":";
                    } else if (time.contains(".")) {
                        regex = "\\.";
                    } else {
                        throw new UnsupportedFormatException(time);
                    }

                    String[] parts = time.split(regex);
                    int hours = Integer.parseInt(parts[0]);
                    int minutes = Integer.parseInt(parts[1]);
                    if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                        throw new InvalidTimeException(time);
                    }
                    timesList.add(new Time(hours, minutes));
                }
            }
        }
    }

    public void writeTimes(OutputStream outputStream, TimeFormat timeFormat) throws IOException {

        try(PrintWriter writer = new PrintWriter(outputStream)) {
            Collections.sort(timesList);
            for (Time time : timesList) {
                writer.println(time.toString(timeFormat));
            }
            writer.flush();
        }

    }

}
