package ro.uvt.dp.accounts.types;

import exceptions.NegativeAmountException;
import ro.uvt.dp.accounts.Account;

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
