package Labs.Lab1.IntegerArray;

import java.util.Arrays;

public class IntegerArray {
    private final int[] array;

    public IntegerArray(int[] array) {
        this.array = array;
    }

    public int length(){
        return array.length;
    }

    public int getElementAt(int inx){
        return array[inx];
    }

    public int sum(){
//        return Arrays.stream(array).sum();
        int result=0;
        for(int x:array){
            result+=x;
        }
        return result;
    }

    public double average(){
//        return Arrays.stream(array).average().orElse(0.0);
        int sum=sum();
        return (double)sum/length();
    }

    public IntegerArray getSorted(){
//        return new IntegerArray(Arrays.stream(array).sorted().toArray());
        int[] newArray=Arrays.copyOf(array,length());
        Arrays.sort(newArray);
        return new IntegerArray(newArray);
    }

    public IntegerArray concat(IntegerArray ia){
        int[] result=new int[this.length()+ia.length()];
        int i;
        for(i=0;i<this.length();i++){
            result[i]=this.getElementAt(i);
        }
        for(int j=0;j<ia.length();j++,i++){
            result[i]=ia.getElementAt(j);
        }
        return new IntegerArray(result);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for(int x:array){
            sb.append(String.format("%d, ",x));
        }
        sb.replace(sb.length()-2,sb.length()-1,"]");
        return sb.toString();
    }
}
