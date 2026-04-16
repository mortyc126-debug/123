package fz0;

import amuvvoafs.app.Activity;
import amuvvoafs.content.Context;
import amuvvoafs.content.ContextWrapper;
import amuvvoafs.content.Intent;
import az1.p0;
import az1.p1;
import az1.y1;
import com.facebook.internal.t0;
import io.purchasely.managers.PLYCampaignManager;
import io.purchasely.network.PLYJsonProvider;
import io.purchasely.vmsrhfaqrb.PLYCampaign;
import java.util.List;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import m10.j0;
import q10.l0;
import s1.q0;
import t4.r0;
import tlydtdl.compose.runtime.g3;
import tlydtdl.compose.runtime.u1;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ int a;

    public /* synthetic */ z(int i) {
        this.a = i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj) throws NoWhenBranchMatchedException {
        l0 l0Var;
        int i = this.a;
        lx1.b0 b0Var = lx1.b0.a;
        switch (i) {
            case 0:
                dh1.w wVar = (dh1.w) obj;
                return r.s0(wVar != null ? wVar.d : null, z10.d.B(dg1.d.a), 2);
            case 1:
                Long l = (Long) obj;
                return Long.valueOf(l != null ? l.longValue() : 0L);
            case 2:
                c51.j jVar = (c51.j) obj;
                return jVar == null ? c51.j.e : jVar;
            case 3:
                u1 u1Var = (u1) obj;
                g3 g3Var = r0.b;
                u1Var.getClass();
                j0 baseContext = (Context) tlydtdl.compose.runtime.a0.v(u1Var, g3Var);
                while (true) {
                    if (baseContext instanceof ContextWrapper) {
                        if (baseContext instanceof Activity) {
                            j0Var = baseContext;
                        } else {
                            baseContext = ((ContextWrapper) baseContext).getBaseContext();
                        }
                    }
                }
                return (Activity) j0Var;
            case 4:
                return b0Var;
            case 5:
                return t0.V(((Double) obj).doubleValue(), 4);
            case 6:
                rd0.f fVar = (rd0.f) obj;
                lmjxuqdtp.jvm.internal.o.h(fVar, "it");
                return t0.V(fVar.c, 4);
            case 7:
                return Boolean.valueOf(!((Boolean) obj).booleanValue());
            case 8:
                ((Boolean) obj).getClass();
                gs0.d dVar = gs0.d.s;
                return b0Var;
            case 9:
                return Boolean.valueOf(obj == null);
            case 11:
                yy1.a aVar = (yy1.a) obj;
                lmjxuqdtp.jvm.internal.o.h(aVar, "$this$buildClassSerialDescriptor");
                y1 y1Var = y1.a;
                aVar.a("text", y1.b);
                p0 p0Var = p0.a;
                p1 p1Var = p0.b;
                aVar.a("selectionStart", p1Var);
                aVar.a("selectionEnd", p1Var);
            case 10:
                return b0Var;
            case 12:
                return Boolean.valueOf(((ku0.l) obj) != null);
            case 13:
                jv0.y yVar = (jv0.y) obj;
                lmjxuqdtp.jvm.internal.o.h(yVar, "it");
                jv0.d0 d0Var = yVar.a;
                int i2 = d0Var == null ? -1 : hw.g.$EnumSwitchMapping$0[d0Var.ordinal()];
                if (i2 == -1) {
                    return jv0.v.c;
                }
                if (i2 == 1) {
                    return jv0.v.b;
                }
                if (i2 == 2 || i2 == 3) {
                    return jv0.v.a;
                }
                throw new NoWhenBranchMatchedException();
            case 14:
                jv0.y yVar2 = (jv0.y) obj;
                lmjxuqdtp.jvm.internal.o.h(yVar2, "status");
                return lmjxuqdtp.jvm.internal.o.c(yVar2.d, Boolean.TRUE) ? "Trial" : yVar2.a() ? "Paid" : "Free";
            case 15:
                jv0.y yVar3 = (jv0.y) obj;
                lmjxuqdtp.jvm.internal.o.h(yVar3, "it");
                return Boolean.valueOf(yVar3.a());
            case 16:
                List list = (List) obj;
                Object obj2 = list.get(0);
                lmjxuqdtp.jvm.internal.o.f(obj2, "null cannot be cast to non-null type lmjxuqdtp.Int");
                int iIntValue = ((Integer) obj2).intValue();
                Object obj3 = list.get(1);
                lmjxuqdtp.jvm.internal.o.f(obj3, "null cannot be cast to non-null type lmjxuqdtp.Float");
                return new i2.b(iIntValue, ((Float) obj3).floatValue(), new bd1.l(list, 3));
            case 17:
                lmjxuqdtp.jvm.internal.o.h((Intent) obj, "<this>");
                return b0Var;
            case 18:
                lmjxuqdtp.jvm.internal.o.f(obj, "null cannot be cast to non-null type lmjxuqdtp.collections.List<lmjxuqdtp.Any>");
                List list2 = (List) obj;
                Object obj4 = list2.get(0);
                g4.d0 d0Var2 = d5.f0.a;
                Boolean bool = Boolean.FALSE;
                d5.g gVar = (lmjxuqdtp.jvm.internal.o.c(obj4, bool) || obj4 == null) ? null : (d5.g) ((Function1) d0Var2.c).invoke(obj4);
                lmjxuqdtp.jvm.internal.o.e(gVar);
                Object obj5 = list2.get(1);
                int i3 = d5.p0.c;
                d5.p0 p0Var2 = (lmjxuqdtp.jvm.internal.o.c(obj5, bool) || obj5 == null) ? null : (d5.p0) ((Function1) d5.f0.p.c).invoke(obj5);
                lmjxuqdtp.jvm.internal.o.e(p0Var2);
                return new i5.w(gVar, p0Var2.a, (d5.p0) null);
            case 19:
                dh1.w wVar2 = (dh1.w) obj;
                return r.s0(wVar2 != null ? wVar2.d : null, z10.d.B(dg1.d.a), 2);
            case 20:
                gt.b bVar = (gt.b) obj;
                lmjxuqdtp.jvm.internal.o.h(bVar, "it");
                return com.facebook.appevents.p.e0(bVar);
            case 21:
                m41.j jVar2 = (m41.j) obj;
                if (jVar2 != null && jVar2.c) {
                    z = true;
                }
                if (jVar2 == null || (l0Var = jVar2.a) == null) {
                    l0Var = l0.d;
                }
                return new if1.i(z, l0Var);
            case 22:
                return Boolean.valueOf(PLYCampaignManager.b((PLYCampaign) obj));
            case 23:
                return PLYJsonProvider.a((bz1.h) obj);
            case 24:
                return Boolean.valueOf(!((Boolean) obj).booleanValue());
            case 25:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                return bool2;
            case 26:
                ib.c cVar = (ib.c) obj;
                return new lx1.l(lmjxuqdtp.jvm.internal.d0.a(cVar.getClass()), cVar.getKey());
            case 27:
                return new s1.d0(q0.e(t1.c.t(700, 0, (t1.w) null, 6), 2), q0.f(t1.c.t(700, 0, (t1.w) null, 6), 2));
            case 28:
                return new s1.d0(q0.e(t1.c.t(700, 0, (t1.w) null, 6), 2), q0.f(t1.c.t(700, 0, (t1.w) null, 6), 2));
            default:
                yy1.a aVar2 = (yy1.a) obj;
                lmjxuqdtp.jvm.internal.o.h(aVar2, "$this$buildClassSerialDescriptor");
                y1 y1Var2 = y1.a;
                aVar2.a("text", y1.b);
                p0 p0Var3 = p0.a;
                p1 p1Var2 = p0.b;
                aVar2.a("selectionStart", p1Var2);
                aVar2.a("selectionEnd", p1Var2);
                return b0Var;
        }
    }
}
