package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseBankAccountTest {

    public static final int DEFAULT_DEPOSIT = 1000;
    protected BankAccount account;
    protected abstract BankAccount createAccount();

    @BeforeEach
    void init(){
        this.account = createAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEFAULT_DEPOSIT);
        assertEquals(DEFAULT_DEPOSIT, this.account.getBalance());
    }

}
