package CollectionBook.Generics.Introduction.IntefacesFunctions.GenericFunctions;

public class GenericFunctions {
    public static <E> void printArray(E[] inputArray){
        StringBuilder builder=new StringBuilder();
        for(E e:inputArray){
            builder.append(e.toString()).append(" ");
        }
        System.out.println(builder.toString());
    }

    public static <T extends Comparable<T> > T maximum(T x, T y, T z){
        T max=x;
        if(max.compareTo(y)<0){
            max=y;
        }
        if(max.compareTo(z)<0){
            max=z;
        }
        return max;
    }

}
