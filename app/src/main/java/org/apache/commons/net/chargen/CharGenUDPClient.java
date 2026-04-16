package org.apache.commons.net.chargen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;
import org.apache.commons.net.util.NetConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class CharGenUDPClient extends DatagramSocketClient {
    public static final int CHARGEN_PORT = 19;
    public static final int DEFAULT_PORT = 19;
    public static final int NETSTAT_PORT = 15;
    public static final int QUOTE_OF_DAY_PORT = 17;
    public static final int SYSTAT_PORT = 11;
    private final byte[] receiveData = new byte[512];
    private final DatagramPacket receivePacket = new DatagramPacket(this.receiveData, this.receiveData.length);
    private final DatagramPacket sendPacket = new DatagramPacket(NetConstants.EMPTY_BTYE_ARRAY, 0);

    public byte[] receive() throws IOException {
        this._socket_.receive(this.receivePacket);
        int length = this.receivePacket.getLength();
        byte[] result = new byte[length];
        System.arraycopy(this.receiveData, 0, result, 0, length);
        return result;
    }

    public void send(InetAddress host) throws IOException {
        send(host, 19);
    }

    public void send(InetAddress host, int port) throws IOException {
        this.sendPacket.setAddress(host);
        this.sendPacket.setPort(port);
        this._socket_.send(this.sendPacket);
    }
}
