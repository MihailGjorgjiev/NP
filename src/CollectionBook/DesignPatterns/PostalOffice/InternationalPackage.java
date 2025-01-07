package CollectionBook.DesignPatterns.PostalOffice;

public class InternationalPackage extends Package{
    private String region;

    public InternationalPackage(String name, String address, int trackingNumber, int weight,String region) {
        super(name, address, trackingNumber, weight);
        this.region=region;
    }

    @Override
    public double getPrice() {
        return getWeight()*1.5;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String format(String indent) {
        return String.format(indent+"I, %s, %s, %d, %d, %s",
                getName(),getAddress(),getTrackingNumber(),getWeight(),getRegion());
    }
}
