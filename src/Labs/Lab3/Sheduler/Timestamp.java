package Labs.Lab3.Sheduler;

import java.time.LocalDateTime;
import java.util.Objects;

public class Timestamp<T> implements Comparable<Timestamp<T>>{
    private final LocalDateTime time;
    private final T element;

    public Timestamp(LocalDateTime time, T element) {
        this.time = time;
        this.element = element;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public T getElement() {
        return element;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp<?> timestamp = (Timestamp<?>) o;
        return Objects.equals(time, timestamp.time);
    }

    @Override
    public String toString() {
        return String.format("%s %s",time,element);
    }

    @Override
    public int compareTo(Timestamp<T> o) {
        return time.compareTo(o.getTime());
    }
}
