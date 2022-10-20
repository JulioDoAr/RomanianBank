package ro.uvt.dp.accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import exceptions.DeposeException;
import ro.uvt.dp.accounts.types.AccountEUR;
import ro.uvt.dp.accounts.types.AccountRON;

public class AccountBuilder {

	private static List<Integer> generatedEURNumbers;
	private static List<Integer> generatedRONNumbers;

	public AccountBuilder() {
		generatedEURNumbers = new ArrayList<Integer>();
		generatedRONNumbers = new ArrayList<Integer>();
	}

	private static int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(100, 1000);
	}

	private static String generateEURAccountNumber() {
		int number;
		do {
			number = getRandomNumber();
		} while (generatedEURNumbers.contains(number));
		generatedEURNumbers.add(number);

		return "EUR" + number;
	}

	private static String generateRONAccountNumber() {
		int number;
		do {
			number = getRandomNumber();
		} while (generatedRONNumbers.contains(number));
		generatedRONNumbers.add(number);

		return "RON" + number;
	}

	public static Account build(AccountType type) throws DeposeException {
		return build(type, 0);
	}

	public static Account build(AccountType type, double initialDeposit) throws DeposeException {
		Account account = null;
		if (type == AccountType.EUR)
			account = new AccountEUR(generateEURAccountNumber(), initialDeposit);
		else if (type == AccountType.RON)
			account = new AccountRON(generateRONAccountNumber(), initialDeposit);
		return account;
	}
}
