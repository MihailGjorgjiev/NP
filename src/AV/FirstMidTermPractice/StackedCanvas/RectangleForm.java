package AV.FirstMidTermPractice.StackedCanvas;

public class RectangleForm extends CanvasForm{
    private float width;
    private float height;

    public RectangleForm(String id, String color, float width, float height) {
        super(id, color);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
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
        return String.format("R:%s%10.2f",super.toString(),weight());
    }
}
