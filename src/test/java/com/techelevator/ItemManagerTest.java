package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemManagerTest {
    @Test
    public void inStock(){
        //Arrange

        List<Item> testItems = new ArrayList<>();
        Item firstItem = new Item("A1", "Peppsi", "1.65" ,"drink");
        testItems.add(firstItem);
        testItems.add(new Item("A5", "Poppit", "1.35" ,"gum"));
        ItemManager itemManager = new ItemManager(testItems);
        int stockCount = 0;

        //Act
        boolean actual = itemManager.isInStock(firstItem);

        //Assert
        Assert.assertTrue(actual);
    }
    @Test
    public void outOfStock() {
        List<Item> testItems = new ArrayList<>();
        Item firstItem = new Item("A1", "Peppsi", "1.65", "drink");
        testItems.add(firstItem);
        testItems.add(new Item("A5", "Poppit", "1.35", "gum"));
        ItemManager itemManager = new ItemManager(testItems);
        for (int i = 0; i < 5; i++) {
            itemManager.decreaseStock("A1");
        }

        //Act
        boolean actual = itemManager.isInStock(firstItem);

        //Assert
        Assert.assertTrue(actual);

        itemManager.decreaseStock("A1");
        actual = itemManager.isInStock(firstItem);
        Assert.assertFalse(actual);

    }
}