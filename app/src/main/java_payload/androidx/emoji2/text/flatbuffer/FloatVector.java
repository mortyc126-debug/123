/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class FloatVector
extends BaseVector {
    public FloatVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 4, byteBuffer);
        return this;
    }

    public float get(int n) {
        return this.bb.getFloat(this.__element(n));
    }
}

