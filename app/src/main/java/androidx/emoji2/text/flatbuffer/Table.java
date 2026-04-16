/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    protected static boolean __has_identifier(ByteBuffer byteBuffer, String string2) {
        if (string2.length() == 4) {
            for (int i = 0; i < 4; ++i) {
                if (string2.charAt(i) == (char)byteBuffer.get(byteBuffer.position() + 4 + i)) continue;
                return false;
            }
            return true;
        }
        throw new AssertionError((Object)"FlatBuffers: file identifier must be length 4");
    }

    protected static int __indirect(int n, ByteBuffer byteBuffer) {
        return byteBuffer.getInt(n) + n;
    }

    protected static int __offset(int n, int n2, ByteBuffer byteBuffer) {
        n2 = byteBuffer.capacity() - n2;
        return byteBuffer.getShort(n2 + n - byteBuffer.getInt(n2)) + n2;
    }

    protected static String __string(int n, ByteBuffer byteBuffer, Utf8 utf8) {
        n += byteBuffer.getInt(n);
        return utf8.decodeUtf8(byteBuffer, n + 4, byteBuffer.getInt(n));
    }

    protected static Table __union(Table table, int n, ByteBuffer byteBuffer) {
        table.__reset(Table.__indirect(n, byteBuffer), byteBuffer);
        return table;
    }

    protected static int compareStrings(int n, int n2, ByteBuffer byteBuffer) {
        n += byteBuffer.getInt(n);
        int n3 = n2 + byteBuffer.getInt(n2);
        int n4 = byteBuffer.getInt(n);
        n2 = byteBuffer.getInt(n3);
        int n5 = n + 4;
        int n6 = n3 + 4;
        n3 = Math.min(n4, n2);
        for (n = 0; n < n3; ++n) {
            if (byteBuffer.get(n + n5) == byteBuffer.get(n + n6)) continue;
            return byteBuffer.get(n + n5) - byteBuffer.get(n + n6);
        }
        return n4 - n2;
    }

    protected static int compareStrings(int n, byte[] byArray, ByteBuffer byteBuffer) {
        n += byteBuffer.getInt(n);
        int n2 = byteBuffer.getInt(n);
        int n3 = byArray.length;
        int n4 = n + 4;
        int n5 = Math.min(n2, n3);
        for (n = 0; n < n5; ++n) {
            if (byteBuffer.get(n + n4) == byArray[n]) continue;
            return byteBuffer.get(n + n4) - byArray[n];
        }
        return n2 - n3;
    }

    protected int __indirect(int n) {
        return this.bb.getInt(n) + n;
    }

    protected int __offset(int n) {
        n = n < this.vtable_size ? (int)this.bb.getShort(this.vtable_start + n) : 0;
        return n;
    }

    public void __reset() {
        this.__reset(0, null);
    }

    protected void __reset(int n, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (this.bb != null) {
            this.bb_pos = n;
            this.vtable_start = this.bb_pos - this.bb.getInt(this.bb_pos);
            this.vtable_size = this.bb.getShort(this.vtable_start);
        } else {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        }
    }

    protected String __string(int n) {
        return Table.__string(n, this.bb, this.utf8);
    }

    protected Table __union(Table table, int n) {
        return Table.__union(table, n, this.bb);
    }

    protected int __vector(int n) {
        return this.bb.getInt(n += this.bb_pos) + n + 4;
    }

    protected ByteBuffer __vector_as_bytebuffer(int n, int n2) {
        if ((n = this.__offset(n)) == 0) {
            return null;
        }
        ByteBuffer byteBuffer = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int n3 = this.__vector(n);
        byteBuffer.position(n3);
        byteBuffer.limit(this.__vector_len(n) * n2 + n3);
        return byteBuffer;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int n, int n2) {
        int n3 = this.__offset(n);
        if (n3 == 0) {
            return null;
        }
        n = this.__vector(n3);
        byteBuffer.rewind();
        byteBuffer.limit(this.__vector_len(n3) * n2 + n);
        byteBuffer.position(n);
        return byteBuffer;
    }

    protected int __vector_len(int n) {
        int n2 = this.bb.getInt(n += this.bb_pos);
        return this.bb.getInt(n + n2);
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    protected int keysCompare(Integer n, Integer n2, ByteBuffer byteBuffer) {
        return 0;
    }

    protected void sortTables(int[] nArray, ByteBuffer byteBuffer) {
        int n;
        Integer[] integerArray = new Integer[nArray.length];
        for (n = 0; n < nArray.length; ++n) {
            integerArray[n] = nArray[n];
        }
        Arrays.sort(integerArray, new Comparator<Integer>(this, byteBuffer){
            final Table this$0;
            final ByteBuffer val$bb;
            {
                this.this$0 = table;
                this.val$bb = byteBuffer;
            }

            @Override
            public int compare(Integer n, Integer n2) {
                return this.this$0.keysCompare(n, n2, this.val$bb);
            }
        });
        for (n = 0; n < nArray.length; ++n) {
            nArray[n] = integerArray[n];
        }
    }
}

