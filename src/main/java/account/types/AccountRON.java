package account.types;

import account.decorator.AccountImpl;
import exceptions.NegativeAmountException;

public class AccountRON extends AccountImpl {

	public AccountRON(String number, double suma) throws NegativeAmountException {
		super(number, suma);
	}

	public double getInterest() {
		if (amount < 500)
			return 0.03;
		else
			return 0.08;
	}

	@Override
	public String toString() {
		return "Account RON [" + super.toString() + "]";
	}

}
