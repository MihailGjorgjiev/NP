package CollectionBook.DesignPatterns.TaskManager;

import java.time.LocalDateTime;

public class PriorityTaskDecorator extends TaskDecorator{
    private int priority;

    public PriorityTaskDecorator(ITask iTask,int priority) {
        super(iTask);
        this.priority=priority;
    }

    @Override
    public LocalDateTime getDeadLine() {
        return getiTask().getDeadLine();
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getCategory() {
        return getiTask().getCategory();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        String base=getiTask().toString();
        sb.append(base,0,base.length()-1);
        sb.append(", priority=").append(priority);
        sb.append("}");
        return sb.toString();
    }
}
