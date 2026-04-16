package org.apache.commons.net.daytime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;

/* JADX INFO: loaded from: classes2.dex */
public final class DaytimeUDPClient extends DatagramSocketClient {
    public static final int DEFAULT_PORT = 13;
    private final byte[] dummyData = new byte[1];
    private final byte[] timeData = new byte[256];

    public String getTime(InetAddress host) throws IOException {
        return getTime(host, 13);
    }

    public String getTime(InetAddress host, int port) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(this.dummyData, this.dummyData.length, host, port);
        DatagramPacket receivePacket = new DatagramPacket(this.timeData, this.timeData.length);
        this._socket_.send(sendPacket);
        this._socket_.receive(receivePacket);
        return new String(receivePacket.getData(), 0, receivePacket.getLength(), getCharset());
    }
}
