package se.kth.iv1350.cashiersystem.integration;

import se.kth.iv1350.cashiersystem.model.Receipt;
import se.kth.iv1350.cashiersystem.model.Sale;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Printer {

	private Receipt receipt;
	/**
	 * Printer is a class that will print the receipt object.
	 */
	public Printer Printer() {
	/**
	 * Vad ska ens skapas här?
	*/
		return null;
	}

	/**
	 * Print the receipt object.
	 * @param receipt The receipt object to be printed.
	 */
	public void printReceipt(String receipt) {
		System.out.println(receipt);
	}

}
