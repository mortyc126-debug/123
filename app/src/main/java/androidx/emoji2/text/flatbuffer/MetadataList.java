/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.BaseVector;
import androidx.emoji2.text.flatbuffer.Constants;
import androidx.emoji2.text.flatbuffer.FlatBufferBuilder;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList
extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addList(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.addOffset(1, n, 0);
    }

    public static void addSourceSha(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.addOffset(2, n, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.addInt(0, n, 0);
    }

    public static int createListVector(FlatBufferBuilder flatBufferBuilder, int[] nArray) {
        flatBufferBuilder.startVector(4, nArray.length, 4);
        for (int i = nArray.length - 1; i >= 0; --i) {
            flatBufferBuilder.addOffset(nArray[i]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder flatBufferBuilder, int n, int n2, int n3) {
        flatBufferBuilder.startTable(3);
        MetadataList.addSourceSha(flatBufferBuilder, n3);
        MetadataList.addList(flatBufferBuilder, n2);
        MetadataList.addVersion(flatBufferBuilder, n);
        return MetadataList.endMetadataList(flatBufferBuilder);
    }

    public static int endMetadataList(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.finish(n);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.finishSizePrefixed(n);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer) {
        return MetadataList.getRootAsMetadataList(byteBuffer, new MetadataList());
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void startListVector(FlatBufferBuilder flatBufferBuilder, int n) {
        flatBufferBuilder.startVector(4, n, 4);
    }

    public static void startMetadataList(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public MetadataList __assign(int n, ByteBuffer byteBuffer) {
        this.__init(n, byteBuffer);
        return this;
    }

    public void __init(int n, ByteBuffer byteBuffer) {
        this.__reset(n, byteBuffer);
    }

    public MetadataItem list(int n) {
        return this.list(new MetadataItem(), n);
    }

    public MetadataItem list(MetadataItem metadataItem, int n) {
        int n2 = this.__offset(6);
        metadataItem = n2 != 0 ? metadataItem.__assign(this.__indirect(this.__vector(n2) + n * 4), this.bb) : null;
        return metadataItem;
    }

    public int listLength() {
        int n = this.__offset(6);
        n = n != 0 ? this.__vector_len(n) : 0;
        return n;
    }

    public MetadataItem.Vector listVector() {
        return this.listVector(new MetadataItem.Vector());
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector vector) {
        int n = this.__offset(6);
        vector = n != 0 ? vector.__assign(this.__vector(n), 4, this.bb) : null;
        return vector;
    }

    public String sourceSha() {
        int n = this.__offset(8);
        String string2 = n != 0 ? this.__string(this.bb_pos + n) : null;
        return string2;
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return this.__vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer byteBuffer) {
        return this.__vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public int version() {
        int n = this.__offset(4);
        n = n != 0 ? this.bb.getInt(this.bb_pos + n) : 0;
        return n;
    }

    public static final class Vector
    extends BaseVector {
        public Vector __assign(int n, int n2, ByteBuffer byteBuffer) {
            this.__reset(n, n2, byteBuffer);
            return this;
        }

        public MetadataList get(int n) {
            return this.get(new MetadataList(), n);
        }

        public MetadataList get(MetadataList metadataList, int n) {
            return metadataList.__assign(MetadataList.__indirect(this.__element(n), this.bb), this.bb);
        }
    }
}

