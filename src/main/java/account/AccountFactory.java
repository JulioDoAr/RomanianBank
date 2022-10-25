package account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import account.types.AccountEUR;
import account.types.AccountRON;
import exceptions.NegativeAmountException;

/**
 * Singleton
 * 
 * @author Julio Dom´inguez Arjona
 *
 */
public class AccountFactory {

	private static AccountFactory instance = null;

	public static AccountFactory getInstance() {
		if (instance == null)
			instance = new AccountFactory();
		return instance;
	}

	private List<Integer> generatedEURNumbers;
	private List<Integer> generatedRONNumbers;

	private AccountFactory() {
		generatedEURNumbers = new ArrayList<Integer>();
		generatedRONNumbers = new ArrayList<Integer>();
	}

	private int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(100, 1000);
	}

	private String generateEURAccountNumber() {
		int number;
		do {
			number = getRandomNumber();
		} while (generatedEURNumbers.contains(number));
		generatedEURNumbers.add(number);

		return "EUR" + number;
	}

	private String generateRONAccountNumber() {
		int number;
		do {
			number = getRandomNumber();
		} while (generatedRONNumbers.contains(number));
		generatedRONNumbers.add(number);

		return "RON" + number;
	}

	public Account build(AccountType type) throws NegativeAmountException {
		return build(type, 0);
	}

	public Account build(AccountType type, double initialDeposit) throws NegativeAmountException {
		Account account = null;
		if (type == AccountType.EUR)
			account = new AccountEUR(generateEURAccountNumber(), initialDeposit);
		else if (type == AccountType.RON)
			account = new AccountRON(generateRONAccountNumber(), initialDeposit);
		return account;
	}
}
