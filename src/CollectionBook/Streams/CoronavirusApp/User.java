package CollectionBook.Streams.CoronavirusApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String id;
    private String name;
    List<ILocation> locations;

    public User() {
        this.locations = new ArrayList<>();
    }

    public User(String id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ILocation> getLocations() {
        return locations;
    }

    public void addLocations(List<ILocation> locations) {
        this.locations.addAll(locations);
    }

    public String complete() {
        return String.format("%s %s", name, id);
    }

    public String hidden() {
        return String.format("%s %s***", name, id.substring(0, 4));
    }

    public int countCloseContacts(User user) {
        return locations.stream()
                .flatMapToInt(l1 -> user.locations.stream()
                        .mapToInt(l2 ->
                                LocationUtils.isDanger(l1, l2) ? 1 : 0))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
