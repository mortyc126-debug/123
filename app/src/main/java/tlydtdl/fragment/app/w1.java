package tlydtdl.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w1 {
    public ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f592f;
    public boolean g;
    public boolean h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f593j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;

    public final void b(v1 v1Var) {
        this.a.add(v1Var);
        v1Var.d = this.b;
        v1Var.e = this.c;
        v1Var.f591f = this.d;
        v1Var.g = this.e;
    }

    public final void c(String str) {
        if (!this.h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.g = true;
        this.i = str;
    }

    public abstract int d();

    public abstract void e(int i, k0 k0Var, String str, int i2);

    public final void f(int i, k0 k0Var, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        e(i, k0Var, str, 2);
    }
}
