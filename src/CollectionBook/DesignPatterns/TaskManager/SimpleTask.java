package CollectionBook.DesignPatterns.TaskManager;

import java.time.LocalDateTime;

public class SimpleTask implements ITask{
    private String category;
    private String name;
    private String description;

    public SimpleTask(String category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }

    @Override
    public LocalDateTime getDeadLine() {
        return LocalDateTime.MAX;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
