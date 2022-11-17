package com.techelevator.application;

import com.techelevator.Item;
import com.techelevator.ItemManager;
import com.techelevator.Purchase;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    Purchase purchase;
    ItemManager itemManager;
    Item item;
    File stockFile;

    public VendingMachine() {
    }

    public void setStockFile(File stockFile) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a path to input file: ");
        System.out.print("Path: ");
        String path = userInput.nextLine();
        stockFile = new File(path);

        while (stockFile.exists() == false || stockFile.isFile() == false) {
            try {
                if (stockFile.exists() == false) {
                    throw new FileNotFoundException(path + " does not exist.");
                } else if (stockFile.isFile() == false) {
                    throw new IOException(path + " is not a file.");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Please enter path to a valid file.");
                System.out.print("Path: ");
                path = userInput.nextLine();
                stockFile = new File(path);
            }
        }
        this.stockFile = stockFile;
    }

    public File getStockFile() {
        return stockFile;
    }

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        setStockFile(stockFile);

        while(true){
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display")) {
                // display the vending machine slots
                try (Scanner fileScanner = new Scanner(stockFile)) {
                    while (fileScanner.hasNextLine()) {
                        String eachLine = fileScanner.nextLine();
                        String[] vending = eachLine.split(",");
                        String displayItems = "";

                        for (int i = 0; i < vending.length - 1; i++){

                            if (i == 2){
                                displayItems += "$" + vending[i];
                            }
                            else {
                                displayItems += vending[i];
                                displayItems += " ";
                            }
                        }
                        System.out.println(displayItems);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            else if(choice.equals("purchase")) {
                purchase = new purchase();
                // make a purchase
                String purchaseChoice = userInput.getPurchaseOption();

                if (purchaseChoice.equals("insert")){
                    System.out.println("Please insert $1, $5, $10, or $20.");
                }
                else if (purchaseChoice.equals("select")){

                }
                else if (purchaseChoice.equals("finish")){

                }
                //sout: "Please insert $1, $5, $10, or $20."
                //userinput = $5;
                //setCurrentBalance;
                //setAction();
                //userinput = $5;
                //setCurrentBalance += userinput;
                //setAction();
            }

            else if(choice.equals("exit")) {
                //good bye
                break;
            }
        }
    }
    
}
