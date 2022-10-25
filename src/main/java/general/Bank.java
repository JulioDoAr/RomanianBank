package general;

import java.util.ArrayList;
import java.util.List;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import client.Client;
import exceptions.ClientNotFoundException;
import logger.Logger;

public class Bank {

	private List<Client> clients;
	private String bankCode = null;
	Logger log;

	public Bank(String bankCode) {
		log = Logger.getInstance();
		this.bankCode = bankCode;
		clients = new ArrayList<Client>();
	}

	public void addClient(String name, String address) {
		Client c = new Client(name, address);
		clients.add(c);
		log.writeLine("Client added. %s", c.toString());
	}

	public Client getClient(String name) throws ClientNotFoundException {
		for (Client client : clients)
			if (client.getName().equals(name))
				return client;
		throw new ClientNotFoundException();
	}

	public void addAccount(String clientName, AccountType type) {
		addAccount(clientName, type, 0);
	}

	public void addAccount(String clientName, AccountType type, double initialDeposit) {
		Client client;
		try {
			client = getClient(clientName);
			Account account = AccountFactory.getInstance().build(type, initialDeposit);
			client.addAccount(account);
			log.write("Account added to %s.", clientName);
			log.writeLine(account.toString());
		} catch (Exception e) {
			log.writeLine(e.getMessage());
		}
	}

	public void deposit(String clientName, double deposit, String accountName) throws ClientNotFoundException {
		Client c = getClient(clientName);
		Account a = c.getAccount(accountName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bank [code=");
		sb.append(bankCode);
		sb.append(", clients=");
		sb.append(clients);
		sb.append("]");
		return sb.toString();
	}

}
