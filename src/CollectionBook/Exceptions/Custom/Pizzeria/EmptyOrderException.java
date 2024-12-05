package CollectionBook.Exceptions.Custom.Pizzeria;

public class EmptyOrderException extends Exception {
    public EmptyOrderException(String message) {
        super(message);
    }
}
