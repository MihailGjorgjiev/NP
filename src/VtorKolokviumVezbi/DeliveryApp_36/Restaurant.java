package VtorKolokviumVezbi.DeliveryApp_36;

public class Restaurant {
    private String id;
    private String name;
    private Location location;

    public Restaurant(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "ID: "+id+" Name: "+name;
    }
}
