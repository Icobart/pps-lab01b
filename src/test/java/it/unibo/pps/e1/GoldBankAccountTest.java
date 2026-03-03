package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BaseBankAccountTest {

    @Override
    protected BankAccount createAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEFAULT_DEPOSIT);
        int withdrawValue = 200;
        this.account.withdraw(withdrawValue);
        int expected = 800;
        assertEquals(expected, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawBelowZero() {
        this.account.deposit(DEFAULT_DEPOSIT);
        int limitWithdraw = 1500;
        this.account.withdraw(limitWithdraw);
        int resultingBalance = -500;
        assertEquals(resultingBalance, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEFAULT_DEPOSIT);
        int wrongAmount = 2000;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(wrongAmount));
    }
}
