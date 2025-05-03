package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;

public class Receipt {

	private SaleDTO sale;

	public Receipt(SaleDTO sale) {	
		this.sale = sale;
	}

	public String getReceipt() {
		StringBuilder receipt = new StringBuilder();
		receipt.append("------------------ Begin receipt ------------------\n");
		receipt.append("Time of Sale : ").append(sale.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).append("\n\n");

		for (ItemDTO item: sale.getItems()) {
			receipt.append(item.getName())
				   .append(" ")
				   .append(item.getQuantity())
				   .append(" x ")
				   .append(String.format("%.2f", item.getPrice()))
				   .append(" ")
				   .append(String.format("%.2f", item.getPriceIncVat()))
				   .append(" SEK\n");
		}

		receipt.append("\n");
		receipt.append("Total : ").append(String.format("%.2f", sale.getTotalPrice())).append(" SEK\n");
		receipt.append("VAT : ").append(String.format("%.2f", sale.getVATAmount())).append("\n\n");
		receipt.append("Cash : ").append(String.format("%.2f", sale.getPaidAmount())).append(" SEK\n");
		receipt.append("Change : ").append(String.format("%.2f", sale.getChange())).append(" SEK\n");
		receipt.append("------------------ End receipt ------------------\n");

		return receipt.toString();
	}
}