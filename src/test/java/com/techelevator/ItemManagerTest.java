package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ItemManagerTest extends TestCase {
    @Test
    public void outOfStock(){
        //Arrange
        //ItemManager itemManager = new ItemManager();
        int stockCount = 0;

        //Act
        //boolean actual = itemManager.isInStock(stockCount);

        //Assert
        //Assert.assertFalse();
    }
    @Test
    public void inStock(){
        //Arrange
        //ItemManager itemManager = new ItemManager();
        int stockCount = 6;

        //Act
        //boolean actual = itemManager.isInStock(stockCount);

        //Assert
        //Assert.assertTrue();
    }
    @Test
    public void overStock(){
        //Arrange
        //ItemManager itemManager = new ItemManager();
        int stockCount = 7;

        //Act
        //boolean actual = itemManager.isInStock(stockCount);

        //Assert
        //Assert.assertFalse();
    }

}