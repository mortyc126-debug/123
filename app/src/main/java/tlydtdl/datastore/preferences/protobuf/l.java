package tlydtdl.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import kotlin.jvm.internal.IntCompanionObject;
import tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final k a;
    public int b;
    public int c;
    public int d = 0;

    public l(k kVar) {
        Charset charset = y.a;
        this.a = kVar;
        kVar.b = this;
    }

    public final int a() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.A();
        }
        int i2 = this.b;
        return (i2 == 0 || i2 == this.c) ? IntCompanionObject.MAX_VALUE : i2 >>> 3;
    }

    public final void b(Object obj, u0 u0Var, o oVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            u0Var.f(obj, this, oVar);
            if (this.b == this.c) {
            } else {
                throw new InvalidProtocolBufferException("Failed to parse the message.");
            }
        } finally {
            this.c = i;
        }
    }

    public final void c(Object obj, u0 u0Var, o oVar) throws InvalidProtocolBufferException {
        k kVar = this.a;
        int iB = kVar.B();
        if (kVar.a >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i = kVar.i(iB);
        kVar.a++;
        u0Var.f(obj, this, oVar);
        kVar.a(0);
        kVar.a--;
        kVar.h(i);
    }

    public final void d(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Boolean.valueOf(kVar.j()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Boolean.valueOf(kVar.j()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final g e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        w(2);
        return this.a.k();
    }

    public final void f(x xVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iA;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((s0) xVar).add(e());
            k kVar = this.a;
            if (kVar.c()) {
                return;
            } else {
                iA = kVar.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    public final void g(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 1) {
            do {
                ((s0) xVar).add(Double.valueOf(kVar.l()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.B();
        if ((iB & 7) != 0) {
            throw new InvalidProtocolBufferException("Failed to parse the message.");
        }
        int iB2 = kVar.b() + iB;
        do {
            ((s0) xVar).add(Double.valueOf(kVar.l()));
        } while (kVar.b() < iB2);
    }

    public final void h(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.m()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.m()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final Object i(p1 p1Var, Class cls, o oVar) throws InvalidProtocolBufferException {
        int iOrdinal = p1Var.ordinal();
        k kVar = this.a;
        switch (iOrdinal) {
            case 0:
                w(1);
                return Double.valueOf(kVar.l());
            case 1:
                w(5);
                return Float.valueOf(kVar.q());
            case 2:
                w(0);
                return Long.valueOf(kVar.s());
            case 3:
                w(0);
                return Long.valueOf(kVar.C());
            case 4:
                w(0);
                return Integer.valueOf(kVar.r());
            case 5:
                w(1);
                return Long.valueOf(kVar.p());
            case 6:
                w(5);
                return Integer.valueOf(kVar.n());
            case 7:
                w(0);
                return Boolean.valueOf(kVar.j());
            case 8:
                w(2);
                return kVar.z();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                u0 u0VarA = r0.c.a(cls);
                w wVarD = u0VarA.d();
                c(wVarD, u0VarA, oVar);
                u0VarA.b(wVarD);
                return wVarD;
            case 11:
                return e();
            case 12:
                w(0);
                return Integer.valueOf(kVar.B());
            case 13:
                w(0);
                return Integer.valueOf(kVar.m());
            case 14:
                w(5);
                return Integer.valueOf(kVar.u());
            case 15:
                w(1);
                return Long.valueOf(kVar.v());
            case 16:
                w(0);
                return Integer.valueOf(kVar.w());
            case 17:
                w(0);
                return Long.valueOf(kVar.x());
        }
    }

    public final void j(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 2) {
            int iB = kVar.B();
            if ((iB & 3) != 0) {
                throw new InvalidProtocolBufferException("Failed to parse the message.");
            }
            int iB2 = kVar.b() + iB;
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.n()));
            } while (kVar.b() < iB2);
            return;
        }
        if (i != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.n()));
            if (kVar.c()) {
                return;
            } else {
                iA = kVar.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    public final void k(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 1) {
            do {
                ((s0) xVar).add(Long.valueOf(kVar.p()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.B();
        if ((iB & 7) != 0) {
            throw new InvalidProtocolBufferException("Failed to parse the message.");
        }
        int iB2 = kVar.b() + iB;
        do {
            ((s0) xVar).add(Long.valueOf(kVar.p()));
        } while (kVar.b() < iB2);
    }

    public final void l(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 2) {
            int iB = kVar.B();
            if ((iB & 3) != 0) {
                throw new InvalidProtocolBufferException("Failed to parse the message.");
            }
            int iB2 = kVar.b() + iB;
            do {
                ((s0) xVar).add(Float.valueOf(kVar.q()));
            } while (kVar.b() < iB2);
            return;
        }
        if (i != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((s0) xVar).add(Float.valueOf(kVar.q()));
            if (kVar.c()) {
                return;
            } else {
                iA = kVar.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    public final void m(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.r()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.r()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void n(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Long.valueOf(kVar.s()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Long.valueOf(kVar.s()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void o(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 2) {
            int iB = kVar.B();
            if ((iB & 3) != 0) {
                throw new InvalidProtocolBufferException("Failed to parse the message.");
            }
            int iB2 = kVar.b() + iB;
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.u()));
            } while (kVar.b() < iB2);
            return;
        }
        if (i != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.u()));
            if (kVar.c()) {
                return;
            } else {
                iA = kVar.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    public final void p(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 1) {
            do {
                ((s0) xVar).add(Long.valueOf(kVar.v()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.B();
        if ((iB & 7) != 0) {
            throw new InvalidProtocolBufferException("Failed to parse the message.");
        }
        int iB2 = kVar.b() + iB;
        do {
            ((s0) xVar).add(Long.valueOf(kVar.v()));
        } while (kVar.b() < iB2);
    }

    public final void q(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.w()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.w()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void r(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Long.valueOf(kVar.x()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Long.valueOf(kVar.x()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void s(x xVar, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        String strY;
        int iA;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            k kVar = this.a;
            if (z) {
                w(2);
                strY = kVar.z();
            } else {
                w(2);
                strY = kVar.y();
            }
            ((s0) xVar).add(strY);
            if (kVar.c()) {
                return;
            } else {
                iA = kVar.A();
            }
        } while (iA == this.b);
        this.d = iA;
    }

    public final void t(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Integer.valueOf(kVar.B()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Integer.valueOf(kVar.B()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void u(x xVar) throws InvalidProtocolBufferException {
        int iA;
        int i = this.b & 7;
        k kVar = this.a;
        if (i == 0) {
            do {
                ((s0) xVar).add(Long.valueOf(kVar.C()));
                if (kVar.c()) {
                    return;
                } else {
                    iA = kVar.A();
                }
            } while (iA == this.b);
            this.d = iA;
            return;
        }
        if (i != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iB = kVar.b() + kVar.B();
        do {
            ((s0) xVar).add(Long.valueOf(kVar.C()));
        } while (kVar.b() < iB);
        v(iB);
    }

    public final void v(int i) throws InvalidProtocolBufferException {
        if (this.a.b() != i) {
            throw InvalidProtocolBufferException.e();
        }
    }

    public final void w(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if ((this.b & 7) != i) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public final boolean x() {
        int i;
        k kVar = this.a;
        if (kVar.c() || (i = this.b) == this.c) {
            return false;
        }
        return kVar.D(i);
    }
}
