package VtorKolokviumVezbi.TasksManager_11;

import java.time.LocalDateTime;

public class Task {
    private String category;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private int priority;

    public Task() {
        this.category = "category";
        this.title = "title";
        this.description = "description";
        this.deadline = LocalDateTime.MAX;
        this.priority = Integer.MAX_VALUE;
    }

    public Task(String category, String title, String description) {
        this.category = category;
        this.title = title;
        this.description = description;

        this.deadline = LocalDateTime.MAX;
        this.priority = Integer.MAX_VALUE;
    }

    public Task(String category, String title, String description, LocalDateTime deadline) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.deadline = deadline;

        this.priority = Integer.MAX_VALUE;
    }

    public Task(String category, String title, String description, int priority) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.priority = priority;

        this.deadline = LocalDateTime.MAX;
    }

    public Task(String category, String title, String description, LocalDateTime deadline, int priority) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        String res = "Task{" +
                "name='" + title + '\'' +
                ", description='" + description + '\'';
        if (deadline.isBefore(LocalDateTime.MAX)) {
            res += ", deadline=" + deadline;
        }
        if (priority < Integer.MAX_VALUE) {
            res += ", priority=" + priority;
        }
        res += '}';
        return res;
    }
}
