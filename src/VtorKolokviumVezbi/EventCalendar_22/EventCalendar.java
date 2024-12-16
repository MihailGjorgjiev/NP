package VtorKolokviumVezbi.EventCalendar_22;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventCalendar {
    private int year;
    private Set<Event> events;

    public EventCalendar(int year) {
        this.year = year;

        this.events = new TreeSet<>(Comparator.comparing(Event::getDate)
                .thenComparing(Event::getName));
    }

    public void addEvent(String name, String location, Date date) throws WrongDateException {
        if (date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() != year) {
            throw new WrongDateException("Wrong date: " + date);
        }
        events.add(new Event(name, location, date));

    }

    public void listEvents(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormat.format(date);

        Set<Event> collect = events.stream()
                .filter(e -> simpleDateFormat.format(e.getDate()).equals(currentDate))
                .collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Event::getDate)
                        .thenComparing(Event::getName))));
        if (collect.isEmpty()) {
            System.out.println("No events on this day!");
        } else {
            collect.stream().forEach(System.out::println);
        }
    }

    public void listByMonth() {
        IntStream.range(1, 13).forEach(m -> {
            int n = (int) events.stream()
                    .filter(e -> e.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue() == m)
                    .count();
            System.out.println(String.format("%d : %d", m, n));
        });
    }

}
