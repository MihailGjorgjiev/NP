package CollectionBook.OOP.Classes.IntegerArray;

import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {
    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int el = scanner.nextInt();
            array[i] = el;
        }
        return new IntegerArray(array);
    }
}
