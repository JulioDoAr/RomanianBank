package client;

import java.util.Date;
import java.util.List;

import account.Account;

public interface Client {

	public void addAccount(Account account);

	public Account getAccount(String accountCode);

	public List<Account> getAccounts();

	@Override
	public String toString();

	public String getName();

	public void setName(String nume);

	public String getAddress();

	public Date getBirth();
}
