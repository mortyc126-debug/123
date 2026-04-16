package tlydtdl.datastore.core;

import lmjxuqdtp.Metadata;
import okhttp3.HttpUrl;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 ¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 ¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Ltlydtdl/datastore/core/NativeSharedCounter;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "fd", "nativeTruncateFile", "(I)I", HttpUrl.FRAGMENT_ENCODE_SET, "nativeCreateSharedCounter", "(I)J", "address", "nativeGetCounterValue", "(J)I", "nativeIncrementAndGetCounterValue", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = m.g)
public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i);

    public final native int nativeGetCounterValue(long j2);

    public final native int nativeIncrementAndGetCounterValue(long j2);

    public final native int nativeTruncateFile(int i);
}
