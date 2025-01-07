package CollectionBook.DesignPatterns.TaskManager;

import java.time.LocalDateTime;

public class TimeTaskDecorator extends TaskDecorator {
    private LocalDateTime deadline;

    public TimeTaskDecorator(ITask iTask,LocalDateTime deadline) {
        super(iTask);
        this.deadline=deadline;
    }


    @Override
    public LocalDateTime getDeadLine() {
        return deadline;
    }

    @Override
    public int getPriority() {
        return getiTask().getPriority();
    }

    @Override
    public String getCategory() {
        return getiTask().getCategory();
    }
    public String toString() {
        StringBuilder sb=new StringBuilder();
        String base=getiTask().toString();
        sb.append(base,0,base.length()-1);
        sb.append(", deadline=").append(deadline);
        sb.append("}");
        return sb.toString();
    }
}
