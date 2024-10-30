package PrvKolokvium.MinAndMax_5;

public class MinMax<T extends Comparable<T>> {
    private T min;
    private T max;
    private int totalDifferent;
    private int minCount;
    private int maxCount;

    public MinMax() {
        totalDifferent = 0;
        minCount=1;
        maxCount=1;
    }

    public void update(T element) {
        if (min == null && max == null) {
            min = element;
            max = element;

            return;
        }
        if (min.equals(max)) {
            if (min.compareTo(element) > 0) {
                min = element;
            } else {
                max = element;
            }
            return;
        }

        if (min.equals(element)){
            minCount++;
        } else if (max.equals(element)) {
            maxCount++;
        }else if (min.compareTo(element) > 0) {
            min = element;
            totalDifferent+=minCount;
            minCount=1;

        } else if (max.compareTo(element) < 0) {
            max = element;
            totalDifferent+=maxCount;
            maxCount=1;

        } else if (!min.equals(element) && !max.equals(element)) {
            totalDifferent++;
        }
    }

    public T max() {
        return max;
    }

    public T min() {
        return min;
    }

    @Override
    public String toString() {
        return "" + min + " " + max + " " + totalDifferent + "\n";
    }
}
