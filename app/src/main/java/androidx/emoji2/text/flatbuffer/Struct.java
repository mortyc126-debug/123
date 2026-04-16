/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    public void __reset() {
        this.__reset(0, null);
    }

    protected void __reset(int n, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        this.bb_pos = this.bb != null ? n : 0;
    }
}

