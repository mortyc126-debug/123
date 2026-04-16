package jg0;

import a21.t;
import ak.n0;
import ak.p0;
import ak.r0;
import java.util.List;
import k7.w;
import ky1.a0;
import ky1.c0;
import ky1.m0;
import lg.e;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function4;
import lx1.b0;
import ng0.f;
import ny1.b2;
import qx1.d;
import sx1.i;
import uo0.u;
import wk.g;
import wk.h;
import wk.m;
import wk.n;
import wk.o;
import x10.c;
import x10.v;
import y11.d2;
import yr.x4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i implements Function4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f235j;
    public int k;
    public /* synthetic */ boolean l;
    public /* synthetic */ Object m;
    public /* synthetic */ Object n;
    public final /* synthetic */ Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, d dVar, int i) {
        super(4, dVar);
        this.f235j = i;
        this.o = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.f235j) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                j jVar = new j((l) this.o, (d) obj4, 0);
                jVar.l = zBooleanValue;
                jVar.n = (r0) obj2;
                jVar.m = (Integer) obj3;
                return jVar.invokeSuspend(b0.a);
            case 1:
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                j jVar2 = new j((f) this.o, (d) obj4, 1);
                jVar2.n = (n) obj;
                jVar2.l = zBooleanValue2;
                jVar2.m = (Integer) obj3;
                return jVar2.invokeSuspend(b0.a);
            default:
                boolean zBooleanValue3 = ((Boolean) obj3).booleanValue();
                j jVar3 = new j((uq0.l) this.o, (d) obj4, 2);
                jVar3.n = (u) obj;
                jVar3.m = (List) obj2;
                jVar3.l = zBooleanValue3;
                return jVar3.invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        Object objR;
        t tVar;
        int i = this.f235j;
        Object obj2 = this.o;
        switch (i) {
            case 0:
                l lVar = (l) obj2;
                boolean z = this.l;
                r0 r0Var = (r0) this.n;
                Integer num = (Integer) this.m;
                rx1.a aVar = rx1.a.a;
                int i2 = this.k;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return obj;
                }
                e.O(obj);
                if (r0Var instanceof n0) {
                    a21.e eVar = (a21.e) lVar.a.a.x.getValue();
                    fy.a aVar2 = lVar.d;
                    String str = eVar.a;
                    d2 d2Var = eVar.g;
                    int i3 = d2Var.a;
                    String strA = d2Var.b.a();
                    String str2 = eVar.f;
                    p0 p0VarC = lVar.c();
                    a21.u uVarF = eVar.f();
                    aVar2.f((Integer) null, (Integer) null, (Integer) null, str, (uVarF == null || (tVar = uVarF.b) == null) ? null : tVar.c(), i3, strA, str2, p0VarC, "fail");
                }
                this.n = null;
                this.m = null;
                this.l = z;
                this.k = 1;
                if (r0Var == null) {
                    objR = null;
                } else {
                    ry1.e eVar2 = m0.a;
                    objR = c0.R(ry1.d.b, new d10.d(r0Var, lVar, z, num, (d) null, 1), this);
                }
                return objR == aVar ? aVar : objR;
            case 1:
                f fVar = (f) obj2;
                a0 a0Var = fVar.a;
                g gVar = fVar.g;
                w wVar = fVar.h;
                n nVar = (n) this.n;
                boolean z2 = this.l;
                Integer num2 = (Integer) this.m;
                rx1.a aVar3 = rx1.a.a;
                int i4 = this.k;
                if (i4 == 0) {
                    e.O(obj);
                    if (!(nVar instanceof h)) {
                        if (nVar instanceof wk.i) {
                            wk.i iVar = (wk.i) nVar;
                            return new og0.a(iVar.a, iVar.b);
                        }
                        if (nVar instanceof wk.l) {
                            wk.l lVar2 = (wk.l) nVar;
                            boolean z3 = lVar2.b;
                            boolean z4 = lVar2.a;
                            o oVar = (o) nVar;
                            b2 b2VarE = wVar.e(oVar, a0Var);
                            b2 b2VarF = wVar.f(oVar, a0Var);
                            wVar.getClass();
                            return new og0.b(z3, z4, b2VarE, b2VarF, w.d(oVar), lVar2.e, lVar2.f661f, (float) lVar2.g, z2, lVar2.h, lVar2.i, lVar2.f662j, num2);
                        }
                        if (!lmjxuqdtp.jvm.internal.o.c(nVar, m.a)) {
                            if (lmjxuqdtp.jvm.internal.o.c(nVar, wk.j.a)) {
                                return null;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        p81.f fVar2 = fVar.c;
                        v.Companion.getClass();
                        fVar2.l(c.g(new String[]{"64"}, 2132019213));
                        ((xl.g) gVar).j();
                        return null;
                    }
                    x4 x4Var = fVar.b;
                    double d = ((h) nVar).a;
                    this.n = null;
                    this.m = null;
                    this.l = z2;
                    this.k = 1;
                    if (x4Var.d(d, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                ((xl.g) gVar).j();
                return null;
            default:
                u uVar = (u) this.n;
                List list = (List) this.m;
                boolean z5 = this.l;
                rx1.a aVar4 = rx1.a.a;
                int i6 = this.k;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return obj;
                }
                e.O(obj);
                uq0.l lVar3 = (uq0.l) obj2;
                b41.c cVar = lVar3.o;
                d10.j jVar = lVar3.i;
                this.n = null;
                this.m = null;
                this.l = z5;
                this.k = 1;
                cVar.getClass();
                Object objR2 = c0.R(m0.a, new uq0.n(cVar, uVar, z5, jVar, list, (d) null), this);
                return objR2 == aVar4 ? aVar4 : objR2;
        }
    }
}
