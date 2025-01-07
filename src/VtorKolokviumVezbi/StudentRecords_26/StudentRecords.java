package VtorKolokviumVezbi.StudentRecords_26;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentRecords {
    private Map<String, Set<Record>> records;

    public StudentRecords() {
        this.records = new TreeMap<>();
    }

    public int readRecords(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final int[] counter = {0};
        Comparator<Record> recordComparator =
                Comparator.comparing(Record::getAverage, Comparator.reverseOrder())
                        .thenComparing(Record::getIndex);
        reader.lines()
                .forEach(line -> {
                    counter[0]++;
                    Record record = new Record(line);
                    records.putIfAbsent(record.getProgram(), new TreeSet<>(recordComparator));
                    records.get(record.getProgram()).add(record);
                });
        return counter[0];
    }

    public void writeTable(OutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);

        records.entrySet().stream()
                .forEach(entry -> {
                    writer.println(entry.getKey());
                    entry.getValue().stream()
                            .forEach(writer::println);
                });

        writer.flush();
    }

    public void writeDistribution(OutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        records.entrySet().stream()
                .sorted((o1, o2) -> {
                    int sum1 = o1.getValue().stream().mapToInt(Record::totalTens).sum();
                    int sum2 = o2.getValue().stream().mapToInt(Record::totalTens).sum();

                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ))
                .forEach((key, value) -> {
                    writer.println(key);
                    IntStream.range(6, 11)
                            .forEach(i -> {
                                int total = value.stream().mapToInt(s -> s.totalPerGrade(i)).sum();
                                writer.write(String.format("%2d | ",i));
                                for (int j = 0; j < total; j += 10) {
                                    writer.write("*");
                                }
                                writer.write(String.format("(%d)\n", total));
                            });
                });
        writer.flush();
    }
}