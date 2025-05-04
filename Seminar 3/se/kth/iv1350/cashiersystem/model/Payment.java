package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import java.time.LocalDateTime;

public class Payment {

	private double paidAmount;
	private double change;
	private Sale sale;

	private java.time.LocalDateTime dateTime;


	/**
	 *  
	 */
	public Payment(double paid, Sale sale) {
		this.dateTime = java.time.LocalDateTime.now();
		this.paidAmount = paid;
		this.sale = sale;
	}

	public void calculateChange() {
		double totalPrice = this.sale.getTotalPrice();
		double discountedPrice = totalPrice - this.sale.addDiscount();
		this.change = discountedPrice - totalPrice;
		
	}

}
