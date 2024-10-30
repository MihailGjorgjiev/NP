package PrvKolokvium.ShapesApplication_2;

import java.io.*;
import java.util.*;

class Shape {
    private char type;
    private int size;

    public Shape(char type, int size) {
        this.type = type;
        this.size = size;
    }

    public char getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public double getArea() {
        switch (type) {
            case 'S':
                return size * size;
            case 'C':
                return size * size * Math.PI;
            default:
                return 0;
        }
    }


}

class Canvas implements Comparable<Canvas> {
    private String id;
    private List<Shape> shapes;

    public Canvas(String id, List<Shape> shapes) {
        this.id = id;
        this.shapes = shapes;
    }

    public String getId() {
        return id;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public int compareTo(Canvas o) {
        return (int) (this.shapes.stream().mapToDouble(sh -> sh.getArea()).sum() - o.shapes.stream().mapToDouble(sh -> sh.getArea()).sum());
    }
}

public class ShapesApplication {

    private double maxArea;
    private List<Canvas> canvases;

    public ShapesApplication(double maxArea) {
        this.maxArea = maxArea;
        canvases = new ArrayList<>();
    }

    void readCanvases(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split("\\s+");
                String id = parts[0];
                parts = Arrays.copyOfRange(parts, 1, parts.length);
                List<Shape> shapes = new ArrayList<>();

                for (int i = 0; i < parts.length; i += 2) {
                    char type = parts[i].toCharArray()[0];
                    int size = Integer.parseInt(parts[i + 1]);
                    Shape shape = new Shape(type, size);
                    shapes.add(shape);
                }

                try {
                    if (shapes.stream().anyMatch(s -> s.getArea() > maxArea)) {
                        throw new IrregularCanvasException(String.format("Canvas %s has a shape with area larger than %.02f", id, maxArea));
                    }
                    canvases.add(new Canvas(id, shapes));
                } catch (IrregularCanvasException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void printCanvases(OutputStream outputStream) throws IOException {
        Collections.sort(canvases, Collections.reverseOrder());
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (Canvas c : canvases) {
                String canvasId = c.getId();
                int totalShapes = c.getShapes().size();
                int numberCircles = (int) c.getShapes().stream().filter(s -> s.getType() == 'C').count();
                int numberSquares = (int) c.getShapes().stream().filter(s -> s.getType() == 'S').count();
                Optional<Double> minArea = c.getShapes().stream().min(new ShapeComparator()).map(s -> s.getArea());
                Optional<Double> maxArea = c.getShapes().stream().max(new ShapeComparator()).map(s -> s.getArea());
                OptionalDouble averageArea = c.getShapes().stream().mapToDouble(s -> s.getArea()).average();

                String output = String.format("%s %d %d %d %.02f %.02f %.02f", canvasId, totalShapes, numberCircles, numberSquares, minArea.orElse(0.0), maxArea.orElse(0.0), averageArea.orElse(0.0));
                writer.write(output);
                writer.newLine();
            }
        }
    }

    private class IrregularCanvasException extends Exception {
        public IrregularCanvasException(String message) {
            super(message);
        }
    }

    private class ShapeComparator implements Comparator<Shape> {

        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    }
}
