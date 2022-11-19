package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

//isBOGODOtest, return boolean (check if given date/year is on thanksgiving)

<<<<<<< HEAD
public class PurchaseTest extends TestCase {
@Test
    public void isBOGODO(){
    //Arrange
    PurchaseTest purchaseTest = new PurchaseTest();
    //LocalDate now = LocalDate.of(11, 24);
    int year = 2022;
    //boolean isT
=======

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
>>>>>>> 19ce070004ea77878da2885ab5093d1611562899










}