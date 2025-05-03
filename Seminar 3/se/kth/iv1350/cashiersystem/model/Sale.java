package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;


public class Sale {

	private SaleDTO currentSale;
	private ExternalInventory inventory;

	/**
	 * Constructor for Sale
	 * @param saleDTO The sale data transfer object
	 */
	public Sale(SaleDTO sale) {
		this.currentSale = sale;
	}

	/**
	 * Adds an item to the sale if it exists in stock
	 * @param item The item to add
	 */
	public void addItem(String itemID) {
		int currentQuantity = currentSale.quantityOfItemScanned(itemID);
		ItemDTO itemAvailable = inventory.getItem(itemID, currentQuantity + 1);

		if(itemAvailable != null) {
			currentSale.addItemToSale(itemAvailable);
		} else {
			System.out.println("Item not in stock");
		}
	}

	/**
	 * Returns the current total price of the sale
	 * @return The current total price of the sale
	 */
	public int getTotalPrice() {
		return currentSale.getTotalPrice();
	}

	/**
	 * Ends the current sale and updates the inventory accordingly
	 */
	public void endSale() {
		// Update inventory
		inventory.updateInventory(currentSale);

	}

	public Discount addDiscount(Discount saleDiscount) {
		return null;
	}

}
