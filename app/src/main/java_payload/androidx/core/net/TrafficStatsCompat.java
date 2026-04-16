/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.TrafficStats
 */
package androidx.core.net;

import android.net.TrafficStats;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public final class TrafficStatsCompat {
    private TrafficStatsCompat() {
    }

    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int n) {
        TrafficStats.incrementOperationCount((int)n);
    }

    @Deprecated
    public static void incrementOperationCount(int n, int n2) {
        TrafficStats.incrementOperationCount((int)n, (int)n2);
    }

    @Deprecated
    public static void setThreadStatsTag(int n) {
        TrafficStats.setThreadStatsTag((int)n);
    }

    public static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        Api24Impl.tagDatagramSocket(datagramSocket);
    }

    @Deprecated
    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket((Socket)socket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        Api24Impl.untagDatagramSocket(datagramSocket);
    }

    @Deprecated
    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket((Socket)socket);
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.tagDatagramSocket((DatagramSocket)datagramSocket);
        }

        static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.untagDatagramSocket((DatagramSocket)datagramSocket);
        }
    }
}

