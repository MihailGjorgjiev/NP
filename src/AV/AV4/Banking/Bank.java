package AV.AV4.Banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public double totalAssets(){
        double totalSum=0;
        for(Account account:accounts){
            totalSum+=account.getBalance();
        }
        return totalSum;
    }

    public void addInterest(){
        for(Account account:accounts){
            if(account instanceof InterestBearingAccount){
                ((InterestBearingAccount) account).addInterest();
            }
        }
    }
}
