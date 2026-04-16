package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import kotlin.UByte;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes2.dex */
public final class TFTPDataPacket extends TFTPPacket {
    public static final int MAX_DATA_LENGTH = 512;
    public static final int MIN_DATA_LENGTH = 0;
    int blockNumber;
    private byte[] data;
    private int length;
    private int offset;

    TFTPDataPacket(DatagramPacket datagram) throws TFTPPacketException {
        super(3, datagram.getAddress(), datagram.getPort());
        this.data = datagram.getData();
        this.offset = 4;
        if (getType() != this.data[1]) {
            throw new TFTPPacketException("TFTP operator code does not match type.");
        }
        this.blockNumber = ((this.data[2] & UByte.MAX_VALUE) << 8) | (this.data[3] & UByte.MAX_VALUE);
        this.length = datagram.getLength() - 4;
        if (this.length > 512) {
            this.length = 512;
        }
    }

    public TFTPDataPacket(InetAddress destination, int port, int blockNumber, byte[] data) {
        this(destination, port, blockNumber, data, 0, data.length);
    }

    public TFTPDataPacket(InetAddress destination, int port, int blockNumber, byte[] data, int offset, int length) {
        super(3, destination, port);
        this.blockNumber = blockNumber;
        this.data = data;
        this.offset = offset;
        this.length = Math.min(length, 512);
    }

    public int getBlockNumber() {
        return this.blockNumber;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDataLength() {
        return this.length;
    }

    public int getDataOffset() {
        return this.offset;
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    public DatagramPacket newDatagram() {
        byte[] data = new byte[this.length + 4];
        data[0] = 0;
        data[1] = (byte) this.type;
        data[2] = (byte) ((this.blockNumber & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >> 8);
        data[3] = (byte) (this.blockNumber & 255);
        System.arraycopy(this.data, this.offset, data, 4, this.length);
        return new DatagramPacket(data, this.length + 4, this.address, this.port);
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    DatagramPacket newDatagram(DatagramPacket datagram, byte[] data) {
        data[0] = 0;
        data[1] = (byte) this.type;
        data[2] = (byte) ((this.blockNumber & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >> 8);
        data[3] = (byte) (this.blockNumber & 255);
        if (data != this.data) {
            System.arraycopy(this.data, this.offset, data, 4, this.length);
        }
        datagram.setAddress(this.address);
        datagram.setPort(this.port);
        datagram.setData(data);
        datagram.setLength(this.length + 4);
        return datagram;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setData(byte[] data, int offset, int length) {
        this.data = data;
        this.offset = offset;
        this.length = length;
        this.length = Math.min(length, 512);
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    public String toString() {
        return super.toString() + " DATA " + this.blockNumber + " " + this.length;
    }
}
