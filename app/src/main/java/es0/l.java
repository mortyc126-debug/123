package es0;

import a2.p4;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.net.Uri;
import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.installation.checker.ApkInstallationChecker;
import com.bandlab.invite.link.collaborator.screen.q;
import com.bandlab.navigation.entry.NavigationActivity;
import com.bandlab.tuner.ui.TunerActivity;
import com.bandlab.video.post.player.VideoPlayerActivity;
import ev0.v;
import fz0.k0;
import hy1.x;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jv0.i0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.k;
import lx1.b0;
import ny1.r2;
import ny1.z;
import o10.a4;
import oz0.d1;
import oz0.f2;
import q10.h0;
import qi.y;
import r20.f0;
import t10.f;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.i1;
import we0.a0;
import we0.n;
import xg0.l0;
import y11.l1;
import yr.q1;
import zs.j0;
import zs.m1;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l extends k implements Function0 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.b = i3;
    }

    public final Object invoke() {
        f fVar;
        String str;
        String str2;
        String str3;
        n hVar;
        int i = this.b;
        ApkInstallationChecker apkInstallationChecker = ApkInstallationChecker.a;
        b0 b0Var = b0.a;
        switch (i) {
            case 0:
                a aVar = (a) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                aVar.c.e(aVar.b.b("studio_setting_membership_banner", lx0.s.INSTANCE));
                return b0Var;
            case 1:
                t tVar = (t) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                c0.F(tVar.h, (qx1.i) null, (ky1.b0) null, new q(tVar, (qx1.d) null, 22), 3);
                return b0Var;
            case 2:
                t tVar2 = (t) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                tVar2.b.e(tVar2.e.e((URL) tVar2.i.c(f.a)));
                return b0Var;
            case 3:
                ((t) ((lmjxuqdtp.jvm.internal.d) this).receiver).f116j.a();
                return b0Var;
            case 4:
                t tVar3 = (t) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                tVar3.s.invoke();
                tVar3.g.a(xg0.m.b);
                xu0.p pVar = tVar3.b;
                j0 j0Var = tVar3.e;
                vc1.i iVar = TunerActivity.o;
                Context context = j0Var.a;
                iVar.getClass();
                pVar.e(vc1.i.b(context, "studio_settings", true));
                return b0Var;
            case 5:
                NavigationActivity navigationActivity = (NavigationActivity) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                int i2 = NavigationActivity.r;
                navigationActivity.getClass();
                if (apkInstallationChecker.isInstallationCorrect(navigationActivity) && navigationActivity.l != null) {
                    v vVarY = navigationActivity.y();
                    Intent intent = navigationActivity.getIntent();
                    ev0.d dVar = vVarY.e;
                    if (dVar.c.b()) {
                        xu0.f fVar2 = dVar.b;
                        if (fVar2.b) {
                            dVar.a.setIntent(intent != null ? intent.putExtra("branch_force_new_session", true) : null);
                            dVar.c();
                        } else {
                            fVar2.b = true;
                            ev0.c cVar = (ev0.c) dVar.i.getValue();
                            cVar.getClass();
                            s02.b bVar = s02.d.a;
                            String str4 = "BranchSDK:: initializing when the current instance is " + nw1.c.k();
                            bVar.getClass();
                            s02.b.p(str4);
                            ComponentActivity componentActivity = cVar.a;
                            nw1.c.h(componentActivity.getApplicationContext());
                            s02.b.p("BranchSDK:: init with " + cq1.d.B(intent));
                            bt.b bVarU = nw1.c.u(componentActivity);
                            nw1.b bVar2 = cVar.b;
                            h02.a.S("InitSessionBuilder setting BranchReferralInitListener withCallback with " + bVar2);
                            bVarU.c = bVar2;
                            Uri data = intent != null ? intent.getData() : null;
                            h02.a.S("InitSessionBuilder setting withData with " + data);
                            bVarU.d = data;
                            bVarU.f();
                            r2 r2Var = dVar.f.a;
                            Boolean bool = Boolean.TRUE;
                            r2Var.getClass();
                            r2Var.i((Object) null, bool);
                        }
                    }
                }
                return b0Var;
            case 6:
                NavigationActivity navigationActivity2 = (NavigationActivity) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                int i3 = NavigationActivity.r;
                navigationActivity2.getClass();
                if (apkInstallationChecker.isInstallationCorrect(navigationActivity2) && navigationActivity2.p != null) {
                    c0.F(i1.f(navigationActivity2.getLifecycle()), (qx1.i) null, (ky1.b0) null, new p4(navigationActivity2, (qx1.d) null, 16), 3);
                }
                return b0Var;
            case 7:
                ev0.h hVar2 = (ev0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                String strB = hVar2.a.b();
                lVarC = strB != null ? m1.c(hVar2.b, strB, (oh1.f) null, (lh1.a) null, (h0) null, (lx1.l) null, 62) : null;
                if (lVarC != null) {
                    hVar2.c.e(lVarC);
                } else {
                    w wVar = new w(2);
                    ArrayList arrayList = wVar.a;
                    wVar.a("CRITICAL");
                    wVar.e(new String[0]);
                    String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("User id is null when trying to open profile"), (String[]) Arrays.copyOf(strArr, strArr.length)));
                }
                return b0Var;
            case 8:
                ((b80.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 9:
                t10.j jVar = (t10.j) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                t10.g gVar = jVar.c;
                List list = (List) gVar.a().e;
                if (list.size() > 1) {
                    ArrayList arrayListP0 = mx1.o.P0(list, mx1.o.G0(list));
                    gVar.a().a(arrayListP0);
                    lVarC = (Integer) mx1.o.G0(arrayListP0);
                }
                if (lVarC != null) {
                    zi.k kVar = (zi.k) jVar.e.d(jVar, t10.j.k[0]);
                    r70.a aVar2 = jVar.g;
                    int iIntValue = lVarC.intValue();
                    if (iIntValue == 0) {
                        fVar = ((t10.h) aVar2.b).b;
                    } else if (iIntValue == 1) {
                        fVar = ((t10.h) aVar2.c).b;
                    } else if (iIntValue == 2) {
                        fVar = ((t10.h) aVar2.d).b;
                    } else if (iIntValue == 3) {
                        fVar = ((t10.h) aVar2.f).b;
                    } else {
                        if (iIntValue != 4) {
                            aVar2.getClass();
                            throw new IllegalArgumentException(o6.c.k(iIntValue, "Invalid Nav Item index "));
                        }
                        fVar = ((t10.h) aVar2.e).b;
                    }
                    kVar.a(fVar);
                } else {
                    w wVar2 = new w(2);
                    ArrayList arrayList2 = wVar2.a;
                    wVar2.a("CRITICAL");
                    wVar2.e(new String[0]);
                    String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Backstack is empty"), (String[]) Arrays.copyOf(strArr2, strArr2.length)));
                }
                return b0Var;
            case 10:
                a80.o oVar = ((a80.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).a;
                q1 q1Var = oVar.e;
                fy1.l[] lVarArr = a80.o.i;
                ((zi.k) q1Var.d(oVar, lVarArr[1])).a((List) oVar.c.b());
                ((zi.k) oVar.f.d(oVar, lVarArr[2])).a((a80.r) oVar.d.b());
                ((zi.k) oVar.b.d(oVar, lVarArr[0])).a(Boolean.TRUE);
                return b0Var;
            case 11:
                f80.m mVar = (f80.m) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                c0.F(i1.f(mVar.b), (qx1.i) null, (ky1.b0) null, new q(mVar, (qx1.d) null, 29), 3);
                return b0Var;
            case 12:
                ((fg0.e) ((lmjxuqdtp.jvm.internal.d) this).receiver).e(bk.g.a);
                return b0Var;
            case 13:
                ((fg0.e) ((lmjxuqdtp.jvm.internal.d) this).receiver).e(bk.d.a);
                return b0Var;
            case 14:
                ((fg0.e) ((lmjxuqdtp.jvm.internal.d) this).receiver).e(bk.c.a);
                return b0Var;
            case 15:
                ((fg0.e) ((lmjxuqdtp.jvm.internal.d) this).receiver).c().a(Boolean.FALSE);
                return b0Var;
            case 16:
                ((v) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 17:
                fz0.f fVar3 = (fz0.f) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                jv0.n nVar = fVar3.a.a.a.m;
                if (nVar != null && (str = nVar.a) != null) {
                    dt.g gVar2 = fVar3.c;
                    try {
                        String host = new URL(str).getHost();
                        lmjxuqdtp.jvm.internal.o.g(host, "getHost(...)");
                        y.k(gVar2.a, "post_link_open", ct1.b.B(new qi.c0("link_type", x.k0(host, "bandlab.com", false) ? "bandlab" : "external")), (qi.h) null, 12);
                    } catch (Exception e) {
                        s02.d.a.getClass();
                        s02.b.s("Failed to parse link to url", e);
                    }
                    fVar3.b.e(tk1.b.c(fVar3.d.i, str));
                }
                return b0Var;
            case 18:
                ((fz0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).b();
                return b0Var;
            case 19:
                ((fz0.w) ((lmjxuqdtp.jvm.internal.d) this).receiver).f();
                return b0Var;
            case 20:
                fz0.w wVar3 = (fz0.w) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                vu0.c cVar2 = wVar3.d().s;
                lVarC = cVar2 != null ? cVar2.a : null;
                if (lVarC == null || !wVar3.b()) {
                    wVar3.f();
                } else {
                    wVar3.c.e(wVar3.d.c(lVarC, new f0(a4.g)));
                }
                return b0Var;
            case 21:
                fz0.w wVar4 = (fz0.w) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var2 = wVar4.n;
                r2 r2Var3 = wVar4.m;
                l1 l1Var = wVar4.l;
                if (l1Var != null && (str2 = l1Var.a) != null) {
                    z10.d.H(r2Var3, new kw0.a(str2, l1Var));
                    if (r2Var2.getValue() == null) {
                        i0 i0Var = wVar4.h;
                        m10.f fVar4 = wVar4.d().e;
                        r2Var2.i((Object) null, wVar4.b.a(new kw0.b(wVar4.g, kw0.c.c, false, new f41.b(21, wVar4), new fk1.g(7, wVar4, dd.v.y(fVar4 != null ? fVar4.a : null, i0Var) ? xg0.i0.g : l0.c), r2Var3)));
                    }
                }
                return b0Var;
            case 22:
                fz0.c0 c0Var = (fz0.c0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                n10.f fVar5 = c0Var.k().C;
                c0Var.d.a(fVar5 != null ? fVar5.a : null, c0Var.a.n, n10.a.h);
                return b0Var;
            case 23:
                iz0.a aVar3 = (iz0.a) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                xu0.p pVar2 = aVar3.b;
                n0 n0Var = aVar3.d;
                wz0.y yVar = aVar3.a;
                d1 d1Var = yVar.a.a;
                String strS = mu0.u.s(yVar.e);
                lmjxuqdtp.jvm.internal.o.h(d1Var, "post");
                pVar2.e(zs.f.c(n0Var.k, xn1.a.t(d1Var), strS));
                return b0Var;
            case 24:
                ((fz0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).b();
                return b0Var;
            case 25:
                fz0.c0 c0Var2 = (fz0.c0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var4 = c0Var2.E;
                Boolean bool2 = Boolean.FALSE;
                r2Var4.getClass();
                r2Var4.i((Object) null, bool2);
                if (((Boolean) c0Var2.b.c(bt.g.a)).booleanValue() && c0Var2.y() == wz0.e.b) {
                    ((lj1.h) c0Var2.g.l.getValue()).b.play();
                }
                return b0Var;
            case 26:
                fz0.f0 f0Var = (fz0.f0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                if (!f0Var.b.f676j) {
                    y yVar2 = f0Var.f140j;
                    qi.h hVar3 = qi.h.b;
                    ArrayList arrayList3 = new ArrayList();
                    String str5 = f0Var.b().a;
                    if (str5 != null) {
                        o6.c.D("post_id", str5, arrayList3);
                    }
                    m10.f fVar6 = f0Var.b().e;
                    String str6 = fVar6 != null ? fVar6.a : null;
                    if (str6 != null) {
                        o6.c.D("post_creator_user_id", str6, arrayList3);
                    }
                    y.k(yVar2, "post_reaction_list_open", arrayList3, hVar3, 8);
                    xu0.l lVar = f0Var.b().E;
                    if (lVar != null) {
                        lVarC = lVar;
                    } else if (f0Var.b().c == f2.h) {
                        lVarC = f0Var.b().a;
                    }
                    if (!DebugUtils.debugThrowIfNull(lVarC, i.n("post with id :", f0Var.b().a, " has null postCompositeId"), new String[0])) {
                        long jLongValue = ((Number) f0Var.l.getValue()).longValue();
                        lmjxuqdtp.jvm.internal.o.h(lVarC, "postCompositeId");
                        f0Var.c.e(new xi.e("post_reactions_dialog", new ol1.p(2, jLongValue, lVarC)));
                    }
                }
                return b0Var;
            case 27:
                fz0.h0 h0Var = (fz0.h0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                wz0.y yVar3 = h0Var.a;
                if (yVar3.d && !yVar3.f676j) {
                    xu0.p pVar3 = h0Var.b;
                    n0 n0Var2 = h0Var.c;
                    d1 d1VarA = h0Var.a();
                    lmjxuqdtp.jvm.internal.o.h(d1VarA, "post");
                    pVar3.e(n0Var2.h.b(d1VarA));
                }
                return b0Var;
            case 28:
                fz0.h0 h0Var2 = (fz0.h0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var5 = h0Var2.r;
                r2 r2Var6 = h0Var2.q;
                l1 l1Var2 = h0Var2.m;
                if (l1Var2 != null && (str3 = l1Var2.a) != null) {
                    z10.d.H(r2Var6, new kw0.a(str3, l1Var2));
                    if (r2Var5.getValue() == null) {
                        i0 i0Var2 = h0Var2.i;
                        m10.f fVar7 = h0Var2.a().e;
                        r2Var5.i((Object) null, h0Var2.h.a(new kw0.b(h0Var2.d, kw0.c.c, true, new f41.b(22, h0Var2), new fk1.g(8, h0Var2, dd.v.y(fVar7 != null ? fVar7.a : null, i0Var2) ? xg0.i0.g : l0.c), r2Var6)));
                    }
                }
                return b0Var;
            default:
                k0 k0Var = (k0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                wz0.y yVar4 = k0Var.a;
                we0.b0 b0Var2 = k0Var.d;
                d1 d1VarB = k0Var.b();
                oz0.n0 n0Var3 = k0Var.b().t;
                d1 d1VarY = d1.y(d1VarB, null, null, (oz0.n0) (n0Var3 != null ? z.c(n0Var3) : yVar4.m).getValue(), null, null, null, -524289, 63);
                a0 a0VarA = b0Var2.a(d1VarY.a, ct1.b.B(d1VarY));
                if (yVar4.e == a4.b) {
                    n10.w wVar5 = n10.w.INSTANCE;
                    we0.b bVar3 = we0.b.a;
                    hVar = new n(a0VarA, wVar5);
                } else {
                    hVar = new we0.h(a0VarA);
                }
                n nVar2 = hVar;
                n0 n0Var4 = k0Var.c;
                we0.w wVar6 = new we0.w(nVar2, yVar4.e, yVar4.o.a(), (lh1.a) null, (q10.y) null, false, 88);
                int i4 = VideoPlayerActivity.l;
                k0Var.b.e(new xu0.l(qr.m.t(n0Var4.a, wVar6), -1));
                return b0Var;
        }
    }
}
