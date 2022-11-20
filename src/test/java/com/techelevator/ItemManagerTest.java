package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class ItemManagerTest {
    @Test
    public void isInStock(){
        //Arrange
        List<Item> testItems = new ArrayList<>();
        ItemManager itemManager = new ItemManager(testItems);
        Item item1 = new Item("A1", "Peppsi", "1.65" ,"drink");
        Item item2 = new Item("A5", "Poppit", "1.35" ,"gum");
        testItems.add(item1);
        testItems.add(item2);

        //Stock count should start at 6.
        assertTrue(itemManager.isInStock(item1));
        assertTrue(itemManager.isInStock(item2));

        //Decreasing once.
        itemManager.decreaseStock("A1");
        int expectedStock = 5;
        int actualStock = item1.getStockCount();
        Assert.assertEquals(expectedStock, actualStock);

        //Testing cases where the user buys out the items.
        for (int i = 0; i < 6; i++) {
            itemManager.decreaseStock("A5");
        }
        expectedStock = 0;
        actualStock = item2.getStockCount();
        Assert.assertEquals(expectedStock,actualStock);
    }

    @Test
    public void getItems(){
        List<Item> testItems = new ArrayList<>();
        ItemManager itemManager = new ItemManager(testItems);
        Item item1 = new Item("A1", "Peppsi", "1.65" ,"drink");
        Item item2 = new Item("A5", "Poppit", "1.35" ,"gum");
        testItems.add(item1);
        testItems.add(item2);

        assertTrue(itemManager.getItems().equals(testItems));
    }

}