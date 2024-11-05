package PrvKolokviumVezbi.WeatherStation_14;

import java.util.Date;

public class WeatherReport {
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
        this.date = (Date) date.clone();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getWind() {
        return wind;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getVisibility() {
        return visibility;
    }

    public Date getDate() {
        return date;
    }
}
