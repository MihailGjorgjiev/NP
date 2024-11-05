package Labs.Lab1.RomanConverter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class RomanConverter {
    public static HashMap<Integer, Character> arabicToRoman;
    public static List<Integer> keys;

    static {
        arabicToRoman = new HashMap<>();
        arabicToRoman.put(1, 'I');
        arabicToRoman.put(5, 'V');
        arabicToRoman.put(10, 'X');
        arabicToRoman.put(50, 'L');
        arabicToRoman.put(100, 'C');
        arabicToRoman.put(500, 'D');
        arabicToRoman.put(1000, 'M');

        keys=arabicToRoman.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static String toRoman(int number) {

//        List<Integer> keys = arabicToRoman.keySet().stream().sorted(Comparator.reverseOrder()).toList();
        String result = "";
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            while (number >= key) {
                result += arabicToRoman.get(key);
                number -= key;
            }
            if (String.valueOf(number).charAt(0) == '9') {
                if (number * 2 < key) continue;
                if (key < keys.get(i + 1) * 2) continue;
                number -= (key - keys.get(i + 2));
                result += String.format("%c%c", arabicToRoman.get(keys.get(i + 2)), arabicToRoman.get(key));
            }
            if (String.valueOf(number).charAt(0) == '4') {
                if (number * 2 < key) continue;
                if (key < keys.get(i + 1) * 5) continue;
                number -= (key - keys.get(i + 1));
                result += String.format("%c%c", arabicToRoman.get(keys.get(i + 1)), arabicToRoman.get(key));
            }

        }

        return result;
    }

}
