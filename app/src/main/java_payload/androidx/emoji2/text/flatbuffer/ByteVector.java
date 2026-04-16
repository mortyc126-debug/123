/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class ByteVector
extends BaseVector {
    public ByteVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 1, byteBuffer);
        return this;
    }

    public byte get(int n) {
        return this.bb.get(this.__element(n));
    }

    public int getAsUnsigned(int n) {
        return this.get(n) & 0xFF;
    }
}

