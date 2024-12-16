package Labs.Lab5.TermFrequency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TermFrequency {
    private Map<String,Integer> wordCount;

    public TermFrequency(InputStream inputStream,String[] stopWords) {
        wordCount=new TreeMap<>();
        List<String> stopList = Arrays.stream(stopWords)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

        reader.lines()
                .filter(line->!line.isEmpty() && !line.isBlank())
                .map(line->line.trim().toLowerCase())
                .map(line->line.split("\\s+"))
                .flatMap(sentence-> Arrays.stream(sentence))
//                .map(word->word.replaceAll("[^љњертѕуиопшѓжасдфгхјклчќзџцвбнмaèѝ0123456789]",""))
                .map(word->word.replaceAll("[,.]",""))
                .filter(word-> !stopList.contains(word) && !word.isEmpty())
                .forEach(word->{
                    wordCount.putIfAbsent(word,0);
                    wordCount.put(word,wordCount.get(word)+1);
                });
    }
    public int countTotal(){
        return wordCount.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int countDistinct(){
        return wordCount.size();
    }
    public List<String> mostOften(int k){
        return wordCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new)).subList(0,k);
    }
}