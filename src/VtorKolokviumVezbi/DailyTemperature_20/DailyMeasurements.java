package VtorKolokviumVezbi.DailyTemperature_20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DailyMeasurements {
    private List<Integer> measurements;
    private char type;


    public List<Integer> getMeasurements() {
        return measurements;
    }

    public char getType() {
        return type;
    }

    public DailyMeasurements(String[] measurements) {
        this.measurements=new ArrayList<>();
        if (measurements[0].contains("C")) {
            type = 'C';
        } else {
            type = 'F';
        }
        for (String temp : measurements) {

            this.measurements.add(Integer.parseInt(temp.substring(0, temp.length() - 1)));
        }


    }

    public List<Double> toFahrenheit() {
        if (type == 'F') {
            return measurements.stream().mapToDouble(value -> value).boxed().collect(Collectors.toList());
        }
        return measurements.stream()
                .map(c -> ((double) c * 9) / 5 + 32)
                .collect(Collectors.toList());
    }

    public List<Double> toCelsius() {
        if (type == 'C') {
            return measurements.stream().mapToDouble(value -> value).boxed().collect(Collectors.toList());
        }
        return measurements.stream()
                .map(f -> ((f - 32) * 5) / 9.0)
                .collect(Collectors.toList());
    }


}
