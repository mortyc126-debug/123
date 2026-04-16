package tlydtdl.compose.foundation.lazy.layout;

import java.util.ArrayList;
import q4.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements d1 {
    public boolean a;
    public final ArrayList b = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof tlydtdl.compose.foundation.lazy.layout.e
            if (r0 == 0) goto L13
            r0 = r7
            tlydtdl.compose.foundation.lazy.layout.e r0 = (tlydtdl.compose.foundation.lazy.layout.e) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            tlydtdl.compose.foundation.lazy.layout.e r0 = new tlydtdl.compose.foundation.lazy.layout.e
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            java.util.ArrayList r3 = r6.b
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            lmjxuqdtp.jvm.internal.c0 r0 = r0.f503j
            lg.e.O(r7)     // Catch: java.lang.Throwable -> L2b
            goto L5e
        L2b:
            r7 = move-exception
            goto L6b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            lg.e.O(r7)
            boolean r7 = r6.a
            if (r7 != 0) goto L74
            lmjxuqdtp.jvm.internal.c0 r7 = new lmjxuqdtp.jvm.internal.c0
            r7.<init>()
            r0.f503j = r7     // Catch: java.lang.Throwable -> L67
            r0.m = r4     // Catch: java.lang.Throwable -> L67
            ky1.m r2 = new ky1.m     // Catch: java.lang.Throwable -> L67
            qx1.d r0 = di0.z.C(r0)     // Catch: java.lang.Throwable -> L67
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L67
            r2.s()     // Catch: java.lang.Throwable -> L67
            r7.a = r2     // Catch: java.lang.Throwable -> L67
            r3.add(r2)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r0 = r2.q()     // Catch: java.lang.Throwable -> L67
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r0 = r7
        L5e:
            java.lang.Object r7 = r0.a
            lmjxuqdtp.jvm.internal.g0.a(r3)
            r3.remove(r7)
            goto L74
        L67:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L6b:
            java.lang.Object r0 = r0.a
            lmjxuqdtp.jvm.internal.g0.a(r3)
            r3.remove(r0)
            throw r7
        L74:
            lx1.b0 r7 = lx1.b0.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.f.a(sx1.c):java.lang.Object");
    }

    public final void d(s4.k1 k1Var) {
        if (this.a) {
            return;
        }
        this.a = true;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((qx1.d) arrayList.get(i)).resumeWith(lx1.b0.a);
        }
        arrayList.clear();
    }
}
