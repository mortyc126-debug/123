/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    private MetadataListReader() {
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader openTypeReader) throws IOException {
        openTypeReader.skip(4);
        int n = openTypeReader.readUnsignedShort();
        if (n <= 100) {
            long l;
            openTypeReader.skip(6);
            long l2 = -1L;
            int n2 = 0;
            while (true) {
                l = l2;
                if (n2 >= n) break;
                int n3 = openTypeReader.readTag();
                openTypeReader.skip(4);
                l = openTypeReader.readUnsignedInt();
                openTypeReader.skip(4);
                if (1835365473 == n3) break;
                ++n2;
            }
            if (l != -1L) {
                openTypeReader.skip((int)(l - openTypeReader.getPosition()));
                openTypeReader.skip(12);
                l2 = openTypeReader.readUnsignedInt();
                n2 = 0;
                while ((long)n2 < l2) {
                    n = openTypeReader.readTag();
                    long l3 = openTypeReader.readUnsignedInt();
                    long l4 = openTypeReader.readUnsignedInt();
                    if (1164798569 != n && 1701669481 != n) {
                        ++n2;
                        continue;
                    }
                    return new OffsetInfo(l3 + l, l4);
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList read(AssetManager object, String object2) throws IOException {
        object = object.open((String)object2);
        try {
            object2 = MetadataListReader.read((InputStream)object);
            return object2;
        }
        finally {
            if (object != null) {
                ((InputStream)object).close();
            }
        }
    }

    static MetadataList read(InputStream inputStream) throws IOException {
        Object object = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo offsetInfo = MetadataListReader.findOffsetInfo((OpenTypeReader)object);
        object.skip((int)(offsetInfo.getStartOffset() - object.getPosition()));
        object = ByteBuffer.allocate((int)offsetInfo.getLength());
        int n = inputStream.read(((ByteBuffer)object).array());
        if ((long)n == offsetInfo.getLength()) {
            return MetadataList.getRootAsMetadataList((ByteBuffer)object);
        }
        throw new IOException("Needed " + offsetInfo.getLength() + " bytes, got " + n);
    }

    static MetadataList read(ByteBuffer byteBuffer) throws IOException {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.position((int)MetadataListReader.findOffsetInfo(new ByteBufferReader(byteBuffer)).getStartOffset());
        return MetadataList.getRootAsMetadataList(byteBuffer);
    }

    static long toUnsignedInt(int n) {
        return (long)n & 0xFFFFFFFFL;
    }

    static int toUnsignedShort(short s) {
        return 0xFFFF & s;
    }

    private static class ByteBufferReader
    implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            this.mByteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override
        public long getPosition() {
            return this.mByteBuffer.position();
        }

        @Override
        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        @Override
        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override
        public void skip(int n) throws IOException {
            this.mByteBuffer.position(this.mByteBuffer.position() + n);
        }
    }

    private static class InputStreamOpenTypeReader
    implements OpenTypeReader {
        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition = 0L;

        InputStreamOpenTypeReader(InputStream inputStream) {
            this.mInputStream = inputStream;
            this.mByteArray = new byte[4];
            this.mByteBuffer = ByteBuffer.wrap(this.mByteArray);
            this.mByteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(int n) throws IOException {
            if (this.mInputStream.read(this.mByteArray, 0, n) == n) {
                this.mPosition += (long)n;
                return;
            }
            throw new IOException("read failed");
        }

        @Override
        public long getPosition() {
            return this.mPosition;
        }

        @Override
        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            this.read(4);
            return this.mByteBuffer.getInt();
        }

        @Override
        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            this.read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override
        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            this.read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override
        public void skip(int n) throws IOException {
            while (n > 0) {
                int n2 = (int)this.mInputStream.skip(n);
                if (n2 >= 1) {
                    n -= n2;
                    this.mPosition += (long)n2;
                    continue;
                }
                throw new IOException("Skip didn't move at least 1 byte forward");
            }
        }
    }

    private static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long l, long l2) {
            this.mStartOffset = l;
            this.mLength = l2;
        }

        long getLength() {
            return this.mLength;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }
    }

    private static interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        public long getPosition();

        public int readTag() throws IOException;

        public long readUnsignedInt() throws IOException;

        public int readUnsignedShort() throws IOException;

        public void skip(int var1) throws IOException;
    }
}

