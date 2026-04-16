package g4;

import a4.b1;
import a4.d1;
import java.util.ArrayList;
import java.util.List;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import okhttp3.HttpUrl;
import tlydtdl.compose.foundation.lazy.layout.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e0 {
    public float[] b;
    public final ArrayList c = new ArrayList();
    public boolean d = true;
    public long e = a4.y.h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f153f;
    public boolean g;
    public a4.k h;
    public Function1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b1 f154j;
    public String k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;

    public c() {
        int i = j0.a;
        this.f153f = mx1.t.a;
        this.g = true;
        this.f154j = new b1(6, this);
        this.k = HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = 1.0f;
        this.p = 1.0f;
        this.s = true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // g4.e0
    public final void a(c4.d dVar) throws NoWhenBranchMatchedException {
        if (this.s) {
            float[] fArrA = this.b;
            if (fArrA == null) {
                fArrA = a4.m0.a();
                this.b = fArrA;
            } else {
                a4.m0.e(fArrA);
            }
            a4.m0.i(fArrA, this.q + this.m, this.r + this.n);
            a4.m0.f(fArrA, this.l);
            a4.m0.g(fArrA, this.o, this.p);
            a4.m0.i(fArrA, -this.m, -this.n);
            this.s = false;
        }
        if (this.g) {
            if (!this.f153f.isEmpty()) {
                a4.k kVarA = this.h;
                if (kVarA == null) {
                    kVarA = a4.o.a();
                    this.h = kVarA;
                }
                b.d(this.f153f, kVarA);
            }
            this.g = false;
        }
        r1 r1VarX0 = dVar.x0();
        long jO = r1VarX0.o();
        r1VarX0.j().o();
        try {
            r1 r1Var = (r1) ((ru1.c) r1VarX0.c).b;
            float[] fArr = this.b;
            if (fArr != null) {
                r1Var.j().r(fArr);
            }
            a4.k kVar = this.h;
            if (!this.f153f.isEmpty() && kVar != null) {
                r1Var.j().e(kVar, 1);
            }
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((e0) arrayList.get(i)).a(dVar);
            }
        } finally {
            s1.a.v(r1VarX0, jO);
        }
    }

    @Override // g4.e0
    public final Function1 b() {
        return this.i;
    }

    @Override // g4.e0
    public final void d(b1 b1Var) {
        this.i = b1Var;
    }

    public final void e(int i, e0 e0Var) {
        ArrayList arrayList = this.c;
        if (i < arrayList.size()) {
            arrayList.set(i, e0Var);
        } else {
            arrayList.add(e0Var);
        }
        g(e0Var);
        e0Var.d(this.f154j);
        c();
    }

    public final void f(long j2) {
        if (this.d && j2 != 16) {
            long j3 = this.e;
            if (j3 == 16) {
                this.e = j2;
                return;
            }
            int i = j0.a;
            if (a4.y.h(j3) == a4.y.h(j2) && a4.y.g(j3) == a4.y.g(j2) && a4.y.e(j3) == a4.y.e(j2)) {
                return;
            }
            this.d = false;
            this.e = a4.y.h;
        }
    }

    public final void g(e0 e0Var) {
        if (!(e0Var instanceof i)) {
            if (e0Var instanceof c) {
                c cVar = (c) e0Var;
                if (cVar.d && this.d) {
                    f(cVar.e);
                    return;
                } else {
                    this.d = false;
                    this.e = a4.y.h;
                    return;
                }
            }
            return;
        }
        i iVar = (i) e0Var;
        d1 d1Var = iVar.b;
        if (this.d && d1Var != null) {
            if (d1Var instanceof d1) {
                f(d1Var.a);
            } else {
                this.d = false;
                this.e = a4.y.h;
            }
        }
        d1 d1Var2 = iVar.g;
        if (this.d && d1Var2 != null) {
            if (d1Var2 instanceof d1) {
                f(d1Var2.a);
            } else {
                this.d = false;
                this.e = a4.y.h;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.k);
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            e0 e0Var = (e0) arrayList.get(i);
            sb.append("\t");
            sb.append(e0Var.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
