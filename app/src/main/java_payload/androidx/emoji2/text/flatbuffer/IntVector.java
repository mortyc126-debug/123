/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class IntVector
extends BaseVector {
    public IntVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 4, byteBuffer);
        return this;
    }

    public int get(int n) {
        return this.bb.getInt(this.__element(n));
    }

    public long getAsUnsigned(int n) {
        return (long)this.get(n) & 0xFFFFFFFFL;
    }
}

