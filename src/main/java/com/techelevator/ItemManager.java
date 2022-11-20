package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private Item item;
    private List<Item> items = new ArrayList<>();

    public ItemManager(List<Item> items) {
        this.items = items;
    }

    public boolean isInStock(Item currentItem){
        int stock = currentItem.getStockCount();

        if (stock == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void decreaseStock(String itemKey){
        for (Item selectedItem: items) {
            if (itemKey.equalsIgnoreCase(selectedItem.getItemKey())) {
                int currentStock = selectedItem.getStockCount();
                selectedItem.setStockCount(currentStock - 1);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
