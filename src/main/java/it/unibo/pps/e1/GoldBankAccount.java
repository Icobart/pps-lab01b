package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    private BankAccount bankAccount;

    public GoldBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int minimumBalance = -500;
        if ((this.getBalance() - amount) < minimumBalance) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount);
    }
}
