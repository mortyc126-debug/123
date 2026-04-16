package d81;

import a2.p4;
import a81.c;
import bj.k;
import fy1.l;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ky1.b0;
import ky1.c0;
import ky1.m0;
import ky1.t1;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.v;
import m81.d;
import rd.g;
import ry1.e;
import tlydtdl.compose.foundation.lazy.layout.r1;
import u71.b;
import vb0.a;
import w2.u;
import z71.r;
import z71.x;
import zs.u0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements b {
    public static final /* synthetic */ l[] o;
    public final u a;
    public final c b;
    public final d c;
    public final a0 d;
    public final p71.f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f81f;
    public final File g;
    public final k h;
    public final a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mt.b f82j;
    public t1 m;
    public final ty1.c k = ty1.d.a();
    public final AtomicInteger l = new AtomicInteger(0);
    public final r1 n = new r1(new a81.k(g0.a));

    static {
        l vVar = new v(f0.class, "mixdownService", "getMixdownService()Lcom/bandlab/sync/mixdown/MixdownService;", 0);
        lmjxuqdtp.jvm.internal.d0.a.getClass();
        o = new l[]{vVar};
    }

    public f0(u uVar, com.gnacba.amuvvoafs.gms.measurement.internal.a0 a0Var, c cVar, d dVar, a0 a0Var2, p71.f0 f0Var, File file, File file2, k kVar, a aVar, mt.b bVar) {
        this.a = uVar;
        this.b = cVar;
        this.c = dVar;
        this.d = a0Var2;
        this.e = f0Var;
        this.f81f = file;
        this.g = file2;
        this.h = kVar;
        this.i = aVar;
        this.f82j = bVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:68|69|89|70|(1:100)|73|40|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01cc: MOVE (r8 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]) (LINE:461), block:B:77:0x01cc */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0 A[Catch: all -> 0x0079, CancellationException -> 0x01ce, TRY_ENTER, TryCatch #2 {CancellationException -> 0x01ce, blocks: (B:15:0x003e, B:42:0x00b0, B:44:0x00b8, B:46:0x00c8, B:49:0x00da, B:51:0x00e2, B:52:0x00f6, B:53:0x011e, B:55:0x0124, B:65:0x0151, B:67:0x0180, B:68:0x0181, B:70:0x018e, B:29:0x0075), top: B:86:0x002e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2 A[Catch: all -> 0x0079, CancellationException -> 0x01ce, TryCatch #2 {CancellationException -> 0x01ce, blocks: (B:15:0x003e, B:42:0x00b0, B:44:0x00b8, B:46:0x00c8, B:49:0x00da, B:51:0x00e2, B:52:0x00f6, B:53:0x011e, B:55:0x0124, B:65:0x0151, B:67:0x0180, B:68:0x0181, B:70:0x018e, B:29:0x0075), top: B:86:0x002e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f6 A[Catch: all -> 0x0079, CancellationException -> 0x01ce, TryCatch #2 {CancellationException -> 0x01ce, blocks: (B:15:0x003e, B:42:0x00b0, B:44:0x00b8, B:46:0x00c8, B:49:0x00da, B:51:0x00e2, B:52:0x00f6, B:53:0x011e, B:55:0x0124, B:65:0x0151, B:67:0x0180, B:68:0x0181, B:70:0x018e, B:29:0x0075), top: B:86:0x002e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124 A[Catch: all -> 0x0079, CancellationException -> 0x01ce, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x01ce, blocks: (B:15:0x003e, B:42:0x00b0, B:44:0x00b8, B:46:0x00c8, B:49:0x00da, B:51:0x00e2, B:52:0x00f6, B:53:0x011e, B:55:0x0124, B:65:0x0151, B:67:0x0180, B:68:0x0181, B:70:0x018e, B:29:0x0075), top: B:86:0x002e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0181 A[Catch: all -> 0x0079, CancellationException -> 0x01ce, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x01ce, blocks: (B:15:0x003e, B:42:0x00b0, B:44:0x00b8, B:46:0x00c8, B:49:0x00da, B:51:0x00e2, B:52:0x00f6, B:53:0x011e, B:55:0x0124, B:65:0x0151, B:67:0x0180, B:68:0x0181, B:70:0x018e, B:29:0x0075), top: B:86:0x002e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0194 -> B:73:0x0197). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x019d -> B:73:0x0197). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(d81.f0 r17, sx1.c r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.f0.a(d81.f0, sx1.c):java.lang.Object");
    }

    public final u0 b() {
        s02.d.a.getClass();
        s02.b.t("MixQueue:: block mixing down in background");
        AtomicInteger atomicInteger = this.l;
        o.h(atomicInteger, "<this>");
        atomicInteger.addAndGet(1);
        u0 u0Var = new u0();
        u0Var.a = new AtomicReference(this);
        return u0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(y11.s2 r14, s71.e r15, sx1.c r16) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.f0.c(y11.s2, s71.e, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0116 A[Catch: all -> 0x00dc, TRY_LEAVE, TryCatch #4 {all -> 0x00dc, blocks: (B:46:0x010e, B:48:0x0116, B:55:0x016b, B:56:0x018f, B:37:0x00d2, B:39:0x00d7, B:42:0x00df), top: B:71:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016b A[Catch: all -> 0x00dc, TRY_ENTER, TryCatch #4 {all -> 0x00dc, blocks: (B:46:0x010e, B:48:0x0116, B:55:0x016b, B:56:0x018f, B:37:0x00d2, B:39:0x00d7, B:42:0x00df), top: B:71:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(s71.e r19, sx1.c r20) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.f0.d(s71.e, sx1.c):java.lang.Object");
    }

    public final Object e(d0 d0Var) {
        x xVar = (x) this.a.b;
        nd.d dVarG = by1.b.g(2125975228, new String[]{"SyncRevision", "RevisionSample", "SyncSample"}, (g) xVar.a, "SyncRevision.sq", "getUnmixedRevisions", "SELECT SyncRevision.revisionStamp FROM SyncRevision\nLEFT JOIN RevisionSample ON SyncRevision.revisionStamp = RevisionSample.revisionStamp\nLEFT JOIN SyncSample ON SyncSample.sampleId = RevisionSample.sampleId\nWHERE SyncSample.type = 'Mixdown' AND SyncSample.status != 'Ready'\nORDER BY createdOn DESC", new r(xVar, 1));
        e eVar = m0.a;
        return x30.b.a(dVarG, x30.b.a, d0Var);
    }

    public final boolean f() {
        if (this.k.b()) {
            return false;
        }
        t1 t1Var = this.m;
        if (t1Var != null && t1Var.isActive()) {
            return false;
        }
        t1 t1Var2 = this.m;
        if (t1Var2 != null) {
            t1Var2.a((CancellationException) null);
        }
        e eVar = m0.a;
        this.m = c0.F(this.h, ry1.d.b, (b0) null, new p4(this, (qx1.d) null, 13), 2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01dc, code lost:
    
        if (lmjxuqdtp.time.g.c(r12, r15.a) > 0) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0143 A[PHI: r1 r2 r5
  0x0143: PHI (r1v9 java.lang.Object) = (r1v8 java.lang.Object), (r1v14 java.lang.Object) binds: [B:42:0x00fe, B:50:0x0142] A[DONT_GENERATE, DONT_INLINE]
  0x0143: PHI (r2v15 y11.s2) = (r2v14 y11.s2), (r2v18 y11.s2) binds: [B:42:0x00fe, B:50:0x0142] A[DONT_GENERATE, DONT_INLINE]
  0x0143: PHI (r5v8 s71.e) = (r5v7 s71.e), (r5v10 s71.e) binds: [B:42:0x00fe, B:50:0x0142] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0225 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(s71.d r18, sx1.c r19) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d81.f0.g(s71.d, sx1.c):java.lang.Object");
    }
}
