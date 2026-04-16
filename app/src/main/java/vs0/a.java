package vs0;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.content.SharedPreferences;
import com.bandlab.bandlab.AppGraph$$;
import com.bandlab.bandlab.feature.mixeditor.viewmodel.MixEditorGraph$$;
import d01.k;
import dh0.h;
import f3.f2;
import gw.l;
import hg1.q;
import i11.c;
import iw1.b;
import jv0.i0;
import jw1.e;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import p81.f;
import qi.y;
import qu0.u;
import xu0.p;
import y10.j;
import y61.t;
import y80.d;
import yr.b3;
import yr.d3;
import yr.e6;
import yr.f1;
import yr.n1;
import yr.p1;
import zj.n;
import zs.e1;
import zs.i1;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {
    public final /* synthetic */ int a;
    public final b b;
    public final b c;

    public /* synthetic */ a(b bVar, b bVar2, int i) {
        this.a = i;
        this.b = bVar;
        this.c = bVar2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                n nVar = (n) this.b.invoke();
                s11.b bVar = (s11.b) this.c.invoke();
                o.h(nVar, "audioController");
                o.h(bVar, "revisionRepository");
                return new c(29, nVar, bVar);
            case 1:
                y yVar = (y) this.b.invoke();
                mt.b bVar2 = (mt.b) this.c.invoke();
                o.h(yVar, "tracker");
                o.h(bVar2, "apiServiceFactory");
                return new w41.b(yVar, bVar2);
            case 2:
                k kVar = (k) this.b.invoke();
                s00.b bVar3 = (s00.b) this.c.invoke();
                o.h(kVar, "preferenceConfig");
                o.h(bVar3, "activityLifecycleCallbacksProvider");
                return new l(1, kVar, bVar3);
            case 3:
                k kVar2 = (k) this.b.invoke();
                lmjxuqdtp.time.e eVar = (lmjxuqdtp.time.e) this.c.invoke();
                o.h(kVar2, "preferences");
                o.h(eVar, "clock");
                return new wg.a(kVar2, eVar);
            case 4:
                f fVar = (f) this.b.invoke();
                t10.n nVar2 = (t10.n) this.c.invoke();
                o.h(fVar, "toaster");
                o.h(nVar2, "navigationEffectBus");
                return new wn0.a(fVar, nVar2);
            case 5:
                t tVar = (t) this.b.invoke();
                i11.t tVar2 = (i11.t) this.c.invoke();
                o.h(tVar, "pipeline");
                o.h(tVar2, "remoteConfig");
                return new vb.a(tVar, tVar2);
            case 6:
                Context context = (Context) this.b.invoke();
                String str = (String) this.c.invoke();
                o.h(context, "context");
                o.h(str, "googleidClientId");
                return new xo.c(context, str);
            case 7:
                j0 j0Var = (j0) this.b.invoke();
                mt.b bVar4 = (mt.b) this.c.invoke();
                o.h(j0Var, "fromMixEditorNavigation");
                o.h(bVar4, "apiServiceFactory");
                return new xr.b(j0Var, bVar4);
            case 8:
                i0 i0Var = (i0) this.b.invoke();
                mt.b bVar5 = (mt.b) this.c.invoke();
                o.h(i0Var, "userProvider");
                o.h(bVar5, "apiServiceFactory");
                return new xt.e(i0Var, bVar5);
            case 9:
                f1 f1Var = (f1) this.b.invoke();
                i11.t tVar3 = (i11.t) this.c.invoke();
                o.h(f1Var, "bottomPanelSlot");
                o.h(tVar3, "remoteConfig");
                return new u(f1Var, tVar3);
            case 10:
                m41.k kVar3 = (m41.k) this.b.invoke();
                mt.b bVar6 = (mt.b) this.c.invoke();
                o.h(kVar3, "followRepository");
                o.h(bVar6, "apiServiceFactory");
                return new d(kVar3, bVar6);
            case 11:
                ye0.c cVar = (ye0.c) this.b.invoke();
                ye0.f fVar2 = (ye0.f) this.c.invoke();
                o.h(cVar, "badgeFactory");
                o.h(fVar2, "spatialViewModelFactory");
                return new ye0.b(cVar, fVar2);
            case 12:
                String str2 = (String) this.b.invoke();
                i11.t tVar4 = (i11.t) this.c.invoke();
                o.h(str2, "clientId");
                o.h(tVar4, "remoteConfig");
                return new yo.b(str2, tVar4);
            case 13:
                n1 n1Var = (n1) this.b.invoke();
                a0 a0Var = (a0) this.c.invoke();
                o.h(n1Var, "countInStateProvider");
                o.h(a0Var, "lifecycleScope");
                return new p1(n1Var, a0Var);
            case 14:
                Application application = (Application) this.b.invoke();
                vm.d dVar = (vm.d) this.c.invoke();
                o.h(application, "app");
                o.h(dVar, "aInfo");
                SharedPreferences sharedPreferences = application.getSharedPreferences("sample_rate_sh_prefs", 0);
                int i = sharedPreferences.getInt("sample_rate_pref", -1);
                if (vm.d.b == -1) {
                    vm.d.b = vm.d.a(dVar.a, "amuvvoafs.media.property.OUTPUT_SAMPLE_RATE", 44100);
                }
                int i2 = vm.d.b;
                if (i == -1) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putInt("sample_rate_pref", i2);
                    editorEdit.apply();
                    i = i2;
                } else if (i != i2) {
                    s02.b bVar7 = s02.d.a;
                    String strG = f2.g(i, i2, "Cached resources SR (", ") != Current optimal SR (", ")");
                    bVar7.getClass();
                    s02.b.r(strG);
                }
                return Integer.valueOf(i);
            case 15:
                j jVar = new j();
                eh0.b bVar8 = (eh0.b) this.b.invoke();
                i11.t tVar5 = (i11.t) this.c.invoke();
                o.h(bVar8, "converter");
                o.h(tVar5, "remoteConfig");
                return new h(jVar, new ey1.d(0.0d, bVar8.b(q.b(((q) tVar5.c(zg0.a0.a)).a) / 1000.0d)));
            case 16:
                p pVar = (p) this.b.invoke();
                ur.d dVar2 = (ur.d) this.c.invoke();
                o.h(pVar, "navigationSource");
                o.h(dVar2, "internalStudioNavigation");
                return new e6(pVar, dVar2);
            case 17:
                p pVar2 = (p) this.b.invoke();
                ur.d dVar3 = (ur.d) this.c.invoke();
                o.h(pVar2, "navigation");
                o.h(dVar3, "internalStudioNavigation");
                return new e6(pVar2, dVar3);
            case 18:
                k kVar4 = (k) this.b.invoke();
                i11.t tVar6 = (i11.t) this.c.invoke();
                o.h(kVar4, "preference");
                o.h(tVar6, "remoteConfig");
                return new v80.h(kVar4, tVar6);
            case 19:
                Context context2 = (Context) this.b.invoke();
                i0 i0Var2 = (i0) this.c.invoke();
                o.h(context2, "context");
                o.h(i0Var2, "userProvider");
                return new com.bandlab.song.utils.c(6, context2, i0Var2);
            case 20:
                hw.q qVar = (hw.q) this.b.invoke();
                i11.t tVar7 = (i11.t) this.c.invoke();
                o.h(qVar, "membershipRepo");
                o.h(tVar7, "remoteConfig");
                return new zl.q(qVar, tVar7);
            case 21:
                e1 e1Var = (e1) this.b.invoke();
                c70.f fVar3 = (c70.f) this.c.invoke();
                o.h(e1Var, "navigationScreenActions");
                o.h(fVar3, "exploreTagNavActions");
                return new w2.j(e1Var, fVar3);
            case 22:
                Context context3 = (Context) this.b.invoke();
                ja0.c cVar2 = (ja0.c) this.c.invoke();
                o.h(context3, "context");
                o.h(cVar2, "homeTabRepository");
                return new e1(context3, cVar2);
            case 23:
                Context context4 = (Context) this.b.invoke();
                i0 i0Var3 = (i0) this.c.invoke();
                o.h(context4, "context");
                o.h(i0Var3, "userProvider");
                return new v80.h(16, context4, i0Var3);
            case 24:
                Context context5 = (Context) this.b.invoke();
                tk1.b bVar9 = (tk1.b) this.c.invoke();
                o.h(context5, "context");
                o.h(bVar9, "urlNavigation");
                return new i1(context5, bVar9);
            default:
                Context context6 = (Context) this.b.invoke();
                e1 e1Var2 = (e1) this.c.invoke();
                o.h(context6, "context");
                o.h(e1Var2, "navigationScreenActions");
                return new w2.j(context6, e1Var2);
        }
    }

    public a(AppGraph$$.MetroGraph metroGraph, jw1.f fVar, b bVar) {
        this.a = 14;
        this.b = fVar;
        this.c = bVar;
    }

    public a(MixEditorGraph$$.MetroGraph metroGraph, yr.e1 e1Var, d3 d3Var, b3 b3Var) {
        this.a = 15;
        this.b = d3Var;
        this.c = b3Var;
    }
}
