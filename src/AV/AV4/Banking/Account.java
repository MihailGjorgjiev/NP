package AV.AV4.Banking;

public abstract class Account {
    private static int numberAccounts = 0;


    private String username;
    private int idSequenceNumber;
    private double balance;

    public Account(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.idSequenceNumber = numberAccounts;
        numberAccounts++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public void withdraw(double money) {
        this.balance -= money;
    }

}
