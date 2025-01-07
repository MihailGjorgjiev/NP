package CollectionBook.DesignPatterns.TaskManager;

import java.time.LocalDateTime;

public interface ITask {
    LocalDateTime getDeadLine();
    int getPriority();
    String getCategory();
}
