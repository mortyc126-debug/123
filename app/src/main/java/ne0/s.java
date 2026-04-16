package ne0;

import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.listmanager.pagination.impl.q;
import com.bandlab.media.player.impl.n;
import com.gnacba.amuvvoafs.gms.cast.MediaInfo;
import com.gnacba.amuvvoafs.gms.common.api.internal.BasePendingResult;
import com.gnacba.amuvvoafs.gms.internal.ads.d1;
import com.gnacba.amuvvoafs.gms.internal.ads.wc0;
import java.util.ArrayList;
import java.util.Arrays;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import m2.i2;
import ny1.r2;
import ny1.z;
import st.w0;
import tlydtdl.media3.exoplayer.ExoPlayer;
import w8.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public final y10.a a;
    public final x b;
    public final wc0 c;
    public final p81.f d;
    public final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kd.h f350f;
    public final n30.k g;
    public final r2 h;
    public final r2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r2 f351j;
    public p k;
    public final r2 l;
    public final i11.c m;
    public final n30.k n;

    public s(y10.a aVar, x xVar, h hVar, wc0 wc0Var, p81.f fVar, n nVar, kd.h hVar2) {
        this.a = aVar;
        this.b = xVar;
        this.c = wc0Var;
        this.d = fVar;
        this.e = nVar;
        this.f350f = hVar2;
        r2 r2Var = nVar.o;
        this.g = w0.o0(r2Var, new i2(19));
        Boolean bool = Boolean.FALSE;
        this.h = z.c(bool);
        this.i = z.c(bool);
        qx1.d dVar = null;
        this.f351j = z.c((Object) null);
        this.l = z.c(Boolean.valueOf(this.k != null));
        i11.c cVar = new i11.c(new lmjxuqdtp.time.a(14, this));
        this.m = cVar;
        this.n = w0.o0((r2) cVar.c, new i2(20));
        z.J(aVar, new am.p(20, xVar.c, new r(this, dVar, 0)));
        z.J(aVar, new d10.j(nVar.m, nVar.n, new q(this, (qx1.d) null, 3), 9));
        z.J(aVar, new am.p(20, new d10.j(z.U(r2Var, new b60.q(dVar, this, 9)), hVar.h, new es0.d(3, 5, dVar), 9), new r(this, dVar, 1)));
    }

    public final kp1.j a() {
        k kVar = (k) this.b.c.getValue();
        if (kVar != null) {
            return kVar.b;
        }
        return null;
    }

    public final boolean b() {
        ip1.p pVarD;
        MediaInfo mediaInfoR;
        se0.k kVarC;
        re0.e eVar = (re0.e) this.e.o.getValue();
        String strF = null;
        String str = (eVar == null || (kVarC = eVar.c()) == null) ? null : kVarC.a;
        kp1.j jVarA = a();
        if (jVarA != null && (pVarD = jVarA.d()) != null && (mediaInfoR = pVarD.R()) != null) {
            strF = mediaInfoR.F();
        }
        return o.c(str, strF);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void c(ke0.i iVar) throws NoWhenBranchMatchedException {
        BasePendingResult basePendingResultC;
        kp1.j jVarA = a();
        if (jVarA == null) {
            bb.w wVar = new bb.w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"Cast"});
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Remote media client is null when running action"), (String[]) Arrays.copyOf(strArr, strArr.length)));
            return;
        }
        if (iVar.equals(ke0.d.a)) {
            basePendingResultC = jVarA.u();
        } else if (iVar.equals(ke0.e.a)) {
            basePendingResultC = jVarA.v();
        } else {
            boolean z = iVar instanceof ke0.f;
            i11.c cVar = this.m;
            if (z) {
                cVar.w();
                basePendingResultC = jVarA.w(((ke0.f) iVar).a());
            } else if (iVar.equals(ke0.g.a)) {
                if (!d()) {
                    return;
                }
                cVar.w();
                d1 d1Var = new d1();
                d1Var.g(0L);
                basePendingResultC = jVarA.C(d1Var.e());
            } else {
                if (!(iVar instanceof ke0.h)) {
                    throw new NoWhenBranchMatchedException();
                }
                long jA = ((ke0.h) iVar).a();
                d1 d1Var2 = new d1();
                d1Var2.g(jA);
                basePendingResultC = jVarA.C(d1Var2.e());
            }
        }
        basePendingResultC.setResultCallback(new o(iVar));
    }

    public final boolean d() {
        return ((Boolean) this.l.getValue()).booleanValue() && ((Number) ((r2) this.m.c).getValue()).longValue() > 3000;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(boolean r20) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ne0.s.e(boolean):void");
    }

    public final void f() {
        ((d0) ((ExoPlayer) this.c.c)).setVolume(1.0f);
        p pVar = this.k;
        if (pVar != null) {
            kp1.j jVar = pVar.c;
            jVar.A(pVar.e);
            jVar.F(pVar.d);
            jVar.D();
            pVar.f348f.invoke();
        }
        this.k = null;
        s1.a.A(false, this.l, (Object) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void g() throws NoWhenBranchMatchedException {
        boolean zBooleanValue = ((Boolean) this.h.getValue()).booleanValue();
        r2 r2Var = this.l;
        if (zBooleanValue) {
            if (((Boolean) r2Var.getValue()).booleanValue()) {
                c(ke0.d.a);
            }
        } else if (((Boolean) r2Var.getValue()).booleanValue()) {
            c(ke0.e.a);
        } else {
            e(true);
        }
    }
}
