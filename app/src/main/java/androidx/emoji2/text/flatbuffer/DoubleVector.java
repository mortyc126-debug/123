/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class DoubleVector
extends BaseVector {
    public DoubleVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 8, byteBuffer);
        return this;
    }

    public double get(int n) {
        return this.bb.getDouble(this.__element(n));
    }
}

