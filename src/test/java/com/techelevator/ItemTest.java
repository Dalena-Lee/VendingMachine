package com.techelevator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemTest {
    private static Class<?> item;

    @BeforeClass
    public static void setup() {
        try {
            item = Class.forName("com.techelevator.Item");
        } catch (ClassNotFoundException e) {
            fail("com.techelevator.Item class not found");
        }
    }

    @Test
    public void testCreateItem() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Constructor<?> constructor = item.getConstructor(String.class,String.class,String.class,String.class);
            Object sut = constructor.newInstance("KEY", "NAME", "1.25", "TYPE");
            assertNotNull(sut);
            assertEquals("NAME", sut.getClass().getMethod("getItemName").invoke(sut));
            assertEquals("KEY", sut.getClass().getMethod("getItemKey").invoke(sut));
            assertEquals(BigDecimal.valueOf(1.25), sut.getClass().getMethod("getPurchasePrice").invoke(sut));
            assertEquals("TYPE", sut.getClass().getMethod("getType").invoke(sut));
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void getItemName(){
        Item item = new Item("TEST", "NAME","1.25", "Type");
        String actual = item.getItemName();
        String expected = "NAME";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getType(){
        Item item = new Item("TEST", "TEST","1.25", "Type");
        String actual = item.getType();
        String expected = "Type";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getItemKey(){
        Item item = new Item("KEY", "TEST","1.25", "TEST");
        String actual = item.getItemKey();
        String expected = "KEY";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStockCount(){
        Item item = new Item("TEST", "TEST","1.25", "TEST");
        int actual = item.getStockCount();
        int expected = 6;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setStockCount(){
        Item item = new Item("TEST", "TEST","1.25", "TEST");
        item.setStockCount(4);
        int actual = item.getStockCount();
        int expected = 4;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPurchasePrice(){
        Item item = new Item("TEST", "TEST","1.25", "TEST");
        BigDecimal actual = item.getPurchasePrice();
        BigDecimal expected = BigDecimal.valueOf(1.25);

        Assert.assertEquals(expected,actual);
    }
}