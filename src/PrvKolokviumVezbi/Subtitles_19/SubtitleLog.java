package PrvKolokviumVezbi.Subtitles_19;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SubtitleLog {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String comment;

    public SubtitleLog(int id, String timestamp,String comment) {
        this.id = id;
        this.comment = comment;

        String[] times=timestamp.split(" --> |,");
        startTime=LocalTime.parse(times[0]).plusNanos((long) (Integer.parseInt(times[1])*1e6));
        endTime=LocalTime.parse(times[2]).plusNanos((long) (Integer.parseInt(times[3])*1e6));
    }

    public int getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        sb.append(id).append("\n");
        String startTimeString=startTime.format(formatter)+String.format(",%03d",startTime.getNano()/1000000);
        String endTimeString=endTime.format(formatter)+String.format(",%03d",endTime.getNano()/1000000);

        String timestamp=startTimeString+" --> "+endTimeString;
        sb.append(timestamp).append("\n");
        sb.append(comment);

        return sb.toString();
    }

    public void shift(int shift) {
        startTime=startTime.plusNanos((long) (shift*1e6));
        endTime=endTime.plusNanos((long) (shift*1e6));
    }
}