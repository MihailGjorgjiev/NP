package AV.AV2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringPrefix {
    public static boolean isPrefix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrefixStream(String str1,String str2){
        if(str1.length()>str2.length()){
            return false;
        }
        return IntStream.range(0,str1.length()).allMatch(i->str1.charAt(i) == str2.charAt(i));
    }


    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("abc", "xyz", "gh", "lmn", "uvw", "qrs", "defg", "aaa", "kl", "rst");
        List<String> list2 = Arrays.asList("abcdef", "mnopqr", "ghijkl", "lmnopqrst", "abcxyz", "qrstuv", "hijklmn", "aaabbbccc", "mnop", "rstuvw");
        List<Boolean> solutions = Arrays.asList(true, false, true, true, false, true, false, true, false, true);

//        int count= (int) IntStream.range(0, list1.size()).mapToObj(i->isPrefix(list1.get(i),list2.get(i)) == solutions.get(i)).filter(el->el).count();
        int count= (int) IntStream.range(0, list1.size()).mapToObj(i->isPrefixStream(list1.get(i),list2.get(i)) == solutions.get(i)).filter(el->el).count();
        System.out.println(String.format("%d/%d passed",count,solutions.size()));
    }


}
