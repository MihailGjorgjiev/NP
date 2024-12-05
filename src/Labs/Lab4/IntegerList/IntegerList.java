package Labs.Lab4.IntegerList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class IntegerList {
    ArrayList<Integer> numbers;

    private boolean isValidIndexPosition(int inx) {
        return inx >= 0 && inx < size();
    }

    public IntegerList() {
        numbers = new ArrayList<>();
    }

    public IntegerList(Integer[] numbers) {
        this();
        for (Integer i : numbers) {
            this.numbers.add(i);
        }
    }

    public void add(int el, int idx) {
        while (idx>size()){
            numbers.add(0);
        }
        numbers.add(idx, el);

    }

    public int remove(int idx) {
        if (!isValidIndexPosition(idx)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return numbers.remove(idx);
    }

    public void set(int el, int idx) {
        if (!isValidIndexPosition(idx)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        numbers.set(idx, el);
    }

    public int get(int idx) {
        if (!isValidIndexPosition(idx)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return numbers.get(idx);
    }

    public int size() {
        return numbers.size();
    }

    public int count(int el) {
        return (int) numbers.stream().filter(n -> n.equals(el)).count();
    }

    public void removeDuplicates() {
        ArrayList<Integer> noDuplicatesList = new ArrayList<>();
        IntStream.range(0,size()).forEach(i->{
            int element= numbers.get(size()-1-i);
            if (!noDuplicatesList.contains(element)) noDuplicatesList.add(element);
        });
        Collections.reverse(noDuplicatesList);
        numbers = noDuplicatesList;
    }

    public int sumFirst(int k) {
        if (k > size()) {
            k = size();
        }
        return IntStream.range(0, k).map(i -> numbers.get(i)).sum();
    }

    public int sumLast(int k) {
        if (k > size()) {
            k = size();
        }
        return IntStream.range(0, k).map(i -> numbers.get(size() - i - 1)).sum();
    }

    public IntegerList addValue(int value) {
        Integer[] list = numbers.toArray(Integer[]::new);
        Integer[] l = Arrays.stream(list).map(el -> el + value).toArray(Integer[]::new);
        return new IntegerList(l);
    }

    private int shiftedIndex(int currInx, int k, int direction) {
        int newInx = currInx;
        if (direction > 0) {
            while (k > 0) {
                newInx++;
                if (newInx == size()) {
                    newInx = 0;
                }
                k--;
            }
        } else {
            while (k>0){
                newInx--;
                if(newInx == -1){
                    newInx=size()-1;
                }
                k--;
            }
        }
        return newInx;
    }

    public void shiftRight(int idx, int k) {
        int newIndex=shiftedIndex(idx,k,1);
        if(newIndex<idx){
            int temp= numbers.get(idx);
            for (int i = idx; i >newIndex ; i--) {
                numbers.set(i,numbers.get(i-1));
            }
            numbers.set(newIndex,temp);
            return;
        }
        if(newIndex>idx){
            int temp= numbers.get(idx);
            for (int i = idx; i <newIndex ; i++) {
                numbers.set(i, numbers.get(i+1));
            }
            numbers.set(newIndex,temp);
            return;
        }
    }

    public void shiftLeft(int idx, int k) {
        int newIndex=shiftedIndex(idx,k,-1);
        if(newIndex<idx){
            int temp= numbers.get(idx);
            for (int i = idx; i >newIndex ; i--) {
                numbers.set(i,numbers.get(i-1));
            }
            numbers.set(newIndex,temp);
            return;
        }
        if(newIndex>idx){
            int temp= numbers.get(idx);
            for (int i = idx; i <newIndex ; i++) {
                numbers.set(i, numbers.get(i+1));
            }
            numbers.set(newIndex,temp);
            return;
        }

    }
}
