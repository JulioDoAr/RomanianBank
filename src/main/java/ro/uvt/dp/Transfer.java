package ro.uvt.dp;

import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;
import ro.uvt.dp.accounts.Account;

public interface Transfer {
	public void transfer(Account account, double amount) throws NegativeAmountException, NotEnoughAmountException;
}
