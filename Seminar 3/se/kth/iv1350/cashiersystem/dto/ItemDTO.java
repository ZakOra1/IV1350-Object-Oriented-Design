package se.kth.iv1350.cashiersystem.dto;

public class ItemDTO {
	private String id;
	private String name;
	private double price;
	private double vatRate;
	private String description;
	private int quantityInSale;
	private int quantityInStock;

	private static final int PERCENT_CONVERSION = 100;

	/**
	 * Constructor for ItemDTO
	 * @param id Unique ID of the item
	 * @param name The name of the item
	 * @param price The price of the item
	 * @param vatRate The VAT rate of the item
	 * @param description The description of the item
	 * @param quantityInStock The current available quantity of the item
	 */
	public ItemDTO(String id, String name, double price, double vatRate, String description, int quantityInStock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.description = description;
		this.quantityInSale = 0;
		this.quantityInStock = quantityInStock;
	}

	/** 
	 * Returns the VAT percentage rate of the item.
	 * @return VAT percentage rate of the item.
	 */
	public double getVatRate() {
		return vatRate;
	}

	/** Returns the name of the item
	 * @return The name of the item
	 */
	public String getName() {
		return name;
	}

	/** Returns the price of the item
	 * @return The price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns the total price of the items with the same ID currently in the sale.
	 * * @return The total price of the items with the same ID in the sale.
	 */
	public double getTotalPrice() {
		return price * quantityInSale;
	}

	/**
	 * Sets the quantity of the item available in stock.
	 * @param quantity The quantity of the item available in stock.
	 */
	public void setStockQuantity(int quantity) {

		this.quantityInStock = quantity;
	}

	/**
	 * Returns the quantity of the item in stock.
	 * @return the quantity of the item in stock.
	 */
	public int getStockQuantity() {
		return quantityInStock;
	}

	/**
	 * Returns the quantity of the item that has been added to the sale.
	 * @return the quantity of the item that has been added to the sale. 
	 */
	public int getSaleQuantity() {
		return quantityInSale;
	}
	
	/**
	 * Sets the quantity of the item that has been added to the sale.
	 * @param quantity The quantity of the item that has been added to the sale.
	 */
	public void setSaleQuantity(int quantity) {
		this.quantityInSale = quantity;
	}

	/**
	 * Returns the quantity of the item that is available for sale.
	 * @return The quantity of the item that is available for sale.
	 */
	public int getAvailableQuantity() {
		return quantityInStock - quantityInSale;
	}

	/**
	 * Returns the ID of the item.
	 * @return The ID of the item.
	 */
	public String getID() {
		return id;
	}

	/**
	 * Calculates the amount of money that is VAT for the item.
	 * @return The amount of money that is VAT for the item.
	 */
	public double getVatAmount() {
		double priceExcludingVat = price / (1 + vatRate / PERCENT_CONVERSION);
		return price - priceExcludingVat;
	}

	/**
	 * Returns the item description String.
	 * @return The item description String.
	 */
	public String getDescription() {
		return description;
	}
}
