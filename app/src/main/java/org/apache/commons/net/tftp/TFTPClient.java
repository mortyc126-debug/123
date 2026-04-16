package org.apache.commons.net.tftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class TFTPClient extends TFTP {
    public static final int DEFAULT_MAX_TIMEOUTS = 5;
    private int maxTimeouts = 5;
    private long totalBytesReceived;
    private long totalBytesSent;

    public int getMaxTimeouts() {
        return this.maxTimeouts;
    }

    public long getTotalBytesReceived() {
        return this.totalBytesReceived;
    }

    public long getTotalBytesSent() {
        return this.totalBytesSent;
    }

    public int receiveFile(String fileName, int mode, OutputStream output, InetAddress host) throws IOException {
        return receiveFile(fileName, mode, output, host, 69);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:188|9|10)|(4:12|(4:14|197|15|(2:17|18)(1:19))(10:28|191|29|30|31|32|201|33|34|205)|177|178)(1:57)|199|58|(2:126|127)(2:61|SW:62)|128|(6:184|159|160|182|161|(4:210|163|164|165)(1:166))(1:171)) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0282, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0283, code lost:
    
        r14 = r14 == true ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x028d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0296, code lost:
    
        r19 = r7;
        r6 = r19;
        r4 = r4;
        r14 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x032b A[LOOP:1: B:188:0x0045->B:171:0x032b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0336 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v47 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v51 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r21v0, types: [org.apache.commons.net.tftp.TFTPClient] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int receiveFile(java.lang.String r22, int r23, java.io.OutputStream r24, java.net.InetAddress r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.TFTPClient.receiveFile(java.lang.String, int, java.io.OutputStream, java.net.InetAddress, int):int");
    }

    public int receiveFile(String fileName, int mode, OutputStream output, String hostname) throws IOException {
        return receiveFile(fileName, mode, output, InetAddress.getByName(hostname), 69);
    }

    public int receiveFile(String fileName, int mode, OutputStream output, String hostname, int port) throws IOException {
        return receiveFile(fileName, mode, output, InetAddress.getByName(hostname), port);
    }

    public void sendFile(String fileName, int mode, InputStream input, InetAddress host) throws Throwable {
        sendFile(fileName, mode, input, host, 69);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025a A[LOOP:1: B:145:0x0049->B:133:0x025a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01f1 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendFile(java.lang.String r20, int r21, java.io.InputStream r22, java.net.InetAddress r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.TFTPClient.sendFile(java.lang.String, int, java.io.InputStream, java.net.InetAddress, int):void");
    }

    public void sendFile(String fileName, int mode, InputStream input, String hostname) throws Throwable {
        sendFile(fileName, mode, input, InetAddress.getByName(hostname), 69);
    }

    public void sendFile(String fileName, int mode, InputStream input, String hostname, int port) throws Throwable {
        sendFile(fileName, mode, input, InetAddress.getByName(hostname), port);
    }

    public void setMaxTimeouts(int numTimeouts) {
        this.maxTimeouts = Math.max(numTimeouts, 1);
    }
}
