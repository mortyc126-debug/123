/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.ReadBuf;

interface ReadWriteBuf
extends ReadBuf {
    @Override
    public int limit();

    public void put(byte var1);

    public void put(byte[] var1, int var2, int var3);

    public void putBoolean(boolean var1);

    public void putDouble(double var1);

    public void putFloat(float var1);

    public void putInt(int var1);

    public void putLong(long var1);

    public void putShort(short var1);

    public boolean requestCapacity(int var1);

    public void set(int var1, byte var2);

    public void set(int var1, byte[] var2, int var3, int var4);

    public void setBoolean(int var1, boolean var2);

    public void setDouble(int var1, double var2);

    public void setFloat(int var1, float var2);

    public void setInt(int var1, int var2);

    public void setLong(int var1, long var2);

    public void setShort(int var1, short var2);

    public int writePosition();
}

