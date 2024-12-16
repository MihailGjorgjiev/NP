package Labs.Lab6.Anagrams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        findAll(System.in);
    }


    public static void findAll(InputStream inputStream) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

        List<String> words = reader.lines()
                .collect(Collectors.toList());


        Map<String, List<String>> anagramGroups = words.stream()
                .collect(Collectors.groupingBy(word -> {
                    char[] charArray = word.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                },LinkedHashMap::new,Collectors.toList()));

        anagramGroups.values().stream()
                .forEach(list->{
                    System.out.println(String.join(" ", list));
                });

    }
}
