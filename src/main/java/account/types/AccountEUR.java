package account.types;

import account.Account;
import exceptions.NegativeAmountException;

public class AccountEUR extends Account {

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
