package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.integration.SaleDTO;


public class Receipt {

	private SaleDTO sale;


	public Receipt(SaleDTO sale) {	
		this.sale = sale;
		this.LocalDateTime dateTime = LocalDateTime.now();
		this.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}

public void printReceipt(SaleDTO sale) {
	Printer printer = new Printer();
	printer.printReceipt(sale);
}

puvlc String getReceipt() {
	StringBuilder receipt = new StringBuilder();
	/**
	 * Appenda all data som ska skrivas ut här
	*/


}