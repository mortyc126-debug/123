package cu0;

import a21.m;
import a21.t;
import a21.u;
import dd.v;
import du0.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.internal.o;
import lu0.s;
import lx1.b0;
import lx1.r;
import oc0.c;
import oc0.f;
import qx1.d;
import sx1.i;
import zg0.a2;
import zg0.b2;
import zg0.m1;
import zg0.n1;
import zg0.o1;
import zg0.p1;
import zg0.q1;
import zg0.r1;
import zg0.s1;
import zg0.t1;
import zg0.u1;
import zg0.v1;
import zg0.x1;
import zg0.y1;
import zg0.z1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i implements Function4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f62j;
    public /* synthetic */ boolean k;
    public /* synthetic */ Object l;
    public /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i, int i2, d dVar) {
        super(i, dVar);
        this.f62j = i2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.f62j) {
            case 0:
                ((Boolean) obj2).getClass();
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                h hVar = new h((q) this.m, (d) obj4);
                hVar.l = (a) obj;
                hVar.k = zBooleanValue;
                return hVar.invokeSuspend(b0.a);
            case 1:
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                h hVar2 = new h(4, 1, (d) obj4);
                hVar2.l = (f) obj;
                hVar2.k = zBooleanValue2;
                hVar2.m = (tc0.h) obj3;
                return hVar2.invokeSuspend(b0.a);
            case 2:
                boolean zBooleanValue3 = ((Boolean) obj2).booleanValue();
                h hVar3 = new h(4, 2, (d) obj4);
                hVar3.l = (u) obj;
                hVar3.k = zBooleanValue3;
                hVar3.m = (b2) obj3;
                return hVar3.invokeSuspend(b0.a);
            case 3:
                boolean zBooleanValue4 = ((Boolean) obj).booleanValue();
                h hVar4 = new h(4, 3, (d) obj4);
                hVar4.k = zBooleanValue4;
                hVar4.l = (a21.e) obj2;
                hVar4.m = (Map) obj3;
                return hVar4.invokeSuspend(b0.a);
            default:
                boolean zBooleanValue5 = ((Boolean) obj3).booleanValue();
                h hVar5 = new h(4, 4, (d) obj4);
                hVar5.l = (u) obj;
                hVar5.m = (r) obj2;
                hVar5.k = zBooleanValue5;
                return hVar5.invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        n1 v1Var;
        m1 m1Var = null;
        switch (this.f62j) {
            case 0:
                q qVar = (q) this.m;
                a aVar = (a) this.l;
                boolean z = this.k;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                if (aVar.b().isEmpty() || !z) {
                    return null;
                }
                du0.f fVarA = q.a(qVar, aVar.a());
                List listB = aVar.b();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = listB.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(q.a(qVar, (js0.p) it.next()));
                }
                return new du0.e(fVarA, linkedHashSet);
            case 1:
                f fVar = (f) this.l;
                boolean z2 = this.k;
                tc0.h hVar = (tc0.h) this.m;
                rx1.a aVar3 = rx1.a.a;
                lg.e.O(obj);
                if (fVar instanceof c) {
                    return fVar;
                }
                tc0.h.Companion.getClass();
                return o.c(hVar, tc0.h.c) ? oc0.d.a : (!v.w(hVar) || z2) ? oc0.e.a : oc0.b.a;
            case 2:
                u uVar = (u) this.l;
                boolean z3 = this.k;
                b2 b2Var = (b2) this.m;
                rx1.a aVar4 = rx1.a.a;
                lg.e.O(obj);
                if (uVar == null || uVar.l || !com.facebook.appevents.p.D(uVar)) {
                    return null;
                }
                String str = uVar.a;
                t tVar = uVar.b;
                boolean z4 = tVar instanceof a21.l;
                y1 y1Var = y1.a;
                a2 a2Var = a2.a;
                if (z4) {
                    if (z3) {
                        if (b2Var instanceof x1) {
                            m1Var = m1.c;
                        } else if (b2Var instanceof z1) {
                            m1Var = m1.b;
                        } else if (o.c(b2Var, a2Var)) {
                            m1Var = m1.a;
                        } else if (!o.c(b2Var, y1Var)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    v1Var = new n1(str, m1Var);
                } else if (tVar instanceof m) {
                    if (z3) {
                        if (o.c(b2Var, a2Var)) {
                            m1Var = o1.a;
                        } else if (b2Var instanceof z1) {
                            m1Var = o1.b;
                        } else if (!(b2Var instanceof x1) && !o.c(b2Var, y1Var)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    v1Var = new p1(str, m1Var);
                } else if (tVar instanceof a21.o) {
                    if (z3) {
                        if (o.c(b2Var, a2Var)) {
                            m1Var = q1.a;
                        } else if (b2Var instanceof z1) {
                            m1Var = q1.b;
                        } else if (o.c(b2Var, y1Var)) {
                            m1Var = q1.c;
                        } else if (!(b2Var instanceof x1)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    v1Var = new r1(str, m1Var);
                } else if (tVar instanceof a21.p) {
                    if (z3) {
                        if (o.c(b2Var, a2Var)) {
                            m1Var = s1.a;
                        } else if (b2Var instanceof z1) {
                            m1Var = s1.b;
                        } else if (!(b2Var instanceof x1) && !o.c(b2Var, y1Var)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    v1Var = new t1(str, m1Var);
                } else {
                    if (!(tVar instanceof a21.q)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (z3) {
                        if (o.c(b2Var, a2Var)) {
                            m1Var = u1.a;
                        } else if (b2Var instanceof z1) {
                            m1Var = u1.b;
                        } else if (!(b2Var instanceof x1) && !o.c(b2Var, y1Var)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    v1Var = new v1(str, m1Var);
                }
                return v1Var;
            case 3:
                boolean z5 = this.k;
                a21.e eVar = (a21.e) this.l;
                Map map = (Map) this.m;
                rx1.a aVar5 = rx1.a.a;
                lg.e.O(obj);
                if (!z5) {
                    return Boolean.FALSE;
                }
                return eVar.c == null ? Boolean.FALSE : Boolean.valueOf(!((Boolean) map.getOrDefault(r8, Boolean.FALSE)).booleanValue());
            default:
                u uVar2 = (u) this.l;
                r rVar = (r) this.m;
                boolean z6 = this.k;
                rx1.a aVar6 = rx1.a.a;
                lg.e.O(obj);
                boolean zBooleanValue = ((Boolean) rVar.a).booleanValue();
                boolean zBooleanValue2 = ((Boolean) rVar.b).booleanValue();
                boolean zBooleanValue3 = ((Boolean) rVar.c).booleanValue();
                if (zBooleanValue) {
                    return new s();
                }
                if (!z6 && !uVar2.l) {
                    if (com.facebook.appevents.p.C(uVar2) == null) {
                        return lu0.r.a;
                    }
                    if (!zBooleanValue2 && !zBooleanValue3 && com.facebook.appevents.p.C(uVar2) != null) {
                        return new lu0.p();
                    }
                }
                return lu0.q.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(q qVar, d dVar) {
        super(4, dVar);
        this.f62j = 0;
        this.m = qVar;
    }
}
