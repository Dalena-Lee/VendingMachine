package com.techelevator.application;

import com.techelevator.Item;
import com.techelevator.ItemManager;
import com.techelevator.Purchase;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void run(){
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        while(true){
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display")) {
                // display the vending machine slots
                // everything that needs to be displayed is called, but
                // we can't display the vending items without referencing
                // the stockfile in this class.
                // like userInput.displayhomescreen is called there and it shows
                // call method from useroutput => userOutput.displayVendingItems();
            }

            else if(choice.equals("purchase")) {

                // make a purchase
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
