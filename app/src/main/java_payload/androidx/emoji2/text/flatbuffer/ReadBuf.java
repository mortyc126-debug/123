/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

interface ReadBuf {
    public byte[] data();

    public byte get(int var1);

    public boolean getBoolean(int var1);

    public double getDouble(int var1);

    public float getFloat(int var1);

    public int getInt(int var1);

    public long getLong(int var1);

    public short getShort(int var1);

    public String getString(int var1, int var2);

    public int limit();
}

