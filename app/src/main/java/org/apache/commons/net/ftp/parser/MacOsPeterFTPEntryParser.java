package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class MacOsPeterFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
    static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
    private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)";

    public MacOsPeterFTPEntryParser() {
        this(null);
    }

    public MacOsPeterFTPEntryParser(FTPClientConfig config) {
        super(REGEX);
        configure(config);
    }

    @Override // org.apache.commons.net.ftp.parser.ConfigurableFTPFileEntryParserImpl
    protected FTPClientConfig getDefaultConfiguration() {
        return new FTPClientConfig(FTPClientConfig.SYST_UNIX, "MMM d yyyy", "MMM d HH:mm");
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String entry) {
        boolean isDevice;
        int type;
        int end;
        FTPFile file = new FTPFile();
        file.setRawListing(entry);
        if (matches(entry)) {
            boolean z = true;
            String typeStr = group(1);
            String filesize = group(20);
            String datestr = group(21) + " " + group(22);
            String name = group(23);
            String endtoken = group(24);
            try {
                file.setTimestamp(super.parseTimestamp(datestr));
            } catch (ParseException e) {
            }
            switch (typeStr.charAt(0)) {
                case '-':
                case HttpStatus.SC_PROCESSING /* 102 */:
                    isDevice = false;
                    type = 0;
                    break;
                case 'b':
                case 'c':
                    isDevice = true;
                    type = 0;
                    break;
                case 'd':
                    isDevice = false;
                    type = 1;
                    break;
                case HttpStatus.SC_SWITCHING_PROTOCOLS /* 101 */:
                    isDevice = false;
                    type = 2;
                    break;
                case 'l':
                    isDevice = false;
                    type = 2;
                    break;
                default:
                    isDevice = false;
                    type = 3;
                    break;
            }
            file.setType(type);
            int g = 4;
            int g2 = 0;
            while (g2 < 3) {
                file.setPermission(g2, 0, group(g).equals("-") ^ z);
                file.setPermission(g2, 1, !group(g + 1).equals("-"));
                String execPerm = group(g + 2);
                file.setPermission(g2, 2, (execPerm.equals("-") || Character.isUpperCase(execPerm.charAt(0))) ? false : true);
                g2++;
                g += 4;
                z = true;
            }
            if (!isDevice) {
                try {
                    file.setHardLinkCount(Integer.parseInt("0"));
                } catch (NumberFormatException e2) {
                }
            }
            file.setUser(null);
            file.setGroup(null);
            try {
                file.setSize(Long.parseLong(filesize));
            } catch (NumberFormatException e3) {
            }
            if (endtoken == null) {
                file.setName(name);
            } else {
                String name2 = name + endtoken;
                if (type != 2 || (end = name2.indexOf(" -> ")) == -1) {
                    file.setName(name2);
                } else {
                    file.setName(name2.substring(0, end));
                    file.setLink(name2.substring(end + 4));
                }
            }
            return file;
        }
        return null;
    }
}
