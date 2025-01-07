package CollectionBook.DesignPatterns.PostalOffice;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PostOffice {
    private String name;
    private String location;
    private List<Package> packages;

    public PostOffice() {
        this.packages = new ArrayList<>();
    }

    public PostOffice(String name, String location) {
        this();
        this.name = name;
        this.location = location;
    }

    public boolean addPackage(Package p) throws InvalidPackageException {
        if(p.getWeight() <=0){
            throw new InvalidPackageException(p.toString());
        }
        return packages.add(p);
    }

    public void loadPackages(Scanner scanner) throws InvalidPackageException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            if (!parts[0].equals("I") && !parts[0].equals("L")) {
                throw new InvalidPackageException(line);
            }
            int weight = Integer.parseInt(parts[4]);
            if (weight <= 0) {
                throw new InvalidPackageException(line);
            }
            if (parts[0].equals("I")) {
                Package p = new InternationalPackage(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        parts[5]
                );
                packages.add(p);
            }
            if (parts[0].equals("L")) {
                Package p = new LocalPackage(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        parts[5].equals("true")
                );
                packages.add(p);
            }
        }
    }
    public Package mostExpensive(){
        return packages.stream().max(Comparator.naturalOrder()).orElse(null);
    }
    public void printPackages(OutputStream os){
        PrintWriter writer=new PrintWriter(os);
        packages.stream().sorted().forEach(writer::println);
        writer.flush();
    }
}
