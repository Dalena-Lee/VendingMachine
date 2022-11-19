package com.techelevator;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Purchase {
<<<<<<< HEAD
=======

    private BigDecimal purchasePrice;
<<<<<<< HEAD

=======
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
>>>>>>> 5463aeb7ce2a3621f80a9316b0613c9582ad29ec
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

<<<<<<< HEAD
    public void countNumberOfItems() {
=======
<<<<<<< HEAD

=======
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
    public void countNumberOfItems(){
>>>>>>> 5463aeb7ce2a3621f80a9316b0613c9582ad29ec
        numberOfItems++;
    }

<<<<<<< HEAD

    public BigDecimal calculateChange(BigDecimal purchasePrice){
        BigDecimal currentBalance -= purchasePrice;

=======
    public BigDecimal calculateChange(BigDecimal purchasePrice) {
        BigDecimal currentBalance = getCurrentBalance();
        currentBalance = currentBalance.subtract(purchasePrice);
<<<<<<< HEAD
=======
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
        // if bogodo is true, buy one, get second off for a dollar, resets after bogodo price
        //increment by 2, i <
>>>>>>> 5463aeb7ce2a3621f80a9316b0613c9582ad29ec

        if (isBOGODO()) {
            if (numberOfItems % 2 == 0) {
                purchasePrice = purchasePrice.subtract(BigDecimal.valueOf(1.00));
                currentBalance = currentBalance.subtract(purchasePrice);
            }
        } else {
            currentBalance = currentBalance.subtract(purchasePrice);
        }
<<<<<<< HEAD
        return currentBalance;
    }

    public boolean isBOGODO() {
=======
<<<<<<< HEAD
=======
    }

>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77


    public boolean isBOGODO(){
     // get date of first nov of current year
        // if 11/1 is thurs, add three weeks
        // if not, find first thursday and then add three weeks
        // if current day is thanksgiving , then return true bogodo
>>>>>>> 5463aeb7ce2a3621f80a9316b0613c9582ad29ec
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

<<<<<<< HEAD
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
=======
<<<<<<< HEAD

    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time

=======
    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time
    int purchasesUntilBOGODO;
>>>>>>> 5463aeb7ce2a3621f80a9316b0613c9582ad29ec
}
>>>>>>> 5f107f2361184ac8d19d531683c9987781327e77
