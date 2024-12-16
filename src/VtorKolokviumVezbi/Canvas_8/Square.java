package VtorKolokviumVezbi.Canvas_8;

import java.util.Objects;

public class Square implements Shape {
    private double side;
    private double originalArea;

    public Square(double side) {
        this.side = side;
        this.originalArea=getArea();
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void scale(double factor) {
        side *= factor;
    }

    @Override
    public double getUnscaledArea() {
        return originalArea;
    }

    @Override
    public String toString() {
        return String.format(
                "Square: -> Side: %.2f Area: %.2f Perimeter: %.2f",
                side, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(side);
    }
}
