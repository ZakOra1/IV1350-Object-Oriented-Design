package se.kth.iv1350.cashiersystem.integration;

import java.util.HashMap;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Sale;

public class ExternalInventory {

	private HashMap<String, ItemDTO> inventory;

	/**
	 * Constructor for ExternalInventory
	 * Adds some items to the inventory for testing purposes (Later: Actually added from constructor)
	 */
	public ExternalInventory() {
		this.inventory = new HashMap<String, ItemDTO>();
	}

	public void addItemToInventory(ItemDTO item) {
		inventory.put(item.getID(), item);
	}

	/**
	 * Method to check if an item is in stock.
	 * If enough quantity of the items is in stock, return the item.
	 * Otherwise, return null.
	 * @param id Unique ID of the item in the inventory
	 * @param quantity The amount of the item that the customer wishes to purchase
	 * @return The item with the specified ID
	 */
	public ItemDTO getItem(String id, int quantity) {
		ItemDTO item = inventory.get(id);

		for(ItemDTO itemInList : inventory.values()) {
			if (itemInList.getID().equals(id) && 
			(itemInList.getAvailableQuantity() >= quantity)) {
				return itemInList;
			}
		}

		return null;
	}

	/**
	 * Updates the available quantities after a sale has ended (Doesn't actually do anything, not included in seminar task)
	 * @param sale SaleDTO object containing information about which items has been sold, as well as how many of each item
	 */
	public void updateInventory(SaleDTO sale) {
	}
}
