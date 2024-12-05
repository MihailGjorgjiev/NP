package Labs.Lab4.SuperString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SuperString {
    private LinkedList<String> strings;
    private Stack<String> order;
    public SuperString() {
        order=new Stack<>();
        strings=new LinkedList<>();

    }

    public void append(String s) {
        strings.addLast(s);
        order.add(s);
    }

    public void insert(String s) {
        strings.addFirst(s);
        order.add(s);
    }

    public boolean contains(String s) {
        return String.join("", strings).contains(s);
    }

    public void reverse() {
    Collections.reverse(strings);
    strings=strings.stream()
            .map(s->new StringBuilder(s).reverse().toString())
            .collect(Collectors.toCollection(LinkedList::new));
    }

    public void removeLast(int k) {
        for (int i = 0; i < k; i++) {
            String s=order.pop();
            strings.remove(s);
        }

    }

    @Override
    public String toString() {
        return String.join("", strings);
    }
}
