package v2;

import d5.p0;
import hy1.x;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import mx1.t;
import okhttp3.HttpUrl;
import rs1.d;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final i11.c a;
    public h b;
    public final n1 c;
    public final n1 d;
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k3.e f625f;

    public p(String str, long j2, i11.c cVar) {
        this.a = cVar;
        this.b = new h(new i(str, uc0.p.o(str.length(), j2), null, null, null, null, 60), null, null, null, 14);
        this.c = a0.t(Boolean.FALSE);
        this.d = a0.t(new i(str, j2, null, null, null, null, 60));
        this.e = new d(25, this);
        this.f625f = new k3.e(0, new n[16]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static final void a(p pVar, c cVar, boolean z, y2.c cVar2) throws NoWhenBranchMatchedException {
        i iVarC = pVar.c();
        if (((k3.e) pVar.b.a().b).c == 0 && p0.c(iVarC.d, pVar.b.e)) {
            if (o.c(iVarC.e, pVar.b.f622f) && o.c(iVarC.f624f, pVar.b.h) && o.c(iVarC.a, pVar.b.g)) {
                return;
            }
            i iVarC2 = pVar.c();
            String string = pVar.b.c.toString();
            h hVar = pVar.b;
            long j2 = hVar.e;
            p0 p0Var = hVar.f622f;
            pVar.h(iVarC2, new i(string, j2, p0Var, hVar.h, q.a(p0Var, hVar.g), null, 32), z);
            return;
        }
        boolean z2 = false;
        boolean z3 = ((k3.e) pVar.b.a().b).c != 0;
        String string2 = pVar.b.c.toString();
        h hVar2 = pVar.b;
        long j3 = hVar2.e;
        p0 p0Var2 = hVar2.f622f;
        i iVar = new i(string2, j3, p0Var2, hVar2.h, q.a(p0Var2, hVar2.g), null, 32);
        if (cVar == null) {
            if (z3 && z) {
                z2 = true;
            }
            pVar.h(iVarC, iVar, z2);
            pVar.d(iVarC, iVar, pVar.b.a(), cVar2);
            return;
        }
        h hVar3 = new h(iVar, pVar.b.a(), iVarC, null, 8);
        cVar.a(hVar3);
        boolean zI0 = x.i0(hVar3.c, iVar);
        boolean z4 = !zI0;
        boolean zC = p0.c(hVar3.e, iVar.d);
        boolean z5 = !zC;
        if (zI0 && zC) {
            pVar.h(iVarC, h.i(hVar3, 0L, iVar.e, null, 13), z);
        } else {
            pVar.g(hVar3, z4, z5);
        }
        pVar.d(iVarC, pVar.c(), hVar3.a(), cVar2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void b(h hVar) throws NoWhenBranchMatchedException {
        h hVar2;
        boolean z = ((k3.e) hVar.a().b).c > 0;
        boolean zC = p0.c(hVar.e, this.b.e);
        boolean z2 = !zC;
        if (!z && zC) {
            hVar.i = true;
        }
        if (z) {
            hVar2 = hVar;
            d(c(), h.i(hVar2, 0L, null, null, 15), hVar2.a(), y2.c.b);
        } else {
            hVar2 = hVar;
        }
        g(hVar2, z, z2);
    }

    public final i c() {
        return (i) this.d.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void d(i iVar, i iVar2, v80.h hVar, y2.c cVar) throws NoWhenBranchMatchedException {
        int iOrdinal = cVar.ordinal();
        i11.c cVar2 = this.a;
        if (iOrdinal == 0) {
            x30.c.w(cVar2, iVar, iVar2, hVar, true);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            x30.c.w(cVar2, iVar, iVar2, hVar, false);
        } else {
            ((n1) cVar2.c).setValue(null);
            y2.e eVar = (y2.e) cVar2.b;
            eVar.b.clear();
            eVar.c.clear();
        }
    }

    public final void e(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    public final h f() {
        s3.f fVarO = rs1.g.o();
        Function1 function1E = fVarO != null ? fVarO.e() : null;
        s3.f fVarP = rs1.g.p(fVarO);
        try {
            if (((Boolean) this.c.getValue()).booleanValue()) {
                d2.a.c("TextFieldState does not support concurrent or nested editing.");
            }
            e(true);
            return new h(c(), null, null, null, 14);
        } finally {
            rs1.g.s(fVarO, fVarP, function1E);
        }
    }

    public final void g(h hVar, boolean z, boolean z2) {
        i iVarI = h.i(this.b, 0L, null, null, 15);
        if (z) {
            this.b = new h(new i(hVar.c.toString(), hVar.e, null, null, null, null, 60), null, null, null, 14);
        } else if (z2) {
            h hVar2 = this.b;
            long j2 = hVar.e;
            int i = p0.c;
            hVar2.h(uc0.p.h((int) (j2 >> 32), (int) (j2 & 4294967295L)));
        }
        if (z || z2 || !o.c(iVarI.e, hVar.f622f)) {
            this.b.g(null);
        }
        h(iVarI, h.i(this.b, 0L, null, null, 15), true);
    }

    public final void h(i iVar, i iVar2, boolean z) {
        this.d.setValue(iVar2);
        e(false);
        k3.e eVar = this.f625f;
        Object[] objArr = eVar.a;
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((n) objArr[i2]).a(iVar, iVar2, (!z || x.i0(iVar.c, iVar2) || iVar.e == null) ? false : true);
        }
    }

    public final String toString() {
        s3.f fVarO = rs1.g.o();
        Function1 function1E = fVarO != null ? fVarO.e() : null;
        s3.f fVarP = rs1.g.p(fVarO);
        try {
            return "TextFieldState(selection=" + ((Object) p0.i(c().d)) + ", text=\"" + ((Object) c().c) + "\")";
        } finally {
            rs1.g.s(fVarO, fVarP, function1E);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p(String str, int i) {
        str = (i & 1) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        int length = str.length();
        this(str, uc0.p.h(length, length));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p(String str, long j2) {
        t tVar = t.a;
        this(str, j2, new i11.c((y2.d) null, new y2.e(100, tVar, tVar)));
    }
}
