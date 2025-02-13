package VtorKolokviumVezbi.MapSorting_19;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class MapSortingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> l = readMapPairs(scanner);
        if (n == 1) {
            Map<String, Integer> map = new HashMap<>();
            fillStringIntegerMap(l, map);
            SortedSet<Map.Entry<String, Integer>> s = entriesSortedByValues(map);
            System.out.println(s);
        } else {
            Map<Integer, String> map = new HashMap<>();
            fillIntegerStringMap(l, map);
            SortedSet<Map.Entry<Integer, String>> s = entriesSortedByValues(map);
            System.out.println(s);
        }

    }

    private static <T extends Comparable<T>, U extends Comparable<U>> SortedSet<Map.Entry<T, U>> entriesSortedByValues(Map<T, U> map) {
        System.out.println(map);
        Comparator<Map.Entry<T,U>> comparator=new Comparator<Map.Entry<T, U>>() {
            @Override
            public int compare(Map.Entry<T, U> o1, Map.Entry<T, U> o2) {
                int value = o1.getValue().compareTo(o2.getValue());
                return value != 0 ? -value : 1;
            }
        };
        return map.entrySet().stream()
                .collect(Collectors.toCollection(()->new TreeSet<>(comparator)));

    }


private static List<String> readMapPairs(Scanner scanner) {
    String line = scanner.nextLine();
    String[] entries = line.split("\\s+");
    return Arrays.asList(entries);
}

static void fillStringIntegerMap(List<String> l, Map<String, Integer> map) {
    l.stream()
            .forEach(s -> map.put(s.substring(0, s.indexOf(':')), Integer.parseInt(s.substring(s.indexOf(':') + 1))));
}

static void fillIntegerStringMap(List<String> l, Map<Integer, String> map) {
    l.stream()
            .forEach(s -> map.put(Integer.parseInt(s.substring(0, s.indexOf(':'))), s.substring(s.indexOf(':') + 1)));
}

//вашиот код овде
}