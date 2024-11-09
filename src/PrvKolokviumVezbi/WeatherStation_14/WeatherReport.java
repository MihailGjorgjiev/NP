package PrvKolokviumVezbi.WeatherStation_14;

import java.util.Date;

public class WeatherReport{
    private float temperature;
    private float wind;
    private float humidity;
    private float visibility;
    private Date date;

    public WeatherReport(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
//        24.6 80.2 km/h 28.7% 51.7 km Tue Dec 17 23:40:15 CET 2013
        sb.append(String.format("%.1f ",temperature));
        sb.append(String.format("%.1f km/h ",wind));
        sb.append(String.format("%.1f%% ",humidity));
        sb.append(String.format("%.1f km ",visibility));
        sb.append(String.format("%s",date.toString().replace("UTC","GMT")));

        return sb.toString();
    }
}