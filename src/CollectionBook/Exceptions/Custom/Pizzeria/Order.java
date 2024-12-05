package CollectionBook.Exceptions.Custom.Pizzeria;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private boolean isOrderLocked;

    public Order() {
        this.items = new ArrayList<>();
        isOrderLocked=false;
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
        if(isOrderLocked){
            throw new OrderLockedException("OrderLockedException");
        }
        if (count > 10) {
            throw new ItemOutOfStockException(item.toString());
        }
        int i;
        for (i = 0; i < items.size(); i++) {
            if (items.get(i).getItem().equals(item)) {
                break;
            }
        }
        if (i < items.size()) {
            items.get(i).setCount(count);
        } else {
            items.add(new OrderItem(item, count));
        }
    }

    public int getPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : items) {
            totalPrice += orderItem.getItem().getPrice();
        }
        return totalPrice;
    }

    public void displayOrder() {
        PrintWriter writer = new PrintWriter(System.out);
        for (int i = 0; i < items.size(); i++) {
            OrderItem orderItem = items.get(i);
            writer.println(String.format("%3d.%-15sx%2d%5d$", i + 1, orderItem.getItem(), orderItem.getCount(), orderItem.getItem().getPrice()));
        }
        writer.println(String.format("%-22s%5s$", "Total:", getPrice()));
        writer.flush();
    }

    public void removeItem(int idx) throws OrderLockedException {
        if(isOrderLocked){
            throw new OrderLockedException("OrderLockedException");
        }
        if (idx < 0 || idx >= items.size()) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        items.remove(idx);
    }

    public void lock() throws EmptyOrderException {
        if(items.size()==0){
            throw new EmptyOrderException("EmptyOrderException");
        }
        isOrderLocked=true;
    }
}
