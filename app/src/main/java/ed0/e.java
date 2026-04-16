package ed0;

import hy1.q;
import hy1.x;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import mu0.u;
import x11.j;
import y11.r1;
import y11.u1;
import y11.w1;
import y11.x1;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final r1 a;
    public final u1 b;
    public final boolean c;
    public final int d;
    public final Float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f103f;

    public e(r1 r1Var) {
        u1 u1VarN;
        String str;
        String str2;
        String strJ1;
        this.a = r1Var;
        int iIntValue = 0;
        if (r1Var == null || (strJ1 = r1Var.a) == null) {
            u1VarN = null;
        } else {
            c cVar = c.b;
            if (x.k0(strJ1, cVar.a(), false)) {
                strJ1 = q.j1(strJ1, cVar.a());
            } else {
                c cVar2 = c.c;
                if (x.k0(strJ1, cVar2.a(), false)) {
                    strJ1 = q.j1(strJ1, cVar2.a());
                }
            }
            u1VarN = lg.e.N(strJ1);
        }
        this.b = u1VarN == null ? u1.b : u1VarN;
        this.c = u.x(r1Var);
        Integer num = r1Var != null ? r1Var.d : null;
        if (num != null) {
            iIntValue = num.intValue();
        } else if (r1Var == null || (str2 = r1Var.a) == null || !x.k0(str2, c.b.a(), false)) {
            iIntValue = (r1Var == null || (str = r1Var.a) == null || !x.k0(str, c.c.a(), false)) ? 50 : 100;
        }
        this.d = iIntValue;
        this.e = r1Var != null ? r1Var.e : null;
        j jVarL = qg.a.l(r1Var != null ? r1Var.c : null);
        this.f103f = jVarL == null ? x1.c : jVarL;
    }

    public final boolean a() {
        return !this.c && b();
    }

    public final boolean b() {
        return w1.b(this.b) || !b.a(this.d);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final String c() throws NoWhenBranchMatchedException {
        switch (this.b.ordinal()) {
            case 0:
                return "universal";
            case 1:
                return "fire";
            case 2:
                return "clarity";
            case 3:
                return "tape";
            case 4:
                return "natural";
            case 5:
                return "spatial";
            case 6:
                return "cinematic";
            case 7:
                return "punch";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && o.c(this.a, ((e) obj).a);
    }

    public final int hashCode() {
        r1 r1Var = this.a;
        if (r1Var == null) {
            return 0;
        }
        return r1Var.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MasteringState(");
        sb.append("type=" + this.b + ", ");
        sb.append("bypass=" + this.c + ", ");
        sb.append("intensity=" + p.c(this.d, "MasteringIntensity(level=", ")") + ", ");
        sb.append("inputGain=" + this.e + ", ");
        r1 r1Var = this.a;
        sb.append("drySampleId=" + (r1Var != null ? r1Var.b : null) + ", ");
        sb.append("version=" + this.f103f.toString());
        sb.append(')');
        return sb.toString();
    }
}
