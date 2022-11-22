package bank;

import java.util.Map;
import java.util.TreeMap;

import account.Account;
import account.AccountType;
import account.factory.AccountEURFactory;
import account.factory.AccountRONFactory;
import client.Client;
import client.ClientBuilder;
import exceptions.AccountNotFoundException;
import exceptions.ClientNotFoundException;
import exceptions.NegativeAmountException;
import logger.Logger;
import mediatorBankClient.BCMediator;
import mediatorBankClient.BCMediatorImpl;

public class Bank {

	private Map<String, BCMediator> mediators;
	private String bankCode = null;
	private final Logger log;

	public Bank(String bankCode) {
		log = Logger.getInstance();
		this.bankCode = bankCode;
		mediators = new TreeMap<String, BCMediator>();
	}

	public void addClient(String name, String address) {
		BCMediator mediator = new BCMediatorImpl();
		Client client = new ClientBuilder().setName(name).setAddress(address).setMediator(mediator).build();
		mediator.registerBank(this);
		mediator.registerClient(client);
		mediators.put(client.getName(), mediator);
		log.writeLine("Client added. %s", client.toString());
	}

	public Client getClient(String name) throws ClientNotFoundException {
		BCMediator med = mediators.get(name);
		if (med != null)
			return med.getClient();
		else
			throw new ClientNotFoundException();
	}

	public void addAccount(String clientName, AccountType type) {
		addAccount(clientName, type, 0);
	}

	public String addAccount(String clientName, AccountType type, double initialDeposit) {
		Account account = null;
		try {
			BCMediator mediator = mediators.get(clientName);

			switch (type) {
			case EUR:
				account = AccountEURFactory.getInstance().build(initialDeposit);
				break;
			case RON:
				account = AccountRONFactory.getInstance().build(initialDeposit);
				break;
			}
			mediator.addAccount(account);
			log.write("Account with number %s added to %s.", account.getCode(), clientName);
			log.writeLine(account.toString());
		} catch (Exception e) {
			log.writeLine(e.getMessage());
		}
		return account.getCode();
	}

	public void deposit(String client, double deposit, String account) throws ClientNotFoundException {
		BCMediator mediator = mediators.get(client);
		try {
			mediator.depose(account, deposit);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bank [code=");
		sb.append(bankCode);
		sb.append(", clients=");
		sb.append(mediators.keySet());
		sb.append("]");
		return sb.toString();
	}

	public void retrieve(String client, double amount, String account) throws NegativeAmountException {
		BCMediator mediator = mediators.get(client);
		mediator.retrieve(account, amount);
	}

	public void transfer(String origin, String destination, double amount, String originAccount,
			String destinationAccount) throws AccountNotFoundException, NegativeAmountException {
		BCMediator originMediator = mediators.get(origin);
		Client originClient = originMediator.getClient();
		if (!originClient.existAccount(originAccount))
			throw new AccountNotFoundException();

		BCMediator destinationMediator = mediators.get(destination);
		Client destinationClient = mediators.get(destination).getClient();
		if (!destinationClient.existAccount(destinationAccount))
			throw new AccountNotFoundException();

		originMediator.retrieve(originAccount, amount);
		destinationMediator.depose(destinationAccount, amount);
	}

}
