package se.kth.iv1350.cashiersystem.integration;

import java.util.ArrayList;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Sale;

public class ExternalInventory {

	private java.util.HashMap<String, ItemDTO, Integer> inventory = new java.util.HashMap<>();

	/**
	 * Constructor for ExternalInventory
	 * Adds some items to the inventory for testing purposes (Later: Actually added from constructor)
	 */
	public ExternalInventory() {
		this.inventory = new ArrayList<ItemDTO>();



		/**
		 * Lägg till dom här i view eller controller
		 * 		inventory.put("abc123", new ItemDTO("abc123", "BigWheel Oatmeal", 29.90, 6, "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", 2));
		inventory.put("def456", new ItemDTO("def456", "YouGoGo Blueberry", 14.90, 6, "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour", 1));
		*/
	}

	public void addItemToInventory(ItemDTO item) {
		itemInInventory.add(item);
		inventory.put(item.getID(), item);
	}

	/**
	 * Method to check if an item is in stock.
	 * If enough quantity of the items is in stock, return the item.
	 * Otherwise, return null.
	 * @param id Unique ID of the item in the inventory
	 * @return The item with the specified ID
	 */
	public ItemDTO getItem(String id, int quantity) {
		ItemDTO item = inventory.get(id);
		for (ItemDTO itemInList : itemInInventory) {
			if (itemInList != null && itemInList.getQuantity() >= quantity) {
				return itemInList;
			}
		}
		return null;
	}
	

	/**
	 *  
	 */
	public void updateInventory(SaleDTO sale) {
		for (ItemDTO soldItem : sale.getItems()) {
			ItemDTO itemInInventory = inventory.get(soldItem.getID());
			if (itemInInventory != null) {
				int updatedQuantity = itemInInventory.getQuantity() - soldItem.getQuantity();
				itemInInventory.setQuantity(updatedQuantity);
			}
		}
	}
	
	}
}
