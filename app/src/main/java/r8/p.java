package r8;

import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final long a;
    public final TreeSet b = new TreeSet(new o());
    public long c;

    public p(long j2) {
        this.a = j2;
    }

    public final void a(a aVar, long j2) {
        while (this.c + j2 > this.a && !this.b.isEmpty()) {
            h hVar = (h) this.b.first();
            s sVar = (s) aVar;
            synchronized (sVar) {
                sVar.j(hVar);
            }
        }
    }

    public final void b(s sVar, t tVar) {
        this.b.add(tVar);
        this.c += ((h) tVar).c;
        a(sVar, 0L);
    }
}
