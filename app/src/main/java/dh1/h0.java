package dh1;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(serializable = true)
public final class h0 {
    public static final g0 Companion = new g0();
    public final String a;

    public /* synthetic */ h0(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            b2.b(i, 1, f0.a.getDescriptor());
            throw null;
        }
    }

    public h0(String str) {
        this.a = str;
    }
}
