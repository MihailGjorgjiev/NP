package VtorKolokviumVezbi.WeatherApplication_17;

public class CurrentConditionsDisplay implements Display{
    private WeatherDispatcher dispatcher;

    public CurrentConditionsDisplay(WeatherDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}
