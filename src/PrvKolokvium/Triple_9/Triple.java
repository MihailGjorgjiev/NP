package PrvKolokvium.Triple_9;

public class Triple<T extends Number> {
    private T a,b,c;

    public Triple(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double max(){
        T greatest = a;

        if(greatest.doubleValue()<b.doubleValue()){
            greatest=b;
        }
        if(greatest.doubleValue()<c.doubleValue()){
            greatest=c;
        }
        return greatest.doubleValue();
    }

    public double average(){
        return (a.doubleValue()+b.doubleValue()+c.doubleValue())/3.0;
    }

    public void sort(){
        if (a.doubleValue()>b.doubleValue()){
            T temp=a;
            a=b;
            b=temp;
        }
        if (a.doubleValue()>c.doubleValue()){
            T temp=a;
            a=c;
            c=temp;
        }
        if (b.doubleValue()>c.doubleValue()){
            T temp=b;
            b=c;
            c=temp;
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f",a.doubleValue(),b.doubleValue(),c.doubleValue());
    }
}
