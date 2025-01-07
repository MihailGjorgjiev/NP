package VtorKolokviumVezbi.Logs_33;

import java.util.*;
import java.util.stream.Collectors;

public class LogCollector {
    private Map<String, Map<String, List<Log>>> services;

    public LogCollector() {
        this.services = new HashMap<>();
    }

    public void addLog(String line) {
        Log log = new Log(line);
        services.putIfAbsent(log.getServiceName(), new HashMap<>());
        services.get(log.getServiceName()).putIfAbsent(log.getMicroserviceName(), new ArrayList<>());
        services.get(log.getServiceName()).get(log.getMicroserviceName()).add(log);
    }

    public void printServicesBySeverity() {
        Map<String, List<Log>> groupedLogs = services.values().stream()
                .flatMap(micro -> micro.values().stream())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Log::getServiceName,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        groupedLogs.entrySet().stream()
                .sorted(Comparator.comparing(stringListEntry -> stringListEntry.getValue().stream().mapToInt(Log::getSeverity).average().orElse(0), Comparator.reverseOrder()))
                .forEach(stringListEntry -> {
                    String name = stringListEntry.getKey();
                    int microCount = stringListEntry.getValue().stream().map(Log::getMicroserviceName).collect(Collectors.toSet()).size();
                    int totalLogs = stringListEntry.getValue().size();
                    double avgSeverity = stringListEntry.getValue().stream().mapToInt(Log::getSeverity).average().orElse(0);
                    double avgMicro = stringListEntry.getValue().stream()
                            .collect(Collectors.groupingBy(
                                    Log::getMicroserviceName,
                                    Collectors.counting()
                            )).values().stream().mapToInt(Math::toIntExact).average().orElse(0);


                    String output = String.format("Service name: %s Count of microservices: %d Total logs in service: %d Average severity for all logs: %.2f Average number of logs per microservice: %.2f", name, microCount, totalLogs, avgSeverity, avgMicro);
                    System.out.println(output);
                });


    }

    public Map<Integer, Integer> getSeverityDistribution(String service, String microservice) {
        if (microservice == null) {
            return services.get(service).values().stream().flatMap(Collection::stream)
                    .collect(Collectors.groupingBy(
                            Log::getSeverity,
                            Collectors.summingInt(i -> 1)
                    ));
        }
        return services.get(service).get(microservice).stream()
                .collect(Collectors.groupingBy(
                        Log::getSeverity,
                        Collectors.summingInt(i -> 1)
                ));
    }


    public void displayLogs(String service, String microservice, String order) {
        Comparator<Log> logComparator = Log.getComparator(order);
        if (microservice == null) {
            services.get(service).values().stream().flatMap(Collection::stream)
                    .sorted(logComparator)
                    .forEach(System.out::println);
            return;
        }
        services.get(service).get(microservice).stream()
                .sorted(logComparator)
                .forEach(System.out::println);
    }


}
