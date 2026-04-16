package l8;

import com.gnacba.common.collect.f1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 {
    public static final s1 b;
    public static final String c;
    public final com.gnacba.common.collect.k0 a;

    static {
        com.gnacba.common.collect.h0 h0Var = com.gnacba.common.collect.k0.b;
        b = new s1(f1.e);
        int i = o8.f0.a;
        c = Integer.toString(0, 36);
    }

    public s1(f1 f1Var) {
        this.a = com.gnacba.common.collect.k0.o(f1Var);
    }

    public final boolean a(int i) {
        int i2 = 0;
        while (true) {
            com.gnacba.common.collect.k0 k0Var = this.a;
            if (i2 >= k0Var.size()) {
                return false;
            }
            r1 r1Var = (r1) k0Var.get(i2);
            if (r1Var.c() && r1Var.b() == i) {
                return true;
            }
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s1.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((s1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
