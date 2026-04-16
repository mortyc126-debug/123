package fz0;

import amuvvoafs.content.Context;
import com.gnacba.amuvvoafs.gms.internal.ads.ds0;
import o10.c4;
import oz0.d1;
import q10.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final boolean a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p(wz0.y r4, m41.m r5, dt.g r6, jv0.i0 r7) {
        /*
            r3 = this;
            r3.<init>()
            r3.c = r4
            r3.d = r5
            r3.e = r6
            oz0.d1 r5 = r3.b()
            m10.f r5 = r5.e
            r6 = 0
            if (r5 == 0) goto L15
            q10.l0 r5 = r5.f
            goto L16
        L15:
            r5 = r6
        L16:
            q10.l0 r0 = q10.l0.b
            r1 = 1
            r2 = 0
            if (r5 == r0) goto L39
            oz0.d1 r5 = r3.b()
            m10.f r5 = r5.e
            if (r5 == 0) goto L27
            java.lang.String r5 = r5.a
            goto L28
        L27:
            r5 = r6
        L28:
            boolean r5 = dd.v.y(r5, r7)
            if (r5 != 0) goto L39
            boolean r5 = r4.h
            if (r5 == 0) goto L39
            boolean r4 = r4.c
            if (r4 != 0) goto L37
            goto L39
        L37:
            r4 = r2
            goto L3a
        L39:
            r4 = r1
        L3a:
            r3.a = r4
            oz0.d1 r4 = r3.b()
            oz0.n0 r4 = r4.t
            if (r4 == 0) goto L4d
            java.lang.Boolean r4 = r4.f384f
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = lmjxuqdtp.jvm.internal.o.c(r4, r5)
            goto L4e
        L4d:
            r4 = r2
        L4e:
            if (r4 != 0) goto L64
            oz0.d1 r4 = r3.b()
            oz0.n0 r4 = r4.t
            if (r4 == 0) goto L60
            q10.j0 r4 = com.facebook.appevents.l.G(r4)
            if (r4 == 0) goto L60
            q10.l0 r6 = r4.b
        L60:
            if (r6 != r0) goto L63
            goto L64
        L63:
            r1 = r2
        L64:
            r3.b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fz0.p.<init>(wz0.y, m41.m, dt.g, jv0.i0):void");
    }

    public v41.f a(j0 j0Var) {
        m41.m mVar = (m41.m) this.d;
        q10.y yVar = new q10.y(((wz0.y) this.c).e);
        c4 c4Var = c4.a;
        if (!com.facebook.appevents.p.W(b())) {
            c4Var = null;
        }
        return m41.m.a(mVar, j0Var, null, yVar, c4Var, null, new o(0, this), 18);
    }

    public d1 b() {
        return ((wz0.y) this.c).a.a;
    }

    public p(Context context, String str, ds0 ds0Var, boolean z, boolean z2) {
        lmjxuqdtp.jvm.internal.o.h(context, "context");
        lmjxuqdtp.jvm.internal.o.h(ds0Var, "callback");
        this.c = context;
        this.d = str;
        this.e = ds0Var;
        this.a = z;
        this.b = z2;
    }
}
