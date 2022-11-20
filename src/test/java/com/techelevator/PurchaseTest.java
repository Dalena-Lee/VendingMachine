package com.techelevator;

import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void InitialMoney(){
        Purchase purchaseTest = new Purchase();
        BigDecimal expectedBalance = BigDecimal.ZERO;
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        assertTrue(expectedBalance.compareTo(actualBalance) == 0);
    }

    @Test
    public void GetNumberOfItems(){
        Purchase purchaseTest = new Purchase();
        purchaseTest.increaseNumberOfItems();
        purchaseTest.increaseNumberOfItems();
        assertEquals(2, purchaseTest.getNumberOfItems());

        purchaseTest = new Purchase();
        assertEquals(0, purchaseTest.getNumberOfItems());
    }

    @Test
    public void addToBalance(){
        Purchase purchaseTest = new Purchase();
        BigDecimal depositAmount = BigDecimal.valueOf(20);
        purchaseTest.addToBalance(depositAmount);
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        assertTrue(depositAmount.compareTo(actualBalance) == 0);

        //Testing amounts greater than $30.
        purchaseTest = new Purchase();
        depositAmount = BigDecimal.valueOf(30);
        purchaseTest.addToBalance(depositAmount);
        actualBalance = purchaseTest.getCurrentBalance();
        assertTrue("Expected balance: 0.00" + "\n" + "Actual balance: " + actualBalance,actualBalance.compareTo(depositAmount) == -1);
    }

    @Test
    public void calculateChange(){
        Purchase purchaseTest = new Purchase();
        BigDecimal initialBalance = BigDecimal.valueOf(5.00);
        BigDecimal testPrice = BigDecimal.valueOf(1.25);
        BigDecimal expectedBalance = initialBalance.subtract(testPrice);
        purchaseTest.addToBalance(initialBalance);
        BigDecimal actualBalance = purchaseTest.calculateChange(testPrice, false);

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void calculateChangeNovember(){
        //Testing discount with 1 item.
        Purchase purchaseTest = new Purchase();
        BigDecimal initialBalance = new BigDecimal("5");
        BigDecimal testPrice = new BigDecimal("2.50");
        purchaseTest.increaseNumberOfItems();
        BigDecimal expectedBalance = initialBalance.subtract(testPrice);
        purchaseTest.addToBalance(initialBalance);
        BigDecimal actualBalance = purchaseTest.calculateChange(testPrice, true);

        assertEquals(expectedBalance, actualBalance);

        //Testing discount with 2 items
        purchaseTest = new Purchase();
        initialBalance = new BigDecimal("5.25");
        testPrice = new BigDecimal("2.25");
        purchaseTest.increaseNumberOfItems();
        purchaseTest.increaseNumberOfItems();
        expectedBalance = new BigDecimal("4.00");
        purchaseTest.addToBalance(initialBalance);
        actualBalance = purchaseTest.calculateChange(testPrice, true);

        assertEquals(expectedBalance, actualBalance);

        //Testing discount with 5 items
        purchaseTest = new Purchase();
        initialBalance = new BigDecimal("10.50");
        testPrice = new BigDecimal("2.00");
        expectedBalance = new BigDecimal("2.50");
        purchaseTest.addToBalance(initialBalance);

        for (int i = 0; i < 5; i++) {
            purchaseTest.increaseNumberOfItems();
            purchaseTest.calculateChange(testPrice, true);
        }

        actualBalance = purchaseTest.getCurrentBalance();

        assertEquals(expectedBalance, actualBalance);

        //Testing discount with 10 items.
        purchaseTest = new Purchase();
        initialBalance = new BigDecimal("20.00");
        testPrice = new BigDecimal("2.00");
        expectedBalance = new BigDecimal("5.00");
        purchaseTest.addToBalance(initialBalance);

        for (int i = 0; i < 10; i++) {
            purchaseTest.increaseNumberOfItems();
            purchaseTest.calculateChange(testPrice, true);
        }

        actualBalance = purchaseTest.getCurrentBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void receiveChange(){
        Purchase purchaseTest = new Purchase();
        purchaseTest.addToBalance(BigDecimal.valueOf(0.75));

        List<String> testList = new ArrayList<>();
        testList.add("Thank you for your purchase!");
        testList.add("Change dispensed: ");
        testList.add("3 Quarters");

        List<String> actualList = purchaseTest.receiveChange();

        assertTrue(actualList.equals(testList));
        assertEquals(BigDecimal.valueOf(0), purchaseTest.getCurrentBalance());

        purchaseTest.addToBalance(BigDecimal.valueOf(1.75));
        testList.clear();
        testList.add("Thank you for your purchase!");
        testList.add("Change dispensed: ");
        testList.add("1 One Dollar Bill");
        testList.add("3 Quarters");

        actualList.clear();
        actualList = purchaseTest.receiveChange();

        assertTrue(actualList.equals(testList));
        assertEquals(BigDecimal.valueOf(0), purchaseTest.getCurrentBalance());

        purchaseTest.addToBalance(BigDecimal.valueOf(18.65));
        testList.clear();
        testList.add("Thank you for your purchase!");
        testList.add("Change dispensed: ");
        testList.add("1 Ten Dollar Bill");
        testList.add("1 Five Dollar Bill");
        testList.add("3 One Dollar Bills");
        testList.add("2 Quarters");
        testList.add("1 Dime");
        testList.add("1 Nickel");

        actualList.clear();
        actualList = purchaseTest.receiveChange();

        assertTrue(actualList.equals(testList));
        assertEquals(BigDecimal.valueOf(0), purchaseTest.getCurrentBalance());

    }

}
