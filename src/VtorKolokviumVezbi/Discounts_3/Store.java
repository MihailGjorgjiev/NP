package VtorKolokviumVezbi.Discounts_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<Item> items;
    private String name;

    public Store(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double averageDiscount() {
        return items.stream().mapToDouble(Item::discount).average().orElse(0);
    }

    public double averageDiscountToString() {
        return items.stream().mapToInt(Item::integerDiscount).average().orElse(0);
    }

    public int totalDiscount() {
        return items.stream().mapToInt(Item::absoluteDiscount).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String newLine = "\n";

        sb.append(name).append(newLine);
        sb.append(String.format("Average discount: %.1f%%", averageDiscountToString())).append(newLine);
        sb.append(String.format("Total discount: %d", totalDiscount())).append(newLine);

        List<Item> sortedItems = items.stream().sorted(Comparator.comparing(Item::integerDiscount).reversed().thenComparing(Item::getDiscountPrice,Comparator.reverseOrder())).collect(Collectors.toList());
        for (int i = 0; i < sortedItems.size(); i++) {
            Item item = sortedItems.get(i);
            sb.append(String.format("%2d%% %d/%d", item.integerDiscount(), item.getDiscountPrice(), item.getFullPrice()));
            if (i < sortedItems.size() - 1) {
                sb.append(newLine);
            }
        }
        return sb.toString();
    }
}