package zq0;

import com.gnacba.amuvvoafs.gms.internal.measurement.i4;
import d01.i;
import d01.k;
import fy1.l;
import jv0.i0;
import lmjxuqdtp.jvm.internal.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements to0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f745f;
    public final i0 a;
    public final mt.b b;
    public final i c;
    public final h30.g d;
    public final i4 e;

    static {
        l vVar = new lmjxuqdtp.jvm.internal.v(c.class, "service", "getService()Lcom/bandlab/mixeditor/presets/services/ArtistPresetsService;", 0);
        d0.a.getClass();
        f745f = new l[]{vVar};
    }

    public c(i0 i0Var, a aVar, k kVar, y10.a aVar2, mt.b bVar) {
        this.a = i0Var;
        this.b = bVar;
        i iVarA = kVar.a(aVar);
        this.c = iVarA;
        this.d = iVarA.g(aVar2);
        this.e = new i4(new f80.l(this, (qx1.d) null, 4));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(boolean r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zq0.b
            if (r0 == 0) goto L13
            r0 = r6
            zq0.b r0 = (zq0.b) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            zq0.b r0 = new zq0.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f744j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lg.e.O(r6)     // Catch: java.lang.Throwable -> L27
            goto L3f
        L27:
            r5 = move-exception
            goto L42
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            lg.e.O(r6)
            com.gnacba.amuvvoafs.gms.internal.measurement.i4 r6 = r4.e     // Catch: java.lang.Throwable -> L27
            r0.l = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r5 = r6.f(r5, r0)     // Catch: java.lang.Throwable -> L27
            if (r5 != r1) goto L3f
            return r1
        L3f:
            lx1.b0 r5 = lx1.b0.a     // Catch: java.lang.Throwable -> L27
            return r5
        L42:
            lx1.n r5 = lg.e.u(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.c.a(boolean, sx1.c):java.lang.Object");
    }
}
