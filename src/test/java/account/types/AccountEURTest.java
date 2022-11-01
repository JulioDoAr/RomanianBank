package account.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import account.Account;
import account.factory.AccountEURFactory;
import account.factory.AccountFactory;
import exceptions.NegativeAmountException;

public class AccountEURTest {

	AccountEUR account;
	AccountFactory builder;

	@BeforeClass
	public void beforeClass() {
		builder = AccountEURFactory.getInstance();
	}

	@Test
	public void test_CreationWithPositiveAmount() throws NegativeAmountException {
		Account a = builder.build(457875);
		double expectedAmount = 457875 * a.getInterest() + 457875;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_CreationWithNegativeAmount() throws NegativeAmountException {
		builder.build(-1234);
	}

	@Test
	public void test_CreationWithoutAmount() throws NegativeAmountException {
		Account a = builder.build();
		double expectedAmount = 0 * a.getInterest();
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test
	public void test_DeposePositiveAmount() throws NegativeAmountException {
		Account a = builder.build();
		a.depose(100);
		double expectedAmount = 100 * a.getInterest() + 100;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_DeposeNegativeAmount() throws NegativeAmountException {
		Account a = builder.build();
		a.depose(-100);
	}

	@Test
	public void test_AccountCodeLenght() throws NegativeAmountException {
		Account a = builder.build();
		String code = a.getCode();
		assertEquals(code.length(), 6);
	}

	@Test
	public void test_AccountCode_StartsWithEUR() throws NegativeAmountException {
		Account a = builder.build();
		String code = a.getCode();
		assertTrue(code.startsWith("EUR"));
	}

}
