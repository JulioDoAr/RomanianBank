package mediatorBankClient;

import account.Account;
import account.AccountType;
import bank.Bank;
import client.Client;
import exceptions.NegativeAmountException;

public class BCMediatorImpl implements BCMediator {

	Bank bank;
	Client client;

	public void registerBank(Bank bank) {
		this.bank = bank;

	}

	public void registerClient(Client client) {
		this.client = client;
	}

	public void addAccount(Account account) {
		client.addAccount(account);
	}

	public void depose(String account, double deposit) throws NegativeAmountException {
		client.depose(account, deposit);
	}

	public void retrieve(String account, double deposit) throws NegativeAmountException {
		client.depose(account, deposit);
	}

	public Client getClient() {
		return client;
	}

	public void addAccount(AccountType type) {
		bank.addAccount(client.getName(), type);
	}

}
