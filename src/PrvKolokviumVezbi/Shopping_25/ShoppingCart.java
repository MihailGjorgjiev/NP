package PrvKolokviumVezbi.Shopping_25;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {
    List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(String itemData) throws InvalidOperationException {
        String[] parts = itemData.split(";");
        String id = parts[1];
        String name = parts[2];
        double price = Double.parseDouble(parts[3]);
        if (parts[0].equals("WS")) {
            int qty = Integer.parseInt(parts[4]);
            if (qty == 0) {
                throw new InvalidOperationException(String.format("The quantity of the product with id %s can not be 0.", id));
            }
            items.add(new WholeProduct(id, name, price, qty));
        } else {
            double qty = Double.parseDouble(parts[4]);
            if (qty == 0) {
                throw new InvalidOperationException(String.format("The quantity of the product with id %s can not be 0.", id));
            }
            items.add(new PieceProduct(id, name, price / 1000.0, qty));
        }
    }

    public void printShoppingCart(OutputStream os) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            items.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() * o1.getQuantity() - o2.getPrice() * o2.getQuantity());
                }
            }.reversed());

            for (Product product : items) {
                writer.write(String.format("%s - %.2f\n", product.getId(), product.getPrice() * product.getQuantity()));
            }
            writer.flush();
        }
    }

    public void blackFridayOffer(List<Integer> discountItems, OutputStream os) throws IOException, InvalidOperationException {
        if (discountItems.isEmpty()) {
            throw new InvalidOperationException("There are no products with discount.");
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {

            for (int i = 0; i < discountItems.size(); i++) {
                String id = String.valueOf(discountItems.get(i));
                Product discounted = items.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
                if (discounted == null) continue;

                double saved = discounted.getPrice() * discounted.getQuantity() * 0.1;
                writer.write(String.format("%s - %.2f\n", discounted.getId(), saved));


            }
        }
    }


}
