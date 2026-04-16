package b60;

import java.util.List;
import lg.e;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.functions.Function6;
import lx1.b0;
import lx1.r;
import ne0.s;
import ny1.r2;
import qx1.d;
import tc0.p;
import tlydtdl.compose.foundation.lazy.layout.r1;
import uq0.g0;
import uq0.o0;
import x10.c;
import x10.v;
import xu1.v0;
import yr.n4;
import yr.u1;
import yr.v7;
import yr.x4;
import za0.f;
import za0.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f20j;
    public int k;
    public /* synthetic */ Object l;
    public /* synthetic */ Object m;
    public /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, d dVar, int i) {
        super(3, dVar);
        this.f20j = i;
        this.l = obj;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    private final Object b(Object obj) throws NoWhenBranchMatchedException {
        za0.n nVar = (za0.n) this.l;
        rx1.a aVar = rx1.a.a;
        int i = this.k;
        if (i == 0) {
            e.O(obj);
            ny1.m mVar = (ny1.m) this.m;
            r rVar = (r) this.n;
            g dVar = (g) rVar.a;
            g gVar = (g) ((z10.a) rVar.b).a();
            if (gVar != null && !(dVar instanceof f)) {
                if (dVar instanceof za0.d) {
                    if ((gVar instanceof za0.e) || gVar.equals(f.a)) {
                        dVar = (za0.d) dVar;
                    } else {
                        if (!(gVar instanceof za0.d)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        c cVar = v.Companion;
                        List listE0 = mx1.n.e0(new v[]{((za0.d) dVar).a, ((za0.d) gVar).a});
                        cVar.getClass();
                        dVar = new za0.d(c.a(listE0, c.d("\n")));
                    }
                } else {
                    if (!(dVar instanceof za0.e)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    dVar = gVar;
                }
            }
            String str = nVar.h;
            r2 oVar = (((str == null || hy1.q.L0(str)) && nVar.d) || !(dVar instanceof za0.e)) ? new ny1.o(1, dVar) : nVar.f;
            this.m = null;
            this.n = null;
            this.k = 1;
            if (ny1.z.x(mVar, oVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e.O(obj);
        }
        return b0.a;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f20j) {
            case 0:
                q qVar = new q((z) this.l, (d) obj3, 0);
                qVar.m = (String) obj;
                qVar.n = (List) obj2;
                return qVar.invokeSuspend(b0.a);
            case 1:
                q qVar2 = new q((d) obj3, (z) this.l, 1);
                qVar2.m = (ny1.m) obj;
                qVar2.n = obj2;
                return qVar2.invokeSuspend(b0.a);
            case 2:
                q qVar3 = new q((d) obj3, (bp0.l) this.l, 2);
                qVar3.m = (ny1.m) obj;
                qVar3.n = obj2;
                return qVar3.invokeSuspend(b0.a);
            case 3:
                q qVar4 = new q((d) obj3, (dk.d) this.l, 3);
                qVar4.m = (ny1.m) obj;
                qVar4.n = obj2;
                return qVar4.invokeSuspend(b0.a);
            case 4:
                q qVar5 = new q((List) this.n, (d) obj3);
                qVar5.m = (ny1.m) obj;
                qVar5.l = obj2;
                return qVar5.invokeSuspend(b0.a);
            case 5:
                q qVar6 = new q((d) obj3, (r1) this.l, 5);
                qVar6.m = (ny1.m) obj;
                qVar6.n = obj2;
                return qVar6.invokeSuspend(b0.a);
            case 6:
                q qVar7 = new q((d) obj3, (hw.q) this.l, 6);
                qVar7.m = (ny1.m) obj;
                qVar7.n = obj2;
                return qVar7.invokeSuspend(b0.a);
            case 7:
                q qVar8 = new q((ij1.i) this.l, (d) obj3, 7);
                qVar8.m = (ks1.j) obj;
                qVar8.n = (ij1.f) obj2;
                return qVar8.invokeSuspend(b0.a);
            case 8:
                q qVar9 = new q((d) obj3, (k81.l) this.l, 8);
                qVar9.m = (ny1.m) obj;
                qVar9.n = obj2;
                return qVar9.invokeSuspend(b0.a);
            case 9:
                q qVar10 = new q((d) obj3, (s) this.l, 9);
                qVar10.m = (ny1.m) obj;
                qVar10.n = obj2;
                return qVar10.invokeSuspend(b0.a);
            case 10:
                q qVar11 = new q(this.l, (d) obj3, 10);
                qVar11.m = (ny1.m) obj;
                qVar11.n = obj2;
                return qVar11.invokeSuspend(b0.a);
            case 11:
                q qVar12 = new q((d) obj3, (Function4) this.l, 11);
                qVar12.m = (ny1.m) obj;
                qVar12.n = (Object[]) obj2;
                return qVar12.invokeSuspend(b0.a);
            case 12:
                q qVar13 = new q((d) obj3, this.l, 12);
                qVar13.m = (ny1.m) obj;
                qVar13.n = (Object[]) obj2;
                return qVar13.invokeSuspend(b0.a);
            case 13:
                q qVar14 = new q((d) obj3, (Function6) this.l, 13);
                qVar14.m = (ny1.m) obj;
                qVar14.n = (Object[]) obj2;
                return qVar14.invokeSuspend(b0.a);
            case 14:
                q qVar15 = new q((Function3) this.l, (d) obj3, 14);
                qVar15.m = (ny1.m) obj;
                qVar15.n = (Object[]) obj2;
                return qVar15.invokeSuspend(b0.a);
            case 15:
                q qVar16 = new q((d) obj3, (lf.d) this.l, 15);
                qVar16.m = (ny1.m) obj;
                qVar16.n = (Object[]) obj2;
                return qVar16.invokeSuspend(b0.a);
            case 16:
                q qVar17 = new q((d) obj3, (rt0.h) this.l, 16);
                qVar17.m = (ny1.m) obj;
                qVar17.n = obj2;
                return qVar17.invokeSuspend(b0.a);
            case 17:
                q qVar18 = new q((d) obj3, (s51.b0) this.l, 17);
                qVar18.m = (ny1.m) obj;
                qVar18.n = obj2;
                return qVar18.invokeSuspend(b0.a);
            case 18:
                q qVar19 = new q((d) obj3, (sc0.c) this.l, 18);
                qVar19.m = (ny1.m) obj;
                qVar19.n = obj2;
                return qVar19.invokeSuspend(b0.a);
            case 19:
                q qVar20 = new q((d) obj3, (uq0.l) this.l, 19);
                qVar20.m = (ny1.m) obj;
                qVar20.n = obj2;
                return qVar20.invokeSuspend(b0.a);
            case 20:
                q qVar21 = new q((g0) this.l, (d) obj3, 20);
                qVar21.m = (a21.u) obj;
                qVar21.n = (so0.v) obj2;
                return qVar21.invokeSuspend(b0.a);
            case 21:
                q qVar22 = new q((d) obj3, (ut0.f) this.l, 21);
                qVar22.m = (ny1.m) obj;
                qVar22.n = obj2;
                return qVar22.invokeSuspend(b0.a);
            case 22:
                q qVar23 = new q((v0) this.l, (d) obj3, 22);
                qVar23.m = (ny1.m) obj;
                qVar23.n = (Throwable) obj2;
                return qVar23.invokeSuspend(b0.a);
            case 23:
                q qVar24 = new q((d) obj3, (u1) this.l, 23);
                qVar24.m = (ny1.m) obj;
                qVar24.n = obj2;
                return qVar24.invokeSuspend(b0.a);
            case 24:
                q qVar25 = new q((d) obj3, (n4) this.l, 24);
                qVar25.m = (ny1.m) obj;
                qVar25.n = obj2;
                return qVar25.invokeSuspend(b0.a);
            case 25:
                q qVar26 = new q((d) obj3, (x4) this.l, 25);
                qVar26.m = (ny1.m) obj;
                qVar26.n = obj2;
                return qVar26.invokeSuspend(b0.a);
            case 26:
                q qVar27 = new q((d) obj3, (o0) this.l, 26);
                qVar27.m = (ny1.m) obj;
                qVar27.n = obj2;
                return qVar27.invokeSuspend(b0.a);
            case 27:
                q qVar28 = new q((d) obj3, (v7) this.l, 27);
                qVar28.m = (ny1.m) obj;
                qVar28.n = obj2;
                return qVar28.invokeSuspend(b0.a);
            case 28:
                q qVar29 = new q((d) obj3, (za0.n) this.l, 28);
                qVar29.m = (ny1.m) obj;
                qVar29.n = obj2;
                return qVar29.invokeSuspend(b0.a);
            default:
                q qVar30 = new q((zq0.c) this.l, (String) this.m, (d) obj3);
                qVar30.n = (p) obj2;
                return qVar30.invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08e4  */
    /* JADX WARN: Type inference failed for: r0v59, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function5] */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 2832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b60.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(List list, d dVar) {
        super(3, dVar);
        this.f20j = 4;
        this.n = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(d dVar, Object obj, int i) {
        super(3, dVar);
        this.f20j = i;
        this.l = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zq0.c cVar, String str, d dVar) {
        super(3, dVar);
        this.f20j = 29;
        this.l = cVar;
        this.m = str;
    }
}
