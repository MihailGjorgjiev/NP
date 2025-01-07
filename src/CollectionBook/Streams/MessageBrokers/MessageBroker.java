package CollectionBook.Streams.MessageBrokers;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MessageBroker {
    private Map<String,Topic> topicMap;
    public static LocalDateTime startDate;
    public static Integer capacityPerTopic;

    public MessageBroker() {
        this.topicMap=new TreeMap<>();
    }

    public MessageBroker(LocalDateTime startDate,Integer capacityPerTopic) {
        this();
        MessageBroker.capacityPerTopic=capacityPerTopic;
        MessageBroker.startDate=startDate;
    }

    public void addTopic(String topic,int partitionCount){
        topicMap.put(topic,new Topic(topic,partitionCount));
    }

    public void addMessage(String topic,Message message) throws PartitionDoesNotExistException {
        if(message.getTimestamp().isBefore(startDate)){
            return;
        }
        topicMap.get(topic).addMessage(message);
    }
    public void changeTopicSettings(String topic,int partitionsCount) throws UnsupprotedOperationException {
        topicMap.get(topic).changeNumberOfPartitions(partitionsCount);
    }

    @Override
    public String toString() {
        return String.format("Broker with %2d topics:\n%s",
                topicMap.size(),
                topicMap.values().stream().map(Topic::toString)
                        .collect(Collectors.joining("\n")));
    }
}
