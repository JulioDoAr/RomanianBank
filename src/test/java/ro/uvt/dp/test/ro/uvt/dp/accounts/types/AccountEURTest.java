package ro.uvt.dp.test.ro.uvt.dp.accounts.types;

import org.junit.Test;

import exceptions.DeposeException;
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

	public void test_Depose() throws DeposeException {
		AccountBuilder.build(AccountType.EUR, -1234);
	}

}
