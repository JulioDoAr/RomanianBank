package account.decorator;

import account.Account;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;

public abstract class AccountDecorator implements Account {

	protected Account decorated;

	public AccountDecorator(Account decorated) {
		this.decorated = decorated;
	}

	public double getTotalAmount() {
		return decorated.getTotalAmount();
	}

	public void depose(double amount) throws NegativeAmountException {
		decorated.depose(amount);
	}

	public void retrieve(double amount) throws NegativeAmountException, NotEnoughAmountException {
		decorated.retrieve(amount);
	}

	public double getInterest() {
		return decorated.getInterest();
	}

	@Override
	public String toString() {
		return decorated.toString();
	}

	public String getCode() {
		return decorated.getCode();
	}

}
