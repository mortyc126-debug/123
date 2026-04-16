/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    protected int __element(int n) {
        return this.vector + this.element_size * n;
    }

    protected void __reset(int n, int n2, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (this.bb != null) {
            this.vector = n;
            this.length = this.bb.getInt(n - 4);
            this.element_size = n2;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        this.__reset(0, 0, null);
    }
}

