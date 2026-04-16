package ge1;

import a2.w3;
import am.p;
import ky1.a0;
import lg.e;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.time.g;
import lmjxuqdtp.time.n;
import lx1.b0;
import ny1.z;
import sx1.i;
import tlydtdl.compose.runtime.e1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f181j;
    public /* synthetic */ Object k;
    public final /* synthetic */ d l;
    public final /* synthetic */ e1 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, e1 e1Var, qx1.d dVar2, int i) {
        super(2, dVar2);
        this.f181j = i;
        this.l = dVar;
        this.m = e1Var;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f181j) {
            case 0:
                b bVar = new b(this.l, this.m, dVar, 0);
                bVar.k = obj;
                return bVar;
            default:
                b bVar2 = new b(this.l, this.m, dVar, 1);
                bVar2.k = obj;
                return bVar2;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        qx1.d dVar = (qx1.d) obj2;
        switch (this.f181j) {
            case 0:
                b bVarCreate = create(a0Var, dVar);
                b0 b0Var = b0.a;
                bVarCreate.invokeSuspend(b0Var);
                return b0Var;
            default:
                b bVarCreate2 = create(a0Var, dVar);
                b0 b0Var2 = b0.a;
                bVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f181j;
        b0 b0Var = b0.a;
        final int i2 = 0;
        d dVar = this.l;
        e1 e1Var = this.m;
        switch (i) {
            case 0:
                a0 a0Var = (a0) this.k;
                rx1.a aVar = rx1.a.a;
                e.O(obj);
                z.J(a0Var, z10.d.l(new a(e1Var, null, 0), dVar.b));
                break;
            default:
                a0 a0Var2 = (a0) this.k;
                rx1.a aVar2 = rx1.a.a;
                e.O(obj);
                int i3 = g.d;
                a20.a aVar3 = new a20.a(n.s(300, lmjxuqdtp.time.i.d), a10.a.c, a0Var2);
                Function1 function1 = dVar.c;
                final int i4 = 2;
                if (function1 != null) {
                    z.J(a0Var2, new p(20, aVar3.f4f, new au1.b(2, function1, (qx1.d) null)));
                }
                e1Var.setValue(aVar3);
                final w3 w3Var = dVar.a;
                if (w3Var instanceof f2.a0) {
                    z.J(a0Var2, new p(20, tlydtdl.compose.runtime.a0.z(new Function0() { // from class: ge1.c
                        public final Object invoke() {
                            switch (i2) {
                                case 0:
                                    return w3Var.h();
                                case 1:
                                    return Boolean.valueOf(w3Var.i.b());
                                default:
                                    return Integer.valueOf(w3Var.k());
                            }
                        }
                    }), new tlydtdl.lifecycle.a0(e1Var, null, 12)));
                    Function1 function12 = dVar.d;
                    if (function12 != null) {
                        final int i6 = 1;
                        z.J(a0Var2, new p(20, tlydtdl.compose.runtime.a0.z(new Function0() { // from class: ge1.c
                            public final Object invoke() {
                                switch (i6) {
                                    case 0:
                                        return w3Var.h();
                                    case 1:
                                        return Boolean.valueOf(w3Var.i.b());
                                    default:
                                        return Integer.valueOf(w3Var.k());
                                }
                            }
                        }), new tlydtdl.lifecycle.a0(w3Var, function12, null, 13)));
                    }
                } else if (w3Var instanceof i2.a0) {
                    z.J(a0Var2, new p(20, tlydtdl.compose.runtime.a0.z(new Function0() { // from class: ge1.c
                        public final Object invoke() {
                            switch (i4) {
                                case 0:
                                    return w3Var.h();
                                case 1:
                                    return Boolean.valueOf(w3Var.i.b());
                                default:
                                    return Integer.valueOf(w3Var.k());
                            }
                        }
                    }), new es0.n(dVar, e1Var, (qx1.d) null, 29)));
                }
                break;
        }
        return b0Var;
    }
}
