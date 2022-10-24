package general;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import account.AccountFactory;
import account.AccountType;
import exceptions.NegativeAmountException;
import general.Client;

public class ClientTest {

	private Client c;

	@Before
	public void before() {
		c = new Client("Name", "Address");
	}

	@Test
	public void test_addAccount() throws NegativeAmountException {
		c.addAccount(AccountFactory.getInstance().build(AccountType.EUR));
		assertEquals(c.getAccounts().size(), 1);
	}

}
