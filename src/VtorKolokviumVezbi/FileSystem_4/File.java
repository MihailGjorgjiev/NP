package VtorKolokviumVezbi.FileSystem_4;

import java.time.LocalDateTime;
import java.util.Comparator;

public class File implements Comparable<File>{
    private String name;
    private Integer size;
    private LocalDateTime createdAt;

    public File() {
        this.name = "";
        this.size = 0;
        this.createdAt = LocalDateTime.now();
    }

    public File(String name, Integer size, LocalDateTime createdAt) {
        this.name = name;
        this.size = size;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Comparator<File> getComparator() {
        return Comparator
                .comparing(File::getCreatedAt)
                .thenComparing(File::getName)
                .thenComparing(File::getSize);
    }

    @Override
    public String toString() {
        return String.format("%-10s %5dB %s",name,size,createdAt);
    }

    @Override
    public int compareTo(File o) {
        return getComparator().compare(this,o);
    }
}
