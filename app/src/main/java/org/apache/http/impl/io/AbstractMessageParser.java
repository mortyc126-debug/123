package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    protected abstract T parseHead(SessionInputBuffer sessionInputBuffer) throws HttpException, ParseException, IOException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer buffer, LineParser parser, HttpParams params) {
        Args.notNull(buffer, "Session input buffer");
        Args.notNull(params, "HTTP parameters");
        this.sessionBuffer = buffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(params);
        this.lineParser = parser != null ? parser : BasicLineParser.INSTANCE;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer buffer, LineParser lineParser, MessageConstraints constraints) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(buffer, "Session input buffer");
        this.lineParser = lineParser != null ? lineParser : BasicLineParser.INSTANCE;
        this.messageConstraints = constraints != null ? constraints : MessageConstraints.DEFAULT;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer inBuffer, int maxHeaderCount, int maxLineLen, LineParser parser) throws HttpException, IOException {
        List<CharArrayBuffer> headerLines = new ArrayList<>();
        return parseHeaders(inBuffer, maxHeaderCount, maxLineLen, parser != null ? parser : BasicLineParser.INSTANCE, headerLines);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:
    
        r2 = new org.apache.http.Header[r12.size()];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009b, code lost:
    
        if (r3 >= r12.size()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009d, code lost:
    
        r4 = r12.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a3, code lost:
    
        r2[r3] = r11.parseHeader(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b7, code lost:
    
        throw new org.apache.http.ProtocolException(r5.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b8, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.http.Header[] parseHeaders(org.apache.http.io.SessionInputBuffer r8, int r9, int r10, org.apache.http.message.LineParser r11, java.util.List<org.apache.http.util.CharArrayBuffer> r12) throws org.apache.http.HttpException, java.io.IOException {
        /*
            java.lang.String r0 = "Session input buffer"
            org.apache.http.util.Args.notNull(r8, r0)
            java.lang.String r0 = "Line parser"
            org.apache.http.util.Args.notNull(r11, r0)
            java.lang.String r0 = "Header line list"
            org.apache.http.util.Args.notNull(r12, r0)
            r0 = 0
            r1 = 0
        L11:
            if (r0 != 0) goto L1c
            org.apache.http.util.CharArrayBuffer r2 = new org.apache.http.util.CharArrayBuffer
            r3 = 64
            r2.<init>(r3)
            r0 = r2
            goto L1f
        L1c:
            r0.clear()
        L1f:
            int r2 = r8.readLine(r0)
            r3 = -1
            if (r2 == r3) goto L90
            int r3 = r0.length()
            r4 = 1
            if (r3 >= r4) goto L2e
            goto L90
        L2e:
            r3 = 0
            char r5 = r0.charAt(r3)
            r6 = 9
            r7 = 32
            if (r5 == r7) goto L3f
            char r3 = r0.charAt(r3)
            if (r3 != r6) goto L79
        L3f:
            if (r1 == 0) goto L79
            r3 = 0
        L42:
            int r5 = r0.length()
            if (r3 >= r5) goto L55
            char r5 = r0.charAt(r3)
            if (r5 == r7) goto L51
            if (r5 == r6) goto L51
            goto L55
        L51:
            int r3 = r3 + 1
            goto L42
        L55:
            if (r10 <= 0) goto L6d
            int r5 = r1.length()
            int r5 = r5 + r4
            int r4 = r0.length()
            int r5 = r5 + r4
            int r5 = r5 - r3
            if (r5 > r10) goto L65
            goto L6d
        L65:
            org.apache.http.MessageConstraintException r4 = new org.apache.http.MessageConstraintException
            java.lang.String r5 = "Maximum line length limit exceeded"
            r4.<init>(r5)
            throw r4
        L6d:
            r1.append(r7)
            int r4 = r0.length()
            int r4 = r4 - r3
            r1.append(r0, r3, r4)
            goto L7e
        L79:
            r12.add(r0)
            r1 = r0
            r0 = 0
        L7e:
            if (r9 <= 0) goto L8f
            int r3 = r12.size()
            if (r3 >= r9) goto L87
            goto L8f
        L87:
            org.apache.http.MessageConstraintException r3 = new org.apache.http.MessageConstraintException
            java.lang.String r4 = "Maximum header count exceeded"
            r3.<init>(r4)
            throw r3
        L8f:
            goto L11
        L90:
            int r2 = r12.size()
            org.apache.http.Header[] r2 = new org.apache.http.Header[r2]
            r3 = 0
        L97:
            int r4 = r12.size()
            if (r3 >= r4) goto Lb8
            java.lang.Object r4 = r12.get(r3)
            org.apache.http.util.CharArrayBuffer r4 = (org.apache.http.util.CharArrayBuffer) r4
            org.apache.http.Header r5 = r11.parseHeader(r4)     // Catch: org.apache.http.ParseException -> Lad
            r2[r3] = r5     // Catch: org.apache.http.ParseException -> Lad
            int r3 = r3 + 1
            goto L97
        Lad:
            r5 = move-exception
            org.apache.http.ProtocolException r6 = new org.apache.http.ProtocolException
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            throw r6
        Lb8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.io.AbstractMessageParser.parseHeaders(org.apache.http.io.SessionInputBuffer, int, int, org.apache.http.message.LineParser, java.util.List):org.apache.http.Header[]");
    }

    @Override // org.apache.http.io.HttpMessageParser
    public T parse() throws HttpException, IOException {
        switch (this.state) {
            case 0:
                try {
                    this.message = (T) parseHead(this.sessionBuffer);
                    this.state = 1;
                } catch (ParseException e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
                break;
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t;
    }
}
