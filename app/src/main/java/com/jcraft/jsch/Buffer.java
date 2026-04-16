/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;

public class Buffer {
    byte[] buffer;
    int index;
    int s;
    final byte[] tmp = new byte[4];

    public Buffer() {
        this(20480);
    }

    public Buffer(int n) {
        this.buffer = new byte[n];
        this.index = 0;
        this.s = 0;
    }

    public Buffer(byte[] byArray) {
        this.buffer = byArray;
        this.index = 0;
        this.s = 0;
    }

    static Buffer fromBytes(byte[][] byArray) {
        int n;
        int n2 = byArray.length * 4;
        for (n = 0; n < byArray.length; ++n) {
            n2 += byArray[n].length;
        }
        Buffer buffer = new Buffer(n2);
        for (n = 0; n < byArray.length; ++n) {
            buffer.putString(byArray[n]);
        }
        return buffer;
    }

    void checkFreeSize(int n) {
        int n2 = this.index + n + 128;
        if (this.buffer.length < n2) {
            int n3;
            n = n3 = this.buffer.length * 2;
            if (n3 < n2) {
                n = n2;
            }
            byte[] byArray = new byte[n];
            System.arraycopy(this.buffer, 0, byArray, 0, this.index);
            this.buffer = byArray;
        }
    }

    public int getByte() {
        byte[] byArray = this.buffer;
        int n = this.s;
        this.s = n + 1;
        return byArray[n] & 0xFF;
    }

    public int getByte(int n) {
        int n2 = this.s;
        this.s += n;
        return n2;
    }

    public void getByte(byte[] byArray) {
        this.getByte(byArray, 0, byArray.length);
    }

    void getByte(byte[] byArray, int n, int n2) {
        System.arraycopy(this.buffer, this.s, byArray, n, n2);
        this.s += n2;
    }

    byte[][] getBytes(int n, String string2) throws JSchException {
        byte[][] byArrayArray = new byte[n][];
        for (int i = 0; i < n; ++i) {
            int n2 = this.getInt();
            if (this.getLength() >= n2) {
                byArrayArray[i] = new byte[n2];
                this.getByte(byArrayArray[i]);
                continue;
            }
            throw new JSchException(string2);
        }
        return byArrayArray;
    }

    byte getCommand() {
        return this.buffer[5];
    }

    public int getInt() {
        return this.getShort() << 16 & 0xFFFF0000 | this.getShort() & 0xFFFF;
    }

    public int getLength() {
        return this.index - this.s;
    }

    public long getLong() {
        return ((long)this.getInt() & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL & (long)this.getInt();
    }

    public byte[] getMPInt() {
        int n;
        block3: {
            block2: {
                int n2 = this.getInt();
                if (n2 < 0) break block2;
                n = n2;
                if (n2 <= 8192) break block3;
            }
            n = 8192;
        }
        byte[] byArray = new byte[n];
        this.getByte(byArray, 0, n);
        return byArray;
    }

    public byte[] getMPIntBits() {
        int n = (this.getInt() + 7) / 8;
        byte[] byArray = new byte[n];
        this.getByte(byArray, 0, n);
        byte[] byArray2 = byArray;
        if ((byArray[0] & 0x80) != 0) {
            byArray2 = new byte[byArray.length + 1];
            byArray2[0] = 0;
            System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
        }
        return byArray2;
    }

    public int getOffSet() {
        return this.s;
    }

    int getShort() {
        return this.getByte() << 8 & 0xFF00 | this.getByte() & 0xFF;
    }

    public byte[] getString() {
        int n;
        block3: {
            block2: {
                int n2 = this.getInt();
                if (n2 < 0) break block2;
                n = n2;
                if (n2 <= 262144) break block3;
            }
            n = 262144;
        }
        byte[] byArray = new byte[n];
        this.getByte(byArray, 0, n);
        return byArray;
    }

    byte[] getString(int[] nArray, int[] nArray2) {
        int n = this.getInt();
        nArray[0] = this.getByte(n);
        nArray2[0] = n;
        return this.buffer;
    }

    public long getUInt() {
        return ((long)this.getByte() << 8 & 0xFF00L | (long)(this.getByte() & 0xFF)) << 16 & 0xFFFFFFFFFFFF0000L | 0xFFFFL & ((long)this.getByte() << 8 & 0xFF00L | (long)(this.getByte() & 0xFF));
    }

    public void putByte(byte by) {
        byte[] byArray = this.buffer;
        int n = this.index;
        this.index = n + 1;
        byArray[n] = by;
    }

    public void putByte(byte[] byArray) {
        this.putByte(byArray, 0, byArray.length);
    }

    public void putByte(byte[] byArray, int n, int n2) {
        System.arraycopy(byArray, n, this.buffer, this.index, n2);
        this.index += n2;
    }

    public void putInt(int n) {
        this.tmp[0] = (byte)(n >>> 24);
        this.tmp[1] = (byte)(n >>> 16);
        this.tmp[2] = (byte)(n >>> 8);
        this.tmp[3] = (byte)n;
        System.arraycopy(this.tmp, 0, this.buffer, this.index, 4);
        this.index += 4;
    }

    public void putLong(long l) {
        this.tmp[0] = (byte)(l >>> 56);
        this.tmp[1] = (byte)(l >>> 48);
        this.tmp[2] = (byte)(l >>> 40);
        this.tmp[3] = (byte)(l >>> 32);
        System.arraycopy(this.tmp, 0, this.buffer, this.index, 4);
        this.tmp[0] = (byte)(l >>> 24);
        this.tmp[1] = (byte)(l >>> 16);
        this.tmp[2] = (byte)(l >>> 8);
        this.tmp[3] = (byte)l;
        System.arraycopy(this.tmp, 0, this.buffer, this.index + 4, 4);
        this.index += 8;
    }

    public void putMPInt(byte[] byArray) {
        int n = byArray.length;
        if ((byArray[0] & 0x80) != 0) {
            this.putInt(n + 1);
            this.putByte((byte)0);
        } else {
            this.putInt(n);
        }
        this.putByte(byArray);
    }

    void putPad(int n) {
        while (n > 0) {
            byte[] byArray = this.buffer;
            int n2 = this.index;
            this.index = n2 + 1;
            byArray[n2] = 0;
            --n;
        }
    }

    public void putString(byte[] byArray) {
        this.putString(byArray, 0, byArray.length);
    }

    public void putString(byte[] byArray, int n, int n2) {
        this.putInt(n2);
        this.putByte(byArray, n, n2);
    }

    public void reset() {
        this.index = 0;
        this.s = 0;
    }

    void rewind() {
        this.s = 0;
    }

    public void setOffSet(int n) {
        this.s = n;
    }

    public void shift() {
        if (this.s == 0) {
            return;
        }
        System.arraycopy(this.buffer, this.s, this.buffer, 0, this.index - this.s);
        this.index -= this.s;
        this.s = 0;
    }

    void skip(int n) {
        this.index += n;
    }
}

