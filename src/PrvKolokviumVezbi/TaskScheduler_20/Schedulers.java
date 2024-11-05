package PrvKolokviumVezbi.TaskScheduler_20;

import java.util.List;

public class Schedulers {
    public static <T> TaskScheduler<T> getOrdered() {

        // vashiot kod ovde (annonimous class)
        return List::of;

    }

    public static <T> TaskScheduler<T> getFiltered(int order) {

        // vashiot kod ovde (lambda expression)
        if (order<0) return null;
        return List::of;
    }
}
