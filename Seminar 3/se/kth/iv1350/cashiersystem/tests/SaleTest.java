package se.kth.iv1350.cashiersystem.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;
import se.kth.iv1350.cashiersystem.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale;
    private ExternalInventory inventory;
    private ItemDTO item1;
    private ItemDTO item2;

    @BeforeEach
    void setUp() {
        inventory = new ExternalInventory();
        item1 = new ItemDTO("a", "test name a", 1, 6, "test description a", 10);
        item2 = new ItemDTO("b", "test name b", 2, 6, "test description b", 5);
        inventory.addItemToInventory(item1);
        inventory.addItemToInventory(item2);
        sale = new Sale(inventory);
    }

    @Test
    void testAddItemSuccess() {
        ItemDTO addedItem = sale.addItem("a");
        assertNotNull(addedItem, "Item should be added");
        assertEquals("a", addedItem.getID(), "Item ID should be a");
        assertEquals(1, addedItem.getSaleQuantity(), "Sale quantity should be updated correctly");
    }

    @Test
    void testAddItemNotFound() {
        ItemDTO addedItem = sale.addItem("fakeID");
        assertNull(addedItem, "Item should not be found in inventory");
    }

    @Test
    void testGetTotalPrice() {
        sale.addItem("a");
        sale.addItem("b");
        double expectedTotalPrice = item1.getPrice() + item2.getPrice();
        assertEquals(expectedTotalPrice, sale.getTotalPrice(), 0.01, "Total sale price should be calculated correctly");
    }

    @Test
    void testGetTotalVat() {
        sale.addItem("a");
        sale.addItem("b");
        double expectedTotalVat = item1.getVatAmount() + item2.getVatAmount();
        assertEquals(expectedTotalVat, sale.getTotalVat(), 0.01, "Total VAT should be calculated correctly");
    }
}