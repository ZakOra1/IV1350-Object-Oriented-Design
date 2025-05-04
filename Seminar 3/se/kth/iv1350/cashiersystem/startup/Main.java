package se.kth.iv1350.cashiersystem.startup;

import se.kth.iv1350.cashiersystem.controller.Controller;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.integration.DiscountDatabase;
import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;
import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.model.Register;
import se.kth.iv1350.cashiersystem.view.View;


public class Main {

	public static void main(String[] args) {
		ExternalInventory externalInventory = new ExternalInventory();
		populateInventory(externalInventory);
		ExternalAccounting externalAccounting = new ExternalAccounting();
		DiscountDatabase discountDatabase = new DiscountDatabase();
		Printer printer = new Printer();
		Register register = new Register();
		Controller contr = new Controller(externalInventory, externalAccounting, discountDatabase, printer, register);
		View view = new View(contr);
		view.sampleExecution();
	}

	/**
	 * Populates the inventory with some sample items.
	 * @param inventory The inventory to populate with sample items.
	 */
	private static void populateInventory(ExternalInventory inventory) {
		ItemDTO item1 = new ItemDTO("abc123", "BigWheel Oatmeal", 29.90, 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free", 10);
        ItemDTO item2 = new ItemDTO("def456", "YouGoGo Blueberry", 14.90, 6, "YouGoGo Blueberry 240 g, low sugar yoghurt, blueberry flavour", 10);
		inventory.addItemToInventory(item1);
		inventory.addItemToInventory(item2);
    }
}