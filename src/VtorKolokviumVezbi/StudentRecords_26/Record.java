package VtorKolokviumVezbi.StudentRecords_26;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Record {
    private String index;
    private String program;
    private List<Integer> grades;

    public Record() {
        this.grades = new ArrayList<>();
    }

    public Record(String line) {
        this();
        String[] split = line.trim().split("\\s+");
        this.index = split[0];
        this.program = split[1];
        IntStream.range(2, split.length)
                .forEach(i -> grades.add(Integer.parseInt(split[i])));
    }

    public String getIndex() {
        return index;
    }

    public String getProgram() {
        return program;
    }

    public double getAverage() {
        return grades.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
    }

    public int totalTens() {
        return (int) grades.stream().filter(g -> g == 10).count();
    }

    public int totalPerGrade(int grade) {
        return (int) grades.stream().filter(g -> g == grade).count();
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", index, getAverage());
    }
}