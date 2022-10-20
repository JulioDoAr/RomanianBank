package ro.uvt.dp;

import exceptions.DeposeException;
import ro.uvt.dp.accounts.Account;

public interface Transfer {
	public void transfer(Account c, double s) throws DeposeException;
}
