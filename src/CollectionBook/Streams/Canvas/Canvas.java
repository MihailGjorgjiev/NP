package CollectionBook.Streams.Canvas;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Canvas {
    private List<IShape> shapes;

    public Canvas() {
        this.shapes=new ArrayList<>();
    }

    public void readShapes(InputStream is){
        Scanner scanner=new Scanner(is);

        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            try {
                shapes.add(ShapeFactory.createShape(line));
            } catch (InvalidIDException | InvalidDimensionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void scaleShapes(String userID,double coefficient){
        shapes.stream().filter(shape->shape.getID().equals(userID))
                .forEach(shape -> shape.scale(coefficient));
    }

    public void printAllShapes(OutputStream os,boolean ascending){
        Comparator<IShape> shapeComparator=
                Comparator.comparing(IShape::getArea)
                        .thenComparing(IShape::getID);

        if(!ascending){
            shapeComparator=shapeComparator.reversed();
        }

        PrintWriter writer=new PrintWriter(os);
        shapes.stream()
                .sorted(shapeComparator)
                .forEach(writer::println);
        writer.flush();
    }

    public void printByUserId(OutputStream os){
        PrintWriter writer=new PrintWriter(os);
        Comparator<IShape> shapeComparator=
                Comparator.comparing(IShape::getPerimeter)
                        .thenComparing(IShape::getID).reversed();

        Map<String, TreeSet<IShape>> result = shapes.stream()
                .collect(Collectors.groupingBy(
                        IShape::getID,
                        Collectors.toCollection(
                                () -> new TreeSet<>(shapeComparator)
                        )
                ));

        Comparator<Map.Entry<String,TreeSet<IShape>>> entryComparator=
                Comparator.comparing(entry -> entry.getValue().size());

        result.entrySet().stream()
                .sorted(entryComparator.reversed().thenComparing(
                        entry->entry.getValue().stream()
                                .mapToDouble(IShape::getArea).sum()))
                .forEach(entry->{
                    writer.println("Shapes of user: "+entry.getKey());
                    entry.getValue().forEach(writer::println);
                });
        writer.flush();
    }

    public void statistics(OutputStream os){
        PrintWriter writer = new PrintWriter(os);
        writer.println(shapes.stream().mapToDouble(IShape::getArea).summaryStatistics());
        writer.flush();
    }


}
