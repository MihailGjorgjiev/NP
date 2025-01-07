package CollectionBook.DesignPatterns.Payroll;

public abstract class BonusDecorator implements Employee {
    private Employee employee;

    public BonusDecorator(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public double getOvertime() {
        return employee.getOvertime();
    }

    @Override
    public int getTicketsCount() {
        return employee.getTicketsCount();
    }

    @Override
    public void updateBonus(double amount) {
        employee.updateBonus(amount);
    }

    @Override
    public String getLevel() {
        return employee.getLevel();
    }

    @Override
    public String toString() {
        return employee.toString()+String.format(" Bonus %.2f",getBonus());
    }
}
