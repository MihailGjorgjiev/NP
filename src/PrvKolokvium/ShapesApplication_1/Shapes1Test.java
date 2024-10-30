package PrvKolokvium.ShapesApplication_1;

import java.io.IOException;

public class Shapes1Test {
    public static void main(String[] args) {
        ShapesApplication shapesApplication = new ShapesApplication();

        System.out.println("===READING SQUARES FROM INPUT STREAM===");
        try {
            System.out.println(shapesApplication.readCanvases(System.in));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("===PRINTING LARGEST CANVAS TO OUTPUT STREAM===");
        try {
            shapesApplication.printLargestCanvasTo(System.out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
