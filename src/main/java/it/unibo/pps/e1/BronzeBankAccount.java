package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{

    private BankAccount bankAccount;
    private Fee fee;

    public BronzeBankAccount(BankAccount bankAccount, Fee fee) {
        this.bankAccount = bankAccount;
        this.fee = fee;
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
        int addition = amount > 100 ? fee.getFee() : 0;
        bankAccount.withdraw(amount + addition);
    }
}
