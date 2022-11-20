package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private BigDecimal currentBalance;
    private int numberOfItems;

    BigDecimal nickels = BigDecimal.valueOf(0.05);
    BigDecimal dimes = BigDecimal.valueOf(0.10);
    BigDecimal quarters = BigDecimal.valueOf(0.25);
    BigDecimal oneDollarBill = BigDecimal.valueOf(1.00);
    BigDecimal fiveDollarBill = BigDecimal.valueOf(5.00);
    BigDecimal tenDollarBill = BigDecimal.valueOf(10.00);

    public Purchase() {
        currentBalance = BigDecimal.ZERO;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public String addToBalance(BigDecimal deposit) {
        BigDecimal newValue = currentBalance.add(deposit);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String message = "";

        //Limit the amount inserted to $20.
        if (newValue.compareTo(BigDecimal.valueOf(20)) == 1){
            message = "Unable to accept amounts greater than $20.00";
        }
        else {
            currentBalance = currentBalance.add(deposit);
            message = formatter.format(currentBalance) + " was inserted.";
        }
        return message;
    }

    public void increaseNumberOfItems(){
        numberOfItems++;
    }

    public BigDecimal calculateChange(BigDecimal purchasePrice, boolean isNovember) {
        if (isNovember) {
            if (getNumberOfItems() % 2 == 0) {
                purchasePrice = purchasePrice.subtract(BigDecimal.valueOf(1.00));
            }
        }
        currentBalance = currentBalance.subtract(purchasePrice);
        return currentBalance;
    }

    public List<String> receiveChange(){

        BigDecimal change = currentBalance;
        List<String> changeList = new ArrayList<>();

        changeList.add("Thank you for your purchase!");
        changeList.add("Change dispensed: ");

        BigDecimal tenDollarNext = change.divideToIntegralValue(tenDollarBill);
            if (tenDollarNext.intValue() != 0) {
                if (tenDollarNext.intValue() == 1) {
                    changeList.add(tenDollarNext.intValue() + " Ten Dollar Bill");
                }
                else if (tenDollarNext.intValue() > 1) {
                    changeList.add(tenDollarNext.intValue() + " Ten Dollar Bills");
                }
            }

        BigDecimal fiveDollarNext = change.subtract(tenDollarBill.multiply(tenDollarNext));
        BigDecimal i = fiveDollarNext.divide(fiveDollarBill);

            if (i.intValue() != 0) {
                if (i.intValue() == 1) {
                    changeList.add(i.intValue() + " Five Dollar Bill");
                }
                else if (i.intValue() > 1) {
                    changeList.add(i.intValue() + " Five Dollar Bills");
                }
            }

        BigDecimal oneDollarNext = fiveDollarNext.subtract(fiveDollarBill.multiply(BigDecimal.valueOf(i.intValue())));
        BigDecimal f = oneDollarNext.divide(oneDollarBill);
            if (f.intValue() != 0) {
                if (f.intValue() == 1) {
                    changeList.add(f.intValue() + " One Dollar Bill");
                }
                else if (f.intValue() > 1) {
                    changeList.add(f.intValue() + " One Dollar Bills");
                }
            }

        BigDecimal quarterNext = oneDollarNext.subtract(oneDollarBill.multiply(BigDecimal.valueOf(f.intValue())));
        BigDecimal q = quarterNext.divide(quarters);
            if (q.intValue() != 0) {
                if (q.intValue() == 1) {
                    changeList.add(q.intValue() + " Quarter");
                }
                else if (q.intValue() > 1) {
                    changeList.add(q.intValue() + " Quarters");
                }
            }

        BigDecimal dimeNext = quarterNext.subtract(quarters.multiply(BigDecimal.valueOf(q.intValue())));
        BigDecimal d = dimeNext.divide(dimes);
            if (d.intValue() != 0) {
                if (d.intValue() == 1) {
                    changeList.add(d.intValue() + " Dime");
                }
                else if (d.intValue() > 1) {
                    changeList.add(d.intValue() + " Dimes");
                }
            }

        BigDecimal nickelNext = dimeNext.subtract(dimes.multiply(BigDecimal.valueOf(d.intValue())));
        BigDecimal n = nickelNext.divide(nickels);
            if (n.intValue() != 0) {
                if (n.intValue() == 1) {
                    changeList.add(n.intValue() + " Nickel");
                }
                else if (n.intValue() > 1) {
                    changeList.add(n.intValue() + " Nickels");
                }
            }

            currentBalance = BigDecimal.valueOf(0);
            return changeList;
        }
    }
