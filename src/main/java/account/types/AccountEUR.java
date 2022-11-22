package account.types;

import account.decorator.AccountImpl;
import exceptions.NegativeAmountException;

public class AccountEUR extends AccountImpl {

	public AccountEUR(String number, double suma) throws NegativeAmountException {
		super(number, suma);
	}

	public double getInterest() {
		return 0.01;
	}

	@Override
	public String toString() {
		return "Account EUR [" + super.toString() + "]";
	}
}
