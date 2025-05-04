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

	public double getVatRate() {
		return vatRate;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return price * quantityInSale;
	}

	public void setStockQuantity(int quantity) {
		this.quantityInStock = quantity;
	}

	public int getStockQuantity() {
		return quantityInStock;
	}

	public int getSaleQuantity() {
		return quantityInSale;
	}
	
	public void setSaleQuantity(int quantity) {
		this.quantityInSale = quantity;
	}

	public int getAvailableQuantity() {
		return quantityInStock - quantityInSale;
	}

	public String getID() {
		return id;
	}

	public double getVatAmount() {
		double priceExcludingVat = price / (1 + vatRate / PERCENT_CONVERSION);
		return price - priceExcludingVat;
	}

	public String getDescription() {
		return description;
	}
}
