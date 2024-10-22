package AV.AV2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigComplex {
    private BigDecimal real;
    private BigDecimal imag;

    public BigComplex(BigDecimal real, BigDecimal imag) {
        this.real = real;
        this.imag = imag;
    }

    public BigDecimal getReal() {
        return real;
    }

    public BigDecimal getImag() {
        return imag;
    }

    @Override
    public String toString() {
        return real + (imag.doubleValue() > 0 ? "+" : "") + imag + "i";
    }


    public BigComplex add(BigComplex complex) {
        BigDecimal real = this.real.add(complex.real);
        BigDecimal imag = this.imag.add(complex.imag);
        return new BigComplex(real, imag);
    }

    public BigComplex substract(BigComplex complex) {
        BigDecimal real = this.real.subtract(complex.real);
        BigDecimal imag = this.imag.subtract(complex.imag);
        return new BigComplex(real, imag);
    }

    public BigComplex multiply(BigComplex complex) {
        BigDecimal real = this.real.multiply(complex.real);
        BigDecimal imag = this.imag.multiply(complex.imag);
        return new BigComplex(real, imag);
    }

    public BigComplex divide(BigComplex complex) {
        try {
            BigDecimal real = this.real.divide(complex.real, RoundingMode.CEILING);
            BigDecimal imag = this.imag.divide(complex.imag,RoundingMode.CEILING);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return new BigComplex(real, imag);
    }

    public static void main(String[] args) {
        BigComplex complex1 = new BigComplex(new BigDecimal(3), new BigDecimal(5));
        BigComplex complex2 = new BigComplex(new BigDecimal(-5), new BigDecimal(3));
        BigComplex complex3 = new BigComplex(new BigDecimal(0), new BigDecimal(5));
        BigComplex complex4 = new BigComplex(new BigDecimal(3), new BigDecimal(0));
        BigComplex complex5 = new BigComplex(new BigDecimal(0), new BigDecimal(0));

        System.out.println(complex1.add(complex2));
        System.out.println(complex1.substract(complex2));
        System.out.println(complex1.multiply(complex2));
        System.out.println(complex1.divide(complex2));
        System.out.println();
        System.out.println(complex1.add(complex3));
        System.out.println(complex1.substract(complex3));
        System.out.println(complex1.multiply(complex3));
        System.out.println(complex1.divide(complex3));
        System.out.println();
        System.out.println(complex1.add(complex4));
        System.out.println(complex1.substract(complex4));
        System.out.println(complex1.multiply(complex4));
        System.out.println(complex1.divide(complex4));
        System.out.println();
        System.out.println(complex1.add(complex5));
        System.out.println(complex1.substract(complex5));
        System.out.println(complex1.multiply(complex5));
        System.out.println(complex1.divide(complex5));
    }
}
