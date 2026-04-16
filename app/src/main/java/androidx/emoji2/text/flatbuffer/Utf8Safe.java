/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

public final class Utf8Safe
extends Utf8 {
    private static int computeEncodedLength(CharSequence charSequence) {
        int n;
        int n2;
        block3: {
            int n3;
            int n4;
            int n5 = n2 = charSequence.length();
            n = 0;
            while (true) {
                n4 = n5;
                n3 = n;
                if (n >= n2) break;
                n4 = n5;
                n3 = n;
                if (charSequence.charAt(n) >= '\u0080') break;
                ++n;
            }
            while (true) {
                n = n4;
                if (n3 >= n2) break block3;
                n = charSequence.charAt(n3);
                if (n >= 2048) break;
                n4 += 127 - n >>> 31;
                ++n3;
            }
            n = n4 + Utf8Safe.encodedLengthGeneral(charSequence, n3);
        }
        if (n >= n2) {
            return n;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + ((long)n + 0x100000000L));
    }

    public static String decodeUtf8Array(byte[] byArray, int n, int n2) {
        if ((n | n2 | byArray.length - n - n2) >= 0) {
            byte by;
            int n3 = n + n2;
            char[] cArray = new char[n2];
            n2 = 0;
            while (n < n3 && Utf8.DecodeUtil.isOneByte(by = byArray[n])) {
                ++n;
                Utf8.DecodeUtil.handleOneByte(by, cArray, n2);
                ++n2;
            }
            while (n < n3) {
                int n4 = n + 1;
                by = byArray[n];
                if (Utf8.DecodeUtil.isOneByte(by)) {
                    n = n2 + 1;
                    Utf8.DecodeUtil.handleOneByte(by, cArray, n2);
                    n2 = n4;
                    while (n2 < n3 && Utf8.DecodeUtil.isOneByte(by = byArray[n2])) {
                        ++n2;
                        Utf8.DecodeUtil.handleOneByte(by, cArray, n);
                        ++n;
                    }
                    n4 = n2;
                    n2 = n;
                    n = n4;
                    continue;
                }
                if (Utf8.DecodeUtil.isTwoBytes(by)) {
                    if (n4 < n3) {
                        Utf8.DecodeUtil.handleTwoBytes(by, byArray[n4], cArray, n2);
                        n = n4 + 1;
                        ++n2;
                        continue;
                    }
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                if (Utf8.DecodeUtil.isThreeBytes(by)) {
                    if (n4 < n3 - 1) {
                        n = n4 + 1;
                        Utf8.DecodeUtil.handleThreeBytes(by, byArray[n4], byArray[n], cArray, n2);
                        ++n;
                        ++n2;
                        continue;
                    }
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                if (n4 < n3 - 2) {
                    n = n4 + 1;
                    byte by2 = byArray[n4];
                    n4 = n + 1;
                    Utf8.DecodeUtil.handleFourBytes(by, by2, byArray[n], byArray[n4], cArray, n2);
                    n = n4 + 1;
                    n2 = n2 + 1 + 1;
                    continue;
                }
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            return new String(cArray, 0, n2);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", byArray.length, n, n2));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int n, int n2) {
        if ((n | n2 | byteBuffer.limit() - n - n2) >= 0) {
            byte by;
            int n3 = n + n2;
            char[] cArray = new char[n2];
            n2 = 0;
            while (n < n3 && Utf8.DecodeUtil.isOneByte(by = byteBuffer.get(n))) {
                ++n;
                Utf8.DecodeUtil.handleOneByte(by, cArray, n2);
                ++n2;
            }
            int n4 = n2;
            n2 = n;
            n = n4;
            while (n2 < n3) {
                n4 = n2 + 1;
                by = byteBuffer.get(n2);
                if (Utf8.DecodeUtil.isOneByte(by)) {
                    n2 = n + 1;
                    Utf8.DecodeUtil.handleOneByte(by, cArray, n);
                    n = n2;
                    n2 = n4;
                    while (n2 < n3 && Utf8.DecodeUtil.isOneByte(by = byteBuffer.get(n2))) {
                        ++n2;
                        Utf8.DecodeUtil.handleOneByte(by, cArray, n);
                        ++n;
                    }
                    continue;
                }
                if (Utf8.DecodeUtil.isTwoBytes(by)) {
                    if (n4 < n3) {
                        Utf8.DecodeUtil.handleTwoBytes(by, byteBuffer.get(n4), cArray, n);
                        n2 = n4 + 1;
                        ++n;
                        continue;
                    }
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                if (Utf8.DecodeUtil.isThreeBytes(by)) {
                    if (n4 < n3 - 1) {
                        n2 = n4 + 1;
                        Utf8.DecodeUtil.handleThreeBytes(by, byteBuffer.get(n4), byteBuffer.get(n2), cArray, n);
                        ++n2;
                        ++n;
                        continue;
                    }
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                if (n4 < n3 - 2) {
                    n2 = n4 + 1;
                    byte by2 = byteBuffer.get(n4);
                    n4 = n2 + 1;
                    Utf8.DecodeUtil.handleFourBytes(by, by2, byteBuffer.get(n2), byteBuffer.get(n4), cArray, n);
                    n2 = n4 + 1;
                    n = n + 1 + 1;
                    continue;
                }
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            return new String(cArray, 0, n);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", byteBuffer.limit(), n, n2));
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] byArray, int n, int n2) {
        int n3 = charSequence.length();
        int n4 = 0;
        int n5 = n + n2;
        for (n2 = n4; n2 < n3 && n2 + n < n5 && (n4 = (int)charSequence.charAt(n2)) < 128; ++n2) {
            byArray[n + n2] = (byte)n4;
        }
        if (n2 == n3) {
            return n + n3;
        }
        n += n2;
        while (n2 < n3) {
            char c;
            block11: {
                block12: {
                    block8: {
                        block10: {
                            block9: {
                                block7: {
                                    c = charSequence.charAt(n2);
                                    if (c >= '\u0080' || n >= n5) break block7;
                                    byArray[n] = (byte)c;
                                    ++n;
                                    break block8;
                                }
                                if (c >= '\u0800' || n > n5 - 2) break block9;
                                n4 = n + 1;
                                byArray[n] = (byte)(c >>> 6 | 0x3C0);
                                n = n4 + 1;
                                byArray[n4] = (byte)(c & 0x3F | 0x80);
                                break block8;
                            }
                            if (c >= '\ud800' && '\udfff' >= c || n > n5 - 3) break block10;
                            n4 = n + 1;
                            byArray[n] = (byte)(c >>> 12 | 0x1E0);
                            n = n4 + 1;
                            byArray[n4] = (byte)(c >>> 6 & 0x3F | 0x80);
                            byArray[n] = (byte)(c & 0x3F | 0x80);
                            ++n;
                            break block8;
                        }
                        if (n > n5 - 4) break block11;
                        n4 = n2;
                        if (n2 + 1 == charSequence.length()) break block12;
                        char c2 = charSequence.charAt(++n2);
                        n4 = n2;
                        if (!Character.isSurrogatePair(c, c2)) break block12;
                        n4 = Character.toCodePoint(c, c2);
                        int n6 = n + 1;
                        byArray[n] = (byte)(n4 >>> 18 | 0xF0);
                        n = n6 + 1;
                        byArray[n6] = (byte)(n4 >>> 12 & 0x3F | 0x80);
                        n6 = n + 1;
                        byArray[n] = (byte)(n4 >>> 6 & 0x3F | 0x80);
                        n = n6 + 1;
                        byArray[n6] = (byte)(n4 & 0x3F | 0x80);
                    }
                    ++n2;
                    continue;
                }
                throw new UnpairedSurrogateException(n4 - 1, n3);
            }
            if (!('\ud800' > c || c > '\udfff' || n2 + 1 != charSequence.length() && Character.isSurrogatePair(c, charSequence.charAt(n2 + 1)))) {
                throw new UnpairedSurrogateException(n2, n3);
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + c + " at index " + n);
        }
        return n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void encodeUtf8Buffer(CharSequence var0, ByteBuffer var1_1) {
        block21: {
            var10_2 = var0.length();
            var8_3 = var1_1.position();
            for (var5_4 = 0; var5_4 < var10_2; ++var5_4) {
                var7_6 = var8_3;
                var6_5 = var5_4;
                var9_7 = var0.charAt(var5_4);
                if (var9_7 >= 128) break;
                var7_6 = var8_3;
                var6_5 = var5_4;
                var1_1.put(var8_3 + var5_4, (byte)var9_7);
                continue;
            }
            if (var5_4 != var10_2) ** GOTO lbl21
            var7_6 = var8_3;
            var6_5 = var5_4;
            try {
                var1_1.position(var8_3 + var5_4);
                return;
lbl21:
                // 1 sources

                var8_3 += var5_4;
            }
            catch (IndexOutOfBoundsException var12_8) {
                var5_4 = var6_5;
                break block21;
            }
            while (var5_4 < var10_2) {
                block22: {
                    var7_6 = var8_3;
                    var6_5 = var5_4;
                    var3_13 = var0.charAt(var5_4);
                    if (var3_13 < '\u0080') {
                        var7_6 = var8_3;
                        var6_5 = var5_4;
                        var1_1.put(var8_3, (byte)var3_13);
                    } else {
                        if (var3_13 < '\u0800') {
                            var7_6 = var8_3 + 1;
                            var2_12 = (byte)(var3_13 >>> 6 | 192);
                            var6_5 = var7_6;
                            var1_1.put(var8_3, var2_12);
                            var6_5 = var7_6;
                            var1_1.put(var7_6, (byte)(var3_13 & 63 | 128));
                            var8_3 = var7_6;
                            break block22;
                        }
                        if (var3_13 >= '\ud800' && '\udfff' >= var3_13) {
                            block23: {
                                var9_7 = var5_4;
                                if (var5_4 + 1 != var10_2) {
                                    var7_6 = var8_3;
                                    var6_5 = ++var5_4;
                                    {
                                        var4_14 = var0.charAt(var5_4);
                                        var7_6 = var8_3;
                                        var6_5 = var5_4;
                                        var9_7 = var5_4;
                                        if (!Character.isSurrogatePair(var3_13, var4_14)) break block23;
                                        var7_6 = var8_3;
                                        var6_5 = var5_4;
                                        var11_15 = Character.toCodePoint(var3_13, var4_14);
                                        var9_7 = var8_3 + 1;
                                    }
                                    var2_12 = (byte)(var11_15 >>> 18 | 240);
                                    var6_5 = var9_7;
                                    try {
                                        var1_1.put(var8_3, var2_12);
                                        var8_3 = var9_7 + 1;
                                    }
                                    catch (IndexOutOfBoundsException var12_10) {
                                        var7_6 = var6_5;
                                        break block21;
                                    }
                                    var2_12 = (byte)(var11_15 >>> 12 & 63 | 128);
                                    var7_6 = var8_3;
                                    var6_5 = var5_4;
                                    {
                                        var1_1.put(var9_7, var2_12);
                                        var7_6 = var8_3 + 1;
                                    }
                                    var2_12 = (byte)(var11_15 >>> 6 & 63 | 128);
                                    var6_5 = var7_6;
                                    var1_1.put(var8_3, var2_12);
                                    var6_5 = var7_6;
                                    var1_1.put(var7_6, (byte)(var11_15 & 63 | 128));
                                    var8_3 = var7_6;
                                    break block22;
                                }
                            }
                            var7_6 = var8_3;
                            var6_5 = var9_7;
                            {
                                var7_6 = var8_3;
                                var6_5 = var9_7;
                                var12_11 = new UnpairedSurrogateException(var9_7, var10_2);
                                var7_6 = var8_3;
                                var6_5 = var9_7;
                                throw var12_11;
                            }
                        }
                        var9_7 = var8_3 + 1;
                        var2_12 = (byte)(var3_13 >>> 12 | 224);
                        var6_5 = var9_7;
                        try {
                            var1_1.put(var8_3, var2_12);
                            var8_3 = var9_7 + 1;
                        }
                        catch (IndexOutOfBoundsException var12_9) {
                            var7_6 = var6_5;
                            break block21;
                        }
                        var2_12 = (byte)(var3_13 >>> 6 & 63 | 128);
                        var7_6 = var8_3;
                        var6_5 = var5_4;
                        {
                            var1_1.put(var9_7, var2_12);
                            var7_6 = var8_3;
                            var6_5 = var5_4;
                            var1_1.put(var8_3, (byte)(var3_13 & 63 | 128));
                        }
                    }
                }
                ++var5_4;
                ++var8_3;
            }
            var7_6 = var8_3;
            var6_5 = var5_4;
            {
                var1_1.position(var8_3);
                return;
            }
        }
        var6_5 = var1_1.position();
        var7_6 = Math.max(var5_4, var7_6 - var1_1.position() + 1);
        throw new ArrayIndexOutOfBoundsException("Failed writing " + var0.charAt(var5_4) + " at index " + (var6_5 + var7_6));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int n) {
        int n2 = charSequence.length();
        int n3 = 0;
        while (n < n2) {
            int n4;
            char c = charSequence.charAt(n);
            if (c < '\u0800') {
                n3 += 127 - c >>> 31;
                n4 = n;
            } else {
                int n5;
                n3 = n5 = n3 + 2;
                n4 = n;
                if ('\ud800' <= c) {
                    n3 = n5;
                    n4 = n;
                    if (c <= '\udfff') {
                        if (Character.codePointAt(charSequence, n) >= 65536) {
                            n4 = n + 1;
                            n3 = n5;
                        } else {
                            throw new UnpairedSurrogateException(n, n2);
                        }
                    }
                }
            }
            n = n4 + 1;
        }
        return n3;
    }

    @Override
    public String decodeUtf8(ByteBuffer byteBuffer, int n, int n2) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return Utf8Safe.decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + n, n2);
        }
        return Utf8Safe.decodeUtf8Buffer(byteBuffer, n, n2);
    }

    @Override
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int n = byteBuffer.arrayOffset();
            byteBuffer.position(Utf8Safe.encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + n, byteBuffer.remaining()) - n);
        } else {
            Utf8Safe.encodeUtf8Buffer(charSequence, byteBuffer);
        }
    }

    @Override
    public int encodedLength(CharSequence charSequence) {
        return Utf8Safe.computeEncodedLength(charSequence);
    }

    static class UnpairedSurrogateException
    extends IllegalArgumentException {
        UnpairedSurrogateException(int n, int n2) {
            super("Unpaired surrogate at index " + n + " of " + n2);
        }
    }
}

