package com.techelevator;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Purchase {

    private BigDecimal purchasePrice;
<<<<<<< HEAD

=======
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
    private BigDecimal currentBalance;

    private BigDecimal nickels;
    private BigDecimal dimes;
    private BigDecimal quarters;

    private int numberOfItems;
    private int oneDollarBill;
    private int fiveDollarBill;
    private int tenDollarBill;
    private int twentyDollarBill;

    public Purchase() {
    }

    //getters and setters



    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

<<<<<<< HEAD

=======
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
    public void countNumberOfItems(){
        numberOfItems++;
    }

<<<<<<< HEAD

    public BigDecimal calculateChange(BigDecimal purchasePrice){
        BigDecimal currentBalance -= purchasePrice;

=======
    public BigDecimal calculateChange(BigDecimal purchasePrice) {
        BigDecimal currentBalance = getCurrentBalance();
        currentBalance = currentBalance.subtract(purchasePrice);
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
        // if bogodo is true, buy one, get second off for a dollar, resets after bogodo price
        //increment by 2, i <

        if (isBOGODO()) {
            if (numberOfItems % 2 == 0) {
                purchasePrice = purchasePrice - 1;
            }
        } else {

            currentBalance -= purchasePrice;
        }
<<<<<<< HEAD
=======
    }

>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77


    public boolean isBOGODO(){
     // get date of first nov of current year
        // if 11/1 is thurs, add three weeks
        // if not, find first thursday and then add three weeks
        // if current day is thanksgiving , then return true bogodo
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        //gives first of nov of current year
        LocalDate firstNov = LocalDate.of(year, 11, 1);

        // if first day of nov is thursday:
        if (firstNov.getDayOfWeek().equals(DayOfWeek.THURSDAY)){

            //setting thanksgiving day
             int dayOfThanks = firstNov.plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
                if (now.equals(thanksgiving)){
                    return true;
                } else {
                    return false;
                }

                //first day of nov isn't thurs
        } else {
           int dayOfThanks = firstNov.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).getDayOfMonth();
           //setting day of thanks
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
            return true;
        }
    }

<<<<<<< HEAD

    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time

=======
    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time
    int purchasesUntilBOGODO;
}
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
