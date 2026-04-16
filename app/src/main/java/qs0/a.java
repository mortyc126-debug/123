package qs0;

import a80.l;
import ak.v;
import amuvvoafs.content.Context;
import b02.d0;
import c61.c0;
import com.bandlab.bandlab.feature.mixeditor.viewmodel.MixEditorGraph$$;
import com.bandlab.restutils.UnauthorizedFileService;
import com.gnacba.firebase.messaging.a0;
import gm.t;
import ir0.i;
import java.io.File;
import java.util.Set;
import jv0.i0;
import jw1.e;
import jx0.h;
import kd1.j;
import lmjxuqdtp.jvm.internal.o;
import ny1.p2;
import or.a1;
import qi.m;
import qi.y;
import qi.z;
import qu0.u;
import r30.f;
import r30.g;
import s51.b0;
import s51.n;
import s70.k;
import tlydtdl.activity.ComponentActivity;
import wm.f0;
import yr.b3;
import yr.f3;
import yr.g3;
import zs.d1;
import zs.e1;
import zs.k0;
import zs.m1;
import zs.q0;
import zs.r0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {
    public final /* synthetic */ int a;
    public final iw1.b b;
    public final iw1.b c;
    public final Object d;
    public final iw1.b e;

    public /* synthetic */ a(int i, iw1.b bVar, e eVar, e eVar2, e eVar3) {
        this.a = i;
        this.b = eVar;
        this.d = eVar2;
        this.e = eVar3;
        this.c = bVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                h hVar = (h) ((a1) this.d).invoke();
                kn0.b bVar = (kn0.b) this.b.invoke();
                fy.a aVar = (fy.a) this.e.invoke();
                fj1.a aVar2 = (fj1.a) this.c.invoke();
                o.h(bVar, "messageHolder");
                o.h(aVar2, "ftueRepository");
                return new d(hVar, bVar, aVar, aVar2);
            case 1:
                g gVar = (g) this.d;
                f fVar = (f) this.e.a;
                r30.e eVar = (r30.e) this.b.invoke();
                u00.g gVar2 = (u00.g) this.c.invoke();
                o.h(gVar, "instance");
                o.h(fVar, "page");
                o.h(eVar, "initialParam");
                o.h(gVar2, "pageParamProvider");
                return gVar2.a(fVar, eVar);
            case 2:
                i iVar = (i) this.b.invoke();
                qq1.b bVar2 = (qq1.b) ((l) this.d).invoke();
                u uVar = (u) this.e.invoke();
                cg0.a aVar3 = (cg0.a) this.c.invoke();
                o.h(iVar, "resourceManager");
                o.h(aVar3, "mixAdapter");
                return new a0(iVar, bVar2, uVar, aVar3);
            case 3:
                File file = (File) this.b.invoke();
                File file2 = (File) ((kr0.a) this.d).invoke();
                Context context = (Context) this.c.invoke();
                lmjxuqdtp.time.e eVar2 = (lmjxuqdtp.time.e) this.e.invoke();
                o.h(file, "chatFileAttachmentStorage");
                o.h(context, "context");
                o.h(eVar2, "clock");
                return new k50.o(file, file2, context, eVar2, 19);
            case 4:
                Set set = (Set) ((ao0.g) this.d).invoke();
                p2 p2Var = (p2) this.c.invoke();
                ComponentActivity componentActivity = (ComponentActivity) this.e.invoke();
                y yVar = (y) this.b.invoke();
                o.h(set, "onFeedLoaded");
                o.h(p2Var, "deeplinkResolutionState");
                o.h(componentActivity, "activity");
                o.h(yVar, "tracker");
                return new k(set, p2Var, componentActivity, yVar);
            case 5:
                int iIntValue = ((Number) this.b.invoke()).intValue();
                lt.b bVar3 = (lt.b) this.c.invoke();
                eu0.k kVar = (eu0.k) ((m) this.d).invoke();
                ls0.k kVar2 = (ls0.k) this.e.invoke();
                o.h(bVar3, "fxProvider");
                o.h(kVar2, "meStorage");
                return new c0(iIntValue, bVar3, kVar, kVar2);
            case 6:
                y10.a aVar4 = (y10.a) this.b.invoke();
                t tVar = new t();
                UnauthorizedFileService unauthorizedFileService = (UnauthorizedFileService) ((f3) this.d).invoke();
                mt.b bVar4 = (mt.b) this.c.invoke();
                i0 i0Var = (i0) this.e.invoke();
                o.h(aVar4, "coroutineScope");
                o.h(bVar4, "serviceFactory");
                o.h(i0Var, "userIdProvider");
                return new tl0.k(aVar4, tVar, unauthorizedFileService, bVar4, i0Var);
            case 7:
                z zVar = (z) this.b.invoke();
                k kVar3 = (k) ((a) this.d).invoke();
                zs.p pVar = (zs.p) this.c.invoke();
                j jVar = (j) this.e.invoke();
                o.h(zVar, "screenTracker");
                o.h(pVar, "authNavActions");
                o.h(jVar, "tooltipRepository");
                return new t30.m(zVar, kVar3, pVar, jVar);
            case 8:
                qo.a aVar5 = (qo.a) this.b.invoke();
                zs.p pVar2 = (zs.p) this.c.invoke();
                ComponentActivity componentActivity2 = (ComponentActivity) ((e) this.d).invoke();
                fp.c cVar = (fp.c) this.e.invoke();
                o.h(aVar5, "authManager");
                o.h(pVar2, "authNavActions");
                o.h(componentActivity2, "activity");
                o.h(cVar, "authProfileChecker");
                return new k(aVar5, pVar2, componentActivity2, cVar);
            case 9:
                UnauthorizedFileService unauthorizedFileService2 = (UnauthorizedFileService) this.b.invoke();
                d0 d0Var = (d0) ((lc0.a) this.d).invoke();
                File file3 = (File) this.c.invoke();
                File file4 = (File) this.e.invoke();
                o.h(unauthorizedFileService2, "fileService");
                o.h(file3, "storageDir");
                return new ws.y(unauthorizedFileService2, d0Var, file3, file4);
            case 10:
                Context context2 = (Context) this.b.invoke();
                r0 r0Var = (r0) ((a) this.d).invoke();
                zi.c cVar2 = (zi.c) this.c.invoke();
                String str = (String) this.e.invoke();
                o.h(context2, "context");
                o.h(cVar2, "resourcesProvider");
                o.h(str, "appPackageName");
                return new x31.p(context2, r0Var, cVar2, str);
            case 11:
                Context context3 = (Context) this.b.invoke();
                y10.a aVar6 = (y10.a) ((jw1.f) this.d).a;
                aq1.c cVar3 = (aq1.c) this.e.invoke();
                y yVar2 = (y) this.c.invoke();
                o.h(context3, "context");
                o.h(aVar6, "scope");
                o.h(yVar2, "tracker");
                return new yg0.h(context3, aVar6, cVar3, yVar2);
            case 12:
                xg.a aVar7 = (xg.a) ((b3) this.d).invoke();
                xu0.p pVar3 = (xu0.p) this.b.a;
                ky1.a0 a0Var = (ky1.a0) this.c.a;
                tlydtdl.lifecycle.z zVar2 = (tlydtdl.lifecycle.z) this.e.a;
                o.h(aVar7, "factory");
                o.h(pVar3, "navigationSource");
                o.h(a0Var, "coroutineScope");
                o.h(zVar2, "lifecycle");
                return aVar7.a(ug.c.e, pVar3, a0Var, zVar2);
            case 13:
                z41.d dVar = (z41.d) this.b.invoke();
                n nVar = (n) ((jq0.d) this.d).invoke();
                b0 b0Var = (b0) this.c.invoke();
                mt.b bVar5 = (mt.b) this.e.invoke();
                o.h(dVar, "playCounterRepository");
                o.h(b0Var, "songDao");
                o.h(bVar5, "apiServiceFactory");
                return new z41.i(dVar, nVar, b0Var, bVar5);
            case 14:
                mt.b bVar6 = (mt.b) this.b.invoke();
                i0 i0Var2 = (i0) this.c.invoke();
                v vVar = (v) ((ak.u) this.d).invoke();
                this.e.invoke();
                o.h(bVar6, "apiServiceFactory");
                o.h(i0Var2, "userProvider");
                return new zj.u(bVar6, i0Var2, vVar, "amuvvoafs-8.41.1");
            case 15:
                Context context4 = (Context) this.b.invoke();
                q0 q0Var = (q0) ((a) this.d).invoke();
                v80.h hVar2 = (v80.h) this.c.invoke();
                m1 m1Var = (m1) this.e.invoke();
                o.h(context4, "context");
                return new zs.u(context4, q0Var, hVar2, m1Var);
            case 16:
                Context context5 = (Context) this.b.invoke();
                m1 m1Var2 = (m1) ((f0) this.d).invoke();
                zs.p pVar4 = (zs.p) this.c.invoke();
                nr.a aVar8 = (nr.a) this.e.invoke();
                o.h(context5, "context");
                return new k(context5, m1Var2, pVar4, aVar8);
            case 17:
                Context context6 = (Context) this.b.invoke();
                e1 e1Var = (e1) this.c.invoke();
                zs.b bVar7 = (zs.b) ((yt.a) this.d).invoke();
                tk1.b bVar8 = (tk1.b) this.e.invoke();
                o.h(context6, "context");
                o.h(e1Var, "navigationScreenActions");
                o.h(bVar8, "urlNavigationProvider");
                return new t30.m(context6, e1Var, bVar7, bVar8);
            case 18:
                Context context7 = (Context) this.b.invoke();
                d1 d1Var = (d1) ((ct.b) this.d).invoke();
                tk1.b bVar9 = (tk1.b) this.c.invoke();
                k0 k0Var = (k0) this.e.invoke();
                o.h(context7, "context");
                o.h(bVar9, "urlNavigationProvider");
                return new q0(context7, d1Var, bVar9, k0Var);
            case 19:
                Context context8 = (Context) this.b.invoke();
                zs.f fVar2 = (zs.f) ((a1) this.d).invoke();
                i0 i0Var3 = (i0) this.c.invoke();
                v31.b bVar10 = (v31.b) this.e.invoke();
                o.h(context8, "context");
                o.h(i0Var3, "userProvider");
                o.h(bVar10, "sharingUrlProvider");
                return new r0(context8, fVar2, i0Var3, bVar10);
            default:
                Context context9 = (Context) this.b.invoke();
                zs.i iVar2 = (zs.i) ((yt.a) this.d).invoke();
                zs.b bVar11 = (zs.b) this.c.invoke();
                k0 k0Var2 = (k0) this.e.invoke();
                o.h(context9, "context");
                return new t30.m(context9, iVar2, bVar11, k0Var2);
        }
    }

    public /* synthetic */ a(iw1.b bVar, iw1.b bVar2, iw1.b bVar3, iw1.b bVar4, int i) {
        this.a = i;
        this.b = bVar;
        this.d = bVar2;
        this.c = bVar3;
        this.e = bVar4;
    }

    public /* synthetic */ a(iw1.b bVar, iw1.b bVar2, e eVar, iw1.b bVar3, int i) {
        this.a = i;
        this.b = bVar;
        this.c = bVar2;
        this.d = eVar;
        this.e = bVar3;
    }

    public a(ao0.g gVar, df0.a aVar, v00.f fVar, iw1.b bVar) {
        this.a = 4;
        this.d = gVar;
        this.c = aVar;
        this.e = fVar;
        this.b = bVar;
    }

    public a(a1 a1Var, iw1.b bVar, m mVar, g3 g3Var) {
        this.a = 0;
        this.d = a1Var;
        this.b = bVar;
        this.e = mVar;
        this.c = g3Var;
    }

    public a(g gVar, jw1.f fVar, au0.e eVar, iw1.b bVar) {
        this.a = 1;
        this.d = gVar;
        this.e = fVar;
        this.b = eVar;
        this.c = bVar;
    }

    public a(MixEditorGraph$$.MetroGraph metroGraph, b3 b3Var, jw1.f fVar, jw1.f fVar2, jw1.f fVar3) {
        this.a = 12;
        this.d = b3Var;
        this.b = fVar;
        this.c = fVar2;
        this.e = fVar3;
    }
}
