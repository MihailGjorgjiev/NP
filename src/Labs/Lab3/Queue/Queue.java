package Labs.Lab3.Queue;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Queue<T> {
    private T[] queue;
    private int n;
    private int head;
    private int tail;
    public Queue() {
        queue = (T[]) new Object[0];
        n = 0;
        head=0;
        tail=0;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enqueue(T element) {
        if (queue.length == tail) {
            T[] newQueue = (T[]) new Object[tail * 2+1];
            for (int i = 0; i < tail; i++) {
                newQueue[i] = queue[i];
            }
            newQueue[tail] = element;
            queue = newQueue;
        } else {
            queue[tail] = element;

        }
        n++;
        tail++;
    }
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException("EmptyQueueException");
        }
        T element=queue[head];
        head++;
        n--;
        if(4*(tail-head)<n){
            T[] newQueue= (T[]) new Object[n/2];
            int t=0;
            for(int i=head;i<=tail;i++){
                newQueue[t]=queue[i];
                t++;
            }
            queue=newQueue;
            head=0;
            tail=t;
        }
        return element;
    }
    public T peek() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException("EmptyQueueException");
        }
        T element=queue[head];
        return element;
    }

    public T inspect() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException("EmptyQueueException");
        }
        T element=queue[tail-1];
        return element;
    }
    public int count(){
        return n;
    }

}
