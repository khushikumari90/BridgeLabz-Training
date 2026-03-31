package com.example.junit_demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(1000);

        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(1000);

        Exception ex = assertThrows(RuntimeException.class,
                () -> account.deposit(-200));

        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(1000);

        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(500);

        Exception ex = assertThrows(RuntimeException.class,
                () -> account.withdraw(800));

        assertEquals("Insufficient funds.", ex.getMessage());
    }
}
