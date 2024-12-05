package CollectionBook.OOP.Inheritance.Canvas;

public class RectangleForm extends Form{
    private float width;
    private float height;

    public RectangleForm(String id, Color color, float width, float height) {
        super(id, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void scale(float scaleFactor) {
        height*=scaleFactor;
        width*=scaleFactor;
    }

    @Override
    public float weight() {
        return height*width;
    }

    @Override
    public String toString() {
        return String.format("R: [id:%5s] [color:%10s] [weight:%10.2f]",getId(),getColor(),weight());
    }
}
