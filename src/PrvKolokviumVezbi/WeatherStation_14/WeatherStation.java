package PrvKolokviumVezbi.WeatherStation_14;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherStation {
    List<WeatherReport> reports;
    int days;

    public WeatherStation(int n) {
        this.days = n;
        this.reports = new ArrayList<>();
    }

    private boolean isTimeDiffLessThan(Date date1, Date date2, long timeDiff) {
        long dateTimeDiff = Math.abs(date1.getTime() - date2.getTime());
        return dateTimeDiff<=timeDiff;
    }

    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
        long twoAndAHalfMinutes = (long) (2.5 * 60 * 1000);//2.5 min in seconds in milliseconds
        long nDays = (long) days * 24 * 60 * 60 * 1000;
        for (WeatherReport report : reports) {
//            long timeDiff = Math.abs(date.getTime() - report.getDate().getTime());
            if (isTimeDiffLessThan(date, report.getDate(), twoAndAHalfMinutes)){
                return;
            }
        }
        for (int i = reports.size() - 1; i >= 0; i--) {
            if (!isTimeDiffLessThan(date,reports.get(i).getDate(),nDays)){
                reports.remove(i);
            }
        }
        reports.add(new WeatherReport(temperature, wind, humidity, visibility, date));
    }
    public int total(){
        return reports.size();
    }

    public void status(Date from, Date to){
        List<WeatherReport> filteredReports = reports.stream().filter(r -> r.getDate().compareTo(from) >= 0 && r.getDate().compareTo(to) <= 0).collect(Collectors.toList());
        if(filteredReports.size() == 0){
            throw new RuntimeException();
        }
        Collections.sort(filteredReports, new Comparator<WeatherReport>() {
            @Override
            public int compare(WeatherReport o1, WeatherReport o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        StringBuilder reportBuilder=new StringBuilder();
        for (WeatherReport r:filteredReports){
            reportBuilder.append(r).append("\n");
        }
        System.out.print(reportBuilder.toString());
        double temp=filteredReports.stream().mapToDouble(WeatherReport::getTemperature).average().orElse(0);
        System.out.println(String.format("Average temperature: %.2f",temp));
    }

}