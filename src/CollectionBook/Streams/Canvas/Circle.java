package CollectionBook.Streams.Canvas;

import java.util.Map;

public class Circle extends Shape{
    private double radius;

    public Circle(String id, double radius) {
        super(id);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    public void scale(double coefficient) {
    radius*=coefficient;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s Radius: %.2f Area: %.2f Perimeter: %.2f",getID(),getRadius(),getArea(),getPerimeter());
    }
}
