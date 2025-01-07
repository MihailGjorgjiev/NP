package CollectionBook.DesignPatterns.Payroll;

public class BonusNotAllowedException extends Exception{
    public BonusNotAllowedException(String bonus) {
        super(String.format("Bonus of %s is not allowed",bonus));
    }
}
