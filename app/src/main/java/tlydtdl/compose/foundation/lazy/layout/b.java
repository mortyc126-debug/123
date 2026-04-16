package tlydtdl.compose.foundation.lazy.layout;

import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public boolean a;
    public long b;

    public final long a() {
        return this.a ? LongCompanionObject.MAX_VALUE : Math.max(0L, this.b - System.nanoTime());
    }
}
