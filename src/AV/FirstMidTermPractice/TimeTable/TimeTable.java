package AV.FirstMidTermPractice.TimeTable;





import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TimeTable {
    List<LocalTime> times;

    public TimeTable() {
        this.times=new ArrayList<>();
    }

    void readTimes(InputStream inputStream) throws UnsupportedFormatException, InvalidTimeException {
        Scanner scanner=new Scanner(inputStream);
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String[] parts=line.split("\\s+");
            for(String timestamp:parts){
                String regex;
                if(timestamp.contains(":")){
                    regex=":";
                } else if (timestamp.contains(".")) {
                    regex="\\.";
                }else {
                    throw new UnsupportedFormatException(timestamp);
                }
                String[] timeParts=timestamp.split(regex);

                int hours=Integer.parseInt(timeParts[0]);
                int minutes=Integer.parseInt(timeParts[1]);

                if(hours<0 || hours>23 || minutes<0 || minutes>59){
                    throw new InvalidTimeException(timestamp);
                }
                times.add(LocalTime.of(hours,minutes));
            }
        }
        Collections.sort(times);
    }
    private String toString24(){
        StringBuilder sb=new StringBuilder();
        for (LocalTime time:times){
            sb.append(time.toString()).append("\n");
        }
        return sb.toString();
    }

    private String toStringAMPM(){
        StringBuilder sb=new StringBuilder();
        for (LocalTime time:times){
            String timeString;
            if(time.getHour()==0){
                timeString=time.plusHours(12).toString() +"AM";
            }else if(time.getHour()<12){
                timeString=time.toString() +"AM";
            }else if(time.getHour()==12){
                timeString=time.toString() +"PM";
            }else{
                timeString=time.minusHours(12).toString() +"PM";
            }
            sb.append(timeString).append("\n");
        }
        return sb.toString();
    }
    public void writeTimes(OutputStream outputStream,TimeFormat timeFormat){
        PrintWriter writer=new PrintWriter(outputStream);
        if(timeFormat==TimeFormat.FORMAT_24){
            writer.write(toString24());
        }else {
            writer.write(toStringAMPM());
        }
        writer.flush();
    }
}
