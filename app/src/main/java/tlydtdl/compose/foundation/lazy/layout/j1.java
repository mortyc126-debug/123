package tlydtdl.compose.foundation.lazy.layout;

import a2.k2;
import a4.b1;
import a5.i;
import a5.v;
import a5.w;
import lmjxuqdtp.jvm.functions.Function0;
import s4.b2;
import t3.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends o implements b2 {
    public Function0 a;
    public g1 b;
    public k2 c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f504f;
    public final h1 g = new h1(this, 0);
    public h1 h;

    public j1(Function0 function0, g1 g1Var, k2 k2Var, boolean z, boolean z2) {
        this.a = function0;
        this.b = g1Var;
        this.c = k2Var;
        this.d = z;
        this.e = z2;
        Q0();
    }

    public final void Q0() {
        this.f504f = new i(new i1(this, 0), new i1(this, 1), this.e);
        this.h = this.d ? new h1(this, 1) : null;
    }

    @Override // s4.b2
    public final void b(a5.k kVar) {
        fy1.l[] lVarArr = v.a;
        w wVar = a5.t.m;
        fy1.l[] lVarArr2 = v.a;
        fy1.l lVar = lVarArr2[6];
        wVar.a(kVar, Boolean.TRUE);
        kVar.h(a5.t.L, this.g);
        if (this.c == k2.a) {
            i iVar = this.f504f;
            if (iVar == null) {
                lmjxuqdtp.jvm.internal.o.m("scrollAxisRange");
                throw null;
            }
            w wVar2 = a5.t.u;
            fy1.l lVar2 = lVarArr2[12];
            wVar2.a(kVar, iVar);
        } else {
            i iVar2 = this.f504f;
            if (iVar2 == null) {
                lmjxuqdtp.jvm.internal.o.m("scrollAxisRange");
                throw null;
            }
            w wVar3 = a5.t.t;
            fy1.l lVar3 = lVarArr2[11];
            wVar3.a(kVar, iVar2);
        }
        h1 h1Var = this.h;
        if (h1Var != null) {
            kVar.h(a5.j.f, new a5.a((String) null, h1Var));
        }
        kVar.h(a5.j.B, new a5.a((String) null, new b1(3, new i1(this, 2))));
        a5.b bVarC = this.b.c();
        w wVar4 = a5.t.f;
        fy1.l lVar4 = lVarArr2[22];
        wVar4.a(kVar, bVarC);
    }

    public final boolean getShouldAutoInvalidate() {
        return false;
    }
}
