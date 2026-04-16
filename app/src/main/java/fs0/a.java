package fs0;

import a2.b1;
import a2.p4;
import a2.r2;
import a2.z0;
import a4.a1;
import a4.w0;
import cf1.h0;
import cf1.m0;
import cf1.q0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import f3.f2;
import f3.j3;
import f3.t2;
import java.util.List;
import kotlin.jvm.internal.CharCompanionObject;
import ld1.r;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import lx1.l;
import md1.n0;
import ny1.p2;
import of1.q;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.apache.commons.net.telnet.TelnetCommand;
import q3.p;
import t3.f;
import tlydtdl.compose.foundation.layout.HorizontalAlignElement;
import tlydtdl.compose.foundation.layout.VerticalAlignElement;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.foundation.layout.f0;
import tlydtdl.compose.foundation.layout.g0;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.foundation.layout.x1;
import tlydtdl.compose.foundation.lazy.layout.l0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import v1.p1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final q3.k a = new q3.k(new ef1.d(7), false, -1272164694);
    public static final q3.k b = new q3.k(new a70.a(4), false, -998576251);
    public static final q3.k c = new q3.k(new ef1.d(8), false, 1992555268);
    public static final q3.k d = new q3.k(new ef1.d(9), false, 447699562);

    public static final void a(x10.v vVar, x10.v vVar2, x10.v vVar3, boolean z, e eVar, q3.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        l lVar;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(646770679);
        if ((i & 6) == 0) {
            i2 = (sVar.g(vVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(vVar2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(vVar3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? sVar.g(eVar) : sVar.i(eVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((i & 196608) == 0) {
            i2 |= sVar.i(kVar) ? 131072 : 65536;
        }
        if (sVar.W(i2 & 1, (74899 & i2) != 74898)) {
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = tlydtdl.compose.runtime.a0.t(Boolean.FALSE);
                sVar.q0(objR);
            }
            e1 e1Var = (e1) objR;
            boolean zH = sVar.h(((Boolean) e1Var.getValue()).booleanValue());
            Object objR2 = sVar.R();
            if (zH || objR2 == x0Var) {
                objR2 = new com.bandlab.uikit.compose.bottomsheet.e(((Boolean) e1Var.getValue()).booleanValue(), true, new l0(2, e1Var));
                sVar.q0(objR2);
            }
            com.bandlab.uikit.compose.bottomsheet.e eVar2 = (com.bandlab.uikit.compose.bottomsheet.e) objR2;
            boolean z2 = (57344 & i2) == 16384 || ((i2 & 32768) != 0 && sVar.g(eVar));
            Object objR3 = sVar.R();
            if (z2 || objR3 == x0Var) {
                if (lmjxuqdtp.jvm.internal.o.c(eVar, d.a)) {
                    lVar = new l(Boolean.TRUE, new l0(3, e1Var));
                } else if (lmjxuqdtp.jvm.internal.o.c(eVar, b.a)) {
                    lVar = new l(Boolean.FALSE, new g(0));
                } else {
                    if (!(eVar instanceof c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    lVar = new l(Boolean.TRUE, ((c) eVar).a);
                }
                objR3 = lVar;
                sVar.q0(objR3);
            }
            l lVar2 = (l) objR3;
            boolean zBooleanValue = ((Boolean) lVar2.a).booleanValue();
            int i3 = i2 & 14;
            b(vVar, vVar2, zBooleanValue, md1.g.v(t3.m.a, (n0) null, (a5.h) null, false, zBooleanValue, (Function0) null, (Function0) null, (Function0) lVar2.b, 55), null, p.d(-497289695, new h(1, vVar3, z), sVar), sVar, i3 | 196608 | (i2 & 112), 16);
            com.bandlab.uikit.compose.bottomsheet.l.b(vVar, eVar2, (t3.p) null, (x10.v) null, (f) null, 0L, (com.bandlab.uikit.compose.bottomsheet.s) null, false, false, (v2) null, p.d(1868468972, new r2(15, kVar, eVar2), sVar), sVar, i3, 1020);
            sVar = sVar;
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ds0.d(vVar, vVar2, vVar3, z, eVar, kVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(x10.v r29, x10.v r30, boolean r31, t3.p r32, lmjxuqdtp.jvm.functions.Function2 r33, q3.k r34, tlydtdl.compose.runtime.m r35, int r36, int r37) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fs0.a.b(x10.v, x10.v, boolean, t3.p, lmjxuqdtp.jvm.functions.Function2, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0215  */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(x10.v r26, x10.v r27, ld1.r r28, boolean r29, q3.k r30, tlydtdl.compose.runtime.m r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fs0.a.c(x10.v, x10.v, ld1.r, boolean, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void d(x10.v vVar, t3.p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        x10.v vVar2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1235407709);
        if ((i & 6) == 0) {
            i2 = (sVar.g(vVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 48;
        if (sVar.W(i3 & 1, (i3 & 19) != 18)) {
            float f2 = 16;
            t3.p pVar2 = t3.m.a;
            t3.p pVarH = tlydtdl.compose.foundation.layout.m.H(pVar2, f2, 0.0f, f2, f2, 2);
            pVar = pVar2;
            vVar2 = vVar;
            z10.d.h(vVar2, i.u(r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size), q.l(), pVarH, false, (of1.e) null, 0, (Function1) null, sVar, i3 & 14, 240);
        } else {
            vVar2 = vVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(vVar2, pVar, i, 4);
        }
    }

    public static final void e(final Function0 function0, final Function0 function02, final Function0 function03, final Function0 function04, final Function0 function05, final Function0 function06, final x10.l lVar, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1496429093);
        int i2 = i | (sVar.g(null) ? 4 : 2) | (sVar.i(function0) ? 32 : 16) | (sVar.i(function02) ? 256 : 128) | (sVar.i(function03) ? 2048 : 1024) | (sVar.i(function04) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192) | (sVar.i(function05) ? 131072 : 65536) | (sVar.i(function06) ? 1048576 : 524288) | (sVar.g(lVar) ? 8388608 : 4194304);
        if (sVar.W(i2 & 1, (4793491 & i2) != 4793490)) {
            c(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132018502), null, i.u(r.Companion, 2131100962), false, p.d(1696322021, new Function3() { // from class: fs0.t
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    lmjxuqdtp.jvm.internal.o.h((f0) obj, "$this$Group");
                    tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                    if (sVar2.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                        a.g(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020098), lVar, false, function06, sVar2, 0, 4);
                        a.j(sVar2);
                        a.g(new x10.r(2132018477), null, false, function0, sVar2, 0, 6);
                        a.j(sVar2);
                        a.g(new x10.r(2132020314), null, false, function02, sVar2, 0, 6);
                        a.j(sVar2);
                        a.g(new x10.r(2132019136), null, false, function05, sVar2, 0, 6);
                        a.j(sVar2);
                        a.g(new x10.r(2132019864), null, false, function03, sVar2, 0, 6);
                        a.j(sVar2);
                        a.g(new x10.r(2132019941), null, false, function04, sVar2, 0, 6);
                    } else {
                        sVar2.Z();
                    }
                    return lx1.b0.a;
                }
            }, sVar), sVar, ((i2 << 3) & 112) | 24576, 8);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new e80.m(function0, function02, function03, function04, function05, function06, lVar, i, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(x10.v r20, final java.lang.Object r21, final java.util.List r22, final lmjxuqdtp.jvm.functions.Function1 r23, final lmjxuqdtp.jvm.functions.Function1 r24, x10.v r25, boolean r26, fs0.e r27, tlydtdl.compose.runtime.m r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fs0.a.f(x10.v, java.lang.Object, java.util.List, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function1, x10.v, boolean, fs0.e, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void g(x10.v vVar, x10.v vVar2, boolean z, Function0 function0, tlydtdl.compose.runtime.m mVar, int i, int i2) {
        int i3;
        int i4;
        tlydtdl.compose.runtime.s sVar;
        x10.v vVar3;
        boolean z2;
        lmjxuqdtp.jvm.internal.o.h(function0, "navigate");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(-1543412390);
        int i6 = i | (sVar2.g(vVar) ? 4 : 2);
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 = i6 | 48;
        } else {
            i3 = i6 | (sVar2.g(vVar2) ? 32 : 16);
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i4 = i3 | 384;
        } else {
            i4 = i3 | (sVar2.h(z) ? 256 : 128);
        }
        int i9 = i4 | (sVar2.i(function0) ? 2048 : 1024);
        if (sVar2.W(i9 & 1, (i9 & 1171) != 1170)) {
            x10.v vVar4 = i7 != 0 ? null : vVar2;
            boolean z3 = i8 != 0 ? true : z;
            sVar = sVar2;
            z2 = z3;
            vVar3 = vVar4;
            b(vVar, vVar3, z2, md1.g.v(t3.m.a, (n0) null, (a5.h) null, false, z3, (Function0) null, (Function0) null, function0, 55), null, c, sVar, (i9 & 14) | 196608 | (i9 & 112) | (i9 & 896), 16);
        } else {
            sVar = sVar2;
            sVar.Z();
            vVar3 = vVar2;
            z2 = z;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new g(vVar, vVar3, z2, function0, i, i2);
        }
    }

    public static final void h(hg1.d dVar, ds0.l lVar, hg1.x xVar, e eVar, Function1 function1, Function1 function12, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.runtime.s sVar;
        lmjxuqdtp.jvm.internal.o.h(dVar, "revisionKey");
        lmjxuqdtp.jvm.internal.o.h(lVar, "tempo");
        lmjxuqdtp.jvm.internal.o.h(xVar, "timeSignature");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(1032034527);
        int i2 = i | (sVar2.e(dVar.ordinal()) ? 4 : 2) | (sVar2.g(lVar) ? 32 : 16) | (sVar2.i(xVar) ? 256 : 128) | (sVar2.g(eVar) ? 2048 : 1024) | (sVar2.i(function1) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192) | (sVar2.i(function12) ? 131072 : 65536);
        if (sVar2.W(i2 & 1, (74899 & i2) != 74898)) {
            sVar = sVar2;
            c(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019044), null, null, false, p.d(-1332256481, new u(lVar, xVar, function12, eVar, dVar, function1), sVar2), sVar, 24576, 14);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new t2(dVar, lVar, xVar, eVar, function1, function12, i, 1);
        }
    }

    public static final void i(boolean z, Function0 function0, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.runtime.s sVar;
        boolean z2 = z;
        lmjxuqdtp.jvm.internal.o.h(function0, "turnOff");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(923813051);
        int i2 = (sVar2.h(z2) ? 4 : 2) | i | (sVar2.i(function0) ? 32 : 16);
        if (sVar2.W(i2 & 1, (i2 & 19) != 18)) {
            float f2 = 12;
            tlydtdl.compose.foundation.layout.j jVarG = tlydtdl.compose.foundation.layout.l.g(f2);
            t3.m mVar2 = t3.m.a;
            t3.p pVarE = o2.e(mVar2, 1.0f);
            ld1.d dVar = r.Companion;
            t3.p pVarD = tlydtdl.compose.foundation.layout.m.D(tlydtdl.compose.foundation.a.c(pVarE, i.e(2131100962, 0, sVar2, dVar), w0.a), f2);
            f fVar = t3.c.m;
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(jVarG, fVar, sVar2, 6);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            t3.p pVarX = j4.x(sVar2, pVarD);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            s4.i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar2, e0VarA, iVar);
            s4.i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, iVar2);
            s4.i iVar3 = s4.k.g;
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar3);
            }
            s4.i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX, iVar4);
            float f3 = 16;
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.g(f3), t3.c.j, sVar2, 6);
            int iHashCode2 = Long.hashCode(sVar2.T);
            u1 u1VarM2 = sVar2.m();
            t3.p pVarX2 = j4.x(sVar2, mVar2);
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, l2VarA, iVar);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM2, iVar2);
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar2, iHashCode2, iVar3);
            }
            fe1.f.a(i.g(sVar2, pVarX2, iVar4, 2131231833, false), (String) null, (a1) null, o2.p(new VerticalAlignElement(t3.c.k), 30), (t3.d) null, (q4.m) null, 0.0f, new a4.q(i.e(R.dimen.m3_comp_extended_fab_primary_pressed_state_layer_opacity, 0, sVar2, dVar), 5), (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, 432, 0, 65392);
            e0 e0VarA2 = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, fVar, sVar2, 0);
            int iHashCode3 = Long.hashCode(sVar2.T);
            u1 u1VarM3 = sVar2.m();
            t3.p pVarX3 = j4.x(sVar2, mVar2);
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, e0VarA2, iVar);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM3, iVar2);
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode3))) {
                i.x(iHashCode3, sVar2, iHashCode3, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX3, iVar4);
            z10.d.h(com.ironsource.adqualitysdk.sdk.i.a0.w(x10.v.Companion, 2132018932, dVar), new ld1.q(R.dimen.m3_comp_extended_fab_primary_pressed_state_layer_opacity), q.l(), (t3.p) null, false, (of1.e) null, 0, (Function1) null, sVar2, 0, TelnetCommand.EL);
            z10.d.h(f2.u(2132018933, dVar), new ld1.q(R.dimen.m3_comp_extended_fab_primary_pressed_state_layer_opacity), q.h(), (t3.p) null, false, (of1.e) null, 0, (Function1) null, sVar2, 0, TelnetCommand.EL);
            sVar2.r(true);
            sVar2.r(true);
            x10.r rVar = new x10.r(2132020450);
            dVar.getClass();
            z2 = z;
            z10.d.h(rVar, new ld1.q(R.dimen.m3_comp_extended_fab_primary_pressed_state_layer_opacity), q.g(), tlydtdl.compose.foundation.layout.m.E(md1.g.v(new HorizontalAlignElement(t3.c.o), (n0) null, (a5.h) null, false, z2, (Function0) null, (Function0) null, function0, 55), f3, 4), true, (of1.e) null, 0, (Function1) null, sVar2, 24576, 224);
            sVar = sVar2;
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new v(z2, function0, i, 0);
        }
    }

    public static final void j(tlydtdl.compose.runtime.m mVar) {
        aq1.b.b((float) 0.5d, 48, 13, 0L, mVar, (t3.p) null, false);
    }

    public static final void k(final x10.r rVar, final float f2, final Function1 function1, final Function1 function12, final ey1.f fVar, final boolean z, tlydtdl.compose.runtime.m mVar, final int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(function1, "onValueChange");
        lmjxuqdtp.jvm.internal.o.h(function12, "toTextRes");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1129194223);
        if ((i & 6) == 0) {
            i2 = (sVar.g(rVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.d(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.i(function12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.g(fVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.h(z) ? 131072 : 65536;
        }
        if (sVar.W(i2 & 1, (74899 & i2) != 74898)) {
            sVar.b0();
            if ((i & 1) != 0 && !sVar.D()) {
                sVar.Z();
            }
            sVar.s();
            b(rVar, null, z, null, p.d(-600151932, new Function2() { // from class: fs0.m
                public final Object invoke(Object obj, Object obj2) {
                    tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                    if (sVar2.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                        by1.b.j(f2, function1, (t3.p) null, (cf1.t) null, (h0) null, (m0) null, z, false, false, (q0) null, (Function0) null, (Function0) null, 0L, false, fVar, 0, (c2.m) null, (p5.f) null, (Function4) null, sVar2, 0, 0, 507836);
                    } else {
                        sVar2.Z();
                    }
                    return lx1.b0.a;
                }
            }, sVar), p.d(-1302747771, new com.bandlab.global.player.ui.internal.u(f2, function12), sVar), sVar, (i2 & 14) | 221232 | ((i2 >> 9) & 896), 8);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new Function2() { // from class: fs0.n
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    a.k(rVar, f2, function1, function12, fVar, z, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(i | 1));
                    return lx1.b0.a;
                }
            };
        }
    }

    public static final void l(x10.r rVar, int i, Function1 function1, ey1.k kVar, Function1 function12, boolean z, tlydtdl.compose.runtime.m mVar, int i2) {
        lmjxuqdtp.jvm.internal.o.h(function12, "toTextRes");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(670164485);
        int i3 = i2 | (sVar.g(rVar) ? 4 : 2) | (sVar.e(i) ? 32 : 16) | (sVar.i(function1) ? 256 : 128) | (sVar.i(kVar) ? 2048 : 1024) | (sVar.h(z) ? 131072 : 65536);
        if (sVar.W(i3 & 1, (74899 & i3) != 74898)) {
            boolean z2 = (i3 & 112) == 32;
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (z2 || objR == x0Var) {
                objR = Float.valueOf(i);
                sVar.q0(objR);
            }
            float fFloatValue = ((Number) objR).floatValue();
            boolean zG = sVar.g(kVar);
            Object objR2 = sVar.R();
            if (zG || objR2 == x0Var) {
                ey1.e eVar = new ey1.e(((ey1.i) kVar).a, ((ey1.i) kVar).b);
                sVar.q0(eVar);
                objR2 = eVar;
            }
            ey1.f fVar = (ey1.f) objR2;
            boolean z3 = (i3 & 896) == 256;
            Object objR3 = sVar.R();
            if (z3 || objR3 == x0Var) {
                objR3 = new x1(2, function1);
                sVar.q0(objR3);
            }
            Function1 function13 = (Function1) objR3;
            Object objR4 = sVar.R();
            if (objR4 == x0Var) {
                objR4 = new x1(3, function12);
                sVar.q0(objR4);
            }
            k(rVar, fFloatValue, function13, (Function1) objR4, fVar, z, sVar, i3 & 458766);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new cf1.f0(rVar, i, function1, kVar, function12, z, i2);
        }
    }

    public static final void m(gs0.d dVar, gs0.b bVar, p2 p2Var, t3.p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(dVar, "state");
        gs0.a aVar = dVar.a;
        lmjxuqdtp.jvm.internal.o.h(bVar, "callbacks");
        lmjxuqdtp.jvm.internal.o.h(p2Var, "scrollToSafeAudioEvent");
        lmjxuqdtp.jvm.internal.o.h(pVar, "modifier");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1721229704);
        int i2 = i | (sVar.g(dVar) ? 4 : 2) | (sVar.g(bVar) ? 32 : 16) | (sVar.i(p2Var) ? 256 : 128) | (sVar.g(pVar) ? 2048 : 1024);
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            p1 p1VarD = uz1.g.D(sVar);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = new j2.b();
                sVar.q0(objR);
            }
            j2.b bVar2 = (j2.b) objR;
            boolean zI = sVar.i(bVar2);
            Object objR2 = sVar.R();
            if (zI || objR2 == x0Var) {
                objR2 = new p4(bVar2, (qx1.d) null, 19);
                sVar.q0(objR2);
            }
            md1.g.A(p2Var, (Function2) objR2, sVar, (i2 >> 6) & 14);
            f fVar = t3.c.n;
            t3.p pVarH = uz1.g.H(pVar, p1VarD, 14);
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, fVar, sVar, 48);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarH);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            tlydtdl.compose.animation.b.b(g0.a, ((Boolean) st.w0.r(aVar.a, sVar, 0, 7).getValue()).booleanValue(), null, null, null, null, p.d(289811270, new z0(6, dVar, st.w0.r(aVar.d, sVar, 0, 7)), sVar), sVar, 1572870, 30);
            o(dVar.o, bVar.e, bVar.b, sVar, 0);
            h(dVar.n, dVar.p, dVar.q, dVar.i, bVar.p, bVar.q, sVar, 0);
            n(dVar.a, bVar2, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, dVar.h, dVar.j, dVar.k, dVar.l, dVar.m, bVar.a, bVar.d, bVar.m, bVar.n, sVar, 0);
            sVar = sVar;
            r(dVar.g, bVar.i, sVar, 0);
            e(bVar.c, bVar.f, bVar.g, bVar.h, bVar.j, bVar.o, dVar.r, sVar, 0);
            s1.a.z(t3.m.a, 16, sVar, true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new com.bandlab.uikit.compose.bottomsheet.b(dVar, bVar, p2Var, pVar, i, 2);
        }
    }

    public static final void n(final gs0.a aVar, final j2.b bVar, final int i, final gs0.a aVar2, final gs0.a aVar3, final gs0.a aVar4, final boolean z, final x10.v vVar, final int i2, final int i3, final gs0.c cVar, final gs0.a aVar5, final Function1 function1, final Function0 function0, final Function1 function12, final Function1 function13, tlydtdl.compose.runtime.m mVar, final int i4) {
        tlydtdl.compose.runtime.s sVar;
        lmjxuqdtp.jvm.internal.o.h(aVar, "audioSafeMode");
        lmjxuqdtp.jvm.internal.o.h(bVar, "audioSafeModeRequester");
        lmjxuqdtp.jvm.internal.o.h(aVar2, "displaySoundsShortcut");
        lmjxuqdtp.jvm.internal.o.h(aVar3, "inputMonitor");
        lmjxuqdtp.jvm.internal.o.h(aVar4, "inputQuantization");
        lmjxuqdtp.jvm.internal.o.h(vVar, "latencyDescription");
        lmjxuqdtp.jvm.internal.o.h(cVar, "midiDevices");
        lmjxuqdtp.jvm.internal.o.h(aVar5, "midiOverdub");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(-1586624569);
        int i6 = i4 | (sVar2.i(aVar) ? 4 : 2) | (sVar2.i(bVar) ? 32 : 16) | (sVar2.e(i) ? 256 : 128) | (sVar2.i(aVar2) ? 2048 : 1024) | (sVar2.i(aVar3) ? 16384 : 8192);
        boolean zI = sVar2.i(aVar4);
        char c2 = CharCompanionObject.MIN_VALUE;
        int i7 = i6 | (zI ? 131072 : 65536);
        boolean zH = sVar2.h(z);
        char c3 = CharCompanionObject.MIN_VALUE;
        int i8 = i7 | (zH ? 1048576 : 524288) | (sVar2.g(vVar) ? 8388608 : 4194304) | (sVar2.e(i2) ? 67108864 : 33554432) | (sVar2.e(i3) ? 536870912 : 268435456);
        int i9 = (sVar2.g(cVar) ? (char) 4 : (char) 2) | (sVar2.i(aVar5) ? ' ' : (char) 16) | (sVar2.i(function1) ? (char) 256 : (char) 128) | (sVar2.i(function0) ? (char) 2048 : (char) 1024) | (sVar2.i(function12) ? (char) 16384 : (char) 8192);
        if (sVar2.i(function13)) {
            c2 = 0;
        }
        int i10 = i9 | c2;
        if (sVar2.i(null)) {
            c3 = 0;
        }
        if (sVar2.W(i8 & 1, ((i8 & 306783379) == 306783378 && ((i10 | c3) & 599187) == 599186) ? false : true)) {
            e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            t3.p pVarX = j4.x(sVar2, t3.m.a);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, e0VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX, s4.k.d);
            sVar = sVar2;
            c(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020316), null, null, false, p.d(-76762159, new Function3() { // from class: fs0.w
                /* JADX WARN: Type inference failed for: r4v24, types: [java.lang.Object, ny1.p2] */
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    lmjxuqdtp.jvm.internal.o.h((f0) obj, "$this$Group");
                    tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar2;
                    if (sVar3.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                        sVar3.f0(-1900684719);
                        sVar3.r(false);
                        final gs0.a aVar6 = aVar2;
                        e1 e1VarR = st.w0.r(aVar6.a, sVar3, 0, 7);
                        e1 e1VarR2 = st.w0.r(aVar6.d, sVar3, 0, 7);
                        x10.r rVarV = com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132017971);
                        boolean zBooleanValue = ((Boolean) e1VarR.getValue()).booleanValue();
                        boolean zBooleanValue2 = ((Boolean) e1VarR2.getValue()).booleanValue();
                        boolean zI2 = sVar3.i(aVar6);
                        Object objR = sVar3.R();
                        x0 x0Var = tlydtdl.compose.runtime.l.a;
                        if (zI2 || objR == x0Var) {
                            final int i11 = 2;
                            objR = new Function1() { // from class: fs0.x
                                public final Object invoke(Object obj4) {
                                    int i12 = i11;
                                    ((Boolean) obj4).booleanValue();
                                    switch (i12) {
                                        case 0:
                                            aVar6.a();
                                            break;
                                        case 1:
                                            aVar6.a();
                                            break;
                                        case 2:
                                            aVar6.a();
                                            break;
                                        case 3:
                                            aVar6.a();
                                            break;
                                        default:
                                            aVar6.a();
                                            break;
                                    }
                                    return lx1.b0.a;
                                }
                            };
                            sVar3.q0(objR);
                        }
                        a.p(rVarV, zBooleanValue, null, zBooleanValue2, null, (Function1) objR, sVar3, 0, 20);
                        a.j(sVar3);
                        x10.r rVar = new x10.r(2132017858);
                        List listC = ct1.b.C(new Integer[]{0, 1, 2});
                        Integer numValueOf = Integer.valueOf(i);
                        Object objR2 = sVar3.R();
                        if (objR2 == x0Var) {
                            objR2 = new dr0.i(21);
                            sVar3.q0(objR2);
                        }
                        a.f(rVar, numValueOf, listC, (Function1) objR2, function12, null, false, null, sVar3, 3456, 224);
                        a.j(sVar3);
                        x10.r rVar2 = new x10.r(2132019207);
                        ey1.k kVar = new ey1.k(0, i2, 1);
                        Object objR3 = sVar3.R();
                        if (objR3 == x0Var) {
                            objR3 = new dr0.i(22);
                            sVar3.q0(objR3);
                        }
                        a.l(rVar2, i3, function13, kVar, (Function1) objR3, z, sVar3, 24576);
                        a.j(sVar3);
                        final gs0.a aVar7 = aVar5;
                        e1 e1VarR3 = st.w0.r(aVar7.a, sVar3, 0, 7);
                        e1 e1VarR4 = st.w0.r(aVar7.d, sVar3, 0, 7);
                        x10.r rVar3 = new x10.r(2132019010);
                        x10.r rVar4 = new x10.r(2132019027);
                        boolean zBooleanValue3 = ((Boolean) e1VarR3.getValue()).booleanValue();
                        boolean zBooleanValue4 = ((Boolean) e1VarR4.getValue()).booleanValue();
                        boolean zI3 = sVar3.i(aVar7);
                        Object objR4 = sVar3.R();
                        if (zI3 || objR4 == x0Var) {
                            final int i12 = 3;
                            objR4 = new Function1() { // from class: fs0.x
                                public final Object invoke(Object obj4) {
                                    int i122 = i12;
                                    ((Boolean) obj4).booleanValue();
                                    switch (i122) {
                                        case 0:
                                            aVar7.a();
                                            break;
                                        case 1:
                                            aVar7.a();
                                            break;
                                        case 2:
                                            aVar7.a();
                                            break;
                                        case 3:
                                            aVar7.a();
                                            break;
                                        default:
                                            aVar7.a();
                                            break;
                                    }
                                    return lx1.b0.a;
                                }
                            };
                            sVar3.q0(objR4);
                        }
                        a.p(rVar3, zBooleanValue3, null, zBooleanValue4, rVar4, (Function1) objR4, sVar3, 0, 4);
                        a.j(sVar3);
                        final gs0.a aVar8 = aVar4;
                        e1 e1VarR5 = st.w0.r(aVar8.a, sVar3, 0, 7);
                        e1 e1VarR6 = st.w0.r(aVar8.d, sVar3, 0, 7);
                        x10.r rVar5 = new x10.r(2132019046);
                        x10.r rVar6 = new x10.r(2132019047);
                        boolean zBooleanValue5 = ((Boolean) e1VarR5.getValue()).booleanValue();
                        boolean zBooleanValue6 = ((Boolean) e1VarR6.getValue()).booleanValue();
                        boolean zI4 = sVar3.i(aVar8);
                        Object objR5 = sVar3.R();
                        if (zI4 || objR5 == x0Var) {
                            final int i13 = 4;
                            objR5 = new Function1() { // from class: fs0.x
                                public final Object invoke(Object obj4) {
                                    int i122 = i13;
                                    ((Boolean) obj4).booleanValue();
                                    switch (i122) {
                                        case 0:
                                            aVar8.a();
                                            break;
                                        case 1:
                                            aVar8.a();
                                            break;
                                        case 2:
                                            aVar8.a();
                                            break;
                                        case 3:
                                            aVar8.a();
                                            break;
                                        default:
                                            aVar8.a();
                                            break;
                                    }
                                    return lx1.b0.a;
                                }
                            };
                            sVar3.q0(objR5);
                        }
                        a.p(rVar5, zBooleanValue5, null, zBooleanValue6, rVar6, (Function1) objR5, sVar3, 0, 4);
                        a.j(sVar3);
                        gs0.c cVar2 = cVar;
                        x10.v vVar2 = cVar2.d;
                        x10.v vVar3 = cVar2.c;
                        String str = cVar2.b;
                        List list = cVar2.a;
                        e eVar = cVar2.e;
                        lmjxuqdtp.jvm.internal.o.h(vVar2, "title");
                        lmjxuqdtp.jvm.internal.o.h(list, "allValues");
                        Object objR6 = sVar3.R();
                        if (objR6 == x0Var) {
                            objR6 = new dr0.i(19);
                            sVar3.q0(objR6);
                        }
                        a.f(vVar2, str, list, (Function1) objR6, function1, vVar3, false, eVar, sVar3, 1575936, 0);
                        a.j(sVar3);
                        final gs0.a aVar9 = aVar3;
                        e1 e1VarR7 = st.w0.r((p2) aVar9.c, sVar3, 0, 7);
                        e1 e1VarR8 = st.w0.r(aVar9.a, sVar3, 0, 7);
                        e1 e1VarR9 = st.w0.r(aVar9.d, sVar3, 0, 7);
                        x10.r rVar7 = new x10.r(2132018551);
                        String str2 = (String) e1VarR7.getValue();
                        if (str2 == null) {
                            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                        x10.l lVarD = x10.c.d(str2);
                        boolean zBooleanValue7 = ((Boolean) e1VarR9.getValue()).booleanValue();
                        boolean zBooleanValue8 = ((Boolean) e1VarR8.getValue()).booleanValue();
                        boolean zI5 = sVar3.i(aVar9);
                        Object objR7 = sVar3.R();
                        if (zI5 || objR7 == x0Var) {
                            final int i14 = 0;
                            objR7 = new Function1() { // from class: fs0.x
                                public final Object invoke(Object obj4) {
                                    int i122 = i14;
                                    ((Boolean) obj4).booleanValue();
                                    switch (i122) {
                                        case 0:
                                            aVar9.a();
                                            break;
                                        case 1:
                                            aVar9.a();
                                            break;
                                        case 2:
                                            aVar9.a();
                                            break;
                                        case 3:
                                            aVar9.a();
                                            break;
                                        default:
                                            aVar9.a();
                                            break;
                                    }
                                    return lx1.b0.a;
                                }
                            };
                            sVar3.q0(objR7);
                        }
                        a.p(rVar7, zBooleanValue8, null, zBooleanValue7, lVarD, (Function1) objR7, sVar3, 0, 4);
                        a.j(sVar3);
                        a.g(new x10.r(2132018625), vVar, false, function0, sVar3, 0, 4);
                    } else {
                        sVar3.Z();
                    }
                    return lx1.b0.a;
                }
            }, sVar2), sVar, 24576, 14);
            c(null, new x10.r(2132020401), null, false, p.d(1626468602, new z0(5, aVar, bVar), sVar), sVar, 24576, 13);
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new Function2(aVar, bVar, i, aVar2, aVar3, aVar4, z, vVar, i2, i3, cVar, aVar5, function1, function0, function12, function13, i4) { // from class: fs0.y
                public final /* synthetic */ gs0.a a;
                public final /* synthetic */ j2.b b;
                public final /* synthetic */ int c;
                public final /* synthetic */ gs0.a d;
                public final /* synthetic */ gs0.a e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public final /* synthetic */ gs0.a f132f;
                public final /* synthetic */ boolean g;
                public final /* synthetic */ x10.v h;
                public final /* synthetic */ int i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ int f133j;
                public final /* synthetic */ gs0.c k;
                public final /* synthetic */ gs0.a l;
                public final /* synthetic */ Function1 m;
                public final /* synthetic */ Function0 n;
                public final /* synthetic */ Function1 o;
                public final /* synthetic */ Function1 p;

                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iB = tlydtdl.compose.runtime.a0.B(1);
                    a.n(this.a, this.b, this.c, this.d, this.e, this.f132f, this.g, this.h, this.i, this.f133j, this.k, this.l, this.m, this.n, this.o, this.p, (tlydtdl.compose.runtime.m) obj, iB);
                    return lx1.b0.a;
                }
            };
        }
    }

    public static final void o(boolean z, Function0 function0, Function0 function02, tlydtdl.compose.runtime.m mVar, int i) {
        boolean z2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(469127895);
        int i2 = (sVar.h(z) ? 4 : 2) | i | (sVar.i(function0) ? 32 : 16) | (sVar.i(function02) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            Object[] objArr = new Object[0];
            boolean z3 = (i2 & 896) == 256;
            Object objR = sVar.R();
            if (z3 || objR == tlydtdl.compose.runtime.l.a) {
                objR = new z(0, function02);
                sVar.q0(objR);
            }
            z2 = z;
            tlydtdl.compose.animation.b.d(z2, null, null, null, null, p.d(1957065983, new z0(7, lf1.g.b(objArr, (Function1) objR, (Function1) null, sVar, 0, 10), function0), sVar), sVar, (i2 & 14) | 196608, 30);
            sVar = sVar;
        } else {
            z2 = z;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a0(z2, function0, function02, i);
        }
    }

    public static final void p(x10.r rVar, final boolean z, t3.p pVar, final boolean z2, x10.v vVar, final Function1 function1, tlydtdl.compose.runtime.m mVar, int i, int i2) {
        int i3;
        x10.v vVar2;
        int i4;
        t3.p pVar2;
        x10.v vVar3;
        lmjxuqdtp.jvm.internal.o.h(function1, "onValueChange");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-827743780);
        int i6 = i | (sVar.g(rVar) ? 4 : 2) | (sVar.h(z) ? 32 : 16);
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 = i6 | 384;
        } else {
            i3 = i6 | (sVar.g(pVar) ? 256 : 128);
        }
        int i8 = i3 | (sVar.h(z2) ? 2048 : 1024);
        int i9 = i2 & 16;
        if (i9 != 0) {
            i4 = i8 | 24576;
            vVar2 = vVar;
        } else {
            vVar2 = vVar;
            i4 = i8 | (sVar.g(vVar2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192);
        }
        int i10 = i4 | (sVar.i(function1) ? 131072 : 65536);
        if (sVar.W(i10 & 1, (74899 & i10) != 74898)) {
            t3.p pVar3 = i7 != 0 ? t3.m.a : pVar;
            if (i9 != 0) {
                vVar2 = null;
            }
            x10.v vVar4 = vVar2;
            b(rVar, vVar4, z2, pVar3, null, p.d(449384562, new Function2() { // from class: fs0.o
                public final Object invoke(Object obj, Object obj2) {
                    tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                    if (sVar2.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                        com.facebook.appevents.p.f(z, function1, (t3.p) null, (bf1.k) null, z2, sVar2, 0, 12);
                    } else {
                        sVar2.Z();
                    }
                    return lx1.b0.a;
                }
            }, sVar), sVar, (i10 & 14) | 196608 | ((i10 >> 9) & 112) | ((i10 >> 3) & 896) | ((i10 << 3) & 7168), 16);
            vVar3 = vVar4;
            pVar2 = pVar3;
        } else {
            sVar.Z();
            pVar2 = pVar;
            vVar3 = vVar2;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new j3(rVar, z, pVar2, z2, vVar3, function1, i, i2);
        }
    }

    public static final void q(hg1.x xVar, Function1 function1, e eVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(xVar, "currentValue");
        lmjxuqdtp.jvm.internal.o.h(function1, "onValueChange");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1150947666);
        int i2 = i | (sVar.i(xVar) ? 4 : 2) | (sVar.i(function1) ? 32 : 16) | 384 | (sVar.g(eVar) ? 2048 : 1024);
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            boolean zG = sVar.g(xVar);
            Object objR = sVar.R();
            if (zG || objR == tlydtdl.compose.runtime.l.a) {
                x10.c cVar = x10.v.Companion;
                String str = xVar.a + "/" + xVar.b;
                cVar.getClass();
                objR = x10.c.d(str);
                sVar.q0(objR);
            }
            a(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019205), null, (x10.v) objR, true, eVar, p.d(1057461120, new z0(4, xVar, function1), sVar), sVar, 199728 | ((i2 << 3) & 57344));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new b1(i, 7, xVar, function1, eVar);
        }
    }

    public static final void r(final boolean z, final Function0 function0, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1337706821);
        int i2 = (sVar.h(z) ? 4 : 2) | i | (sVar.i(function0) ? 32 : 16);
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            final int i3 = 0;
            c(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020374), null, null, false, p.d(-1311730053, new Function3() { // from class: fs0.c0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    switch (i3) {
                        case 0:
                            Function0 function02 = (Function0) function0;
                            tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj2;
                            int iIntValue = ((Integer) obj3).intValue();
                            lmjxuqdtp.jvm.internal.o.h((f0) obj, "$this$Group");
                            tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                            if (sVar2.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                                a.g(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132020409), null, z, function02, sVar2, 0, 2);
                            } else {
                                sVar2.Z();
                            }
                            return lx1.b0.a;
                        case 1:
                            ld1.q qVar = (ld1.q) function0;
                            t3.p pVar = (t3.p) obj;
                            ((Integer) obj3).getClass();
                            lmjxuqdtp.jvm.internal.o.h(pVar, "$this$composed");
                            tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                            sVar3.f0(-1508842886);
                            t3.p pVarH = j4.H(pVar, z, md1.g.y(qVar, sVar3, 0), (Float) null);
                            sVar3.r(false);
                            return pVarH;
                        default:
                            tlydtdl.compose.foundation.layout.a0 a0Var = (tlydtdl.compose.foundation.layout.a0) function0;
                            vf1.c cVar = (vf1.c) obj;
                            ((Integer) obj3).intValue();
                            lmjxuqdtp.jvm.internal.o.h(cVar, "$this$withWindowSizeClasses");
                            tlydtdl.compose.runtime.s sVar4 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                            sVar4.f0(1830412979);
                            boolean zC = ch0.b.C(cVar);
                            boolean z2 = z;
                            w90.k kVar = zC ? z2 ? w90.k.f : w90.k.e : (!z2 || cVar.a.compareTo(vf1.b.a) <= 0) ? cVar.b.compareTo(vf1.b.a) > 0 ? Float.compare(((tlydtdl.compose.foundation.layout.b0) a0Var).c(), (float) 750) >= 0 ? w90.k.c : w90.k.b : w90.k.a : w90.k.d;
                            sVar4.r(false);
                            return kVar;
                    }
                }
            }, sVar), sVar, 24576, 14);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new v(z, function0, i, 1);
        }
    }
}
