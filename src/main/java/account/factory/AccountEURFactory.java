package account.factory;

import java.util.Set;
import java.util.TreeSet;

import account.Account;
import account.types.AccountEUR;
import exceptions.NegativeAmountException;

/**
 * Singleton
 * 
 * @author Julio Domínguez Arjona
 *
 */
public class AccountEURFactory extends AccountFactory {

	private static AccountFactory instance = null;

	public synchronized static AccountFactory getInstance() {
		if (instance == null)
			instance = new AccountEURFactory();
		return instance;
	}

	private Set<Integer> generatedNumbers;

	private AccountEURFactory() {
		generatedNumbers = new TreeSet<Integer>();
	}

	@Override
	protected String generateAccountNumber() {
		int number;
		do {
			number = getRandomNumber();
		} while (generatedNumbers.contains(number));
		generatedNumbers.add(number);

		return "EUR" + number;
	}

	@Override
	public Account build() throws NegativeAmountException {
		return build(0);
	}

	@Override
	public Account build(double initialDeposit) throws NegativeAmountException {
		return new AccountEUR(generateAccountNumber(), initialDeposit);
	}

}
