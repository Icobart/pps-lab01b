package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BaseBankAccountTest {

    @Override
    protected BankAccount createAccount() {
        return new SilverBankAccount(new CoreBankAccount(), new Fee(1));
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
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEFAULT_DEPOSIT);
        int wrongAmount = 1200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(wrongAmount));
    }

}
