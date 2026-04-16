package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileEntryParser;
import org.apache.commons.net.ftp.FTPFileEntryParserImpl;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeFileEntryParser extends FTPFileEntryParserImpl {
    private FTPFileEntryParser cachedFtpFileEntryParser = null;
    private final FTPFileEntryParser[] ftpFileEntryParsers;

    public CompositeFileEntryParser(FTPFileEntryParser[] ftpFileEntryParsers) {
        this.ftpFileEntryParsers = ftpFileEntryParsers;
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String listEntry) {
        if (this.cachedFtpFileEntryParser != null) {
            return this.cachedFtpFileEntryParser.parseFTPEntry(listEntry);
        }
        for (FTPFileEntryParser ftpFileEntryParser : this.ftpFileEntryParsers) {
            FTPFile matched = ftpFileEntryParser.parseFTPEntry(listEntry);
            if (matched != null) {
                this.cachedFtpFileEntryParser = ftpFileEntryParser;
                return matched;
            }
        }
        return null;
    }
}
