package ct;

import amuvvoafs.content.ContentResolver;
import amuvvoafs.content.Context;
import com.bandlab.bandlab.AppGraph$$;
import com.bandlab.media.player.impl.n;
import com.gnacba.firebase.messaging.a0;
import d01.k;
import fm0.n0;
import fm0.q0;
import ft.g;
import i11.p;
import i11.t;
import iz1.d0;
import iz1.h0;
import j50.c1;
import java.io.File;
import jv0.i0;
import jw1.e;
import k50.m;
import lmjxuqdtp.jvm.internal.o;
import m71.g0;
import m81.d;
import mr.a4;
import mz.r0;
import n71.l;
import qi.y;
import tlydtdl.lifecycle.z;
import uq0.o0;
import wj1.q;
import wz0.k0;
import xp.i;
import y41.j;
import yr.w1;
import zj.u2;
import zj.v1;
import zq0.w;
import zs.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {
    public final /* synthetic */ int a;
    public final iw1.b b;
    public final iw1.b c;
    public final iw1.b d;
    public final iw1.b e;

    public /* synthetic */ b(AppGraph$$.MetroGraph metroGraph, b81.c cVar, jw1.c cVar2, iw1.b bVar, iw1.b bVar2, int i) {
        this.a = i;
        this.b = cVar;
        this.c = cVar2;
        this.d = bVar;
        this.e = bVar2;
    }

    public final Object invoke() {
        int i = this.a;
        iw1.b bVar = this.e;
        iw1.b bVar2 = this.d;
        iw1.b bVar3 = this.c;
        iw1.b bVar4 = this.b;
        switch (i) {
            case 0:
                g gVar = (g) bVar4.invoke();
                n nVar = (n) bVar3.invoke();
                ft.f fVar = (ft.f) bVar2.invoke();
                z zVar = (z) bVar.invoke();
                o.h(gVar, "postUploadEventPublisher");
                o.h(nVar, "globalPlayer");
                o.h(fVar, "postEventsRepository");
                o.h(zVar, "lifecycle");
                return new a0(gVar, nVar, fVar, zVar);
            case 1:
                d dVar = (d) bVar4.invoke();
                d81.a0 a0Var = (d81.a0) bVar3.invoke();
                l lVar = (l) bVar2.invoke();
                o.h(dVar, "validator");
                o.h(a0Var, "maker");
                o.h(lVar, "storageManager");
                o.h(bVar, "shareCache");
                o.h(bVar, "shareCache");
                a0 a0Var2 = new a0();
                a0Var2.a = dVar;
                a0Var2.b = a0Var;
                a0Var2.c = lVar;
                a0Var2.d = bVar;
                return a0Var2;
            case 2:
                Context context = (Context) bVar4.invoke();
                lmjxuqdtp.time.e eVar = (lmjxuqdtp.time.e) bVar3.invoke();
                a4 a4Var = (a4) bVar2.invoke();
                k kVar = (k) bVar.invoke();
                o.h(context, "context");
                o.h(eVar, "clock");
                o.h(a4Var, "clientConfig");
                o.h(kVar, "preferenceConfig");
                return new dj.b(context, eVar, a4Var, kVar);
            case 3:
                j jVar = (j) bVar4.invoke();
                p81.f fVar2 = (p81.f) bVar3.invoke();
                y yVar = (y) bVar2.invoke();
                mt.b bVar5 = (mt.b) bVar.invoke();
                o.h(jVar, "likeRepository");
                o.h(fVar2, "toaster");
                o.h(yVar, "tracker");
                o.h(bVar5, "apiServiceFactory");
                return new ey0.c(jVar, fVar2, yVar, bVar5);
            case 4:
                v1 v1Var = (v1) bVar4.invoke();
                u2 u2Var = (u2) bVar3.invoke();
                o0 o0Var = (o0) bVar2.invoke();
                w wVar = (w) bVar.invoke();
                o.h(v1Var, "mixController");
                o.h(u2Var, "transportController");
                o.h(o0Var, "trackPresetResolver");
                o.h(wVar, "presetPictures");
                return new a0(v1Var, u2Var, o0Var, wVar);
            case 5:
                f21.b bVar6 = new f21.b();
                lmjxuqdtp.time.e eVar2 = (lmjxuqdtp.time.e) bVar4.invoke();
                k kVar2 = (k) bVar3.invoke();
                i11.n nVar2 = (i11.n) bVar2.invoke();
                mt.b bVar7 = (mt.b) bVar.invoke();
                o.h(eVar2, "clock");
                o.h(kVar2, "preferenceConfig");
                o.h(nVar2, "optionsPreferenceConfig");
                o.h(bVar7, "apiServiceFactory");
                return new p(bVar6, eVar2, kVar2, nVar2, bVar7);
            case 6:
                ky1.a0 a0Var3 = (ky1.a0) bVar4.invoke();
                t tVar = (t) bVar2.invoke();
                sh0.k kVar3 = (sh0.k) bVar.invoke();
                o.h(a0Var3, "scope");
                o.h(bVar3, "mixProcessor");
                o.h(tVar, "remoteConfig");
                o.h(kVar3, "availabilityProvider");
                return new il.a(a0Var3, bVar3, tVar, kVar3);
            case 7:
                j jVar2 = (j) bVar4.invoke();
                p81.f fVar3 = (p81.f) bVar3.invoke();
                y yVar2 = (y) bVar2.invoke();
                mt.b bVar8 = (mt.b) bVar.invoke();
                o.h(jVar2, "likeRepository");
                o.h(fVar3, "toaster");
                o.h(yVar2, "tracker");
                o.h(bVar8, "apiServiceFactory");
                return new jh.b(jVar2, fVar3, yVar2, bVar8);
            case 8:
                mt.b bVar9 = (mt.b) bVar4.invoke();
                xu.n nVar3 = (xu.n) bVar3.invoke();
                ky1.a0 a0Var4 = (ky1.a0) bVar2.invoke();
                ju.a aVar = (ju.a) bVar.invoke();
                o.h(bVar9, "apiServiceFactory");
                o.h(nVar3, "beatsEventsRepository");
                o.h(a0Var4, "coroutineScope");
                o.h(aVar, "beatsCollectionListItemViewModelFactory");
                return new ju.c(bVar9, nVar3, a0Var4, aVar);
            case 9:
                File file = (File) bVar4.invoke();
                t tVar2 = (t) bVar3.invoke();
                ls0.k kVar4 = (ls0.k) bVar2.invoke();
                g0 g0Var = (g0) bVar.invoke();
                o.h(file, "persistentStorage");
                o.h(tVar2, "remoteConfig");
                o.h(kVar4, "mixEditorStorage");
                o.h(g0Var, "storageErrorEventsRepository");
                return new ls0.l(file, tVar2, kVar4, g0Var);
            case 10:
                p81.f fVar4 = (p81.f) bVar4.invoke();
                u41.e eVar3 = (u41.e) bVar3.invoke();
                y yVar3 = (y) bVar2.invoke();
                mt.b bVar10 = (mt.b) bVar.invoke();
                o.h(fVar4, "toaster");
                o.h(eVar3, "followRepository");
                o.h(yVar3, "tracker");
                o.h(bVar10, "apiServiceFactory");
                return new m41.k(fVar4, eVar3, yVar3, bVar10);
            case 11:
                h0 h0Var = (h0) bVar4.invoke();
                d0 d0Var = (nt.e) bVar3.invoke();
                nt.g gVar2 = (nt.g) bVar2.invoke();
                lv1.c cVar = (lv1.c) bVar.invoke();
                o.h(h0Var, "builder");
                o.h(d0Var, "authInterceptor");
                o.h(gVar2, "errorParsingInterceptorFactory");
                return AppGraph$$.MetroGraph.x(h0Var, (iz1.g) null, cVar, 600L, a02.a.b, new d0[]{d0Var, gVar2.a(true)});
            case 12:
                h0 h0Var2 = (h0) bVar4.invoke();
                d0 d0Var2 = (nt.e) bVar3.invoke();
                iz1.g gVar3 = (iz1.g) bVar2.invoke();
                nt.g gVar4 = (nt.g) bVar.invoke();
                o.h(h0Var2, "builder");
                o.h(d0Var2, "authInterceptor");
                o.h(gVar3, "cache");
                o.h(gVar4, "errorParsingInterceptorFactory");
                return AppGraph$$.MetroGraph.x(h0Var2, gVar3, (lv1.c) null, 45L, a02.a.c, new d0[]{d0Var2, gVar4.a(true)});
            case 13:
                nw0.a aVar2 = (nw0.a) bVar4.invoke();
                t tVar3 = (t) bVar3.invoke();
                k kVar5 = (k) bVar2.invoke();
                nw0.b bVar11 = (nw0.b) bVar.invoke();
                o.h(aVar2, "config");
                o.h(tVar3, "remoteConfig");
                o.h(kVar5, "preferenceConfig");
                o.h(bVar11, "preferences");
                return new m(aVar2, tVar3, kVar5, bVar11);
            case 14:
                j jVar3 = (j) bVar4.invoke();
                p81.f fVar5 = (p81.f) bVar3.invoke();
                y yVar4 = (y) bVar2.invoke();
                mt.b bVar12 = (mt.b) bVar.invoke();
                o.h(jVar3, "likeRepository");
                o.h(fVar5, "toaster");
                o.h(yVar4, "tracker");
                o.h(bVar12, "apiServiceFactory");
                return new p41.j(jVar3, fVar5, yVar4, bVar12);
            case 15:
                i40.b bVar13 = (i40.b) bVar4.invoke();
                t tVar4 = (t) bVar3.invoke();
                k kVar6 = (k) bVar2.invoke();
                i40.a aVar3 = (i40.a) bVar.invoke();
                o.h(bVar13, "config");
                o.h(tVar4, "remoteConfig");
                o.h(kVar6, "preferenceConfig");
                o.h(aVar3, "preferences");
                return new c1(bVar13, tVar4, kVar6, aVar3);
            case 16:
                k kVar7 = (k) bVar4.invoke();
                uz.b bVar14 = (uz.b) bVar3.invoke();
                y10.a aVar4 = (y10.a) bVar2.invoke();
                vb0.a aVar5 = (vb0.a) bVar.invoke();
                o.h(kVar7, "config");
                o.h(bVar14, "selector");
                o.h(aVar4, "coroutineScope");
                o.h(aVar5, "jsonMapper");
                return new uz.a(kVar7, aVar4, aVar5, by1.b.d(r0.Companion.serializer()), bVar14);
            case 17:
                n0 n0Var = (n0) bVar4.invoke();
                q0 q0Var = (q0) bVar3.invoke();
                ws.w wVar2 = (ws.w) bVar2.invoke();
                dr0.g gVar5 = (dr0.g) bVar.invoke();
                o.h(n0Var, "soundsLibraryManager");
                o.h(q0Var, "soundsLibraryStorage");
                o.h(wVar2, "samplerLibraryManager");
                o.h(gVar5, "progressIndicatorManager");
                return new vs.f(n0Var, q0Var, wVar2, gVar5);
            case 18:
                tk1.b bVar15 = (tk1.b) bVar4.invoke();
                xu0.p pVar = (xu0.p) bVar3.invoke();
                z zVar2 = (z) bVar2.invoke();
                i30.e eVar4 = (i30.e) bVar.invoke();
                boolean zBooleanValue = Boolean.FALSE.booleanValue();
                o.h(bVar15, "urlNavigationProvider");
                o.h(pVar, "navigation");
                o.h(zVar2, "lifecycle");
                o.h(eVar4, "contentCardProvider");
                return new w70.c(bVar15, pVar, zVar2, eVar4, zBooleanValue);
            case 19:
                Context context2 = (Context) bVar4.invoke();
                y yVar5 = (y) bVar3.invoke();
                t tVar5 = (t) bVar2.invoke();
                ContentResolver contentResolver = (ContentResolver) bVar.invoke();
                o.h(context2, "context");
                o.h(yVar5, "tracker");
                o.h(tVar5, "remoteConfig");
                o.h(contentResolver, "contentResolver");
                return new q(context2, yVar5, tVar5, contentResolver);
            case 20:
                xu0.p pVar2 = (xu0.p) bVar4.invoke();
                ky1.a0 a0Var5 = (ky1.a0) bVar3.invoke();
                z zVar3 = (z) bVar2.invoke();
                kz0.d dVar2 = (kz0.d) bVar.invoke();
                o.h(pVar2, "navigation");
                o.h(a0Var5, "coroutineScope");
                o.h(zVar3, "lifecycle");
                o.h(dVar2, "componentFactory");
                return new k0(pVar2, a0Var5, zVar3, dVar2);
            case 21:
                i0 i0Var = (i0) bVar4.invoke();
                t tVar6 = (t) bVar3.invoke();
                y10.g gVar6 = (y10.g) bVar2.invoke();
                xp.a aVar6 = (xp.a) bVar.invoke();
                o.h(i0Var, "userProvider");
                o.h(tVar6, "remoteConfig");
                o.h(gVar6, "localDateTimeProvider");
                o.h(aVar6, "accountValidationSettingsConfig");
                return new i(i0Var, tVar6, gVar6, aVar6);
            case 22:
                v1 v1Var2 = (v1) bVar4.invoke();
                ky1.a0 a0Var6 = (ky1.a0) bVar3.invoke();
                dr0.g gVar7 = (dr0.g) bVar2.invoke();
                kn0.b bVar16 = (kn0.b) bVar.invoke();
                o.h(v1Var2, "mixer");
                o.h(a0Var6, "scope");
                o.h(gVar7, "progressViewModel");
                o.h(bVar16, "studioMessageHolder");
                return new r70.a(v1Var2, a0Var6, gVar7, bVar16);
            case 23:
                sh0.q qVar = (sh0.q) bVar4.invoke();
                rs1.g gVar8 = new rs1.g(5);
                ws.w wVar3 = (ws.w) bVar3.invoke();
                n0 n0Var2 = (n0) bVar2.invoke();
                ur.t tVar7 = (ur.t) bVar.invoke();
                o.h(qVar, "soundsLibrary");
                o.h(wVar3, "samplerLibraryManager");
                o.h(n0Var2, "soundsLibraryManager");
                o.h(tVar7, "uiStateRepo");
                return new w1(qVar, gVar8, wVar3, n0Var2, tVar7);
            case 24:
                v1 v1Var3 = (v1) bVar4.invoke();
                m11.a aVar7 = (m11.a) bVar3.invoke();
                xu0.p pVar3 = (xu0.p) bVar2.invoke();
                p81.f fVar6 = (p81.f) bVar.invoke();
                o.h(v1Var3, "mixController");
                o.h(aVar7, "reportManager");
                o.h(pVar3, "navigation");
                o.h(fVar6, "toaster");
                return new r70.a(v1Var3, aVar7, pVar3, fVar6);
            default:
                Context context3 = (Context) bVar4.invoke();
                String str = (String) bVar3.invoke();
                tk1.b bVar17 = (tk1.b) bVar2.invoke();
                hw.q qVar2 = (hw.q) bVar.invoke();
                o.h(context3, "context");
                o.h(str, "appPackage");
                o.h(bVar17, "urlNavigationProvider");
                o.h(qVar2, "membershipRepo");
                return new d1(context3, str, bVar17, qVar2);
        }
    }

    public /* synthetic */ b(iw1.b bVar, iw1.b bVar2, iw1.b bVar3, iw1.b bVar4, int i) {
        this.a = i;
        this.b = bVar;
        this.c = bVar2;
        this.d = bVar3;
        this.e = bVar4;
    }

    public b(jw1.c cVar, v00.a aVar, v00.a aVar2, iw1.b bVar, bj.g gVar) {
        this.a = 18;
        this.b = cVar;
        this.c = aVar;
        this.d = aVar2;
        this.e = bVar;
    }
}
