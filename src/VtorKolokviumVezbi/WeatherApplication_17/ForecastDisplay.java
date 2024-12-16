package VtorKolokviumVezbi.WeatherApplication_17;

public class ForecastDisplay implements Display{
    private WeatherDispatcher dispatcher;

    public ForecastDisplay(WeatherDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}
