/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import java.nio.ByteBuffer;

public final class BooleanVector
extends BaseVector {
    public BooleanVector __assign(int n, ByteBuffer byteBuffer) {
        this.__reset(n, 1, byteBuffer);
        return this;
    }

    public boolean get(int n) {
        boolean bl = this.bb.get(this.__element(n)) != 0;
        return bl;
    }
}

