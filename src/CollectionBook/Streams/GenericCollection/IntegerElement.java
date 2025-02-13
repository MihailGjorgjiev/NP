package CollectionBook.Streams.GenericCollection;

import java.time.LocalDateTime;

public class IntegerElement  implements Comparable<IntegerElement>,IHasTimestamp{
    private int value;
    private LocalDateTime timestamp;

    public IntegerElement(int value, LocalDateTime timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(IntegerElement o) {
        return Integer.compare(this.value,o.value);
    }

    @Override
    public String toString() {
        return "IntegerElement{" +
                "value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}
