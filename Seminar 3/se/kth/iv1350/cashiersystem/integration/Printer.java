package se.kth.iv1350.cashiersystem.integration;

import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Receipt;
import se.kth.iv1350.cashiersystem.model.Sale;



public class Printer {

	/**
	 * Printer is a class that will print the receipt object.
	 */
	public Printer() {
	}

	/**
	 * Print the receipt object.
	 * @param receipt The receipt object to be printed.
	 */
	public void printReceipt(String receipt) {
		System.out.println(receipt);
	}

}
