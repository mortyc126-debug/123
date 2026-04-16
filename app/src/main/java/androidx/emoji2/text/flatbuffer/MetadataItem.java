/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import androidx.emoji2.text.flatbuffer.Constants;
import androidx.emoji2.text.flatbuffer.FlatBufferBuilder;
import androidx.emoji2.text.flatbuffer.IntVector;
import androidx.emoji2.text.flatbuffer.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataItem
extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.addOffset(6, n, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(3, s, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean bl) {
        flatBufferBuilder.addBoolean(1, bl, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(5, s, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.addInt(0, n, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(2, s, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(4, s, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] nArray) {
        flatBufferBuilder.startVector(4, nArray.length, 4);
        for (int i = nArray.length - 1; i >= 0; --i) {
            flatBufferBuilder.addInt(nArray[i]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int n, boolean bl, short s, short s2, short s3, short s4, int n2) {
        flatBufferBuilder.startTable(7);
        MetadataItem.addCodepoints(flatBufferBuilder, n2);
        MetadataItem.addId(flatBufferBuilder, n);
        MetadataItem.addHeight(flatBufferBuilder, s4);
        MetadataItem.addWidth(flatBufferBuilder, s3);
        MetadataItem.addCompatAdded(flatBufferBuilder, s2);
        MetadataItem.addSdkAdded(flatBufferBuilder, s);
        MetadataItem.addEmojiStyle(flatBufferBuilder, bl);
        return MetadataItem.endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return MetadataItem.getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.startVector(4, n, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int n, ByteBuffer byteBuffer) {
        this.__init(n, byteBuffer);
        return this;
    }

    public void __init(int n, ByteBuffer byteBuffer) {
        this.__reset(n, byteBuffer);
    }

    public int codepoints(int n) {
        int n2 = this.__offset(16);
        n = n2 != 0 ? this.bb.getInt(this.__vector(n2) + n * 4) : 0;
        return n;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return this.__vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return this.__vector_in_bytebuffer(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int n = this.__offset(16);
        n = n != 0 ? this.__vector_len(n) : 0;
        return n;
    }

    public IntVector codepointsVector() {
        return this.codepointsVector(new IntVector());
    }

    public IntVector codepointsVector(IntVector intVector) {
        int n = this.__offset(16);
        intVector = n != 0 ? intVector.__assign(this.__vector(n), this.bb) : null;
        return intVector;
    }

    public short compatAdded() {
        int n = this.__offset(10);
        short s = n != 0 ? this.bb.getShort(this.bb_pos + n) : (short)0;
        return s;
    }

    public boolean emojiStyle() {
        boolean bl;
        int n = this.__offset(6);
        boolean bl2 = bl = false;
        if (n != 0) {
            bl2 = bl;
            if (this.bb.get(this.bb_pos + n) != 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public short height() {
        int n = this.__offset(14);
        short s = n != 0 ? this.bb.getShort(this.bb_pos + n) : (short)0;
        return s;
    }

    public int id() {
        int n = this.__offset(4);
        n = n != 0 ? this.bb.getInt(this.bb_pos + n) : 0;
        return n;
    }

    public short sdkAdded() {
        int n = this.__offset(8);
        short s = n != 0 ? this.bb.getShort(this.bb_pos + n) : (short)0;
        return s;
    }

    public short width() {
        int n = this.__offset(12);
        short s = n != 0 ? this.bb.getShort(this.bb_pos + n) : (short)0;
        return s;
    }

    public static final class Vector
    extends BaseVector {
        public Vector __assign(int n, int n2, ByteBuffer byteBuffer) {
            this.__reset(n, n2, byteBuffer);
            return this;
        }

        public MetadataItem get(int n) {
            return this.get(new MetadataItem(), n);
        }

        public MetadataItem get(MetadataItem metadataItem, int n) {
            return metadataItem.__assign(MetadataItem.__indirect(this.__element(n), this.bb), this.bb);
        }
    }
}

