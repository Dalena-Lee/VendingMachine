package com.techelevator;

import java.math.BigDecimal;

public class Item {
    private int stockCount = 6;
    private BigDecimal purchasePrice;
    private String itemName;
    private String type;
    private String itemKey;

    public Item(String itemkey, String itemName, String purchasePrice, String type) {
        this.itemKey = itemkey;
        this.itemName = itemName;
        //Might need to convert purchaseprice into bigdecimal using valueof.
        this.purchasePrice = new BigDecimal(purchasePrice);
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void decreaseStock() {
        stockCount--;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
