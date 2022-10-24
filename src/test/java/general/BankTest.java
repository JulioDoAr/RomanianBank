package general;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import account.Account;
import account.AccountType;
import exceptions.NegativeAmountException;

public class BankTest {

	private Bank b;

	@Before
	public void before() {
		b = new Bank("Test");
	}

	@Test
	public void test_addClienteAndGetIt() throws NegativeAmountException {
		b.addClient("Name", "Address");
		assertNotNull(b.getClient("Name"));
	}

	@Test
	public void test_addAccountToClient() throws NegativeAmountException {
		b.addClient("Name", "Address");
		b.addAccount("Name", AccountType.EUR);
		assertEquals(b.getClient("Name").getAccounts().size(), 1);
	}

	@Test
	public void test_addAccountWithMoneyToClient() throws NegativeAmountException {
		b.addClient("Name", "Address");
		b.addAccount("Name", AccountType.EUR, 150);
		Account a = b.getClient("Name").getAccounts().get(1);
		assertNotEquals(a.getTotalAmount(), 0, 0.1);
	}

}
