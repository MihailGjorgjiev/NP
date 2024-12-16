package VtorKolokviumVezbi.Canvas_8;

import java.util.Objects;

public class Circle implements Shape{
    private double radius;
    private double originalArea;


    public Circle(double radius) {
        this.radius = radius;
        this.originalArea=getArea();
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    public void scale(double factor) {
        radius*=factor;
    }

    @Override
    public double getUnscaledArea() {
        return originalArea;
    }

    @Override
    public String toString() {
        return String.format(
                "Circle -> Radius: %.2f Area: %.2f Perimeter: %.2f",
                radius, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }
}
