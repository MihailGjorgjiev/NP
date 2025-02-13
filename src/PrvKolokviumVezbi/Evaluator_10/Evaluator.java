package PrvKolokviumVezbi.Evaluator_10;

public class Evaluator {
    public static <T extends Comparable<T>> boolean evaluateExpression(T left, T right, String operator){
        IEvaluator<T> e=EvaluatorBuilder.build(operator);
        return e.evaluate(left,right);

    }
}
