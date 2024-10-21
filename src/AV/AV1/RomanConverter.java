package AV.AV1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanConverter {
    public static HashMap<Integer,Character> romanNumerals;
    public static List<Integer> keysInOrder;
    static {
        romanNumerals=new HashMap<>();
        romanNumerals.put(1,'I');
        romanNumerals.put(5,'V');
        romanNumerals.put(10,'X');
        romanNumerals.put(50,'L');
        romanNumerals.put(100,'C');
        romanNumerals.put(500,'D');
        romanNumerals.put(1000,'M');

        keysInOrder=romanNumerals.keySet().stream().
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }
    public static String toRoman(int number) {
        String result="";

        for(int i=0;i< keysInOrder.size();i++){

            while (number>= keysInOrder.get(i)){
                number-= keysInOrder.get(i);
                result+=romanNumerals.get(keysInOrder.get(i));
            }
            if(String.format("%d",number).charAt(0) == '9'){
                if(number*2< keysInOrder.get(i)) continue;
                if(keysInOrder.get(i)!=keysInOrder.get(i+1)*2){
                    continue;
                }
                number-=(keysInOrder.get(i)-keysInOrder.get(i+2));
                result+=romanNumerals.get(keysInOrder.get(i+2));
                result+=romanNumerals.get(keysInOrder.get(i));
            }
            if(String.format("%d",number).charAt(0) == '4'){
                if(number*2< keysInOrder.get(i)) continue;
                if(keysInOrder.get(i)!=keysInOrder.get(i+1)*5){
                    continue;
                }
                number-=(keysInOrder.get(i)-keysInOrder.get(i+1));
                result+=romanNumerals.get(keysInOrder.get(i+1));
                result+=romanNumerals.get(keysInOrder.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> testCases = Arrays.asList(1, 4, 9, 58, 199, 2021, 2456, 2999, 3120, 3999, 4444, 2500, 3333, 4000, 4789, 4999);

        List<String> solutions = Arrays.asList("I", "IV", "IX", "LVIII", "CXCIX", "MMXXI", "MMCDLVI", "MMCMXCIX", "MMMCXX", "MMMCMXCIX", "MMMMCDXLIV", "MMD", "MMMCCCXXXIII", "MMMM", "MMMMDCCLXXXIX", "MMMMCMXCIX");


        int results= (int) IntStream.range(0, testCases.size()).filter(i->toRoman(testCases.get(i)).equals(solutions.get(i))).count();
        System.out.println(String.format("%d/%d passed",results,testCases.size()));


    }
}
