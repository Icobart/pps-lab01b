package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private int balance;

    public SilverBankAccount() {

    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.balance -= (amount + 1);
    }
}
