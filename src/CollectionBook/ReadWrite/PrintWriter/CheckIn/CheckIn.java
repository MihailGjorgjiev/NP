package CollectionBook.ReadWrite.PrintWriter.CheckIn;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckIn {
    List<LogElement> elements;
    public CheckIn() {
        elements=new ArrayList<>();
    }
    public void readTimes(InputStream inputStream) throws InvalidCheckInTimes {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String line=scanner.nextLine();
            elements.add(new LogElement(line));
        }
    }
    public void writeTimes(OutputStream outputStream){
        PrintWriter writer=new PrintWriter(outputStream);

        List<LogElement> sortedElements=elements.stream().sorted().collect(Collectors.toList());

        for(LogElement logElement:sortedElements){
            writer.println(logElement);
        }
        writer.flush();
    }

    public static void main(String[] args) {

        CheckIn in=new CheckIn();

        try {
            in.readTimes(System.in);
        } catch (InvalidCheckInTimes e) {
            throw new RuntimeException(e);
        }

        in.writeTimes(System.out);
    }
}
