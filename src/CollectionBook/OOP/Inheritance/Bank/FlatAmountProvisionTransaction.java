package CollectionBook.OOP.Inheritance.Bank;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction{
    private double flatAmount;

    public FlatAmountProvisionTransaction(long fromAccount, long toAccount, String description, double amount, double flatAmount) {
        super(fromAccount, toAccount, description, amount);
        this.flatAmount = flatAmount;
    }

    public double getFlatAmount() {
        return flatAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return Double.compare(flatAmount, that.flatAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(flatAmount);
    }
}
