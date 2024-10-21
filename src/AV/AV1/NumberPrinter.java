package AV.AV1;

public class NumberPrinter {
    public static void formatNumbers(int howMany, int lineLength) {
        int n = 1;
        String line = "";
        while (n <= howMany) {
            String number = String.format("[%d]", n);
            if (line.length() + number.length() > lineLength) {
                System.out.println(line);
                line = "";
            }
            line+=number;
            n++;
        }
        if (!line.isEmpty()){
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        formatNumbers(250,60);
    }
}
