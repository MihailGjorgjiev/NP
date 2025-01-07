package CollectionBook.Streams.Canvas;

public class Rectangle extends Square {
    private double b;

    public Rectangle(String id, double a, double b) {
        super(id, a);
        this.b = b;
    }

    public double getHeight() {
        return getSide();
    }

    public double getWidth() {
        return b;
    }

    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override
    public void scale(double coefficient) {
        super.scale(coefficient);
        b *= coefficient;
    }

    @Override
    public String toString() {
        return String.format("Rectangle: %s Sides: %.2f,%,2f Area: %.2f Perimeter: %.2f",getID(),getHeight(),getWidth(),getArea(),getPerimeter());
    }
}
