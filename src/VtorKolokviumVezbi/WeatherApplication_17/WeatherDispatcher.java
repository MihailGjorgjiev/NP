package VtorKolokviumVezbi.WeatherApplication_17;

public class WeatherDispatcher {
    private WeatherReport pastReport;
    private WeatherReport currentReport;
    private boolean isForecastDisplay;
    private boolean isCurrentConditionsDisplay;

    public WeatherDispatcher() {
        this.pastReport=new WeatherReport(0,0,0);
        this.currentReport=new WeatherReport(0,0,0);
        this.isForecastDisplay=true;
        this.isCurrentConditionsDisplay=true;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        pastReport=currentReport;
        currentReport=new WeatherReport(temperature, humidity, pressure);
        System.out.println(toString());
    }

    public void register(Display display){
        if(display instanceof CurrentConditionsDisplay){
            isCurrentConditionsDisplay=true;
        }
        if(display instanceof ForecastDisplay){
            isForecastDisplay=true;
        }
    }
    public void remove(Display display){
        if(display instanceof CurrentConditionsDisplay){
            isCurrentConditionsDisplay=false;
        }
        if(display instanceof ForecastDisplay){
            isForecastDisplay=false;
        }
    }

    @Override
    public String toString() {
        String newLine="\n";
        StringBuilder sb=new StringBuilder();

        if(isCurrentConditionsDisplay){
            sb.append(String.format("Temperature: %.1fF",currentReport.getTemperature())).append(newLine);
            sb.append(String.format("Humidity: %.1f%%",currentReport.getHumidity())).append(newLine);
        }
        if(isForecastDisplay){
            String forecast="";
            switch (currentReport.compareTo(pastReport)){
                case 1:
                    forecast="Improving";
                    break;
                case -1:
                    forecast="Cooler";
                    break;
                case 0:
                    forecast="Same";
                    break;
            }
            sb.append(String.format("Forecast: %s",forecast)).append(newLine);
        }

        return sb.toString();
    }
}
