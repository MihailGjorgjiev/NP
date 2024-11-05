package PrvKolokviumVezbi.GenericFraction_11;

public class GenericFraction<T extends Number, U extends Number> {
    private T numerator;
    private U denominator;

    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        if (denominator.doubleValue() == 0) {
            throw new ZeroDenominatorException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public T getNumerator() {
        return numerator;
    }

    public U getDenominator() {
        return denominator;
    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) throws ZeroDenominatorException {
        double newDenominator = denominator.doubleValue() * gf.denominator.doubleValue();
        double newNumerator = numerator.doubleValue() * gf.denominator.doubleValue() + denominator.doubleValue() * gf.numerator.doubleValue();
        return new GenericFraction<>(newNumerator, newDenominator);
    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    private GenericFraction<Double, Double> normalize() throws ZeroDenominatorException {
        int intNumerator = getNumerator().intValue();
        int intDenominator = getDenominator().intValue();

        while (intNumerator % 2 == 0 && intDenominator % 2 == 0) {
            intNumerator /= 2;
            intDenominator /= 2;
        }
        for (int i = 3; i * i <= intDenominator; i += 2) {
            if ((intNumerator % i == 0 && intDenominator % i == 0)) {
                intNumerator /= i;
                intDenominator /= i;
            }
        }
        return new GenericFraction<>((double) intNumerator, (double) intDenominator);
    }

    @Override
    public String toString() {
        try {
            GenericFraction<Double, Double> nf = normalize();
            return String.format("%.2f / %.2f",nf.numerator.doubleValue() , nf.denominator.doubleValue());
        } catch (ZeroDenominatorException e) {
            throw new RuntimeException(e);
        }
    }
}
