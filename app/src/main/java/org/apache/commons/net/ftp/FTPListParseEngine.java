package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.net.util.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public class FTPListParseEngine {
    private static final FTPFile[] EMPTY_FTP_FILE_ARRAY = new FTPFile[0];
    private List<String> entries;
    private ListIterator<String> internalIterator;
    private final FTPFileEntryParser parser;
    private final boolean saveUnparseableEntries;

    public FTPListParseEngine(FTPFileEntryParser parser) {
        this(parser, null);
    }

    FTPListParseEngine(FTPFileEntryParser parser, FTPClientConfig configuration) {
        this.entries = new LinkedList();
        this.internalIterator = this.entries.listIterator();
        this.parser = parser;
        if (configuration != null) {
            this.saveUnparseableEntries = configuration.getUnparseableEntries();
        } else {
            this.saveUnparseableEntries = false;
        }
    }

    public List<FTPFile> getFileList(final FTPFileFilter filter) {
        return (List) this.entries.stream().map(new Function() { // from class: org.apache.commons.net.ftp.FTPListParseEngine$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1785xa450d0a6((String) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.commons.net.ftp.FTPListParseEngine$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return filter.accept((FTPFile) obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: renamed from: lambda$getFileList$0$org-apache-commons-net-ftp-FTPListParseEngine, reason: not valid java name */
    /* synthetic */ FTPFile m1785xa450d0a6(String e) {
        FTPFile file = this.parser.parseFTPEntry(e);
        return (file == null && this.saveUnparseableEntries) ? new FTPFile(e) : file;
    }

    public FTPFile[] getFiles() throws IOException {
        return getFiles(FTPFileFilters.NON_NULL);
    }

    public FTPFile[] getFiles(FTPFileFilter filter) throws IOException {
        return (FTPFile[]) getFileList(filter).toArray(EMPTY_FTP_FILE_ARRAY);
    }

    public FTPFile[] getNext(int quantityRequested) {
        List<FTPFile> tmpResults = new LinkedList<>();
        for (int count = quantityRequested; count > 0 && this.internalIterator.hasNext(); count--) {
            String entry = this.internalIterator.next();
            FTPFile temp = this.parser.parseFTPEntry(entry);
            if (temp == null && this.saveUnparseableEntries) {
                temp = new FTPFile(entry);
            }
            tmpResults.add(temp);
        }
        return (FTPFile[]) tmpResults.toArray(EMPTY_FTP_FILE_ARRAY);
    }

    public FTPFile[] getPrevious(int quantityRequested) {
        List<FTPFile> tmpResults = new LinkedList<>();
        for (int count = quantityRequested; count > 0 && this.internalIterator.hasPrevious(); count--) {
            String entry = this.internalIterator.previous();
            FTPFile temp = this.parser.parseFTPEntry(entry);
            if (temp == null && this.saveUnparseableEntries) {
                temp = new FTPFile(entry);
            }
            tmpResults.add(0, temp);
        }
        return (FTPFile[]) tmpResults.toArray(EMPTY_FTP_FILE_ARRAY);
    }

    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    public boolean hasPrevious() {
        return this.internalIterator.hasPrevious();
    }

    private void read(InputStream inputStream, String charsetName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.toCharset(charsetName)));
        try {
            String line = this.parser.readNextEntry(reader);
            while (line != null) {
                this.entries.add(line);
                line = this.parser.readNextEntry(reader);
            }
            reader.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    reader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public void readServerList(InputStream inputStream) throws IOException {
        readServerList(inputStream, null);
    }

    public void readServerList(InputStream inputStream, String charsetName) throws IOException {
        this.entries = new LinkedList();
        read(inputStream, charsetName);
        this.parser.preParse(this.entries);
        resetIterator();
    }

    public void resetIterator() {
        this.internalIterator = this.entries.listIterator();
    }
}
