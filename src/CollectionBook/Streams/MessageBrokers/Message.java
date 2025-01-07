package CollectionBook.Streams.MessageBrokers;


import java.time.LocalDateTime;

public class Message implements Comparable<Message> {
    private LocalDateTime timestamp;
    private String message;
    private Integer partition;
    private String key;

    public Message(LocalDateTime timestamp, String message, Integer partition, String key) {
        this.timestamp = timestamp;
        this.message = message;
        this.partition = partition;
        this.key = key;
    }

    public Message(LocalDateTime timestamp, String message, String key) {
        this.timestamp = timestamp;
        this.message = message;
        this.key = key;
        this.partition=null;
    }


    @Override
    public int compareTo(Message o) {
        return this.timestamp.compareTo(o.timestamp);
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getPartition() {
        return partition;
    }

    public String getKey() {
        return key;
    }
}
