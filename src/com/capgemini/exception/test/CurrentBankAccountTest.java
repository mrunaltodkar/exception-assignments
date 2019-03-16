package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.exception.DebitLimitExceedsException;
import com.capgemini.exception.main.CurrentBankAccount;

public class CurrentBankAccountTest {

	@Test
	public void testForWithdrawCurrentAccountSufficientBalance() throws DebitLimitExceedsException {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 45000, 20000);
		assertEquals(30000, account.withdraw(15000), 0.01);
	}

	@Test
	public void testForWithdrawCurrentAccountSufficientBalanceUsingDebitAmount()
			throws DebitLimitExceedsException {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 45000, 20000);
		account.withdraw(50000);
		assertEquals(5000, account.getBorrowedAmount(), 0.01);
	}

	@Test(expected = DebitLimitExceedsException.class)
	public void testForWithdrawCurrentAccountInSufficientBalanceUsingDebitAmountExceeds()
			throws DebitLimitExceedsException {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 45000, 20000);
		account.withdraw(50000);
		account.withdraw(20000);
	}

	@Test
	public void testDepositCurrentAccountWithZeroDebitAmount() {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 45000, 20000);
		assertEquals(50000, account.deposit(5000), 0.01);
	}

	@Test
	public void testDepositCurrentAccountWithSomeDebitAmount() throws DebitLimitExceedsException {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 45000, 20000);
		account.withdraw(50000);
		assertEquals(1000, account.deposit(6000), 0.01);
	}

	@Test
	public void testDepositCurrentAccountWithDebitAmountExceed() throws DebitLimitExceedsException {
		CurrentBankAccount account = new CurrentBankAccount(102, "Mrunal Todkar", 30000, 20000);
		account.withdraw(50000);
		assertEquals(0, account.deposit(6000), 0.01);
	}
}