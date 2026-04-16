package a51;

import amuvvoafs.content.Context;
import br.o0;
import br.p;
import bt.k;
import com.bandlab.audio.controller.voiceTransfer.a0;
import com.bandlab.bandlab.AppGraph$$;
import com.bandlab.fcm.service.q;
import com.bandlab.media.player.impl.x;
import com.bandlab.sync.services.impl.m;
import cs0.i;
import jv0.i0;
import jw1.d;
import jw1.e;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.v;
import lx1.l;
import org.apache.http.HttpHeaders;
import qi.y;
import qi.z;
import ru1.c;
import tlydtdl.media3.exoplayer.ExoPlayer;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {
    public final /* synthetic */ int a;
    public final iw1.b b;

    public /* synthetic */ b(iw1.b bVar, int i) {
        this.a = i;
        this.b = bVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                mt.b bVar = (mt.b) this.b.invoke();
                o.h(bVar, "apiServiceFactory");
                return new h(bVar);
            case 1:
                i0 i0Var = (i0) this.b.invoke();
                o.h(i0Var, "userProvider");
                return new a80.b(i0Var);
            case 2:
                a91.b bVar2 = (a91.b) this.b.invoke();
                o.h(bVar2, "navActions");
                return new a91.a(0, bVar2);
            case 3:
                Context context = (Context) this.b.invoke();
                o.h(context, "context");
                return new a91.b(context);
            case 4:
                y yVar = (y) this.b.invoke();
                o.h(yVar, "tracker");
                return new aq.e(yVar);
            case 5:
                z zVar = (z) this.b.invoke();
                o.h(zVar, "screenTracker");
                return new c(9, zVar);
            case 6:
                uc0.h hVar = (uc0.h) this.b.invoke();
                o.h(hVar, "localeManager");
                return new l(HttpHeaders.ACCEPT_LANGUAGE, hVar.j.getValue());
            case 7:
                mt.b bVar3 = (mt.b) this.b.invoke();
                o.h(bVar3, "factory");
                return new bk0.e(bVar3);
            case 8:
                p80.c cVar = (p80.c) this.b.invoke();
                o.h(cVar, "feedVideosEventsRepository");
                return new p(cVar);
            case 9:
                Context context2 = (Context) this.b.invoke();
                o.h(context2, "context");
                return new o0(context2, 0);
            case 10:
                Context context3 = (Context) this.b.invoke();
                o.h(context3, "context");
                return new br0.a(context3, 0);
            case 11:
                y yVar2 = (y) this.b.invoke();
                o.h(yVar2, "tracker");
                return new k(yVar2);
            case 12:
                d01.k kVar = (d01.k) this.b.invoke();
                o.h(kVar, "preferenceConfig");
                return new bu.b(kVar);
            case 13:
                String str = (String) this.b.invoke();
                o.h(str, "appPackageName");
                return new c10.a(0, str, false);
            case 14:
                y30.a aVar = (y30.a) this.b.invoke();
                o.h(aVar, "fileSettingsAdapter");
                return new c(14, aVar);
            case 15:
                Context context4 = (Context) this.b.invoke();
                o.h(context4, "context");
                return new c70.f(context4);
            case 16:
                ls0.k kVar2 = (ls0.k) this.b.invoke();
                o.h(kVar2, "mixEditorStorage");
                return new u(kVar2);
            case 17:
                ls0.k kVar3 = (ls0.k) this.b.invoke();
                o.h(kVar3, "storage");
                return new a0(0, kVar3);
            case 18:
                lx1.h hVar2 = this.b;
                o.h(hVar2, "provider");
                return new q(0, hVar2 instanceof lx1.h ? hVar2 : new d(hVar2));
            case 19:
                mt.b bVar4 = (mt.b) this.b.invoke();
                o.h(bVar4, "factory");
                return new com.bandlab.library.service.song.b(bVar4);
            case 20:
                y yVar3 = (y) this.b.invoke();
                o.h(yVar3, "tracker");
                return new com.bandlab.media.player.impl.a(yVar3);
            case 21:
                x xVar = (x) this.b.invoke();
                ie0.b bVar5 = new ie0.b();
                o.h(xVar, "mediaSourceFactory");
                return new kd.h(xVar, bVar5);
            case 22:
                ExoPlayer exoPlayer = (ExoPlayer) this.b.invoke();
                o.h(exoPlayer, "exoPlayer");
                return new com.bandlab.media.player.impl.u(exoPlayer);
            case 23:
                mt.b bVar6 = (mt.b) this.b.invoke();
                o.h(bVar6, "factory");
                return new com.bandlab.projects.core.impl.x(bVar6);
            case 24:
                mt.b bVar7 = (mt.b) this.b.invoke();
                o.h(bVar7, "apiFactor");
                return new com.bandlab.revision.services.impl.a(bVar7);
            case 25:
                mt.b bVar8 = (mt.b) this.b.invoke();
                o.h(bVar8, "apiServiceFactory");
                return new com.bandlab.revision.services.impl.b(bVar8);
            case 26:
                mt.b bVar9 = (mt.b) this.b.invoke();
                o.h(bVar9, "factory");
                return new com.bandlab.song.utils.b(bVar9);
            case 27:
                mt.b bVar10 = (mt.b) this.b.invoke();
                o.h(bVar10, "factory");
                return new m(bVar10);
            case 28:
                v vVar = (v) this.b.invoke();
                o.h(vVar, "timeSource");
                return new i(vVar);
            default:
                Context context5 = (Context) this.b.invoke();
                o.h(context5, "context");
                return new br0.a(context5, 1);
        }
    }

    public b(AppGraph$$.MetroGraph metroGraph, a81.d dVar) {
        this.a = 14;
        this.b = dVar;
    }
}
