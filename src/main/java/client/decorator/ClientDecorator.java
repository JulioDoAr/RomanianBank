package client.decorator;

import java.util.Date;
import java.util.List;

import account.Account;
import client.Client;

public abstract class ClientDecorator implements Client {
	Client decorated;

	public ClientDecorator(Client decorated) {
		this.decorated = decorated;
	}

	public void addAccount(Account account) {
		decorated.addAccount(account);
	}

	public Account getAccount(String accountCode) {
		return decorated.getAccount(accountCode);
	}

	public List<Account> getAccounts() {
		return decorated.getAccounts();
	}

	@Override
	public String toString() {
		return decorated.toString();
	}

	public String getName() {
		return decorated.getName();
	}

	public void setName(String name) {
		decorated.setName(name);
	}

	public String getAddress() {
		return decorated.getAddress();
	}

	public Date getBirth() {
		return decorated.getBirth();
	}
}
