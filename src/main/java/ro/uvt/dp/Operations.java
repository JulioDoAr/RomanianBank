package ro.uvt.dp;

import exceptions.DeposeException;

public interface Operations {
	public double getTotalAmount();

	public double getInterest();

	public void depose(double amount) throws DeposeException;

	public void retrieve(double amount) throws DeposeException;
}
