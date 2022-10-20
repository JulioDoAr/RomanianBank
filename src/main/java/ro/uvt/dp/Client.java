package ro.uvt.dp;

import java.util.ArrayList;
import java.util.List;

import ro.uvt.dp.accounts.Account;

public class Client {

	private String name;
	private String address;
	private List<Account> accounts;

	public Client(String name, String address) {
		this.name = name;
		this.address = address;
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Account getAccount(String accountCode) {
		for (Account account : accounts)
			if (account.getAccountCode().equals(accountCode))
				return account;
		return null;
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
}
