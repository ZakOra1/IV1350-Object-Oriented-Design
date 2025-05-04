package se.kth.iv1350.cashiersystem.integration;

import java.util.ArrayList;

import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.model.Payment;
import se.kth.iv1350.cashiersystem.model.Sale;

public class ExternalAccounting {
    private ArrayList<Payment> transactionRecords = new ArrayList<>();

    /**
     * Creates an instance of ExternalAccounting, simulating an external accounting system.
     */
    public ExternalAccounting() {
    }

    /**
     * Updates the accounting system with the given payment.
     * 
     * @param payment The payment to be recorded in the accounting system.
     */
    public void updateAccounting(Payment payment) {
        transactionRecords.add(payment);
    }
}
