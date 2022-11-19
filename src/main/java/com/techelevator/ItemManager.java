package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private Item item;
    private List<Item> items = new ArrayList<>();

    //
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

    public void addItem(Item item){
        items.add(item);
    }

    public void decreaseStock(String itemKey){
        for (Item eachItem: items)
            //getting itemkey from user, compare to itemlist we have, then decrease stock
            if (itemKey.equals(eachItem.getItemKey())){
                eachItem.decreaseStock();
            }
    }

    public List<Item> getItems() {
        return items;
    }
}
