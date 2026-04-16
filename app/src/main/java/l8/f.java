package l8;

import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements z0 {
    public final j1 a = new j1();

    @Override // l8.z0
    public final void A() {
        e(6);
    }

    @Override // l8.z0
    public long A0() {
        return getCurrentPosition();
    }

    @Override // l8.z0
    public final void B() {
        c(-9223372036854775807L, G0(), false);
    }

    @Override // l8.z0
    public long C0() {
        return getCurrentPosition();
    }

    @Override // l8.z0
    public final boolean D0() {
        k1 k1VarA0 = a0();
        return !k1VarA0.p() && k1VarA0.m(G0(), this.a, 0L).h;
    }

    @Override // l8.z0
    public final void E0(k0 k0Var) {
        R0(com.gnacba.common.collect.k0.r(k0Var));
    }

    @Override // l8.z0
    public final void H(int i) {
        I(i, i + 1);
    }

    @Override // l8.z0
    public final void I0(int i, int i2) {
        if (i != i2) {
            J0(i, i + 1, i2);
        }
    }

    @Override // l8.z0
    public final void J() {
        if (a0().p() || u()) {
            b(7);
            return;
        }
        boolean zA = a();
        if (T0() && !D0()) {
            if (zA) {
                e(7);
                return;
            } else {
                b(7);
                return;
            }
        }
        if (!zA || getCurrentPosition() > n0()) {
            d(7, 0L);
        } else {
            e(7);
        }
    }

    @Override // l8.z0
    public final void K0(List list) {
        B0(IntCompanionObject.MAX_VALUE, list);
    }

    @Override // l8.z0
    public long M0() {
        return getCurrentPosition();
    }

    @Override // l8.z0
    public final void N(k0 k0Var, long j2) {
        e0(0, j2, com.gnacba.common.collect.k0.r(k0Var));
    }

    @Override // l8.z0
    public final void O() {
        int iE;
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            iE = -1;
        } else {
            int iG0 = G0();
            int iJ = j();
            if (iJ == 1) {
                iJ = 0;
            }
            iE = k1VarA0.e(iG0, iJ, q());
        }
        if (iE == -1) {
            b(8);
        } else if (iE == G0()) {
            c(-9223372036854775807L, G0(), true);
        } else {
            c(-9223372036854775807L, iE, false);
        }
    }

    @Override // l8.z0
    public final void O0() {
        long currentPosition = getCurrentPosition() + z0();
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        d(12, Math.max(currentPosition, 0L));
    }

    @Override // l8.z0
    public final void P0() {
        long currentPosition = getCurrentPosition() + (-S0());
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        d(11, Math.max(currentPosition, 0L));
    }

    @Override // l8.z0
    public final boolean R() {
        int iE;
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            iE = -1;
        } else {
            int iG0 = G0();
            int iJ = j();
            if (iJ == 1) {
                iJ = 0;
            }
            iE = k1VarA0.e(iG0, iJ, q());
        }
        return iE != -1;
    }

    @Override // l8.z0
    public final boolean T0() {
        k1 k1VarA0 = a0();
        return !k1VarA0.p() && k1VarA0.m(G0(), this.a, 0L).a();
    }

    @Override // l8.z0
    public final boolean V(int i) {
        return k0().a(i);
    }

    @Override // l8.z0
    public final boolean Y() {
        k1 k1VarA0 = a0();
        return !k1VarA0.p() && k1VarA0.m(G0(), this.a, 0L).i;
    }

    public final boolean a() {
        int iK;
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            iK = -1;
        } else {
            int iG0 = G0();
            int iJ = j();
            if (iJ == 1) {
                iJ = 0;
            }
            iK = k1VarA0.k(iG0, iJ, q());
        }
        return iK != -1;
    }

    public final void b(int i) {
        c(-9223372036854775807L, -1, false);
    }

    public abstract void c(long j2, int i, boolean z);

    public final void d(int i, long j2) {
        c(j2, G0(), false);
    }

    public final void e(int i) {
        int iK;
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            iK = -1;
        } else {
            int iG0 = G0();
            int iJ = j();
            if (iJ == 1) {
                iJ = 0;
            }
            iK = k1VarA0.k(iG0, iJ, q());
        }
        if (iK == -1) {
            b(i);
        } else if (iK == G0()) {
            c(-9223372036854775807L, G0(), true);
        } else {
            c(-9223372036854775807L, iK, false);
        }
    }

    @Override // l8.z0
    public final void f0() {
        int iE;
        if (a0().p() || u()) {
            b(9);
            return;
        }
        if (!R()) {
            if (T0() && Y()) {
                c(-9223372036854775807L, G0(), false);
                return;
            } else {
                b(9);
                return;
            }
        }
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            iE = -1;
        } else {
            int iG0 = G0();
            int iJ = j();
            if (iJ == 1) {
                iJ = 0;
            }
            iE = k1VarA0.e(iG0, iJ, q());
        }
        if (iE == -1) {
            b(9);
        } else if (iE == G0()) {
            c(-9223372036854775807L, G0(), true);
        } else {
            c(-9223372036854775807L, iE, false);
        }
    }

    @Override // l8.z0
    public long getDuration() {
        return o0();
    }

    @Override // l8.z0
    public final long i0() {
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            return -9223372036854775807L;
        }
        int iG0 = G0();
        j1 j1Var = this.a;
        if (k1VarA0.m(iG0, j1Var, 0L).f296f == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (o8.f0.C(j1Var.g) - j1Var.f296f) - A0();
    }

    @Override // l8.z0
    public final boolean isPlaying() {
        return r() == 3 && l0() && Z() == 0;
    }

    @Override // l8.z0
    public final void j0(int i, long j2) {
        c(j2, i, false);
    }

    @Override // l8.z0
    public final void n(long j2) {
        d(5, j2);
    }

    @Override // l8.z0
    public final long o0() {
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            return -9223372036854775807L;
        }
        return o8.f0.g0(k1VarA0.m(G0(), this.a, 0L).m);
    }

    @Override // l8.z0
    public final void p(float f2) {
        setPlaybackParameters(new t0(f2, getPlaybackParameters().b));
    }

    @Override // l8.z0
    public int p0() {
        return G0();
    }

    @Override // l8.z0
    public final void pause() {
        L(false);
    }

    @Override // l8.z0
    public final void play() {
        L(true);
    }

    @Override // l8.z0
    public final void w() {
        I(0, IntCompanionObject.MAX_VALUE);
    }

    @Override // l8.z0
    public final void w0(int i, k0 k0Var) {
        X(com.gnacba.common.collect.k0.r(k0Var), i, i + 1);
    }

    @Override // l8.z0
    public final k0 x() {
        k1 k1VarA0 = a0();
        if (k1VarA0.p()) {
            return null;
        }
        return k1VarA0.m(G0(), this.a, 0L).c;
    }

    @Override // l8.z0
    public final int y() {
        long jC0 = C0();
        long duration = getDuration();
        if (jC0 == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return o8.f0.i((int) ((jC0 * 100) / duration), 0, 100);
    }

    @Override // l8.z0
    public final void y0(int i) {
        c(-9223372036854775807L, i, false);
    }
}
