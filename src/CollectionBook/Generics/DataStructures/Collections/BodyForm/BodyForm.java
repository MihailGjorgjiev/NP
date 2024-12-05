package CollectionBook.Generics.DataStructures.Collections.BodyForm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BodyForm {
    private List<Person> people;

    public BodyForm() {
        this.people = new ArrayList<>();
    }

    public void readData(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        reader.lines().forEach(line -> {
            String[] parts = line.split("\\s+");
            String name = parts[0];
            List<Double> weights = IntStream.range(1, parts.length).mapToDouble(i -> Double.parseDouble(parts[i])).boxed().collect(Collectors.toList());
            people.add(new Person(name, weights));
        });

    }

    public void printByWeight(OutputStream outputStream, int type) {
        PrintWriter writer = new PrintWriter(outputStream);
        List<Person> sortedPeople;
        if (type == 1) {
            sortedPeople = people.stream().sorted((o1, o2) -> (int) (o1.max() - o2.max())).collect(Collectors.toList());
        } else {
            sortedPeople = people.stream().sorted((o1, o2) -> (int) (o1.average() - o2.average())).collect(Collectors.toList());
        }
        for(Person p:sortedPeople){
            writer.println(p);
        }
        writer.flush();
    }
}
