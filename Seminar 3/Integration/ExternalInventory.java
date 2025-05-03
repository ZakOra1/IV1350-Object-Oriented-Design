package se.kth.iv1350.cashiersystem.integration;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Sale;

public class ExternalInventory {

	Arraylist<ItemDTO> itemInInventory;

	/**
	 * Constructor for ExternalInventory
	 * Adds some items to the inventory for testing purposes (Later: Actually added from constructor)
	 */
	public ExternalInventory() {
		this.itemInInventory = new ArrayList<ItemDTO>();


		/**
		 * Lägg till dom här i view eller controller
		 * 		inventory.put("abc123", new ItemDTO("abc123", "BigWheel Oatmeal", 29.90, 6, "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free", 2));
		inventory.put("def456", new ItemDTO("def456", "YouGoGo Blueberry", 14.90, 6, "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour", 1));
	}
		 */


	

	/**
	 * Method to check if an item is in stock.
	 * If enough quantity of the items is in stock, return the item.
	 * Otherwise, return null.
	 * @param id Unique ID of the item in the inventory
	 * @return The item with the specified ID
	 */
	public ItemDTO getItem(String id, int quantity) {
		ItemDTO item = inventory.get(id);
		for (item : itemInInventory) {
			if (item != null && item.getQuantity() >= quantity) {
				return item;
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
