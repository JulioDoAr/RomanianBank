package account;

import account.operation.Operations;
import account.operation.Transfer;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;

public abstract class Account implements Operations, Transfer {

	protected String code = null;
	protected double amount = 0;

	protected Account(String numarCont, double initialDeposit) throws NegativeAmountException {
		this.code = numarCont;
		depose(initialDeposit);
	}

	public double getTotalAmount() {
		return amount + amount * getInterest();
	}

	public void depose(double amount) throws NegativeAmountException {
		if (amount < 0)
			throw new NegativeAmountException();
		this.amount += amount;
	}

	public void retrieve(double amount) throws NegativeAmountException, NotEnoughAmountException {
		if (amount < 0)
			throw new NegativeAmountException();
		if (this.amount < amount)
			throw new NotEnoughAmountException();
		this.amount -= amount;
	}

	@Override
	public String toString() {
		return "Account: code=" + code + ", amount=" + amount;
	}

	public String getCode() {
		return code;
	}

	public void transfer(Account c, double s) throws NegativeAmountException, NotEnoughAmountException {
		c.retrieve(s);
		depose(s);
	}
}
