package Labs.Lab3.ResizableArray;

//@SuppressWarnings("unchecked")
public class ResizableArray<T> {
    private T[] array;
    private int n;

    public ResizableArray() {
        this.array = (T[]) new Object[0];
    }
    private void resize(int newSize){
        T[] newArray= (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            newArray[i]=array[i];
        }
        this.array=newArray;
    }
    public void addElement(T element) {
        if(n== array.length){
            resize(2*n+1);
        }
        array[n]=element;
        n++;
    }

    public boolean removeElement(T element) {
        int inx = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(element)) {
                inx = i;
                break;
            }
        }
        if (inx == -1) {
            return false;
        }
        n--;
        for (int i = inx; i < n; i++) {
            array[i]=array[i+1];
        }

        if(array.length>=4*n){
            resize(n);
        }
        return true;
    }

    public boolean contains(T element) {
        int z=0;
        for (int i=0;i<n;i++) {
            if (elementAt(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return array;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int count() {
        return n;
    }

    public T elementAt(int inx) {
        if (inx < 0 || inx > n - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[inx];
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
        ResizableArray<T> destTemp=new ResizableArray<>();
        for (int i = 0; i < src.count(); i++) {
            destTemp.addElement(src.elementAt(i));
        }
        for (int i = 0; i < destTemp.count(); i++) {
            dest.addElement(destTemp.elementAt(i));
        }

    }
}
