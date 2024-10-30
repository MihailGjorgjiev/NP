package PrvKolokvium.Times_7;

public class Time implements Comparable<Time> {
    private int hours;
    private int minutes;


    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Time o) {
        int h = Integer.compare(hours, o.hours);
        return (h == 0) ? Integer.compare(minutes, o.minutes) : h;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String toString(TimeFormat format) {
        String time;
        if (format == TimeFormat.FORMAT_24) {
            time = String.format("%2d:%02d", hours, minutes);
        } else {
            if (hours == 0) {
                time = String.format("%2d:%02d AM", hours + 12, minutes);
            } else if (hours < 12) {
                time = String.format("%2d:%02d AM", hours, minutes);
            }else if (hours == 12) {
                time = String.format("%2d:%02d PM", hours, minutes);
            } else {
                time = String.format("%2d:%02d PM", hours - 12, minutes);
            }
        }
        return time;
    }
}
