package org.apache.commons.net.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;
import kotlin.UByte;
import org.apache.commons.net.DatagramSocketClient;

/* JADX INFO: loaded from: classes2.dex */
public final class TimeUDPClient extends DatagramSocketClient {
    public static final int DEFAULT_PORT = 37;
    public static final long SECONDS_1900_TO_1970 = 2208988800L;
    private final byte[] dummyData = new byte[1];
    private final byte[] timeData = new byte[4];

    public Date getDate(InetAddress host) throws IOException {
        return new Date((getTime(host, 37) - 2208988800L) * 1000);
    }

    public Date getDate(InetAddress host, int port) throws IOException {
        return new Date((getTime(host, port) - 2208988800L) * 1000);
    }

    public long getTime(InetAddress host) throws IOException {
        return getTime(host, 37);
    }

    public long getTime(InetAddress host, int port) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(this.dummyData, this.dummyData.length, host, port);
        DatagramPacket receivePacket = new DatagramPacket(this.timeData, this.timeData.length);
        this._socket_.send(sendPacket);
        this._socket_.receive(receivePacket);
        long time = 0 | (((long) ((this.timeData[0] & UByte.MAX_VALUE) << 24)) & 4294967295L);
        return time | (((long) ((this.timeData[1] & UByte.MAX_VALUE) << 16)) & 4294967295L) | (((long) ((this.timeData[2] & UByte.MAX_VALUE) << 8)) & 4294967295L) | (((long) (this.timeData[3] & UByte.MAX_VALUE)) & 4294967295L);
    }
}
