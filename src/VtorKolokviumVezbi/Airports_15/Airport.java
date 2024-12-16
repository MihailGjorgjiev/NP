package VtorKolokviumVezbi.Airports_15;

public class Airport {
    private String name;
    private String country;
    private String code;
    private int passengers;

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        String newLine="\n";

        StringBuilder sb=new StringBuilder();

        sb.append(String.format("%s (%s)",name,code)).append(newLine);
        sb.append(country).append(newLine);
        sb.append(passengers);
        return sb.toString();

    }
}
