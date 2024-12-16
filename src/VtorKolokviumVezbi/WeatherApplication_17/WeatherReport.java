package VtorKolokviumVezbi.WeatherApplication_17;

public class WeatherReport implements Comparable<WeatherReport>{
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherReport(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public int compareTo(WeatherReport o) {
        return Float.compare(pressure,o.pressure);
    }
}
