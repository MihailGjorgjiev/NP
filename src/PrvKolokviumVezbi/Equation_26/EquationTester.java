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
            Equation<Integer,Integer> eq1=new Equation<>(()->inputs.get(2),x->x+1000);
            // TODO: Add an equation where you get the 3rd integer from the inputs list, and the result is the sum of that number and the number 1000.

            Equation<Integer,Integer> eq2=new Equation<>(()->inputs.get(3),x->x>100?x:100);
            // TODO: Add an equation where you get the 4th integer from the inputs list, and the result is the maximum of that number and the number 100.
            equations1.add(eq1);
            equations1.add(eq2);
            EquationProcessor.process(inputs, equations1);

        } else { // Testing with Line, Integer
            List<Equation<Line, Double>> equations2 = new ArrayList<>();
            List<Line> inputs = new ArrayList<>();
            while (sc.hasNext()) {
                inputs.add(Line.createLine(sc.nextLine()));
            }
            Equation<Line,Double> eq3=new Equation<>(()->inputs.get(1),x->x.calculateLine());
            //TODO Add an equation where you get the 2nd line, and the result is the value of y in the line equation.

            Equation<Line,Double> eq4=new Equation<>(()->inputs.get(0),x->inputs.stream().filter(l->l.calculateLine()>x.calculateLine()).mapToDouble(l->l.calculateLine()).sum());
            //TODO Add an equation where you get the 1st line, and the result is the sum of all y values for all lines that have a greater y value than that equation.
            equations2.add(eq3);
            equations2.add(eq4);
            EquationProcessor.process(inputs, equations2);
        }
    }
}