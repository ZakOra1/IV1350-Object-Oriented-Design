package se.kth.iv1350.cashiersystem.model;

import java.time.LocalDateTime;

import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Discount;
import se.kth.iv1350.cashiersystem.model.Register;

public class Payment {
	private double paidAmount;
	private double change;
	private SaleDTO sale;
	private java.time.LocalDateTime dateTime;

	/**
	 * Constructor for the Payment class
	 */
	public Payment(double paid, SaleDTO sale) {
		this.dateTime = java.time.LocalDateTime.now();
		this.paidAmount = paid;
		this.sale = sale;
	}

	/**
	 * Calculates how much change to give to the customer, 
	 * Discount is currently a hardcoded placeholder as there is no Discount database currently
	 */
	public void calculateChange() {
		double totalPrice = this.sale.getTotalPrice();
		Discount discount = new Discount(this.sale, 1);
		double discountedPrice = totalPrice - this.sale.addDiscount();
		this.change = this.paidAmount - discountedPrice;
	}

	/**
	 * Returns the amount of money the customer paid
	 * @return The amount of money the customer paid
	 */
	public double getPaidAmount() {
		return this.paidAmount;
	}

	/**
	 * Returns the change to give to the customer
	 * @return The change to give to the customer
	 */
	public double getChange() {
		return this.change;
	}
}