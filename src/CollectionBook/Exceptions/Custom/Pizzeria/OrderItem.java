package CollectionBook.Exceptions.Custom.Pizzeria;

import java.util.Objects;

public class OrderItem {
    private Item item;
    private int count;

    public OrderItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(item, orderItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(item);
    }
}
