package AV.AV5.TextFile.WordCount;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        if (args.length == 0) {
            System.out.println("Provide filename as argument");
            return;
        }
        for (String filename : args) {
            try {
                String wordCount = processFile(filename);
//                wordCount=processWthMapReduce(filename);
                result.append(String.format("%s -> %s\n", filename, wordCount));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(result.toString());

    }

    private static String processFile(String filename) throws IOException {
        int linesCount = 0;
        int wordsCount = 0;
        int charactersCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesCount++;
                String[] words = line.split("\\s+");
                wordsCount += words.length;
                charactersCount += line.length() + 1;
            }
        }
        return String.format("%d %d %d", linesCount, wordsCount, charactersCount);
    }

    private static String processWithConsumer(String filename) throws IOException {
        FileCounts fileCounts=new FileCounts();
        Files.lines(Paths.get(filename))
                .forEach(fileCounts);
        return fileCounts.toString();

    }

    private static String processWithMapReduce(String filename) throws IOException {
        Pattern word = Pattern.compile("\\s+");
        long[] result=Files.lines(Paths.get(filename))
                .map(line -> {
                    long words = word.split(line).length;
                    return new long[]{1, words, line.length() + 1};
                })
                .reduce(new long[]{0, 0, 0},
                        (left, right) -> {
                            long[] sum = new long[3];
                            Arrays.setAll(sum,i->left[i]+right[i]);
                            return sum;
                        });

        return Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    static class FileCounts implements Consumer<String>{
        private static final Pattern WORD=Pattern.compile("\\s+");
        long lines;
        long chars;
        long words;

        public FileCounts() {
            lines=0;
            chars=0;
            words=0;
        }

        @Override
        public void accept(String line) {
            lines++;
            this.chars+=line.length()+1;
            this.words+=WORD.split(line).length;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d",lines,words,chars);
        }
    }
}
