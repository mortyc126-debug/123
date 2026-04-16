package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import kotlin.UByte;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes2.dex */
public final class TFTPAckPacket extends TFTPPacket {
    int blockNumber;

    TFTPAckPacket(DatagramPacket datagram) throws TFTPPacketException {
        super(4, datagram.getAddress(), datagram.getPort());
        byte[] data = datagram.getData();
        if (getType() != data[1]) {
            throw new TFTPPacketException("TFTP operator code does not match type.");
        }
        this.blockNumber = ((data[2] & UByte.MAX_VALUE) << 8) | (data[3] & UByte.MAX_VALUE);
    }

    public TFTPAckPacket(InetAddress destination, int port, int blockNumber) {
        super(4, destination, port);
        this.blockNumber = blockNumber;
    }

    public int getBlockNumber() {
        return this.blockNumber;
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    public DatagramPacket newDatagram() {
        byte[] data = {0, (byte) this.type, (byte) ((this.blockNumber & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >> 8), (byte) (this.blockNumber & 255)};
        return new DatagramPacket(data, data.length, this.address, this.port);
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    DatagramPacket newDatagram(DatagramPacket datagram, byte[] data) {
        data[0] = 0;
        data[1] = (byte) this.type;
        data[2] = (byte) ((this.blockNumber & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >> 8);
        data[3] = (byte) (this.blockNumber & 255);
        datagram.setAddress(this.address);
        datagram.setPort(this.port);
        datagram.setData(data);
        datagram.setLength(4);
        return datagram;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    public String toString() {
        return super.toString() + " ACK " + this.blockNumber;
    }
}
