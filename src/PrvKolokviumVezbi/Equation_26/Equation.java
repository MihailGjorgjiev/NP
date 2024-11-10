package PrvKolokviumVezbi.Equation_26;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Equation<T, R> {
    private Supplier<T> supplier;
    private Function<T, R> function;

    public Equation(Supplier<T> supplier, Function<T, R> function) {
        this.supplier = supplier;
        this.function = function;
    }

    public Optional<R> calculate() {
        return Optional.of(function.apply(supplier.get()));
    }
}