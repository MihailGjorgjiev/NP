package VtorKolokviumVezbi.Telco_30;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TelcoApp {
    private Map<String, Call> calls;

    public TelcoApp() {
        this.calls = new HashMap<>();
    }

    public void addCall(String uuid, String dialer, String receiver, long timestamp) {
        Call call = new Call(uuid, dialer, receiver, timestamp);

        calls.put(uuid, call);
        calls.get(uuid).createCall();
    }

    public void updateCall(String uuid, long timestamp, String action) {
        calls.get(uuid).update(timestamp, action);
    }

    public void printChronologicalReport(String phoneNumber) {
        calls.values().stream()
                .filter(call -> call.getDialer().equals(phoneNumber) || call.getReceiver().equals(phoneNumber))
                .sorted(Comparator.comparing(call -> {
                    Long tss = call.getTimestampStart();
                    return tss != null ? tss : 0;
                }))
                .forEach(call -> System.out.println(call.report(phoneNumber)));
    }

    public void printReportByDuration(String phoneNumber) {
        calls.values().stream()
                .filter(call -> call.getDialer().equals(phoneNumber) || call.getReceiver().equals(phoneNumber))
                .sorted(Comparator.comparing(Call::getDuration, Comparator.reverseOrder()))
                .forEach(call -> System.out.println(call.report(phoneNumber)));
    }

    public void printCallsDuration() {
        Map<String, Long> results = calls.values().stream()
                .collect(
                        Collectors.groupingBy(
                                call -> String.format("%s <-> %s", call.getDialer(), call.getReceiver()),
                                Collectors.summingLong(Call::getDuration)
                        )
                );
        results.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach((entry) -> {
                    System.out.println(entry.getKey() + " : " + DurationConverter.convert(entry.getValue()));
                });
    }
}
