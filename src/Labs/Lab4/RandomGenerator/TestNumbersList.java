package Labs.Lab4.RandomGenerator;

import java.util.List;

public interface TestNumbersList<T extends Number> {
    boolean test(List<T> numbers);
}