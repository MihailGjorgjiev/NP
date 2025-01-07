package VtorKolokviumVezbi.Logs_33;

import java.util.stream.Collectors;
import java.util.*;

public class Log {
    private String serviceName;
    private String microserviceName;
    private Type type;
    private String message;
    private long timestamp;

    public Log(String line) {
        String[] splitLine = line.split("\\s+");
        this.serviceName = splitLine[0];
        this.microserviceName = splitLine[1];
        this.type = Type.valueOf(splitLine[2]);
        this.timestamp = Long.parseLong(splitLine[splitLine.length - 1]);

        this.message = Arrays.stream(splitLine, 3, splitLine.length)
                .collect(Collectors.joining(" "));
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMicroserviceName() {
        return microserviceName;
    }

    public Type getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getSeverity() {
        switch (type) {
            case INFO:
                return 0;
            case WARN:
                int severity = 1;
                if (message.toLowerCase().contains("might cause error")) {
                    severity += 1;
                }
                return severity;
            case ERROR:
                int severity1 = 3;
                if (message.toLowerCase().contains("fatal")) {
                    severity1 += 2;
                }
                if (message.toLowerCase().contains("exception")) {
                    severity1 += 3;
                }
                return severity1;

            default:
                return 0;
        }

    }

    public static Comparator<Log> getComparator(String order) {
        if (Order.NEWEST_FIRST.name().equals(order)) {
            return Comparator.comparing(Log::getTimestamp, Comparator.reverseOrder());
        } else if (Order.OLDEST_FIRST.name().equals(order)) {
            return Comparator.comparing(Log::getTimestamp);
        } else if (Order.LEAST_SEVERE_FIRST.name().equals(order)) {
            return Comparator.comparing((Log log)->log.getType().ordinal())
                    .thenComparing(Log::getSeverity);
        } else {
//            return Comparator.comparing(Log::getSeverity);
            return Comparator.comparing((Log log)->log.getType().ordinal(), Comparator.reverseOrder())
                    .thenComparing(Log::getSeverity,Comparator.reverseOrder());
        }

    }

    @Override
    public String toString() {
        return String.format("%s|%s [%s] %s T:%d",serviceName,microserviceName,type,message,timestamp);
    }
}
