package CollectionBook.DesignPatterns.Payroll;

import java.util.Map;

public class HourlyEmployee extends EmployeeBase{
    private double hours;
    private double regular;
    private double overtime;
    public HourlyEmployee(String id, String level, double rate,double hours) {
        super(id, level, rate);
        this.hours=hours;

        this.overtime= Math.max(0,hours-40);
        this.regular=hours-overtime;
    }

    @Override
    public double calculateSalary() {
        return regular*getRate()+getOvertime();
    }

    @Override
    public double getOvertime() {
        return overtime*getRate()*1.5;
    }

    @Override
    public int getTicketsCount() {
        return -1;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(
                " Regular hours: %.2f Overtime hours: %.2f",regular,overtime);
    }
}
