package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BaseBankAccountTest {

    @Override
    protected BankAccount createAccount() {
        return new BronzeBankAccount(new CoreBankAccount(), new Fee(1));
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEFAULT_DEPOSIT);
        int withdrawValue = 200;
        this.account.withdraw(withdrawValue);
        int expected = 799;
        assertEquals(expected, this.account.getBalance());
    }

    @Test
    public void testWithdrawNoFee() {
        this.account.deposit(DEFAULT_DEPOSIT);
        int withdrawValue = 50;
        this.account.withdraw(withdrawValue);
        int expectedNoFee = 950;
        assertEquals(expectedNoFee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEFAULT_DEPOSIT);
        int wrongAmount = 1200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(wrongAmount));
    }
}
