package VtorKolokviumVezbi.Canvas_8;

import java.util.Objects;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private double originalArea;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.originalArea=getArea();
    }

    @Override
    public double getArea() {
        return height*width;
    }

    @Override
    public double getPerimeter() {
        return 2*width+2*height;
    }

    @Override
    public void scale(double factor) {
        height*=factor;
        width*=factor;
    }

    @Override
    public double getUnscaledArea() {
        return originalArea;
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle: -> Sides: %.2f, %.2f Area: %.2f Perimeter: %.2f",
                width,height, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
