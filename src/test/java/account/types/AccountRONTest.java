package account.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import account.types.AccountRON;
import exceptions.NegativeAmountException;

public class AccountRONTest {

	AccountRON account;

	@Test
	public void test_CreationWithPositiveAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON, 457875);
		double expectedAmount = 457875 * a.getInterest() + 457875;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_CreationWithNegativeAmount() throws NegativeAmountException {
		AccountFactory.getInstance().build(AccountType.RON, -1234);
	}

	@Test
	public void test_CreationWithoutAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		double expectedAmount = 0 * a.getInterest();
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test
	public void test_DeposePositiveAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		a.depose(100);
		double expectedAmount = 100 * a.getInterest() + 100;
		assertEquals(a.getTotalAmount(), expectedAmount, 0.001);
	}

	@Test(expected = NegativeAmountException.class)
	public void test_DeposeNegativeAmount() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		a.depose(-100);
	}

	@Test
	public void test_AccountCodeLenght() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		String code = a.getCode();
		assertEquals(code.length(), 6);
	}

	@Test
	public void test_AccountCode_StartsWithRON() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		String code = a.getCode();
		assertTrue(code.startsWith("RON"));
	}

	@Test
	public void test_Interest_LessThan500() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON);
		assertEquals(a.getInterest(), 0.03, 0.001);
	}

	@Test
	public void test_Interest_500OrMore() throws NegativeAmountException {
		Account a = AccountFactory.getInstance().build(AccountType.RON, 500);
		assertEquals(a.getInterest(), 0.08, 0.001);
	}
}
