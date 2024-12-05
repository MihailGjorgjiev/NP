package CollectionBook.OOP.Inheritance.Bank;

public abstract class Transaction {
    private long fromAccount;
    private long toAccount;
    private String description;
    private double amount;

    public Transaction(long fromAccount, long toAccount, String description, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.description = description;
        this.amount = amount;
    }

    public long getFromId() {
        return fromAccount;
    }

    public long getToId() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }


}
