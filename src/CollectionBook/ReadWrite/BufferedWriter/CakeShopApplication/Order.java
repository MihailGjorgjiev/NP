package CollectionBook.ReadWrite.BufferedWriter.CakeShopApplication;

import java.util.List;

public class Order {
    private String id;
    List<CakeItem> items;

    public Order(String orderId,List<CakeItem> items) {
        this.id=orderId;
        this.items = items;
    }

    public double getPrice(){
        return items.stream().mapToDouble(CakeItem::getPrice).sum();
    }

    public int getTotalOrderItems(){
        return items.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
