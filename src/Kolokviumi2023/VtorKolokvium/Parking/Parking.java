package Kolokviumi2023.VtorKolokvium.Parking;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Parking {
    private int capacity;
    private Map<String, ParkingEntry> parkingByRegistration;
    private Map<String, List<LocalDateTime>> spotOccupancyTime;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.parkingByRegistration = new TreeMap<>();
        this.spotOccupancyTime = new TreeMap<>();
    }

    public void update(String registration, String spot, LocalDateTime timestamp, boolean entry) {
        if (entry) {
            parkingByRegistration.putIfAbsent(registration+"-"+spot, new ParkingEntry(registration, spot, timestamp));
            parkingByRegistration.computeIfPresent(registration+"-"+spot, (k, v) -> {
                if (!v.isEntry()) {
                    v.reentry(timestamp, spot);
                }
                return v;
            });

            spotOccupancyTime.putIfAbsent(spot,new ArrayList<>());
            spotOccupancyTime.computeIfPresent(spot,(k,v)->{
                v.add(timestamp);
                return v;
            });
        } else {
            ParkingEntry pe = parkingByRegistration.get(registration+"-"+spot);
            pe.leave(timestamp);

            spotOccupancyTime.computeIfPresent(spot,(k,v)->{
                v.add(timestamp);
                return v;
            });
        }
    }

    public void currentState() {
        int totalParked = (int) parkingByRegistration.values().stream().filter(ParkingEntry::isEntry).count();
        double capacityFilled = ((double) totalParked / capacity) * 100.0;

        System.out.println(String.format("Capacity filled: %.2f%%", capacityFilled));
        parkingByRegistration.values().stream()
                .filter(ParkingEntry::isEntry)
                .sorted(Comparator.comparing(ParkingEntry::getTimestampEntry, Comparator.reverseOrder())
                        .thenComparing(ParkingEntry::getSpot,Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void history() {
        parkingByRegistration.values().stream()
                .filter(e -> !e.isEntry())
                .sorted(Comparator.comparing(p->DateUtil.durationBetween(p.getTimestampEntry(),p.getTimestampLeave()), Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public Map<String, Integer> carStatistics() {
        return parkingByRegistration.values().stream()
                .collect(Collectors.groupingBy(
                        ParkingEntry::getRegistration,
                        TreeMap::new,
                        Collectors.summingInt(ParkingEntry::getTimesParked)
                ));
    }

    public Map<String, Double> spotOccupancy(LocalDateTime start, LocalDateTime end) {
        return spotOccupancyTime.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double result = 0;
                            List<LocalDateTime> times = entry.getValue();
                            for (int i = 0; i < times.size(); i += 2) {
                                LocalDateTime from = times.get(i);
                                LocalDateTime to = times.get(i + 1);

                                if (from.isAfter(start) && to.isBefore(end)) { //    [from to]
                                    result += DateUtil.durationBetween(from, to);
                                } else if (from.isBefore(start) && to.isBefore(end)) {   //    from [to]
                                    result += DateUtil.durationBetween(start, to);
//                                    result+=0;
                                } else if (from.isAfter(start) && to.isAfter(end)) { //    [from] to
//                                    result+=0;
                                    result += DateUtil.durationBetween(from, end); // from [] to
                                } else {
                                    result += 0;
                                }
                            }
                            return result > 0 ? result * 100.0 / DateUtil.durationBetween(start, end) : 0.0;
                        },
                        Double::sum,
                        TreeMap::new
                ));

    }
}
