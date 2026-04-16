package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inStream) {
        this(inStream, -1L);
    }

    public InputStreamEntity(InputStream inStream, long length) {
        this(inStream, length, null);
    }

    public InputStreamEntity(InputStream inStream, ContentType contentType) {
        this(inStream, -1L, contentType);
    }

    public InputStreamEntity(InputStream inStream, long length, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inStream, "Source input stream");
        this.length = length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outStream) throws IOException {
        int readLen;
        Args.notNull(outStream, "Output stream");
        InputStream inStream = this.content;
        try {
            byte[] buffer = new byte[4096];
            if (this.length < 0) {
                while (true) {
                    int readLen2 = inStream.read(buffer);
                    if (readLen2 == -1) {
                        break;
                    } else {
                        outStream.write(buffer, 0, readLen2);
                    }
                }
            } else {
                long remaining = this.length;
                while (remaining > 0 && (readLen = inStream.read(buffer, 0, (int) Math.min(4096L, remaining))) != -1) {
                    outStream.write(buffer, 0, readLen);
                    remaining -= (long) readLen;
                }
            }
        } finally {
            inStream.close();
        }
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }
}
