package se.kth.iv1350.cashiersystem.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.integration.Printer;

public class Receipt {
	private SaleDTO sale;
	private LocalDateTime timeOfSale;
	private Payment customerPayment;

	/**
	 * Creates an instance of Receipt.
	 * @param sale The sale object containing the items and their prices.
	 * @param customerPayment The payment object containing the amount paid by the customer.
	 */
	public Receipt(SaleDTO sale, Payment customerPayment) {	
		this.sale = sale;
		this.customerPayment = customerPayment;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.timeOfSale = LocalDateTime.now();
		this.timeOfSale.format(formatter);
	}

	/**
	 * Constructs the receipt
	 * @return A string representation of the receipt.
	 */
	public String getReceipt() {
		StringBuilder receipt = new StringBuilder();
		receipt.append("------------------ Begin receipt ------------------\n");
		receipt.append("Time of Sale : " + timeOfSale + "\n\n");
		for (ItemDTO item : sale.getItems()) {
			receipt.append(item.getName())
				   .append("    ")
				   .append(item.getSaleQuantity())
				   .append(" x ")
				   .append(String.format("%.2f", item.getPrice()))
				   .append("     ")
				   .append(String.format("%.2f", item.getTotalPrice()))
				   .append(" SEK\n");
		}

		receipt.append("\n");
		receipt.append("Total : ").append(String.format("%.2f", sale.getTotalPrice())).append(" SEK\n");
		receipt.append("VAT : ").append(String.format("%.2f", sale.getVATAmount())).append("SEK").append("\n\n");
		receipt.append("Cash: " + customerPayment.getPaidAmount()).append(" SEK\n");
		receipt.append("Change: ").append(String.format("%.2f", customerPayment.getChange())).append(" SEK\n");
		receipt.append("------------------ End receipt ------------------\n");

		return receipt.toString();
	}
}