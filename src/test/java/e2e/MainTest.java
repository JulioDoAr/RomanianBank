package e2e;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import account.Account;
import account.AccountType;
import account.types.AccountRON;
import client.Client;
import exceptions.ClientNotFoundException;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;
import general.Bank;
import logger.ConsoleOutputOperation;
import logger.Logger;

public class MainTest {
	Logger log;

	@Before
	public void before() {
		log = Logger.getInstance();
		log.reset();
		log.addOutputOperation(new ConsoleOutputOperation());
	}

	@After
	public void after() {
		log.finishWrite();
	}

	@Test
	public void test() throws NegativeAmountException, NotEnoughAmountException, ClientNotFoundException {
		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = new Bank("Banca BCR");

		bcr.addClient("Ionescu Ion", "Timisoara");
		bcr.addAccount("Ionescu Ion", AccountType.EUR, 200.9);
		bcr.addAccount("Ionescu Ion", AccountType.RON, 400);

		bcr.addClient("Marinescu Marin", "Timisoara");
		bcr.addAccount("Marinescu Marin", AccountType.RON, 200);

		log.writeLine(bcr.toString());

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = new Bank("Banca CEC");

		bcr.addClient("Vasilescu Vasile", "Brasov");
		bcr.addAccount("Vasilescu Vasile", AccountType.EUR, 700);

		Client cl = bcr.getClient("Marinescu Marin");
		Account a = cl.getAccounts().get(0);
		a.depose(400);
		log.writeLine(cl.toString());

		a.retrieve(67);
		log.writeLine(cl.toString());

		AccountRON c1 = (AccountRON) cl.getAccount("RON126");
		AccountRON c2 = (AccountRON) bcr.getClient("Ionescu Ion").getAccount("RON1234");
		c1.transfer(c2, 40);
		log.writeLine(bcr.toString());

		assertTrue(true);
	}

}
