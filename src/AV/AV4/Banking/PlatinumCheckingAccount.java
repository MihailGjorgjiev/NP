package AV.AV4.Banking;

public class PlatinumCheckingAccount extends Account implements InterestBearingAccount{
    public PlatinumCheckingAccount(String username, double balance) {
        super(username, balance);
    }

    @Override
    public void addInterest() {
        this.deposit(this.getBalance()*InterestCheckingAccount.INTEREST_RATE*2);
    }
}
