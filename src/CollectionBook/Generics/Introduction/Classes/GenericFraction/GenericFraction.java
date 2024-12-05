package CollectionBook.Generics.Introduction.Classes.GenericFraction;

import PrvKolokviumVezbi.GenericFraction_11.ZeroDenominatorException;

public class GenericFraction<T extends Number,U extends Number> {
    private T numerator;
    private U denominator;

    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        this.numerator = numerator;
        if(denominator.doubleValue() == 0){
            throw new ZeroDenominatorException(denominator.toString());
        }
        this.denominator = denominator;
    }

    public GenericFraction<Double,Double> add(GenericFraction<? extends Number,? extends Number> gf) throws ZeroDenominatorException {
        double a=numerator.doubleValue();
        double b=denominator.doubleValue();
        double c=gf.numerator.doubleValue();
        double d=gf.denominator.doubleValue();
        return new GenericFraction<>(a*d+b*c,b*d);
    }

    public double toDouble(){
        return numerator.doubleValue()/denominator.doubleValue();
    }

    @Override
    public String toString() {
        return numerator.toString()+"/"+denominator.toString();
    }
    public <N extends Number,D extends Number> GenericFraction<N,D> create(N numerator,D denominator) throws ZeroDenominatorException {
        return new GenericFraction<>(numerator,denominator);
    }

}
