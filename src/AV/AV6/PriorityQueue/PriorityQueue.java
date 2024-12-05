package AV.AV6.PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T> {
    private ArrayList<T> queue;
    private ArrayList<Integer> priorities;

    public PriorityQueue() {
        this.queue = new ArrayList<>();
        this.priorities = new ArrayList<>();
    }

    public void add(T item,int priority){
        int i;
        for (i = 0; i < priorities.size() ; i++) {
            if(priorities.get(i)<priority){
                break;
            }
        }
        queue.add(i,item);
        priorities.add(i,priority);
    }

    public T remove(){
        if(queue.isEmpty()){
            return null;
        }
        T item=queue.get(0);
        queue.remove(0);
        priorities.remove(0);
        return item;
    }

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("X", 0);
        pq.add("Y", 1);
        pq.add("Z", 3);
        System.out.println(pq.remove()); // Returns Z
        System.out.println(pq.remove()); // Returns Y
        System.out.println(pq.remove()); // Returns X
    }
}
