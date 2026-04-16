/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8Safe;
import java.nio.ByteBuffer;

public abstract class Utf8 {
    private static Utf8 DEFAULT;

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer var1, int var2, int var3);

    public abstract void encodeUtf8(CharSequence var1, ByteBuffer var2);

    public abstract int encodedLength(CharSequence var1);

    static class DecodeUtil {
        DecodeUtil() {
        }

        static void handleFourBytes(byte by, byte by2, byte by3, byte by4, char[] cArray, int n) throws IllegalArgumentException {
            if (!(DecodeUtil.isNotTrailingByte(by2) || (by << 28) + (by2 + 112) >> 30 != 0 || DecodeUtil.isNotTrailingByte(by3) || DecodeUtil.isNotTrailingByte(by4))) {
                by = (byte)((by & 7) << 18 | DecodeUtil.trailingByteValue(by2) << 12 | DecodeUtil.trailingByteValue(by3) << 6 | DecodeUtil.trailingByteValue(by4));
                cArray[n] = DecodeUtil.highSurrogate(by);
                cArray[n + 1] = DecodeUtil.lowSurrogate(by);
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleOneByte(byte by, char[] cArray, int n) {
            cArray[n] = (char)by;
        }

        static void handleThreeBytes(byte by, byte by2, byte by3, char[] cArray, int n) throws IllegalArgumentException {
            if (!(DecodeUtil.isNotTrailingByte(by2) || by == -32 && by2 < -96 || by == -19 && by2 >= -96 || DecodeUtil.isNotTrailingByte(by3))) {
                cArray[n] = (char)((by & 0xF) << 12 | DecodeUtil.trailingByteValue(by2) << 6 | DecodeUtil.trailingByteValue(by3));
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleTwoBytes(byte by, byte by2, char[] cArray, int n) throws IllegalArgumentException {
            if (by >= -62) {
                if (!DecodeUtil.isNotTrailingByte(by2)) {
                    cArray[n] = (char)((by & 0x1F) << 6 | DecodeUtil.trailingByteValue(by2));
                    return;
                }
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        private static char highSurrogate(int n) {
            return (char)((n >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte by) {
            boolean bl = by > -65;
            return bl;
        }

        static boolean isOneByte(byte by) {
            boolean bl = by >= 0;
            return bl;
        }

        static boolean isThreeBytes(byte by) {
            boolean bl = by < -16;
            return bl;
        }

        static boolean isTwoBytes(byte by) {
            boolean bl = by < -32;
            return bl;
        }

        private static char lowSurrogate(int n) {
            return (char)((n & 0x3FF) + 56320);
        }

        private static int trailingByteValue(byte by) {
            return by & 0x3F;
        }
    }

    static class UnpairedSurrogateException
    extends IllegalArgumentException {
        UnpairedSurrogateException(int n, int n2) {
            super("Unpaired surrogate at index " + n + " of " + n2);
        }
    }
}

