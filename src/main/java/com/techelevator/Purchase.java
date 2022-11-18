package com.techelevator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
    private BigDecimal purchasePrice;
    private BigDecimal currentBalance;
    private String selectedItem;

    private BigDecimal nickels;
    private BigDecimal dimes;
    private BigDecimal quarters;

    private int oneDollarBill;
    private int fiveDollarBill;
    private int tenDollarBill;
    private int twentyDollarBill;

    public Purchase() {
    }

    //getters and setters
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal calculateChange(){
        currentBalance -= purchasePrice;
        // if bogodo is true, buy one, get second off for a dollar, resets after bogodo price
        return currentBalance;
    }

    public Boolean isBOGODO(){
     // get date of first nov of current year
        // if 11/1 is thurs, add three weeks
        // if not, find first thursday and then add three weeks
        // if current day is thanksgiving , then return true bogodo
        LocalDate firstNov;
        if (fir){

     }
    }
    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time
    int purchasesUntilBOGODO;
}
