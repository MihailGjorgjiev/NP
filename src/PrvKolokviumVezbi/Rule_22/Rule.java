package PrvKolokviumVezbi.Rule_22;

import Labs.Lab2.Contacts.Operator;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Rule<T,K> implements Predicate<T>, Function<T,K> {
    //TODO: implement the following methods

    @Override
    public K apply(T t) {
        return null;
    }

    @Override
    public boolean test(T t) {
        return false;
    }
}
