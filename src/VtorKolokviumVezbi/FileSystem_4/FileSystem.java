package VtorKolokviumVezbi.FileSystem_4;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FileSystem {
    private Map<Character, Set<File>> folders;

    public FileSystem() {
        this.folders = new HashMap<>();
    }

    public void addFile(char folder, String name, int size, LocalDateTime createdAt) {
        File file = new File(name, size, createdAt);
        folders.putIfAbsent(folder, new LinkedHashSet<>());
        folders.get(folder).add(file);
    }

    public List<File> findAllHiddenFilesWithSizeLessThen(int size) {
        return folders.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.getName().startsWith(".") && file.getSize() < size)
                .sorted(Comparator.comparing(File::getName))
                .collect(Collectors.toList());
    }

    public int totalSizeOfFilesFromFolders(List<Character> folders) {
        return folders.stream().mapToInt(folder -> this.folders.get(folder).stream().mapToInt(File::getSize).sum())
                .sum();
    }

    private Set<File> getAllFilesByYear(int year) {
        return folders.values().stream().
                flatMap(Collection::stream)
                .filter(file -> file.getCreatedAt().getYear() == year)
                .collect(Collectors.toSet());
    }

    private long getFileSizeByMonthAndDay(String date) {
        String[] splitDate = date.split("-");
        String month = splitDate[0];
        int day = Integer.parseInt(splitDate[1]);

        return folders.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.getCreatedAt().getMonth().toString().equals(month) && file.getCreatedAt().getDayOfMonth() == day)
                .mapToLong(File::getSize)
                .sum();
    }

    public Map<Integer, Set<File>> byYear() {
        Map<Integer, Set<File>> result = new HashMap<>();

        Set<Integer> years = folders.values().stream().
                flatMap(Collection::stream)
                .mapToInt(file -> file.getCreatedAt().getYear())
                .boxed()
                .collect(Collectors.toSet());

        years.stream()
                .forEach(year -> {
                    Set<File> set = getAllFilesByYear(year);
                    result.put(year, set);
                });
        return result;
    }

    public Map<String, Long> sizeByMonthAndDay() {
        Map<String, Long> result = new HashMap<>();
        Set<String> dates = folders.values().stream()
                .flatMap(folder -> folder.stream())
                .map(file -> String.format("%s-%d", file.getCreatedAt().getMonth(), file.getCreatedAt().getDayOfMonth()))
                .collect(Collectors.toSet());

        dates.stream()
                .forEach(date ->
                        result.put(date, getFileSizeByMonthAndDay(date))
                );

        return result;
    }
}
