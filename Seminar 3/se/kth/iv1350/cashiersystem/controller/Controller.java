package se.kth.iv1350.cashiersystem.controller;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.integration.DiscountDatabase;
import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;
import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.model.Discount;
import se.kth.iv1350.cashiersystem.model.Payment;
import se.kth.iv1350.cashiersystem.model.Receipt;
import se.kth.iv1350.cashiersystem.model.Register;
import se.kth.iv1350.cashiersystem.model.Sale;

public class Controller {
	private Sale sale;
	private ExternalInventory externalInventory;
	private ExternalAccounting externalAccounting;
	private DiscountDatabase discountDatabase;
	private Receipt receipt;
	private Printer printer;
	private Register register;

	/**
	 * Constructor for the Controller class
	 * @param externalInventory The inventory system to be used for retrieving item information.
	 * @param externalAccounting The accounting system which will be used for updating accounting records after a sale.
	 * @param discountDatabase The database containing discount information.
	 * @param printer The printer which will be used for printing receipts.
	 * @param register The register which will be used for depositing "leftover" cash from customer payments.
	 */
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
	}

	/**
	 * Attempts to add a new item to the current sale.
	 * @param itemID The ID of the item to be added.
	 * @param quantity The quantity of the item to be added.
	 * @return The ItemDTO of the item with the provided ID
	 */
	public ItemDTO scanItem(String itemID, int quantity) {
		ItemDTO addedItem = null;
		for(int currentItemsAdded = 0; currentItemsAdded < quantity; currentItemsAdded++) {
			addedItem = sale.addItem(itemID);
		}
		return addedItem;
	}

	/**
	 * "Fake" method for checking if a discount is available.
	 */
	public void checkDiscount() {
	}

	/**
	 * Adds discount to the current sale.
	 */
	public void applyDiscount(Discount discount) {
		sale.addDiscount(discount);
	}

	/**
	 * Method for ending the current sale. Handles the payment process and updates the external systems.
	 */
	public void endSale() {
		Payment customerPayment = new Payment(100, sale.getSale());
		customerPayment.calculateChange();
		externalInventory.updateInventory(sale.getSale());
		externalAccounting.updateAccounting(customerPayment);
		Receipt receipt = new Receipt(sale.getSale(), customerPayment);
		String receiptString = receipt.getReceipt();
		printer.printReceipt(receiptString);
		double amountToDeposit = customerPayment.getPaidAmount() - customerPayment.getChange();
		register.deposit(amountToDeposit);
	}

	/**
	 * Returns the current sale.
	 * @return The current sale object.
	 */
	public Sale getSale() {
		return sale;
	}
}
