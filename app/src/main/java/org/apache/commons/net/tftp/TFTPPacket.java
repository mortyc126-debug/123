package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TFTPPacket {
    public static final int ACKNOWLEDGEMENT = 4;
    public static final int DATA = 3;
    public static final int ERROR = 5;
    static final int MIN_PACKET_SIZE = 4;
    public static final int READ_REQUEST = 1;
    public static final int SEGMENT_SIZE = 512;
    public static final int WRITE_REQUEST = 2;
    InetAddress address;
    int port;
    int type;

    public abstract DatagramPacket newDatagram();

    abstract DatagramPacket newDatagram(DatagramPacket datagramPacket, byte[] bArr);

    public static final TFTPPacket newTFTPPacket(DatagramPacket datagram) throws TFTPPacketException {
        if (datagram.getLength() < 4) {
            throw new TFTPPacketException("Bad packet. Datagram data length is too short.");
        }
        byte[] data = datagram.getData();
        switch (data[1]) {
            case 1:
                TFTPPacket packet = new TFTPReadRequestPacket(datagram);
                return packet;
            case 2:
                TFTPPacket packet2 = new TFTPWriteRequestPacket(datagram);
                return packet2;
            case 3:
                TFTPPacket packet3 = new TFTPDataPacket(datagram);
                return packet3;
            case 4:
                TFTPPacket packet4 = new TFTPAckPacket(datagram);
                return packet4;
            case 5:
                TFTPPacket packet5 = new TFTPErrorPacket(datagram);
                return packet5;
            default:
                throw new TFTPPacketException("Bad packet.  Invalid TFTP operator code.");
        }
    }

    TFTPPacket(int type, InetAddress address, int port) {
        this.type = type;
        this.address = address;
        this.port = port;
    }

    public final InetAddress getAddress() {
        return this.address;
    }

    public final int getPort() {
        return this.port;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAddress(InetAddress address) {
        this.address = address;
    }

    public final void setPort(int port) {
        this.port = port;
    }

    public String toString() {
        return this.address + " " + this.port + " " + this.type;
    }
}
