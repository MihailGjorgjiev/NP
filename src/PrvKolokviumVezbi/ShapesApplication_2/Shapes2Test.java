package PrvKolokviumVezbi.ShapesApplication_2;

import java.io.IOException;

public class Shapes2Test {
    public static void main(String[] args) {

        ShapesApplication shapesApplication = new ShapesApplication(10000);

        System.out.println("===READING CANVASES AND SHAPES FROM INPUT STREAM===");
        try {
            shapesApplication.readCanvases(System.in);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("===PRINTING SORTED CANVASES TO OUTPUT STREAM===");
        try {
            shapesApplication.printCanvases(System.out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
