package PrvKolokviumVezbi.Equation_26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquationTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        if (testCase == 1) { // Testing with Integer, Integer
            List<Equation<Integer, Integer>> equations1 = new ArrayList<>();
            List<Integer> inputs = new ArrayList<>();
            while (sc.hasNext()) {
                inputs.add(Integer.parseInt(sc.nextLine()));
            }
            Equation<Integer, Integer> equation11 = new Equation<>(
                    () -> inputs.get(2), n -> n + 1000
            );
            equations1.add(equation11);
            // TODO: Add an equation where you get the 3rd integer from the inputs list, and the result is the sum of that number and the number 1000.


            // TODO: Add an equation where you get the 4th integer from the inputs list, and the result is the maximum of that number and the number 100.
            Equation<Integer, Integer> equation12 = new Equation<>(
                    () -> inputs.get(3), n -> Math.max(n, 100)
            );
            equations1.add(equation12);
            EquationProcessor.process(inputs, equations1);

        } else { // Testing with Line, Integer
            List<Equation<Line, Double>> equations2 = new ArrayList<>();
            List<Line> inputs = new ArrayList<>();
            while (sc.hasNext()) {
                inputs.add(Line.createLine(sc.nextLine()));
            }
            Equation<Line, Double> equation21 = new Equation<>(
                    () -> inputs.get(1), Line::calculateLine
            );
            equations2.add(equation21);
            //TODO Add an equation where you get the 2nd line, and the result is the value of y in the line equation.

            Equation<Line, Double> equation22 = new Equation<>(
                    () -> inputs.get(0), y -> inputs.stream().filter(l -> l.calculateLine() > y.calculateLine()).mapToDouble(Line::calculateLine).sum()
            );
            equations2.add(equation22);
            //TODO Add an equation where you get the 1st line, and the result is the sum of all y values for all lines that have a greater y value than that equation.

            EquationProcessor.process(inputs, equations2);
        }
    }
}
