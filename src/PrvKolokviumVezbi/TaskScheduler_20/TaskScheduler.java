package PrvKolokviumVezbi.TaskScheduler_20;

import java.util.List;

public interface TaskScheduler<T>{
    List<T> schedule(T[] tasks);
}
