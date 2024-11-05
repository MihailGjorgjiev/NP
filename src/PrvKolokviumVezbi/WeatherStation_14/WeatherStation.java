package PrvKolokviumVezbi.WeatherStation_14;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherStation {
    private int days;
    private List<WeatherReport> reports;

    public WeatherStation(int days) {
        this.days = days;
        reports = new ArrayList<>();
    }
    private static boolean isMoreThanFiveDaysAgo(Date date1,Date date2){
        LocalDate localDate1=date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2=date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate2.plusDays(5).isAfter(localDate1);
    }
    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date){
        WeatherReport wr=new WeatherReport(temperature,wind,humidity,visibility,date);
        if(reports.isEmpty()){
            reports.add(wr);
            return;
        }




    }

    public boolean total() {
        return false;
    }

    public void status(Date from, Date to) {

    }
}
