package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine 
{
    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        while(true){
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display")) {
                // display the vending machine slots
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
