package PrvKolokviumVezbi.Subtitles_19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Subtitles {
    List<String> ids;
    List<String> times;
    List<String> texts;


    public Subtitles() {
        this.ids = new ArrayList<>();
        this.times = new ArrayList<>();
        this.texts = new ArrayList<>();
    }

    public int loadSubtitles(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int count = 0;
            while (true) {
                count++;
                String testLineOrId = reader.readLine();
                if (testLineOrId == null) break;
                ids.add(testLineOrId);

                String time = reader.readLine();
                times.add(time);
                StringBuilder subtitle = new StringBuilder();
                while (true) {
                    String newLineOrSubtitle = reader.readLine();
                    if (newLineOrSubtitle == null || newLineOrSubtitle.isBlank()) break;
                    subtitle.append(newLineOrSubtitle).append("\n");
                }
                texts.add(subtitle.toString());
            }
            return count;
        }
    }

    public void print() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = ids.size();
            for (int i = 0; i < n; i++) {
                writer.write(ids.get(i));
                writer.newLine();
                writer.write(times.get(i));
                writer.newLine();
                writer.write(texts.get(i));
                writer.newLine();
            }

            writer.flush();

        }
    }

    public void shift(int shift) {

//        long milliToNano= (long) (shift*1e6);
//
//        for(String time:times){
//            String newTime;
//            String[] parts=time.split(" --> ");
//            LocalTime startTime=LocalTime.parse(parts[0].substring(0,8));
//            long currentNanoStartTime= (long) (Long.parseLong(parts[0].substring(9,12))*1e6);
//            startTime=startTime.plusNanos(currentNanoStartTime);
//            startTime=startTime.minusNanos(milliToNano);
//            newTime=startTime.toString().replace(".",",");
//            newTime+=" --> ";
//
//            LocalTime endTime=LocalTime.parse(parts[1].substring(0,8));
//            long currentNanoEndTime= (long) (Long.parseLong(parts[1].substring(9,12))*1e6);
//            endTime=endTime.plusNanos(currentNanoEndTime);
//            endTime=endTime.minusNanos(milliToNano);
//            newTime+=endTime.toString().replace(".",",");
//
//
//            time=newTime;


//    }
    }
}
