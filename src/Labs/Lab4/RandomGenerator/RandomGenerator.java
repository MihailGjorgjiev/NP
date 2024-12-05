package Labs.Lab4.RandomGenerator;


import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

    static Random random = new Random();

    // Generate a random integer between a and b (inclusive of a, exclusive of b)
    public static int randomBetween(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return a + random.nextInt(b - a);
    }

    // Generate a random double between 0.0 and 1.0
    public static double randomDouble() {
        return random.nextDouble();
    }

    // Generate a random double between a and b
    public static double randomDoubleBetween(double a, double b) {
        if (a > b) {
            double t = a;
            a = b;
            b = t;
        }
        return a + random.nextDouble() * (b - a);
    }

    // Generate a random integer within a specified range (inclusive)
    public static int randomIntInclusive(int a, int b) {
        return a + random.nextInt(b - a + 1);
    }

    // Generate a list of random integers between a and b (exclusive)
    public static List<Integer> listOfRandomBetween(int a, int b, int length) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        int lower = a;
        int upper = b;
        return IntStream.range(0, length).map(i -> +lower + random.nextInt(upper - lower)).boxed().collect(Collectors.toList());
    }

    // Generate a list of random longs between a and b (exclusive)
    public static List<Long> listOfRandomBetween(long a, long b, int length) {
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }

        long lower = a;
        long upper = b;
        return IntStream.range(0, length).mapToLong(i -> lower + (long) (random.nextDouble() * (upper - lower))).boxed().collect(Collectors.toList());
    }
}