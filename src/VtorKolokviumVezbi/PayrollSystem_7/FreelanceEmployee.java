package VtorKolokviumVezbi.PayrollSystem_7;

import java.util.List;

public class FreelanceEmployee extends Employee {
    private List<Integer> tickets;


    public FreelanceEmployee(String id, String level, double rate, String bonus, List<Integer> tickets) {
        super(id, level, rate, bonus);
        this.tickets = tickets;
    }

    public List<Integer> getTickets() {
        return tickets;
    }

    public void setTickets(List<Integer> tickets) {
        this.tickets = tickets;
    }

    public int ticketSum() {
        return tickets.stream().mapToInt(i -> i).sum();
    }

    @Override
    public double salary() {
        return getRate() * ticketSum();

    }

    @Override
    public String toString() {
        String baseString = super.toString();
        return baseString + String.format(" Tickets count: %d Tickets points: %d", tickets.size(), ticketSum());
    }
}
