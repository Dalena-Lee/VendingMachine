package com.techelevator.application;

import com.techelevator.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachine {

    public VendingMachine() {
    }

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        Stock stock = new Stock();
        stock.stockItems();
        ItemManager itemManager = stock.getItemManager();

        File auditFile = userInput.setAuditFile();
        Audit audit = new Audit();

        while(true){
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display")) {
                // display the vending machine slots
                for (String s: stock.getDisplayItem()){
                    System.out.println(s);
                }
            }

            else if (choice.equals("purchase")) {
                Purchase purchase = new Purchase();

                Innerloop:
                while(true) {
                    String purchaseChoice = userInput.getPurchaseOption();
                    if (purchaseChoice.equals("insert")) {
                        BigDecimal inserted = userInput.getMoneyProvided();
                        //set current balance to the money provided
                        purchase.updateCurrentBalance(inserted);

                        //Record to audit.txt
                        BigDecimal currentBalance = purchase.getCurrentBalance();
                        String insertMessage = "Money inserted: ";
                        String currentTime = audit.getCurrentTime();
                        audit.recordToAudit(currentTime, insertMessage, inserted, currentBalance);
                    }

                    else if (purchaseChoice.equals("select")) {
                        //Prompt user to select an item using the item key.
                        String selectedItem = userInput.getSelectedItem();

                        //Iterate through the list of Item objects and select the item using input key.
                        for (Item i : itemManager.getItems()) {
                            String key = i.getItemKey();
                            if (key.equals(selectedItem)) {
                                if (itemManager.isInStock(i)) {
                                    // record to audit
                                    BigDecimal currentBalance = purchase.getCurrentBalance();
                                    BigDecimal balanceAfterPurchase = purchase.calculateChange(i.getPurchasePrice());
                                    String itemAudit = i.getItemName();
                                    String currentTime = audit.getCurrentTime();
                                    audit.recordToAudit(currentTime, itemAudit, key, currentBalance, balanceAfterPurchase);

                                    //update currentBalance
                                    purchase.countNumberOfItems();
                                    purchase.updateCurrentBalance(balanceAfterPurchase);
                                    i.decreaseStock();
                                }

                                else {
                                    System.out.println("Sorry, item is out of stock!");
                                }
                            }
                        }
                    }

                    else if (purchaseChoice.equals("finish")) {
                        BigDecimal balanceBeforeChange = purchase.getCurrentBalance();
                        List<String> changeList = purchase.receiveChange();
                        for (String s: changeList) {
                            System.out.println(s);
                        }
                        //Update balance

                        //Record to audit.txt.
                        BigDecimal balanceAfterChange = purchase.getCurrentBalance();
                        String changeMessage = "CHANGE GIVEN: ";
                        String currentTime = audit.getCurrentTime();
                        audit.recordToAudit(currentTime, changeMessage, balanceBeforeChange, balanceAfterChange);
                        audit.addAuditString("");
                        break Innerloop;
                    }

                    System.out.println();
                    System.out.println("Remaining Balance: $" + purchase.getCurrentBalance());
                    System.out.println();

                }
            }
            else if(choice.equals("exit")) {
                audit.printToFile(auditFile);
                //good bye
                break;
            }
        }
    }
    
}
