package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import account.decorator.AccountImpl;
import client.decorator.ClientImpl;

public class ClientBuilder {

	private String name;
	private String address;
	private Date birth;
	private List<AccountImpl> accounts;

	public ClientBuilder() {
		birth = null;
		accounts = new ArrayList<AccountImpl>();
	}

	public Client build() {
		Client c = new ClientImpl(name, address, birth);
		for (AccountImpl a : accounts)
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

	public ClientBuilder addAccount(AccountImpl account) {
		this.accounts.add(account);
		return this;
	}

	public ClientBuilder setBirth(Date birth) {
		this.birth = birth;
		return this;
	}
}
