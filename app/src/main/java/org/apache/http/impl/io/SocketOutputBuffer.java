package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket socket, int bufferSize, HttpParams params) throws IOException {
        Args.notNull(socket, "Socket");
        int n = bufferSize;
        n = n < 0 ? socket.getSendBufferSize() : n;
        init(socket.getOutputStream(), n < 1024 ? 1024 : n, params);
    }
}
