package Labs.Lab3.PizzaOrder;



import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Item> items;
    List<Integer> counts;
    boolean isLocked;

    public Order() {
        items=new ArrayList<>();
        counts=new ArrayList<>();
        isLocked=false;
    }
    public void addItem(Item item,int count) throws ItemOutOfStockException, OrderLockedException {
        if(isLocked){
            throw new OrderLockedException("OrderLockedException");
        }
        if(count>10){
            throw new ItemOutOfStockException(item.toString());
        }
        int i;
        for(i=0;i< items.size();i++){
            if(items.get(i).toString().equals(item.toString())){
                break;
            }
        }
        if(i== counts.size()){
            items.add(item);
            counts.add(count);
        }else {
            counts.set(i,count);
        }

    }
    public int getPrice(){
        int total=0;
        for (int i = 0; i < items.size(); i++) {
            total+=items.get(i).getPrice()*counts.get(i);
        }
        return total;
    }
    public void displayOrder(){
        PrintWriter writer=new PrintWriter(System.out);

        for (int i = 0; i < items.size(); i++) {
            int count= counts.get(i);
            int cost=items.get(i).getPrice();
            String line=String.format("%3d.%-15sx%2d%5d$",i+1,items.get(i).toString(),count,count*cost);
            writer.println(line);
        }
        writer.println(String.format("%-15s%5d","Total",getPrice()));
        writer.flush();
    }

    public void removeItem(int idx) throws OrderLockedException {
        if(isLocked){
            throw new OrderLockedException("OrderLockedException");
        }
        if(idx>= counts.size()){
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        items.remove(idx);
        counts.remove(idx);
    }
    public void lock() throws EmptyOrder {
        if(counts.size() == 0){
            throw new EmptyOrder("EmptyOrderException");
        }
        isLocked=true;
    }
}
