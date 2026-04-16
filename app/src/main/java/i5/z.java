package i5;

import ac0.t;
import amuvvoafs.graphics.Rect;
import amuvvoafs.view.Choreographer;
import amuvvoafs.view.View;
import amuvvoafs.view.inputmethod.InputMethodManager;
import b5.b;
import d5.m0;
import d5.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import k3.e;
import lmjxuqdtp.jvm.functions.Function1;
import okhttp3.HttpUrl;
import tlydtdl.compose.foundation.lazy.layout.r1;
import tlydtdl.lifecycle.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements r {
    public final View a;
    public final r1 b;
    public final a0 c;
    public boolean d;
    public Function1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1 f220f;
    public w g;
    public k h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f221j;
    public Rect k;
    public final d l;
    public final e m;
    public w0 n;

    public z(View view, t4.x xVar) {
        r1 r1Var = new r1(view);
        a0 a0Var = new a0(0, Choreographer.getInstance());
        this.a = view;
        this.b = r1Var;
        this.c = a0Var;
        this.e = c.e;
        this.f220f = c.f216f;
        this.g = new w(4, p0.b, HttpUrl.FRAGMENT_ENCODE_SET);
        this.h = k.g;
        this.i = new ArrayList();
        this.f221j = hs1.d.E(lx1.j.b, new b(4, this));
        this.l = new d(xVar, r1Var);
        this.m = new e(0, new y[16]);
    }

    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.Object, lx1.h] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, lx1.h] */
    @Override // i5.r
    public final void a(w wVar, w wVar2) {
        boolean z = (p0.c(this.g.b, wVar2.b) && lmjxuqdtp.jvm.internal.o.c(this.g.c, wVar2.c)) ? false : true;
        this.g = wVar2;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            s sVar = (s) ((WeakReference) this.i.get(i)).get();
            if (sVar != null) {
                sVar.d(wVar2);
            }
        }
        d dVar = this.l;
        synchronized (dVar.c) {
            dVar.f218j = null;
            dVar.l = null;
            dVar.k = null;
            dVar.m = b.d;
            dVar.n = null;
            dVar.o = null;
        }
        if (lmjxuqdtp.jvm.internal.o.c(wVar, wVar2)) {
            if (z) {
                r1 r1Var = this.b;
                int iG = p0.g(wVar2.b);
                int iF = p0.f(wVar2.b);
                p0 p0Var = this.g.c;
                int iG2 = p0Var != null ? p0.g(p0Var.a) : -1;
                p0 p0Var2 = this.g.c;
                ((InputMethodManager) r1Var.b.getValue()).updateSelection((View) r1Var.c, iG, iF, iG2, p0Var2 != null ? p0.f(p0Var2.a) : -1);
                return;
            }
            return;
        }
        if (wVar != null && (!lmjxuqdtp.jvm.internal.o.c(wVar.a.b, wVar2.a.b) || (p0.c(wVar.b, wVar2.b) && !lmjxuqdtp.jvm.internal.o.c(wVar.c, wVar2.c)))) {
            r1 r1Var2 = this.b;
            ((InputMethodManager) r1Var2.b.getValue()).restartInput((View) r1Var2.c);
            return;
        }
        int size2 = this.i.size();
        for (int i2 = 0; i2 < size2; i2++) {
            s sVar2 = (s) ((WeakReference) this.i.get(i2)).get();
            if (sVar2 != null) {
                sVar2.e(this.g, this.b);
            }
        }
    }

    @Override // i5.r
    public final void b() {
        i(y.a);
    }

    @Override // i5.r
    public final void c(z3.c cVar) {
        Rect rect;
        this.k = new Rect(by1.b.P(cVar.a), by1.b.P(cVar.b), by1.b.P(cVar.c), by1.b.P(cVar.d));
        if (!this.i.isEmpty() || (rect = this.k) == null) {
            return;
        }
        this.a.requestRectangleOnScreen(new Rect(rect));
    }

    @Override // i5.r
    public final void d() {
        this.d = false;
        this.e = b.e;
        this.f220f = b.f;
        this.k = null;
        i(y.b);
    }

    @Override // i5.r
    public final void e() {
        i(y.d);
    }

    @Override // i5.r
    public final void f(w wVar, k kVar, la1.c cVar, Function1 function1) {
        this.d = true;
        this.g = wVar;
        this.h = kVar;
        this.e = cVar;
        this.f220f = function1;
        i(y.a);
    }

    @Override // i5.r
    public final void g() {
        i(y.c);
    }

    @Override // i5.r
    public final void h(w wVar, q qVar, m0 m0Var, t tVar, z3.c cVar, z3.c cVar2) {
        d dVar = this.l;
        synchronized (dVar.c) {
            try {
                dVar.f218j = wVar;
                dVar.l = qVar;
                dVar.k = m0Var;
                dVar.m = tVar;
                dVar.n = cVar;
                dVar.o = cVar2;
                if (dVar.e || dVar.d) {
                    dVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(y yVar) {
        this.m.d(yVar);
        if (this.n == null) {
            w0 w0Var = new w0(9, this);
            this.c.execute(w0Var);
            this.n = w0Var;
        }
    }
}
