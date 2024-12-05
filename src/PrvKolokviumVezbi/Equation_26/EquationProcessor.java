package PrvKolokviumVezbi.Equation_26;

import java.util.*;

public class EquationProcessor {

    public static <T, U> void process(List<T> inputs, List<Equation<T, U>> equations) {
        List<U> results = new ArrayList<>();
        for (T input : inputs) {
            for (Equation<T, U> equation : equations) {
                Optional<U> result = equation.calculate();
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
            for (U res : results) {
                System.out.println("Result: " + res);
            }
        } else {
            for (T input : inputs) {
                System.out.println("Input: " + input);
                for (Equation<T, U> equation : equations) {
                    Optional<U> optionalResult = equation.calculate();
                    if (optionalResult.isPresent()) {
                        System.out.println("Result: " + optionalResult.get());
                    }
                }
            }
        }
    }
}