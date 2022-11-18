package com.techelevator;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Purchase {

    private BigDecimal currentBalance;

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

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal calculateChange(BigDecimal purchasePrice){
        currentBalance -= purchasePrice;
        // if bogodo is true, buy one, get second off for a dollar, resets after bogodo price
        return currentBalance;
    }

    public boolean isBOGODO(){
     // get date of first nov of current year
        // if 11/1 is thurs, add three weeks
        // if not, find first thursday and then add three weeks
        // if current day is thanksgiving , then return true bogodo
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        //gives first of nov of current year
        LocalDate firstNov = LocalDate.of(year, 11, 1);
        int dayOfThanks = 0;

        // if first day of nov is thursday:
        if (firstNov.getDayOfWeek().equals(DayOfWeek.THURSDAY)){

            //setting thanksgiving day
             dayOfThanks = firstNov.plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
                if (now.equals(thanksgiving)){
                    return true;
                } else {
                    return false;
                }

                //first day of nov isn't thurs
        } else {
           dayOfThanks = firstNov.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).getDayOfMonth();
           //setting day of thanks
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
            return true;
        }
    }


}
