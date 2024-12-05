package AV.AV7.ArrangeLetters;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ArrangeLetters {
    public static String arrange(String input){
        String[] parts=input.split(" ");
        for (int i = 0; i < parts.length; i++) {
            char[] word=parts[i].toCharArray();
            Arrays.sort(word);
            parts[i]=new String(word);
        }

        return Arrays.stream(parts)
                .sorted()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String line="kO pSk sO";
        String result=arrange(line);
        System.out.println(result);
    }
}
