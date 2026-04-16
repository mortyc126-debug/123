package l5;

import a4.r0;
import a4.u;
import a4.w0;
import a4.y;
import a4.z0;
import amuvvoafs.graphics.Paint;
import amuvvoafs.graphics.Shader;
import amuvvoafs.text.TextPaint;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import o5.l;
import tlydtdl.compose.runtime.h0;
import z3.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends TextPaint {
    public a4.i a;
    public l b;
    public int c;
    public z0 d;
    public y e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f277f;
    public h0 g;
    public e h;
    public c4.e i;

    public final r0 a() {
        a4.i iVar = this.a;
        if (iVar != null) {
            return iVar;
        }
        a4.i iVar2 = new a4.i(this);
        this.a = iVar2;
        return iVar2;
    }

    public final void b(int i) {
        if (i == this.c) {
            return;
        }
        a().d(i);
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(a4.u r6, long r7, float r9) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Ld
            r5.g = r0
            r5.f277f = r0
            r5.h = r0
            r5.setShader(r0)
            return
        Ld:
            boolean r1 = r6 instanceof a4.d1
            if (r1 == 0) goto L1d
            a4.d1 r6 = (a4.d1) r6
            long r6 = r6.a
            long r6 = st1.t1.F(r6, r9)
            r5.d(r6)
            return
        L1d:
            boolean r1 = r6 instanceof a4.y0
            if (r1 == 0) goto L74
            a4.u r1 = r5.f277f
            boolean r1 = lmjxuqdtp.jvm.internal.o.c(r1, r6)
            r2 = 0
            if (r1 == 0) goto L38
            z3.e r1 = r5.h
            if (r1 != 0) goto L30
            r1 = r2
            goto L36
        L30:
            long r3 = r1.a
            boolean r1 = z3.e.b(r3, r7)
        L36:
            if (r1 != 0) goto L59
        L38:
            r3 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L42
            r2 = 1
        L42:
            if (r2 == 0) goto L59
            r5.f277f = r6
            z3.e r1 = new z3.e
            r1.<init>(r7)
            r5.h = r1
            dm1.j r1 = new dm1.j
            r2 = 1
            r1.<init>(r6, r7, r2)
            tlydtdl.compose.runtime.h0 r6 = tlydtdl.compose.runtime.a0.q(r1)
            r5.g = r6
        L59:
            a4.r0 r6 = r5.a()
            tlydtdl.compose.runtime.h0 r7 = r5.g
            if (r7 == 0) goto L68
            java.lang.Object r7 = r7.getValue()
            amuvvoafs.graphics.Shader r7 = (amuvvoafs.graphics.Shader) r7
            goto L69
        L68:
            r7 = r0
        L69:
            a4.i r6 = (a4.i) r6
            r6.i(r7)
            r5.e = r0
            l5.j.c(r5, r9)
            return
        L74:
            lmjxuqdtp.NoWhenBranchMatchedException r6 = new lmjxuqdtp.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.d.c(a4.u, long, float):void");
    }

    public final void d(long j2) {
        y yVar = this.e;
        if (yVar == null ? false : y.c(yVar.a, j2)) {
            return;
        }
        if (j2 != 16) {
            this.e = new y(j2);
            setColor(w0.w(j2));
            this.g = null;
            this.f277f = null;
            this.h = null;
            setShader((Shader) null);
        }
    }

    public final void e(c4.e eVar) {
        if (eVar == null || o.c(this.i, eVar)) {
            return;
        }
        this.i = eVar;
        if (eVar.equals(c4.g.a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(eVar instanceof c4.h)) {
            throw new NoWhenBranchMatchedException();
        }
        a().m(1);
        c4.h hVar = (c4.h) eVar;
        a().l(hVar.a);
        a4.i iVarA = a();
        iVarA.a.setStrokeMiter(hVar.b);
        a().k(hVar.d);
        a().j(hVar.c);
        a().h(hVar.e);
    }

    public final void f(z0 z0Var) {
        if (z0Var == null || o.c(this.d, z0Var)) {
            return;
        }
        this.d = z0Var;
        if (z0Var.equals(z0.d)) {
            clearShadowLayer();
            return;
        }
        z0 z0Var2 = this.d;
        float f2 = z0Var2.c;
        if (f2 == 0.0f) {
            f2 = Float.MIN_VALUE;
        }
        setShadowLayer(f2, Float.intBitsToFloat((int) (z0Var2.b >> 32)), Float.intBitsToFloat((int) (this.d.b & 4294967295L)), w0.w(this.d.a));
    }

    public final void g(l lVar) {
        if (lVar == null || o.c(this.b, lVar)) {
            return;
        }
        this.b = lVar;
        int i = lVar.a;
        setUnderlineText((i | 1) == i);
        int i2 = this.b.a;
        setStrikeThruText((i2 | 2) == i2);
    }
}
