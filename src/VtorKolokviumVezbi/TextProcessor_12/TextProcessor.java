package VtorKolokviumVezbi.TextProcessor_12;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextProcessor {
    private Map<String, Integer> wordCount;
    private List<String> text;

    public TextProcessor() {
        this.wordCount = new TreeMap<>();
        this.text = new ArrayList<>();
    }

    public void readText(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        text = reader.lines()
                .collect(Collectors.toList());

        generateWordCount();
    }

    private void generateWordCount() {
        text.stream()
                .map(line -> line.trim().toLowerCase().replaceAll("[^a-zA-Z\\s]", ""))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .forEach(word -> {
                    wordCount.putIfAbsent(word, 0);
                    wordCount.computeIfPresent(word, (k, currentFreq) -> currentFreq + 1);
                });
    }


    public void printTextsVectors(OutputStream os) {
        PrintWriter writer = new PrintWriter(os);
        List<String> sortedKeys = wordCount.keySet().stream().collect(Collectors.toList());

        text.stream()
                .map(line -> line.trim().toLowerCase().replaceAll("[^a-zA-Z\\s]", ""))
                .forEach(line -> {
                    int[] vector=word2vec(line);
                    writer.println(Arrays.toString(vector));
                });

        writer.flush();

    }
    private  int[] word2vec(String line){
        String[] words = line.split("\\s+");
        List<String> sortedKeys = wordCount.keySet().stream().collect(Collectors.toList());
        int[] vector = new int[sortedKeys.size()];
        for (int i = 0; i < words.length; i++) {
            vector[sortedKeys.indexOf(words[i])]++;
        }
        return vector;
    }

    public void printCorpus(OutputStream os, int n, boolean ascending) {
        PrintWriter writer = new PrintWriter(os);


        Comparator<Map.Entry<String, Integer>> entryComparator =
                Comparator.comparing(Map.Entry::getValue);

        if (!ascending) {
            entryComparator = entryComparator.reversed();
        }

        wordCount.entrySet().stream()
                .sorted(entryComparator)
                .limit(n)
                .forEach(entry -> {
                    String output = String.format("%s : %d", entry.getKey(), entry.getValue());
                    writer.println(output);
                });


        writer.flush();
    }

    public void mostSimilarTexts(OutputStream os) {
        PrintWriter writer = new PrintWriter(os);
        List<String> cleanedText=text.stream()
                .map(line -> line.trim().toLowerCase().replaceAll("[^a-zA-Z\\s]", ""))
                .collect(Collectors.toList());
        double maxCoeff=0;

        int maxi=0,maxj=0;

        for (int i = 0; i < cleanedText.size()-1; i++) {
            for (int j = i+1; j < cleanedText.size(); j++) {
                List<Integer> vectori= Arrays.stream(word2vec(cleanedText.get(i))).boxed().collect(Collectors.toList());
                List<Integer> vectorj= Arrays.stream(word2vec(cleanedText.get(j))).boxed().collect(Collectors.toList());

                double coeff=CosineSimilarityCalculator.cosineSimilarity(vectori,vectorj);

                if(coeff>maxCoeff){
                    maxCoeff=coeff;
                    maxi=i;
                    maxj=j;
                }


            }

        }
            writer.println(text.get(maxi));
            writer.println(text.get(maxj));
            writer.println(String.format("%.10f",maxCoeff));
            writer.flush();
    }
}
