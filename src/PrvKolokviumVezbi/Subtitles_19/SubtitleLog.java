package PrvKolokviumVezbi.Subtitles_19;

import java.time.LocalTime;

public class SubtitleLog {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String text;

    public SubtitleLog(int id, LocalTime startTime, LocalTime endTime, String text) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = text;
    }

    public void shiftTime(int milliseconds){
        startTime.plusNanos((long) (milliseconds*1e6));
        endTime.plusNanos((long) (milliseconds*1e6));
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        sb.append(id).append("\n");

        sb.append(startTime.toString()).append(" --> ").append(endTime.toString()).append("\n");

        sb.append(text).append("\n");

        return sb.toString();
    }
}
