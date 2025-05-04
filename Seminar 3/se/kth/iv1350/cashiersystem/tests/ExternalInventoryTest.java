package se.kth.iv1350.cashiersystem.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.cashiersystem.dto.ItemDTO;
import se.kth.iv1350.cashiersystem.dto.SaleDTO;
import se.kth.iv1350.cashiersystem.integration.ExternalInventory;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventoryTest {
    private ExternalInventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new ExternalInventory();
        inventory.addItemToInventory(new ItemDTO("a", "test name a", 5, 6, "test description a", 10));
    }

    @Test
    void testGetItemSuccess() {
        ItemDTO item = inventory.getItem("a", 1);
        assertNotNull(item, "Item should be found in inventory");
        assertEquals("a", item.getID(), "Item ID should match");
    }

    @Test
    void testGetItemInsufficientStock() {
        ItemDTO item = inventory.getItem("a", 20);
        assertNull(item, "Item should not be found due to insufficient stock");
    }

    @Test
    void testGetItemNotFound() {
        ItemDTO item = inventory.getItem("nonexistent", 1);
        assertNull(item, "Item should not be found in inventory");
    }
}