/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class LongVector
extends BaseVector {
    public LongVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 8, byteBuffer);
        return this;
    }

    public long get(int n) {
        return this.bb.getLong(this.__element(n));
    }
}

