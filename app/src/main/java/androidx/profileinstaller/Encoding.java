/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    static int bitsToBytes(int n) {
        return (n + 8 - 1 & 0xFFFFFFF8) / 8;
    }

    /*
     * Exception decompiling
     */
    static byte[] compress(byte[] var0) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    static RuntimeException error(String string2) {
        return new IllegalStateException(string2);
    }

    static byte[] read(InputStream inputStream, int n) throws IOException {
        int n2;
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; i += n2) {
            n2 = inputStream.read(byArray, i, n - i);
            if (n2 >= 0) {
                continue;
            }
            throw Encoding.error("Not enough bytes to read: " + n);
        }
        return byArray;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static byte[] readCompressed(InputStream object, int n, int n2) throws IOException {
        int n3;
        Inflater inflater = new Inflater();
        try {
            int n4;
            int n5;
            byte[] byArray = new byte[n2];
            int n6 = 0;
            byte[] byArray2 = new byte[2048];
            for (n3 = 0; !inflater.finished() && !inflater.needsDictionary() && n3 < n; n6 += n5, n3 += n4) {
                n4 = ((InputStream)object).read(byArray2);
                if (n4 < 0) {
                    object = new StringBuilder();
                    throw Encoding.error(((StringBuilder)object).append("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected ").append(n).append(" bytes").toString());
                }
                inflater.setInput(byArray2, 0, n4);
                try {
                    n5 = inflater.inflate(byArray, n6, n2 - n6);
                    continue;
                }
                catch (DataFormatException dataFormatException) {
                    throw Encoding.error(dataFormatException.getMessage());
                }
            }
            if (n3 == n) {
                boolean bl = inflater.finished();
                if (!bl) throw Encoding.error("Inflater did not finish");
                inflater.end();
                return byArray;
            }
        }
        catch (Throwable throwable) {
            inflater.end();
            throw throwable;
        }
        {
            object = new StringBuilder();
            throw Encoding.error(((StringBuilder)object).append("Didn't read enough bytes during decompression. expected=").append(n).append(" actual=").append(n3).toString());
        }
    }

    static String readString(InputStream inputStream, int n) throws IOException {
        return new String(Encoding.read(inputStream, n), StandardCharsets.UTF_8);
    }

    static long readUInt(InputStream object, int n) throws IOException {
        object = Encoding.read((InputStream)object, n);
        long l = 0L;
        for (int i = 0; i < n; ++i) {
            l += (long)(object[i] & 0xFF) << i * 8;
        }
        return l;
    }

    static int readUInt16(InputStream inputStream) throws IOException {
        return (int)Encoding.readUInt(inputStream, 2);
    }

    static long readUInt32(InputStream inputStream) throws IOException {
        return Encoding.readUInt(inputStream, 4);
    }

    static int readUInt8(InputStream inputStream) throws IOException {
        return (int)Encoding.readUInt(inputStream, 1);
    }

    static int utf8Length(String string2) {
        return string2.getBytes(StandardCharsets.UTF_8).length;
    }

    static void writeAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        int n;
        byte[] byArray = new byte[512];
        while ((n = inputStream.read(byArray)) > 0) {
            outputStream.write(byArray, 0, n);
        }
    }

    static void writeCompressed(OutputStream outputStream, byte[] byArray) throws IOException {
        Encoding.writeUInt32(outputStream, byArray.length);
        byArray = Encoding.compress(byArray);
        Encoding.writeUInt32(outputStream, byArray.length);
        outputStream.write(byArray);
    }

    static void writeString(OutputStream outputStream, String string2) throws IOException {
        outputStream.write(string2.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(OutputStream outputStream, long l, int n) throws IOException {
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; ++i) {
            byArray[i] = (byte)(l >> i * 8 & 0xFFL);
        }
        outputStream.write(byArray);
    }

    static void writeUInt16(OutputStream outputStream, int n) throws IOException {
        Encoding.writeUInt(outputStream, n, 2);
    }

    static void writeUInt32(OutputStream outputStream, long l) throws IOException {
        Encoding.writeUInt(outputStream, l, 4);
    }

    static void writeUInt8(OutputStream outputStream, int n) throws IOException {
        Encoding.writeUInt(outputStream, n, 1);
    }
}

