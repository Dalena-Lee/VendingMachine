package com.techelevator;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurchaseTest {
    @Test
    public void testInitialMoney(){
        Purchase purchaseTest = new Purchase();
        BigDecimal expectedBalance = BigDecimal.ZERO;
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        assertTrue(expectedBalance.compareTo(actualBalance)== 0);


    }
    @Test
    public void testMoneyAdd(){
        Purchase purchaseTest = new Purchase();
        BigDecimal depositAmount = new BigDecimal("30");
        purchaseTest.addToBalance(depositAmount);
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        assertTrue(depositAmount.compareTo(actualBalance)==0 );

    }
    @Test
    public void calculateChange(){
        Purchase purchaseTest = new Purchase();
        BigDecimal testBalance = new BigDecimal("5");
        BigDecimal testPrice = new BigDecimal("2.50");
        BigDecimal expectedBalance = testBalance.subtract(testPrice);
        purchaseTest.addToBalance(testBalance);
        BigDecimal actualBalance = purchaseTest.calculateChange(testPrice, false);

        assertEquals(expectedBalance, actualBalance);

        purchaseTest = new Purchase();
        testBalance = new BigDecimal("5.25");
        testPrice = new BigDecimal("2.25");
        expectedBalance = testBalance.subtract(testPrice);
        purchaseTest.addToBalance(testBalance);
        actualBalance = purchaseTest.calculateChange(testPrice, false);

        assertEquals(expectedBalance, actualBalance);

        purchaseTest = new Purchase();
        testBalance = new BigDecimal("5.25");
        testPrice = new BigDecimal("2.25");
        expectedBalance = testBalance.subtract(testPrice);
        purchaseTest.addToBalance(testBalance);
        actualBalance = purchaseTest.calculateChange(testPrice, false);

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void calculateChangeNovember(){
        Purchase purchaseTest = new Purchase();
        BigDecimal testChange = new BigDecimal("5");
        BigDecimal testPrice = new BigDecimal("2.50");
        BigDecimal expectedBalance = new BigDecimal("2.50");

        purchaseTest.addToBalance(testChange);
        BigDecimal actualBalance = purchaseTest.calculateChange(testPrice, true);

        assertEquals(expectedBalance, actualBalance);


    }
    //test for is bogodo




}
