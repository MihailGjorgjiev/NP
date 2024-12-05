package AV.AV7.BenfordsLaw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class BenfordLawTest {
//    private static final String INPUT_FILE = "src/AV/AV7/BenfordsLaw/librarybooks.txt";

//        private static final String INPUT_FILE="src/AV/AV7/BenfordsLaw/livejournal.txt";
    private static final String INPUT_FILE="src/AV/AV7/BenfordsLaw/sunspots.txt";
    public static void main(String[] args) throws FileNotFoundException {
    NumbersReader numbersReader=new SunspotNumberReader();
        List<Integer> numbers=numbersReader.read(new FileInputStream(INPUT_FILE));
        BenfordLawTest benfordLawTest=new BenfordLawTest();
        int[] count= benfordLawTest.countsFunc(numbers);
        CountVisualizer countVisualizer=new CountVisualizer(100);
        countVisualizer.visualize(System.out,count);
    }
    public int[] counts(List<Integer> numbers){
        int[] result=new int[10];
        for(Integer number:numbers){
            int digit=firstDigit(number);
            result[digit]+=1;
        }
        return result;
    }
    public int[] countsFunc(List<Integer> numbers){
        return numbers.stream()
                .map(BenfordLawTest::firstDigit)
                .map(n->{
                    int[] res=new int[10];
                    res[n]++;
                    return res;
                })
                .reduce(new int[10],(left,right)->{
                    Arrays.setAll(left,i->left[i]+right[i]);
                    return left;
                });
    }
    public static int firstDigit(int num){
        while (num>=10){
            num/=10;
        }
        return num;
    }
}
