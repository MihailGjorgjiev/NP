package Labs.Lab2.Bank;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;
    private double transfers;
    private double provisions;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts.clone();

        transfers=0;
        provisions=0;
    }

    public boolean makeTransaction(Transaction t) {
        int fromId = -1;
        int toId = -1;
        boolean fromAccountHasEnoughFunds = false;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == t.getFromId()) {
                fromId = i;
                if (t instanceof FlatAmountProvisionTransaction) {
                    FlatAmountProvisionTransaction fapt = (FlatAmountProvisionTransaction) t;
                    if (fapt.getFlatAmount() <= accounts[i].getBalance()) {
                        fromAccountHasEnoughFunds = true;
                    }
                } else {
                    FlatPercentProvisionTransaction fppt = (FlatPercentProvisionTransaction) t;
                    if (fppt.getPercentAmount() <= accounts[i].getBalance()) {
                        fromAccountHasEnoughFunds = true;
                    }
                }
            }
            if (accounts[i].getId() == t.getToId()) {
                toId = i;
            }
        }


        if (fromId == -1 || toId == -1 || !fromAccountHasEnoughFunds) {
            return false;
        }

        if (t instanceof FlatAmountProvisionTransaction) {
            FlatAmountProvisionTransaction fapt = (FlatAmountProvisionTransaction) t;
            accounts[fromId].setBalance(accounts[fromId].getBalance()-fapt.getFlatAmount());
            accounts[toId].setBalance(accounts[toId].getBalance()+fapt.getAmount());
            transfers+= fapt.getAmount();
            provisions+= fapt.getFlatProvision();
        } else {
            FlatPercentProvisionTransaction fppt = (FlatPercentProvisionTransaction) t;
            accounts[fromId].setBalance(accounts[fromId].getBalance()-fppt.getPercentAmount());
            accounts[toId].setBalance(accounts[toId].getBalance()+fppt.getAmount());
            transfers+= fppt.getAmount();
            provisions+= fppt.getFlatProvision();
        }
        return true;
    }

    public double totalProvision(){
        return provisions;
    }

    public double totalTransfers() {
        return transfers;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("\n");

        for(Account account:accounts){
            sb.append(account);
        }

        return sb.toString();
    }

    public Account[] getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(transfers, bank.transfers) == 0 && Double.compare(provisions, bank.provisions) == 0 && Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts), transfers, provisions);
    }
}
