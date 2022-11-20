package com.techelevator.ui;

import java.util.List;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    public void displayMessage(String type){

        if(type.equalsIgnoreCase("Spongebob")) {
            System.out.println("I'm ready, I'm ready, I'm ready \uD83E\uDD29!");
        }

        else if (type.equalsIgnoreCase("MonsterHighDolls")) {
            System.out.println("Being the only normie at Monster High is creepy cool!! \uD83D\uDE0E");
        }

        else if (type.equalsIgnoreCase("Andy'sToys")) {
            System.out.println("Please just keep me until you leave for college!! \uD83E\uDD72 !!");
        }

        else if (type.equalsIgnoreCase("TeddyBear")) {
            System.out.println("Don't leave me or I'll turn into Lotso \uD83D\uDC98 !!!");
        }
    }

    public void outOfStock(){
        System.out.println("Sorry, item is out of stock!");
    }

    public void displayHomeScreen(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayChange(List<String> changeList){
        List<String> display = changeList;
        for (String s: changeList) {
            System.out.println(s);
        }
    }

}
