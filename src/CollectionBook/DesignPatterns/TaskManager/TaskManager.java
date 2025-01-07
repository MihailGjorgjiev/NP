package CollectionBook.DesignPatterns.TaskManager;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private Map<String, List<ITask>> tasks;

    public TaskManager() {
        this.tasks = new TreeMap<>();
    }

    public void readTasks(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        tasks=reader.lines()
                .map(line -> {
                    try {
                        return TaskFactory.createTask(line);
                    } catch (DeadlineNotValidException e) {
                        System.out.println(e.getMessage());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        ITask::getCategory,
                  TreeMap::new,
                  Collectors.toList()
                ));
    }

    public void addTask(ITask iTask){
        tasks.computeIfAbsent(iTask.getCategory(),k->new ArrayList<>());
        tasks.computeIfPresent(iTask.getCategory(),(k,v)->{
            v.add(iTask);
            return v;
        });
    }

    public void printTasks(OutputStream outputStream,
                           boolean includePriority,
                           boolean byCategory){
        PrintWriter writer=new PrintWriter(outputStream);

        Comparator<ITask> priorityComparator=
                Comparator.comparing(ITask::getPriority)
                        .thenComparing(task->
                                Duration.between(
                                        LocalDateTime.now(),
                                        task.getDeadLine()
                                ));

        Comparator<ITask> simpleComparator=
                Comparator.comparing(task->
                        Duration.between(
                                LocalDateTime.now(),
                                task.getDeadLine()
                        ));

        if(byCategory){
            tasks.forEach((category,t)->{
                writer.println(category.toUpperCase());
                t.stream()
                        .sorted(includePriority?priorityComparator:simpleComparator)
                        .forEach(writer::println);
            });
        }else {
            tasks.values().stream()
                    .flatMap(Collection::stream)
                    .sorted(includePriority?priorityComparator:simpleComparator)
                    .forEach(writer::println);
        }
        writer.flush();
    }
}






























