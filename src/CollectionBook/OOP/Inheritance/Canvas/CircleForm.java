package CollectionBook.OOP.Inheritance.Canvas;

public class CircleForm extends Form{
    private float radius;

    public CircleForm(String id, Color color, float radius) {
        super(id, color);
        this.radius = radius;
    }

    @Override
    public void scale(float scaleFactor) {
        radius*=scaleFactor;
    }

    @Override
    public float weight() {
        return (float) (Math.pow(radius,2)*Math.PI);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("C: [id:%5s] [color:%10s] [weight:%10.2f]",getId(),getColor(),weight());
    }
}
