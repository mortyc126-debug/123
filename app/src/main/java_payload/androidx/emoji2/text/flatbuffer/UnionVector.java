/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import androidx.emoji2.text.flatbuffer.Table;
import java.nio.ByteBuffer;

public final class UnionVector
extends BaseVector {
    public UnionVector __assign(int n, int n2, ByteBuffer byteBuffer) {
        this.__reset(n, n2, byteBuffer);
        return this;
    }

    public Table get(Table table, int n) {
        return Table.__union(table, this.__element(n), this.bb);
    }
}

