/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.ReadWriteBuf;
import androidx.emoji2.text.flatbuffer.Utf8Safe;
import java.util.Arrays;

public class ArrayReadWriteBuf
implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int n) {
        this(new byte[n]);
    }

    public ArrayReadWriteBuf(byte[] byArray) {
        this.buffer = byArray;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] byArray, int n) {
        this.buffer = byArray;
        this.writePos = n;
    }

    @Override
    public byte[] data() {
        return this.buffer;
    }

    @Override
    public byte get(int n) {
        return this.buffer[n];
    }

    @Override
    public boolean getBoolean(int n) {
        boolean bl = this.buffer[n] != 0;
        return bl;
    }

    @Override
    public double getDouble(int n) {
        return Double.longBitsToDouble(this.getLong(n));
    }

    @Override
    public float getFloat(int n) {
        return Float.intBitsToFloat(this.getInt(n));
    }

    @Override
    public int getInt(int n) {
        return this.buffer[n + 3] << 24 | (this.buffer[n + 2] & 0xFF) << 16 | (this.buffer[n + 1] & 0xFF) << 8 | this.buffer[n] & 0xFF;
    }

    @Override
    public long getLong(int n) {
        byte[] byArray = this.buffer;
        int n2 = n + 1;
        long l = byArray[n];
        byArray = this.buffer;
        n = n2 + 1;
        long l2 = byArray[n2];
        byArray = this.buffer;
        n2 = n + 1;
        long l3 = byArray[n];
        byArray = this.buffer;
        n = n2 + 1;
        long l4 = byArray[n2];
        byArray = this.buffer;
        n2 = n + 1;
        long l5 = byArray[n];
        byArray = this.buffer;
        n = n2 + 1;
        return l & 0xFFL | (l2 & 0xFFL) << 8 | (l3 & 0xFFL) << 16 | (l4 & 0xFFL) << 24 | (l5 & 0xFFL) << 32 | ((long)byArray[n2] & 0xFFL) << 40 | (0xFFL & (long)this.buffer[n]) << 48 | (long)this.buffer[n + 1] << 56;
    }

    @Override
    public short getShort(int n) {
        return (short)(this.buffer[n + 1] << 8 | this.buffer[n] & 0xFF);
    }

    @Override
    public String getString(int n, int n2) {
        return Utf8Safe.decodeUtf8Array(this.buffer, n, n2);
    }

    @Override
    public int limit() {
        return this.writePos;
    }

    @Override
    public void put(byte by) {
        this.set(this.writePos, by);
        ++this.writePos;
    }

    @Override
    public void put(byte[] byArray, int n, int n2) {
        this.set(this.writePos, byArray, n, n2);
        this.writePos += n2;
    }

    @Override
    public void putBoolean(boolean bl) {
        this.setBoolean(this.writePos, bl);
        ++this.writePos;
    }

    @Override
    public void putDouble(double d) {
        this.setDouble(this.writePos, d);
        this.writePos += 8;
    }

    @Override
    public void putFloat(float f) {
        this.setFloat(this.writePos, f);
        this.writePos += 4;
    }

    @Override
    public void putInt(int n) {
        this.setInt(this.writePos, n);
        this.writePos += 4;
    }

    @Override
    public void putLong(long l) {
        this.setLong(this.writePos, l);
        this.writePos += 8;
    }

    @Override
    public void putShort(short s) {
        this.setShort(this.writePos, s);
        this.writePos += 2;
    }

    @Override
    public boolean requestCapacity(int n) {
        if (this.buffer.length > n) {
            return true;
        }
        n = this.buffer.length;
        this.buffer = Arrays.copyOf(this.buffer, (n >> 1) + n);
        return true;
    }

    @Override
    public void set(int n, byte by) {
        this.requestCapacity(n + 1);
        this.buffer[n] = by;
    }

    @Override
    public void set(int n, byte[] byArray, int n2, int n3) {
        this.requestCapacity(n3 - n2 + n);
        System.arraycopy(byArray, n2, this.buffer, n, n3);
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.set(n, (byte)(bl ? 1 : 0));
    }

    @Override
    public void setDouble(int n, double d) {
        this.requestCapacity(n + 8);
        long l = Double.doubleToRawLongBits(d);
        int n2 = (int)l;
        byte[] byArray = this.buffer;
        int n3 = n + 1;
        byArray[n] = (byte)(n2 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 8 & 0xFF);
        byArray = this.buffer;
        n3 = n + 1;
        byArray[n] = (byte)(n2 >> 16 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 24 & 0xFF);
        n3 = (int)(l >> 32);
        byArray = this.buffer;
        n2 = n + 1;
        byArray[n] = (byte)(n3 & 0xFF);
        byArray = this.buffer;
        n = n2 + 1;
        byArray[n2] = (byte)(n3 >> 8 & 0xFF);
        this.buffer[n] = (byte)(n3 >> 16 & 0xFF);
        this.buffer[n + 1] = (byte)(n3 >> 24 & 0xFF);
    }

    @Override
    public void setFloat(int n, float f) {
        this.requestCapacity(n + 4);
        int n2 = Float.floatToRawIntBits(f);
        byte[] byArray = this.buffer;
        int n3 = n + 1;
        byArray[n] = (byte)(n2 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 8 & 0xFF);
        this.buffer[n] = (byte)(n2 >> 16 & 0xFF);
        this.buffer[n + 1] = (byte)(n2 >> 24 & 0xFF);
    }

    @Override
    public void setInt(int n, int n2) {
        this.requestCapacity(n + 4);
        byte[] byArray = this.buffer;
        int n3 = n + 1;
        byArray[n] = (byte)(n2 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 8 & 0xFF);
        this.buffer[n] = (byte)(n2 >> 16 & 0xFF);
        this.buffer[n + 1] = (byte)(n2 >> 24 & 0xFF);
    }

    @Override
    public void setLong(int n, long l) {
        this.requestCapacity(n + 8);
        int n2 = (int)l;
        byte[] byArray = this.buffer;
        int n3 = n + 1;
        byArray[n] = (byte)(n2 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 8 & 0xFF);
        byArray = this.buffer;
        n3 = n + 1;
        byArray[n] = (byte)(n2 >> 16 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 24 & 0xFF);
        n2 = (int)(l >> 32);
        byArray = this.buffer;
        n3 = n + 1;
        byArray[n] = (byte)(n2 & 0xFF);
        byArray = this.buffer;
        n = n3 + 1;
        byArray[n3] = (byte)(n2 >> 8 & 0xFF);
        this.buffer[n] = (byte)(n2 >> 16 & 0xFF);
        this.buffer[n + 1] = (byte)(n2 >> 24 & 0xFF);
    }

    @Override
    public void setShort(int n, short s) {
        this.requestCapacity(n + 2);
        this.buffer[n] = (byte)(s & 0xFF);
        this.buffer[n + 1] = (byte)(s >> 8 & 0xFF);
    }

    @Override
    public int writePosition() {
        return this.writePos;
    }
}

