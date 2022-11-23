package persistance.service;

import java.util.Map;

import account.Account;
import account.decorator.AccountImpl;

public interface AccountService {

	void create(Account account, String clientName);

	Map<String, Account> getAllAccountsByClientName(String name);

	void updateAmountByCode(AccountImpl accountImpl);

}
