package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.Printer;

/**
 * The Register class represents a cash register that keeps track of the balance.
 */
public class Register {
	private double balance;

	/**
	 * Constructor for the register class.
	 */
	public Register() {
		this.balance = 0;
	}

	public void deposit(double customerPayment) {
		this.balance += customerPayment;
	}
}