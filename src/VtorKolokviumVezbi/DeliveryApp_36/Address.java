package VtorKolokviumVezbi.DeliveryApp_36;

public class Address {
    private String name;
    private Location location;

    public Address(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
