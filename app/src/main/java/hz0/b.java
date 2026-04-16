package hz0;

import ay0.j;
import ay0.k;
import ay0.m;
import com.facebook.internal.t0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import i11.t;
import lmjxuqdtp.jvm.internal.o;
import m10.a1;
import m10.j0;
import ny1.p2;
import ny1.r2;
import ny1.z;
import o10.a4;
import o10.j1;
import okhttp3.HttpUrl;
import p10.l;
import rd1.v0;
import se0.q;
import uz1.g;
import wz0.y;
import x10.c;
import x10.f;
import x10.r;
import x10.v;
import xu.e;
import xu.h;
import xu.i;
import xu0.p;
import zs.d;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final l a;
    public final y b;
    public final t c;
    public final n0 d;
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f212f;
    public final String g;
    public final r h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f213j;
    public final bw.l k;

    public b(l lVar, y yVar, zx0.i iVar, e eVar, h hVar, t tVar, n0 n0Var, d dVar, p pVar, lmjxuqdtp.time.e eVar2) {
        ue0.b bVarQ;
        r rVar;
        r rVarD;
        o.h(lVar, "beat");
        this.a = lVar;
        this.b = yVar;
        this.c = tVar;
        this.d = n0Var;
        this.e = dVar;
        this.f212f = pVar;
        j1 j1Var = j1.INSTANCE;
        this.g = lVar.a;
        c cVar = v.Companion;
        this.h = a0.v(cVar, 2132017461);
        a1 a1VarJ = j4.J(lVar, (String) null);
        se0.d dVar2 = new se0.d(a1VarJ, false);
        boolean z = !yVar.f676j;
        this.i = z;
        v vVar = (v) yVar.o.getName().getValue();
        boolean zA = a();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (zA) {
            bVarQ = by1.b.W(dVar2, (p2) null, re0.l.c, j1Var, 5);
        } else {
            v vVarD = vVar;
            se0.p pVar2 = q.e2;
            re0.l lVar2 = re0.l.c;
            if (!bn1.c.z(vVarD)) {
                String str2 = a1VarJ.h;
                vVarD = c.d(str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2);
            }
            bVarQ = g.q(pVar2, dVar2, j1Var, vVarD, lVar2, 16);
        }
        zx0.l lVarB = zx0.i.b(iVar, dVar2, bVarQ, (j) null, new k(a() ? ay0.p.c : ay0.p.a, z, m.a, (ay0.h) null, a() ? ay0.d.c : ay0.d.a, 8), (a00.l) null, (a00.l) null, 116);
        this.f213j = hVar.a(lVar, x10.a.O(j1Var));
        xu.g gVarA = eVar.a(lVar);
        r2 r2VarC = z.c(z10.a.c);
        String str3 = lVar.b;
        x10.l lVarD = c.d(str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3);
        String strZ = dVar2.z();
        x10.l lVarD2 = c.d(strZ == null ? HttpUrl.FRAGMENT_ENCODE_SET : strZ);
        Double d = lVar.i;
        x10.l lVarD3 = c.d(t0.V(d != null ? d.doubleValue() : 0.0d, 6));
        String str4 = lVar.d;
        v vVarD2 = c.d(str4 != null ? str4 : str);
        Integer num = lVar.f385f;
        f fVarC = c.c(cVar, new v[]{vVarD2, c.g(new String[]{String.valueOf(num != null ? num.intValue() : 0)}, 2132017594)});
        xu.c cVar2 = gVarA.e;
        v0 v0VarU = ve.g.U(lVarB);
        j0 j0Var = lVar.l;
        boolean z2 = !o.c(lVar.m, Boolean.TRUE);
        hv.d dVar3 = new hv.d(this, 16);
        hv.d dVar4 = new hv.d(this, 17);
        re0.e eVar3 = lVarB.k;
        r2 r2VarC2 = z.c(eVar3 != null ? h02.a.R(eVar3) : null);
        p10.k kVar = lVar.y;
        lmjxuqdtp.time.l lVarA = kVar != null ? kVar.a() : null;
        xu.c cVar3 = gVarA.e;
        if (cVar3.d) {
            rVar = new r(2132018288);
        } else if (cVar3.c) {
            rVar = new r(2132020142);
        } else if (lVarA != null) {
            lmjxuqdtp.time.l lVarA2 = eVar2.a();
            o.h(lVarA2, "now");
            lx1.l lVarR = lg.e.R(lVarA2, lVarA);
            int iIntValue = ((Number) lVarR.a).intValue();
            int iIntValue2 = ((Number) lVarR.b).intValue();
            if (iIntValue == 0 && iIntValue2 <= 0) {
                rVarD = new r(2132018228);
            } else if (iIntValue != 0) {
                rVarD = c.b(new v[]{c.d(iIntValue + "d"), c.d(iIntValue2 + "h")}, v.c);
            } else {
                rVarD = c.d(iIntValue2 + "h");
            }
            rVar = c.b(new v[]{new r(2132018718), rVarD}, v.c);
        } else {
            rVar = new r(2132020563);
        }
        this.k = new bw.l(lVarD, lVarD2, lVarD3, fVarC, cVar2, v0VarU, j0Var, z2, z, rVar, dVar3, dVar4, r2VarC2, r2VarC);
    }

    public final boolean a() {
        if (!((Boolean) this.c.c(bt.g.a)).booleanValue()) {
            return false;
        }
        a4 a4Var = this.b.e;
        return a4Var == a4.F || a4Var == a4.G || a4Var == a4.n;
    }
}
