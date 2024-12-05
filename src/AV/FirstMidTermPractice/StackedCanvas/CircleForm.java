package AV.FirstMidTermPractice.StackedCanvas;

public class CircleForm extends CanvasForm{
    private float radius;

    public CircleForm(String id, String color, float radius) {
        super(id, color);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public void scale(float scaleFactor) {
        this.radius*=scaleFactor;
    }

    @Override
    public float weight() {
        return (float) (2*Math.pow(radius,2)*Math.PI);
    }

    @Override
    public String toString() {
        return String.format("C:%s%10.2f",super.toString(),weight());
    }
}
