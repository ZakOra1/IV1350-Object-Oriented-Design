package se.kth.iv1350.cashiersystem.controller;

import se.kth.iv1350.cashiersystem.model.Sale;
import se.kth.iv1350.cashiersystem.integration.DiscountDatabase;
import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;
import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.model.Discount;
import se.kth.iv1350.cashiersystem.model.Register;
import se.kth.iv1350.cashiersystem.model.Receipt;
import se.kth.iv1350.cashiersystem.model.Payment;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;

public class Controller {

	private Sale sale;
	private ExternalInventory externalInventory;
	private ExternalAccounting externalAccounting;
	private DiscountDatabase discountDatabase;
	private Receipt receipt;
	private Printer printer;
	private Register register;

	public Controller(ExternalInventory externalInventory, ExternalAccounting externalAccounting, DiscountDatabase discountDatabase, Printer printer, Register register) {
		this.externalInventory = externalInventory;
		this.externalAccounting = externalAccounting;
		this.discountDatabase = discountDatabase;
		this.printer = printer;
		this.register = register;
	}

	/**
	 * Starts a new sale.
	 * Calls the constructor of the Sale class to create a new SaleDTO object.
	 */
	public void initializeSale() {
		this.sale = new Sale(externalInventory);
		Receipt receipt = new Receipt(sale.getSale());
	}

	/**
	 * Attempts to add a new item to the current sale.
	 * @param itemID The ID of the item to be added.
	 * @param quantity The quantity of the item to be added.
	 * @return The ItemDTO of the item with the provided ID
	 */
	public ItemDTO scanItem(String itemID, int quantity) {
		boolean itemSuccessfullyAdded = false;
		ItemDTO addedItem = null;
		for(int currentItemsAdded = 0; currentItemsAdded < quantity; currentItemsAdded++) {
			addedItem = sale.addItem(itemID);
		}
		return addedItem;
	}

	public void checkDiscount() {

	}

	public void applyDiscount(Discount discount) {
		sale.addDiscount(discount);
	}

	public void endSale() {
		Payment customerPayment = new Payment(100, this.sale);
		String receiptString = receipt.getReceipt();
		printer.printReceipt(receiptString);

		/**
		 * Ta emot betalning, skicka till Register
		 * Skapa Receipt
		 * Skicka till Printer
		 */

	}

	public Sale getSale() {
		return sale;
	}

}
