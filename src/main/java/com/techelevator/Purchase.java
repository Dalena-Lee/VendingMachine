package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Purchase {

    private BigDecimal purchasePrice;

<<<<<<< HEAD
    private BigDecimal currentBalance = BigDecimal.valueOf(0);
=======
    private BigDecimal currentBalance;
>>>>>>> 19ce070004ea77878da2885ab5093d1611562899
    private int numberOfItems;

    BigDecimal nickels = BigDecimal.valueOf(0.05);
    BigDecimal dimes = BigDecimal.valueOf(0.10);
    BigDecimal quarters = BigDecimal.valueOf(0.25);
    BigDecimal oneDollarBill = BigDecimal.valueOf(1.00);
    BigDecimal fiveDollarBill = BigDecimal.valueOf(5.00);
    BigDecimal tenDollarBill = BigDecimal.valueOf(10.00);
    BigDecimal twentyDollarBill = BigDecimal.valueOf(20.00);

    public Purchase() {
        currentBalance = BigDecimal.ZERO;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

<<<<<<< HEAD
    public void updateCurrentBalance(BigDecimal balanceToAdd) {
        this.currentBalance.add(balanceToAdd);
    }

    public void countNumberOfItems(){
        numberOfItems++;
    }

    public BigDecimal calculateChange(BigDecimal purchasePrice) {
        BigDecimal currentBalance = getCurrentBalance();
        currentBalance = currentBalance.subtract(purchasePrice);
=======
    public void addMoney(BigDecimal depositAmount){
        currentBalance = currentBalance.add(depositAmount);
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

        // if bogodo is true, buy one, get second off for a dollar, resets after bogodo price
        //increment by 2, i <

>>>>>>> 19ce070004ea77878da2885ab5093d1611562899

        if (isBOGODO()) {
            if (numberOfItems % 2 == 0) {

                purchasePrice = purchasePrice.subtract(BigDecimal.ONE);
            }
        }
<<<<<<< HEAD

        return currentBalance;
    }

    public boolean isBOGODO(){
=======
            currentBalance =currentBalance.subtract(purchasePrice);
      return currentBalance;



    }


    public boolean isBOGODO(){
     // get date of first nov of current year
        // if 11/1 is thurs, add three weeks
        // if not, find first thursday and then add three weeks
        // if current day is thanksgiving , then return true bogodo

>>>>>>> 19ce070004ea77878da2885ab5093d1611562899
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        LocalDate firstNov = LocalDate.of(year, 11, 1);

        if (firstNov.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            int dayOfThanks = firstNov.plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);

            if (now.equals(thanksgiving)) {
                return true;
            }
        }

        else {
            int dayOfThanks = firstNov.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).getDayOfMonth();
            LocalDate thanksgiving = LocalDate.of(year, 11, dayOfThanks);
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public List<String> receiveChange() {
=======

    public String receiveChange() {
>>>>>>> 19ce070004ea77878da2885ab5093d1611562899
        BigDecimal change = currentBalance;
        List<String> changeList = new ArrayList<>();

        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdFormat.setMinimumFractionDigits(2);
        usdFormat.setMaximumFractionDigits(2);

        changeList.add("Thank you for your purchase!");
        changeList.add("Change dispensed: ");

        BigDecimal tenDollarNext = change.divideToIntegralValue(tenDollarBill);
            if (tenDollarNext.intValue() != 0) {
                changeList.add(tenDollarNext.intValue() + " Ten Dollar Bills");
            }

        BigDecimal fiveDollarNext = change.subtract(tenDollarBill.multiply(tenDollarNext));
        BigDecimal i = fiveDollarNext.divide(fiveDollarBill);

            if (i.intValue() != 0) {
                changeList.add(i.intValue() + " Five Dollar Bills");
            }

<<<<<<< HEAD
        BigDecimal oneDollarNext = fiveDollarNext.subtract(fiveDollarBill.multiply(BigDecimal.valueOf(i.intValue())));
        BigDecimal f = oneDollarNext.divide(oneDollarBill);
            if (f.intValue() != 0) {
                changeList.add(f.intValue() + " One Dollar Bills");
            }

        BigDecimal quarterNext = oneDollarNext.subtract(oneDollarBill.multiply(BigDecimal.valueOf(f.intValue())));
        BigDecimal q = quarterNext.divide(quarters);
            if (q.intValue() != 0) {
                changeList.add(q.intValue() + " Quarters");
            }

        BigDecimal dimeNext = quarterNext.subtract(quarters.multiply(BigDecimal.valueOf(q.intValue())));
        BigDecimal d = dimeNext.divide(dimes);
            if (d.intValue() != 0) {
                changeList.add(d.intValue() + " Dimes");
            }

        BigDecimal nickelNext = dimeNext.subtract(dimes.multiply(BigDecimal.valueOf(d.intValue())));
        BigDecimal n = nickelNext.divide(nickels);
            if (n.intValue() != 0) {
                changeList.add(n.intValue() + " Nickels");
            }

            currentBalance = BigDecimal.valueOf(0);
            return changeList;

        }
=======
        }
        return changeGiven;
    }
>>>>>>> 19ce070004ea77878da2885ab5093d1611562899

}
