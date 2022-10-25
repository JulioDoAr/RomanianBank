package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import account.Account;

public class ClientBuilder {

	private String name;
	private String address;
	private Date birth;
	private List<Account> accounts;

	public ClientBuilder() {
		birth = null;
		accounts = new ArrayList<Account>();
	}

	public Client build() {
		Client c = new Client(name, address, birth);
		for (Account a : accounts)
			c.addAccount(a);
		return c;
	}

	public ClientBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ClientBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public ClientBuilder addAccount(Account account) {
		this.accounts.add(account);
		return this;
	}

	public ClientBuilder setBirth(Date birth) {
		this.birth = birth;
		return this;
	}
}
