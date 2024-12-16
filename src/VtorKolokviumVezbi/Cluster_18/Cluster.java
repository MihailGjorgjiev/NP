package VtorKolokviumVezbi.Cluster_18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster<T extends IdentifiablePoints> {
    private List<T> elements;

    public Cluster() {
        elements = new ArrayList<>();
    }

    public void addItem(T element) {
        elements.add(element);
    }

    public void near(long id, int top) {

        T point = elements.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);

        List<T> collect = elements.stream()
                .filter(p->p.getId() != id)
                .sorted(Comparator.comparing(t -> t.distance(point)))
                .limit(top)
                .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            T el=collect.get(i);
            System.out.println(String.format("%d. %d -> %.3f",i+1,el.getId(),point.distance(el)));
        }
    }
}
