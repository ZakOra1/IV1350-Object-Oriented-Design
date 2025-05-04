package se.kth.iv1350.cashiersystem.model;

import se.kth.iv1350.cashiersystem.controller.Controller;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.integration.DiscountDatabase;


/**
 * Placeholder, discounts are not actually handled as it is not included in the seminar task due to being handled by a database
 */
public class Discount {
	private DiscountDatabase discountDB;
	
	public Discount(DiscountDatabase DiscountDB) {
	}
		
	public void getDiscount(SaleDTO sale, int customerID) {
	}

}
