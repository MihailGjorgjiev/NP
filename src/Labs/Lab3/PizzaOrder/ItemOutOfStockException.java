package Labs.Lab3.PizzaOrder;

public class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(String message) {
        super(message);
    }
}
