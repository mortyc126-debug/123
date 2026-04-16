package tlydtdl.datastore.preferences.protobuf;

import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import amuvvoafs.webkit.WebView;
import com.bandlab.restutils.model.ApiHttpException;
import com.bandlab.uikit.compose.bottomsheet.k0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import dionskkgzp.HttpException;
import j3.m0;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import ky1.e1;
import ky1.g1;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.net.nntp.NNTPReply;
import qs1.e;
import qx1.d;
import t4.r1;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.n2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import xwfkdfdvbiz.coroutines.DispatchException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {
    public static e b;
    public final /* synthetic */ int a;

    public /* synthetic */ j1(int i) {
        this.a = i;
    }

    public static final void A(m0 m0Var, int i, Object obj) {
        m0Var.f[(m0Var.g - m0Var.b[m0Var.c - 1].b) + i] = obj;
    }

    public static final void B(m0 m0Var, int i, Object obj, int i2, Object obj2) {
        int i3 = m0Var.g - m0Var.b[m0Var.c - 1].b;
        Object[] objArr = m0Var.f;
        objArr[i + i3] = obj;
        objArr[i3 + i2] = obj2;
    }

    public static final void C(m0 m0Var, Object obj, Object obj2, Object obj3) {
        int i = m0Var.g - m0Var.b[m0Var.c - 1].b;
        Object[] objArr = m0Var.f;
        objArr[i] = obj;
        objArr[i + 1] = obj2;
        objArr[i + 2] = obj3;
    }

    public static final void D(d dVar, ky1.a aVar) throws Throwable {
        try {
            py1.b.g(lx1.b0.a, di0.z.C(dVar));
        } catch (Throwable th) {
            th = th;
            if (th instanceof DispatchException) {
                th = ((DispatchException) th).a;
            }
            aVar.resumeWith(lg.e.u(th));
            throw th;
        }
    }

    public static final m10.q E(m10.f fVar) {
        lmjxuqdtp.jvm.internal.o.h(fVar, "<this>");
        return new m10.q(fVar.a, fVar.b, fVar.c, (String) null, fVar.e, fVar.f, fVar.h, fVar.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:208:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static m10.a1 F(y11.l1 r46, java.lang.String r47, java.lang.String r48, boolean r49, java.lang.Boolean r50, java.lang.Integer r51, n10.f r52, n10.a0 r53, java.lang.Boolean r54, boolean r55, int r56) {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.datastore.preferences.protobuf.j1.F(y11.l1, java.lang.String, java.lang.String, boolean, java.lang.Boolean, java.lang.Integer, n10.f, n10.a0, java.lang.Boolean, boolean, int):m10.a1");
    }

    public static final u00.a G(List list) {
        lmjxuqdtp.jvm.internal.o.h(list, "<this>");
        return new u00.a(list);
    }

    public static final void a(int i, int i2, tlydtdl.compose.runtime.m mVar, Function0 function0, boolean z) {
        int i3;
        lmjxuqdtp.jvm.internal.o.h(function0, "onBack");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-20890198);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (sVar.h(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.i(function0) ? 32 : 16;
        }
        if (sVar.W(i3 & 1, (i3 & 19) != 18)) {
            if (i4 != 0) {
                z = true;
            }
            j4.a(z, function0, sVar, i3 & WebSocketProtocol.PAYLOAD_SHORT);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new pd1.a(z, function0, i, i2);
        }
    }

    public static final void b(pd1.c cVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(cVar, "backHandler");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1307598058);
        if ((i & 6) == 0) {
            i2 = (sVar.g(cVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            a(0, 0, sVar, cVar.b, ((Boolean) st.w0.r(cVar.a, sVar, 0, 7).getValue()).booleanValue());
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new pd1.b(cVar, i, 0);
        }
    }

    public static final void c(int i, tlydtdl.compose.runtime.m mVar, Function1 function1, t3.p pVar) {
        int i2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-932836462);
        if ((i & 6) == 0) {
            i2 = (sVar.g(pVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(function1) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            tlydtdl.compose.foundation.layout.m.i(sVar, tlydtdl.compose.ui.draw.a.a(pVar, function1));
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(pVar, function1, i, 16);
        }
    }

    public static final void d(gf1.b bVar, t3.p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "state");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(790112314);
        int i2 = (sVar.g(bVar) ? 4 : 2) | i | 48;
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            Long l = (Long) st.w0.r(bVar.a, sVar, 0, 7).getValue();
            dg1.g gVar = new dg1.g(2131231408, false);
            ld1.q qVarU = i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation);
            t3.p pVar2 = t3.m.a;
            bn1.c.e(l, gVar, qVarU, pVar2, sVar, 3072);
            pVar = pVar2;
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new gf1.a(bVar, pVar, i, 1);
        }
    }

    public static final void e(List list, xs0.b bVar, boolean z, c60.h hVar, kd1.g gVar, Function0 function0, Function0 function02, Function0 function03, Function1 function1, t3.p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar;
        boolean z2;
        lmjxuqdtp.jvm.internal.o.h(list, "tabs");
        lmjxuqdtp.jvm.internal.o.h(bVar, "selectedTab");
        lmjxuqdtp.jvm.internal.o.h(gVar, "lyricsTranscriberTooltip");
        lmjxuqdtp.jvm.internal.o.h(function0, "onExit");
        lmjxuqdtp.jvm.internal.o.h(function02, "onSave");
        lmjxuqdtp.jvm.internal.o.h(function03, "onQuickSave");
        lmjxuqdtp.jvm.internal.o.h(function1, "onTabSelected");
        lmjxuqdtp.jvm.internal.o.h(pVar, "modifier");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(-1373007926);
        if ((i & 6) == 0) {
            i2 = (sVar2.g(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar2.e(bVar.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar2.h(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar2.g(hVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar2.g(gVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= sVar2.i(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= sVar2.i(function02) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= sVar2.i(function03) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= sVar2.i(function1) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= sVar2.g(pVar) ? 536870912 : 268435456;
        }
        int i3 = i2;
        if (sVar2.W(i3 & 1, (i3 & 306783379) != 306783378)) {
            t3.g gVar2 = t3.c.k;
            t3.p pVarA = tlydtdl.compose.ui.platform.a.a(md1.g.V(uz1.g.x(o2.e(pVar, 1.0f), uz1.g.D(sVar2), 14)), "me-toolbar");
            l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.a, gVar2, sVar2, 48);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            t3.p pVarX = j4.x(sVar2, pVarA);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX, s4.k.d);
            dg1.g gVar3 = new dg1.g(2131231475, false);
            ld1.d dVar = ld1.r.Companion;
            a4.q qVarN = bh.j.n(R.dimen.m3_comp_fab_primary_large_icon_size, 6, sVar2, dVar);
            q4.k kVar = q4.l.f;
            String strN = x10.a.N(sVar2, 2132018289);
            float f2 = 56;
            float f3 = 50;
            t3.p pVar2 = t3.m.a;
            fe1.f.a(gVar3, strN, (a4.a1) null, md1.g.v(o2.r(pVar2, f2, f3), (md1.n0) null, (a5.h) null, true, false, (Function0) null, (Function0) null, function0, 59), (t3.d) null, kVar, 0.0f, qVarN, (Function0) null, false, (md1.n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, 196992, 0, 65360);
            n2 n2Var = n2.a;
            tlydtdl.compose.foundation.layout.m.i(sVar2, n2Var.a(1.0f, pVar2, true));
            if (hVar != null) {
                sVar2.f0(-1241482507);
                tlydtdl.compose.foundation.layout.m.i(sVar2, o2.p(pVar2, 40));
                z2 = false;
            } else {
                z2 = false;
                sVar2.f0(-1244097388);
            }
            sVar2.r(z2);
            zs0.c.b(list, bVar, gVar, function1, sVar2, (i3 & WebSocketProtocol.PAYLOAD_SHORT) | ((i3 >> 6) & 896) | ((i3 >> 15) & 7168));
            c60.g.a(hVar, (t3.p) null, 0.0f, sVar2, (i3 >> 9) & 14, 6);
            tlydtdl.compose.foundation.layout.m.i(sVar2, n2Var.a(1.0f, pVar2, true));
            fe1.f.a(new dg1.g(2131231810, z2), x10.a.N(sVar2, 2132019989), (a4.a1) null, md1.g.v(o2.r(pVar2, f2, f3), (md1.n0) null, (a5.h) null, true, z, function03, (Function0) null, function02, 35), (t3.d) null, kVar, 0.0f, md1.g.f0(z ? i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size) : i.u(dVar, R.dimen.m3_comp_elevated_button_disabled_container_elevation), sVar2, 6), (Function0) null, false, (md1.n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, 196992, 0, 65360);
            sVar = sVar2;
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new zs0.a(list, bVar, z, hVar, gVar, function0, function02, function03, function1, pVar, i);
        }
    }

    public static final void f(List list, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(list, "backHandlers");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-188063779);
        int i2 = (sVar.g(list) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b((pd1.c) it.next(), sVar, 0);
            }
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ln0.b(list, i, 9);
        }
    }

    public static final void g(Function0 function0, Function0 function02, List list, boolean z, Function1 function1, Function0 function03, Function0 function04, wp.r rVar, tlydtdl.compose.runtime.m mVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(function0, "onOpenSignup");
        lmjxuqdtp.jvm.internal.o.h(function02, "onOpenLogin");
        lmjxuqdtp.jvm.internal.o.h(list, "socialAuthProviders");
        lmjxuqdtp.jvm.internal.o.h(function1, "onSocialConnect");
        lmjxuqdtp.jvm.internal.o.h(function03, "onTermsOfUseClicked");
        lmjxuqdtp.jvm.internal.o.h(function04, "onPrivacyPolicyClicked");
        lmjxuqdtp.jvm.internal.o.h(rVar, "signupEmailUiMode");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(888778561);
        int i2 = i | (sVar.i(function0) ? 4 : 2) | (sVar.i(function02) ? 32 : 16) | (sVar.g(list) ? 256 : 128) | (sVar.h(z) ? 2048 : 1024) | (sVar.i(function1) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192) | (sVar.i(function03) ? 131072 : 65536) | (sVar.i(function04) ? 1048576 : 524288) | (sVar.g(rVar) ? 8388608 : 4194304);
        if (sVar.W(i2 & 1, (4793491 & i2) != 4793490)) {
            ct1.b.b(q3.p.d(-1445106150, new wp.w(function0, list, z, function1, function03, function04, rVar), sVar), q3.p.d(-1142218759, new wp.h(function02), sVar), sVar, 54, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new k0(function0, function02, list, z, function1, function03, function04, rVar, i);
        }
    }

    public static final q10.j0 h(m10.f fVar) {
        lmjxuqdtp.jvm.internal.o.h(fVar, "<this>");
        return new q10.j0(new q10.s0(fVar.a), fVar.f, fVar.j);
    }

    public static final py1.d i(ky1.a0 a0Var, qx1.i iVar) {
        lmjxuqdtp.jvm.internal.o.h(a0Var, "<this>");
        lmjxuqdtp.jvm.internal.o.h(iVar, "context");
        e1 e1Var = e1.a;
        iVar.get(e1Var);
        return ky1.c0.b(a0Var.getCoroutineContext().plus(iVar).plus(new g1(a0Var.getCoroutineContext().get(e1Var))));
    }

    public static final tlydtdl.compose.runtime.e1 j(c2.m mVar, tlydtdl.compose.runtime.m mVar2, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar2;
        Object objR = sVar.R();
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        if (objR == x0Var) {
            objR = tlydtdl.compose.runtime.a0.t(Boolean.FALSE);
            sVar.q0(objR);
        }
        tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) objR;
        boolean z = (((i & 14) ^ 6) > 4 && sVar.g(mVar)) || (i & 6) == 4;
        Object objR2 = sVar.R();
        if (z || objR2 == x0Var) {
            objR2 = new c2.i(mVar, e1Var, (d) null, 0);
            sVar.q0(objR2);
        }
        tlydtdl.compose.runtime.a0.f(sVar, mVar, (Function2) objR2);
        return e1Var;
    }

    public static final boolean k(z3.c cVar, float f2, float f3) {
        float f4 = cVar.a;
        if (f2 > cVar.c || f4 > f2) {
            return false;
        }
        return f3 <= cVar.d && cVar.b <= f3;
    }

    public static ao0.g l(ev0.l lVar, iw1.b bVar) {
        lmjxuqdtp.jvm.internal.o.h(lVar, "instance");
        lmjxuqdtp.jvm.internal.o.h(bVar, "commonActivity");
        return new ao0.g(13, lVar, bVar);
    }

    public static qs0.a m(iw1.b bVar, jq0.d dVar, iw1.b bVar2, iw1.b bVar3) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "playCounterRepository");
        lmjxuqdtp.jvm.internal.o.h(bVar2, "songDao");
        lmjxuqdtp.jvm.internal.o.h(bVar3, "apiServiceFactory");
        return new qs0.a(bVar, (iw1.b) dVar, bVar2, bVar3, 13);
    }

    public static final ok1.s o(Context context, float f2) {
        qc1.a aVar = qc1.a.d;
        return new ok1.s(16 * f2, as.a.a(context), qg.a.r(context, 2131231437), 20 * f2, 4 * f2);
    }

    public static InvocationHandler q() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = g6.a.i();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static final Integer r(Throwable th) {
        ApiHttpException apiHttpException = th instanceof ApiHttpException ? (ApiHttpException) th : null;
        if (apiHttpException != null) {
            return apiHttpException.a();
        }
        return null;
    }

    public static ld1.q s() {
        return i.u(ld1.r.Companion, 2131100921);
    }

    public static final String t() {
        return String.format("m.%s", Arrays.copyOf(new Object[]{com.facebook.s.q}, 1));
    }

    public static final Integer u(Throwable th) {
        if (th == null) {
            return null;
        }
        boolean z = th instanceof HttpException;
        if (z || (th.getCause() instanceof HttpException)) {
            if (!z) {
                th = th.getCause();
            }
            lmjxuqdtp.jvm.internal.o.f(th, "null cannot be cast to non-null type dionskkgzp.HttpException");
            return Integer.valueOf(((HttpException) th).a);
        }
        boolean z2 = th instanceof ApiHttpException;
        if (!z2 && !(th.getCause() instanceof ApiHttpException)) {
            return null;
        }
        if (!z2) {
            th = th.getCause();
        }
        lmjxuqdtp.jvm.internal.o.f(th, "null cannot be cast to non-null type com.bandlab.restutils.model.ApiHttpException");
        return Integer.valueOf(((ApiHttpException) th).a);
    }

    public static final String v() {
        return String.format("m.%s", Arrays.copyOf(new Object[]{com.facebook.s.p}, 1));
    }

    public static ld1.q w() {
        return i.u(ld1.r.Companion, 2131100924);
    }

    public static final boolean x(Throwable th, int... iArr) {
        lmjxuqdtp.jvm.internal.o.h(iArr, "codes");
        Integer numR = r(th);
        if (numR != null) {
            return mx1.n.M(numR.intValue(), iArr);
        }
        return false;
    }

    public static final String y(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = reader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = reader.read(cArr);
        }
        String string = stringWriter.toString();
        lmjxuqdtp.jvm.internal.o.g(string, "toString(...)");
        return string;
    }

    public static final d5.o0 z(tlydtdl.compose.runtime.m mVar) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        h5.h hVar = (h5.h) sVar.k(r1.k);
        p5.c cVar = (p5.c) sVar.k(r1.h);
        p5.n nVar = (p5.n) sVar.k(r1.n);
        boolean zG = sVar.g(hVar) | sVar.g(cVar) | sVar.e(nVar.ordinal()) | sVar.e(8);
        Object objR = sVar.R();
        if (zG || objR == tlydtdl.compose.runtime.l.a) {
            objR = new d5.o0(hVar, cVar, nVar, 8);
            sVar.q0(objR);
        }
        return (d5.o0) objR;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String n(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.datastore.preferences.protobuf.j1.n(byte[], int, int):java.lang.String");
    }

    public final int p(String str, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char cCharAt;
        long j2;
        char c;
        long j3;
        long j4;
        char c2;
        int i6;
        char cCharAt2;
        switch (this.a) {
            case 0:
                int length = str.length();
                int i7 = i2 + i;
                int i8 = 0;
                while (i8 < length && (i4 = i8 + i) < i7 && (cCharAt = str.charAt(i8)) < 128) {
                    bArr[i4] = (byte) cCharAt;
                    i8++;
                }
                if (i8 == length) {
                    return i + length;
                }
                int i9 = i + i8;
                while (i8 < length) {
                    char cCharAt3 = str.charAt(i8);
                    if (cCharAt3 < 128 && i9 < i7) {
                        bArr[i9] = (byte) cCharAt3;
                        i9++;
                    } else if (cCharAt3 < 2048 && i9 <= i7 - 2) {
                        int i10 = i9 + 1;
                        bArr[i9] = (byte) ((cCharAt3 >>> 6) | 960);
                        i9 += 2;
                        bArr[i10] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i9 > i7 - 3) {
                            if (i9 > i7 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i8 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i3)))) {
                                    throw new Utf8$UnpairedSurrogateException(i8, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i9);
                            }
                            int i11 = i8 + 1;
                            if (i11 != str.length()) {
                                char cCharAt4 = str.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i12 = i9 + 3;
                                    bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i9 += 4;
                                    bArr[i12] = (byte) ((codePoint & 63) | 128);
                                    i8 = i11;
                                } else {
                                    i8 = i11;
                                }
                            }
                            throw new Utf8$UnpairedSurrogateException(i8 - 1, length);
                        }
                        bArr[i9] = (byte) ((cCharAt3 >>> '\f') | NNTPReply.AUTHENTICATION_REQUIRED);
                        int i13 = i9 + 2;
                        bArr[i9 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i9 += 3;
                        bArr[i13] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i8++;
                }
                return i9;
            default:
                long j5 = i;
                long j6 = ((long) i2) + j5;
                int length2 = str.length();
                if (length2 > i2 || bArr.length - i2 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i2));
                }
                int i14 = 0;
                while (true) {
                    j2 = 1;
                    c = 128;
                    if (i14 < length2 && (cCharAt2 = str.charAt(i14)) < 128) {
                        i1.j(bArr, j5, (byte) cCharAt2);
                        i14++;
                        j5 = 1 + j5;
                    }
                }
                if (i14 == length2) {
                    return (int) j5;
                }
                while (i14 < length2) {
                    char cCharAt5 = str.charAt(i14);
                    if (cCharAt5 < c && j5 < j6) {
                        i1.j(bArr, j5, (byte) cCharAt5);
                        c2 = c;
                        j3 = j2;
                        j4 = j5 + j2;
                    } else if (cCharAt5 >= 2048 || j5 > j6 - 2) {
                        j3 = j2;
                        if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j5 > j6 - 3) {
                            long j7 = j5;
                            if (j7 > j6 - 4) {
                                if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i6 = i14 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i6)))) {
                                    throw new Utf8$UnpairedSurrogateException(i14, length2);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j7);
                            }
                            int i15 = i14 + 1;
                            if (i15 != length2) {
                                char cCharAt6 = str.charAt(i15);
                                if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                    int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                    i1.j(bArr, j7, (byte) ((codePoint2 >>> 18) | 240));
                                    c2 = 128;
                                    i1.j(bArr, j7 + j3, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                    i1.j(bArr, j7 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                    i1.j(bArr, j7 + 3, (byte) ((codePoint2 & 63) | 128));
                                    j4 = j7 + 4;
                                    i14 = i15;
                                } else {
                                    i14 = i15;
                                }
                            }
                            throw new Utf8$UnpairedSurrogateException(i14 - 1, length2);
                        }
                        i1.j(bArr, j5, (byte) ((cCharAt5 >>> '\f') | NNTPReply.AUTHENTICATION_REQUIRED));
                        long j8 = j5;
                        i1.j(bArr, j5 + j3, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                        j4 = j8 + 3;
                        i1.j(bArr, j8 + 2, (byte) ((cCharAt5 & '?') | 128));
                        c2 = 128;
                    } else {
                        j3 = j2;
                        i1.j(bArr, j5, (byte) ((cCharAt5 >>> 6) | 960));
                        i1.j(bArr, j5 + j3, (byte) ((cCharAt5 & '?') | c));
                        j4 = j5 + 2;
                        c2 = c;
                    }
                    i14++;
                    c = c2;
                    j5 = j4;
                    j2 = j3;
                }
                return (int) j5;
        }
    }
}
