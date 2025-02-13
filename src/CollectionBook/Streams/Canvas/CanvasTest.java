package CollectionBook.Streams.Canvas;

public class CanvasTest {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        System.out.println(" READ SHAPES AND EXCEPTIONS TESTING ");
        canvas.readShapes(System.in);

        System.out.println(" BEFORE SCALING ");
        canvas.printAllShapes(System.out, true);
        canvas.scaleShapes(" 123456 ", 1.5);
        System.out.println(" AFTER SCALING ");
        canvas.printAllShapes(System.out, false);

        System.out.println(" PRINT BY USER ID TESTING ");
        canvas.printByUserId(System.out);

        System.out.println(" PRINT STATISTICS ");
        canvas.statistics(System.out);
    }
}
