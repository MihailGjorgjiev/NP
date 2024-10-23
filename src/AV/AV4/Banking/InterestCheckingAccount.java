package AV.AV4.Banking;

public class InterestCheckingAccount extends Account implements InterestBearingAccount{
    public static final double INTEREST_RATE=0.03;
    public InterestCheckingAccount(String username, double balance) {
        super(username, balance);
    }

    @Override
    public void addInterest() {
        this.deposit(this.getBalance()*INTEREST_RATE);
    }
}
