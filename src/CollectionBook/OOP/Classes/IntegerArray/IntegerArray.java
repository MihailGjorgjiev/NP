package CollectionBook.OOP.Classes.IntegerArray;

import java.util.Arrays;
import java.util.Objects;

public final class IntegerArray {
    private int[] a;

    public IntegerArray(int[] a) {
//        this.a = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            this.a[i] = a[i];
//        }
        this.a=Arrays.copyOf(a,a.length);
    }

    public int length() {
        return a.length;
    }

    public int getElementAt(int i) {
        return a[i];
    }

    public int sum() {
        int sum = 0;
        for(int i:a){
            sum+=i;
        }

        return sum;
    }

    public double average() {
        return (double) sum() / a.length;
    }

    public IntegerArray getSorted() {
//        int[] arr = new int[a.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]=a[i];
//        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
        int[] arr=Arrays.copyOf(a,a.length);
        Arrays.sort(arr);
        return new IntegerArray(arr);
    }

    public IntegerArray concat(IntegerArray ia){
        int[] arr=new int[a.length+ia.length()];
//        int i;
//        for(i=0;i<a.length;i++){
//            arr[i]=a[i];
//        }
//        for (int j = 0; j < ia.length(); j++) {
//            arr[i]=ia.getElementAt(j);
//        }
//        IntegerArray concatenatedArray=new IntegerArray(arr);
//        return concatenatedArray;
        System.arraycopy(a,0,arr,0,a.length);
        System.arraycopy(ia.a,0,arr,a.length,ia.a.length);
        return new IntegerArray(arr);
    }

    public String toString(){
//        StringBuilder sb=new StringBuilder();
//        sb.append("[");
//        for(Integer i:a){
//            sb.append(String.format("%d, ",i));
//        }
//        sb.replace(sb.length()-2,sb.length(),"]");
//
//        return sb.toString();

        return Arrays.toString(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Objects.deepEquals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }
}
