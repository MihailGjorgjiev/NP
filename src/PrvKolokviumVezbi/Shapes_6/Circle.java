package PrvKolokviumVezbi.Shapes_6;

public class Circle implements Shape,Scalable,Stackable{
    private String id;
    private Color color;
    private float radius;

    public Circle(String id,Color color,float radius) {
        this.radius = radius;
        this.color=color;
        this.id=id;
    }

    @Override
    public float area() {
        return (float) (radius*radius*Math.PI);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void scale(float scaleFactor) {
        radius*=scaleFactor;
    }

    @Override
    public float weight() {
        return area();
    }

    @Override
    public String toString() {
        return String.format("C: %-5s%-10s%10.2f",id,color.toString(),weight());
    }
}
