package VtorKolokviumVezbi.DeliveryApp_36;

public class Worker {
    private String id;
    private String name;
    private Location location;
    private float earned;

    public Worker(){
        this.earned=0;
    }
    public Worker(String id, String name, Location location) {
        this();
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

    public float getEarned() {
        return earned;
    }

}
