package general;

import account.Account;
import exceptions.NegativeAmountException;
import exceptions.NotEnoughAmountException;

public interface Transfer {
	public void transfer(Account account, double amount) throws NegativeAmountException, NotEnoughAmountException;
}
