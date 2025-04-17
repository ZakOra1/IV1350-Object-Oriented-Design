package Model;

import DTO.SaleDTO;
import Controller.Controller;
import Integration.ExternalInventory;
import DTO.ItemDTO;

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

	// TODO: Implementera removeItem funktion

	/**
	 * Adds an item to the sale if it exists in stock
	 * @param item The item to add
	 */
	public void addItem(String itemID) {
		// Get current quantity of item in the sale
		int currentQuantity = currentSale.quantityOfItemScanned(itemID);

		// Check quantity of item in stock
		ItemDTO itemAvailable = inventory.getItem(itemID, currentQuantity + 1);

		if(itemAvailable != null) {
			// If item is in stock, add it to the sale
			currentSale.additem(itemAvailable);
		} else {
			// If item is not in stock, show error message
			System.out.println("Item not in stock");
		}
	}

	/**
	 *  
	 */
	public void updateTotalPrice() {

	}

	public void endSale() {
		// Update inventory
		inventory.updateInventory(currentSale);

	}

	public Discount addDiscount(Discount saleDiscount) {
		return null;
	}

}
