package VtorKolokviumVezbi.Airports_15;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    private String from;
    private String to;
    private int time;
    private int duration;

    public Flight(String from, String to, int time, int duration) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.duration = duration;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        LocalTime startTime=LocalTime.ofSecondOfDay(time* 60L);
        LocalTime endTime=LocalTime.ofSecondOfDay(((time+duration)%1440)* 60L);
        Duration duration = Duration.between(startTime, endTime);
        if(duration.isNegative()){
            duration=duration.plusDays(1);
        }
        int hours=duration.toHoursPart();
        int minutes=duration.toMinutesPart();
        StringBuilder sb=new StringBuilder().append(String.format("%s-%s %s-%s",from,to,startTime,endTime));
        if(endTime.isBefore(startTime)){
            sb.append(" +1d");
        }
        sb.append(String.format(" %dh%02dm",hours,minutes));

        return sb.toString();

    }

}
