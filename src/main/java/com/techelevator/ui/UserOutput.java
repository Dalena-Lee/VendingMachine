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

        if(type.equalsIgnoreCase("munchy")) {
            System.out.println("Munchy, Munchy, so Good!");
        }

        else if (type.equalsIgnoreCase("candy")) {
            System.out.println("Sugar, Sugar, so Sweet!");
        }

        else if (type.equalsIgnoreCase("drink")) {
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        }

        else if (type.equalsIgnoreCase("gum")) {
            System.out.println("Chewy, Chewy, Lots O Bubbles!");
        }
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
