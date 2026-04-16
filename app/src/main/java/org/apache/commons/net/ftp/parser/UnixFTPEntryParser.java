package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import java.util.List;
import java.util.function.Predicate;
import okhttp3.HttpUrl;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class UnixFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
    private static final String DEFAULT_DATE_FORMAT_JA = "M'月' d'日' yyyy'年'";
    static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
    private static final String DEFAULT_RECENT_DATE_FORMAT_JA = "M'月' d'日' HH:mm";
    private static final String JA_DAY = "日";
    private static final String JA_MONTH = "月";
    private static final String JA_YEAR = "年";
    private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3})|(?:\\d{1,2}月\\s+\\d{1,2}日))\\s+((?:\\d+(?::\\d+)?)|(?:\\d{4}年))\\s(.*)";
    final boolean trimLeadingSpaces;
    static final String NUMERIC_DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final FTPClientConfig NUMERIC_DATE_CONFIG = new FTPClientConfig(FTPClientConfig.SYST_UNIX, NUMERIC_DATE_FORMAT, null);

    public UnixFTPEntryParser() {
        this(null);
    }

    public UnixFTPEntryParser(FTPClientConfig config) {
        this(config, false);
    }

    public UnixFTPEntryParser(FTPClientConfig config, boolean trimLeadingSpaces) {
        super(REGEX);
        configure(config);
        this.trimLeadingSpaces = trimLeadingSpaces;
    }

    @Override // org.apache.commons.net.ftp.parser.ConfigurableFTPFileEntryParserImpl
    protected FTPClientConfig getDefaultConfiguration() {
        return new FTPClientConfig(FTPClientConfig.SYST_UNIX, "MMM d yyyy", "MMM d HH:mm");
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String entry) {
        String name;
        boolean isDevice;
        int type;
        int end;
        FTPFile file = new FTPFile();
        file.setRawListing(entry);
        if (matches(entry)) {
            String typeStr = group(1);
            String hardLinkCount = group(15);
            String usr = group(16);
            String grp = group(17);
            String filesize = group(18);
            String datestr = group(19) + " " + group(20);
            String name2 = group(21);
            if (!this.trimLeadingSpaces) {
                name = name2;
            } else {
                name = name2.replaceFirst("^\\s+", HttpUrl.FRAGMENT_ENCODE_SET);
            }
            try {
                if (group(19).contains(JA_MONTH)) {
                    FTPTimestampParserImpl jaParser = new FTPTimestampParserImpl();
                    jaParser.configure(new FTPClientConfig(FTPClientConfig.SYST_UNIX, DEFAULT_DATE_FORMAT_JA, DEFAULT_RECENT_DATE_FORMAT_JA));
                    file.setTimestamp(jaParser.parseTimestamp(datestr));
                } else {
                    file.setTimestamp(super.parseTimestamp(datestr));
                }
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
                file.setPermission(g2, 0, !group(g).equals("-"));
                file.setPermission(g2, 1, !group(g + 1).equals("-"));
                String execPerm = group(g + 2);
                file.setPermission(g2, 2, (execPerm.equals("-") || Character.isUpperCase(execPerm.charAt(0))) ? false : true);
                g2++;
                g += 4;
            }
            if (!isDevice) {
                try {
                    file.setHardLinkCount(Integer.parseInt(hardLinkCount));
                } catch (NumberFormatException e2) {
                }
            }
            file.setUser(usr);
            file.setGroup(grp);
            try {
                file.setSize(Long.parseLong(filesize));
            } catch (NumberFormatException e3) {
            }
            if (type != 2 || (end = name.indexOf(" -> ")) == -1) {
                file.setName(name);
            } else {
                file.setName(name.substring(0, end));
                file.setLink(name.substring(end + 4));
            }
            return file;
        }
        return null;
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParserImpl, org.apache.commons.net.ftp.FTPFileEntryParser
    public List<String> preParse(List<String> original) {
        original.removeIf(new Predicate() { // from class: org.apache.commons.net.ftp.parser.UnixFTPEntryParser$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).matches("^total \\d+$");
            }
        });
        return original;
    }
}
