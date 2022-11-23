package account.decorator;

import account.Account;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;
import persistance.service.AccountService;

public abstract class AccountImpl implements Account {

	AccountService accountService;

	protected String code = null;
	protected double amount = 0;

	protected AccountImpl(String code, double initialDeposit) throws NegativeAmountException {
		this.code = code;
		depose(initialDeposit);
	}

	public double getTotalAmount() {
		return amount + amount * getInterest();
	}

	public void depose(double amount) throws NegativeAmountException {
		if (amount < 0)
			throw new NegativeAmountException();
		this.amount += amount;
		accountService.updateAmountByCode(this);
	}

	public void retrieve(double amount) throws NegativeAmountException, NotEnoughAmountException {
		if (amount < 0)
			throw new NegativeAmountException();
		if (this.amount < amount)
			throw new NotEnoughAmountException();
		this.amount -= amount;
		accountService.updateAmountByCode(this);
	}

	@Override
	public String toString() {
		return "Account: code=" + code + ", amount=" + amount;
	}

	public String getCode() {
		return code;
	}
}
