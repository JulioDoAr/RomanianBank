package account.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import account.types.AccountEUR;
import exceptions.NegativeAmountException;

public class AccountEURTest {

	AccountEUR account;

	@Test
	public void test_CreationWithPositiveAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR, 457875);
		double expectedAmount = 457875 * a.getInterest() + 457875;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_CreationWithNegativeAmount() throws NegativeAmountException {
		AccountFactory.getInstance().build(AccountType.EUR, -1234);
	}

	@Test
	public void test_CreationWithoutAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR);
		double expectedAmount = 0 * a.getInterest();
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test
	public void test_DeposePositiveAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR);
		a.depose(100);
		double expectedAmount = 100 * a.getInterest() + 100;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_DeposeNegativeAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR);
		a.depose(-100);
	}

	@Test
	public void test_AccountCodeLenght() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR);
		String code = a.getCode();
		assertEquals(code.length(), 6);
	}

	@Test
	public void test_AccountCode_StartsWithEUR() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.EUR);
		String code = a.getCode();
		assertTrue(code.startsWith("EUR"));
	}

}
