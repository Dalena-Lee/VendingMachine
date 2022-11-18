package com.techelevator;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stock {
    private File stockFile;
    private List<String> displayItem = new ArrayList<>();
    private List<Item> vendingItems = new ArrayList<>();
    private ItemManager itemManager;

    public void stockItems(){
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        this.stockFile = userInput.setStockFile();
        //Created a list of Item class objects and initializing itemManager with list.
        this.itemManager = new ItemManager(vendingItems);

        //Created a string to display each line and added it to a list.
        String displayItems = "";
        this.displayItem = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(stockFile)) {
            while (fileScanner.hasNextLine()) {
                String eachLine = fileScanner.nextLine();
                String[] vending = eachLine.split(",");

                //For each line in the file, the line gets split and a new item object is initialized.
                Item item = new Item(vending[0], vending[1], vending[2], vending[3]);

                //Appending the new string.
                displayItems = vending[0] + " " + vending[1] + " " + vending[2];
                displayItem.add(displayItems);

                //Added item into list of objects.
                vendingItems.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File getStockFile() {
        return stockFile;
    }

    public void setStockFile(File stockFile) {
        this.stockFile = stockFile;
    }

    public List<String> getDisplayItem() {
        return displayItem;
    }

    public void setDisplayItem(List<String> displayItem) {
        this.displayItem = displayItem;
    }

    public List<Item> getVendingItems() {
        return vendingItems;
    }

    public void setVendingItems(List<Item> vendingItems) {
        this.vendingItems = vendingItems;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}
