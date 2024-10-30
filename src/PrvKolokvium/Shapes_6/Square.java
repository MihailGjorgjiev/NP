package PrvKolokvium.Shapes_6;

public class Square implements Shape,Stackable,Scalable{
    private String id;
    private Color color;
    private float height;
    private float width;

    public Square(String id,Color color,float width, float height) {
        this.id=id;
        this.color=color;
        this.height = height;
        this.width = width;
    }

    @Override
    public float area() {
        return height*width;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void scale(float scaleFactor) {
        width*=scaleFactor;
        height*=scaleFactor;
    }

    @Override
    public float weight() {
        return area();
    }

    @Override
    public String toString() {
        return String.format("R: %-5s%-10s%10.2f",id,color.toString(),weight());
    }
}
