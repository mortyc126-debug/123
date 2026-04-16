package okio;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.HttpUrl;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", HttpUrl.FRAGMENT_ENCODE_SET, "trie", HttpUrl.FRAGMENT_ENCODE_SET, "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", HttpUrl.FRAGMENT_ENCODE_SET, "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = m.g)
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    public static final Options of(ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof ByteString) {
            return contains((ByteString) element);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString element) {
        return super.contains(element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof ByteString) {
            return indexOf((ByteString) element);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString element) {
        return super.indexOf(element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof ByteString) {
            return lastIndexOf((ByteString) element);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString element) {
        return super.lastIndexOf(element);
    }

    /* JADX INFO: renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    /* JADX INFO: renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    private Options(ByteString[] byteStrings, int[] trie) {
        this.byteStrings = byteStrings;
        this.trie = trie;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    /* JADX INFO: compiled from: Options.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "intCount", HttpUrl.FRAGMENT_ENCODE_SET, "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", HttpUrl.FRAGMENT_ENCODE_SET, "nodeOffset", "node", "byteStringOffset", HttpUrl.FRAGMENT_ENCODE_SET, "byteStrings", HttpUrl.FRAGMENT_ENCODE_SET, "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", HttpUrl.FRAGMENT_ENCODE_SET, "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 9, 0}, xi = m.g)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0110, code lost:
        
            continue;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(okio.ByteString... r22) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j2, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) throws IOException {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j2, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) throws IOException {
            int fromIndex2;
            ByteString from;
            int prefixIndex;
            ByteString from2;
            ByteString to;
            int rangeEnd;
            int selectChoiceCount;
            int prefixIndex2;
            ByteString from3;
            int fromIndex3;
            ByteString to2;
            List<? extends ByteString> list = byteStrings;
            List<Integer> list2 = indexes;
            if (!(fromIndex < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i = fromIndex; i < toIndex; i++) {
                if (!(list.get(i).size() >= byteStringOffset)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString from4 = list.get(fromIndex);
            ByteString to3 = list.get(toIndex - 1);
            if (byteStringOffset != from4.size()) {
                fromIndex2 = fromIndex;
                from = from4;
                prefixIndex = -1;
            } else {
                int prefixIndex3 = list2.get(fromIndex).intValue();
                int fromIndex4 = fromIndex + 1;
                fromIndex2 = fromIndex4;
                from = list.get(fromIndex4);
                prefixIndex = prefixIndex3;
            }
            if (from.getByte(byteStringOffset) != to3.getByte(byteStringOffset)) {
                int selectChoiceCount2 = 1;
                for (int i2 = fromIndex2 + 1; i2 < toIndex; i2++) {
                    if (list.get(i2 - 1).getByte(byteStringOffset) != list.get(i2).getByte(byteStringOffset)) {
                        selectChoiceCount2++;
                    }
                }
                ByteString to4 = to3;
                long childNodesOffset = nodeOffset + getIntCount(node) + ((long) 2) + ((long) (selectChoiceCount2 * 2));
                node.writeInt(selectChoiceCount2);
                node.writeInt(prefixIndex);
                for (int i3 = fromIndex2; i3 < toIndex; i3++) {
                    byte rangeByte = list.get(i3).getByte(byteStringOffset);
                    if (i3 == fromIndex2 || rangeByte != list.get(i3 - 1).getByte(byteStringOffset)) {
                        int other$iv = 255 & rangeByte;
                        node.writeInt(other$iv);
                    }
                }
                Buffer childNodes = new Buffer();
                int rangeStart = fromIndex2;
                while (rangeStart < toIndex) {
                    byte rangeByte2 = list.get(rangeStart).getByte(byteStringOffset);
                    int i4 = rangeStart + 1;
                    while (true) {
                        if (i4 >= toIndex) {
                            i4 = toIndex;
                            break;
                        } else if (rangeByte2 != list.get(i4).getByte(byteStringOffset)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int rangeEnd2 = rangeStart + 1;
                    if (rangeEnd2 == i4 && byteStringOffset + 1 == list.get(rangeStart).size()) {
                        node.writeInt(list2.get(rangeStart).intValue());
                        rangeEnd = i4;
                        selectChoiceCount = selectChoiceCount2;
                        prefixIndex2 = prefixIndex;
                        from3 = from;
                        fromIndex3 = fromIndex2;
                        to2 = to4;
                    } else {
                        int rangeEnd3 = i4;
                        node.writeInt(((int) (childNodesOffset + getIntCount(childNodes))) * (-1));
                        rangeEnd = rangeEnd3;
                        selectChoiceCount = selectChoiceCount2;
                        prefixIndex2 = prefixIndex;
                        from3 = from;
                        fromIndex3 = fromIndex2;
                        to2 = to4;
                        buildTrieRecursive(childNodesOffset, childNodes, byteStringOffset + 1, byteStrings, rangeStart, rangeEnd, indexes);
                    }
                    rangeStart = rangeEnd;
                    fromIndex2 = fromIndex3;
                    prefixIndex = prefixIndex2;
                    from = from3;
                    selectChoiceCount2 = selectChoiceCount;
                    to4 = to2;
                    list = byteStrings;
                    list2 = indexes;
                }
                node.writeAll(childNodes);
                return;
            }
            int prefixIndex4 = prefixIndex;
            ByteString from5 = from;
            int fromIndex5 = fromIndex2;
            ByteString to5 = to3;
            int i6 = byteStringOffset;
            int iMin = Math.min(from5.size(), to5.size());
            int scanByteCount = 0;
            while (true) {
                if (i6 >= iMin) {
                    from2 = from5;
                    to = to5;
                    break;
                }
                from2 = from5;
                to = to5;
                if (from2.getByte(i6) != to.getByte(i6)) {
                    break;
                }
                scanByteCount++;
                i6++;
                to5 = to;
                from5 = from2;
            }
            long childNodesOffset2 = nodeOffset + getIntCount(node) + ((long) 2) + ((long) scanByteCount) + 1;
            node.writeInt(-scanByteCount);
            node.writeInt(prefixIndex4);
            int i7 = byteStringOffset + scanByteCount;
            for (int i8 = byteStringOffset; i8 < i7; i8++) {
                byte $this$and$iv = from2.getByte(i8);
                node.writeInt($this$and$iv & UByte.MAX_VALUE);
            }
            int i9 = fromIndex5 + 1;
            if (i9 == toIndex) {
                if (!(byteStringOffset + scanByteCount == byteStrings.get(fromIndex5).size())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                node.writeInt(indexes.get(fromIndex5).intValue());
            } else {
                Buffer childNodes2 = new Buffer();
                node.writeInt(((int) (childNodesOffset2 + getIntCount(childNodes2))) * (-1));
                buildTrieRecursive(childNodesOffset2, childNodes2, byteStringOffset + scanByteCount, byteStrings, fromIndex5, toIndex, indexes);
                node.writeAll(childNodes2);
            }
        }

        private final long getIntCount(Buffer $this$intCount) {
            return $this$intCount.size() / ((long) 4);
        }
    }
}
