package PrvKolokviumVezbi.Equation_26;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Equation<T,U> {
    private Supplier<T> supplier;
    private Function<T, U> function;

    public Equation(Supplier<T> supplier, Function<T, U> function) {
        this.supplier = supplier;
        this.function = function;
    }

    public Optional<U> calculate(){
        return Optional.of(function.apply(supplier.get()));
    }
}
