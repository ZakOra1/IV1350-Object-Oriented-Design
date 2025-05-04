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

	public double getTotalPrice() {
		return totalPrice;
	}

	public boolean checkIfScannedItem (ItemDTO item) {
		for (ItemDTO scannedItem : itemList) {
			if (item == scannedItem) {
				return true;
			}
		}
		return false;
	} 

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

	public int quantityOfItemScanned(String itemID) {
		int currentQuantityInSale = 0;
		for (ItemDTO item : itemList) {
			if (item.getID() == itemID) {
				currentQuantityInSale += 1;
			}
		}
		return currentQuantityInSale;
	}

	public ArrayList<ItemDTO> getItems() {
		return itemList;
	}

	public double getVATAmount() {
		return totalVAT;
	}

	public double addDiscount() {
		return 0.0;
	}


}
