package Labs.Lab2.DoubleMatrix;

public class InsufficientElementsException extends Exception {
    public InsufficientElementsException() {
        super("Insufficient number of elements");
    }
}
