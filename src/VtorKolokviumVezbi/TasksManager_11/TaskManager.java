package VtorKolokviumVezbi.TasksManager_11;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class TaskManager {
    private List<Task> tasks;
    private Map<String, List<Task>> tasksByCategory;
    private Map<Integer, List<Task>> tasksByPriority;

    public TaskManager() {
        tasks = new ArrayList<>();
        tasksByCategory = new HashMap<>();
        tasksByPriority = new HashMap<>();
    }

    public void readTasks(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        reader.lines()
                .forEach(line -> {
                    try {

                        String[] parts = line.trim().split(",");
                        String category = parts[0];
                        String title = parts[1];
                        String description = parts[2];
                        Task task;
                        if (parts.length == 3) {
                            task = new Task(category, title, description);
                        } else if (parts.length == 4) {
                            if (parts[3].length() <= 3) {
                                int priority = Integer.parseInt(parts[3]);
                                task = new Task(category, title, description, priority);
                            } else {
                                LocalDateTime deadline = LocalDateTime.parse(parts[3]);
                                if (deadline.isBefore(LocalDateTime.of(2020, 6, 2, 0, 0, 0))) {
                                    throw new DeadlineNotValidException("The deadline 2020-06-01T23:59:59 has already passed");
                                }
                                task = new Task(category, title, description, deadline);
                            }

                        } else {
                            LocalDateTime deadline = LocalDateTime.parse(parts[3]);
                            if (deadline.isBefore(LocalDateTime.of(2020, 6, 2, 0, 0, 0))) {
                                throw new DeadlineNotValidException("The deadline 2020-06-01T23:59:59 has already passed");
                            }
                            int priority = Integer.parseInt(parts[4]);
                            task = new Task(category, title, description, deadline, priority);
                        }
                        tasks.add(task);

                        tasksByCategory.putIfAbsent(task.getCategory(), new ArrayList<>());
                        tasksByPriority.putIfAbsent(task.getPriority(), new ArrayList<>());

                        tasksByCategory.get(task.getCategory()).add(task);
                        tasksByPriority.get(task.getPriority()).add(task);
                    } catch (DeadlineNotValidException e) {
                        System.out.println(e.getMessage());
                    }
                });
    }

    public void printTasks(OutputStream os, boolean includePriority, boolean includeCategory) {
        PrintWriter writer = new PrintWriter(os);
        if (includeCategory) {
            tasksByCategory.keySet().stream()
                    .forEach(key -> {
                        writer.println(key.toUpperCase());
                        if (includePriority) {
                            tasksByCategory.get(key).stream()
                                    .sorted(Comparator.comparing(Task::getPriority)
                                            .thenComparing((t1) -> Duration.between(t1.getDeadline(), LocalDateTime.now()),Comparator.reverseOrder()))
                                    .forEach(task -> {
                                        writer.println(task);
                                    });
                        } else {
                            tasksByCategory.get(key).stream()
                                    .forEach(task -> {
                                        writer.println(task);
                                    });
                        }

                    });
        } else {
            if (includePriority) {
                tasks.stream()
                        .sorted(Comparator.comparing(Task::getPriority)
                                .thenComparing((t1) -> Duration.between(t1.getDeadline(), LocalDateTime.now()),Comparator.reverseOrder()))
                        .forEach(task -> {
                            writer.println(task);
                        });
            } else {

                tasks.stream()
                        .sorted(Comparator.comparing(t->Duration.between(t.getDeadline(),LocalDateTime.now()),Comparator.reverseOrder()))
                .forEach(task -> {
                    writer.println(task);
                });
            }
        }
        writer.flush();
    }
}
