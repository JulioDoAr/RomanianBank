package e2e;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bank.Bank;
import logger.ConsoleOutputOperation;
import logger.Logger;
import persistance.service.BankService;

public class MainTest {
	Logger log;

	BankService bankService;

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
	public void test() throws Exception {
		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = bankService.getBankByCode("Banca BCR");

//		bcr.addClient("Ionescu Ion", "Timisoara");
//		String ionescuEurAccount = bcr.addAccount("Ionescu Ion", AccountType.EUR, 200.9);
//		String ionescuRonAccount = bcr.addAccount("Ionescu Ion", AccountType.RON, 400);

//		bcr.addClient("Marinescu Marin", "Timisoara");
//		String marinescuRonAccount = bcr.addAccount("Marinescu Marin", AccountType.RON, 200);

		log.writeLine(bcr.toString());

		bcr.deposit("Marinescu Marin", 400, "RON002");
		log.writeLine(bcr.toString());
		bcr.retrieve("Marinescu Marin", 70, "RON002");
		log.writeLine(bcr.toString());
		bcr.transfer("Marinescu Marin", "Ionescu Ion", 50.0, "RON002", "RON001");
		log.writeLine(bcr.toString());

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = bankService.getBankByCode("Banca CEC");

		log.writeLine(cec.toString());

		assertTrue(true);
	}

}
