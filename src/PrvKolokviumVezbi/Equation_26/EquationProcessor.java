package PrvKolokviumVezbi.Equation_26;

import java.util.*;

public class EquationProcessor {
    public static <T, R> void process(List<T> inputs, List<Equation<T, R>> equations) {
        List<R> results = new ArrayList<>();
        for (T input : inputs) {
            for (Equation<T, R> equation : equations) {
                Optional<R> result = equation.calculate();
                if (result.isPresent()) {
                    if (!results.contains(result.get())) {
                        results.add(result.get());
                    }
                }
            }
        }
        if (results.size() == equations.size()) {
            for (T input : inputs) {
                System.out.println("Input: " + input);
            }
            for (R res : results) {
                System.out.println("Result: " + res);
            }
        } else {
            for (T input : inputs) {
                System.out.println("Input: " + input);
                for (Equation<T, R> equation : equations) {
                    Optional<R> result = equation.calculate();
                    if (result.isPresent()) {
                        System.out.println("Result: " + result.get());
                    }
                }
            }
        }

    }
}
