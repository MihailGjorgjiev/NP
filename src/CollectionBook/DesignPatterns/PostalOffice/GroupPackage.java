package CollectionBook.DesignPatterns.PostalOffice;

import java.util.ArrayList;
import java.util.List;

public class GroupPackage extends Package{
    private List<Package> packages;

    public GroupPackage(String name, String address, int trackingNumber) {
        super(name, address, trackingNumber, 0);
        packages=new ArrayList<>();
    }

    @Override
    public double getPrice() {
        return packages.stream().mapToDouble(Package::getPrice).sum()+2;
    }
    public void addPackage(Package p){
        packages.add(p);
    }

    @Override
    public int getWeight() {
        return packages.stream().mapToInt(Package::getWeight).sum();
    }

    @Override
    public String format(String indent) {
        StringBuilder sb= new StringBuilder();
        sb.append(String.format(indent+"G, %d, %d",getTrackingNumber(),getWeight())).append("\n");
        packages.forEach(p->sb.append(p.format(indent+" ")).append("\n"));

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
