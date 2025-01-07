package VtorKolokviumVezbi.QuizProcessor_38;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuizProcessor {
    public static Map<String, Double> processAnswers(InputStream is) {
        Scanner scanner = new Scanner(is);

        Map<String, Double> result = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(";");
            String id = splitLine[0];
            String[] test = splitLine[1].split(", ");
            String[] quiz = splitLine[2].split(", ");
            try {
                if (test.length != quiz.length) {
                    throw new Exception("A quiz must have same number of correct and selected answers");
                } else {
                    double points = IntStream.range(0, test.length)
                            .mapToDouble(i -> {
                                if (test[i].equals(quiz[i])) {
                                    return 1.0;
                                } else {
                                    return -0.25;
                                }
                            }).sum();

                    result.put(id, points);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return result;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//
//        return reader.lines()
//                .map(line -> line.split(";"))
//                .collect(Collectors.groupingBy(
//                        strings -> strings[0],
//                        Collectors.summingDouble(strings -> {
//                            String[] test = strings[1].split(", ");
//                            String[] quiz = strings[2].split(", ");
//                            if (test.length != quiz.length) {
//                                return -1000.0;
//                            } else {
//                                return IntStream.range(0, test.length)
//                                        .mapToDouble(i -> {
//                                            if (test[i].equals(quiz[i])) {
//                                                return 1.0;
//                                            } else {
//                                                return -0.25;
//                                            }
//                                        }).sum();
//                            }
//                        })
//                )).entrySet().stream()
//                .filter(stringDoubleEntry -> stringDoubleEntry.getValue()!=-1000.0)
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1,e2)->e1,
//                        LinkedHashMap::new
//                        ));


    }
}
