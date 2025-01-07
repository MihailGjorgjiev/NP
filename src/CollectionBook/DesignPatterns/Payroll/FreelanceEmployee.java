package CollectionBook.DesignPatterns.Payroll;

import java.util.List;

public class FreelanceEmployee extends EmployeeBase{
    private List<Integer> ticketPoints;
    public FreelanceEmployee(String id, String level, double rate,List<Integer> ticketPoints) {
        super(id, level, rate);
        this.ticketPoints=ticketPoints;
    }

    @Override
    public double calculateSalary() {
        return ticketPoints.stream().mapToInt(i->i).sum()*getRate();
    }

    @Override
    public double getOvertime() {
        return -1;
    }

    @Override
    public int getTicketsCount() {
        return ticketPoints.size();
    }

    @Override
    public String toString() {
        return super.toString()+String.format(
                " Tickets count: %d Ticket points: %d",
                ticketPoints.size(),
                ticketPoints.stream().mapToInt(i->i).sum());
    }
}
