package se.kth.iv1350.cashiersystem.dto;

public class ItemDTO {

	private String id;
	private String name;
	private double price;
	private int vatRate;
	private String description;
	private int quantity;
	private static final int PERCENT_CONVERSION = 100;

	/**
	 * Constructor for ItemDTO
	 * @param id Unique ID of the item
	 * @param name The name of the item
	 * @param price The price of the item
	 * @param vatRate The VAT rate of the item
	 * @param description The description of the item
	 * @param quantity The current quantity of the item
	 */
	public ItemDTO(String id, String name, double price, int vatRate, String description, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.description = description;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return price * quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getID() {
		return id;
	}

	public double getPriceIncVat() {
		return getTotalPrice() * (vatRate / PERCENT_CONVERSION);
	}

	public double getVATAmount() {
		return getPriceIncVat() - getTotalPrice();
	}

	public String getDescription() {
		return description;
	}
}
