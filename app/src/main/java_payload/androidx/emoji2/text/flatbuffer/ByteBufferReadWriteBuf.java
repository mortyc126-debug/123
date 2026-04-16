/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.ReadWriteBuf;
import androidx.emoji2.text.flatbuffer.Utf8Safe;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf
implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public byte[] data() {
        return this.buffer.array();
    }

    @Override
    public byte get(int n) {
        return this.buffer.get(n);
    }

    @Override
    public boolean getBoolean(int n) {
        boolean bl = this.get(n) != 0;
        return bl;
    }

    @Override
    public double getDouble(int n) {
        return this.buffer.getDouble(n);
    }

    @Override
    public float getFloat(int n) {
        return this.buffer.getFloat(n);
    }

    @Override
    public int getInt(int n) {
        return this.buffer.getInt(n);
    }

    @Override
    public long getLong(int n) {
        return this.buffer.getLong(n);
    }

    @Override
    public short getShort(int n) {
        return this.buffer.getShort(n);
    }

    @Override
    public String getString(int n, int n2) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, n, n2);
    }

    @Override
    public int limit() {
        return this.buffer.limit();
    }

    @Override
    public void put(byte by) {
        this.buffer.put(by);
    }

    @Override
    public void put(byte[] byArray, int n, int n2) {
        this.buffer.put(byArray, n, n2);
    }

    @Override
    public void putBoolean(boolean bl) {
        this.buffer.put((byte)(bl ? 1 : 0));
    }

    @Override
    public void putDouble(double d) {
        this.buffer.putDouble(d);
    }

    @Override
    public void putFloat(float f) {
        this.buffer.putFloat(f);
    }

    @Override
    public void putInt(int n) {
        this.buffer.putInt(n);
    }

    @Override
    public void putLong(long l) {
        this.buffer.putLong(l);
    }

    @Override
    public void putShort(short s) {
        this.buffer.putShort(s);
    }

    @Override
    public boolean requestCapacity(int n) {
        boolean bl = n <= this.buffer.limit();
        return bl;
    }

    @Override
    public void set(int n, byte by) {
        this.requestCapacity(n + 1);
        this.buffer.put(n, by);
    }

    @Override
    public void set(int n, byte[] byArray, int n2, int n3) {
        this.requestCapacity(n3 - n2 + n);
        int n4 = this.buffer.position();
        this.buffer.position(n);
        this.buffer.put(byArray, n2, n3);
        this.buffer.position(n4);
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.set(n, (byte)(bl ? 1 : 0));
    }

    @Override
    public void setDouble(int n, double d) {
        this.requestCapacity(n + 8);
        this.buffer.putDouble(n, d);
    }

    @Override
    public void setFloat(int n, float f) {
        this.requestCapacity(n + 4);
        this.buffer.putFloat(n, f);
    }

    @Override
    public void setInt(int n, int n2) {
        this.requestCapacity(n + 4);
        this.buffer.putInt(n, n2);
    }

    @Override
    public void setLong(int n, long l) {
        this.requestCapacity(n + 8);
        this.buffer.putLong(n, l);
    }

    @Override
    public void setShort(int n, short s) {
        this.requestCapacity(n + 2);
        this.buffer.putShort(n, s);
    }

    @Override
    public int writePosition() {
        return this.buffer.position();
    }
}

