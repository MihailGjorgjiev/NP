package CollectionBook.Streams.Canvas;

import java.util.Map;

public class Square extends Shape{
    private double a;

    public Square(String id, double a) {
        super(id);
        this.a=a;
    }

    public double getSide(){
        return a;
    }

    @Override
    public double getArea() {
        return Math.pow(a,2);
    }

    @Override
    public double getPerimeter() {
        return 4*a;
    }

    @Override
    public void scale(double coefficient) {
        a*=coefficient;
    }

    @Override
    public String toString() {
        return String.format("Square: %s Side: %.2f Area: %.2f Perimeter: %.2f",getID(),getSide(),getArea(),getPerimeter());
    }
}
