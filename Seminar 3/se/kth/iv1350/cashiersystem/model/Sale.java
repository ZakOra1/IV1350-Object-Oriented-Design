package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;


public class Sale {
	private SaleDTO currentSale;
	private ExternalInventory inventory;

	/**
	 * Constructor for Sale
	 * @param saleDTO The sale data transfer object
	 */
	public Sale(ExternalInventory inventory) {
		this.inventory = inventory;
		this.currentSale = new SaleDTO();
	}

	/**
	 * Adds an item to the sale if it exists in stock
	 * @param itemID The itemID to add
	 */
	public ItemDTO addItem(String itemID) {
		int currentQuantity = currentSale.quantityOfItemScanned(itemID);
		ItemDTO itemAvailable = inventory.getItem(itemID, currentQuantity + 1);

		if(itemAvailable != null) {
			currentSale.addItemToSale(itemAvailable);
			itemAvailable.setSaleQuantity(currentQuantity + 1);
			return itemAvailable;
		} else {
			return null;
		}
	}

	/**
	 * Returns the current total price of the sale
	 * @return The current total price of the sale
	 */
	public double getTotalPrice() {
		return currentSale.getTotalPrice();
	}

	public double getTotalVat() {
		return currentSale.getVATAmount();
	}

	/**
	 * Ends the current sale and updates the inventory accordingly
	 */
	public void endSale() {
		inventory.updateInventory(currentSale);
	}

	/**
	 * Returns the current SaleDTO object
	 * @return The current SaleDTO object
	 */
	public SaleDTO getSale() {
		return currentSale;
	}

	/**
	 * This method is a placeholder for the discount functionality.
	 */
	public double addDiscount(Discount discount) {
		return 0.0;
	}
}