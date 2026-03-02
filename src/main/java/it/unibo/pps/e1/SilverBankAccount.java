package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private BankAccount bankAccount;

    public SilverBankAccount(BankAccount bankAccount) {
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
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount + 1);
    }
}
