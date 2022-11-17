package com.techelevator.ui;

import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {
    //This outputs all messages that are printed, so when the balance updates, we call the method userOutput.somemethod()
    //- All munchy items print "Munchy, Munchy, so Good!" => displayMunchyPurchase(String)
    //- All candy items print  "Sugar, Sugar, so Sweet!" => displayCandyPurchase()
    //- All drink items print  "Drinky, Drinky, Slurp Slurp!" => displayDrinkPurchase()
    //- All gum items print    "Chewy, Chewy, Lots O Bubbles!" = displayGumPurchase()
    //displayCurrentBalance()
    //displayChange()

    public void displayMessage(String message){
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

}
