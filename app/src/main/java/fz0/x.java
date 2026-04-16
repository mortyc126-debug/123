package fz0;

import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function0;
import m10.j0;
import ny1.k;
import okhttp3.HttpUrl;
import oz0.d1;
import oz0.i0;
import rd1.v0;
import wz0.n0;
import x10.r;
import zs.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ gz0.f b;

    public /* synthetic */ x(gz0.f fVar, int i) {
        this.a = i;
        this.b = fVar;
    }

    public final Object invoke() {
        v0 v0VarU;
        Long l;
        switch (this.a) {
            case 0:
                gz0.f fVar = this.b;
                m10.q qVar = fVar.a.c;
                if (qVar != null) {
                    fVar.c.e(m1.c(fVar.f.b, qVar.a, (oh1.f) null, (lh1.a) null, (q10.h0) null, (lx1.l) null, 62));
                }
                return lx1.b0.a;
            case 1:
                gz0.f fVar2 = this.b;
                m10.q qVar2 = fVar2.a.c;
                if (qVar2 != null) {
                    fVar2.c.e(m1.c(fVar2.f.b, qVar2.a, (oh1.f) null, (lh1.a) null, (q10.h0) null, (lx1.l) null, 62));
                }
                return lx1.b0.a;
            case 2:
                gz0.f fVar3 = this.b;
                lmjxuqdtp.jvm.internal.o.h(fVar3, "<this>");
                oz0.i iVar = fVar3.a;
                m10.q qVar3 = iVar.c;
                String str = fVar3.i;
                v80.h hVar = new v80.h((r) null);
                x10.c cVar = x10.v.Companion;
                String str2 = qVar3 != null ? qVar3.b : null;
                if (str2 == null) {
                    str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                cVar.getClass();
                wz0.g0 g0Var = new wz0.g0(new ny1.o(1, x10.c.d(str2)), new ny1.o(1, Boolean.valueOf(qVar3 != null ? lmjxuqdtp.jvm.internal.o.c(qVar3.g, Boolean.TRUE) : false)), null, new ny1.o(1, (Object) null), false, new ny1.o(1, y10.r.s0(qVar3 != null ? qVar3.e : null, z10.d.B(dg1.d.a), 2)), new x(fVar3, 0), new x(fVar3, 1), false, mx1.t.a, new cs0.t(10, new wz0.a[0]), ny1.z.c((Object) null), false, null, ny1.z.c(new wz0.f0(null, new wz0.d0(fVar3.r, new y10.i(y10.l.c), false), null, 5)), false);
                String str3 = iVar.f382j;
                n0 n0Var = new n0(str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3, 1, of1.q.b(), null, null, null, null, null, null, false, null, new bn0.i(1, fVar3, gz0.f.class, "onHashtagClick", "onHashtagClick(Ljava/lang/String;)V", 0, 20), new bn0.i(1, fVar3, gz0.f.class, "onMentionClick", "onMentionClick(Ljava/lang/String;)V", 0, 18), new bn0.i(1, fVar3, gz0.f.class, "onUrlClick", "onUrlClick(Ljava/lang/String;)V", 0, 19), null, null, 34808);
                String str4 = iVar.b;
                String str5 = str4 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str4;
                m10.f fVar4 = iVar.d;
                String str6 = fVar4 != null ? fVar4.b : null;
                String str7 = str6 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str6;
                oz0.k0 k0Var = iVar.p;
                String strName = k0Var != null ? k0Var.name() : null;
                String str8 = strName == null ? HttpUrl.FRAGMENT_ENCODE_SET : strName;
                String str9 = fVar3.j;
                oz0.h hVar2 = iVar.e;
                gf1.b bVar = new gf1.b(ny1.z.c(Long.valueOf((hVar2 == null || (l = hVar2.a) == null) ? 0L : l.longValue())));
                j0 j0Var = iVar.i;
                if (fVar3.k) {
                    Boolean bool = Boolean.FALSE;
                    v0VarU = new v0(null, ny1.z.c(bool), ny1.z.c(bool), ny1.z.c(Float.valueOf(0.0f)), true, ny1.z.c(Boolean.TRUE), k.a, null);
                } else {
                    v0VarU = ve.g.U(fVar3.n);
                }
                v0 v0Var = v0VarU;
                ArrayList<gz0.b> arrayList = fVar3.p;
                ArrayList arrayList2 = new ArrayList(mx1.p.c0(arrayList, 10));
                for (gz0.b bVar2 : arrayList) {
                    d1 d1Var = bVar2.a.a.a;
                    i0 i0Var = d1Var.n;
                    String str10 = i0Var != null ? i0Var.a : null;
                    if (str10 == null) {
                        str10 = HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                    arrayList2.add(new xz0.b(str10, lmjxuqdtp.jvm.internal.o.c(d1Var.u, Boolean.TRUE), ve.g.U(bVar2.e)));
                }
                Integer num = fVar3.q;
                return new wz0.i0(str, ny1.z.c((Object) null), hVar, g0Var, n0Var, new xz0.c(str5, str7, str8, str9, bVar, j0Var, v0Var, fVar3.t, arrayList2, num != null ? num.intValue() : 0, fVar3.k, new b0(0, fVar3, gz0.f.class, "openAlbumPage", "openAlbumPage()Lcom/bandlab/vmsrhfaqrb/navigation/NavigationAction;", 8, 2), fVar3.s, fVar3.o), new lg.f(null, null, null, null, true, null, null), new g(0));
            default:
                gz0.f fVar5 = this.b;
                dt.g gVar = fVar5.h;
                n10.f fVar6 = fVar5.l;
                gVar.a(fVar6 != null ? fVar6.f : null, fVar5.b.n, n10.a.e);
                return lx1.b0.a;
        }
    }
}
