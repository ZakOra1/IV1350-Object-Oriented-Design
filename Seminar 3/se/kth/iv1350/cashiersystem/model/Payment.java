package Model;

import Integration.ExternalAccounting;
import Integration.ExternalInventory;

public class Payment {

	private double customerPayment;
	private double change;
	private double totalPrice;
	private Sale sale;
	private Receipt receipt;
	private Register register;
	private ExternalAccounting externalAccounting;
	private ExternalInventory externalInventory;

	/**
	 *  
	 */
	public Payment Payment(double customerPayment, double totalPrice) {
		return null;
	}

	public double calculateChange() {
		return 0;
	}

}
