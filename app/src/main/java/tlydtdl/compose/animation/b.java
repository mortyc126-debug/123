package tlydtdl.compose.animation;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import le1.h;
import lf.y;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.internal.http2.Http2;
import q3.k;
import qx1.d;
import s1.b0;
import s1.h0;
import s1.i0;
import s1.l1;
import s1.n0;
import s1.o0;
import s1.q0;
import s1.t;
import s1.u;
import s1.x;
import s1.x0;
import s1.y0;
import s1.z;
import s4.i;
import s4.j;
import t1.k1;
import t1.l0;
import t1.q1;
import t1.u1;
import t1.x1;
import t3.p;
import tlydtdl.compose.foundation.lazy.layout.r0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.n1;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final void a(q1 q1Var, Function1 function1, p pVar, x0 x0Var, y0 y0Var, Function2 function2, k kVar, m mVar, int i) {
        int i2;
        k kVar2;
        int i3;
        q1 q1Var2;
        x1 x1Var;
        tlydtdl.compose.runtime.x0 x0Var2;
        boolean z;
        k1 k1Var;
        k1 k1Var2;
        k1 k1Var3;
        boolean z2;
        k1 k1Var4;
        k1 k1Var5;
        boolean z3;
        k1 k1Var6;
        k1 k1Var7;
        k1 k1VarB;
        y0 y0Var2;
        x0 x0Var3;
        boolean z4;
        s sVar = (s) mVar;
        sVar.h0(1912839215);
        if ((i & 6) == 0) {
            i2 = (sVar.g(q1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(pVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.g(x0Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar.g(y0Var) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar.i(function2) ? 131072 : 65536;
        }
        int i4 = i2 | 1572864;
        if ((12582912 & i) == 0) {
            i4 |= sVar.i(kVar) ? 8388608 : 4194304;
        }
        if (sVar.W(i4 & 1, (4793491 & i4) != 4793490)) {
            n1 n1Var = q1Var.d;
            r0 r0Var = q1Var.a;
            if (((Boolean) function1.invoke(n1Var.getValue())).booleanValue() || ((Boolean) function1.invoke(r0Var.m())).booleanValue() || q1Var.h() || q1Var.d()) {
                sVar.f0(-232323267);
                int i6 = i4 & 14;
                int i7 = i6 | 48;
                int i8 = i7 & 14;
                boolean z5 = ((i8 ^ 6) > 4 && sVar.g(q1Var)) || (i7 & 6) == 4;
                Object objR = sVar.R();
                boolean z6 = z5;
                tlydtdl.compose.runtime.x0 x0Var4 = l.a;
                if (z6 || objR == x0Var4) {
                    objR = r0Var.m();
                    sVar.q0(objR);
                }
                if (q1Var.h()) {
                    objR = r0Var.m();
                }
                sVar.f0(1844425648);
                h0 h0VarG = g(q1Var, function1, objR, sVar);
                sVar.r(false);
                Object value = q1Var.d.getValue();
                sVar.f0(1844425648);
                h0 h0VarG2 = g(q1Var, function1, value, sVar);
                sVar.r(false);
                int i9 = i8 | 3072;
                sw0.l lVar = u1.a;
                int i10 = (i9 & 14) ^ 6;
                int i11 = i4;
                boolean z7 = (i10 > 4 && sVar.g(q1Var)) || (i9 & 6) == 4;
                Object objR2 = sVar.R();
                if (z7 || objR2 == x0Var4) {
                    i3 = i9;
                    objR2 = new q1(new l0(h0VarG), q1Var, i.p(new StringBuilder(), q1Var.c, " > EnterExitTransition"));
                    sVar.q0(objR2);
                } else {
                    i3 = i9;
                }
                q1 q1Var3 = (q1) objR2;
                boolean zG = ((i10 > 4 && sVar.g(q1Var)) || (i3 & 6) == 4) | sVar.g(q1Var3);
                Object objR3 = sVar.R();
                if (zG || objR3 == x0Var4) {
                    objR3 = new h(24, q1Var, q1Var3);
                    sVar.q0(objR3);
                }
                a0.d(q1Var3, (Function1) objR3, sVar);
                if (q1Var.h()) {
                    q1Var3.l(h0VarG, h0VarG2);
                } else {
                    q1Var3.q(h0VarG2);
                    q1Var3.k.setValue(Boolean.FALSE);
                }
                e1 e1VarX = a0.x(function2, sVar);
                r0 r0Var2 = q1Var3.a;
                r0 r0Var3 = q1Var3.a;
                n1 n1Var2 = q1Var3.d;
                Object objInvoke = function2.invoke(r0Var2.m(), n1Var2.getValue());
                boolean zG2 = sVar.g(q1Var3) | sVar.g(e1VarX);
                Object objR4 = sVar.R();
                if (zG2 || objR4 == x0Var4) {
                    objR4 = new y(q1Var3, e1VarX, (d) null, 7);
                    sVar.q0(objR4);
                }
                e1 e1VarU = a0.u(sVar, objInvoke, (Function2) objR4);
                Object objM = r0Var3.m();
                h0 h0Var = h0.c;
                if (objM == h0Var && n1Var2.getValue() == h0Var && ((Boolean) e1VarU.getValue()).booleanValue()) {
                    sVar.f0(-230155437);
                    sVar.r(false);
                    kVar2 = kVar;
                    z4 = false;
                } else {
                    sVar.f0(-231293261);
                    boolean z8 = i6 == 4;
                    Object objR5 = sVar.R();
                    if (z8 || objR5 == x0Var4) {
                        objR5 = new b0();
                        sVar.q0(objR5);
                    }
                    b0 b0Var = (b0) objR5;
                    x1 x1Var2 = q0.a;
                    x1 x1Var3 = t1.c.o;
                    Object objR6 = sVar.R();
                    if (objR6 == x0Var4) {
                        objR6 = n0.c;
                        sVar.q0(objR6);
                    }
                    Function0 function0 = (Function0) objR6;
                    boolean zG3 = sVar.g(q1Var3);
                    Object objR7 = sVar.R();
                    if (zG3 || objR7 == x0Var4) {
                        objR7 = a0.t(x0Var);
                        sVar.q0(objR7);
                    }
                    e1 e1Var = (e1) objR7;
                    if (r0Var3.m() == n1Var2.getValue() && r0Var3.m() == h0.b) {
                        if (q1Var3.h()) {
                            e1Var.setValue(x0Var);
                        } else {
                            e1Var.setValue(x0.b);
                        }
                    } else if (n1Var2.getValue() == h0.b) {
                        e1Var.setValue(((x0) e1Var.getValue()).a(x0Var));
                    }
                    x0 x0Var5 = (x0) e1Var.getValue();
                    boolean zG4 = sVar.g(q1Var3);
                    Object objR8 = sVar.R();
                    if (zG4 || objR8 == x0Var4) {
                        objR8 = a0.t(y0Var);
                        sVar.q0(objR8);
                    }
                    e1 e1Var2 = (e1) objR8;
                    if (r0Var3.m() == n1Var2.getValue() && r0Var3.m() == h0.b) {
                        if (q1Var3.h()) {
                            e1Var2.setValue(y0Var);
                        } else {
                            e1Var2.setValue(y0.b);
                        }
                    } else if (n1Var2.getValue() != h0.b) {
                        e1Var2.setValue(((y0) e1Var2.getValue()).a(y0Var));
                    }
                    y0 y0Var3 = (y0) e1Var2.getValue();
                    l1 l1Var = x0Var5.a;
                    boolean z9 = (l1Var.b == null && y0Var3.a.b == null) ? false : true;
                    boolean z10 = (l1Var.c == null && y0Var3.a.c == null) ? false : true;
                    if (z9) {
                        sVar.f0(133838277);
                        Object objR9 = sVar.R();
                        if (objR9 == x0Var4) {
                            objR9 = "Built-in slide";
                            sVar.q0("Built-in slide");
                        }
                        String str = (String) objR9;
                        q1Var2 = q1Var3;
                        x0Var2 = x0Var4;
                        z = true;
                        k1 k1VarB2 = u1.b(q1Var2, x1Var3, str, sVar, 384, 0);
                        x1Var = x1Var3;
                        sVar.r(false);
                        k1Var = k1VarB2;
                    } else {
                        q1Var2 = q1Var3;
                        x1Var = x1Var3;
                        x0Var2 = x0Var4;
                        z = true;
                        sVar.f0(133944080);
                        sVar.r(false);
                        k1Var = null;
                    }
                    if (z10) {
                        sVar.f0(134035871);
                        x1 x1Var4 = t1.c.p;
                        Object objR10 = sVar.R();
                        if (objR10 == x0Var2) {
                            objR10 = "Built-in shrink/expand";
                            sVar.q0("Built-in shrink/expand");
                        }
                        k1 k1VarB3 = u1.b(q1Var2, x1Var4, (String) objR10, sVar, 384, 0);
                        sVar.r(false);
                        k1Var2 = k1VarB3;
                    } else {
                        sVar.f0(134146695);
                        sVar.r(false);
                        k1Var2 = null;
                    }
                    if (z10) {
                        sVar.f0(134220321);
                        Object objR11 = sVar.R();
                        if (objR11 == x0Var2) {
                            objR11 = "Built-in InterruptionHandlingOffset";
                            sVar.q0("Built-in InterruptionHandlingOffset");
                        }
                        k1 k1VarB4 = u1.b(q1Var2, x1Var, (String) objR11, sVar, 384, 0);
                        sVar.r(false);
                        k1Var3 = k1VarB4;
                    } else {
                        sVar.f0(134390727);
                        sVar.r(false);
                        k1Var3 = null;
                    }
                    l1 l1Var2 = y0Var3.a;
                    boolean z11 = !z10;
                    x1 x1Var5 = t1.c.i;
                    boolean z12 = (l1Var.a == null && y0Var3.a.a == null) ? false : z;
                    boolean z13 = (l1Var.d == null && y0Var3.a.d == null) ? false : z;
                    if (z12) {
                        sVar.f0(-703859581);
                        Object objR12 = sVar.R();
                        if (objR12 == x0Var2) {
                            objR12 = "Built-in alpha";
                            sVar.q0("Built-in alpha");
                        }
                        z2 = z11;
                        k1 k1VarB5 = u1.b(q1Var2, x1Var5, (String) objR12, sVar, 384, 0);
                        sVar.r(false);
                        k1Var4 = k1VarB5;
                    } else {
                        z2 = z11;
                        sVar.f0(-703690136);
                        sVar.r(false);
                        k1Var4 = null;
                    }
                    if (z13) {
                        sVar.f0(-703622493);
                        Object objR13 = sVar.R();
                        if (objR13 == x0Var2) {
                            objR13 = "Built-in scale";
                            sVar.q0("Built-in scale");
                        }
                        k1Var5 = k1Var4;
                        k1 k1VarB6 = u1.b(q1Var2, x1Var5, (String) objR13, sVar, 384, 0);
                        z3 = false;
                        sVar.r(false);
                        k1Var6 = k1VarB6;
                    } else {
                        k1Var5 = k1Var4;
                        z3 = false;
                        sVar.f0(-703453048);
                        sVar.r(false);
                        k1Var6 = null;
                    }
                    if (z13) {
                        sVar.f0(-703375392);
                        k1Var7 = k1Var6;
                        k1VarB = u1.b(q1Var2, q0.a, "TransformOriginInterruptionHandling", sVar, 384, 0);
                        sVar.r(z3);
                    } else {
                        k1Var7 = k1Var6;
                        sVar.f0(-703203064);
                        sVar.r(z3);
                        k1VarB = null;
                    }
                    boolean zI = sVar.i(k1Var5) | sVar.g(x0Var5) | sVar.g(y0Var3) | sVar.i(k1Var7) | sVar.g(q1Var2) | sVar.i(k1VarB);
                    Object objR14 = sVar.R();
                    if (zI || objR14 == x0Var2) {
                        y0Var2 = y0Var3;
                        x0Var3 = x0Var5;
                        objR14 = new i0(k1Var5, k1Var7, q1Var2, x0Var3, y0Var2, k1VarB);
                        sVar.q0(objR14);
                    } else {
                        y0Var2 = y0Var3;
                        x0Var3 = x0Var5;
                    }
                    i0 i0Var = (i0) objR14;
                    boolean zH = sVar.h(z2) | sVar.g(function0);
                    Object objR15 = sVar.R();
                    if (zH || objR15 == x0Var2) {
                        objR15 = new o0(z2, function0);
                        sVar.q0(objR15);
                    }
                    t3.m mVar2 = t3.m.a;
                    p pVarThen = tlydtdl.compose.ui.graphics.a.a(mVar2, (Function1) objR15).then(new EnterExitTransitionElement(q1Var2, k1Var2, k1Var3, k1Var, x0Var3, y0Var2, function0, i0Var));
                    sVar.f0(-7429769);
                    sVar.r(false);
                    p pVarThen2 = pVar.then(pVarThen.then(mVar2));
                    Object objR16 = sVar.R();
                    if (objR16 == x0Var2) {
                        objR16 = new t(b0Var);
                        sVar.q0(objR16);
                    }
                    t tVar = (t) objR16;
                    int iHashCode = Long.hashCode(sVar.T);
                    tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
                    p pVarX = j4.x(sVar, pVarThen2);
                    s4.l.f436d2.getClass();
                    j jVar = s4.k.b;
                    sVar.j0();
                    if (sVar.S) {
                        sVar.l(jVar);
                    } else {
                        sVar.t0();
                    }
                    a0.y(sVar, tVar, s4.k.f435f);
                    a0.y(sVar, u1VarM, s4.k.e);
                    i iVar = s4.k.g;
                    if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar, iHashCode, iVar);
                    }
                    a0.y(sVar, pVarX, s4.k.d);
                    kVar2 = kVar;
                    kVar2.invoke(b0Var, sVar, Integer.valueOf((i11 >> 18) & 112));
                    sVar.r(z);
                    z4 = false;
                    sVar.r(false);
                }
                sVar.r(z4);
            } else {
                sVar.f0(-230149485);
                sVar.r(false);
                kVar2 = kVar;
            }
        } else {
            kVar2 = kVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new u(q1Var, function1, pVar, x0Var, y0Var, function2, kVar2, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(tlydtdl.compose.foundation.layout.f0 r13, boolean r14, t3.p r15, s1.x0 r16, s1.y0 r17, java.lang.String r18, q3.k r19, tlydtdl.compose.runtime.m r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.animation.b.b(tlydtdl.compose.foundation.layout.f0, boolean, t3.p, s1.x0, s1.y0, java.lang.String, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void c(l0 l0Var, p pVar, x0 x0Var, y0 y0Var, String str, k kVar, m mVar, int i) {
        int i2;
        p pVar2;
        String str2;
        s sVar = (s) mVar;
        sVar.h0(657024243);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? sVar.g(l0Var) : sVar.i(l0Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 48;
        if ((i & 384) == 0) {
            i3 |= sVar.g(x0Var) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.g(y0Var) ? 2048 : 1024;
        }
        int i4 = i3 | 24576;
        if ((196608 & i) == 0) {
            i4 |= sVar.i(kVar) ? 131072 : 65536;
        }
        if (sVar.W(i4 & 1, (74899 & i4) != 74898)) {
            q1 q1VarD = u1.d(l0Var, "AnimatedVisibility", sVar, (i4 & 14) | ((i4 >> 9) & 112), 0);
            Object objR = sVar.R();
            if (objR == l.a) {
                objR = x.d;
                sVar.q0(objR);
            }
            Function1 function1 = (Function1) objR;
            int i6 = i4 << 3;
            p pVar3 = t3.m.a;
            f(q1VarD, function1, pVar3, x0Var, y0Var, kVar, sVar, (i6 & 57344) | (i6 & 896) | 48 | (i6 & 7168) | (i4 & 458752));
            str2 = "AnimatedVisibility";
            pVar2 = pVar3;
        } else {
            sVar.Z();
            pVar2 = pVar;
            str2 = str;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new s1.y(l0Var, pVar2, x0Var, y0Var, str2, kVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(boolean r16, t3.p r17, s1.x0 r18, s1.y0 r19, java.lang.String r20, q3.k r21, tlydtdl.compose.runtime.m r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.animation.b.d(boolean, t3.p, s1.x0, s1.y0, java.lang.String, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(boolean r16, t3.p r17, s1.x0 r18, s1.y0 r19, java.lang.String r20, q3.k r21, tlydtdl.compose.runtime.m r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.animation.b.e(boolean, t3.p, s1.x0, s1.y0, java.lang.String, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void f(q1 q1Var, Function1 function1, p pVar, x0 x0Var, y0 y0Var, k kVar, m mVar, int i) {
        int i2;
        x0 x0Var2;
        y0 y0Var2;
        k kVar2;
        s sVar = (s) mVar;
        sVar.h0(1706321816);
        if ((i & 6) == 0) {
            i2 = (sVar.g(q1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(pVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            x0Var2 = x0Var;
            i2 |= sVar.g(x0Var2) ? 2048 : 1024;
        } else {
            x0Var2 = x0Var;
        }
        if ((i & 24576) == 0) {
            y0Var2 = y0Var;
            i2 |= sVar.g(y0Var2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        } else {
            y0Var2 = y0Var;
        }
        if ((i & 196608) == 0) {
            kVar2 = kVar;
            i2 |= sVar.i(kVar2) ? 131072 : 65536;
        } else {
            kVar2 = kVar;
        }
        if (sVar.W(i2 & 1, (74899 & i2) != 74898)) {
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object objR = sVar.R();
            tlydtdl.compose.runtime.x0 x0Var3 = l.a;
            if (z || objR == x0Var3) {
                objR = new z(function1, q1Var);
                sVar.q0(objR);
            }
            p pVarB = tlydtdl.compose.ui.layout.a.b(pVar, (Function3) objR);
            Object objR2 = sVar.R();
            if (objR2 == x0Var3) {
                objR2 = s1.k.e;
                sVar.q0(objR2);
            }
            a(q1Var, function1, pVarB, x0Var2, y0Var2, (Function2) objR2, kVar2, sVar, 196608 | i4 | i3 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new s1.y(q1Var, function1, pVar, x0Var, y0Var, kVar, i);
        }
    }

    public static final h0 g(q1 q1Var, Function1 function1, Object obj, m mVar) {
        h0 h0Var;
        s sVar = (s) mVar;
        sVar.d0(-422486105, q1Var);
        boolean zH = q1Var.h();
        r0 r0Var = q1Var.a;
        if (zH) {
            sVar.f0(-212146657);
            sVar.r(false);
            h0Var = ((Boolean) function1.invoke(obj)).booleanValue() ? h0.b : ((Boolean) function1.invoke(r0Var.m())).booleanValue() ? h0.c : h0.a;
        } else {
            sVar.f0(-211872524);
            Object objR = sVar.R();
            if (objR == l.a) {
                objR = a0.t(Boolean.FALSE);
                sVar.q0(objR);
            }
            e1 e1Var = (e1) objR;
            if (((Boolean) function1.invoke(r0Var.m())).booleanValue()) {
                e1Var.setValue(Boolean.TRUE);
            }
            h0Var = ((Boolean) function1.invoke(obj)).booleanValue() ? h0.b : ((Boolean) e1Var.getValue()).booleanValue() ? h0.c : h0.a;
            sVar.r(false);
        }
        sVar.r(false);
        return h0Var;
    }
}
