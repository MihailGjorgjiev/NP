package PrvKolokviumVezbi.MojDDV_16;

import java.io.IOException;

public class MojDDVTest {

    public static void main(String[] args) {

        MojDDV mojDDV = new MojDDV();

        System.out.println("===READING RECORDS FROM INPUT STREAM===");
        try {
            mojDDV.readRecords(System.in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===PRINTING TAX RETURNS RECORDS TO OUTPUT STREAM ===");
        try {
            mojDDV.printTaxReturns(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===PRINTING SUMMARY STATISTICS FOR TAX RETURNS TO OUTPUT STREAM===");
        try {
            mojDDV.printStatistics(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}