package CollectionBook.DesignPatterns.PostalOffice;

public abstract class Package implements Comparable<Package> {
    private String name;
    private String address;
    private int trackingNumber;
    private int weight;

    public Package(String name, String address, int trackingNumber, int weight) {
        this.name = name;
        this.address = address;
        this.trackingNumber = trackingNumber;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public int getWeight(){
        return weight;
    }
    public abstract double getPrice();

    @Override
    public int compareTo(Package o) {
        return Double.compare(o.getPrice(),getPrice());
    }

    public abstract String format(String indent);

    @Override
    public String toString() {
        return format("");
    }
}
