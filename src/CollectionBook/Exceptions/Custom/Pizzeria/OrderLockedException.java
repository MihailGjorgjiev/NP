package CollectionBook.Exceptions.Custom.Pizzeria;

public class OrderLockedException extends Exception {
    public OrderLockedException(String message) {
        super(message);
    }
}
