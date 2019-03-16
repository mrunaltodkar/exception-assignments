package com.capgemini.exception.main;

import com.capgemini.exception.exception.DebitLimitExceedsException;

public class CurrentBankAccount extends BankAccount {

	private double debitLimit;
	private double borrowedAmount;

	public CurrentBankAccount() {
		super();
	}

	public CurrentBankAccount(long accountId, String accountHolderName, double accountBalance, double debitLimit) {
		super(accountId, accountHolderName, "CURRENT", accountBalance);
		this.debitLimit = debitLimit;
	}

	public double getDebitLimit() {
		return debitLimit;
	}

	public void setDebitLimit(double debitLimit) {
		this.debitLimit = debitLimit;
	}

	public double getBorrowedAmount() {
		return borrowedAmount;
	}

	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}

	@Override
	public double withdraw(double amount) throws DebitLimitExceedsException {
		double temp = getAccountBalance() - amount;
		if (temp >= 0)
			setAccountBalance(temp);
		else if (Math.abs(temp) <= (debitLimit - borrowedAmount)) {
			setAccountBalance(0);
			borrowedAmount = borrowedAmount + Math.abs(temp);
		} else {
			throw new DebitLimitExceedsException("Debit limit exceed");
		}

		return getAccountBalance();
	}

	@Override
	public double deposit(double amount) {
		if (borrowedAmount == 0)
			return super.deposit(amount);
		else if (amount >= borrowedAmount) {
			setAccountBalance(amount - borrowedAmount);
			borrowedAmount = 0;
		} else {
			borrowedAmount = borrowedAmount - amount;
		}
		return getAccountBalance();
	}

}