package CollectionBook.ReadWrite.PrintWriter.CheckIn;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LogElement implements Comparable<LogElement> {
    private String name;
    private LocalDateTime loginDateTime;
    private LocalDateTime logoutDateTime;

    public LogElement(String input) throws InvalidCheckInTimes {
        String[] parts = input.split("\\s+");

        this.name=parts[0];
        String loginTimestamp=parts[1];
        String logoutTimestamp=parts[2];
        if(!isValidDateTime(loginTimestamp)){
            throw new InvalidCheckInTimes(loginTimestamp);
        }
        if(!isValidDateTime(logoutTimestamp)){
            throw new InvalidCheckInTimes(logoutTimestamp);
        }
        loginDateTime=stringToDateTime(loginTimestamp);
        logoutDateTime=stringToDateTime(logoutTimestamp);
    }
    private static LocalDateTime stringToDateTime(String timestamp){
        String[] timeParts=timestamp.split("-");
        String[] date;
        String[] time;
        if(timeParts[0].contains(".")){
            date=timeParts[0].split("\\.");
        }else {
            date=timeParts[0].split("/");
        }

        if(timeParts[1].contains(".")){
            time=timeParts[1].split("\\.");
        }else {
            time=timeParts[1].split(":");
        }

        int day= Integer.parseInt(date[0]);
        int month= Integer.parseInt(date[1]);
        int year= Integer.parseInt(date[2]);

        int hour=Integer.parseInt(time[0]);
        int minute=Integer.parseInt(time[1]);

        return LocalDateTime.of(year,month,day,hour,minute);
    }

    private static boolean isValidDateTime(String timestamp){
        String[] timeParts=timestamp.split("-");

        String date=timeParts[0];
        String time=timeParts[1];

        boolean isDateValid=false;
        boolean isTimeValid=false;
        if(date.split("/").length == 3 || date.split("\\.").length == 3){
            isDateValid=true;
        }
        if(time.split(":").length == 2 || time.split("\\.").length == 2){
            isTimeValid=true;
        }
        return isDateValid && isTimeValid;
    }

    public long getTotalMinutes(){
        Duration d=Duration.between(loginDateTime,logoutDateTime);
        return d.toMinutes();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(LocalDateTime loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public LocalDateTime getLogoutDateTime() {
        return logoutDateTime;
    }

    public void setLogoutDateTime(LocalDateTime logoutDateTime) {
        this.logoutDateTime = logoutDateTime;
    }

    @Override
    public String toString() {
        return String.format("%-15s%s %s %s %d",name,loginDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),loginDateTime.toLocalTime(),logoutDateTime.toLocalTime(),getTotalMinutes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogElement that = (LogElement) o;
        return Objects.equals(name, that.name) && Objects.equals(loginDateTime, that.loginDateTime) && Objects.equals(logoutDateTime, that.logoutDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, loginDateTime, logoutDateTime);
    }

    @Override
    public int compareTo(LogElement o) {
        return loginDateTime.compareTo(o.loginDateTime);
    }
}


