package CollectionBook.Generics.DataStructures.Collections.BodyForm;

import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private List<Double> weights;

    public Person(String name, List<Double> weights) {
        this.name = name;
        this.weights = weights;
    }

    public String getName() {
        return name;
    }

    public List<Double> getWeights() {
        return weights;
    }
    public double max(){
        return weights.stream().max(Double::compareTo).orElse(0.0);
    }
    public double average(){
        return weights.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public String toString() {
        return name + " MAX : " +
                String.format("%.2f kg,", max()) +
                String.format(" AVG : %.2f kg", average());
    }

}
