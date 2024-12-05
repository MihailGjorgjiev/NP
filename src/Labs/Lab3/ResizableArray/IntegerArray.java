package Labs.Lab3.ResizableArray;

public class IntegerArray extends ResizableArray<Integer>{
    public IntegerArray() {
        super();
    }

    public double sum(){
        double sum=0;
        for (int i = 0; i < count(); i++) {
            sum+=elementAt(i);
        }
        return sum;
    }
    public double mean(){
        double sum=sum();
        return sum/count();
    }
    public int countNonZero(){
        int total=0;
        for (int i = 0; i < count(); i++) {
            if(elementAt(i)!=0){
                total++;
            }
        }
        return total;
    }

    public IntegerArray distinct(){
        IntegerArray distinctArray=new IntegerArray();
        for (int i = 0; i < count(); i++) {
            int element=elementAt(i);
            if(!distinctArray.contains(element)){
                distinctArray.addElement(element);
            }
        }
        return distinctArray;
    }
    public IntegerArray increment(int offset){
        IntegerArray offestArray=new IntegerArray();
        for (int i = 0; i < count(); i++) {
            offestArray.addElement(elementAt(i)+offset);
        }
        return offestArray;
    }
}
