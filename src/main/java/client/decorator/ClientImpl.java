package client.decorator;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import account.Account;
import account.AccountType;
import account.command.impl.AccountDeposeCommand;
import client.Client;
import exceptions.NegativeAmountException;
import mediatorBankClient.BCMediator;

public class ClientImpl implements Client {

	private String name;
	private String address;
	private Map<String, Account> accounts;
	private Date birth;
	private BCMediator mediator;

	public ClientImpl(BCMediator mediator, String name, String address) {
		this(mediator, name, address, null);
	}

	public ClientImpl(BCMediator mediator, String name, String address, Date birth) {
		this.name = name;
		this.address = address;
		this.birth = birth;
		this.mediator = mediator;
		accounts = new TreeMap<String, Account>();
	}

	public void addAccount(Account account) {
		accounts.put(account.getCode(), account);
	}

	public Account getAccount(String accountCode) {
		Account account = accounts.get(accountCode);
		if (account != null)
			return account;
		return null;
	}

	public Map<String, Account> getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tClient [name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", acounts=");
		sb.append(accounts);
		sb.append("]");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String nume) {
		this.name = nume;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirth() {
		return birth;
	}

	public void depose(String accountNumber, double amount) throws NegativeAmountException {
		Account account = getAccount(accountNumber);
		AccountDeposeCommand command = new AccountDeposeCommand(account, amount);
		command.execute();
	}

	public boolean existAccount(String number) {
		return accounts.containsKey(number);
	}

	public void addAccount(AccountType type) {
		mediator.addAccount(type);
	}

}