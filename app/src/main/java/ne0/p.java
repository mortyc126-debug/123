package ne0;

import com.bandlab.media.player.impl.n;
import java.util.ArrayList;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import m01.l;
import ny1.p2;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final i11.c a;
    public final n b;
    public final kp1.j c;
    public final q d;
    public final l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f348f;
    public se0.n g;

    public p(boolean z, se0.n nVar, i11.c cVar, n nVar2, kp1.j jVar, kd.h hVar, q qVar, l lVar, co1.c cVar2, l lVar2) {
        o.h(cVar, "playbackTime");
        this.a = cVar;
        this.b = nVar2;
        this.c = jVar;
        this.d = qVar;
        this.e = lVar;
        this.f348f = lVar2;
        this.g = nVar;
        Integer num = nVar.c;
        a(z, num != null ? num.intValue() : 0, nVar);
        jVar.z(qVar);
        jVar.a(lVar, 500L);
    }

    public final void a(boolean z, int i, se0.n nVar) {
        p2 currentPosition;
        re0.h hVar;
        p2 duration;
        this.g = nVar;
        re0.e eVar = (re0.e) this.b.o.getValue();
        long jLongValue = (eVar == null || (duration = eVar.getDuration()) == null) ? 0L : ((Number) duration.getValue()).longValue();
        long j2 = (eVar == null || (currentPosition = eVar.getCurrentPosition()) == null || (hVar = (re0.h) currentPosition.getValue()) == null) ? 0L : hVar.a;
        long j3 = jLongValue - j2 >= 3000 ? j2 : 0L;
        i11.c cVar = this.a;
        if (((Boolean) ((lmjxuqdtp.time.a) cVar.b).invoke()).booleanValue()) {
            r2 r2Var = (r2) cVar.c;
            Long lValueOf = Long.valueOf(j3);
            r2Var.getClass();
            r2Var.i((Object) null, lValueOf);
        }
        xn1.a.o("Queue startTime: " + j3 + " startIndex: " + i + " autoPlay: " + z);
        List list = nVar.b;
        ArrayList arrayList = new ArrayList(mx1.p.c0(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                ct1.b.X();
                throw null;
            }
            se0.d dVar = (se0.d) obj;
            o.h(dVar, "audioItem");
            arrayList.add(ie0.b.a(com.bandlab.media.player.impl.x.b(dVar)));
            i2 = i3;
        }
        com.gnacba.amuvvoafs.gms.measurement.internal.l lVar = new com.gnacba.amuvvoafs.gms.measurement.internal.l();
        fo.n nVar2 = new fo.n(11);
        nVar2.E(arrayList);
        nVar2.H(i);
        nVar2.I(j3);
        lVar.j(nVar2.l());
        lVar.i(j3);
        lVar.g(Boolean.valueOf(z));
        this.c.s(lVar.f()).setResultCallback(new o(arrayList, this));
    }
}
