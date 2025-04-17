package DTO;

import java.util.ArrayList;

public class SaleDTO {

	private ArrayList<ItemDTO> itemList = new ArrayList<>();
	private int priceTotal;
	private java.time.LocalDateTime dateTime;

	/**
	 * Constructor for SaleDTO
	 */
	public SaleDTO() {
	}

	public double getTotalPrice() {
		return priceTotal;
	}

	public void additem(ItemDTO item) {
		itemList.add(item);
		priceTotal += item.getPriceIncVat();
	}

	public int quantityOfItemScanned(String itemID) {
		int currentQuantityInList = 0;
		for (ItemDTO item: itemList) {
			if (item.getID() == itemID) {
				currentQuantityInList += 1;
			}
		}
		return currentQuantityInList;
	}

	public ArrayList<ItemDTO> getItems() {
		return itemList;
	}

	public java.time.LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.time.LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void removeItem(ItemDTO item) {
		itemList.remove(item);
		priceTotal -= item.getPriceIncVat();
	}

}
