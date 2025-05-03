package se.kth.iv1350.cashiersystem.view;

import se.kth.iv1350.cashiersystem.controller.Controller;


/**
 * Placeholder view. 
 * It is not a "real" view, instead it will use hardcoded calls to the system operations in the controller.
 */
public class View {
	Private Controller contr;

	/**
	 * Constructor for the view class. 
	 * It takes a controller object as a parameter and assigns it to the contr variable.
	 * @param contr The controller object to be used by the view.
	 */
	public View(Controller contr) {
		this.contr = contr;
	}

	/**
	 * Hardcoded method used to simulate a sale
	 */
	public void sampleExecution() {

		/**
		 * Lägg in kommandon för att  
		 * starta en sale
		 * scanna items som är hårdkodade i inventoryn
		 * avsluta sale
		 * kolla discount (extern databas så lite oklart hur vi ska göra det)
		 * skapa kvitto
		 * säg åt printer att skriva ut kvittot
		 */

		 contr.initiateSale();
		 /**
		  * Scanna items som vi hårdkodat i inventoryn
		  */

	}

}
