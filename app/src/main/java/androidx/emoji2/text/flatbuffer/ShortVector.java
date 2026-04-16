/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class ShortVector
extends BaseVector {
    public ShortVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 2, byteBuffer);
        return this;
    }

    public short get(int n) {
        return this.bb.getShort(this.__element(n));
    }

    public int getAsUnsigned(int n) {
        return this.get(n) & 0xFFFF;
    }
}

