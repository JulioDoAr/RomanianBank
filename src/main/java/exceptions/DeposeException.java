package exceptions;

public class DeposeException extends Exception {

	public DeposeException() {
		super("Deposits can not be a negative value.");
	}

}
