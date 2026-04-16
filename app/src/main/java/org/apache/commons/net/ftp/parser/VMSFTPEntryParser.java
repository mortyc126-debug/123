package org.apache.commons.net.ftp.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.StringTokenizer;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;

/* JADX INFO: loaded from: classes2.dex */
public class VMSFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    private static final String DEFAULT_DATE_FORMAT = "d-MMM-yyyy HH:mm:ss";
    private static final String REGEX = "(.*?;[0-9]+)\\s*(\\d+)(?:/\\d+)?\\s*(\\S+)\\s+(\\S+)\\s+\\[(([0-9$A-Za-z_]+)|([0-9$A-Za-z_]+),([0-9$a-zA-Z_]+))\\]?\\s*\\([a-zA-Z]*,([a-zA-Z]*),([a-zA-Z]*),([a-zA-Z]*)\\)";

    public VMSFTPEntryParser() {
        this(null);
    }

    public VMSFTPEntryParser(FTPClientConfig config) {
        super(REGEX);
        configure(config);
    }

    @Override // org.apache.commons.net.ftp.parser.ConfigurableFTPFileEntryParserImpl
    protected FTPClientConfig getDefaultConfiguration() {
        return new FTPClientConfig(FTPClientConfig.SYST_VMS, DEFAULT_DATE_FORMAT, null);
    }

    protected boolean isVersioning() {
        return false;
    }

    @Deprecated
    public FTPFile[] parseFileList(InputStream listStream) throws IOException {
        FTPListParseEngine engine = new FTPListParseEngine(this);
        engine.readServerList(listStream, null);
        return engine.getFiles();
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String entry) {
        String grp;
        String user;
        int i;
        long longBlock = 512;
        if (matches(entry)) {
            FTPFile f2 = new FTPFile();
            f2.setRawListing(entry);
            String name = group(1);
            String size = group(2);
            String datestr = group(3) + " " + group(4);
            String owner = group(5);
            String[] permissions = {group(9), group(10), group(11)};
            try {
                f2.setTimestamp(super.parseTimestamp(datestr));
            } catch (ParseException e) {
            }
            StringTokenizer t = new StringTokenizer(owner, ",");
            switch (t.countTokens()) {
                case 1:
                    grp = null;
                    String user2 = t.nextToken();
                    user = user2;
                    break;
                case 2:
                    grp = t.nextToken();
                    String user3 = t.nextToken();
                    user = user3;
                    break;
                default:
                    grp = null;
                    user = null;
                    break;
            }
            if (name.lastIndexOf(".DIR") != -1) {
                f2.setType(1);
                i = 0;
            } else {
                i = 0;
                f2.setType(0);
            }
            if (!isVersioning()) {
                name = name.substring(i, name.lastIndexOf(59));
            }
            f2.setName(name);
            long sizeInBytes = Long.parseLong(size) * 512;
            f2.setSize(sizeInBytes);
            f2.setGroup(grp);
            f2.setUser(user);
            int access = 0;
            while (access < 3) {
                String permission = permissions[access];
                StringTokenizer t2 = t;
                long longBlock2 = longBlock;
                f2.setPermission(access, 0, permission.indexOf(82) >= 0);
                f2.setPermission(access, 1, permission.indexOf(87) >= 0);
                f2.setPermission(access, 2, permission.indexOf(69) >= 0);
                access++;
                t = t2;
                longBlock = longBlock2;
            }
            return f2;
        }
        return null;
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParserImpl, org.apache.commons.net.ftp.FTPFileEntryParser
    public String readNextEntry(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        StringBuilder entry = new StringBuilder();
        while (line != null) {
            if (line.startsWith("Directory") || line.startsWith("Total")) {
                line = reader.readLine();
            } else {
                entry.append(line);
                if (line.trim().endsWith(")")) {
                    break;
                }
                line = reader.readLine();
            }
        }
        if (entry.length() == 0) {
            return null;
        }
        return entry.toString();
    }
}
