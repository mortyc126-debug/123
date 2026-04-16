/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AudioUtils {
    public static byte[] addWavHeader(byte[] byArray, int n, int n2, int n3) throws IOException {
        long l = byArray.length;
        long l2 = n * n2 * n3 / 8;
        byte[] byArray2 = AudioUtils.wavFileHeader(l, l + 36L, n, n2, l2, (byte)n3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(byArray2);
        byteArrayOutputStream.write(byArray);
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] wavFileHeader(long l, long l2, long l3, int n, long l4, byte by) {
        return new byte[]{82, 73, 70, 70, (byte)(l2 & 0xFFL), (byte)(l2 >> 8 & 0xFFL), (byte)(l2 >> 16 & 0xFFL), (byte)(l2 >> 24 & 0xFFL), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte)n, 0, (byte)(l3 & 0xFFL), (byte)(l3 >> 8 & 0xFFL), (byte)(l3 >> 16 & 0xFFL), (byte)(l3 >> 24 & 0xFFL), (byte)(l4 & 0xFFL), (byte)(l4 >> 8 & 0xFFL), (byte)(l4 >> 16 & 0xFFL), (byte)(l4 >> 24 & 0xFFL), (byte)(by / 8 * n), 0, by, 0, 100, 97, 116, 97, (byte)(l & 0xFFL), (byte)(l >> 8 & 0xFFL), (byte)(l >> 16 & 0xFFL), (byte)(l >> 24 & 0xFFL)};
    }
}

