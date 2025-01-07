package CollectionBook.DesignPatterns.Payroll;

public class PercentageBonusDecorator extends BonusDecorator{
    private double percentage;
    private double bonus;
    public PercentageBonusDecorator(Employee employee,double percent) {
        super(employee);
        this.percentage=percent;
        this.bonus= getEmployee().calculateSalary()*percentage/100.0;
        getEmployee().updateBonus(bonus);
    }

    @Override
    public double calculateSalary() {
        double salaryWithoutBonus= getEmployee().calculateSalary();
        return salaryWithoutBonus+bonus;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}
