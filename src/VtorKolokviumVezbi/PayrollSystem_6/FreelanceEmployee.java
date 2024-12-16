package VtorKolokviumVezbi.PayrollSystem_6;

import java.util.Arrays;

public class FreelanceEmployee extends Employee{
    private int numTickets;
    private int sumTickets;
    private double payment;
    public FreelanceEmployee(String id,String level,int[] tickets,double tokenRate) {
        super(id,level);
        numTickets=tickets.length;
        sumTickets= Arrays.stream(tickets).sum();
        setPayment(tokenRate);
    }
    private void setPayment(double tokenRate){
        payment=sumTickets*tokenRate;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public int getSumTickets() {
        return sumTickets;
    }

    @Override
    public double getPayment() {
        return payment;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(getPayment(),o.getPayment());
    }

    @Override
    public String toString() {
        String result=super.toString();
        result+=String.format(" Tickets count: %d Tickets points: %d",numTickets,sumTickets);

        return result;
    }
}
