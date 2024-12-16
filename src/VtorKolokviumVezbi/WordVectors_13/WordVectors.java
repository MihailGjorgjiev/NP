package VtorKolokviumVezbi.WordVectors_13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordVectors {
    private Map<String, List<Integer>> vectors;
    private List<String> wordList;

    public WordVectors() {
        this.wordList = new ArrayList<>();
        this.vectors = new HashMap<>();
    }

    public WordVectors(String[] words, List<List<Integer>> vectors) {
        this();
        for (int i = 0; i < words.length; i++) {
            this.vectors.put(words[i], vectors.get(i));
        }
    }

    private static List<Integer> sum(List<Integer> l1, List<Integer> l2) {
        return IntStream.range(0, l1.size()).map(i -> l1.get(i) + l2.get(i)).boxed().collect(Collectors.toList());
    }

    public void readWords(List<String> words) {
        wordList = new ArrayList<>(words);
    }

    public List<Integer> slidingWindow(int n) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < wordList.size() - n + 1; i++) {
//            List<Integer> acc = Arrays.stream(new int[5]).boxed().collect(Collectors.toList());
//            for (int j = 0; j < n; j++) {
//                List<Integer> vec = vectors.getOrDefault(wordList.get(i + j), Arrays.stream(new int[]{5, 5, 5, 5, 5}).boxed().collect(Collectors.toList()));
//                acc = sum(acc, vec);
//            }
//            result.add(acc.stream().mapToInt(x -> x).max().orElse(0));
//
//        }
        return IntStream.range(0, wordList.size() - n + 1)
                .mapToObj(i -> {
                    return IntStream.range(0, n).mapToObj(j -> vectors.getOrDefault(wordList.get(i + j), Arrays.stream(new int[]{5, 5, 5, 5, 5}).boxed().collect(Collectors.toList())))
                            .reduce(Arrays.stream(new int[5]).boxed().collect(Collectors.toList()), (left, right) -> {
                                return IntStream.range(0, right.size()).map(inx -> left.get(inx) + right.get(inx)).boxed().collect(Collectors.toList());
                            }).stream().mapToInt(inx->inx).max().orElse(0);
                }).collect(Collectors.toList());
//        return result;
    }


}
