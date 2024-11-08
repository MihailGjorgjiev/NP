package Labs.Lab2.Bank;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction{
    private int centsPerDollar;
    public FlatPercentProvisionTransaction(long fromId, long toId, double amount,int centsPerDollar) {
        super(fromId, toId, "FlatPercent", amount);
        this.centsPerDollar=centsPerDollar;
    }


    public int getPercent() {
        return centsPerDollar;
    }
    public double getPercentAmount() {
        double percentAmount= (1+ centsPerDollar/100.0) * getAmount();
        return Double.parseDouble(String.format("%.2f",percentAmount));
    }

    public double getFlatProvision(){
        return (centsPerDollar/100.0) * getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDollar == that.centsPerDollar;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(centsPerDollar);
    }
}
