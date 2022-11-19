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

        while (!option.equals("M") && !option.equals("S") && !option.equals("F")) {
            try {
                if (!option.equals("M") && !option.equals("S") && !option.equals("F")) {
                    throw new IllegalArgumentException("Please enter M, S, or F as your choice.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {

                System.out.print("Select an option: ");
                selectedOption = scanner.nextLine();
                option = selectedOption.trim().toUpperCase();
            }
        }

        if (option.equalsIgnoreCase("M")) {
            return "insert";
        } else if (option.equalsIgnoreCase("S")) {
            return "select";
        } else if (option.equalsIgnoreCase("F")) {
            return "finish";
        }
        return "";
    }

    public BigDecimal getMoneyProvided() {

        System.out.println("Please insert $1, $5, $10, or $20.");
        System.out.print("Insert: $");
        String insert = scanner.nextLine();
        while (!insert.equals("1") && !insert.equals("5") && !insert.equals("10") && !insert.equals("20")) {
            try {
                if (!insert.equals("1") && !insert.equals("5") && !insert.equals("10") && !insert.equals("20")) {
                    throw new IllegalArgumentException("Please insert $1, $5, $10, or $20");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.print("Insert acceptable bills: ");
                insert = scanner.nextLine();
                insert = insert.trim().toUpperCase();
            }
        }
        double n = Double.parseDouble(insert);
        BigDecimal inserted = new BigDecimal(n);

        if (inserted.equals(1)) {
            return BigDecimal.valueOf(1);
        } else if (inserted.equals(5)) {
            return BigDecimal.valueOf(5);
        } else if (inserted.equals(10)) {
            return BigDecimal.valueOf(10);
        } else if (inserted.equals(20)) {
            return BigDecimal.valueOf(20);
        }
         return BigDecimal.ZERO;

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
