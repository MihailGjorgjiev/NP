package CollectionBook.DesignPatterns.PostalOffice;

public class LocalPackage extends Package{
    private boolean priority;
    public LocalPackage(String name, String address, int trackingNumber, int weight,boolean priority) {
        super(name, address, trackingNumber, weight);
        this.priority=priority;
    }

    public boolean isPriority() {
        return priority;
    }

    @Override
    public double getPrice() {
        return priority ? 5:3;
    }

    @Override
    public String format(String indent) {
        return String.format(indent+"L, %s, %s, %d, %d, %s",
                getName(),getAddress(),getTrackingNumber(),getWeight(),isPriority());
    }
}
