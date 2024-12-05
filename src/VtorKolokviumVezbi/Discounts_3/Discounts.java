package VtorKolokviumVezbi.Discounts_3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    private List<Store> stores;

    public Discounts() {
        stores=new ArrayList<>();
    }

    public int readStores(InputStream inputStream){
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

        stores=reader.lines()
                .map(line->{
                    String[] splitLine = line.trim().split("\\s+");
                    String name=splitLine[0];
                    Store store=new Store(name);
                    for (int i = 1; i < splitLine.length; i++) {
                        store.addItem(new Item(splitLine[i]));
                    }
                    return store;
                })
                .collect(Collectors.toList());

        return stores.size();
    }
    public List<Store> byAverageDiscount(){
        return stores.stream().sorted(Comparator.comparing(Store::averageDiscount).reversed()).collect(Collectors.toList()).subList(0,3);
    }

    public List<Store> byTotalDiscount(){
        return stores.stream().sorted(Comparator.comparing(Store::totalDiscount)).collect(Collectors.toList()).subList(0,3);
    }
}