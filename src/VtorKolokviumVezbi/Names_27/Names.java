package VtorKolokviumVezbi.Names_27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Names {
    private final Map<String, Integer> uniqueNames;

    public Names() {
        this.uniqueNames = new TreeMap<>();
    }

    public void addName(String name) {
        uniqueNames.putIfAbsent(name, 0);
        uniqueNames.computeIfPresent(name, (key, val) -> val + 1);
    }

    public void printN(int n) {
        uniqueNames.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= n)
                .forEach(entry -> {
                    char[] charArray = entry.getKey().toLowerCase().toCharArray();
                    HashSet<Character> letters = new HashSet<>();
                    for (char c : charArray) {
                        letters.add(c);
                    }

                    System.out.printf("%s (%d) %d%n", entry.getKey(), entry.getValue(), letters.size());
                });
    }

    public String findName(int len, int x) {
        ArrayList<String> words = uniqueNames.keySet().stream()
                .filter(entry -> entry.length() < len)
                .collect(Collectors.toCollection(ArrayList::new));

        x = x % words.size();
        return words.get(x);
    }
}
