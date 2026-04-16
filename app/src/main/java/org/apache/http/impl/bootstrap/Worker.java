package org.apache.http.impl.bootstrap;

import java.io.IOException;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpService;

/* JADX INFO: loaded from: classes2.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    Worker(HttpService httpservice, HttpServerConnection conn, ExceptionLogger exceptionLogger) {
        this.httpservice = httpservice;
        this.conn = conn;
        this.exceptionLogger = exceptionLogger;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    BasicHttpContext localContext = new BasicHttpContext();
                    HttpCoreContext context = HttpCoreContext.adapt(localContext);
                    while (!Thread.interrupted() && this.conn.isOpen()) {
                        this.httpservice.handleRequest(this.conn, context);
                        localContext.clear();
                    }
                    this.conn.close();
                    this.conn.shutdown();
                } catch (Exception ex) {
                    this.exceptionLogger.log(ex);
                    this.conn.shutdown();
                }
            } catch (Throwable th) {
                try {
                    this.conn.shutdown();
                } catch (IOException ex2) {
                    this.exceptionLogger.log(ex2);
                }
                throw th;
            }
        } catch (IOException ex3) {
            this.exceptionLogger.log(ex3);
        }
    }
}
