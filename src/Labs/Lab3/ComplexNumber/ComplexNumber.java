package Labs.Lab3.ComplexNumber;

import java.math.BigDecimal;

public class ComplexNumber<T extends Number,U extends Number> implements Comparable<ComplexNumber<T,U>>{
    private T real;
    private U imag;

    public ComplexNumber(T real, U imaginary) {
        this.real = real;
        this.imag = imaginary;
    }

    public T getReal() {
        return real;
    }

    public U getImaginary() {
        return imag;
    }
    public double modul(){
        return Math.sqrt(Math.pow(real.doubleValue(),2)+Math.pow( imag.doubleValue(),2));
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(String.format("%.2f",real.doubleValue()));
        if(imag.doubleValue()>=0){
            sb.append("+");
        }
        sb.append(String.format("%.2fi",imag.doubleValue()));
        return sb.toString();
    }

    @Override
    public int compareTo(ComplexNumber<T, U> o) {
        return Double.compare(modul(),o.modul());
    }
}
