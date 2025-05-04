package se.kth.iv1350.cashiersystem.view;

import se.kth.iv1350.cashiersystem.controller.Controller;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;


/**
 * Placeholder view. 
 * It is not a "real" view, instead it will use hardcoded calls to the system operations in the controller.
 */
public class View {
	private Controller contr;

	/**
	 * Constructor for the view class. 
	 * It takes a controller object as a parameter and assigns it to the contr variable.
	 * @param contr The controller object to be used by the view.
	 */
	public View(Controller contr) {
		this.contr = contr;
	}

	/**
	 * Hardcoded method used to simulate a sale
	 */
	public void sampleExecution() {
		System.out.println("Starting a new sale.\n");
		contr.initializeSale();
		ItemDTO item1 = contr.scanItem("abc123", 2);
		printScannedItemInfo(item1);
		ItemDTO item2 = contr.scanItem("def456", 1); 
		printScannedItemInfo(item2);
		ItemDTO item3 = contr.scanItem("def456", 1); 
		printScannedItemInfo(item3);
		contr.endSale();
	}
	
	/**
	 * Prints information for each scanned item along with the running total
	 * @param scannedItem The item that just got scanned by the cashier
	 */
	public void printScannedItemInfo(ItemDTO scannedItem) {
		System.out.println("Item ID: " + scannedItem.getID() + 
						"\nItem quantity: " + scannedItem.getSaleQuantity() +
						"\nItem name: " + scannedItem.getName() + 
						"\nItem cost: " + scannedItem.getPrice() + 
						"\nVAT: " + scannedItem.getVatRate() + "%" +
						"\nItem description: " + scannedItem.getDescription() +
						"\n"				
						);
		System.out.println("Total cost (incl VAT): " + String.format("%.2f", contr.getSale().getTotalPrice()));
		System.out.println("Total VAT: " + String.format("%.2f", contr.getSale().getTotalVat()) + "\n\n");
	}
}
