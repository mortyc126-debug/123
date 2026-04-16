/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.ArrayReadWriteBuf;
import androidx.emoji2.text.flatbuffer.ByteBufferReadWriteBuf;
import androidx.emoji2.text.flatbuffer.ReadBuf;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class FlexBuffers {
    static final boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    static /* synthetic */ ReadBuf access$000() {
        return EMPTY_BB;
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int n = readBuf.limit() - 1;
        byte by = readBuf.get(n);
        return new Reference(readBuf, --n - by, by, Unsigned.byteToUnsignedInt(readBuf.get(n)));
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer object) {
        object = ((ByteBuffer)object).hasArray() ? new ArrayReadWriteBuf(((ByteBuffer)object).array(), ((Buffer)object).limit()) : new ByteBufferReadWriteBuf((ByteBuffer)object);
        return FlexBuffers.getRoot((ReadBuf)object);
    }

    private static int indirect(ReadBuf readBuf, int n, int n2) {
        return (int)((long)n - FlexBuffers.readUInt(readBuf, n, n2));
    }

    static boolean isTypeInline(int n) {
        boolean bl = n <= 3 || n == 26;
        return bl;
    }

    static boolean isTypedVector(int n) {
        boolean bl = n >= 11 && n <= 15 || n == 36;
        return bl;
    }

    static boolean isTypedVectorElementType(int n) {
        boolean bl = true;
        if ((n < 1 || n > 4) && n != 26) {
            bl = false;
        }
        return bl;
    }

    private static double readDouble(ReadBuf readBuf, int n, int n2) {
        switch (n2) {
            default: {
                return -1.0;
            }
            case 8: {
                return readBuf.getDouble(n);
            }
            case 4: 
        }
        return readBuf.getFloat(n);
    }

    private static int readInt(ReadBuf readBuf, int n, int n2) {
        return (int)FlexBuffers.readLong(readBuf, n, n2);
    }

    private static long readLong(ReadBuf readBuf, int n, int n2) {
        switch (n2) {
            default: {
                return -1L;
            }
            case 8: {
                return readBuf.getLong(n);
            }
            case 4: {
                return readBuf.getInt(n);
            }
            case 2: {
                return readBuf.getShort(n);
            }
            case 1: 
        }
        return readBuf.get(n);
    }

    private static long readUInt(ReadBuf readBuf, int n, int n2) {
        switch (n2) {
            default: {
                return -1L;
            }
            case 8: {
                return readBuf.getLong(n);
            }
            case 4: {
                return Unsigned.intToUnsignedLong(readBuf.getInt(n));
            }
            case 2: {
                return Unsigned.shortToUnsignedInt(readBuf.getShort(n));
            }
            case 1: 
        }
        return Unsigned.byteToUnsignedInt(readBuf.get(n));
    }

    static int toTypedVector(int n, int n2) {
        if (FlexBuffers.isTypedVectorElementType(n)) {
            switch (n2) {
                default: {
                    break;
                }
                case 4: {
                    return n - 1 + 22;
                }
                case 3: {
                    return n - 1 + 19;
                }
                case 2: {
                    return n - 1 + 16;
                }
                case 0: {
                    return n - 1 + 11;
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    static int toTypedVectorElementType(int n) {
        return n - 11 + 1;
    }

    public static class Blob
    extends Sized {
        static final boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.access$000(), 1, 1);

        Blob(ReadBuf readBuf, int n, int n2) {
            super(readBuf, n, n2);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer byteBuffer = ByteBuffer.wrap(this.bb.data());
            byteBuffer.position(this.end);
            byteBuffer.limit(this.end + this.size());
            return byteBuffer.asReadOnlyBuffer().slice();
        }

        public byte get(int n) {
            if (n >= 0 && n <= this.size()) {
                return this.bb.get(this.end + n);
            }
            throw new AssertionError();
        }

        public byte[] getBytes() {
            int n = this.size();
            byte[] byArray = new byte[n];
            for (int i = 0; i < n; ++i) {
                byArray[i] = this.bb.get(this.end + i);
            }
            return byArray;
        }

        @Override
        public String toString() {
            return this.bb.getString(this.end, this.size());
        }

        @Override
        public StringBuilder toString(StringBuilder stringBuilder) {
            stringBuilder.append('\"');
            stringBuilder.append(this.bb.getString(this.end, this.size()));
            return stringBuilder.append('\"');
        }
    }

    public static class FlexBufferException
    extends RuntimeException {
        FlexBufferException(String string2) {
            super(string2);
        }
    }

    public static class Key
    extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.access$000(), 0, 0);

        Key(ReadBuf readBuf, int n, int n2) {
            super(readBuf, n, n2);
        }

        public static Key empty() {
            return EMPTY;
        }

        int compareTo(byte[] byArray) {
            byte by;
            byte by2;
            int n = this.end;
            int n2 = 0;
            do {
                by2 = this.bb.get(n);
                by = byArray[n2];
                if (by2 == 0) {
                    return by2 - by;
                }
                ++n;
                if (++n2 != byArray.length) continue;
                return by2 - by;
            } while (by2 == by);
            return by2 - by;
        }

        public boolean equals(java.lang.Object object) {
            boolean bl = object instanceof Key;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            bl = bl2;
            if (((Key)object).end == this.end) {
                bl = bl2;
                if (((Key)object).byteWidth == this.byteWidth) {
                    bl = true;
                }
            }
            return bl;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override
        public String toString() {
            int n = this.end;
            while (true) {
                if (this.bb.get(n) == 0) {
                    int n2 = this.end;
                    return this.bb.getString(this.end, n - n2);
                }
                ++n;
            }
        }

        @Override
        public StringBuilder toString(StringBuilder stringBuilder) {
            return stringBuilder.append(this.toString());
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int n) {
            if (n >= this.size()) {
                return Key.EMPTY;
            }
            int n2 = this.vec.end;
            int n3 = this.vec.byteWidth;
            return new Key(this.vec.bb, FlexBuffers.indirect(this.vec.bb, n2 + n3 * n, this.vec.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (int i = 0; i < this.vec.size(); ++i) {
                this.vec.get(i).toString(stringBuilder);
                if (i == this.vec.size() - 1) continue;
                stringBuilder.append(", ");
            }
            return stringBuilder.append("]").toString();
        }
    }

    public static class Map
    extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);

        Map(ReadBuf readBuf, int n, int n2) {
            super(readBuf, n, n2);
        }

        private int binarySearch(KeyVector keyVector, byte[] byArray) {
            int n = 0;
            int n2 = keyVector.size() - 1;
            while (n <= n2) {
                int n3 = n + n2 >>> 1;
                int n4 = keyVector.get(n3).compareTo(byArray);
                if (n4 < 0) {
                    n = n3 + 1;
                    continue;
                }
                if (n4 > 0) {
                    n2 = n3 - 1;
                    continue;
                }
                return n3;
            }
            return -(n + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String string2) {
            return this.get(string2.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] byArray) {
            KeyVector keyVector = this.keys();
            int n = keyVector.size();
            int n2 = this.binarySearch(keyVector, byArray);
            if (n2 >= 0 && n2 < n) {
                return this.get(n2);
            }
            return Reference.NULL_REFERENCE;
        }

        public KeyVector keys() {
            int n = this.end - this.byteWidth * 3;
            return new KeyVector(new TypedVector(this.bb, FlexBuffers.indirect(this.bb, n, this.byteWidth), FlexBuffers.readInt(this.bb, this.byteWidth + n, this.byteWidth), 4));
        }

        @Override
        public StringBuilder toString(StringBuilder stringBuilder) {
            stringBuilder.append("{ ");
            KeyVector keyVector = this.keys();
            int n = this.size();
            Vector vector = this.values();
            for (int i = 0; i < n; ++i) {
                stringBuilder.append('\"').append(keyVector.get(i).toString()).append("\" : ");
                stringBuilder.append(vector.get(i).toString());
                if (i == n - 1) continue;
                stringBuilder.append(", ");
            }
            stringBuilder.append(" }");
            return stringBuilder;
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }
    }

    private static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        Object(ReadBuf readBuf, int n, int n2) {
            this.bb = readBuf;
            this.end = n;
            this.byteWidth = n2;
        }

        public String toString() {
            return this.toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder var1);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(ReadBuf readBuf, int n, int n2, int n3) {
            this(readBuf, n, n2, 1 << (n3 & 3), n3 >> 2);
        }

        Reference(ReadBuf readBuf, int n, int n2, int n3, int n4) {
            this.bb = readBuf;
            this.end = n;
            this.parentWidth = n2;
            this.byteWidth = n3;
            this.type = n4;
        }

        public Blob asBlob() {
            if (!this.isBlob() && !this.isString()) {
                return Blob.empty();
            }
            return new Blob(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            boolean bl = this.isBoolean();
            boolean bl2 = true;
            boolean bl3 = true;
            if (bl) {
                bl2 = this.bb.get(this.end) != 0 ? bl3 : false;
                return bl2;
            }
            if (this.asUInt() == 0L) {
                bl2 = false;
            }
            return bl2;
        }

        public double asFloat() {
            if (this.type == 3) {
                return FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                default: {
                    return 0.0;
                }
                case 10: {
                    return this.asVector().size();
                }
                case 8: {
                    return FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 7: {
                    return FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 6: {
                    return FlexBuffers.readInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 5: {
                    return Double.parseDouble(this.asString());
                }
                case 2: 
                case 26: {
                    return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
                }
                case 1: {
                    return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                }
                case 0: 
            }
            return 0.0;
        }

        public int asInt() {
            if (this.type == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                default: {
                    return 0;
                }
                case 26: {
                    return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                }
                case 10: {
                    return this.asVector().size();
                }
                case 8: {
                    return (int)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 7: {
                    return (int)FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth);
                }
                case 6: {
                    return FlexBuffers.readInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 5: {
                    return Integer.parseInt(this.asString());
                }
                case 3: {
                    return (int)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
                }
                case 2: {
                    return (int)FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
                }
                case 0: 
            }
            return 0;
        }

        public Key asKey() {
            if (this.isKey()) {
                return new Key(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }
            return Key.empty();
        }

        public long asLong() {
            if (this.type == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                default: {
                    return 0L;
                }
                case 26: {
                    return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                }
                case 10: {
                    return this.asVector().size();
                }
                case 8: {
                    return (long)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 7: {
                    return FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth);
                }
                case 6: {
                    return FlexBuffers.readLong(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 5: {
                    try {
                        long l = Long.parseLong(this.asString());
                        return l;
                    }
                    catch (NumberFormatException numberFormatException) {
                        return 0L;
                    }
                }
                case 3: {
                    return (long)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
                }
                case 2: {
                    return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
                }
                case 0: 
            }
            return 0L;
        }

        public Map asMap() {
            if (this.isMap()) {
                return new Map(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }
            return Map.empty();
        }

        public String asString() {
            if (this.isString()) {
                int n = FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                int n2 = (int)FlexBuffers.readUInt(this.bb, n - this.byteWidth, this.byteWidth);
                return this.bb.getString(n, n2);
            }
            if (this.isKey()) {
                int n;
                int n3 = n = FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
                while (true) {
                    if (this.bb.get(n3) == 0) {
                        return this.bb.getString(n, n3 - n);
                    }
                    ++n3;
                }
            }
            return "";
        }

        public long asUInt() {
            if (this.type == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            switch (this.type) {
                default: {
                    return 0L;
                }
                case 26: {
                    return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                }
                case 10: {
                    return this.asVector().size();
                }
                case 8: {
                    return (long)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth);
                }
                case 7: {
                    return FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 6: {
                    return FlexBuffers.readLong(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                }
                case 5: {
                    return Long.parseLong(this.asString());
                }
                case 3: {
                    return (long)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
                }
                case 1: {
                    return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
                }
                case 0: 
            }
            return 0L;
        }

        public Vector asVector() {
            if (this.isVector()) {
                return new Vector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }
            if (this.type == 15) {
                return new TypedVector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (FlexBuffers.isTypedVector(this.type)) {
                return new TypedVector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
            }
            return Vector.empty();
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            boolean bl = this.type == 25;
            return bl;
        }

        public boolean isBoolean() {
            boolean bl = this.type == 26;
            return bl;
        }

        public boolean isFloat() {
            boolean bl = this.type == 3 || this.type == 8;
            return bl;
        }

        public boolean isInt() {
            boolean bl;
            int n = this.type;
            boolean bl2 = bl = true;
            if (n != 1) {
                bl2 = this.type == 6 ? bl : false;
            }
            return bl2;
        }

        public boolean isIntOrUInt() {
            boolean bl = this.isInt() || this.isUInt();
            return bl;
        }

        public boolean isKey() {
            boolean bl = this.type == 4;
            return bl;
        }

        public boolean isMap() {
            boolean bl = this.type == 9;
            return bl;
        }

        public boolean isNull() {
            boolean bl = this.type == 0;
            return bl;
        }

        public boolean isNumeric() {
            boolean bl = this.isIntOrUInt() || this.isFloat();
            return bl;
        }

        public boolean isString() {
            boolean bl = this.type == 5;
            return bl;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            boolean bl = this.type == 2 || this.type == 7;
            return bl;
        }

        public boolean isVector() {
            boolean bl = this.type == 10 || this.type == 9;
            return bl;
        }

        public String toString() {
            return this.toString(new StringBuilder(128)).toString();
        }

        StringBuilder toString(StringBuilder stringBuilder) {
            switch (this.type) {
                default: {
                    return stringBuilder;
                }
                case 26: {
                    return stringBuilder.append(this.asBoolean());
                }
                case 25: {
                    return this.asBlob().toString(stringBuilder);
                }
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: {
                    throw new FlexBufferException("not_implemented:" + this.type);
                }
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 36: {
                    return stringBuilder.append(this.asVector());
                }
                case 10: {
                    return this.asVector().toString(stringBuilder);
                }
                case 9: {
                    return this.asMap().toString(stringBuilder);
                }
                case 5: {
                    return stringBuilder.append('\"').append(this.asString()).append('\"');
                }
                case 4: {
                    return this.asKey().toString(stringBuilder.append('\"')).append('\"');
                }
                case 3: 
                case 8: {
                    return stringBuilder.append(this.asFloat());
                }
                case 2: 
                case 7: {
                    return stringBuilder.append(this.asUInt());
                }
                case 1: 
                case 6: {
                    return stringBuilder.append(this.asLong());
                }
                case 0: 
            }
            return stringBuilder.append("null");
        }
    }

    private static abstract class Sized
    extends Object {
        protected final int size;

        Sized(ReadBuf readBuf, int n, int n2) {
            super(readBuf, n, n2);
            this.size = FlexBuffers.readInt(this.bb, n - n2, n2);
        }

        public int size() {
            return this.size;
        }
    }

    public static class TypedVector
    extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.access$000(), 1, 1, 1);
        private final int elemType;

        TypedVector(ReadBuf readBuf, int n, int n2, int n3) {
            super(readBuf, n, n2);
            this.elemType = n3;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override
        public Reference get(int n) {
            if (n >= this.size()) {
                return Reference.NULL_REFERENCE;
            }
            int n2 = this.end;
            int n3 = this.byteWidth;
            return new Reference(this.bb, n2 + n3 * n, this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            boolean bl = this == EMPTY_VECTOR;
            return bl;
        }
    }

    static class Unsigned {
        Unsigned() {
        }

        static int byteToUnsignedInt(byte by) {
            return by & 0xFF;
        }

        static long intToUnsignedLong(int n) {
            return (long)n & 0xFFFFFFFFL;
        }

        static int shortToUnsignedInt(short s) {
            return 0xFFFF & s;
        }
    }

    public static class Vector
    extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);

        Vector(ReadBuf readBuf, int n, int n2) {
            super(readBuf, n, n2);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int n) {
            long l = this.size();
            if ((long)n >= l) {
                return Reference.NULL_REFERENCE;
            }
            int n2 = Unsigned.byteToUnsignedInt(this.bb.get((int)((long)this.end + (long)this.byteWidth * l + (long)n)));
            int n3 = this.end;
            int n4 = this.byteWidth;
            return new Reference(this.bb, n3 + n4 * n, this.byteWidth, n2);
        }

        public boolean isEmpty() {
            boolean bl = this == EMPTY_VECTOR;
            return bl;
        }

        @Override
        public StringBuilder toString(StringBuilder stringBuilder) {
            stringBuilder.append("[ ");
            int n = this.size();
            for (int i = 0; i < n; ++i) {
                this.get(i).toString(stringBuilder);
                if (i == n - 1) continue;
                stringBuilder.append(", ");
            }
            stringBuilder.append(" ]");
            return stringBuilder;
        }
    }
}

