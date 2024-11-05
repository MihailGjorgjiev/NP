package PrvKolokviumVezbi.Evaluator_10;

public class EvaluatorBuilder<T extends Comparable<T>> {
//    private static final IEvaluator greaterThan = (x, y) -> x.compareTo(y) > 0;
//    private static final IEvaluator lessThan = (x, y) -> x.compareTo(y) < 0;
//    private static final IEvaluator equals = Object::equals;
//    private static final IEvaluator notEquals = (x, y) -> !Objects.equals(x, y);

    public static <T extends Comparable<T>> IEvaluator<T> build(String operator) {
        switch (operator) {
            case ">":
                return (x, y) -> x.compareTo(y) > 0;
            case "<":
                return (x, y) -> x.compareTo(y) < 0;
            case "==":
                return Object::equals;
            case "!=":
                return (x, y) -> !x.equals(y);
            default:
                return (x, y) -> false;
        }
    }
}
