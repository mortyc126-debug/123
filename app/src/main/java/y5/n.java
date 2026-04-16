package y5;

import x5.c;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n implements d {
    public int a;
    public x5.d b;
    public k c;
    public int d;
    public final f e = new f(this);

    /* JADX INFO: renamed from: f */
    public int f702f = 0;
    public boolean g = false;
    public final e h = new e(this);
    public final e i = new e(this);

    /* JADX INFO: renamed from: j */
    public int f703j = 1;

    public n(x5.d dVar) {
        this.b = dVar;
    }

    public static void b(e eVar, e eVar2, int i) {
        eVar.l.add(eVar2);
        eVar.f = i;
        eVar2.k.add(eVar);
    }

    public static e h(c cVar) {
        c cVar2 = cVar.f686f;
        if (cVar2 == null) {
            return null;
        }
        x5.d dVar = cVar2.d;
        int iK = p.k(cVar2.e);
        if (iK == 1) {
            return dVar.d.h;
        }
        if (iK == 2) {
            return dVar.e.h;
        }
        if (iK == 3) {
            return dVar.d.i;
        }
        if (iK == 4) {
            return dVar.e.i;
        }
        if (iK != 5) {
            return null;
        }
        return dVar.e.k;
    }

    public static e i(c cVar, int i) {
        c cVar2 = cVar.f686f;
        if (cVar2 == null) {
            return null;
        }
        x5.d dVar = cVar2.d;
        j jVar = i == 0 ? dVar.d : dVar.e;
        int iK = p.k(cVar2.e);
        if (iK == 1 || iK == 2) {
            return jVar.h;
        }
        if (iK == 3 || iK == 4) {
            return jVar.i;
        }
        return null;
    }

    public final void c(e eVar, e eVar2, int i, f fVar) {
        eVar.l.add(eVar2);
        eVar.l.add(this.e);
        eVar.h = i;
        eVar.i = fVar;
        eVar2.k.add(eVar);
        ((e) fVar).k.add(eVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        if (i2 == 0) {
            x5.d dVar = this.b;
            int i3 = dVar.v;
            int iMax = Math.max(dVar.u, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            x5.d dVar2 = this.b;
            int i4 = dVar2.y;
            int iMax2 = Math.max(dVar2.x, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (((e) this.e).j) {
            return ((e) r0).g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:95:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(x5.c r12, x5.c r13, int r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.n.l(x5.c, x5.c, int):void");
    }
}
