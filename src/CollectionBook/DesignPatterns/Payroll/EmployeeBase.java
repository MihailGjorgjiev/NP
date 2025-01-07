package CollectionBook.DesignPatterns.Payroll;

import java.util.Comparator;

public abstract class EmployeeBase implements Comparable<EmployeeBase>,Employee {
    private String id;
    private String level;
    private double rate;
    private double totalBonus;

    public EmployeeBase(String id, String level, double rate) {
        this.id = id;
        this.level = level;
        this.rate = rate;
        this.totalBonus=0;
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public int compareTo(EmployeeBase o) {
        return Comparator.comparing(EmployeeBase::calculateSalary)
                .thenComparing(EmployeeBase::getLevel)
                .compare(this,o);
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f",
                id,level,calculateSalary()+totalBonus);
    }

    @Override
    public void updateBonus(double amount) {
        this.totalBonus+=amount;
    }

    @Override
    public double getBonus() {
        return totalBonus;
    }

    public String getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }
}
