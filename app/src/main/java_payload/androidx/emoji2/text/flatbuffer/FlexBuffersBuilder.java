/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.ArrayReadWriteBuf;
import androidx.emoji2.text.flatbuffer.FlexBuffers;
import androidx.emoji2.text.flatbuffer.ReadWriteBuf;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    static final boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished = false;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack = new ArrayList();
    private final HashMap<String, Integer> stringPool;

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int n) {
        this(new ArrayReadWriteBuf(n), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int n) {
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.keyComparator = new Comparator<Value>(this){
            final FlexBuffersBuilder this$0;
            {
                this.this$0 = flexBuffersBuilder;
            }

            @Override
            public int compare(Value value, Value value2) {
                byte by;
                byte by2;
                int n = value.key;
                int n2 = value2.key;
                do {
                    by2 = this.this$0.bb.get(n);
                    by = this.this$0.bb.get(n2);
                    if (by2 == 0) {
                        return by2 - by;
                    }
                    ++n;
                    ++n2;
                } while (by2 == by);
                return by2 - by;
            }
        };
        this.bb = readWriteBuf;
        this.flags = n;
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int n) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), n);
    }

    private int align(int n) {
        int n2 = 1 << n;
        for (n = Value.paddingBytes(this.bb.writePosition(), n2); n != 0; --n) {
            this.bb.put((byte)0);
        }
        return n2;
    }

    private Value createKeyVector(int n, int n2) {
        int n3;
        int n4 = Math.max(0, FlexBuffersBuilder.widthUInBits(n2));
        for (n3 = n; n3 < this.stack.size(); ++n3) {
            n4 = Math.max(n4, Value.elemWidth(4, 0, this.stack.get((int)n3).key, this.bb.writePosition(), n3 + 1));
        }
        n3 = this.align(n4);
        this.writeInt(n2, n3);
        n2 = this.bb.writePosition();
        while (n < this.stack.size()) {
            if (this.stack.get((int)n).key != -1) {
                this.writeOffset(this.stack.get((int)n).key, n3);
                ++n;
                continue;
            }
            throw new AssertionError();
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), n4, n2);
    }

    private Value createVector(int n, int n2, int n3, boolean bl, boolean bl2, Value value) {
        int n4;
        if (bl2 && !bl) {
            throw new AssertionError();
        }
        int n5 = FlexBuffersBuilder.widthUInBits(n3);
        int n6 = 0;
        int n7 = Math.max(0, n5);
        int n8 = 1;
        n5 = n7;
        if (value != null) {
            n5 = Math.max(n7, value.elemWidth(this.bb.writePosition(), 0));
            n8 = 1 + 2;
        }
        n7 = 4;
        for (n4 = n2; n4 < this.stack.size(); ++n4) {
            n5 = Math.max(n5, this.stack.get(n4).elemWidth(this.bb.writePosition(), n4 + n8));
            if (!bl) continue;
            if (n4 == n2) {
                n7 = this.stack.get((int)n4).type;
                if (FlexBuffers.isTypedVectorElementType(n7)) continue;
                throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
            }
            if (n7 != this.stack.get((int)n4).type) {
                throw new AssertionError();
            }
        }
        if (bl2 && !FlexBuffers.isTypedVectorElementType(n7)) {
            throw new AssertionError();
        }
        int n9 = this.align(n5);
        if (value != null) {
            this.writeOffset(value.iValue, n9);
            this.writeInt(1L << value.minBitWidth, n9);
        }
        if (!bl2) {
            this.writeInt(n3, n9);
        }
        n4 = this.bb.writePosition();
        for (n8 = n2; n8 < this.stack.size(); ++n8) {
            this.writeAny(this.stack.get(n8), n9);
        }
        if (!bl) {
            while (n2 < this.stack.size()) {
                this.bb.put(this.stack.get(n2).storedPackedType(n5));
                ++n2;
            }
        }
        if (value != null) {
            n2 = 9;
        } else if (bl) {
            n2 = n6;
            if (bl2) {
                n2 = n3;
            }
            n2 = FlexBuffers.toTypedVector(n7, n2);
        } else {
            n2 = 10;
        }
        return new Value(n, n2, n5, n4);
    }

    private int putKey(String string2) {
        if (string2 == null) {
            return -1;
        }
        int n = this.bb.writePosition();
        if ((this.flags & 1) != 0) {
            Object object = this.keyPool.get(string2);
            if (object == null) {
                object = string2.getBytes(StandardCharsets.UTF_8);
                this.bb.put((byte[])object, 0, ((Object)object).length);
                this.bb.put((byte)0);
                this.keyPool.put(string2, n);
            } else {
                n = (Integer)object;
            }
        } else {
            byte[] byArray = string2.getBytes(StandardCharsets.UTF_8);
            this.bb.put(byArray, 0, byArray.length);
            this.bb.put((byte)0);
            this.keyPool.put(string2, n);
        }
        return n;
    }

    private void putUInt(String object, long l) {
        int n = this.putKey((String)object);
        int n2 = FlexBuffersBuilder.widthUInBits(l);
        object = n2 == 0 ? Value.uInt8(n, (int)l) : (n2 == 1 ? Value.uInt16(n, (int)l) : (n2 == 2 ? Value.uInt32(n, (int)l) : Value.uInt64(n, l)));
        this.stack.add((Value)object);
    }

    private void putUInt64(String string2, long l) {
        this.stack.add(Value.uInt64(this.putKey(string2), l));
    }

    static int widthUInBits(long l) {
        if (l <= (long)FlexBuffers.Unsigned.byteToUnsignedInt((byte)-1)) {
            return 0;
        }
        if (l <= (long)FlexBuffers.Unsigned.shortToUnsignedInt((short)-1)) {
            return 1;
        }
        if (l <= FlexBuffers.Unsigned.intToUnsignedLong(-1)) {
            return 2;
        }
        return 3;
    }

    private void writeAny(Value value, int n) {
        switch (value.type) {
            default: {
                this.writeOffset(value.iValue, n);
                break;
            }
            case 3: {
                this.writeDouble(value.dValue, n);
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 26: {
                this.writeInt(value.iValue, n);
            }
        }
    }

    private Value writeBlob(int n, byte[] byArray, int n2, boolean bl) {
        int n3 = FlexBuffersBuilder.widthUInBits(byArray.length);
        int n4 = this.align(n3);
        this.writeInt(byArray.length, n4);
        n4 = this.bb.writePosition();
        this.bb.put(byArray, 0, byArray.length);
        if (bl) {
            this.bb.put((byte)0);
        }
        return Value.blob(n, n4, n2, n3);
    }

    private void writeDouble(double d, int n) {
        if (n == 4) {
            this.bb.putFloat((float)d);
        } else if (n == 8) {
            this.bb.putDouble(d);
        }
    }

    private void writeInt(long l, int n) {
        switch (n) {
            default: {
                break;
            }
            case 8: {
                this.bb.putLong(l);
                break;
            }
            case 4: {
                this.bb.putInt((int)l);
                break;
            }
            case 2: {
                this.bb.putShort((short)l);
                break;
            }
            case 1: {
                this.bb.put((byte)l);
            }
        }
    }

    private void writeOffset(long l, int n) {
        int n2 = (int)((long)this.bb.writePosition() - l);
        if (n != 8 && (long)n2 >= 1L << n * 8) {
            throw new AssertionError();
        }
        this.writeInt(n2, n);
    }

    private Value writeString(int n, String string2) {
        return this.writeBlob(n, string2.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String object, int n) {
        int n2 = this.putKey((String)object);
        Collections.sort(this.stack.subList(n, this.stack.size()), this.keyComparator);
        object = this.createKeyVector(n, this.stack.size() - n);
        object = this.createVector(n2, n, this.stack.size() - n, false, false, (Value)object);
        while (this.stack.size() > n) {
            this.stack.remove(this.stack.size() - 1);
        }
        this.stack.add((Value)object);
        return (int)((Value)object).iValue;
    }

    public int endVector(String object, int n, boolean bl, boolean bl2) {
        object = this.createVector(this.putKey((String)object), n, this.stack.size() - n, bl, bl2, null);
        while (this.stack.size() > n) {
            this.stack.remove(this.stack.size() - 1);
        }
        this.stack.add((Value)object);
        return (int)((Value)object).iValue;
    }

    public ByteBuffer finish() {
        if (this.stack.size() == 1) {
            int n = this.align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
            this.writeAny(this.stack.get(0), n);
            this.bb.put(this.stack.get(0).storedPackedType());
            this.bb.put((byte)n);
            this.finished = true;
            return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
        }
        throw new AssertionError();
    }

    public ReadWriteBuf getBuffer() {
        if (this.finished) {
            return this.bb;
        }
        throw new AssertionError();
    }

    public int putBlob(String object, byte[] byArray) {
        object = this.writeBlob(this.putKey((String)object), byArray, 25, false);
        this.stack.add((Value)object);
        return (int)((Value)object).iValue;
    }

    public int putBlob(byte[] byArray) {
        return this.putBlob(null, byArray);
    }

    public void putBoolean(String string2, boolean bl) {
        this.stack.add(Value.bool(this.putKey(string2), bl));
    }

    public void putBoolean(boolean bl) {
        this.putBoolean(null, bl);
    }

    public void putFloat(double d) {
        this.putFloat(null, d);
    }

    public void putFloat(float f) {
        this.putFloat((String)null, f);
    }

    public void putFloat(String string2, double d) {
        this.stack.add(Value.float64(this.putKey(string2), d));
    }

    public void putFloat(String string2, float f) {
        this.stack.add(Value.float32(this.putKey(string2), f));
    }

    public void putInt(int n) {
        this.putInt((String)null, n);
    }

    public void putInt(long l) {
        this.putInt(null, l);
    }

    public void putInt(String string2, int n) {
        this.putInt(string2, (long)n);
    }

    public void putInt(String string2, long l) {
        int n = this.putKey(string2);
        if (-128L <= l && l <= 127L) {
            this.stack.add(Value.int8(n, (int)l));
        } else if (-32768L <= l && l <= 32767L) {
            this.stack.add(Value.int16(n, (int)l));
        } else if (Integer.MIN_VALUE <= l && l <= Integer.MAX_VALUE) {
            this.stack.add(Value.int32(n, (int)l));
        } else {
            this.stack.add(Value.int64(n, l));
        }
    }

    public int putString(String string2) {
        return this.putString(null, string2);
    }

    public int putString(String object, String string2) {
        int n = this.putKey((String)object);
        if ((this.flags & 2) != 0) {
            object = this.stringPool.get(string2);
            if (object == null) {
                object = this.writeString(n, string2);
                this.stringPool.put(string2, (int)((Value)object).iValue);
                this.stack.add((Value)object);
                return (int)((Value)object).iValue;
            }
            int n2 = FlexBuffersBuilder.widthUInBits(string2.length());
            this.stack.add(Value.blob(n, (Integer)object, 5, n2));
            return (Integer)object;
        }
        object = this.writeString(n, string2);
        this.stack.add((Value)object);
        return (int)((Value)object).iValue;
    }

    public void putUInt(int n) {
        this.putUInt(null, n);
    }

    public void putUInt(long l) {
        this.putUInt(null, l);
    }

    public void putUInt64(BigInteger bigInteger) {
        this.putUInt64(null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    private static class Value {
        static final boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        Value(int n, int n2, int n3, double d) {
            this.key = n;
            this.type = n2;
            this.minBitWidth = n3;
            this.dValue = d;
            this.iValue = Long.MIN_VALUE;
        }

        Value(int n, int n2, int n3, long l) {
            this.key = n;
            this.type = n2;
            this.minBitWidth = n3;
            this.iValue = l;
            this.dValue = Double.MIN_VALUE;
        }

        static Value blob(int n, int n2, int n3, int n4) {
            return new Value(n, n3, n4, n2);
        }

        static Value bool(int n, boolean bl) {
            long l = bl ? 1L : 0L;
            return new Value(n, 26, 0, l);
        }

        private int elemWidth(int n, int n2) {
            return Value.elemWidth(this.type, this.minBitWidth, this.iValue, n, n2);
        }

        private static int elemWidth(int n, int n2, long l, int n3, int n4) {
            if (FlexBuffers.isTypeInline(n)) {
                return n2;
            }
            for (n = 1; n <= 32; n *= 2) {
                n2 = FlexBuffersBuilder.widthUInBits((int)((long)(Value.paddingBytes(n3, n) + n3 + n4 * n) - l));
                if (1L << n2 != (long)n) continue;
                return n2;
            }
            throw new AssertionError();
        }

        static Value float32(int n, float f) {
            return new Value(n, 3, 2, f);
        }

        static Value float64(int n, double d) {
            return new Value(n, 3, 3, d);
        }

        static Value int16(int n, int n2) {
            return new Value(n, 1, 1, n2);
        }

        static Value int32(int n, int n2) {
            return new Value(n, 1, 2, n2);
        }

        static Value int64(int n, long l) {
            return new Value(n, 1, 3, l);
        }

        static Value int8(int n, int n2) {
            return new Value(n, 1, 0, n2);
        }

        private static byte packedType(int n, int n2) {
            return (byte)(n2 << 2 | n);
        }

        private static int paddingBytes(int n, int n2) {
            return ~n + 1 & n2 - 1;
        }

        private byte storedPackedType() {
            return this.storedPackedType(0);
        }

        private byte storedPackedType(int n) {
            return Value.packedType(this.storedWidth(n), this.type);
        }

        private int storedWidth(int n) {
            if (FlexBuffers.isTypeInline(this.type)) {
                return Math.max(this.minBitWidth, n);
            }
            return this.minBitWidth;
        }

        static Value uInt16(int n, int n2) {
            return new Value(n, 2, 1, n2);
        }

        static Value uInt32(int n, int n2) {
            return new Value(n, 2, 2, n2);
        }

        static Value uInt64(int n, long l) {
            return new Value(n, 2, 3, l);
        }

        static Value uInt8(int n, int n2) {
            return new Value(n, 2, 0, n2);
        }
    }
}

