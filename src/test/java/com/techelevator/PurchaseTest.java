package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

//isBOGODOtest, return boolean (check if given date/year is on thanksgiving)


public class PurchaseTest {
    @Test
    public void testInitialMoney(){
        Purchase purchaseTest = new Purchase();
        BigDecimal expectedBalance = BigDecimal.ZERO;
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        Assert.assertTrue(expectedBalance.compareTo(actualBalance)== 0);


    }
    @Test
    public void testMoneyAdd(){
        Purchase purchaseTest = new Purchase();
        BigDecimal depositAmount = new BigDecimal("30");
        purchaseTest.addMoney(depositAmount);
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        Assert.assertTrue(depositAmount.compareTo(actualBalance)==0 );

    }
    @Test
    public void notEnoughMoneyAdd(){
        Purchase purchaseTest = new Purchase();
        BigDecimal depositAmount = new BigDecimal("1");
        purchaseTest.addMoney(depositAmount);
        BigDecimal actualBalance = purchaseTest.getCurrentBalance();
        Assert.assertTrue(depositAmount.compareTo(actualBalance)==-1 );

    }













}






}