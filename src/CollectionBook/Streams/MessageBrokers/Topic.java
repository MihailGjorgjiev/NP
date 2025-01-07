package CollectionBook.Streams.MessageBrokers;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Topic {
    private String topicName;
    Map<Integer, Set<Message>> messagesByPartitions;
    private int partitionCount;

    public Topic() {
        this.messagesByPartitions = new TreeMap<>();
    }

    public Topic(String topicName, int partitionCount) {
        this();
        this.topicName = topicName;
        this.partitionCount = partitionCount;

        IntStream.range(1, partitionCount + 1)
                .forEach(i -> messagesByPartitions.putIfAbsent(i, new TreeSet<>()));
    }

    public void addMessage(Message message) throws PartitionDoesNotExistException {
        Integer messagePartition = message.getPartition();
        if (messagePartition == null) {
            messagePartition = (Math.abs(message.getKey().hashCode()) % this.partitionCount) + 1;
        }
        if (!messagesByPartitions.containsKey(messagePartition)) {
            throw new PartitionDoesNotExistException(topicName, messagePartition);
        }

        messagesByPartitions.computeIfPresent(messagePartition, (k, v) -> {
            if (v.size() == MessageBroker.capacityPerTopic) {
                v.remove(v.stream().findFirst().orElse(null));
            }
            v.add(message);
            return v;
        });
    }


    public void changeNumberOfPartitions(int newPartitionsNumber) throws UnsupprotedOperationException {
        if (newPartitionsNumber < this.partitionCount) {
            throw new UnsupprotedOperationException("Partitions number cannot be decreased!");
        } else {
            int diff = newPartitionsNumber - this.partitionCount;
            int size = this.messagesByPartitions.size();
            for (int i = 1; i <= diff; i++) {
                this.messagesByPartitions.putIfAbsent(size + i, new TreeSet<>());
            }
            this.partitionCount = newPartitionsNumber;
        }
    }

    @Override
    public String toString() {
        String messages = messagesByPartitions.entrySet().stream()
                .map(entry ->
                        String.format("%2d : Count of messages: %5d\n%s",
                                entry.getKey(),
                                entry.getValue().size(),
                                !entry.getValue().isEmpty() ?
                                        "Messages:\n" + entry.getValue().stream()
                                                .map(Message::toString)
                                                .collect(Collectors.joining("\n")) :
                                        "")
                ).collect(Collectors.joining("\n"));
        return String.format("Topic :%10s Partitions: %5d\n%s", topicName, partitionCount, messages);
    }
}
