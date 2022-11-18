package com.techelevator;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Audit extends Purchase{
    String audit;
    File auditFile;
    LocalDateTime dateTime;

    public Audit(String audit) {
        this.audit = audit;
    }

    public void setAuditFile(File auditFile) {
        this.auditFile = auditFile;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
