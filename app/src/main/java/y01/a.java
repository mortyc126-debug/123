package y01;

import ak.i3;
import az1.j1;
import com.braze.requests.c;
import com.braze.requests.h;
import f3.f2;
import gf0.g;
import he1.d;
import kc0.j;
import lmjxuqdtp.jvm.functions.Function0;
import lx1.b0;
import oc0.r;
import yy1.i;
import z2.m;
import ze1.n;
import zg.f;
import zg0.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                j jVar = (j) ((r70.a) this.b).f;
                jVar.getClass();
                jVar.f(r.b);
                return b0.a;
            case 1:
                ym0.j jVar2 = (ym0.j) this.b;
                jVar2.c(d.k(jVar2.q));
                return b0.a;
            case 2:
                ((g) this.b).a();
                return b0.a;
            case 3:
                i iVar = (i) this.b;
                return Integer.valueOf(j1.g(iVar, iVar.k));
            case 4:
                z2.j jVar3 = (z2.j) this.b;
                jVar3.q = null;
                s4.g.u(jVar3).G();
                s4.g.u(jVar3).E();
                s4.g.l(jVar3);
                return Boolean.TRUE;
            case 5:
                m mVar = (m) this.b;
                mVar.l = null;
                s4.g.u(mVar).G();
                s4.g.u(mVar).E();
                s4.g.l(mVar);
                return Boolean.TRUE;
            case 6:
                return Float.valueOf(((Number) ((n) this.b).a.d()).floatValue());
            case 7:
                ((f) this.b).b();
                return b0.a;
            case 8:
                return f2.h(((x0) this.b).a, "Wrong StudioMaxTrackInfo userMaxTrackCount: ", " projectMaxTrackCount: 32");
            case 9:
                return "Snap state should be null on initialization, but was " + ((i3) this.b);
            case 10:
                return com.braze.requests.b.c((com.braze.requests.b) this.b);
            case 11:
                return c.a(this.b);
            default:
                return h.a((com.braze.requests.n) this.b);
        }
    }
}
