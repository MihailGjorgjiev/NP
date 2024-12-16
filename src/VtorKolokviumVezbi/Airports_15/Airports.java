package VtorKolokviumVezbi.Airports_15;

import java.util.*;
import java.util.stream.Collectors;

public class Airports {
    private Map<String,Airport> airports;
    private Map<String, Set<Flight>> flightsFrom;
    private Map<String, Set<Flight>> flightsTo;

    public Airports() {
        this.airports=new HashMap<>();
        this.flightsFrom=new HashMap<>();
        this.flightsTo=new HashMap<>();
    }

    public void addAirport(String name, String country, String code, int passengers){
        Airport airport=new Airport(name, country, code, passengers);
        airports.put(code,airport);
    }

    public void addFlights(String from, String to, int time, int duration){
        Comparator<Flight> flightComparator=
                Comparator.comparing(Flight::getTo)
                        .thenComparing(Flight::getTime)
                        .thenComparing(Flight::getDuration);

        Flight flight=new Flight(from, to, time, duration);

        flightsFrom.putIfAbsent(from,new TreeSet<>(flightComparator));
        flightsTo.putIfAbsent(to,new TreeSet<>(flightComparator));

        flightsFrom.get(from).add(flight);
        flightsTo.get(to).add(flight);
    }

    public void showFlightsFromAirport(String code){
        Airport airport=airports.get(code);
        System.out.println(airport);
        List<Flight> flights = flightsFrom.get(code)
                .stream().collect(Collectors.toList());
        for (int i = 1; i <=flights.size() ; i++) {
            System.out.println(String.format("%d. %s",i,flights.get(i-1)));
        }
    }

    public void showDirectFlightsFromTo(String from, String to){
        List<Flight> flights = flightsFrom.get(from).stream()
                .filter(flight -> flight.getTo().equals(to))
                .collect(Collectors.toList());

        if(flights.isEmpty()){
            System.out.println(String.format("No flights from %s to %s",from,to));
        }else {
            flights.stream().forEach(System.out::println);
        }
    }
    public void showDirectFlightsTo(String to){
        flightsTo.get(to).stream().forEach(System.out::println);
    }


}
