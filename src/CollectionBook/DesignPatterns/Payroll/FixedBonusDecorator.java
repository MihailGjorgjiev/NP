package CollectionBook.DesignPatterns.Payroll;

public class FixedBonusDecorator extends BonusDecorator {
    private double fixedAmount;

    public FixedBonusDecorator(Employee employee, double fixedAmount) {
        super(employee);
        this.fixedAmount = fixedAmount;
        getEmployee().updateBonus(fixedAmount);
    }

    @Override
    public double calculateSalary() {
        double salaryWithoutBonus= getEmployee().calculateSalary();
        return salaryWithoutBonus+fixedAmount;
    }

    @Override
    public double getBonus() {
        return fixedAmount;
    }
}
