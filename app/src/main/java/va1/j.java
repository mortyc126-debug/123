package va1;

import amuvvoafs.app.DownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import lx1.b0;
import mx1.p;
import ny1.a2;
import ny1.g2;
import ny1.z;
import p81.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final i11.c a;
    public final u00.c b;
    public final y10.a c;
    public final c d;
    public final File e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f626f;
    public final g2 g;
    public final a2 h;
    public final ConcurrentLinkedQueue i;

    public j(i11.c cVar, u00.c cVar2, y10.a aVar, c cVar3, File file, f fVar) {
        this.a = cVar;
        this.b = cVar2;
        this.c = aVar;
        this.d = cVar3;
        this.e = file;
        this.f626f = fVar;
        g2 g2VarA = z.a(1, 1, my1.c.b);
        this.g = g2VarA;
        this.h = new a2(g2VarA);
        this.i = new ConcurrentLinkedQueue();
        g2VarA.a(b0.a);
    }

    public final void a(h hVar) {
        DownloadManager downloadManager = (DownloadManager) this.a.c;
        this.i.remove(hVar);
        this.g.a(b0.a);
        Long lB = hVar.b();
        if (lB != null) {
            downloadManager.remove(Arrays.copyOf(new long[]{lB.longValue()}, 1));
        }
        Long lA = hVar.a();
        if (lA != null) {
            downloadManager.remove(Arrays.copyOf(new long[]{lA.longValue()}, 1));
        }
    }

    public final void b(long j2) {
        Object next;
        Long lB;
        Iterator it = this.i.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            h hVar = (h) next;
            Long lA = hVar.a();
            if ((lA != null && lA.longValue() == j2) || ((lB = hVar.b()) != null && lB.longValue() == j2)) {
                break;
            }
        }
        h hVar2 = (h) next;
        if (hVar2 == null) {
            return;
        }
        a(hVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(oz0.d1 r19, java.lang.String r20, sx1.c r21) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: va1.j.c(oz0.d1, java.lang.String, sx1.c):java.lang.Object");
    }

    public final ArrayList d() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.i;
        ArrayList arrayList = new ArrayList(p.c0(concurrentLinkedQueue, 10));
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) it.next()).c());
        }
        return arrayList;
    }
}
