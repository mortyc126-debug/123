package d81;

import a81.c;
import au0.g;
import cg0.a;
import com.gnacba.amuvvoafs.gms.measurement.internal.b0;
import i11.t;
import java.io.File;
import lmjxuqdtp.jvm.internal.o;
import um.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public final g a;
    public final b b;
    public final iw1.b c;
    public final a d;
    public final File e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f78f;
    public final iw1.b g;
    public final c h;
    public final t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f79j;
    public final lt.b k;

    public a0(g gVar, b bVar, iw1.b bVar2, a aVar, File file, File file2, iw1.b bVar3, c cVar, t tVar, int i, b0 b0Var, lt.b bVar4) {
        o.h(bVar2, "renderers");
        o.h(bVar3, "resourceManager");
        this.a = gVar;
        this.b = bVar;
        this.c = bVar2;
        this.d = aVar;
        this.e = file;
        this.f78f = file2;
        this.g = bVar3;
        this.h = cVar;
        this.i = tVar;
        this.f79j = i;
        this.k = bVar4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x033d, code lost:
    
        if (ky1.c0.R(r0, r4, r9) == r10) goto L130;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021b  */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(d81.a0 r14, x71.p r15, u71.a r16, lmjxuqdtp.jvm.functions.Function1 r17, sx1.c r18) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.a0.a(d81.a0, x71.p, u71.a, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(x71.p r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof d81.z
            if (r0 == 0) goto L13
            r0 = r8
            d81.z r0 = (d81.z) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            d81.z r0 = new d81.z
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            lx1.b0 r3 = lx1.b0.a
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            com.bandlab.audiocore.generated.EffectMetadataManager r7 = r0.k
            x71.p r0 = r0.j
            lg.e.O(r8)     // Catch: java.lang.Throwable -> L2f
            r8 = r7
            r7 = r0
            goto L77
        L2f:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r0
            r0 = r5
            goto L73
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            lg.e.O(r8)
            lt.b r8 = r6.k     // Catch: java.lang.Throwable -> L47
            com.bandlab.audiocore.generated.EffectMetadataManager r8 = r8.d()     // Catch: java.lang.Throwable -> L47
            goto L4c
        L47:
            r8 = move-exception
            lx1.n r8 = lg.e.u(r8)
        L4c:
            di0.z.T(r8)
            java.lang.Throwable r2 = lx1.o.a(r8)
            if (r2 != 0) goto L99
            com.bandlab.audiocore.generated.EffectMetadataManager r8 = (com.bandlab.audiocore.generated.EffectMetadataManager) r8
            iw1.b r2 = r6.g     // Catch: java.lang.Throwable -> L72
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L72
            ir0.i r2 = (ir0.i) r2     // Catch: java.lang.Throwable -> L72
            r0.j = r7     // Catch: java.lang.Throwable -> L72
            r0.k = r8     // Catch: java.lang.Throwable -> L72
            r0.n = r4     // Catch: java.lang.Throwable -> L72
            java.io.Serializable r0 = r2.d(r7, r0)     // Catch: java.lang.Throwable -> L72
            rx1.a r2 = rx1.a.a     // Catch: java.lang.Throwable -> L72
            if (r0 != r2) goto L6e
            goto L6f
        L6e:
            r0 = r3
        L6f:
            if (r0 != r1) goto L77
            return r1
        L72:
            r0 = move-exception
        L73:
            lx1.n r3 = lg.e.u(r0)
        L77:
            di0.z.T(r3)
            java.lang.Throwable r0 = lx1.o.a(r3)
            if (r0 == 0) goto L86
            d81.k r7 = new d81.k
            r7.<init>(r0)
            return r7
        L86:
            u71.w r0 = new u71.w
            java.io.File r7 = r7.y()
            java.io.File r1 = r6.e
            java.io.File r2 = r6.f78f
            r0.<init>(r7, r1, r2)
            d81.l r7 = new d81.l
            r7.<init>(r0, r8)
            return r7
        L99:
            d81.k r7 = new d81.k
            r7.<init>(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.a0.b(x71.p, sx1.c):java.lang.Object");
    }
}
