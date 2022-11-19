package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Purchase {

    private BigDecimal currentBalance;

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

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void addToBalance(BigDecimal deposit) {
        currentBalance = currentBalance.add(deposit);
    }

    public void countNumberOfItems(){
        numberOfItems++;
    }

    public BigDecimal calculateChange(BigDecimal purchasePrice) {
        if (isBOGODO()) {
            if (numberOfItems % 2 == 0) {
                purchasePrice = purchasePrice.subtract(BigDecimal.ONE);
            }
        }
        currentBalance = currentBalance.subtract(purchasePrice);
        return currentBalance;
    }

    public boolean isBOGODO(){
        LocalDate now = LocalDate.now();

        if (now.getMonth().equals(Month.NOVEMBER)) {
            return true;
        }
        return false;
    }


    public List<String> receiveChange(){

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
    }
