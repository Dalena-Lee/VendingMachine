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
        this.purchasePrice = new BigDecimal(purchasePrice);
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }


    public String getItemKey() {
        return itemKey;
    }


    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

}
