package PrvKolokviumVezbi.MojDDV_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MojDDV {
    private static final double TAX_TYPE_A = 0.18;
    private static final double TAX_TYPE_B = 0.05;
    private static final double TAX_TYPE_V = 0.00;

    List<Integer> ids;
    List<Integer> costs;
    List<Double> taxReturns;

    public MojDDV() {
        ids = new ArrayList<>();
        costs = new ArrayList<>();
        taxReturns = new ArrayList<>();
    }

    public void readRecords(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                int itemCost = 0;
                double itemTax = 0;
                for (int i = 1; i < parts.length; i += 2) {
                    int priceBeforeTax = Integer.parseInt(parts[i]);
                    char taxType = parts[i+1].charAt(0);
                    double tax;
                    switch (taxType) {
                        case 'A':
                            tax = priceBeforeTax * TAX_TYPE_A;
                            break;
                        case 'B':
                            tax = priceBeforeTax * TAX_TYPE_B;
                            break;
                        case 'V':
                            tax = priceBeforeTax * TAX_TYPE_V;
                            break;
                        default:
                            tax = 0;
                            break;
                    }
                    itemCost += priceBeforeTax;
                    itemTax += tax;
                }
                if(itemCost>30000){
                    try {
                        throw new AmountNotAllowedException(String.format("Receipt with amount %d is not allowed to be scanned",itemCost));
                    } catch (AmountNotAllowedException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }else{
                    ids.add(id);
                    costs.add(itemCost);
                    taxReturns.add(itemTax*0.15);

                }
            }
        }
    }

    public void printTaxReturns(OutputStream outputStream) throws IOException {
        try (BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream))){
            for(int i=0;i< ids.size();i++){
                writer.write(String.format("%d %d %.2f",ids.get(i),costs.get(i),taxReturns.get(i)));
                writer.newLine();

            }
        }
    }
}
