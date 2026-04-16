/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Table;
import androidx.emoji2.text.flatbuffer.Utf8;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {
    static final boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished = false;
    boolean force_defaults = false;
    int minalign = 1;
    boolean nested = false;
    int num_vtables = 0;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems = 0;
    int[] vtable = null;
    int vtable_in_use = 0;
    int[] vtables = new int[16];

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(int n) {
        this(n, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int n, ByteBufferFactory byteBufferFactory) {
        this(n, byteBufferFactory, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int n, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        int n2 = n;
        if (n <= 0) {
            n2 = 1;
        }
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            this.bb.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(n2);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, (ByteBufferFactory)new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        this.finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory object) {
        int n = byteBuffer.capacity();
        if ((0xC0000000 & n) == 0) {
            int n2 = n == 0 ? 1 : n << 1;
            byteBuffer.position(0);
            object = ((ByteBufferFactory)object).newByteBuffer(n2);
            ((ByteBuffer)object).position(((ByteBuffer)object).clear().capacity() - n);
            ((ByteBuffer)object).put(byteBuffer);
            return object;
        }
        throw new AssertionError((Object)"FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table table, int n) {
        boolean bl = table.__offset(n) != 0;
        return bl;
    }

    public void Nested(int n) {
        if (n == this.offset()) {
            return;
        }
        throw new AssertionError((Object)"FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(int n, boolean bl, boolean bl2) {
        if (this.force_defaults || bl != bl2) {
            this.addBoolean(bl);
            this.slot(n);
        }
    }

    public void addBoolean(boolean bl) {
        this.prep(1, 0);
        this.putBoolean(bl);
    }

    public void addByte(byte by) {
        this.prep(1, 0);
        this.putByte(by);
    }

    public void addByte(int n, byte by, int n2) {
        if (this.force_defaults || by != n2) {
            this.addByte(by);
            this.slot(n);
        }
    }

    public void addDouble(double d) {
        this.prep(8, 0);
        this.putDouble(d);
    }

    public void addDouble(int n, double d, double d2) {
        if (this.force_defaults || d != d2) {
            this.addDouble(d);
            this.slot(n);
        }
    }

    public void addFloat(float f) {
        this.prep(4, 0);
        this.putFloat(f);
    }

    public void addFloat(int n, float f, double d) {
        if (this.force_defaults || (double)f != d) {
            this.addFloat(f);
            this.slot(n);
        }
    }

    public void addInt(int n) {
        this.prep(4, 0);
        this.putInt(n);
    }

    public void addInt(int n, int n2, int n3) {
        if (this.force_defaults || n2 != n3) {
            this.addInt(n2);
            this.slot(n);
        }
    }

    public void addLong(int n, long l, long l2) {
        if (this.force_defaults || l != l2) {
            this.addLong(l);
            this.slot(n);
        }
    }

    public void addLong(long l) {
        this.prep(8, 0);
        this.putLong(l);
    }

    public void addOffset(int n) {
        this.prep(4, 0);
        if (n <= this.offset()) {
            this.putInt(this.offset() - n + 4);
            return;
        }
        throw new AssertionError();
    }

    public void addOffset(int n, int n2, int n3) {
        if (this.force_defaults || n2 != n3) {
            this.addOffset(n2);
            this.slot(n);
        }
    }

    public void addShort(int n, short s, int n2) {
        if (this.force_defaults || s != n2) {
            this.addShort(s);
            this.slot(n);
        }
    }

    public void addShort(short s) {
        this.prep(2, 0);
        this.putShort(s);
    }

    public void addStruct(int n, int n2, int n3) {
        if (n2 != n3) {
            this.Nested(n2);
            this.slot(n);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (this.vtable_in_use > 0) {
            int n;
            int[] nArray = this.vtable;
            this.vtable_in_use = n = this.vtable_in_use - 1;
            nArray[n] = 0;
        }
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int n = byteBuffer.remaining();
        this.startVector(1, n, 1);
        ByteBuffer byteBuffer2 = this.bb;
        this.space = n = this.space - n;
        byteBuffer2.position(n);
        this.bb.put(byteBuffer);
        return this.endVector();
    }

    public int createByteVector(byte[] byArray) {
        int n = byArray.length;
        this.startVector(1, n, 1);
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - n;
        byteBuffer.position(n);
        this.bb.put(byArray);
        return this.endVector();
    }

    public int createByteVector(byte[] byArray, int n, int n2) {
        int n3;
        this.startVector(1, n2, 1);
        ByteBuffer byteBuffer = this.bb;
        this.space = n3 = this.space - n2;
        byteBuffer.position(n3);
        this.bb.put(byArray, n, n2);
        return this.endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t, int[] nArray) {
        t.sortTables(nArray, this.bb);
        return this.createVectorOfTables(nArray);
    }

    public int createString(CharSequence charSequence) {
        int n = this.utf8.encodedLength(charSequence);
        this.addByte((byte)0);
        this.startVector(1, n, 1);
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - n;
        byteBuffer.position(n);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return this.endVector();
    }

    public int createString(ByteBuffer byteBuffer) {
        int n = byteBuffer.remaining();
        this.addByte((byte)0);
        this.startVector(1, n, 1);
        ByteBuffer byteBuffer2 = this.bb;
        this.space = n = this.space - n;
        byteBuffer2.position(n);
        this.bb.put(byteBuffer);
        return this.endVector();
    }

    public ByteBuffer createUnintializedVector(int n, int n2, int n3) {
        int n4 = n * n2;
        this.startVector(n, n2, n3);
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - n4;
        byteBuffer.position(n);
        byteBuffer = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.limit(n4);
        return byteBuffer;
    }

    public int createVectorOfTables(int[] nArray) {
        this.notNested();
        this.startVector(4, nArray.length, 4);
        for (int i = nArray.length - 1; i >= 0; --i) {
            this.addOffset(nArray[i]);
        }
        return this.endVector();
    }

    public ByteBuffer dataBuffer() {
        this.finished();
        return this.bb;
    }

    public int endTable() {
        if (this.vtable != null && this.nested) {
            int n;
            int n2;
            this.addInt(0);
            int n3 = this.offset();
            for (n2 = this.vtable_in_use - 1; n2 >= 0 && this.vtable[n2] == 0; --n2) {
            }
            int n4 = n2;
            while ((n = n4) >= 0) {
                n4 = this.vtable[n] != 0 ? n3 - this.vtable[n] : 0;
                this.addShort((short)n4);
                n4 = n - 1;
            }
            this.addShort((short)(n3 - this.object_start));
            this.addShort((short)((n2 + 1 + 2) * 2));
            n = 0;
            n2 = 0;
            while (true) {
                block10: {
                    n4 = n;
                    if (n2 >= this.num_vtables) break;
                    int n5 = this.bb.capacity() - this.vtables[n2];
                    int n6 = this.space;
                    short s = this.bb.getShort(n5);
                    if (s == this.bb.getShort(n6)) {
                        for (n4 = 2; n4 < s; n4 += 2) {
                            if (this.bb.getShort(n5 + n4) == this.bb.getShort(n6 + n4)) {
                                continue;
                            }
                            break block10;
                        }
                        n4 = this.vtables[n2];
                        break;
                    }
                }
                ++n2;
            }
            if (n4 != 0) {
                this.space = this.bb.capacity() - n3;
                this.bb.putInt(this.space, n4 - n3);
            } else {
                if (this.num_vtables == this.vtables.length) {
                    this.vtables = Arrays.copyOf(this.vtables, this.num_vtables * 2);
                }
                int[] nArray = this.vtables;
                n2 = this.num_vtables;
                this.num_vtables = n2 + 1;
                nArray[n2] = this.offset();
                this.bb.putInt(this.bb.capacity() - n3, this.offset() - n3);
            }
            this.nested = false;
            return n3;
        }
        throw new AssertionError((Object)"FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if (this.nested) {
            this.nested = false;
            this.putInt(this.vector_num_elems);
            return this.offset();
        }
        throw new AssertionError((Object)"FlatBuffers: endVector called without startVector");
    }

    public void finish(int n) {
        this.finish(n, false);
    }

    public void finish(int n, String string2) {
        this.finish(n, string2, false);
    }

    protected void finish(int n, String string2, boolean bl) {
        int n2 = this.minalign;
        int n3 = bl ? 4 : 0;
        this.prep(n2, n3 + 8);
        if (string2.length() == 4) {
            for (n3 = 3; n3 >= 0; --n3) {
                this.addByte((byte)string2.charAt(n3));
            }
            this.finish(n, bl);
            return;
        }
        throw new AssertionError((Object)"FlatBuffers: file identifier must be length 4");
    }

    protected void finish(int n, boolean bl) {
        int n2 = this.minalign;
        int n3 = bl ? 4 : 0;
        this.prep(n2, n3 + 4);
        this.addOffset(n);
        if (bl) {
            this.addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int n) {
        this.finish(n, true);
    }

    public void finishSizePrefixed(int n, String string2) {
        this.finish(n, string2, true);
    }

    public void finished() {
        if (this.finished) {
            return;
        }
        throw new AssertionError((Object)"FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean bl) {
        this.force_defaults = bl;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        this.bb.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (!this.nested) {
            return;
        }
        throw new AssertionError((Object)"FlatBuffers: object serialization must not be nested.");
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int n) {
        for (int i = 0; i < n; ++i) {
            int n2;
            ByteBuffer byteBuffer = this.bb;
            this.space = n2 = this.space - 1;
            byteBuffer.put(n2, (byte)0);
        }
    }

    public void prep(int n, int n2) {
        if (n > this.minalign) {
            this.minalign = n;
        }
        int n3 = ~(this.bb.capacity() - this.space + n2) + 1 & n - 1;
        while (this.space < n3 + n + n2) {
            int n4 = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            this.bb = FlatBufferBuilder.growByteBuffer(byteBuffer, this.bb_factory);
            if (byteBuffer != this.bb) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space += this.bb.capacity() - n4;
        }
        this.pad(n3);
    }

    public void putBoolean(boolean bl) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 1;
        byteBuffer.put(n, (byte)(bl ? 1 : 0));
    }

    public void putByte(byte by) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 1;
        byteBuffer.put(n, by);
    }

    public void putDouble(double d) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 8;
        byteBuffer.putDouble(n, d);
    }

    public void putFloat(float f) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 4;
        byteBuffer.putFloat(n, f);
    }

    public void putInt(int n) {
        int n2;
        ByteBuffer byteBuffer = this.bb;
        this.space = n2 = this.space - 4;
        byteBuffer.putInt(n2, n);
    }

    public void putLong(long l) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 8;
        byteBuffer.putLong(n, l);
    }

    public void putShort(short s) {
        int n;
        ByteBuffer byteBuffer = this.bb;
        this.space = n = this.space - 2;
        byteBuffer.putShort(n, s);
    }

    public void required(int n, int n2) {
        int n3 = this.bb.capacity() - n;
        n = this.bb.getShort(n3 - (n = this.bb.getInt(n3)) + n2) != 0 ? 1 : 0;
        if (n != 0) {
            return;
        }
        throw new AssertionError((Object)("FlatBuffers: field " + n2 + " must be set"));
    }

    public byte[] sizedByteArray() {
        return this.sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public byte[] sizedByteArray(int n, int n2) {
        this.finished();
        byte[] byArray = new byte[n2];
        this.bb.position(n);
        this.bb.get(byArray);
        return byArray;
    }

    public InputStream sizedInputStream() {
        this.finished();
        ByteBuffer byteBuffer = this.bb.duplicate();
        byteBuffer.position(this.space);
        byteBuffer.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(byteBuffer);
    }

    public void slot(int n) {
        this.vtable[n] = this.offset();
    }

    public void startTable(int n) {
        this.notNested();
        if (this.vtable == null || this.vtable.length < n) {
            this.vtable = new int[n];
        }
        this.vtable_in_use = n;
        Arrays.fill(this.vtable, 0, this.vtable_in_use, 0);
        this.nested = true;
        this.object_start = this.offset();
    }

    public void startVector(int n, int n2, int n3) {
        this.notNested();
        this.vector_num_elems = n2;
        this.prep(4, n * n2);
        this.prep(n3, n * n2);
        this.nested = true;
    }

    static class ByteBufferBackedInputStream
    extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override
        public int read() throws IOException {
            try {
                byte by = this.buf.get();
                return by & 0xFF;
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int var1);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory
    extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override
        public ByteBuffer newByteBuffer(int n) {
            return ByteBuffer.allocate(n).order(ByteOrder.LITTLE_ENDIAN);
        }
    }
}

