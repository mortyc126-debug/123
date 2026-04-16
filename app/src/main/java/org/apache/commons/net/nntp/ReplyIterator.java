package org.apache.commons.net.nntp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.net.io.DotTerminatedMessageReader;
import org.apache.commons.net.io.Util;

/* JADX INFO: loaded from: classes2.dex */
class ReplyIterator implements Iterator<String>, Iterable<String> {
    private String line;
    private final BufferedReader reader;
    private Exception savedException;

    ReplyIterator(BufferedReader _reader) throws IOException {
        this(_reader, true);
    }

    ReplyIterator(BufferedReader _reader, boolean addDotReader) throws IOException {
        this.reader = addDotReader ? new DotTerminatedMessageReader(_reader) : _reader;
        this.line = this.reader.readLine();
        if (this.line == null) {
            Util.closeQuietly(this.reader);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.savedException == null) {
            return this.line != null;
        }
        throw new NoSuchElementException(this.savedException.toString());
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public String next() throws NoSuchElementException {
        if (this.savedException != null) {
            throw new NoSuchElementException(this.savedException.toString());
        }
        String prev = this.line;
        if (prev == null) {
            throw new NoSuchElementException();
        }
        try {
            this.line = this.reader.readLine();
            if (this.line == null) {
                Util.closeQuietly(this.reader);
            }
        } catch (IOException ex) {
            this.savedException = ex;
            Util.closeQuietly(this.reader);
        }
        return prev;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
