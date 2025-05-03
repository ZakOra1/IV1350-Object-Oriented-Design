package se.kth.iv1350.cashiersystem.dto;

import java.util.ArrayList;

public class SaleDTO {

	private ArrayList<ItemDTO> itemList = new ArrayList<>();
	private double totalPrice;
	private double totalVAT;
	private java.time.LocalDateTime dateTime;

	/**
	 * Constructor for SaleDTO
	 */
	public SaleDTO() {
		this.dateTime = java.time.LocalDateTime.now();
		this.totalPrice = 0;
		this.itemList = new ArrayList<>();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void addItemToSale(ItemDTO item) {
		itemList.add(item);
		totalPrice += item.getPriceIncVat();
		totalVAT += item.getVATAmount();
	}

	public int quantityOfItemScanned(String itemID) {
		int currentQuantityInSale = 0;
		for (ItemDTO item: itemList) {
			if (item.getID() == itemID) {
				currentQuantityInSale += 1;
			}
		}
		return currentQuantityInSale;
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

	public double getVATAmount() {
		return totalVAT;
	}


}
