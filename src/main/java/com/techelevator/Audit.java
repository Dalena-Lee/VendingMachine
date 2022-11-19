package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Audit {
    LocalDateTime currentTime;
    List<String> auditStrings = new ArrayList<>();
    NumberFormat formatter;

    public Audit() {
    }

    //This audit method records the action taken instead of the item that's purchase.
    public void recordToAudit(String currentTime, String message, BigDecimal inserted, BigDecimal currentBalance){
        String format = formatAuditString(currentTime, message, inserted, currentBalance);
        addAuditString(format);
    }

    //This audit method records when a purchase is made.
    public void recordToAudit(String currentTime, String itemAudit, String key, BigDecimal currentBalance, BigDecimal balanceAfterPurchase){
        String format = formatAuditString(currentTime, itemAudit, key, currentBalance, balanceAfterPurchase);
        addAuditString(format);
    }

    public void addAuditString(String audit){
        auditStrings.add(audit);
    }

    public String formatAuditString(String currentTime, String itemAudit, String key, BigDecimal currentBalance, BigDecimal balanceAfterPurchase){
        formatter = NumberFormat.getCurrencyInstance();
        String formatCurrentBalance = formatter.format(currentBalance);
        String formatBalanceAfterPurchase = formatter.format(balanceAfterPurchase);
        String audit = String.format("%-22s %-15s %-2s %-7s %-7s", currentTime, itemAudit, key, formatCurrentBalance, formatBalanceAfterPurchase);
        return audit;
    }

    public String formatAuditString(String currentTime, String message, BigDecimal balanceBeforeChange, BigDecimal balanceAfterChange){
        formatter = NumberFormat.getCurrencyInstance();
        String formatCurrentBalance = formatter.format(balanceBeforeChange);
        String formatBalance = formatter.format(balanceAfterChange);
        String audit = String.format("%-22s %-18s %-7s %-7s", currentTime, message, formatCurrentBalance, formatBalance);
        return audit;
    }

    public void printToFile(File auditFile){
        try (PrintWriter fileWriter = new PrintWriter(auditFile)) {
            for (String s: auditStrings){
                fileWriter.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentTime() {
        currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String date = currentTime.format(formatter);
        return date;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
