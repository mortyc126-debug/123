/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import androidx.emoji2.text.flatbuffer.Table;
import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

public final class StringVector
extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int n, int n2, ByteBuffer byteBuffer) {
        this.__reset(n, n2, byteBuffer);
        return this;
    }

    public String get(int n) {
        return Table.__string(this.__element(n), this.bb, this.utf8);
    }
}

