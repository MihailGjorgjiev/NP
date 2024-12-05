package Labs.Lab4.RandomGenerator;

import java.util.List;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Test randomBetween for integers
        int a = sc.nextInt();
        int b = sc.nextInt();

        int x = RandomGenerator.randomBetween(a, b);

        TestNumber<Integer> testRandomBetween = n -> n >= a && n < b;
        System.out.println("Test for randomBetween method: " + testRandomBetween.test(x));

        // Test randomDouble
        double randomDouble = RandomGenerator.randomDouble();
        TestNumber<Double> testRandomDouble = n -> n>=0.0 && n<1.0;
        System.out.println("Test for randomDouble method: " + testRandomDouble.test(randomDouble));


        // Test randomDoubleBetween

        double da = sc.nextDouble();
        double db = sc.nextDouble();
        double randomDoubleBetween = RandomGenerator.randomDoubleBetween(da, db);

        TestNumber<Double> testRandomDoubleBetween = n -> n >= da && n < db;
        System.out.println("Test for randomDoubleBetween method: " + testRandomDoubleBetween.test(randomDoubleBetween));

        // Test randomIntInclusive

        int inclusiveA = sc.nextInt();
        int inclusiveB = sc.nextInt();
        int randomIntInclusive = RandomGenerator.randomIntInclusive(inclusiveA, inclusiveB);

        TestNumber<Integer> testRandomIntInclusive = n -> n >= inclusiveA && n <= inclusiveB;
        System.out.println("Test for randomIntInclusive method: " + testRandomIntInclusive.test(randomIntInclusive));

        // Test listOfRandomBetween for integers

        int listA = sc.nextInt();
        int listB = sc.nextInt();
        int listLength = sc.nextInt();
        List<Integer> randomIntList = RandomGenerator.listOfRandomBetween(listA, listB, listLength);

        TestNumbersList<Integer> testRandomIntList = numbers -> numbers.stream().allMatch(n -> n >= listA && n < listB);
        System.out.println("Test for listOfRandomBetween (int): " + testRandomIntList.test(randomIntList));

        // Test listOfRandomBetween for longs

        long longA = sc.nextLong();
        long longB = sc.nextLong();
        int longListLength = sc.nextInt();
        List<Long> randomLongList = RandomGenerator.listOfRandomBetween(longA, longB, longListLength);

        TestNumbersList<Long> testRandomLongList = numbers -> numbers.stream().allMatch(n -> n >= longA && n < longB);
        System.out.println("Test for listOfRandomBetween (long): " + testRandomLongList.test(randomLongList));

        sc.close();
    }
}