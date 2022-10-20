package ro.uvt.dp.test.ro.uvt.dp.accounts.types;

import org.junit.Test;

import exceptions.DeposeException;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountBuilder;
import ro.uvt.dp.accounts.AccountType;

public class AccountEURTest {

	@Test
	public void test_CreationWithPositiveAmount() {
		try {
			AccountBuilder.build(AccountType.EUR, 457875);
			assert true;
		} catch (DeposeException e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test(expected = DeposeException.class)
	public void test_CreationWithNegativeAmount() throws DeposeException {
		AccountBuilder.build(AccountType.EUR, -1234);
	}

	@Test(expected = DeposeException.class)
	public void test_CreationWithoutAmount() throws DeposeException {
		AccountBuilder.build(AccountType.EUR);
	}

	public void test_Depose() throws DeposeException {
		Account a = AccountBuilder.build(AccountType.EUR, 1234);
	}

}
