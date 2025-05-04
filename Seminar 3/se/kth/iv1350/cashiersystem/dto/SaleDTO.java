package se.kth.iv1350.cashiersystem.dto;

import java.util.ArrayList;

public class SaleDTO {
	private ArrayList<ItemDTO> itemList = new ArrayList<>();
	private double totalPrice;
	private double totalVAT;

	/**
	 * Constructor for SaleDTO
	 */
	public SaleDTO() {
		this.totalPrice = 0;
		this.totalVAT = 0;
		this.itemList = new ArrayList<>();
	}

	/**
	 * Returns the total price of the sale
	 * @return The total price of the sale
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Checks if the item is already scanned in the sale
	 * @param item The item to check
	 * @return true if the item is already scanned, false otherwise
	 */
	public boolean checkIfScannedItem (ItemDTO item) {
		for (ItemDTO scannedItem : itemList) {
			if (item == scannedItem) {
				return true;
			}
		}
		return false;
	} 

	/**
	 * Adds an item to the sale. If the item is already scanned, it increases the sale quantity of the item.
	 * @param item The item to add to the sale
	 */
	public void addItemToSale(ItemDTO item) {
		if(!checkIfScannedItem(item)) {
			itemList.add(item);
		}
		else {
			item.setSaleQuantity(item.getSaleQuantity() + 1);
		}  
		totalPrice += item.getPrice();
		totalVAT += item.getVatAmount();
	}

	/**
	 * Counts how many items of the provided ID have been added to the sale
	 * @param itemID The ID of the item to count
	 * @return The number of items with the provided ID in the sale
	 */
	public int quantityOfItemScanned(String itemID) {
		int currentQuantityInSale = 0;
		for (ItemDTO item : itemList) {
			if (item.getID() == itemID) {
				currentQuantityInSale++;
			}
		}
		return currentQuantityInSale;
	}

	/**
	 * Returns the list of items in the sale.
	 * @return The list of items in the sale.
	 */
	public ArrayList<ItemDTO> getItems() {
		return itemList;
	}
	
	/**
	 * Returns the total VAT price of the sale.
	 * @return The total VAT price of the sale.
	 */
	public double getVATAmount() {
		return totalVAT;
	}

	/**
	 * Returns the discount amount for the sale. 
	 * This method is a placeholder since the seminar task does not require a discount.
	 * @return The discount amount for the sale.
	 */
	public double addDiscount() {
		return 0.0;
	}
}