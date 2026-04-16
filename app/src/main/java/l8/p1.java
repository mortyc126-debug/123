package l8;

import com.gnacba.common.collect.f1;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class p1 {
    public boolean A;
    public boolean B;
    public boolean C;
    public HashMap D;
    public HashSet E;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f307f;
    public int g;
    public int h;
    public com.gnacba.common.collect.k0 m;
    public com.gnacba.common.collect.k0 n;
    public int o;
    public com.gnacba.common.collect.k0 p;
    public int q;
    public int r;
    public int s;
    public com.gnacba.common.collect.k0 t;
    public o1 u;
    public com.gnacba.common.collect.k0 v;
    public int w;
    public boolean x;
    public int y;
    public boolean z;
    public int a = IntCompanionObject.MAX_VALUE;
    public int b = IntCompanionObject.MAX_VALUE;
    public int c = IntCompanionObject.MAX_VALUE;
    public int d = IntCompanionObject.MAX_VALUE;
    public int i = IntCompanionObject.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f308j = IntCompanionObject.MAX_VALUE;
    public boolean k = true;
    public boolean l = true;

    public p1() {
        com.gnacba.common.collect.h0 h0Var = com.gnacba.common.collect.k0.b;
        f1 f1Var = f1.e;
        this.m = f1Var;
        this.n = f1Var;
        this.o = 0;
        this.p = f1Var;
        this.q = 0;
        this.r = IntCompanionObject.MAX_VALUE;
        this.s = IntCompanionObject.MAX_VALUE;
        this.t = f1Var;
        this.u = o1.d;
        this.v = f1Var;
        this.w = 0;
        this.x = true;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = new HashMap();
        this.E = new HashSet();
    }

    public static f1 f(String[] strArr) {
        com.gnacba.common.collect.g0 g0VarN = com.gnacba.common.collect.k0.n();
        for (String str : strArr) {
            str.getClass();
            g0VarN.a(o8.f0.V(str));
        }
        return g0VarN.g();
    }

    public void a(m1 m1Var) {
        this.D.put(m1Var.a, m1Var);
    }

    public q1 b() {
        return new q1(this);
    }

    public p1 c() {
        this.D.clear();
        return this;
    }

    public p1 d(int i) {
        Iterator it = this.D.values().iterator();
        while (it.hasNext()) {
            if (((m1) it.next()).a() == i) {
                it.remove();
            }
        }
        return this;
    }

    public final void e(q1 q1Var) {
        this.a = q1Var.a;
        this.b = q1Var.b;
        this.c = q1Var.c;
        this.d = q1Var.d;
        this.e = q1Var.e;
        this.f307f = q1Var.f309f;
        this.g = q1Var.g;
        this.h = q1Var.h;
        this.i = q1Var.i;
        this.f308j = q1Var.f310j;
        this.k = q1Var.k;
        this.l = q1Var.l;
        this.m = q1Var.m;
        this.n = q1Var.n;
        this.o = q1Var.o;
        this.p = q1Var.p;
        this.q = q1Var.q;
        this.r = q1Var.r;
        this.s = q1Var.s;
        this.t = q1Var.t;
        this.u = q1Var.u;
        this.v = q1Var.v;
        this.w = q1Var.w;
        this.x = q1Var.x;
        this.y = q1Var.y;
        this.z = q1Var.z;
        this.A = q1Var.A;
        this.B = q1Var.B;
        this.C = q1Var.C;
        this.E = new HashSet((Collection) q1Var.E);
        this.D = new HashMap((Map) q1Var.D);
    }

    public p1 g() {
        this.y = -3;
        return this;
    }

    public p1 h(m1 m1Var) {
        d(m1Var.a());
        this.D.put(m1Var.a, m1Var);
        return this;
    }

    public p1 i() {
        return j(new String[0]);
    }

    public p1 j(String... strArr) {
        this.v = f(strArr);
        this.x = false;
        return this;
    }

    public p1 k() {
        this.w = 0;
        this.x = false;
        return this;
    }

    public p1 l(int i) {
        this.E.remove(Integer.valueOf(i));
        return this;
    }
}
