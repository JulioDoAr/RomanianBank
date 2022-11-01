package account.factory;

import java.util.concurrent.ThreadLocalRandom;

import account.Account;
import exceptions.NegativeAmountException;

public abstract class AccountFactory {

	protected int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(100, 1000);
	}

	protected abstract String generateAccountNumber();

	public Account build() throws NegativeAmountException {
		return build(0);
	}

	public abstract Account build(double initialDeposit) throws NegativeAmountException;
}
