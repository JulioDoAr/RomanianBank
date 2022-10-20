package ro.uvt.dp.accounts;

import exceptions.DeposeException;
import ro.uvt.dp.Operations;
import ro.uvt.dp.Transfer;

public abstract class Account implements Operations, Transfer {

	protected String accountCode = null;
	protected double amount = 0;

	protected Account(String numarCont, double initialDeposit) throws DeposeException {
		this.accountCode = numarCont;
		depose(initialDeposit);
	}

	public double getTotalAmount() {
		return amount + amount * getInterest();
	}

	public void depose(double amount) throws DeposeException {
		if (amount < 0)
			throw new DeposeException();
		this.amount += amount;
	}

	public void retrieve(double amount) throws DeposeException {
		if (amount < 0)
			throw new DeposeException();
		this.amount -= amount;
	}

	@Override
	public String toString() {
		return "Account: code=" + accountCode + ", amount=" + amount;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void transfer(Account c, double s) throws DeposeException {
		c.retrieve(s);
		depose(s);
	}
}
