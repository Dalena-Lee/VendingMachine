package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void ConstructorTest() {
    }

    @Test
    public void existingNameTest(){
        //create object of class you want to test
        Item getItemNameTest = new Item();
        String itemName = "ValentineHugs";

        String result = getItemNameTest.getItemName();
        Assert.assertEquals("ValentineHugs", result);
    }
    @Test
    public void nonExistentNameTest(){
        Item getItemNameTest = new Item();
        String itemName = "Squeakers";
        String result = getItemNameTest.getItemName();
        Assert.assertEquals("", result);
    }


    @Test
    public void getType(){

    }

    @Test
    public void getItemKey(){

    }

    @Test
    public void getStockCount(){

    }

    @Test
    public void setStockCount(){

    }

    @Test getPurchasePrice(){

    }
}