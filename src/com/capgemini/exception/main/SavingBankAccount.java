package com.capgemini.exception.main;

import com.capgemini.exception.exception.DebitLimitExceedsException;
import com.capgemini.exception.exception.InsufficientBalanceException;

public class SavingBankAccount extends BankAccount {

	private boolean salaryAccount;
	public static final double MINIMUM_BALANCE = 10000;

	public SavingBankAccount() {
		super();
	}

	public SavingBankAccount(long accountId, String accountHolderName, double accountBalance, boolean salaryAccount) {
		super(accountId, accountHolderName, "SAVING", accountBalance);
		this.salaryAccount = salaryAccount;
	}

	public boolean isSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException, DebitLimitExceedsException {
		if (salaryAccount) {
			return super.withdraw(amount);
		} else {
			if (getAccountBalance() - amount >= MINIMUM_BALANCE) {
				setAccountBalance(getAccountBalance() - amount);
			} else {
				throw new InsufficientBalanceException("You don't have sufficent amount");
			}
			return getAccountBalance();
		}
	}
}