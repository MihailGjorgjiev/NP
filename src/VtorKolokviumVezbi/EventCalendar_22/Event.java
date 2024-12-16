package VtorKolokviumVezbi.EventCalendar_22;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Event {
    private String name;
    private String location;
    private Date date;

    public Event(String name, String location, Date date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        LocalDateTime localDate=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        sb.append(localDate.format(DateTimeFormatter.ofPattern("dd MMM"))).append(", ");
        sb.append(localDate.format(DateTimeFormatter.ofPattern("yyyy"))).append(" ");
        sb.append(localDate.format(DateTimeFormatter.ofPattern("HH:mm")));

        sb.append(String.format(" at %s, %s",location,name));

        return sb.toString();
    }
}
