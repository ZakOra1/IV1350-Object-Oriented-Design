package se.kth.iv1350.cashiersystem.startup;

import se.kth.iv1350.cashiersystem.view.View;
import se.kth.iv1350.cashiersystem.controller.Controller;
import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.model.Register;
import se.kth.iv1350.cashiersystem.integration.DiscountDatabase;
import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;



public class Main {

	public static void main(String args) {
		ExternalInventory externalInventory = new ExternalInventory();
		ExternalAccounting externalAccounting = new ExternalAccounting();
		DiscountDatabase discountDatabase = new DiscountDatabase();
		Printer printer = new Printer();
		Register register = new Register();
		Controller contr = new Controller(externalInventory, externalAccounting, discountDatabase, printer, register);
		View view = new View(contr);
		
		view.sampleExecution();

		

	}

	private static void populateInventory(ExternalInventory inventory) {
        inventory.addItem("abc123", "BigWheel Oatmeal", "29:90", 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        inventory.addItem("def456", "YouGoGo Blueberry", "14:90", 6, "YouGoGo Blueberry 240 g, low sugar yoghurt, blueberry flavour");
    }

}
