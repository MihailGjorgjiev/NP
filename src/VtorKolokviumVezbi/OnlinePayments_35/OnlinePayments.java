package VtorKolokviumVezbi.OnlinePayments_35;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OnlinePayments {
    private Map<String, List<Transaction>> transactions;

    public OnlinePayments() {
        this.transactions = new HashMap<>();
    }

    public void readItems(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        reader.lines()
                .forEach(line -> {
                    String[] splitLine = line.trim().split(";");
                    transactions.putIfAbsent(splitLine[0], new ArrayList<>());
                    transactions.get(splitLine[0]).add(new Transaction(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2])));

                });
    }

    public void printStudentReport(String index, OutputStream os) {
        PrintWriter writer = new PrintWriter(os);

        List<Transaction> student = transactions.getOrDefault(index, null);

        if (student == null) {
            System.out.println(String.format("Student %s not found!", index));
            return;
        }

        int totalPrice = student.stream().mapToInt(Transaction::getPrice).sum();
        int fee = (int) Math.round(totalPrice * 0.0114);
        if (fee < 3) fee = 3;
        if (fee > 300) fee = 300;
        int totalAfterTax = totalPrice + fee;
        System.out.println(String.format("Student: %s Net: %s Fee: %d Total: %d", index, totalPrice, fee, totalAfterTax));
        System.out.println("Items:");

        List<Transaction> sortedStudent = student.stream().sorted(Comparator.comparing(Transaction::getPrice, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        IntStream.range(0, sortedStudent.size()).forEach(i -> {
            System.out.println(String.format("%d. %s", i + 1, sortedStudent.get(i)));
        });

    }
}
