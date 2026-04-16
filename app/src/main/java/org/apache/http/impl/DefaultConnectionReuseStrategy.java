package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    @Override // org.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse response, HttpContext context) {
        Args.notNull(response, "HTTP response");
        Args.notNull(context, "HTTP context");
        if (response.getStatusLine().getStatusCode() == 204) {
            Header clh = response.getFirstHeader("Content-Length");
            if (clh != null) {
                try {
                    int contentLen = Integer.parseInt(clh.getValue());
                    if (contentLen > 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                }
            }
            if (response.getFirstHeader("Transfer-Encoding") != null) {
                return false;
            }
        }
        HttpRequest request = (HttpRequest) context.getAttribute("http.request");
        if (request != null) {
            try {
                TokenIterator ti = new BasicTokenIterator(request.headerIterator("Connection"));
                while (ti.hasNext()) {
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(ti.nextToken())) {
                        return false;
                    }
                }
            } catch (ParseException e2) {
                return false;
            }
        }
        ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
        Header teh = response.getFirstHeader("Transfer-Encoding");
        if (teh != null) {
            if (!HTTP.CHUNK_CODING.equalsIgnoreCase(teh.getValue())) {
                return false;
            }
        } else if (canResponseHaveBody(request, response)) {
            Header[] clhs = response.getHeaders("Content-Length");
            if (clhs.length != 1) {
                return false;
            }
            try {
                long contentLen2 = Long.parseLong(clhs[0].getValue());
                if (contentLen2 < 0) {
                    return false;
                }
            } catch (NumberFormatException e3) {
                return false;
            }
        }
        HeaderIterator headerIterator = response.headerIterator("Connection");
        if (!headerIterator.hasNext()) {
            headerIterator = response.headerIterator("Proxy-Connection");
        }
        if (headerIterator.hasNext()) {
            try {
                TokenIterator ti2 = new BasicTokenIterator(headerIterator);
                boolean keepalive = false;
                while (ti2.hasNext()) {
                    String token = ti2.nextToken();
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(token)) {
                        return false;
                    }
                    if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token)) {
                        keepalive = true;
                    }
                }
                if (keepalive) {
                    return true;
                }
            } catch (ParseException e4) {
                return false;
            }
        }
        return !ver.lessEquals(HttpVersion.HTTP_1_0);
    }

    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        return new BasicTokenIterator(hit);
    }

    private boolean canResponseHaveBody(HttpRequest request, HttpResponse response) {
        int status;
        return ((request != null && request.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) || (status = response.getStatusLine().getStatusCode()) < 200 || status == 204 || status == 304 || status == 205) ? false : true;
    }
}
