package Labs.Lab3.IntegerList;

import java.util.ArrayList;
import java.util.List;

public class IntegerList {
    List<Integer> list;

    public IntegerList() {
        list = new ArrayList<>();
    }

    public IntegerList(Integer[] list) {
        this.list = new ArrayList<>();
        for (Integer element : list) {
            this.list.add(element);
        }
    }

    public void add(int el, int idx) {
        if(idx>size()){
            int n=size();
            while (n!=idx){
                list.add(n,0);
                n++;
            }
        }
        list.add(idx, el);

    }

    public int remove(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list.remove(idx);
    }

    public void set(int el, int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list.set(idx, el);
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list.get(idx);
    }

    public int size() {
        return list.size();
    }

    public int count(int el) {
        int num = 0;
        for (Integer x : list) {
            if (x.equals(el)) {
                num++;
            }
        }
        return num;
    }

    public void removeDuplicates() {
        for (int i = 0; i < size(); i++) {
            if (count(get(i)) == 1) continue;
            remove(i);
            i--;
        }
    }

    public int sumFirst(int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (i >= size()) {
//                throw new ArrayIndexOutOfBoundsException();
                break;
            }
            sum += get(i);
        }
        return sum;
    }

    public int sumLast(int k) {
        int sum = 0;
        for (int i = size() - k; i < size(); i++) {
            if (i < 0 || i >= size()) {
//                throw new ArrayIndexOutOfBoundsException();
                break;
            }
            sum += get(i);
        }
        return sum;
    }

    public void shiftRight(int idx, int k) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int element = get(idx);

        int newInx = idx != size() ? idx : 0;
        for (int i = 1; i <= k; i++) {
            newInx++;
            if (newInx == size()) {
                newInx = 0;
            }
        }
        remove(idx);
        add(element, newInx);
    }

    public void shiftLeft(int idx, int k) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int element = get(idx);

        int newInx = idx != size() ? idx : 0;
        for (int i = 1; i <= k; i++) {
            newInx--;
            if (newInx < 0) {
                newInx = size()-1;
            }
        }
        if(newInx<idx){
        remove(idx);
        add(element, newInx);
        }else {
            remove(idx);
            add(element, newInx);
        }
        int z=0;
    }

    public IntegerList addValue(int value) {
        IntegerList addedIntegerList = new IntegerList();
        for (int i = 0; i < size(); i++) {
            addedIntegerList.add(get(i) + value, i);
        }
        return addedIntegerList;
    }

}
