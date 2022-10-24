package ro.uvt.dp.test;

import ro.uvt.dp.Bank;
import ro.uvt.dp.Client;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountType;
import ro.uvt.dp.accounts.types.AccountRON;

public class Test {

	public static void main(String[] args) {
		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = new Bank("Banca BCR");
//		// creare client Ionescu cu 2 conturi unul in EUR si unul in RON
//		Client cl1 = new Client("Ionescu Ion", "Timisoara", AccountType.EUR, "EUR124", 200.9);
//		bcr.addClient(cl1);
//		cl1.addAccount(AccountType.RON, "RON1234", 400);
		bcr.addClient("Ionescu Ion", "Timisoara");
		bcr.addAccount("Ionescu Ion", AccountType.EUR, 200.9);
//		// creare client Marinecu cu un cont in RON
//		Client cl2 = new Client("Marinescu Marin", "Timisoara", AccountType.RON, "RON126", 100);
//		bcr.addClient(cl2);
		bcr.addClient("Marinescu Marin", "Timisoara");
		bcr.addAccount("Marinescu Marin", AccountType.RON, 200);
//		System.out.println(bcr);
		System.out.println(bcr);

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = new Bank("Banca CEC");
//		Client clientCEC = new Client("Vasilescu Vasile", "Brasov", AccountType.EUR, "EUR128", 700);
//		cec.addClient(clientCEC);
//		System.out.println(cec);
		bcr.addClient("Vasilescu Vasile", "Brasov");
		bcr.addAccount("Vasilescu Vasile", AccountType.EUR, 700);

		// depose in account RON126 of client Marinescu
		Client cl = bcr.getClient("Marinescu Marin");
		if (cl != null) {
			for (Account ac : cl.get)
				cl.getAccount("RON126").depose(400);
			System.out.println(cl);
		}

		// retrieve from account RON126 of Marinescu client
		if (cl != null) {
			cl.getAccount("RON126").retrieve(67);
			System.out.println(cl);
		}

		// tranfer between accounts RON126 si RON1234
		AccountRON c1 = (AccountRON) cl.getAccount("RON126");
		AccountRON c2 = (AccountRON) bcr.getClient("Ionescu Ion").getAccount("RON1234");
		c1.transfer(c2, 40);
		System.out.println(bcr);

	}

}
