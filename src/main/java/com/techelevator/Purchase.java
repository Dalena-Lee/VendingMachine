package com.techelevator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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


    //getters and setters
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }


    public static BigDecimal calculateChange(BigDecimal purchasePrice, String selectedItem,  ){

    }

    //boolean isBOGODO();
    public static Boolean isBOGODO(){

        public class CurrentDateTimeExample2 {
            public static void main(String[] args) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                System.out.println(formatter.format(date));
            }
        }
    }
    //getCurrentBalance(); //purchasePrice, selectedItem,
    //boolean isThanksgiving; get local date and time
    int purchasesUntilBOGODO;
}
