package client;

import java.util.Date;
import java.util.Map;

import account.Account;
import exceptions.AccountNotFoundException;
import exceptions.NegativeAmountException;

public interface Client {

	void addAccount(Account account);

	Account getAccount(String accountCode) throws AccountNotFoundException;

	Map<String, Account> getAccounts();

	@Override
	String toString();

	String getName();

	void setName(String name);

	String getAddress();

	Date getBirth();

	void depose(String accountNumber, double amount) throws NegativeAmountException;

	boolean existAccount(String number);
}
