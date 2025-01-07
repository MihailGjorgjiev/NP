package CollectionBook.Streams.CoronavirusApp;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String id) {
        super(String.format("User with id %s already exists",id));
    }
}
