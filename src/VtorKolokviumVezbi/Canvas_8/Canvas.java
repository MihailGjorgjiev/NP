package VtorKolokviumVezbi.Canvas_8;

import java.io.*;
import java.util.*;

public class Canvas {
    private Map<String, List<Shape>> shapes;

    public Canvas() {
        shapes = new HashMap<>();
    }

    private static boolean isIdValid(String id) {
//        return true;
        return id.length() == 6 && id.matches("[a-zA-Z0-9]+");
    }

    public void readShapes(InputStream is) {
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            try {
                int type = scanner.nextInt();
                String id = scanner.next();
                if (!isIdValid(id)) {
                    scanner.nextLine();
                    throw new InvalidIDException(String.format("ID %s is not valid",id));
                }
                shapes.putIfAbsent(id, new ArrayList<>());
                switch (type) {
                    case 1:
                        double radius = scanner.nextDouble();
                        if (radius == 0) {
                            if (shapes.get(id).isEmpty()){
                                shapes.remove(id);
                            }
                            throw new InvalidDimensionException("Dimension 0 is not allowed!");
                        }
                        shapes.get(id).add(new Circle(radius));
                        break;
                    case 2:
                        double side = scanner.nextDouble();
                        if (side == 0) {
                            if (shapes.get(id).isEmpty()){
                                shapes.remove(id);
                            }
                            throw new InvalidDimensionException("Dimension 0 is not allowed!");
                        }
                        shapes.get(id).add(new Square(side));
                        break;
                    case 3:
                        double width = scanner.nextDouble();
                        double height = scanner.nextDouble();
                        if (width == 0 || height == 0) {
                            if (shapes.get(id).isEmpty()){
                                shapes.remove(id);
                            }
                            throw new InvalidDimensionException("Dimension 0 is not allowed!");
                        }
                        shapes.get(id).add(new Rectangle(width, height));
                        break;
                }
            } catch (InvalidIDException e) {
                System.out.println(e.getMessage());
            } catch (InvalidDimensionException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

    }

    public void printAllShapes(OutputStream os) {
        PrintWriter writer = new PrintWriter(os);
        Set<Shape> treeSet = new TreeSet<>(Comparator.comparing(Shape::getUnscaledArea));
        shapes.values().stream()
                .flatMap(Collection::stream)
                .forEach(treeSet::add);

        for (Shape shape : treeSet) {
            writer.println(shape);
        }
        writer.flush();
    }

    public void scaleShapes(String userID, double coef) {
        if(!shapes.containsKey(userID)){
            return;
        }
        shapes.get(userID).stream()
                .forEach(shape -> shape.scale(coef));
    }

    public void printByUserId(OutputStream os) {
        PrintWriter writer = new PrintWriter(os);
        shapes.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getValue().size()*1000-o.getValue().stream().mapToDouble(Shape::getUnscaledArea).sum(),Comparator.reverseOrder()))

                .forEach(stringListEntry -> {
                    writer.println("Shapes of user: " + stringListEntry.getKey());
                    Set<Shape> treeSet = new TreeSet<>(Comparator.comparing(Shape::getPerimeter));
                    stringListEntry.getValue().stream()
                            .forEach(treeSet::add);

                    for (Shape shape : treeSet) {
                        writer.println(shape);
                    }
//                    stringListEntry.getValue().stream().forEach(writer::println);
                });
        writer.flush();


    }

    public void statistics(PrintStream os) {
        PrintWriter writer=new PrintWriter(os);
        DoubleSummaryStatistics stats = shapes.values().stream().
                flatMap(Collection::stream).mapToDouble(Shape::getArea)
                .summaryStatistics();

        writer.println(String.format("count: %d",stats.getCount()));
        writer.println(String.format("sum: %.2f",stats.getSum()));
        writer.println(String.format("min: %.2f",stats.getMin()));
        writer.println(String.format("average: %.2f",stats.getAverage()));
        writer.println(String.format("max: %.2f",stats.getMax()));
        writer.flush();
    }
}
