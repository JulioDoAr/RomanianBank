package mediatorBankClient;

import account.Account;
import bank.Bank;
import client.Client;
import exceptions.NegativeAmountException;

public interface BCMediator {

	void registerBank(Bank bank);

	void registerClient(Client client);

	Client getClient();

	void addAccount(Account account);

	void depose(String account, double deposit) throws NegativeAmountException;

	void retrieve(String account, double deposit) throws NegativeAmountException;

}
