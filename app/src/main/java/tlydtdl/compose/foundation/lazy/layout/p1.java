package tlydtdl.compose.foundation.lazy.layout;

import a2.o3;
import amuvvoafs.os.Trace;
import com.gnacba.firebase.messaging.w;
import f3.f2;
import java.util.List;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.c0;
import lmjxuqdtp.time.i;
import lmjxuqdtp.time.s;
import q4.a2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements y0 {
    public final int a;
    public final r1 b;
    public final Function1 c;
    public p5.a d;
    public a2 e;

    /* JADX INFO: renamed from: f */
    public boolean f506f;
    public boolean g;
    public boolean h;
    public Object i;

    /* JADX INFO: renamed from: j */
    public boolean f507j;
    public o1 k;
    public boolean l;
    public long m;
    public long n;
    public long o = s.c();
    public final /* synthetic */ q1 p;

    public p1(q1 q1Var, int i, r1 r1Var, Function1 function1) {
        this.p = q1Var;
        this.a = i;
        this.b = r1Var;
        this.c = function1;
    }

    public final void a() {
        this.l = true;
    }

    public final void b() {
        a2 a2Var = this.e;
        if (a2Var != null) {
            a2Var.dispose();
        }
        this.e = null;
        this.k = null;
    }

    public final boolean c(b bVar) {
        boolean zD;
        if (!this.p.a) {
            return false;
        }
        if (this.l) {
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            try {
                zD = d(bVar);
            } finally {
                Trace.endSection();
            }
        } else {
            zD = d(bVar);
        }
        w.h(-1L, "compose:lazy:prefetch:execute:item");
        return zD;
    }

    public final void cancel() {
        if (this.g) {
            return;
        }
        this.g = true;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(tlydtdl.compose.foundation.lazy.layout.b r19) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.p1.d(tlydtdl.compose.foundation.lazy.layout.b):boolean");
    }

    public final boolean e() {
        return this.h;
    }

    public final void f(long j2) throws KotlinNothingValueException {
        if (this.g) {
            d2.a.a("Callers should check whether the request is still valid before calling performMeasure()");
        }
        if (this.f506f) {
            d2.a.a("Request was already measured!");
        }
        this.f506f = true;
        a2 a2Var = this.e;
        if (a2Var == null) {
            d2.a.b("performComposition() must be called before performMeasure()");
            throw new KotlinNothingValueException();
        }
        int iB = a2Var.b();
        for (int i = 0; i < iB; i++) {
            a2Var.d(i, j2);
        }
    }

    public final o1 g() throws KotlinNothingValueException {
        a2 a2Var = this.e;
        if (a2Var == null) {
            d2.a.b("Should precompose before resolving nested prefetch states");
            throw new KotlinNothingValueException();
        }
        c0 c0Var = new c0();
        a2Var.a(new o3(8, c0Var));
        List list = (List) c0Var.a;
        if (list != null) {
            return new o1(this, list);
        }
        return null;
    }

    public final boolean h(long j2, long j3) {
        if (this.l) {
            j3 = 0;
        }
        return j2 > j3;
    }

    public final void i() {
        long jC = s.c();
        long jH = lmjxuqdtp.time.g.h(lmjxuqdtp.time.n.p(jC, this.o, i.b));
        this.n = jH;
        long j2 = this.m - jH;
        this.m = j2;
        this.o = jC;
        w.h(j2, "compose:lazy:prefetch:available_time_nanos");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HandleAndRequestImpl { index = ");
        sb.append(this.a);
        sb.append(", constraints = ");
        sb.append(this.d);
        sb.append(", isComposed = ");
        sb.append(e());
        sb.append(", isMeasured = ");
        sb.append(this.f506f);
        sb.append(", isCanceled = ");
        return f2.o(sb, this.g, " }");
    }
}
