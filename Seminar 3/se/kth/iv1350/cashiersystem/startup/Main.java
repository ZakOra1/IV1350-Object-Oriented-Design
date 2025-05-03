package se.kth.iv1350.cashiersystem.startup;

import se.kth.iv1350.cashiersystem.view.View;
import se.kth.iv1350.cashiersystem.controller.Controller;
import se.kth.iv1350.cashiersystem.integration.Printer;
import se.kth.iv1350.cashiersystem.model.Register;
import se.kth.iv1350.cashiersystem.integration.ExternalAccounting;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;



public class Main {

	public static void main(String args) {
		Printer printer = new Printer();
		Register register = new Register();
		ExternalAccounting externalAccounting = new ExternalAccounting();
		ExternalInventory externalInventory = new ExternalInventory();
		Controller contr = new Controller()
		View view = new View(contr);
		view.sampleExecution();

	}

}
