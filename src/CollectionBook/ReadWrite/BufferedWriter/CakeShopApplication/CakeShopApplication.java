package CollectionBook.ReadWrite.BufferedWriter.CakeShopApplication;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CakeShopApplication {
    List<Order> orders;

    public CakeShopApplication() {
        this.orders = new ArrayList<>();
    }

    public int readCakeOrders(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.lines().map(line -> {
            String[] parts = line.split("\\s+");
            String id = parts[0];
            List<CakeItem> items = new ArrayList<>();
            for (int i = 1; i < parts.length; i += 2) {
                String name = parts[i];
                double price = Double.parseDouble(parts[i + 1]);
                items.add(new CakeItem(name, price));
            }
            return new Order(id, items);
        }).forEach(o -> orders.add(o));

        return orders.size();
    }

    public void printLongestOrder(OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        Optional<Order> max = orders.stream().max((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
        if (max.isPresent()) {
            Order order = max.get();
            writer.write(String.format("%s %d",order.getId(),order.getTotalOrderItems()));
            writer.flush();
        }
    }
}
