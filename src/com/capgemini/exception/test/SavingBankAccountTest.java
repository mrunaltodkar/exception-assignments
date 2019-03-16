package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.exception.DebitLimitExceedsException;
import com.capgemini.exception.exception.InsufficientBalanceException;
import com.capgemini.exception.main.SavingBankAccount;

public class SavingBankAccountTest {

	@Test
	public void testWithdrawSavingBankAccountForSalaryAccountSufficeantAmount() throws InsufficientBalanceException, DebitLimitExceedsException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		assertEquals(25000, account.withdraw(10000),0.01);
	}

	@Test(expected=InsufficientBalanceException.class)
	public void testWithdrawSavingBankAccountForSalaryAccountInSufficeantAmount() throws InsufficientBalanceException, DebitLimitExceedsException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		account.withdraw(36000);
	}

	@Test
	public void testWithdrawSavingBankAccountForSavingAccountSufficeantAmount() throws InsufficientBalanceException, DebitLimitExceedsException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, false);
		assertEquals(15000, account.withdraw(20000),0.01);
	}

	@Test(expected=InsufficientBalanceException.class)
	public void testWithdrawSavingBankAccountForSavingAccountInSufficeantAmount() throws InsufficientBalanceException, DebitLimitExceedsException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, false);
		account.withdraw(40000);
	}

	@Test
	public void testDepositForSavingBabnkAccountInSalaryAccount() {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		assertEquals(45000, account.deposit(10000),0.01);
	}
}
