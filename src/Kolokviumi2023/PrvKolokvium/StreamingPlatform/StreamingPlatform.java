package Kolokviumi2023.PrvKolokvium.StreamingPlatform;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class StreamingPlatform {
    private List<Item> items;

    public StreamingPlatform() {
        this.items = new ArrayList<>();
    }

    public void addItem(String data) {
        if(data.split(";").length == 3){
            items.add(new MovieItem(data));
        }else {
            items.add(new SeriesItem(data));
        }
    }

    public void listAllItems(OutputStream os){
        PrintWriter writer=new PrintWriter(os);

        items.sort((o1, o2) -> Double.compare(o2.getRating(), o1.getRating()));

        for(Item item:items){
            writer.println(item);
            writer.flush();
        }
        writer.close();
    }

    public void listFromGenre(String genre, OutputStream os){
        PrintWriter writer=new PrintWriter(os);
        items.sort((o1, o2) -> Double.compare(o2.getRating(), o1.getRating()));

        List<Item> itemsQuery=items.stream().filter(i->i.getGenre().contains(genre)).collect(Collectors.toList());
        for(Item item:itemsQuery){
            writer.println(item);
            writer.flush();
        }
        writer.close();
    }
}

