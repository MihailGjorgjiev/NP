package AV.AV5.TextFile.LongestPalindrome;

import java.io.*;
import java.util.Comparator;
import java.util.stream.IntStream;

public class LongestPalindrome {
    public static final String FILENAME="src/AV/AV5/TextFile/LongestPalindrome/words.txt";

    public static void main(String[] args) {
        try {
//            System.out.println(findLongest(new FileInputStream(FILENAME)));
            System.out.println(findLongestFunc(new FileInputStream(FILENAME)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String findLongestFunc(FileInputStream inputStream) throws IOException {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))){
            return reader.lines()
                    .filter(LongestPalindrome::isPalindromeFunc)
                    .max(Comparator.comparing(String::length))
                    .orElse(null);

        }
    }

    static boolean isPalindromeFunc(String word){
        return IntStream.range(0,word.length()/2)
                .allMatch(i->word.charAt(i)==word.charAt(word.length()-1-i));
    }

    static String findLongest(InputStream inputStream) throws IOException {
        String longest=null;

        try (BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream))){
            String word;
            while ((word= reader.readLine())!=null){
                if(isPalindrome(word)){
                    if (longest==null){
                        longest=word;
                    }else {
                        if(word.length()>longest.length()){
                            longest=word;
                        }
                    }
                }
            }
        }
        return longest;
    }

    static boolean isPalindrome(String word) {
        int len=word.length();
        for (int i = 0; i < len / 2; i++) {
            if(word.charAt(i)!=word.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
