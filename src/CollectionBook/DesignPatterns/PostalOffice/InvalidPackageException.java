package CollectionBook.DesignPatterns.PostalOffice;

public class InvalidPackageException extends Exception {
    public InvalidPackageException(String line) {
        super(line);
    }
}
