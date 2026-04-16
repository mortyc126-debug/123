package fm;

import com.bandlab.restutils.UnauthorizedFileService;
import em.e;
import iw1.b;
import lmjxuqdtp.jvm.internal.o;
import sx1.c;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final UnauthorizedFileService a;
    public final em.a b;
    public final u c;
    public final b d;

    public d(UnauthorizedFileService unauthorizedFileService, em.a aVar, u uVar, b bVar) {
        o.h(bVar, "audioCacheStorage");
        this.a = unauthorizedFileService;
        this.b = aVar;
        this.c = uVar;
        this.d = bVar;
    }

    public static Object b(d dVar, String str, String str2, c cVar, int i) {
        e eVar = e.e;
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            eVar = e.f;
        }
        return dVar.c(str2, str, eVar, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r8 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.io.File r6, java.lang.String r7, sx1.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof fm.b
            if (r0 == 0) goto L13
            r0 = r8
            fm.b r0 = (fm.b) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            fm.b r0 = new fm.b
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lg.e.O(r8)
            goto L5a
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.io.File r6 = r0.j
            lg.e.O(r8)
            goto L48
        L38:
            lg.e.O(r8)
            r0.j = r6
            r0.m = r4
            com.bandlab.restutils.UnauthorizedFileService r8 = r5.a
            java.lang.Object r8 = r8.downloadFile(r7, r0)
            if (r8 != r1) goto L48
            goto L59
        L48:
            iz1.s0 r8 = (iz1.s0) r8
            ny1.l r6 = com.gnacba.amuvvoafs.gms.internal.auth.h.b0(r8, r6)
            r7 = 0
            r0.j = r7
            r0.m = r3
            java.lang.Object r8 = ve.g.m(r6, r0)
            if (r8 != r1) goto L5a
        L59:
            return r1
        L5a:
            f21.c r8 = (f21.c) r8
            java.lang.Object r6 = r8.b
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.d.a(java.io.File, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r3 == r7) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d9, code lost:
    
        if (r3 != r7) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r16, java.lang.String r17, em.e r18, sx1.c r19) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.d.c(java.lang.String, java.lang.String, em.e, sx1.c):java.lang.Object");
    }
}
