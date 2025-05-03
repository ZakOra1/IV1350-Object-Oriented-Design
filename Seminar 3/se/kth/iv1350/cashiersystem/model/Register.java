package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.Printer;

public class Register {

	private double balance;
	private Payment payment;

	public Register() {
	}

	public void PrintReceipt(Receipt receipt) {
		Printer printer = new Printer();
		printer.printReceipt(receipt);
	}

	public void deposit(double customerPayment) {

	}

	public void withdraw(double customerChange) {

	}

}
