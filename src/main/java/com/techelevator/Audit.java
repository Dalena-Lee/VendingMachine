package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Audit {
    LocalDateTime currentTime;
    List<String> auditStrings = new ArrayList<>();

    public Audit() {
    }

    public void recordToAudit(String currentTime, String message, BigDecimal inserted, BigDecimal currentBalance){
        String format = formatAuditString(currentTime, message, inserted, currentBalance);
        addAuditString(format);
    }

    public void recordToAudit(String currentTime, String itemAudit, String key, BigDecimal currentBalance, BigDecimal balanceAfterPurchase){
        String format = formatAuditString(currentTime, itemAudit, key, currentBalance, balanceAfterPurchase);
        addAuditString(format);
    }

    public void recordToAudit(String currentTime, String message, BigDecimal currentBalance, String balance){
        String format = formatAuditString(currentTime, message, currentBalance, balance);
        addAuditString(format);
    }

    public void addAuditString(String audit){
        auditStrings.add(audit);
    }

    public String formatAuditString(String currentTime, String message, BigDecimal inserted, BigDecimal currentBalance){
        String audit = String.format("%-22s %-18s $%-7s $%-7s", currentTime, message, inserted, currentBalance);
        return audit;
    }

    public String formatAuditString(String currentTime, String itemAudit, String key, BigDecimal currentBalance, BigDecimal balanceAfterPurchase){
        String audit = String.format("%-22s %-15s %-2s $%-7s $%-7s", currentTime, itemAudit, key, currentBalance, balanceAfterPurchase);
        return audit;
    }

    public String formatAuditString(String currentTime, String message, BigDecimal currentBalance, String balance){
        String audit = String.format("%-22s %-18s $%-7s $%-7s", currentTime, message, currentBalance, balance);
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
