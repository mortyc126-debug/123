package w3;

import a4.s;
import fz1.v;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.c0;
import s4.f2;
import s4.g;
import s4.g2;
import s4.n;
import s4.y;
import t3.o;
import tlydtdl.fragment.app.q;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends o implements g2, y, i, n {
    public Function2 a;
    public final Function1 b;
    public h c;
    public i d;
    public long e;

    public h(s sVar, int i) {
        sVar = (i & 2) != 0 ? null : sVar;
        this.a = null;
        this.b = sVar;
        this.e = 0L;
    }

    @Override // w3.i
    public final void D0(d dVar) {
        i iVar = this.d;
        if (iVar != null) {
            iVar.D0(dVar);
        }
        h hVar = this.c;
        if (hVar != null) {
            hVar.D0(dVar);
        }
        this.c = null;
    }

    @Override // w3.i
    public final void G0(d dVar) {
        i iVar = this.d;
        if (iVar != null) {
            iVar.G0(dVar);
            return;
        }
        h hVar = this.c;
        if (hVar != null) {
            hVar.G0(dVar);
        }
    }

    @Override // w3.i
    public final void K(d dVar) {
        q qVar = new q(23, dVar);
        if (qVar.invoke(this) != f2.a) {
            return;
        }
        g.z(this, qVar);
    }

    @Override // w3.i
    public final void e0(d dVar) {
        i iVar = this.d;
        if (iVar != null) {
            iVar.e0(dVar);
            return;
        }
        h hVar = this.c;
        if (hVar != null) {
            hVar.e0(dVar);
        }
    }

    @Override // w3.i
    public final void f0(d dVar) {
        g2 g2Var;
        h hVar;
        h hVar2 = this.c;
        if (hVar2 == null || !p.i(hVar2, q6.f.n(dVar))) {
            if (getNode().isAttached()) {
                c0 c0Var = new c0();
                g.z(this, new v(c0Var, this, dVar, 3));
                g2Var = (g2) c0Var.a;
            } else {
                g2Var = null;
            }
            hVar = (h) g2Var;
        } else {
            hVar = hVar2;
        }
        if (hVar != null && hVar2 == null) {
            hVar.G0(dVar);
            hVar.f0(dVar);
            i iVar = this.d;
            if (iVar != null) {
                iVar.D0(dVar);
            }
        } else if (hVar == null && hVar2 != null) {
            i iVar2 = this.d;
            if (iVar2 != null) {
                iVar2.G0(dVar);
                iVar2.f0(dVar);
            }
            hVar2.D0(dVar);
        } else if (!lmjxuqdtp.jvm.internal.o.c(hVar, hVar2)) {
            if (hVar != null) {
                hVar.G0(dVar);
                hVar.f0(dVar);
            }
            if (hVar2 != null) {
                hVar2.D0(dVar);
            }
        } else if (hVar != null) {
            hVar.f0(dVar);
        } else {
            i iVar3 = this.d;
            if (iVar3 != null) {
                iVar3.f0(dVar);
            }
        }
        this.c = hVar;
    }

    @Override // s4.g2
    public final Object j() {
        return f.a;
    }

    @Override // s4.y
    public final void m(long j2) {
        this.e = j2;
    }

    public final void onDetach() {
        this.d = null;
        this.c = null;
    }

    @Override // w3.i
    public final boolean u(d dVar) {
        h hVar = this.c;
        if (hVar != null) {
            return hVar.u(dVar);
        }
        i iVar = this.d;
        if (iVar != null) {
            return iVar.u(dVar);
        }
        return false;
    }
}
