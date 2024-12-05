package CollectionBook.OOP.Inheritance.Bank;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    private double totalTransfers;
    private double totalProvision;


    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts= Arrays.copyOf(accounts,accounts.length);
        this.totalTransfers=0;
        this.totalProvision=0;
    }

    public boolean makeTransaction(Transaction t){
        Account fromAccount=null;
        Account toAccount=null;
        for(Account account:accounts){
            if(account.getId()==t.getFromId()){
                fromAccount=account;
            }else if(account.getId()==t.getToId()){
                toAccount=account;
            }
        }
        if(fromAccount == null || toAccount == null){
            return false;
        }

        if(t instanceof FlatAmountProvisionTransaction){
            FlatAmountProvisionTransaction tFlat= (FlatAmountProvisionTransaction) t;
            double total=tFlat.getFlatAmount()+ tFlat.getAmount();
            if(total<= fromAccount.getBalance()){
                fromAccount.setBalance(fromAccount.getBalance()-total);
                toAccount.setBalance(toAccount.getBalance()+t.getAmount());
                totalTransfers+=tFlat.getAmount();
                totalProvision+=tFlat.getFlatAmount();
            }else {
                return false;
            }
        }
        if(t instanceof FlatPercentProvisionTransaction){
            FlatPercentProvisionTransaction tPerc = (FlatPercentProvisionTransaction) t;
            double provision= (double) (tPerc.getPercent() * (int) tPerc.getAmount()) /100.0;
            double total= provision+ tPerc.getAmount();
            if(total<= fromAccount.getBalance()){
                fromAccount.setBalance(fromAccount.getBalance()-total);
                toAccount.setBalance(toAccount.getBalance()+t.getAmount());
                totalTransfers+= tPerc.getAmount();
                totalProvision+= provision;
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(totalTransfers, bank.totalTransfers) == 0 && Double.compare(totalProvision, bank.totalProvision) == 0 && Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts), totalTransfers, totalProvision);
    }
}
