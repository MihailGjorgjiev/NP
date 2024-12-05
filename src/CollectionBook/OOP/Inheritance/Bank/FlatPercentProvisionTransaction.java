package CollectionBook.OOP.Inheritance.Bank;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction{
    private int flatPercent;

    public FlatPercentProvisionTransaction(long fromAccount, long toAccount, String description, double amount, int flatPercent) {
        super(fromAccount, toAccount, description, amount);
        this.flatPercent = flatPercent;
    }

    public int getPercent() {
        return flatPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return flatPercent == that.flatPercent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(flatPercent);
    }
}
