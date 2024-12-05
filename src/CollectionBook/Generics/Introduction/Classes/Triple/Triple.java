package CollectionBook.Generics.Introduction.Classes.Triple;

public class Triple<T extends Number> {
    private T first;
    private T second;
    private T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double max() {
        T max = first;
        if (max.doubleValue() < second.doubleValue()) {
            max = second;
        }
        if (max.doubleValue() < third.doubleValue()) {
            max = third;
        }
        return max.doubleValue();
    }

    public double average() {
        double sum = first.doubleValue() + second.doubleValue() + third.doubleValue();

        return sum / 3;
    }


    public void sort() {
        if (first.doubleValue() > second.doubleValue()) {
            T temp = first;
            first = second;
            second = temp;
        }
        if (first.doubleValue() > third.doubleValue()) {
            T temp = first;
            first = third;
            third = temp;
        }
        if (second.doubleValue() > third.doubleValue()) {
            T temp = second;
            second = third;
            third = temp;
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f",first.doubleValue(),second.doubleValue(),third.doubleValue());
    }
}
