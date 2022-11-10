package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import account.Account;

public class ConcreteClient implements Client {

	private String name;
	private String address;
	private List<Account> accounts;
	private Date birth;

	public ConcreteClient(String name, String address) {
		this(name, address, null);
	}

	public ConcreteClient(String name, String address, Date birth) {
		this.name = name;
		this.address = address;
		this.birth = birth;
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Account getAccount(String accountCode) {
		for (Account account : accounts)
			if (account.getCode().equals(accountCode))
				return account;
		return null;
	}

	public List<Account> getAccounts() {
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

}
