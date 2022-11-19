package com.techelevator;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Purchase {
    private BigDecimal currentBalance;
    private int numberOfItems;

    private BigDecimal nickels = new BigDecimal(0.05);
    private BigDecimal dimes = new BigDecimal(0.10);
    private BigDecimal quarters = new BigDecimal(0.25);
    private BigDecimal oneDollarBill = new BigDecimal(1.00);
    private BigDecimal fiveDollarBill = new BigDecimal(5.00);
    private BigDecimal tenDollarBill = new BigDecimal(10.00);
    private BigDecimal twentyDollarBill = new BigDecimal(20.00);

    public Purchase() {
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void countNumberOfItems() {
        numberOfItems++;
    }

    public BigDecimal calculateChange(BigDecimal purchasePrice) {
        BigDecimal currentBalance = getCurrentBalance();
        currentBalance = currentBalance.subtract(purchasePrice);

        if (isBOGODO()) {
            if (numberOfItems % 2 == 0) {
                purchasePrice = purchasePrice.subtract(BigDecimal.valueOf(1.00));
                currentBalance = currentBalance.subtract(purchasePrice);
            }
        } else {
            currentBalance = currentBalance.subtract(purchasePrice);
        }
        return currentBalance;
    }

    public boolean isBOGODO() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        LocalDate firstNov = LocalDate.of(year, 11, 1);

        if (firstNov.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            int dayOfThanks = firstNov.plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);

            if (now.equals(thanksgiving)) {
                return true;
            }

        } else {
            int dayOfThanks = firstNov.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
            return true;
        }
        return false;
    }

    public String receiveChange() {
        BigDecimal change = currentBalance;
        String changeGiven = "";

        //If change is greater than 1
        if (change.compareTo(BigDecimal.valueOf(1)) == 1) {
            while (change.compareTo(BigDecimal.valueOf(0)) == 0) {
                BigDecimal numOfDollars = change.divide(oneDollarBill);
                change = change.subtract(numOfDollars);
                changeGiven += numOfDollars + " One Dollar Bills ";
                BigDecimal numOfQuarters = change.divide(quarters);
                change = change.subtract(numOfQuarters);
                changeGiven += numOfQuarters + " Quarters ";
                BigDecimal numOfDimes = change.divide(dimes);
                change = change.subtract(numOfDimes);
                changeGiven += numOfDimes + " Dimes ";
                BigDecimal numOfNickels = change.divide(nickels);
                change = change.subtract(numOfNickels);
                changeGiven += numOfNickels + " Nickels ";
            }
        }

        //If change is equal to 1
        else if (change.compareTo(BigDecimal.valueOf(1)) == 0) {

        }
        //If change is less than 1
        else {

        }
        return changeGiven;
    }
}
