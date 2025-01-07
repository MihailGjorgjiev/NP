package CollectionBook.DesignPatterns.Payroll;

public interface Employee {
    double calculateSalary();
    double getBonus();
    double getOvertime();
    int getTicketsCount();
    void updateBonus(double amount);
    String getLevel();
}
