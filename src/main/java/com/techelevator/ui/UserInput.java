package com.techelevator.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
        System.out.println();

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        while (!option.equals("D") && !option.equals("P") && !option.equals("E")) {
            try {
                if (!option.equals("D") && !option.equals("P") && !option.equals("E")) {
                    throw new IllegalArgumentException("Please enter D, P, or E as your choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.print("Select an option: ");
                selectedOption = scanner.nextLine();
                option = selectedOption.trim().toUpperCase();
            }
        }

        if (option.equalsIgnoreCase("D")) {
            return "display";
        } else if (option.equalsIgnoreCase("P")) {
            return "purchase";
        } else if (option.equalsIgnoreCase("E")) {
            return "exit";
        }
        return "";
    }

    public String getPurchaseOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Insert Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "insert";
        } else if (option.equals("S")) {

            return "select";
        } else if (option.equals("F")) {
            return "finish";
        } else {
            return "";
        }
    }

    public BigDecimal getMoneyProvided() {
        //Create a while loop with a try catch statement that catches if the user inputs anything other than 1, 5, 10, or 20.
        System.out.println("Please insert $1, $5, $10, or $20.");
        System.out.print("Insert: $");
        String insert = scanner.nextLine();
        double n = Double.parseDouble(insert);
        BigDecimal inserted = new BigDecimal(n);
        return inserted;
    }

    public String getSelectedItem() {
        System.out.print("Enter the key of your selected item: ");
        String select = scanner.nextLine();
        return select;
    }

    public File setStockFile() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a path to input file: ");
        System.out.print("Path: ");
        String path = userInput.nextLine();
        File stockFile = new File(path);

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
        return stockFile;
    }

    public File setAuditFile() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a path to audit file: ");
        System.out.print("Path: ");
        String path = userInput.nextLine();
        File auditFile = new File(path);

        while (auditFile.exists() == false || auditFile.isFile() == false) {
            try {
                if (auditFile.exists() == false) {
                    throw new FileNotFoundException(path + " does not exist.");
                } else if (auditFile.isFile() == false) {
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
                auditFile = new File(path);
            }
        }
        return auditFile;
    }
}
