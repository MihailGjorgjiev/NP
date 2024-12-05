package CollectionBook.Exceptions.Custom.Pizzeria;

public class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(String message) {
        super(message);
    }
}
