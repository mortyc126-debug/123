package org.apache.commons.net.ntp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class TimeStamp implements Serializable, Comparable<TimeStamp> {
    public static final String NTP_DATE_FORMAT = "EEE, MMM dd yyyy HH:mm:ss.SSS";
    protected static final long msb0baseTime = 2085978496000L;
    protected static final long msb1baseTime = -2208988800000L;
    private static final long serialVersionUID = 8139806907588338737L;
    private final long ntpTime;
    private DateFormat simpleFormatter;
    private DateFormat utcFormatter;

    private static void appendHexString(StringBuilder buf, long l) {
        String s = Long.toHexString(l);
        for (int i = s.length(); i < 8; i++) {
            buf.append('0');
        }
        buf.append(s);
    }

    protected static long decodeNtpHexString(String hexString) throws NumberFormatException {
        if (hexString == null) {
            throw new NumberFormatException("null");
        }
        int ind = hexString.indexOf(46);
        if (ind == -1) {
            if (hexString.isEmpty()) {
                return 0L;
            }
            return Long.parseLong(hexString, 16) << 32;
        }
        return (Long.parseLong(hexString.substring(0, ind), 16) << 32) | Long.parseLong(hexString.substring(ind + 1), 16);
    }

    public static TimeStamp getCurrentTime() {
        return getNtpTime(System.currentTimeMillis());
    }

    public static TimeStamp getNtpTime(long dateMillis) {
        return new TimeStamp(toNtpTime(dateMillis));
    }

    public static long getTime(long ntpTimeValue) {
        long seconds = (ntpTimeValue >>> 32) & 4294967295L;
        long fraction = Math.round(((4294967295L & ntpTimeValue) * 1000.0d) / 4.294967296E9d);
        long msb = 2147483648L & seconds;
        if (msb == 0) {
            return (1000 * seconds) + msb0baseTime + fraction;
        }
        return (1000 * seconds) + msb1baseTime + fraction;
    }

    public static TimeStamp parseNtpString(String s) throws NumberFormatException {
        return new TimeStamp(decodeNtpHexString(s));
    }

    protected static long toNtpTime(long millis) {
        long baseTimeMillis;
        boolean useBase1 = millis < msb0baseTime;
        if (useBase1) {
            baseTimeMillis = millis - msb1baseTime;
        } else {
            baseTimeMillis = millis - msb0baseTime;
        }
        long seconds = baseTimeMillis / 1000;
        long fraction = ((baseTimeMillis % 1000) * 4294967296L) / 1000;
        if (useBase1) {
            seconds |= 2147483648L;
        }
        return (seconds << 32) | fraction;
    }

    public static String toString(long ntpTime) {
        StringBuilder buf = new StringBuilder();
        appendHexString(buf, (ntpTime >>> 32) & 4294967295L);
        buf.append('.');
        appendHexString(buf, ntpTime & 4294967295L);
        return buf.toString();
    }

    public TimeStamp(Date d) {
        this.ntpTime = d == null ? 0L : toNtpTime(d.getTime());
    }

    public TimeStamp(long ntpTime) {
        this.ntpTime = ntpTime;
    }

    public TimeStamp(String hexStamp) throws NumberFormatException {
        this.ntpTime = decodeNtpHexString(hexStamp);
    }

    @Override // java.lang.Comparable
    public int compareTo(TimeStamp anotherTimeStamp) {
        long thisVal = this.ntpTime;
        long anotherVal = anotherTimeStamp.ntpTime;
        return Long.compare(thisVal, anotherVal);
    }

    public boolean equals(Object obj) {
        return (obj instanceof TimeStamp) && this.ntpTime == ((TimeStamp) obj).ntpValue();
    }

    public Date getDate() {
        return new Date(getTime(this.ntpTime));
    }

    public long getFraction() {
        return this.ntpTime & 4294967295L;
    }

    public long getSeconds() {
        return (this.ntpTime >>> 32) & 4294967295L;
    }

    public long getTime() {
        return getTime(this.ntpTime);
    }

    public int hashCode() {
        return (int) (this.ntpTime ^ (this.ntpTime >>> 32));
    }

    public long ntpValue() {
        return this.ntpTime;
    }

    private void readObject(ObjectInputStream in) {
        throw new UnsupportedOperationException("Serialization is not supported");
    }

    public String toDateString() {
        if (this.simpleFormatter == null) {
            this.simpleFormatter = new SimpleDateFormat(NTP_DATE_FORMAT, Locale.US);
            this.simpleFormatter.setTimeZone(TimeZone.getDefault());
        }
        Date ntpDate = getDate();
        return this.simpleFormatter.format(ntpDate);
    }

    public String toString() {
        return toString(this.ntpTime);
    }

    public String toUTCString() {
        if (this.utcFormatter == null) {
            this.utcFormatter = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS 'UTC'", Locale.US);
            this.utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        Date ntpDate = getDate();
        return this.utcFormatter.format(ntpDate);
    }

    private void writeObject(ObjectOutputStream out) {
        throw new UnsupportedOperationException("Serialization is not supported");
    }
}
