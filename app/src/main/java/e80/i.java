package e80;

import aq1.b;
import cs0.t;
import i2.a0;
import java.util.ArrayList;
import java.util.List;
import k80.u;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import n10.r;
import ny1.z;
import q10.s0;
import qx1.d;
import so0.v;
import uq0.g0;
import w2.i0;
import w2.o;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f98j;
    public int k;
    public /* synthetic */ int l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Object obj, int i, d dVar, int i2) {
        super(2, dVar);
        this.f98j = i2;
        this.m = obj;
        this.l = i;
    }

    public final d create(Object obj, d dVar) {
        switch (this.f98j) {
            case 0:
                return new i((a0) this.m, this.l, dVar, 0);
            case 1:
                return new i((j80.i) this.m, this.l, dVar, 1);
            case 2:
                return new i((u) this.m, this.l, dVar, 2);
            case 3:
                i iVar = new i((g0) this.m, dVar, 3);
                iVar.l = ((Number) obj).intValue();
                return iVar;
            case 4:
                i iVar2 = new i((i0) this.m, dVar, 4);
                iVar2.l = ((Number) obj).intValue();
                return iVar2;
            default:
                return new i((z70.u) this.m, this.l, dVar, 5);
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f98j) {
            case 0:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 1:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 2:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 3:
                return create(Integer.valueOf(((Number) obj).intValue()), (d) obj2).invokeSuspend(b0.a);
            case 4:
                return create(Integer.valueOf(((Number) obj).intValue()), (d) obj2).invokeSuspend(b0.a);
            default:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        bt.l lVar;
        o oVar;
        x20.k kVar;
        y70.a aVar;
        switch (this.f98j) {
            case 0:
                rx1.a aVar2 = rx1.a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    a0 a0Var = (a0) this.m;
                    int i2 = this.l;
                    this.k = 1;
                    if (a0.g(i2, a0Var, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            case 1:
                j80.i iVar = (j80.i) this.m;
                rx1.a aVar3 = rx1.a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    lg.e.O(obj);
                    t tVarX = b.x(iVar.n);
                    this.k = 1;
                    obj = z.C(tVarX, this);
                    if (obj == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                mx1.t tVar = (List) obj;
                if (tVar == null) {
                    tVar = mx1.t.a;
                }
                j80.c cVar = (j80.c) mx1.o.z0(this.l, tVar);
                if (cVar != null && (cVar.a instanceof s0)) {
                    n10.f fVar = cVar.h;
                    iVar.f.c(new n10.c(fVar != null ? fVar.b : null, r.INSTANCE), n10.b.b);
                }
                return b0.a;
            case 2:
                u uVar = (u) this.m;
                rx1.a aVar4 = rx1.a.a;
                int i4 = this.k;
                if (i4 == 0) {
                    lg.e.O(obj);
                    t tVarX2 = b.x(uVar.t);
                    this.k = 1;
                    obj = z.C(tVarX2, this);
                    if (obj == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                List list = (List) obj;
                vu0.d dVar = list != null ? (vu0.d) mx1.o.z0(this.l, list) : null;
                wz0.i0 i0Var = dVar instanceof wz0.i0 ? (wz0.i0) dVar : null;
                if (i0Var != null && (lVar = i0Var.f670j) != null) {
                    uVar.v.b(lVar);
                }
                return b0.a;
            case 3:
                g0 g0Var = (g0) this.m;
                v1 v1Var = g0Var.a;
                int i6 = this.l;
                rx1.a aVar5 = rx1.a.a;
                int i7 = this.k;
                b0 b0Var = b0.a;
                if (i7 == 0) {
                    lg.e.O(obj);
                    a21.u uVar2 = (a21.u) g0Var.s.a.getValue();
                    if (uVar2 != null) {
                        String str = uVar2.a;
                        ArrayList arrayListC = g0Var.u.c();
                        v vVar = (v) mx1.o.z0(i6 % arrayListC.size(), arrayListC);
                        if (vVar != null) {
                            if (lmjxuqdtp.jvm.internal.o.c(g0Var.w.a.getValue(), vVar)) {
                                so0.a aVarC = lt.b.c();
                                this.l = i6;
                                this.k = 2;
                                if (qb0.a.k(v1Var, str, aVarC, this) == aVar5) {
                                    return aVar5;
                                }
                            } else {
                                this.l = i6;
                                this.k = 1;
                                if (qb0.a.k(v1Var, str, vVar, this) == aVar5) {
                                    return aVar5;
                                }
                            }
                        }
                    }
                } else {
                    if (i7 != 1 && i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0Var;
            case 4:
                rx1.a aVar6 = rx1.a.a;
                int i8 = this.k;
                b0 b0Var2 = b0.a;
                if (i8 == 0) {
                    lg.e.O(obj);
                    if (Math.abs(this.l) == 1 && (oVar = ((i0) this.m).n) != null) {
                        this.k = 1;
                        Object objO = c0.o(new qi.k(oVar, (d) null, 14), this);
                        if (objO != aVar6) {
                            objO = b0Var2;
                        }
                        if (objO == aVar6) {
                            return aVar6;
                        }
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0Var2;
            default:
                z70.u uVar3 = (z70.u) this.m;
                b0 b0Var3 = rx1.a.a;
                int i9 = this.k;
                if (i9 == 0) {
                    lg.e.O(obj);
                    t tVarX3 = b.x(uVar3.E);
                    this.k = 1;
                    obj = z.C(tVarX3, this);
                    if (obj != b0Var3) {
                    }
                    return b0Var3;
                }
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lg.e.O(obj);
                List list2 = (List) obj;
                b0Var3 = b0.a;
                if (list2 != null && (kVar = (vu0.d) mx1.o.z0(this.l, list2)) != null) {
                    if (kVar instanceof x20.k) {
                        bt.l lVar2 = kVar.a.f670j;
                        if (lVar2 != null) {
                            uVar3.H.b(lVar2);
                        }
                    } else if (kVar instanceof wz0.i0) {
                        bt.l lVar3 = ((wz0.i0) kVar).f670j;
                        if (lVar3 != null) {
                            uVar3.H.b(lVar3);
                        }
                    } else if (kVar instanceof o80.b) {
                        uVar3.H.b(((o80.b) kVar).b);
                    } else if (kVar instanceof x70.d) {
                        Object value = uVar3.p.e.getValue();
                        x70.c cVar2 = value instanceof x70.c ? (x70.c) value : null;
                        if (cVar2 != null && (aVar = (y70.a) mx1.o.y0(cVar2.a)) != null) {
                            aVar.h.invoke();
                        }
                    }
                }
                return b0Var3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Object obj, d dVar, int i) {
        super(2, dVar);
        this.f98j = i;
        this.m = obj;
    }
}
