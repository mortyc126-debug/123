package tlydtdl.compose.foundation.layout;

import amuvvoafs.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 {
    public static final WeakHashMap v = new WeakHashMap();
    public final a a = e.b(4, "captionBar");
    public final a b;
    public final a c;
    public final a d;
    public final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f496f;
    public final a g;
    public final a h;
    public final a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t2 f497j;
    public final q2 k;
    public final t2 l;
    public final t2 m;
    public final t2 n;
    public final t2 o;
    public final t2 p;
    public final t2 q;
    public final t2 r;
    public final boolean s;
    public int t;
    public final j1 u;

    public x2(View view) {
        a aVarB = e.b(128, "displayCutout");
        this.b = aVarB;
        a aVarB2 = e.b(8, "ime");
        this.c = aVarB2;
        a aVarB3 = e.b(32, "mandatorySystemGestures");
        this.d = aVarB3;
        this.e = e.b(2, "navigationBars");
        this.f496f = e.b(1, "statusBars");
        a aVarB4 = e.b(519, "systemBars");
        this.g = aVarB4;
        a aVarB5 = e.b(16, "systemGestures");
        this.h = aVarB5;
        a aVarB6 = e.b(64, "tappableElement");
        this.i = aVarB6;
        t2 t2Var = new t2(new n1(0, 0, 0, 0), "waterfall");
        this.f497j = t2Var;
        this.k = new q2(new q2(aVarB4, aVarB2), aVarB);
        new q2(new q2(new q2(aVarB6, aVarB3), aVarB5), t2Var);
        this.l = e.d(4, "captionBarIgnoringVisibility");
        this.m = e.d(2, "navigationBarsIgnoringVisibility");
        this.n = e.d(1, "statusBarsIgnoringVisibility");
        this.o = e.d(519, "systemBarsIgnoringVisibility");
        this.p = e.d(64, "tappableElementIgnoringVisibility");
        this.q = e.d(8, "imeAnimationTarget");
        this.r = e.d(8, "imeAnimationSource");
        View parent = view.getParent();
        View view2 = parent instanceof View ? parent : null;
        Object tag = view2 != null ? view2.getTag(2131427705) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.s = bool != null ? bool.booleanValue() : false;
        this.u = new j1(this);
    }

    public static void a(x2 x2Var, r6.z1 z1Var) {
        boolean z = false;
        x2Var.a.f(z1Var, 0);
        x2Var.c.f(z1Var, 0);
        x2Var.b.f(z1Var, 0);
        x2Var.e.f(z1Var, 0);
        x2Var.f496f.f(z1Var, 0);
        x2Var.g.f(z1Var, 0);
        x2Var.h.f(z1Var, 0);
        x2Var.i.f(z1Var, 0);
        x2Var.d.f(z1Var, 0);
        x2Var.l.f(m.L(z1Var.a.h(4)));
        x2Var.m.f(m.L(z1Var.a.h(2)));
        x2Var.n.f(m.L(z1Var.a.h(1)));
        x2Var.o.f(m.L(z1Var.a.h(519)));
        x2Var.p.f(m.L(z1Var.a.h(64)));
        r6.j jVarF = z1Var.a.f();
        if (jVarF != null) {
            x2Var.f497j.f(m.L(jVarF.a()));
        }
        synchronized (s3.l.c) {
            q1.o0 o0Var = ((s3.b) s3.l.j).i;
            if (o0Var != null) {
                if (o0Var.h()) {
                    z = true;
                }
            }
        }
        if (z) {
            s3.l.a();
        }
    }
}
