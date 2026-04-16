package ln1;

import a4.a1;
import a4.k0;
import a4.o0;
import a4.p0;
import a4.w;
import a4.w0;
import amuvvoafs.app.Activity;
import amuvvoafs.content.Context;
import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import android.R;
import b02.b0;
import com.amplitude.experiment.evaluation.CycleException;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import cz1.c0;
import ed0.j;
import f3.f2;
import hy1.q;
import hy1.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kg.y;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import md1.n0;
import mr.c4;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.net.telnet.TelnetCommand;
import org.json.JSONObject;
import r6.l0;
import r6.u0;
import s00.t;
import t1.u;
import t4.r0;
import t4.r1;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.compose.foundation.layout.HorizontalAlignElement;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;
import tlydtdl.databinding.DataBinderMapperImpl;
import tlydtdl.lifecycle.g0;
import tlydtdl.lifecycle.z;
import uc0.p;
import x10.r;
import x10.v;
import y11.i1;
import y11.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static final r A(u1 u1Var) throws NoWhenBranchMatchedException {
        int i;
        x10.c cVar = v.Companion;
        switch (u1Var == null ? -1 : j.$EnumSwitchMapping$0[u1Var.ordinal()]) {
            case -1:
                i = 2132019423;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                i = 2132019003;
                break;
            case 2:
                i = 2132018998;
                break;
            case 3:
                i = 2132018997;
                break;
            case 4:
                i = 2132019002;
                break;
            case 5:
                i = 2132018999;
                break;
            case 6:
                i = 2132019001;
                break;
            case 7:
                i = 2132018996;
                break;
            case 8:
                i = 2132019000;
                break;
        }
        return a0.v(cVar, i);
    }

    public static final int B(int i, int i2) {
        return (i >> i2) & 31;
    }

    public static g7.v C(View view, int i, ViewGroup viewGroup, Object obj, int i2) {
        iu0.i iVar = new iu0.i(2, view);
        if ((i2 & 16) != 0) {
            obj = null;
        }
        o.h(view, "<this>");
        g7.v vVarC = g7.g.c(LayoutInflater.from(view.getContext()), i, viewGroup, true);
        if (vVarC == null) {
            throw new IllegalArgumentException(("Cannot inflate layout " + i + " for View " + view + ". Probably this layout doesn't have bindings").toString());
        }
        if (obj != null) {
            int i3 = c4.a;
            vVarC.y(4, obj);
        }
        if (view.isAttachedToWindow()) {
            vVarC.w((g0) iVar.invoke());
            return vVarC;
        }
        view.addOnAttachStateChangeListener(new gg1.e(view, vVarC, iVar, 1));
        return vVarC;
    }

    public static g7.v D(xi.b bVar, LayoutInflater layoutInflater, int i, ViewGroup viewGroup, Object obj, int i2) {
        if ((i2 & 4) != 0) {
            viewGroup = null;
        }
        if ((i2 & 16) != 0) {
            obj = null;
        }
        g7.v vVarC = g7.g.c(layoutInflater, i, viewGroup, false);
        if (vVarC == null) {
            throw new IllegalArgumentException(("Cannot inflate layout " + i + " for Fragment " + bVar + ". Probably this layout doesn't have bindings").toString());
        }
        if (obj != null) {
            int i3 = c4.a;
            vVarC.y(4, obj);
        }
        z lifecycle = bVar.getLifecycle();
        o.g(lifecycle, "<get-lifecycle>(...)");
        hs1.d.t(lifecycle, new t(new gm1.b(10, bVar, vVarC), lifecycle));
        N(vVarC, 655);
        return vVarC;
    }

    public static final boolean E() {
        String str = Build.FINGERPRINT;
        o.g(str, "FINGERPRINT");
        if (x.u0(str, "generic", false) || x.u0(str, "unknown", false)) {
            return true;
        }
        String str2 = Build.MODEL;
        o.g(str2, "MODEL");
        if (q.x0(str2, "google_sdk", false) || q.x0(str2, "Emulator", false) || q.x0(str2, "Android SDK built for x86", false)) {
            return true;
        }
        String str3 = Build.MANUFACTURER;
        o.g(str3, "MANUFACTURER");
        if (q.x0(str3, "Genymotion", false)) {
            return true;
        }
        String str4 = Build.BRAND;
        o.g(str4, "BRAND");
        if (x.u0(str4, "generic", false)) {
            String str5 = Build.DEVICE;
            o.g(str5, "DEVICE");
            if (x.u0(str5, "generic", false)) {
                return true;
            }
        }
        return "google_sdk".equals(Build.PRODUCT);
    }

    public static boolean F(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static final boolean G(xf1.a aVar, m mVar) {
        o.h(aVar, "<this>");
        boolean z = (((Configuration) ((s) mVar).k(r0.a)).uiMode & 48) == 32;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1) {
            return true;
        }
        if (iOrdinal == 2) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean H(i1 i1Var) {
        o.h(i1Var, "<this>");
        return (i1Var.b() == null && i1Var.i() == null) ? false : true;
    }

    public static final long I(float f2, long j2, long j3) {
        float fI = ve.g.I(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j3 >> 32)), f2);
        float fI2 = ve.g.I(Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j3 & 4294967295L)), f2);
        return (((long) Float.floatToRawIntBits(fI)) << 32) | (((long) Float.floatToRawIntBits(fI2)) & 4294967295L);
    }

    public static final List J(String str, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet) throws CycleException {
        y yVar = (y) linkedHashMap.get(str);
        if (yVar == null) {
            return null;
        }
        Set<String> set = yVar.d;
        String str2 = yVar.a;
        Set set2 = set;
        if (set2 == null || set2.isEmpty()) {
            linkedHashMap.remove(str2);
            return ct1.b.B(yVar);
        }
        linkedHashSet.add(str2);
        ArrayList arrayList = new ArrayList();
        for (String str3 : set) {
            if (linkedHashSet.contains(str3)) {
                throw new CycleException(linkedHashSet);
            }
            List listJ = J(str3, linkedHashMap, linkedHashSet);
            if (listJ != null) {
                arrayList.addAll(listJ);
            }
        }
        arrayList.add(yVar);
        linkedHashSet.remove(str2);
        linkedHashMap.remove(str2);
        return arrayList;
    }

    public static final xb0.b K(long j2) {
        return new xb0.b(j2, di0.z.V(xb0.c.b));
    }

    public static final long L(long j2) {
        int iRound = Math.round(Float.intBitsToFloat((int) (j2 >> 32)));
        return (((long) Math.round(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (((long) iRound) << 32);
    }

    public static g7.v M(ComponentActivity componentActivity, int i, Object obj, int i2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        DataBinderMapperImpl dataBinderMapperImpl = g7.g.a;
        componentActivity.setContentView(i);
        g7.v vVarB = g7.g.b(componentActivity.getWindow().getDecorView().findViewById(R.id.content), 0, i);
        if (vVarB != null) {
            if (obj != null) {
                int i3 = c4.a;
                vVarB.y(4, obj);
            }
            vVarB.w(componentActivity);
            N(vVarB, 655);
            return vVarB;
        }
        throw new IllegalArgumentException(("Cannot set layout " + i + " and bind it for Activity " + componentActivity + ". Probably this layout doesn't have bindings").toString());
    }

    public static final void N(g7.v vVar, int i) {
        View view = vVar.e;
        j10.a aVar = new j10.a(i, 0);
        WeakHashMap weakHashMap = u0.a;
        l0.n(view, aVar);
    }

    public static final u O(p5.c cVar) {
        return new u(new rs1.d(cVar));
    }

    public static final long P(long j2) {
        return (((long) Float.floatToRawIntBits((int) (j2 & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32);
    }

    public static String Q(long j2) {
        return f2.h(j2, "Samples(v=", ")");
    }

    public static final ArrayList R(HashMap map, Set set) throws CycleException {
        o.h(set, "flagKeys");
        LinkedHashMap linkedHashMapF0 = mx1.z.f0(map);
        ArrayList arrayList = new ArrayList();
        Set setR1 = set;
        if (setR1.isEmpty()) {
            setR1 = mx1.o.r1(linkedHashMapF0.keySet());
        }
        Iterator it = setR1.iterator();
        while (it.hasNext()) {
            List listJ = J((String) it.next(), linkedHashMapF0, new LinkedHashSet());
            if (listJ != null) {
                arrayList.addAll(listJ);
            }
        }
        return arrayList;
    }

    public static final double S(long j2) {
        return ((j2 >>> 11) * ((double) 2048)) + (j2 & 2047);
    }

    public static final String T(int i, long j2) {
        if (j2 >= 0) {
            p.n(i);
            String string = Long.toString(j2, i);
            o.g(string, "toString(...)");
            return string;
        }
        long j3 = i;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        p.n(i);
        String string2 = Long.toString(j4, i);
        o.g(string2, "toString(...)");
        p.n(i);
        String string3 = Long.toString(j5, i);
        o.g(string3, "toString(...)");
        return string2.concat(string3);
    }

    public static final long a(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0086 A[PHI: r12
  0x0086: PHI (r12v18 int) = (r12v0 int), (r12v6 int), (r12v7 int) binds: [B:142:0x0084, B:152:0x009e, B:151:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(x10.r r27, x10.v r28, lmjxuqdtp.jvm.functions.Function0 r29, t3.p r30, boolean r31, nx0.c r32, tlydtdl.compose.runtime.m r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ln1.e.b(x10.r, x10.v, lmjxuqdtp.jvm.functions.Function0, t3.p, boolean, nx0.c, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void c(boolean z, float f2, float f3, float f4, float f5, float f7, Function1 function1, Function1 function12, q3.k kVar, t3.p pVar, Function1 function13, m mVar, int i) {
        int i2;
        float f8;
        float f9;
        float f10;
        float f12;
        q3.k kVar2;
        t3.p pVar2;
        s sVar;
        Function1 function14;
        o.h(function1, "dragOffset");
        o.h(function12, "onSnapCompleted");
        s sVar2 = (s) mVar;
        sVar2.h0(1018484122);
        if ((i & 6) == 0) {
            i2 = (sVar2.h(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            f8 = f2;
            i2 |= sVar2.d(f8) ? 32 : 16;
        } else {
            f8 = f2;
        }
        if ((i & 384) == 0) {
            i2 |= sVar2.d(f3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            f9 = f4;
            i2 |= sVar2.d(f9) ? 2048 : 1024;
        } else {
            f9 = f4;
        }
        if ((i & 24576) == 0) {
            f10 = f5;
            i2 |= sVar2.d(f10) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        } else {
            f10 = f5;
        }
        if ((196608 & i) == 0) {
            f12 = f7;
            i2 |= sVar2.d(f12) ? 131072 : 65536;
        } else {
            f12 = f7;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar2.i(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= sVar2.i(function12) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            kVar2 = kVar;
            i2 |= sVar2.i(kVar2) ? 67108864 : 33554432;
        } else {
            kVar2 = kVar;
        }
        if ((805306368 & i) == 0) {
            pVar2 = pVar;
            i2 |= sVar2.g(pVar2) ? 536870912 : 268435456;
        } else {
            pVar2 = pVar;
        }
        if (sVar2.W(i2 & 1, (306783379 & i2) != 306783378)) {
            Object objR = sVar2.R();
            if (objR == l.a) {
                objR = new sw0.l(24);
                sVar2.q0(objR);
            }
            Function1 function15 = (Function1) objR;
            float f13 = f12;
            q3.k kVarD = q3.p.d(-1586027536, new tn0.f(f8, z, function15, f3, f9, f10, f13, function1, function12, pVar2, kVar2), sVar2);
            sVar = sVar2;
            tlydtdl.compose.foundation.layout.m.a(null, null, false, kVarD, sVar, 3072, 7);
            function14 = function15;
        } else {
            sVar = sVar2;
            sVar.Z();
            function14 = function13;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new tn0.g(z, f2, f3, f4, f5, f7, function1, function12, kVar, pVar, function14, i);
        }
    }

    public static final long d(float f2, float f3) {
        return (((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32);
    }

    public static final void e(List list, Function1 function1, boolean z, m mVar, int i) throws NoWhenBranchMatchedException {
        int i2;
        o.h(list, "socialAuthProviders");
        o.h(function1, "onSocialConnect");
        s sVar = (s) mVar;
        sVar.h0(-1956603680);
        if ((i & 48) == 0) {
            i2 = (sVar.g(list) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.h(z) ? 2048 : 1024;
        }
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(t3.c.n);
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.g(16), t3.c.j, sVar, 6);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, horizontalAlignElement);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            Iterator itO = s1.a.o(sVar, pVarX, s4.k.d, -331479979, list);
            while (itO.hasNext()) {
                wp.u uVar = (wp.u) itO.next();
                boolean zE = ((i2 & 896) == 256) | sVar.e(uVar.ordinal());
                Object objR = sVar.R();
                if (zE || objR == l.a) {
                    objR = new t1.d(18, function1, uVar);
                    sVar.q0(objR);
                }
                Function0 function0 = (Function0) objR;
                int iOrdinal = uVar.ordinal();
                if (iOrdinal == 0) {
                    lg.e.o(o6.c.g(sVar, 1982693675, 2131231477, false), z, function0, sVar, ((i2 >> 3) & 896) | 6);
                    sVar.r(false);
                } else if (iOrdinal == 1) {
                    lg.e.o(o6.c.g(sVar, 1982913155, 2131231480, true), z, function0, sVar, ((i2 >> 3) & 896) | 6);
                    sVar.r(false);
                } else {
                    if (iOrdinal != 2) {
                        throw a0.q(sVar, -1460064430, false);
                    }
                    lg.e.o(o6.c.g(sVar, 1983142214, 2131231763, false), z, function0, sVar, ((i2 >> 3) & 896) | 6);
                    sVar.r(false);
                }
            }
            sVar.r(false);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new m2.g0(list, function1, z, i, 4);
        }
    }

    public static final void f(r rVar, ld1.r rVar2, m mVar, int i) {
        int i2;
        s sVar = (s) mVar;
        sVar.h0(861042584);
        if ((i & 6) == 0) {
            i2 = (sVar.g(rVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(rVar2) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.g(8), t3.c.k, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            t3.m mVar2 = t3.m.a;
            t3.p pVarX = j4.x(sVar, mVar2);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            dg1.g gVarG = i.g(sVar, pVarX, s4.k.d, 2131231720, false);
            a4.q qVar = new a4.q(i.e(2131100962, 0, sVar, ld1.r.Companion), 5);
            t3.p pVarP = o2.p(mVar2, 20);
            float fU0 = ((p5.c) sVar.k(r1.h)).u0();
            fe1.f.a(gVarG, (String) null, (a1) null, cq1.d.E(pVarP, fU0, fU0), (t3.d) null, (q4.m) null, 0.0f, qVar, (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar, 432, 0, 65392);
            sVar = sVar;
            z10.d.h(rVar, rVar2, of1.q.c(), (t3.p) null, false, (of1.e) null, 0, (Function1) null, sVar, i2 & WebSocketProtocol.PAYLOAD_SHORT, TelnetCommand.EL);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(rVar, rVar2, i, 9);
        }
    }

    public static final Object[] g(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        mx1.n.U(0, i, 6, objArr, objArr2);
        mx1.n.Q(i + 2, i, objArr.length, objArr, objArr2);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    public static final Object[] h(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 2];
        mx1.n.U(0, i, 6, objArr, objArr2);
        mx1.n.Q(i, i + 2, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final Object[] i(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 1];
        mx1.n.U(0, i, 6, objArr, objArr2);
        mx1.n.Q(i, i + 1, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final void j(zy1.e eVar) {
        o.h(eVar, "<this>");
        if ((eVar instanceof c0 ? (c0) eVar : null) != null) {
            return;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + d0.a(eVar.getClass()));
    }

    public static void k(String str, String str2, Bundle bundle, com.facebook.appevents.r rVar) {
        o.h(str, "key");
        o.h(str2, "value");
        int iK = z.p.k(w(str));
        if (iK == 0) {
            bundle.putCharSequence(str, str2);
            return;
        }
        com.facebook.appevents.s sVar = com.facebook.appevents.s.a;
        if (iK == 1) {
            rVar.a(sVar, str, str2);
        } else {
            if (iK != 2) {
                return;
            }
            rVar.a(sVar, str, str2);
            bundle.putCharSequence(str, str2);
        }
    }

    public static lx1.l l(String str, String str2, Bundle bundle, com.facebook.appevents.r rVar) {
        int iK = z.p.k(w(str));
        if (iK != 0) {
            com.facebook.appevents.s sVar = com.facebook.appevents.s.a;
            if (iK == 1) {
                if (rVar == null) {
                    rVar = new com.facebook.appevents.r();
                }
                rVar.a(sVar, str, str2);
            } else if (iK == 2) {
                if (rVar == null) {
                    rVar = new com.facebook.appevents.r();
                }
                if (bundle == null) {
                    bundle = new Bundle();
                }
                rVar.a(sVar, str, str2);
                bundle.putCharSequence(str, str2);
            }
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putCharSequence(str, str2);
        }
        return new lx1.l(bundle, rVar);
    }

    public static final bz1.k m(zy1.d dVar) {
        o.h(dVar, "<this>");
        bz1.k kVar = dVar instanceof bz1.k ? (bz1.k) dVar : null;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + d0.a(dVar.getClass()));
    }

    public static void n(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("k");
                String strOptString2 = jSONObjectOptJSONObject.optString("v");
                o.g(strOptString, "k");
                if (strOptString.length() != 0) {
                    CopyOnWriteArraySet copyOnWriteArraySetA = an1.d.a();
                    o.g(next, "key");
                    List listY0 = q.Y0(strOptString, new String[]{","}, 0, 6);
                    o.g(strOptString2, "v");
                    copyOnWriteArraySetA.add(new an1.d(next, strOptString2, listY0));
                }
            }
        }
    }

    public static yt.a o(iw1.b bVar) {
        o.h(bVar, "context");
        return new yt.a(bVar, 22);
    }

    public static final void p(b02.o oVar, b0 b0Var) throws IOException {
        try {
            IOException iOException = null;
            for (b0 b0Var2 : oVar.F(b0Var)) {
                try {
                    if (oVar.K(b0Var2).c) {
                        p(oVar, b0Var2);
                    }
                    oVar.g(b0Var2);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void q(c4.d dVar, d4.c cVar) throws NoWhenBranchMatchedException {
        boolean z;
        boolean z2;
        Canvas canvas;
        boolean z3;
        float f2;
        w wVarJ = dVar.x0().j();
        d4.c cVar2 = (d4.c) dVar.x0().b;
        d4.e eVar = cVar.a;
        if (cVar.s) {
            return;
        }
        cVar.a();
        if (!eVar.i()) {
            try {
                cVar.a.D(cVar.b, cVar.c, cVar, cVar.e);
            } catch (Throwable unused) {
            }
        }
        boolean z4 = eVar.L() > 0.0f;
        if (z4) {
            wVarJ.l();
        }
        Canvas canvasA = a4.d.a(wVarJ);
        boolean zIsHardwareAccelerated = canvasA.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            long j2 = cVar.t;
            float f3 = (int) (j2 >> 32);
            float f4 = (int) (j2 & 4294967295L);
            long j3 = cVar.u;
            float f5 = ((int) (j3 >> 32)) + f3;
            float f7 = ((int) (j3 & 4294967295L)) + f4;
            float fA = eVar.a();
            a4.z zVarG = eVar.g();
            int iX = eVar.x();
            if (fA < 1.0f || iX != 3 || zVarG != null || eVar.f() == 1) {
                a4.i iVarG = cVar.p;
                if (iVarG == null) {
                    iVarG = w0.g();
                    cVar.p = iVarG;
                }
                iVarG.c(fA);
                iVarG.d(iX);
                iVarG.f(zVarG);
                canvasA = canvasA;
                f2 = f3;
                canvasA.saveLayer(f2, f4, f5, f7, iVarG.a);
            } else {
                canvasA.save();
                canvasA = canvasA;
                f2 = f3;
            }
            canvasA.translate(f2, f4);
            canvasA.concat(eVar.u());
        }
        boolean z5 = !zIsHardwareAccelerated && cVar.w;
        if (z5) {
            wVarJ.o();
            o0 o0VarD = cVar.d();
            if (o0VarD instanceof o0) {
                w.s(wVarJ, o0VarD.a);
            } else if (o0VarD instanceof p0) {
                a4.k kVarA = cVar.m;
                if (kVarA != null) {
                    kVarA.a.rewind();
                } else {
                    kVarA = a4.o.a();
                    cVar.m = kVarA;
                }
                a4.k.b(kVarA, ((p0) o0VarD).a);
                wVarJ.e(kVarA, 1);
            } else {
                if (!(o0VarD instanceof a4.n0)) {
                    throw new NoWhenBranchMatchedException();
                }
                wVarJ.e(((a4.n0) o0VarD).a, 1);
            }
        }
        if (cVar2 != null) {
            d4.a aVar = cVar2.r;
            if (!aVar.a) {
                k0.a("Only add dependencies during a tracking");
            }
            q1.o0 o0Var = (q1.o0) aVar.d;
            if (o0Var != null) {
                o0Var.a(cVar);
            } else if (((d4.c) aVar.b) != null) {
                q1.o0 o0Var2 = q1.w0.a;
                q1.o0 o0Var3 = new q1.o0();
                d4.c cVar3 = (d4.c) aVar.b;
                o.e(cVar3);
                o0Var3.a(cVar3);
                o0Var3.a(cVar);
                aVar.d = o0Var3;
                aVar.b = null;
            } else {
                aVar.b = cVar;
            }
            q1.o0 o0Var4 = (q1.o0) aVar.e;
            if (o0Var4 != null) {
                z3 = !o0Var4.l(cVar);
            } else if (((d4.c) aVar.c) != cVar) {
                z3 = true;
            } else {
                aVar.c = null;
                z3 = false;
            }
            if (z3) {
                cVar.q++;
            }
        }
        if (a4.d.a(wVarJ).isHardwareAccelerated()) {
            z = z4;
            z2 = z5;
            canvas = canvasA;
            eVar.s(wVarJ);
        } else {
            c4.b bVar = cVar.o;
            if (bVar == null) {
                bVar = new c4.b();
                cVar.o = bVar;
            }
            tlydtdl.compose.foundation.lazy.layout.r1 r1Var = bVar.b;
            p5.c cVar4 = cVar.b;
            p5.n nVar = cVar.c;
            long jP = P(cVar.u);
            c4.a aVar2 = ((c4.b) r1Var.d).a;
            p5.c cVar5 = aVar2.a;
            p5.n nVar2 = aVar2.b;
            w wVarJ2 = r1Var.j();
            z2 = z5;
            canvas = canvasA;
            long jO = r1Var.o();
            z = z4;
            d4.c cVar6 = (d4.c) r1Var.b;
            r1Var.v(cVar4);
            r1Var.x(nVar);
            r1Var.u(wVarJ);
            r1Var.y(jP);
            r1Var.b = cVar;
            wVarJ.o();
            try {
                cVar.c(bVar);
            } finally {
                wVarJ.k();
                r1Var.v(cVar5);
                r1Var.x(nVar2);
                r1Var.u(wVarJ2);
                r1Var.y(jO);
                r1Var.b = cVar6;
            }
        }
        if (z2) {
            wVarJ.k();
        }
        if (z) {
            wVarJ.p();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvas.restore();
    }

    public static ColorStateList r(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListB = f6.a.b(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListB;
    }

    public static ColorStateList s(Context context, jx0.h hVar, int i) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = (TypedArray) hVar.c;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListB = f6.a.b(context, resourceId)) == null) ? hVar.k(i) : colorStateListB;
    }

    public static Drawable t(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableR;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableR = qg.a.r(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableR;
    }

    public static final dg1.g u(u1 u1Var) throws NoWhenBranchMatchedException {
        switch (u1Var == null ? -1 : j.$EnumSwitchMapping$0[u1Var.ordinal()]) {
            case -1:
                return new dg1.g(2131231719, false);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return new dg1.g(2131231664, false);
            case 2:
                return new dg1.g(2131231659, false);
            case 3:
                return new dg1.g(2131231658, false);
            case 4:
                return new dg1.g(2131231663, false);
            case 5:
                return new dg1.g(2131231660, false);
            case 6:
                return new dg1.g(2131231662, false);
            case 7:
                return new dg1.g(2131231657, false);
            case 8:
                return new dg1.g(2131231661, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object v(java.lang.String r3, amuvvoafs.os.Bundle r4, com.facebook.appevents.r r5) {
        /*
            java.lang.String r0 = "key"
            lmjxuqdtp.jvm.internal.o.h(r3, r0)
            r0 = 0
            if (r5 == 0) goto L20
            java.util.LinkedHashMap r5 = r5.a
            com.facebook.appevents.s r1 = com.facebook.appevents.s.a
            boolean r2 = r5.containsKey(r1)
            if (r2 != 0) goto L13
            goto L20
        L13:
            java.lang.Object r5 = r5.get(r1)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L20
            java.lang.Object r5 = r5.get(r3)
            goto L21
        L20:
            r5 = r0
        L21:
            if (r4 == 0) goto L27
            java.lang.CharSequence r0 = r4.getCharSequence(r3)
        L27:
            if (r5 != 0) goto L2a
            return r0
        L2a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ln1.e.v(java.lang.String, amuvvoafs.os.Bundle, com.facebook.appevents.r):java.lang.Object");
    }

    public static int w(String str) {
        o.h(str, "parameter");
        Map map = com.facebook.appevents.r.b;
        com.facebook.appevents.s sVar = com.facebook.appevents.s.a;
        lx1.l lVar = (lx1.l) map.get(sVar);
        Set set = lVar != null ? (Set) lVar.a : null;
        lx1.l lVar2 = (lx1.l) map.get(sVar);
        Set set2 = lVar2 != null ? (Set) lVar2.b : null;
        if (set == null || !set.contains(str)) {
            return (set2 == null || !set2.contains(str)) ? 1 : 3;
        }
        return 2;
    }

    public static final ld1.q x(u1 u1Var) throws NoWhenBranchMatchedException {
        ld1.d dVar;
        int i;
        switch (u1Var == null ? -1 : j.$EnumSwitchMapping$0[u1Var.ordinal()]) {
            case -1:
                dVar = ld1.r.Companion;
                i = com.google.android.material.R.dimen.m3_comp_fab_primary_large_icon_size;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                dVar = ld1.r.Companion;
                i = 2131100952;
                break;
            case 2:
                dVar = ld1.r.Companion;
                i = 2131100957;
                break;
            case 3:
                dVar = ld1.r.Companion;
                i = 2131100927;
                break;
            case 4:
                dVar = ld1.r.Companion;
                i = 2131100942;
                break;
            case 5:
                dVar = ld1.r.Companion;
                i = 2131100937;
                break;
            case 6:
                dVar = ld1.r.Companion;
                i = 2131100932;
                break;
            case 7:
                dVar = ld1.r.Companion;
                i = 2131100962;
                break;
            case 8:
                dVar = ld1.r.Companion;
                i = 2131100947;
                break;
        }
        return i.u(dVar, i);
    }

    public static final int y(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i6 = i % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                int i7 = (i4 - i6) % i3;
                if (i7 < 0) {
                    i7 += i3;
                }
                return i2 - i7;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i2) {
                int i8 = -i3;
                int i9 = i % i8;
                if (i9 < 0) {
                    i9 += i8;
                }
                int i10 = i2 % i8;
                if (i10 < 0) {
                    i10 += i8;
                }
                int i11 = (i9 - i10) % i8;
                if (i11 < 0) {
                    i11 += i8;
                }
                return i11 + i2;
            }
        }
        return i2;
    }

    public static final View z(Activity activity) {
        if (vn1.a.b(e.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            vn1.a.a(e.class, th);
            return null;
        }
    }
}
