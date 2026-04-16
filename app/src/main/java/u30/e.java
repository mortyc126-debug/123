package u30;

import ak.s1;
import com.bandlab.audiocore.generated.Transport;
import eh0.b;
import hg1.u;
import java.util.List;
import n30.k;
import ny1.r2;
import qi.c0;
import qi.q;
import qi.s;
import qi.y;
import st.w0;
import sw0.l;
import zj.n;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements a {
    public final y a;
    public final b b;
    public final int c;
    public final c d;
    public final v80.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f612f;
    public final k g;
    public final k h;
    public final k i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f613j;
    public final k k;

    public e(n nVar, y yVar, b bVar, int i, c cVar) {
        this.a = yVar;
        this.b = bVar;
        this.c = i;
        this.d = cVar;
        v80.h hVar = nVar.c.w;
        this.e = hVar;
        this.f612f = new g(i);
        this.g = w0.o0((r2) hVar.c, new l(27));
        r2 r2Var = (r2) hVar.c;
        this.h = w0.o0(r2Var, new l(28));
        this.i = w0.o0(r2Var, new l(29));
        this.f613j = d.a;
        this.k = w0.o0(r2Var, new s70.a(12, this));
    }

    public final void a(double d) {
        v80.h hVar = this.e;
        hVar.getClass();
        new s1(d, 4).invoke((Transport) hVar.b);
        hVar.h();
        y.k(this.a, "cycle_set_new_cycle", c(), (qi.h) null, 12);
    }

    public final List b() {
        q c0Var = new c0("origin", qb.a.i(this.f613j));
        lx1.l lVar = (lx1.l) this.g.getValue();
        return ct1.b.C(new q[]{c0Var, new s("cycle_length", ((((u) lVar.b).a - ((u) lVar.a).a) / ((double) this.c)) / ((double) 4))});
    }

    public final List c() {
        return ct1.b.B(new c0("origin", qb.a.i(this.f613j)));
    }

    public final void d() {
        boolean cycleState;
        if (this.d.a()) {
            v80.h hVar = this.e;
            Transport transport = (Transport) hVar.b;
            if (hVar.g()) {
                new xy.k(25, hVar).invoke(transport);
                hVar.h();
                cycleState = transport.getCycleState();
            } else {
                cycleState = ((z11.e) ((r2) hVar.c).getValue()).c;
            }
            if (cycleState) {
                return;
            }
            y.k(this.a, "cycle_disable", c(), (qi.h) null, 12);
        }
    }

    public final void e() {
        if (((Boolean) this.h.getValue()).booleanValue()) {
            y.k(this.a, "cycle_playback_start", b(), (qi.h) null, 12);
        }
    }
}
