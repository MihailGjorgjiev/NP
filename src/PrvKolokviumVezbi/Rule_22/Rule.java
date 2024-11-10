package PrvKolokviumVezbi.Rule_22;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Rule<T,R> {
    private Predicate<T> predicate;
    private Function<T,R> function;

    public Rule(Predicate<T> predicate, Function<T, R> function) {
        this.predicate = predicate;
        this.function = function;
    }
    public Optional<R> apply(T input){
        if(predicate.test(input)){
            return Optional.of(function.apply(input));
        }else {
            return Optional.empty();
        }
    }
}
