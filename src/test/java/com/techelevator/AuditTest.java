package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuditTest {

    private final String AUDIT_FILE_PATH = "src/test/resources/Audit.txt";
    private File auditFile = new File(AUDIT_FILE_PATH);

    @Before
    public void setUp() throws Exception {
        System.setIn(new ByteArrayInputStream(AUDIT_FILE_PATH.getBytes()));
    }

    @Test
    public void recordToAudit(){
        //Testing list of audit strings to be printed.
        List<String> testAuditList = new ArrayList<>();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String testTime = "11/19/2022 08:16:53 PM";
        String testMessage = "Money inserted: ";
        String testFormatedMoney = formatter.format(10);

        //Testing overloaded method without item key variable.
        String expectedString = String.format("%-22s %-18s %-7s %-7s", testTime, testMessage, testFormatedMoney, testFormatedMoney);
        testAuditList.add(expectedString);

        Audit audit = new Audit();
        audit.recordToAudit(testTime,testMessage, BigDecimal.valueOf(10),BigDecimal.valueOf(10));
        assertTrue(audit.auditStrings.equals(testAuditList));

        testAuditList.clear();
        testTime = "11/19/2022 08:16:53 PM";
        testMessage = "Money inserted: ";
        String testItemKey = "A1";
        testFormatedMoney = formatter.format(10);
        String testFormatedMoneyAfterPurchase = formatter.format(5.25);

        //Testing overloaded method with item key variable.
        expectedString = String.format("%-22s %-15s %-2s %-7s %-7s", testTime, testMessage, testItemKey, testFormatedMoney, testFormatedMoneyAfterPurchase);
        testAuditList.add(expectedString);

        audit.auditStrings.clear();
        audit.recordToAudit(testTime,testMessage, testItemKey, BigDecimal.valueOf(10),BigDecimal.valueOf(5.25));
        assertTrue(audit.auditStrings.equals(testAuditList));
    }

    @Test
    public void printToFile() throws IOException {
        Audit audit = new Audit();
        String auditContent = "";
        audit.printToFile(auditFile);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String a = "Test string 1.";
        String b = "Test string 2.";

        try (PrintWriter fileWriter = new PrintWriter(auditFile)) {
            fileWriter.println(a);
            fileWriter.println(b);
        }

        if(auditFile.exists()) {
            auditContent = Files.readString(auditFile.toPath());
        }

        String[] result = {a, b};
        String auditFileExpect = String.join(System.lineSeparator(), result);

        assertEquals(auditFileExpect, auditContent.trim());
    }

    @Test
    public void getCurrentTime() {
        Audit audit = new Audit();
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String expectedDateTime = currentTime.format(formatter);
        String actualDateTime = audit.getCurrentTime();

        assertEquals("Expected: " + expectedDateTime + "\n" + "Actual: " + actualDateTime,expectedDateTime, actualDateTime);
    }
}