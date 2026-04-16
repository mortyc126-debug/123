package qj1;

import i2.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import l8.z0;
import lc0.a;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.g;
import lmjxuqdtp.time.n;
import se0.x;
import tlydtdl.media3.ui.PlayerView;
import ty1.i;
import ty1.j;
import w8.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final a a;
    public final y10.a b;
    public final i c = j.a(6);
    public final ArrayList d = new ArrayList();
    public final ConcurrentHashMap e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f388f;
    public t1 g;

    public c(a aVar, y10.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
        int i = g.d;
        this.f388f = n.s(30, lmjxuqdtp.time.i.e);
        t1 t1Var = this.g;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        this.g = c0.F(aVar2, (qx1.i) null, (b0) null, new d(this, (qx1.d) null, 29), 3);
    }

    public final lx1.b0 a(x xVar) {
        Object next;
        b bVar;
        PlayerView playerView;
        ConcurrentHashMap concurrentHashMap = this.e;
        Set setEntrySet = concurrentHashMap.entrySet();
        o.g(setEntrySet, "<get-entries>(...)");
        Iterator it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (o.c(((Map.Entry) next).getKey(), xVar)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        lx1.b0 b0Var = lx1.b0.a;
        if (entry != null && (bVar = (b) entry.getValue()) != null) {
            concurrentHashMap.remove(xVar);
            WeakReference weakReference = bVar.d;
            if (weakReference != null && (playerView = (PlayerView) weakReference.get()) != null) {
                playerView.setPlayer((z0) null);
            }
            bVar.d = null;
            ((d0) bVar.a).stop();
            this.c.g();
        }
        return b0Var;
    }
}
