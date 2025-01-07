package CollectionBook.Streams.MessageBrokers;

public class PartitionDoesNotExistException extends Exception {
    public PartitionDoesNotExistException(String topic,int partition) {
        super(String.format("The topic %s does not have a partition with number %d",topic,partition));
    }
}
