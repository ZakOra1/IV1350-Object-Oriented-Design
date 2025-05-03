package se.kth.iv1350.cashiersystem.controller;

import se.kth.iv1350.cashiersystem.model.Sale;
import se.kth.iv1350.cashiersystem.model.Discount;

public class Controller {

	private Sale sale;
	private Register register;


	public Controller(Register register) {
		this.register = register;
	}

	/**
	 *  Starts a new sale. 
	 */
	public void initializeSale() {
		sale = new Sale(); //TODO: Vad ska vi egentligen ha här för konstruktorn? Behövs det ens något?

	}

	/**
	 * Attempts to add a new item to the current sale.
	 * @param itemID The ID of the item to be added.
	 * @param quantity The quantity of the item to be added.
	 * @return true if the item was successfully added, false otherwise.
	 */
	public boolean scanItem(int itemID, int quantity) {
		return sale.addItem(itemID, quantity);
	}

	public void checkDiscount() {

	}

	public void applyDiscount(Discount discount) {
		sale.addDiscount(discount);
	}

	public void endSale() {

		/**
		 * Ta emot betalning, skicka till Register
		 * Skapa Receipt
		 * Skicka till Printer
		 */

	}

}
