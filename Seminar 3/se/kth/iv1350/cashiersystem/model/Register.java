package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.Printer;

public class Register {

	private double balance;

	public Register() {
		this.balance = 0;
	}

	public void deposit(double customerPayment) {
		this.balance += customerPayment;
	}


}
