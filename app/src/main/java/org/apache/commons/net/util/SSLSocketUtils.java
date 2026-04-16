package org.apache.commons.net.util;

import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public class SSLSocketUtils {
    public static boolean enableEndpointNameVerification(SSLSocket socket) {
        SSLParameters sslParameters = socket.getSSLParameters();
        if (sslParameters != null) {
            sslParameters.setEndpointIdentificationAlgorithm("HTTPS");
            socket.setSSLParameters(sslParameters);
            return true;
        }
        return false;
    }

    private SSLSocketUtils() {
    }
}
