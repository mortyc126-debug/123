package org.apache.commons.net.smtp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleSMTPHeader {
    private StringBuffer cc;
    private final String from;
    private boolean hasHeaderDate;
    private final StringBuffer headerFields;
    private final String subject;
    private final String to;

    public SimpleSMTPHeader(String from, String to, String subject) {
        if (from == null) {
            throw new IllegalArgumentException("From cannot be null");
        }
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.headerFields = new StringBuffer();
        this.cc = null;
    }

    public void addCC(String address) {
        if (this.cc == null) {
            this.cc = new StringBuffer();
        } else {
            this.cc.append(", ");
        }
        this.cc.append(address);
    }

    public void addHeaderField(String headerField, String value) {
        if (!this.hasHeaderDate && "Date".equals(headerField)) {
            this.hasHeaderDate = true;
        }
        this.headerFields.append(headerField);
        this.headerFields.append(": ");
        this.headerFields.append(value);
        this.headerFields.append('\n');
    }

    public String toString() {
        StringBuilder header = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        if (!this.hasHeaderDate) {
            addHeaderField("Date", format.format(new Date()));
        }
        if (this.headerFields.length() > 0) {
            header.append(this.headerFields.toString());
        }
        header.append("From: ").append(this.from).append("\n");
        if (this.to != null) {
            header.append("To: ").append(this.to).append("\n");
        }
        if (this.cc != null) {
            header.append("Cc: ").append(this.cc.toString()).append("\n");
        }
        if (this.subject != null) {
            header.append("Subject: ").append(this.subject).append("\n");
        }
        header.append('\n');
        return header.toString();
    }
}
