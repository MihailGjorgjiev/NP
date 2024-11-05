package PrvKolokviumVezbi.Shapes_6;

import java.util.ArrayList;

public class Canvas{

    ArrayList<Shape> shapes;

    public Canvas() {
        shapes= new ArrayList<>();
    }

    public void add(String id,Color color,float radius){
        Circle circle=new Circle(id,color,radius);
        if(shapes.isEmpty()){
            shapes.add(circle);
            return;
        }

        Shape before=new Circle("temp",Color.RED,0);
        for(Shape shape:shapes){
            Stackable stackableShape=(Stackable) shape;
            Stackable stackableBefore=(Stackable) before;
            if(stackableBefore.weight()< stackableShape.weight() && stackableShape.weight()< circle.weight()){
                before=shape;
            }
        }
        int index=shapes.indexOf(before);
        if(index == -1){
            shapes.add(circle);
            return;
        }
        shapes.add(index,circle);
    }

    public void add(String id,Color color,float width,float height){
        Square square=new Square(id,color,width,height);
        if(shapes.isEmpty()){
            shapes.add(square);
        }
        Shape before=new Square("temp",Color.RED,0,0);
        for(Shape shape:shapes){
            Stackable stackableShape=(Stackable) shape;
            Stackable stackableBefore=(Stackable) before;
            if(stackableBefore.weight()< stackableShape.weight() && stackableShape.weight()< square.weight()){
                before=shape;
            }
        }
        int index=shapes.indexOf(before);
        if(index == -1){
            shapes.add(square);
            return;
        }
        shapes.add(index,square);
    }

    public void add(Shape newShape){
        if(shapes.isEmpty()){
            shapes.add(newShape);
        }
        Shape before=new Square("temp",Color.RED,0,0);
        for(Shape shape:shapes){
            Stackable stackableShape=(Stackable) shape;
            Stackable stackableBefore=(Stackable) before;
            if(stackableBefore.weight()< stackableShape.weight() && stackableShape.weight()< ((Stackable)newShape).weight()){
                before=shape;
            }
        }
        int index=shapes.indexOf(before);
        if(index == -1){
            shapes.add(newShape);
            return;
        }
        shapes.add(index,newShape);
    }

    public void scale(String id,float scaleFactor){
        int index=-1;
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                index=i;
                break;
            }
        }
        Scalable shape=(Scalable)shapes.remove(index);
        shape.scale(scaleFactor);
        add((Shape) shape);


    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Shape shape:shapes){
            sb.append(shape.toString()).append('\n');
        }
        return sb.toString();
    }
}
