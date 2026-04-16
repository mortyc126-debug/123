package tlydtdl.compose.foundation.lazy.layout;

import a4.w;
import amuvvoafs.view.View;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.gnacba.amuvvoafs.gms.internal.ads.wc0;
import com.gnacba.amuvvoafs.gms.internal.gtm.zzbu;
import com.gnacba.firebase.encoders.EncodingException;
import f3.f2;
import g7.x;
import java.io.ByteArrayOutputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import ky1.c0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.u;
import lmjxuqdtp.time.v;
import ny1.p2;
import ny1.z;
import qx1.i;
import u71.s;
import xu0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class r1 implements zu1.b, b01.m, cg.c, p02.l, fs1.c, g7.m {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ r1(Enum r12, Enum r2, Object obj, int i) {
        this.a = i;
        this.c = r12;
        this.d = r2;
        this.b = obj;
    }

    @Override // b01.m
    public h30.f a() {
        switch (this.a) {
            case 4:
                return (h30.f) this.c;
            default:
                return (b01.l) this.c;
        }
    }

    @Override // g7.m
    public void b(tlydtdl.lifecycle.g0 g0Var) {
        WeakReference weakReference = (WeakReference) this.c;
        if ((weakReference != null ? (tlydtdl.lifecycle.g0) weakReference.get() : null) != g0Var) {
            ky1.t1 t1Var = (ky1.t1) this.b;
            if (t1Var != null) {
                t1Var.a((CancellationException) null);
            }
            if (g0Var == null) {
                this.c = null;
                return;
            }
            this.c = new WeakReference(g0Var);
            ny1.l lVar = (ny1.l) ((x) this.d).c;
            if (lVar != null) {
                ky1.t1 t1Var2 = (ky1.t1) this.b;
                if (t1Var2 != null) {
                    t1Var2.a((CancellationException) null);
                }
                this.b = c0.F(tlydtdl.lifecycle.i1.g(g0Var), (i) null, (ky1.b0) null, new a10.i(g0Var, lVar, this, (qx1.d) null, 16), 3);
            }
        }
    }

    @Override // g7.m
    public void c(Object obj) {
        ky1.t1 t1Var = (ky1.t1) this.b;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        this.b = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:183|184|250|185|(2:246|187)(1:191)|192|193|242|194|(5:254|197|(3:258|199|261)(3:257|200|260)|259|195)|256|201|202|203|204) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:181|(15:183|184|250|185|(2:246|187)(1:191)|192|193|242|194|(5:254|197|(3:258|199|261)(3:257|200|260)|259|195)|256|201|202|203|204)(1:211)|244|212|(5:215|(4:218|(3:264|220|267)(1:266)|265|216)|263|221|213)|262|(1:223)|226|227) */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00a8, code lost:
    
        if (r0 == r3) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x013f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0146, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x01be, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x007b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x00a8 -> B:174:0x00ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(qx1.d r21) {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.d(qx1.d):java.lang.Object");
    }

    @Override // g7.m
    public void e(Object obj) {
        tlydtdl.lifecycle.g0 g0Var;
        ny1.l lVar = (ny1.l) obj;
        WeakReference weakReference = (WeakReference) this.c;
        if (weakReference == null || (g0Var = (tlydtdl.lifecycle.g0) weakReference.get()) == null || lVar == null) {
            return;
        }
        ky1.t1 t1Var = (ky1.t1) this.b;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        this.b = c0.F(tlydtdl.lifecycle.i1.g(g0Var), (i) null, (ky1.b0) null, new a10.i(g0Var, lVar, this, (qx1.d) null, 16), 3);
    }

    @Override // b01.m
    public b01.n f() {
        switch (this.a) {
        }
        return (b01.n) this.b;
    }

    @Override // b01.m
    public b01.t g() {
        switch (this.a) {
        }
        return (b01.t) this.d;
    }

    public Object get() {
        return new av1.q((i) ((kx1.a) this.c).get(), (xu1.z0) ((kx1.a) this.b).get(), (k7.e) ((zu1.c) this.d).get());
    }

    public bx.i h(String str) {
        bx.h hVar = (bx.h) this.d;
        p pVar = (p) this.b;
        ky1.a0 a0Var = (ky1.a0) this.c;
        wc0 wc0Var = hVar.a;
        zs.f fVar = (zs.f) ((or.a1) wc0Var.b).invoke();
        d01.k kVar = (d01.k) ((iw1.b) wc0Var.c).invoke();
        o.h(kVar, "preferenceConfig");
        return new bx.i(str, pVar, a0Var, fVar, kVar);
    }

    public void i(Object obj, ByteArrayOutputStream byteArrayOutputStream) throws EncodingException {
        HashMap map = (HashMap) this.c;
        gu1.f fVar = new gu1.f(byteArrayOutputStream, map, (HashMap) this.b, (du1.c) this.d);
        du1.c cVar = (du1.c) map.get(obj.getClass());
        if (cVar != null) {
            cVar.a(obj, fVar);
        } else {
            throw new EncodingException("No encoder for " + obj.getClass());
        }
    }

    public w j() {
        return ((c4.b) this.d).a.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object l(java.lang.String r12, a80.r r13, tc0.p r14, sx1.c r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof f80.e
            if (r0 == 0) goto L13
            r0 = r15
            f80.e r0 = (f80.e) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            f80.e r0 = new f80.e
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r15)
            goto L4c
        L27:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2f:
            lg.e.O(r15)
            f80.f r15 = new f80.f
            r2 = 0
            r4 = 0
            r15.<init>(r11, r14, r4, r2)
            f80.g r5 = new f80.g
            r10 = 0
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            r0.l = r3
            java.lang.Object r15 = m8.d.m(r15, r5, r0)
            if (r15 != r1) goto L4c
            return r1
        L4c:
            lx1.l r15 = (lx1.l) r15
            java.lang.Object r12 = r15.a
            ow.b0 r12 = (ow.b0) r12
            java.lang.Object r13 = r15.b
            tc0.l r13 = (tc0.l) r13
            java.util.List r14 = r13.a
            r15 = 0
            java.util.List r12 = cd.i0.B(r14, r12, r15)
            r14 = 2
            tc0.l r12 = tc0.l.a(r13, r12, r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.l(java.lang.String, a80.r, tc0.p, sx1.c):java.lang.Object");
    }

    public Object m(Object obj) {
        ru1.c cVar = (ru1.c) this.d;
        iz1.e0 e0Var = (iz1.e0) this.c;
        String strB = ((wy1.h) cVar.b).b(obj, (wy1.a) this.b);
        int i = iz1.o0.a;
        return iz1.b.f(strB, e0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object n(qx1.d r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cg.a
            if (r0 == 0) goto L13
            r0 = r5
            cg.a r0 = (cg.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L1a
        L13:
            cg.a r0 = new cg.a
            sx1.c r5 = (sx1.c) r5
            r0.<init>(r4, r5)
        L1a:
            java.lang.Object r5 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            tlydtdl.compose.foundation.lazy.layout.r1 r0 = r0.j
            lg.e.O(r5)     // Catch: java.io.FileNotFoundException -> L2b
            goto L48
        L2b:
            r5 = move-exception
            goto L74
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            lg.e.O(r5)
            java.lang.Object r5 = r4.c     // Catch: java.io.FileNotFoundException -> L72
            uf.f r5 = (uf.f) r5     // Catch: java.io.FileNotFoundException -> L72
            r0.j = r4     // Catch: java.io.FileNotFoundException -> L72
            r0.m = r3     // Catch: java.io.FileNotFoundException -> L72
            java.lang.Object r5 = r5.c(r0)     // Catch: java.io.FileNotFoundException -> L72
            if (r5 != r1) goto L47
            return r1
        L47:
            r0 = r4
        L48:
            java.lang.Object r5 = r0.c
            uf.f r5 = (uf.f) r5
            java.util.List r5 = r5.b()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L59
            goto L87
        L59:
            java.util.Iterator r5 = r5.iterator()
        L5d:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L87
            java.lang.Object r1 = r5.next()
            java.lang.String r2 = "null cannot be cast to non-null type lmjxuqdtp.String"
            lmjxuqdtp.jvm.internal.o.f(r1, r2)
            java.lang.String r1 = (java.lang.String) r1
            r0.s(r1)
            goto L5d
        L72:
            r5 = move-exception
            r0 = r4
        L74:
            java.lang.String r5 = r5.getMessage()
            if (r5 == 0) goto L87
            java.lang.Object r0 = r0.b
            wf.b r0 = (wf.b) r0
            java.lang.String r1 = "Event storage file not found: "
            java.lang.String r5 = r1.concat(r5)
            r0.b(r5)
        L87:
            lx1.b0 r5 = lx1.b0.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.n(qx1.d):java.lang.Object");
    }

    public long o() {
        return ((c4.b) this.d).a.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object p(js0.t r30, s71.e1 r31, sx1.c r32) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.p(js0.t, s71.e1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x006f, code lost:
    
        if (r8.g(r7, r0) != r1) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object q(oz0.d1 r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.bandlab.song.utils.a
            if (r0 == 0) goto L13
            r0 = r8
            com.bandlab.song.utils.a r0 = (com.bandlab.song.utils.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            com.bandlab.song.utils.a r0 = new com.bandlab.song.utils.a
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            lg.e.O(r8)
            goto L72
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            oz0.d1 r7 = r0.j
            lg.e.O(r8)
            goto L62
        L3b:
            oz0.d1 r7 = r0.j
            lg.e.O(r8)
            goto L53
        L41:
            lg.e.O(r8)
            java.lang.Object r8 = r6.c
            p41.g r8 = (p41.g) r8
            r0.j = r7
            r0.m = r5
            java.lang.Object r8 = ct1.b.J(r8, r7, r0)
            if (r8 != r1) goto L53
            goto L71
        L53:
            java.lang.Object r8 = r6.b
            l41.j r8 = (l41.j) r8
            r0.j = r7
            r0.m = r4
            java.lang.Object r8 = r8.e(r7, r0)
            if (r8 != r1) goto L62
            goto L71
        L62:
            java.lang.Object r8 = r6.d
            q41.b r8 = (q41.b) r8
            r2 = 0
            r0.j = r2
            r0.m = r3
            java.lang.Object r7 = r8.g(r7, r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            lx1.b0 r7 = lx1.b0.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.q(oz0.d1, sx1.c):java.lang.Object");
    }

    public void r(s71.e eVar, s sVar) {
        v vVar = (v) this.c;
        o.h(eVar, "id");
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.d;
        Object aVar = linkedHashMap.get(eVar);
        if (aVar == null) {
            aVar = new d81.a(vVar.b(), 0, mx1.t.a);
        }
        d81.a aVar2 = (d81.a) aVar;
        linkedHashMap.put(eVar, d81.a.a(vVar.b(), aVar2.d() + 1, mx1.o.R0(aVar2.b(), ct1.b.B(sVar))));
    }

    public void s(String str) {
        lf.d dVar = (lf.d) this.d;
        c0.F(dVar.c, dVar.f, (ky1.b0) null, new tlydtdl.lifecycle.a0(this, str, null, 5), 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d5, code lost:
    
        if (r2 == r4) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object t(js0.t r29, java.lang.String r30, y11.y2 r31, y11.l2 r32, sx1.c r33) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.r1.t(js0.t, java.lang.String, y11.y2, y11.l2, sx1.c):java.lang.Object");
    }

    public void u(w wVar) {
        ((c4.b) this.d).a.c = wVar;
    }

    public void v(p5.c cVar) {
        ((c4.b) this.d).a.a = cVar;
    }

    public void w(int i, int[] iArr, String[] strArr, int[] iArr2) {
        ((String[][]) this.c)[i] = strArr;
        ((int[][]) this.b)[i] = iArr;
        ((int[][]) this.d)[i] = iArr2;
    }

    public void x(p5.n nVar) {
        ((c4.b) this.d).a.b = nVar;
    }

    public void y(long j2) {
        ((c4.b) this.d).a.d = j2;
    }

    public Object zza() {
        return new es1.f((es1.m) ((fs1.c) this.c).zza(), (es1.d) ((fs1.c) this.b).zza(), ((aq1.c) ((dd.b) this.d).b).a);
    }

    public /* synthetic */ r1(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
        this.d = obj3;
    }

    public r1(zzbu zzbuVar) {
        this.a = 2;
        ap1.j jVarZzd = zzbuVar.zzd();
        yp1.a aVarZzr = zzbuVar.zzr();
        com.gnacba.amuvvoafs.gms.common.internal.f0.h(jVarZzd);
        this.b = new ArrayList();
        this.c = new wc0(this, aVarZzr);
        this.d = zzbuVar;
    }

    public r1(ue0.a aVar) {
        this.a = 26;
        this.c = aVar;
        com.bandlab.media.player.impl.i0 i0Var = (com.bandlab.media.player.impl.i0) aVar;
        n30.k kVar = i0Var.i;
        this.b = kVar;
        this.d = new r1((p2) kVar, new he0.b(z.U(i0Var.f, new b60.q((qx1.d) null, this, 5)), 0), new fz0.o(9, this));
    }

    public r1(uf.f fVar, wf.b bVar, lf.d dVar) {
        this.a = 7;
        o.h(bVar, "logger");
        this.c = fVar;
        this.b = bVar;
        this.d = dVar;
    }

    public r1(b01.m mVar, String str, b01.n nVar, b01.t tVar) throws NoWhenBranchMatchedException {
        b01.d lVar;
        this.a = 4;
        this.b = nVar;
        this.d = tVar;
        h30.a aVarA = mVar.a();
        if (aVarA instanceof h30.a) {
            lVar = new b01.a(aVarA, str);
        } else if (aVarA instanceof h30.b) {
            lVar = new b01.d((h30.b) aVarA, str);
        } else if (aVarA instanceof h30.c) {
            lVar = new b01.j((h30.c) aVarA, str);
        } else {
            if (!(aVarA instanceof h30.d)) {
                throw new NoWhenBranchMatchedException();
            }
            lVar = new b01.l((h30.d) aVarA, str);
        }
        this.c = lVar;
        String key = mVar.a().getKey();
        if (str.equals(key) && nVar == mVar.f() && tVar.equals(mVar.g())) {
            String strC = f2.C(key, ": All params are the same, nothing to migrate.");
            bb.w wVar = new bb.w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"PreferenceConfig"});
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(strC), (String[]) Arrays.copyOf(strArr, strArr.length)));
        }
    }

    public r1(a81.k kVar) {
        this.a = 13;
        this.c = u.a;
        this.b = kVar;
        this.d = new LinkedHashMap();
    }

    public r1(p2 p2Var, he0.b bVar, fz0.o oVar) {
        this.a = 23;
        o.h(p2Var, "muted");
        this.c = p2Var;
        this.b = bVar;
        this.d = oVar;
    }

    public r1(View view) {
        this.a = 29;
        this.c = view;
        this.b = hs1.d.E(lx1.j.b, new b5.b(3, this));
        this.d = new m80.b(view);
    }

    public r1(g7.v vVar, int i, ReferenceQueue referenceQueue) {
        this.a = 22;
        o.h(referenceQueue, "referenceQueue");
        this.d = new x(vVar, i, this, referenceQueue);
    }

    public r1(c4.b bVar) {
        this.a = 6;
        this.d = bVar;
        this.c = new ru1.c(15, this);
    }

    public r1(r0 r0Var, b01.n nVar, b01.t tVar, String str) {
        this.a = 5;
        this.b = nVar;
        this.d = tVar;
        this.c = new b01.l(r0Var, str);
    }

    public r1(int i, byte b) {
        this.a = i;
        switch (i) {
            case 9:
                break;
            case 25:
                this.b = new q1.u(16);
                long[] jArr = q1.v0.a;
                this.c = new q1.n0();
                this.d = new g7.p(12);
                break;
            default:
                long[] jArr2 = q1.v0.a;
                this.c = new q1.n0();
                break;
        }
    }

    public r1(int i, int i2) {
        this.a = i2;
        switch (i2) {
            case 21:
                this.c = new String[i][];
                this.b = new int[i][];
                this.d = new int[i][];
                break;
            default:
                this.c = i != 1 ? new q1.u(i) : null;
                break;
        }
    }
}
