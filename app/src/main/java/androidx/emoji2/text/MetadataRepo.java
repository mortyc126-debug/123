/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.util.SparseArray
 */
package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiMetadata;
import androidx.emoji2.text.MetadataListReader;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode;
    private final Typeface mTypeface;

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[this.mMetadataList.listLength() * 2];
        this.constructIndex(this.mMetadataList);
    }

    private void constructIndex(MetadataList object) {
        int n = ((MetadataList)object).listLength();
        for (int i = 0; i < n; ++i) {
            object = new EmojiMetadata(this, i);
            Character.toChars(((EmojiMetadata)object).getId(), this.mEmojiCharArray, i * 2);
            this.put((EmojiMetadata)object);
        }
    }

    public static MetadataRepo create(AssetManager object, String string2) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            object = new MetadataRepo(Typeface.createFromAsset((AssetManager)object, (String)string2), MetadataListReader.read(object, string2));
            return object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(Typeface object) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            MetadataList metadataList = new MetadataList();
            object = new MetadataRepo((Typeface)object, metadataList);
            return object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(Typeface object, InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            object = new MetadataRepo((Typeface)object, MetadataListReader.read(inputStream));
            return object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(Typeface object, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            object = new MetadataRepo((Typeface)object, MetadataListReader.read(byteBuffer));
            return object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    Node getRootNode() {
        return this.mRootNode;
    }

    Typeface getTypeface() {
        return this.mTypeface;
    }

    void put(EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "emoji metadata cannot be null");
        boolean bl = emojiMetadata.getCodepointsLength() > 0;
        Preconditions.checkArgument(bl, "invalid metadata codepoint length");
        this.mRootNode.put(emojiMetadata, 0, emojiMetadata.getCodepointsLength() - 1);
    }

    static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        Node(int n) {
            this.mChildren = new SparseArray(n);
        }

        Node get(int n) {
            Node node = this.mChildren == null ? null : (Node)this.mChildren.get(n);
            return node;
        }

        final EmojiMetadata getData() {
            return this.mData;
        }

        void put(EmojiMetadata emojiMetadata, int n, int n2) {
            Node node;
            Node node2 = node = this.get(emojiMetadata.getCodepointAt(n));
            if (node == null) {
                node2 = new Node();
                this.mChildren.put(emojiMetadata.getCodepointAt(n), (Object)node2);
            }
            if (n2 > n) {
                node2.put(emojiMetadata, n + 1, n2);
            } else {
                node2.mData = emojiMetadata;
            }
        }
    }
}

