package AV.FirstMidTermPractice.MinMax;

public class MinMax<T extends Comparable<T>> {
    private T min;
    private T max;
    private int total;
    private int totalMin;
    private int totalMax;

    public MinMax() {
        min=null;
        max=null;
        total=0;
        totalMax=0;
        totalMin=0;

    }
    public T max(){
        return max;
    }
    public T min(){
        return min;
    }

    public void update(T element){
        if(total == 0){
            min=element;
            max=element;
        }
        total++;
        if (element.compareTo(min)<0){
            totalMin=1;
            min=element;
        }else {
            if(element.compareTo(min) == 0){
                totalMin++;
            }
        }
        if (element.compareTo(max)>0){
            totalMax=1;
            max=element;
        }else {
            if(element.compareTo(max) == 0){
                totalMax++;
            }
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s %s",min,max,total-(totalMin+totalMax));
    }

    public static void main(String[] args) {
        MinMax<String> strings = new MinMax<>();
        strings.update("b");
        strings.update("b");
        strings.update("a");

        strings.update("a");
        strings.update("a");
        strings.update("c");
        strings.update("c");
        strings.update("c");
        strings.update("d");
        System.out.println(strings);
    }
}
