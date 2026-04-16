package ip;

import a2.q3;
import cn1.j;
import gp.q0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import mx1.p;
import p81.f;
import po.g;
import po.h;
import qi.c0;
import qi.y;
import sp.b;
import tlydtdl.lifecycle.z;
import up.c;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public final o a;
    public final d b;
    public final h c;
    public final q0 d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f231f;
    public final z g;
    public final List h;
    public final LinkedHashMap i;

    /* JADX WARN: Multi-variable type inference failed */
    public w(o oVar, d dVar, h hVar, q0 q0Var, f fVar, g gVar, z zVar, b bVar, c cVar, tp.c cVar2) {
        this.a = oVar;
        this.b = dVar;
        this.c = hVar;
        this.d = q0Var;
        this.e = fVar;
        this.f231f = gVar;
        this.g = zVar;
        List<rp.g> listE1 = mx1.o.e1(ct1.b.C(new rp.g[]{cVar, cVar2, bVar}), new c6.h(2));
        this.h = listE1;
        int iR = mx1.z.R(p.c0(listE1, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iR < 16 ? 16 : iR);
        for (rp.g gVar2 : listE1) {
            bp.d dVarA = gVar2.a();
            linkedHashMap.put(dVarA, gVar2.b(new q3(25, this, dVarA)));
        }
        this.i = linkedHashMap;
    }

    public final void a(bp.d dVar, rp.h hVar) {
        lmjxuqdtp.jvm.internal.o.h(dVar, "type");
        lmjxuqdtp.jvm.internal.o.h(hVar, "error");
        this.d.b(false);
        Throwable thB = hVar.b();
        Integer numA = hVar.a();
        if (thB instanceof CancellationException) {
            s02.b bVar = s02.d.a;
            String str = "Auth cancelled message: (" + thB.getMessage() + ")";
            bVar.getClass();
            s02.b.p(str);
        } else {
            f fVar = this.e;
            if (numA != null) {
                x10.c cVar = v.Companion;
                int iIntValue = numA.intValue();
                cVar.getClass();
                j.K(fVar, new x10.r(iIntValue));
            } else {
                j.L(fVar, thB);
            }
        }
        y.k(this.c.a, "continue_with_sns_error", ct1.b.B(new c0("method", h.b(dVar))), (qi.h) null, 12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
    
        if (r7 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(rp.i r6, sx1.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ip.v
            if (r0 == 0) goto L13
            r0 = r7
            ip.v r0 = (ip.v) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            ip.v r0 = new ip.v
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            bp.i0 r6 = r0.j
            ip.j r6 = (ip.j) r6
            lg.e.O(r7)
            return r7
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            bp.i0 r6 = r0.j
            lg.e.O(r7)
            goto L63
        L3c:
            lg.e.O(r7)
            qs1.p r6 = r6.a()
            boolean r7 = r6 instanceof bp.q
            if (r7 == 0) goto L4f
            ip.g r7 = new ip.g
            bp.q r6 = (bp.q) r6
            r7.<init>(r6)
            goto L75
        L4f:
            boolean r7 = r6 instanceof bp.i0
            if (r7 == 0) goto L84
            r7 = r6
            bp.i0 r7 = (bp.i0) r7
            r0.j = r7
            r0.m = r4
            ip.d r7 = r5.b
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L63
            goto L82
        L63:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L6e
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L6e:
            ip.i r7 = new ip.i
            bp.i0 r6 = (bp.i0) r6
            r7.<init>(r6)
        L75:
            r6 = 0
            r0.j = r6
            r0.m = r3
            ip.o r6 = r5.a
            java.lang.Object r6 = r6.a(r7, r0)
            if (r6 != r1) goto L83
        L82:
            return r1
        L83:
            return r6
        L84:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Unsupported auth type"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ip.w.b(rp.i, sx1.c):java.lang.Object");
    }
}
