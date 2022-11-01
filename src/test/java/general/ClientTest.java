package general;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import account.factory.AccountEURFactory;
import client.Client;
import exceptions.NegativeAmountException;

public class ClientTest {

	private Client c;

	@Before
	public void before() {
		c = new Client("Name", "Address");
	}

	@Test
	public void test_getName() throws NegativeAmountException {
		assertEquals(c.getName(), "Name");
	}

	@Test
	public void test_getAddress() throws NegativeAmountException {
		assertEquals(c.getAddress(), "Address");
	}

	@Test
	public void test_getBirth() throws NegativeAmountException {
		assertEquals(c.getBirth(), null);
	}

	@Test
	public void test_addAccount() throws NegativeAmountException {
		c.addAccount(AccountEURFactory.getInstance().build());
		assertEquals(c.getAccounts().size(), 1);
	}

}
