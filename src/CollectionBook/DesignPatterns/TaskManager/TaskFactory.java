package CollectionBook.DesignPatterns.TaskManager;

import java.time.LocalDateTime;

public class TaskFactory {
    public static ITask createTask(String line) throws DeadlineNotValidException {
        String[] parts = line.split(",");
        String category = parts[0];
        String name = parts[1];
        String description = parts[2];

        SimpleTask baseTask = new SimpleTask(category, name, description);

        if (parts.length == 3) {
            return baseTask;
        } else if (parts.length == 4) {
            try {
                int priority = Integer.parseInt(parts[3]);
                return new PriorityTaskDecorator(baseTask, priority);
            } catch (Exception e){
                LocalDateTime deadline=LocalDateTime.parse(parts[3]);
                checkDeadline(deadline);
                return new TimeTaskDecorator(baseTask,deadline);
            }
        }else {
            LocalDateTime deadline=LocalDateTime.parse(parts[3]);
            checkDeadline(deadline);
            int priority = Integer.parseInt(parts[3]);
            return new PriorityTaskDecorator(new TimeTaskDecorator(baseTask,deadline),priority);
        }
    }
    private static void checkDeadline(LocalDateTime deadline) throws DeadlineNotValidException {
        if(deadline.isBefore(LocalDateTime.now())){
            throw new DeadlineNotValidException(deadline);
        }
    }
}
