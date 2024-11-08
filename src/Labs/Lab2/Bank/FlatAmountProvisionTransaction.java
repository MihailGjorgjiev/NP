package Labs.Lab2.Bank;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction{
    private double flatProvision;
    public FlatAmountProvisionTransaction(long fromId, long toId,  double amount,double flatProvision) {
        super(fromId, toId, "FlatAmount", amount);
        this.flatProvision=flatProvision;
    }

    public double getFlatProvision() {
        return flatProvision;
    }

    public double getFlatAmount() {
        return flatProvision+getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return Double.compare(flatProvision, that.flatProvision) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(flatProvision);
    }
}
