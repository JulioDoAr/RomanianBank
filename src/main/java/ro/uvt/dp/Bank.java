package ro.uvt.dp;

import java.util.ArrayList;
import java.util.List;

import exceptions.DeposeException;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.accounts.AccountBuilder;

public class Bank {

	private List<Client> clients;
	private String bankCode = null;

	public Bank(String bankCode) {
		this.bankCode = bankCode;
		clients = new ArrayList<Client>();
	}

	public void addClient(String name, String address) {
		Client client = new Client(name, address);
		clients.add(client);
	}

	public Client getClient(String name) {
		for (Client client : clients)
			if (client.getName().equals(name))
				return client;
		return null;
	}

	public boolean addAccount(String clientName, TYPE type, String accountNumber) {
		return addAccount(clientName, type, accountNumber, 0);
	}

	public boolean addAccount(String clientName, TYPE type, String accountNumber, double initialDeposit) {
		Client client = getClient(clientName);

		if (client != null) {
			Account account;
			try {
				account = AccountBuilder.build(type, initialDeposit, accountNumber);
				client.addAccount(account);
			} catch (DeposeException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;
			}
		} else
			System.out.println("The client does not exist");
		return true;
	}

	public void deposit(String clientName, double deposit) {

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
