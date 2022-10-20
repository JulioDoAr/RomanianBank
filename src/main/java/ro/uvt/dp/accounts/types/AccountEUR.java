package ro.uvt.dp.accounts.types;

import exceptions.DeposeException;
import ro.uvt.dp.accounts.Account;

public class AccountEUR extends Account {

	public AccountEUR(String number, double suma) throws DeposeException {
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
