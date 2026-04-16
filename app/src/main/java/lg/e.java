package lg;

import a2.j3;
import a2.r2;
import a2.x3;
import a4.a1;
import a4.q;
import a4.u;
import a4.w0;
import amuvvoafs.app.Activity;
import amuvvoafs.content.Context;
import amuvvoafs.content.pm.ApplicationInfo;
import amuvvoafs.content.res.Resources;
import amuvvoafs.os.Bundle;
import amuvvoafs.text.TextUtils;
import amuvvoafs.util.Log;
import amuvvoafs.util.TypedValue;
import an0.h;
import av1.g;
import com.facebook.appevents.w;
import com.facebook.internal.t0;
import com.facebook.s;
import com.gnacba.amuvvoafs.gms.internal.ads.py0;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import d5.m0;
import d5.p0;
import f.d0;
import f3.f2;
import fe1.f;
import iz1.e0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import ky1.a0;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import ld1.r;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.i;
import m2.i2;
import m2.l1;
import m2.m1;
import md1.b1;
import md1.e1;
import md1.n0;
import mx1.n;
import mx1.z;
import my1.x;
import ny1.p2;
import okhttp3.internal.http2.Http2;
import org.apache.commons.net.telnet.TelnetCommand;
import org.json.JSONException;
import org.json.JSONObject;
import p5.l;
import q1.v0;
import q4.u0;
import q4.z0;
import qi.k;
import qx1.j;
import s1.f0;
import s1.g0;
import t1.q1;
import t3.p;
import t4.r1;
import t4.t2;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.compose.foundation.layout.LayoutWeightElement;
import tlydtdl.compose.foundation.layout.m2;
import tlydtdl.compose.foundation.layout.n2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.foundation.lazy.layout.h0;
import tlydtdl.compose.foundation.lazy.layout.r0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.k1;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.n1;
import tlydtdl.compose.runtime.x0;
import tlydtdl.lifecycle.y;
import v1.p1;
import x10.v;
import y11.d1;
import y11.j0;
import y11.u1;
import y11.w1;
import y3.t;
import yr.n8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static boolean a;
    public static Boolean b;

    public static e0 A(String str) {
        o.h(str, "<this>");
        try {
            return w(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static x B(a0 a0Var, int i, Function2 function2, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        my1.c cVar = my1.c.a;
        b0 b0Var = b0.a;
        x xVar = new x(c0.G(a0Var, j.a), h02.a.c(i, cVar, (i2) null, 4), true, true);
        xVar.h0(b0Var, xVar, function2);
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String C(amuvvoafs.content.Context r10) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.e.C(amuvvoafs.content.Context):java.lang.String");
    }

    public static String D(Context context, ApplicationInfo applicationInfo) {
        String str;
        String str2;
        String str3 = a ? "io.branch.sdk.BranchKey.test" : "io.branch.sdk.BranchKey";
        StringBuilder sbQ = f2.q("Looking for branch key in manifest with key: ", str3, " (test mode: ");
        sbQ.append(a);
        sbQ.append(")");
        h02.a.S(sbQ.toString());
        String string = applicationInfo.metaData.getString(str3);
        if (string != null) {
            StringBuilder sb = new StringBuilder("Found branch key in manifest meta-data: ");
            if (string.length() > 10) {
                str2 = string.substring(0, 10) + "...";
            } else {
                str2 = string;
            }
            sb.append(str2);
            h02.a.S(sb.toString());
            g gVarA = g.A(context);
            gVarA.U(string);
            gVarA.d0("bnc_branch_key_source", "manifest");
            return string;
        }
        if (!a) {
            h02.a.S("Branch key not found for live mode in manifest");
            return null;
        }
        h02.a.S("Test mode enabled but test key not found, attempting fallback to live key...");
        String string2 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
        if (string2 == null) {
            h02.a.S("No live key found for test mode fallback");
            return string2;
        }
        StringBuilder sb2 = new StringBuilder("Found live branch key for test mode fallback: ");
        if (string2.length() > 10) {
            str = string2.substring(0, 10) + "...";
        } else {
            str = string2;
        }
        sb2.append(str);
        h02.a.S(sb2.toString());
        g gVarA2 = g.A(context);
        gVarA2.U(string2);
        gVarA2.d0("bnc_branch_key_source", "manifest_test_fallback");
        return string2;
    }

    public static TypedValue E(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean F(Context context, int i, boolean z) {
        TypedValue typedValueE = E(context, i);
        return (typedValueE == null || typedValueE.type != 18) ? z : typedValueE.data != 0;
    }

    public static TypedValue G(Context context, int i, String str) {
        TypedValue typedValueE = E(context, i);
        if (typedValueE != null) {
            return typedValueE;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static final l H(z3.c cVar) {
        return new l(Math.round(cVar.a), Math.round(cVar.b), Math.round(cVar.c), Math.round(cVar.d));
    }

    public static final Object I(Function2 function2) {
        Thread.interrupted();
        return c0.J(j.a, new k(function2, (qx1.d) null));
    }

    public static void J(Context context) {
        JSONObject jSONObject = (JSONObject) m80.b.h(context).b;
        String string = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("apiUrl")) {
                    string = jSONObject.getString("apiUrl");
                }
            } catch (JSONException e) {
                Log.e("BranchJsonConfig", "Error parsing branch.json: " + e.getMessage());
            }
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (TextUtils.isEmpty(string)) {
            h02.a.U("setAPIUrl: URL cannot be empty or null");
            return;
        }
        if (!string.endsWith("/")) {
            string = string.concat("/");
        }
        g.h = string;
        h02.a.S("setAPIUrl: Branch API URL was set to " + string);
    }

    public static void K(Context context) {
        JSONObject jSONObject = (JSONObject) m80.b.h(context).b;
        String string = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("cppLevel")) {
                    string = jSONObject.getString("cppLevel");
                }
            } catch (JSONException e) {
                Log.e("BranchJsonConfig", "Error parsing branch.json: " + e.getMessage());
            }
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int iC = b1.C(string);
        nw1.c cVarK = nw1.c.k();
        Context context2 = cVarK.d;
        py0 py0Var = cVarK.k;
        g gVar = cVarK.b;
        gVar.getClass();
        gVar.d0("bnc_consumer_protection_attribution_level", b1.A(iC));
        h02.a.S("Set Consumer Protection Preference to ".concat(iC != 1 ? iC != 2 ? iC != 3 ? iC != 4 ? "null" : "NONE" : "MINIMAL" : "REDUCED" : "FULL"));
        if (iC == 4) {
            py0Var.f(context2, true);
        } else if (py0Var.b) {
            py0Var.f(context2, false);
        }
    }

    public static void L(Context context) {
        JSONObject jSONObject = (JSONObject) m80.b.h(context).b;
        String string = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("fbAppId")) {
                    string = jSONObject.getString("fbAppId");
                }
            } catch (JSONException e) {
                Log.e("BranchJsonConfig", "Error parsing branch.json: " + e.getMessage());
            }
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        nw1.c.w(string);
    }

    public static void M(HashMap map) {
        String[] strArr;
        ConcurrentHashMap concurrentHashMap = w.e;
        w wVar = w.a;
        if (vn1.a.b(w.class)) {
            return;
        }
        try {
            if (!w.c.get()) {
                wVar.b();
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                int length = str2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = o.i(str2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String strT0 = t0.t0(wVar.c(str, str2.subSequence(i, length + 1).toString()));
                if (concurrentHashMap.containsKey(str)) {
                    String str3 = (String) concurrentHashMap.get(str);
                    if (str3 == null || (strArr = (String[]) new hy1.o(",").i(0, str3).toArray(new String[0])) == null) {
                        strArr = new String[0];
                    }
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
                    o.h(objArrCopyOf, "elements");
                    LinkedHashSet linkedHashSet = new LinkedHashSet(z.R(objArrCopyOf.length));
                    n.t0(objArrCopyOf, linkedHashSet);
                    if (linkedHashSet.contains(strT0)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(strT0);
                    } else if (strArr.length < 5) {
                        sb.append(str3);
                        sb.append(",");
                        sb.append(strT0);
                    } else {
                        for (int i2 = 1; i2 < 5; i2++) {
                            sb.append(strArr[i2]);
                            sb.append(",");
                        }
                        sb.append(strT0);
                        linkedHashSet.remove(strArr[0]);
                    }
                    concurrentHashMap.put(str, sb.toString());
                } else {
                    concurrentHashMap.put(str, strT0);
                }
            }
            String strI0 = t0.i0(concurrentHashMap);
            if (vn1.a.b(wVar)) {
                return;
            }
            try {
                s.c().execute(new cn1.d(strI0, 1));
            } catch (Throwable th) {
                vn1.a.a(wVar, th);
            }
        } catch (Throwable th2) {
            vn1.a.a(w.class, th2);
        }
    }

    public static u1 N(String str) {
        u1 u1Var = u1.b;
        if (!str.equals(w1.a(u1Var)) && !str.equals("cd-master")) {
            u1Var = u1.c;
            if (!str.equals(w1.a(u1Var)) && !str.equals("bass-boost")) {
                u1Var = u1.d;
                if (!str.equals(w1.a(u1Var)) && !str.equals("enhance-clarity")) {
                    u1 u1Var2 = u1.e;
                    if (str.equals(w1.a(u1Var2))) {
                        return u1Var2;
                    }
                    u1 u1Var3 = u1.f;
                    if (str.equals(w1.a(u1Var3))) {
                        return u1Var3;
                    }
                    u1 u1Var4 = u1.g;
                    if (str.equals(w1.a(u1Var4))) {
                        return u1Var4;
                    }
                    u1 u1Var5 = u1.h;
                    if (str.equals(w1.a(u1Var5))) {
                        return u1Var5;
                    }
                    u1 u1Var6 = u1.i;
                    if (str.equals(w1.a(u1Var6))) {
                        return u1Var6;
                    }
                    return null;
                }
            }
        }
        return u1Var;
    }

    public static final void O(Object obj) {
        if (obj instanceof lx1.n) {
            throw ((lx1.n) obj).a;
        }
    }

    public static final y11.c P(d1 d1Var) {
        if (d1Var instanceof y11.c) {
            return (y11.c) d1Var;
        }
        if (d1Var == null) {
            return null;
        }
        boolean zG = d1Var.g();
        List listF = d1Var.f();
        Float fE = d1Var.e();
        String strD = d1Var.d();
        String strA = d1Var.a();
        String scale = d1Var.getScale();
        String strC = d1Var.c();
        return new y11.c(zG, listF, fE, strD, scale, strA, !o.c(strC, "0.0") ? strC : null, d1Var.b(), d1Var.getAlgorithm());
    }

    public static final j0 Q(d1 d1Var) {
        o.h(d1Var, "<this>");
        if (d1Var instanceof j0) {
            return (j0) d1Var;
        }
        boolean zG = d1Var.g();
        Float fE = d1Var.e();
        float fFloatValue = fE != null ? fE.floatValue() : 0.0f;
        List listF = d1Var.f();
        String strD = d1Var.d();
        String strA = d1Var.a();
        String scale = d1Var.getScale();
        String strC = d1Var.c();
        if (strC == null) {
            strC = "0.0";
        }
        return new j0(zG, listF, fFloatValue, strD, scale, strA, strC, d1Var.b(), d1Var.getAlgorithm());
    }

    public static final lx1.l R(lmjxuqdtp.time.l lVar, lmjxuqdtp.time.l lVar2) {
        long jT = lmjxuqdtp.time.g.t(lVar2.c(lVar), i.g);
        long j2 = 24;
        return new lx1.l(Integer.valueOf((int) (jT / j2)), Integer.valueOf((int) (jT % j2)));
    }

    public static final double S(double d, float f2, hg1.x xVar) {
        return d * ((double) (xVar.a * (((60 / f2) * 4) / xVar.b)));
    }

    public static String T(long j2) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            return "CornerRadius.circular(" + z0.A(Float.intBitsToFloat(i)) + ')';
        }
        return "CornerRadius.elliptical(" + z0.A(Float.intBitsToFloat(i)) + ", " + z0.A(Float.intBitsToFloat(i2)) + ')';
    }

    public static final q U(boolean z, m mVar) {
        if (!z) {
            tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
            sVar.f0(1607972335);
            sVar.r(false);
            return null;
        }
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.f0(1607827379);
        q qVar = new q(i.e(2131100890, 0, sVar2, r.Companion), 26);
        sVar2.r(false);
        return qVar;
    }

    public static final void a(int i, m mVar, final Function0 function0, p pVar, boolean z) {
        p pVar2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-2041249555);
        int i2 = (sVar.h(z) ? 4 : 2) | i | (sVar.i(function0) ? 32 : 16);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            pVar2 = pVar;
            p pVarX = j4.x(sVar, pVar2);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            final int i3 = 1;
            tlydtdl.compose.animation.b.d(z, null, null, null, null, q3.p.d(939087567, new Function3() { // from class: fs0.b0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    switch (i3) {
                        case 0:
                            tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj2;
                            int iIntValue = ((Integer) obj3).intValue();
                            lmjxuqdtp.jvm.internal.o.h((m2) obj, "$this$SwipeToDismissBox");
                            tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                            if (sVar2.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                                float f2 = 16;
                                ln1.e.b(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132017565), new x10.r(2132019045), function0, tlydtdl.compose.foundation.layout.m.H(t3.m.a, f2, 12, f2, 0.0f, 8), false, null, sVar2, 27648, 32);
                            } else {
                                sVar2.Z();
                            }
                            break;
                        default:
                            tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj2;
                            ((Integer) obj3).getClass();
                            lmjxuqdtp.jvm.internal.o.h((s1.a0) obj, "$this$AnimatedVisibility");
                            f.a(new dg1.g(2131231697, false), x10.a.N(mVar3, 2132017880), (a1) null, tlydtdl.compose.ui.platform.a.a(tlydtdl.compose.foundation.layout.m.D(com.facebook.appevents.l.o(md1.g.v(b4.v(t3.m.a, l2.f.b(8)), md1.j0.a, (a5.h) null, false, false, (Function0) null, (Function0) null, function0, 62), f2.d(r.Companion, 2131100913, mVar3, 0), w0.a), 12), "add_track_button"), (t3.d) null, (q4.m) null, 0.0f, new q(md1.g.y(new ld1.q(R.dimen.m3_comp_fab_primary_large_icon_size), mVar3, 0), 5), (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, mVar3, 384, 0, 65392);
                            break;
                    }
                    return lx1.b0.a;
                }
            }, sVar), sVar, (i2 & 14) | 196608, 30);
            sVar.r(true);
        } else {
            pVar2 = pVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ds0.m(z, function0, pVar2, i, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(java.lang.Object r14, t3.p r15, t1.z r16, java.lang.String r17, q3.k r18, tlydtdl.compose.runtime.m r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.e.b(java.lang.Object, t3.p, t1.z, java.lang.String, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void c(q1 q1Var, p pVar, t1.z zVar, Function1 function1, q3.k kVar, m mVar, int i) {
        Function1 function12;
        r0 r0Var = q1Var.a;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1877370462);
        int i2 = (i & 6) == 0 ? (sVar.g(q1Var) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= sVar.g(pVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(zVar) ? 256 : 128;
        }
        int i3 = i2 | 3072;
        if ((i & 24576) == 0) {
            i3 |= sVar.i(kVar) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        if (sVar.W(i3 & 1, (i3 & 9363) != 9362)) {
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = s1.d.j;
                sVar.q0(objR);
            }
            function12 = (Function1) objR;
            Object objR2 = sVar.R();
            Object obj = objR2;
            if (objR2 == x0Var) {
                s3.p pVar2 = new s3.p();
                pVar2.add(r0Var.m());
                sVar.q0(pVar2);
                obj = pVar2;
            }
            s3.p pVar3 = (s3.p) obj;
            Object objR3 = sVar.R();
            if (objR3 == x0Var) {
                long[] jArr = v0.a;
                objR3 = new q1.n0();
                sVar.q0(objR3);
            }
            q1.n0 n0Var = (q1.n0) objR3;
            n1 n1Var = q1Var.d;
            if (o.c(r0Var.m(), n1Var.getValue())) {
                sVar.f0(321189832);
                if (pVar3.size() == 1 && o.c(pVar3.get(0), n1Var.getValue())) {
                    sVar.f0(321514464);
                    sVar.r(false);
                } else {
                    sVar.f0(321324186);
                    boolean z = (i3 & 14) == 4;
                    Object objR4 = sVar.R();
                    if (z || objR4 == x0Var) {
                        objR4 = new tlydtdl.fragment.app.q(16, q1Var);
                        sVar.q0(objR4);
                    }
                    mx1.o.U0(pVar3, (Function1) objR4);
                    n0Var.a();
                    sVar.r(false);
                }
                sVar.r(false);
            } else {
                sVar.f0(321520416);
                sVar.r(false);
            }
            if (n0Var.b(n1Var.getValue())) {
                sVar.f0(322323936);
                sVar.r(false);
            } else {
                sVar.f0(321581083);
                nx1.c cVarListIterator = pVar3.listIterator();
                int i4 = 0;
                while (true) {
                    nx1.c cVar = cVarListIterator;
                    if (!cVar.hasNext()) {
                        i4 = -1;
                        break;
                    } else if (o.c(function12.invoke(cVar.next()), function12.invoke(n1Var.getValue()))) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 == -1) {
                    pVar3.add(n1Var.getValue());
                } else {
                    pVar3.set(i4, n1Var.getValue());
                }
                n0Var.a();
                int size = pVar3.size();
                for (int i6 = 0; i6 < size; i6++) {
                    Object obj2 = pVar3.get(i6);
                    n0Var.m(obj2, q3.p.d(-934471669, new f0(q1Var, zVar, obj2, kVar), sVar));
                }
                sVar.r(false);
            }
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            sVar.f0(-1312707512);
            int size2 = pVar3.size();
            for (int i7 = 0; i7 < size2; i7++) {
                Object obj3 = pVar3.get(i7);
                sVar.d0(1171574969, function12.invoke(obj3));
                Function2 function2 = (Function2) n0Var.g(obj3);
                if (function2 == null) {
                    sVar.f0(1959122128);
                } else {
                    sVar.f0(1171576145);
                    function2.invoke(sVar, 0);
                }
                sVar.r(false);
                sVar.r(false);
            }
            sVar.r(false);
            sVar.r(true);
        } else {
            sVar.Z();
            function12 = function1;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new g0(q1Var, pVar, zVar, function12, kVar, i);
        }
    }

    public static final void d(ComponentActivity componentActivity, xf1.a aVar, q3.k kVar, m mVar, int i) {
        o.h(componentActivity, "<this>");
        o.h(aVar, "uiMode");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(179109384);
        int i2 = (sVar.i(componentActivity) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= sVar.e(aVar.ordinal()) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            sVar.f0(1498443956);
            boolean zG = ln1.e.G(aVar, sVar);
            boolean zH = sVar.h(zG);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zH || objR == x0Var) {
                objR = new e1(zG, 4);
                sVar.q0(objR);
            }
            d0 d0VarA = nd1.a.a((Function1) objR);
            boolean zH2 = sVar.h(zG);
            Object objR2 = sVar.R();
            if (zH2 || objR2 == x0Var) {
                objR2 = new e1(zG, 5);
                sVar.q0(objR2);
            }
            f.o.a(componentActivity, d0VarA, nd1.a.a((Function1) objR2));
            sVar.r(false);
            e(aVar, kVar, sVar, ((i2 >> 3) & 14) | 48);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new h0(i, 7, componentActivity, aVar, kVar);
        }
    }

    public static final void e(xf1.a aVar, q3.k kVar, m mVar, int i) {
        int i2;
        o.h(aVar, "uiMode");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(202707854);
        if ((i & 6) == 0) {
            i2 = (sVar.e(aVar.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(kVar) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            hs1.d.h(ln1.e.G(aVar, sVar) ? rf1.a.a() : (yf1.a) rf1.c.a.getValue(), kVar, sVar, i2 & 112);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(aVar, kVar, i, 13);
        }
    }

    public static final l f(long j2, long j3) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        return new l(i, i2, ((int) (j3 >> 32)) + i, ((int) (j3 & 4294967295L)) + i2);
    }

    public static final void g(an0.a aVar, a80.d dVar, p pVar, m mVar, int i) {
        tlydtdl.compose.runtime.s sVar;
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(386998424);
        int i2 = i | (sVar2.i(aVar) ? 4 : 2);
        if ((i & 48) == 0) {
            i2 |= sVar2.g(dVar) ? 32 : 16;
        }
        int i3 = i2 | (sVar2.g(pVar) ? 256 : 128);
        if (sVar2.W(i3 & 1, (i3 & 147) != 146)) {
            sVar = sVar2;
            tf1.s.b(aVar.c, pVar, (Function0) null, tf1.d.g, 0L, 0.0f, 0.0f, 0.0f, (r) null, (r) null, (t5.g0) null, 0, q3.p.d(-1858356071, new a00.c(13, aVar, dVar), sVar2), sVar, ((i3 >> 3) & 112) | 3072, 384, 4084);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a3.d(i, 2, aVar, dVar, pVar);
        }
    }

    public static final void h(an0.a aVar, a80.d dVar, m mVar, int i) {
        boolean z;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1576496789);
        int i2 = (sVar.i(aVar) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= sVar.g(dVar) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            if (aVar.h) {
                sVar.f0(-51267828);
                z = false;
                com.bandlab.uikit.compose.bottomsheet.l.a(new com.bandlab.uikit.compose.bottomsheet.e(true, true, (uq0.f0) dVar.d), (p) null, 0L, (com.bandlab.uikit.compose.bottomsheet.s) null, false, false, (v2) null, (Function2) null, q3.p.d(1328385430, new r2(3, dVar, aVar), sVar), sVar, 100663296, TelnetCommand.DONT);
            } else {
                z = false;
                sVar.f0(-56070131);
            }
            sVar.r(z);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(aVar, dVar, i, 0);
        }
    }

    public static final void i(an0.a aVar, xr0.a aVar2, p pVar, m mVar, int i) {
        tlydtdl.compose.runtime.s sVar;
        int i2;
        int i3;
        p1 p1Var;
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(-1776959569);
        int i4 = i | (sVar2.i(aVar) ? 4 : 2) | (sVar2.i(aVar2) ? 32 : 16) | (sVar2.g(pVar) ? 256 : 128);
        if (sVar2.W(i4 & 1, (i4 & 147) != 146)) {
            tlydtdl.compose.runtime.e1 e1VarR = st.w0.r(aVar.a, sVar2, 0, 7);
            p1 p1VarD = uz1.g.D(sVar2);
            Object objR = sVar2.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = tlydtdl.compose.runtime.a0.t(null);
                sVar2.q0(objR);
            }
            tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) objR;
            Object objR2 = sVar2.R();
            if (objR2 == x0Var) {
                objR2 = com.ironsource.adqualitysdk.sdk.i.a0.g(0, sVar2);
            }
            k1 k1Var = (k1) objR2;
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar2.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar2.m();
            p pVarX = j4.x(sVar2, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar2, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar2.S || !o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar2, pVarX, s4.k.d);
            i5.w wVar = (i5.w) e1VarR.getValue();
            ld1.d dVar = r.Companion;
            ld1.q qVarU = i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size);
            of1.n nVarD = of1.q.d();
            p pVar2 = t3.m.a;
            p pVarD = o2.d(pVar2, 1.0f);
            Object objR3 = sVar2.R();
            if (objR3 == x0Var) {
                objR3 = new h(k1Var, 0);
                sVar2.q0(objR3);
            }
            p pVarG = tlydtdl.compose.ui.layout.a.g(pVarD, (Function1) objR3);
            o.h(pVarG, "<this>");
            o.h(p1VarD, "scrollState");
            a2.w wVar2 = p1VarD.f;
            float f2 = 2;
            float fI0 = md1.g.i0(f2, sVar2);
            float fI02 = md1.g.i0(f2, sVar2);
            float fI03 = md1.g.i0(16, sVar2);
            float f3 = wVar2.b() ? 1.0f : 0.0f;
            if (wVar2.b()) {
                i2 = i4;
                i3 = 150;
            } else {
                i2 = i4;
                i3 = 500;
            }
            f3 f3VarB = t1.e.b(f3, t1.c.t(i3, wVar2.b() ? 0 : 500, (t1.w) null, 4), (String) null, sVar2, 0, 28);
            dVar.getClass();
            long jZ = md1.g.Z(new ld1.q(R.dimen.m3_comp_fab_primary_large_icon_size), sVar2, 0);
            boolean zG = sVar2.g(p1VarD) | sVar2.g(f3VarB) | sVar2.d(fI03) | sVar2.f(jZ) | sVar2.d(fI0) | sVar2.d(fI02);
            Object objR4 = sVar2.R();
            if (zG || objR4 == x0Var) {
                objR4 = new an0.k(p1VarD, fI03, jZ, fI0, fI02, f3VarB);
                p1Var = p1VarD;
                sVar2.q0(objR4);
            } else {
                p1Var = p1VarD;
            }
            p pVarA = tlydtdl.compose.ui.platform.a.a(uz1.g.H(pVarG.then(tlydtdl.compose.ui.draw.a.c(pVar2, (Function1) objR4)), p1Var, 14), "LYRICS_TEXT_FIELD_TAG");
            Object objR5 = sVar2.R();
            if (objR5 == x0Var) {
                objR5 = new x3(1, e1Var);
                sVar2.q0(objR5);
            }
            md1.g.n(wVar, aVar2, qVarU, nVarD, pVarA, (u) null, 0, 5, (m1) null, (l1) null, (i5.f0) null, (Function1) objR5, (t) null, (Function3) null, sVar2, i2 & 112);
            sVar = sVar2;
            if (((i5.w) e1VarR.getValue()).a.b.length() == 0) {
                sVar.f0(2143968777);
                z10.d.h(com.ironsource.adqualitysdk.sdk.i.a0.w(v.Companion, 2132018762, dVar), new ld1.q(R.dimen.m3_comp_fab_primary_pressed_container_elevation), of1.q.d(), tlydtdl.compose.foundation.layout.x.a.b(pVar2, t3.c.e), false, (of1.e) null, 0, (Function1) null, sVar, 0, 240);
                sVar = sVar;
            } else {
                sVar.f0(2130667545);
            }
            sVar.r(false);
            p0 p0Var = new p0(((i5.w) e1VarR.getValue()).b);
            m0 m0Var = (m0) e1Var.getValue();
            Integer numValueOf = Integer.valueOf(k1Var.h());
            boolean zG2 = sVar.g(e1VarR) | sVar.g(p1Var);
            Object objR6 = sVar.R();
            if (zG2 || objR6 == x0Var) {
                an0.j jVar2 = new an0.j(p1Var, e1Var, e1VarR, k1Var, (qx1.d) null, 0);
                sVar.q0(jVar2);
                objR6 = jVar2;
            }
            tlydtdl.compose.runtime.a0.g(p0Var, m0Var, numValueOf, (Function2) objR6, sVar);
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a2.b1(i, 2, aVar, aVar2, pVar);
        }
    }

    public static final void j(an0.e eVar, kd1.g gVar, a80.d dVar, m mVar, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-976802059);
        int i2 = i | (sVar.g(eVar) ? 4 : 2) | (sVar.g(gVar) ? 32 : 16) | (sVar.g(dVar) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            p pVarO = com.facebook.appevents.l.o(o2.f(o2.e(t3.m.a, 1.0f), 56), i.e(2131100890, 0, sVar, r.Companion), w0.a);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarO);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            tf1.s.b(gVar, (p) null, (Function0) null, tf1.d.f, 0L, 0.0f, 0.0f, 0.0f, (r) null, (r) null, (t5.g0) null, 0, q3.p.d(-1905123878, new a00.c(14, eVar, dVar), sVar), sVar, ((i2 >> 3) & 14) | 3072, 384, 4086);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new j3(i, 2, eVar, gVar, dVar);
        }
    }

    public static final void k(an0.a aVar, p2 p2Var, a80.d dVar, m mVar, int i) {
        an0.a aVar2;
        boolean z;
        an0.e eVar = aVar.f;
        o.h(p2Var, "hideKeyboardEvent");
        o.h(dVar, "actions");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-810644283);
        int i2 = i | (sVar.i(aVar) ? 4 : 2) | (sVar.i(p2Var) ? 32 : 16) | (sVar.g(dVar) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            t2 t2Var = (t2) sVar.k(r1.p);
            boolean zG = sVar.g(t2Var);
            Object objR = sVar.R();
            if (zG || objR == tlydtdl.compose.runtime.l.a) {
                objR = new a21.v(t2Var, (qx1.d) null, 1);
                sVar.q0(objR);
            }
            int i3 = i2 >> 3;
            md1.g.A(p2Var, (Function2) objR, sVar, i3 & 14);
            t3.m mVar2 = t3.m.a;
            p pVarV = md1.g.V(o2.d(mVar2, 1.0f));
            tlydtdl.compose.foundation.layout.e0 e0VarA = tlydtdl.compose.foundation.layout.c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarV);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            s4.i iVar = s4.k.f435f;
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, iVar);
            s4.i iVar2 = s4.k.e;
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, iVar2);
            s4.i iVar3 = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar3);
            }
            s4.i iVar4 = s4.k.d;
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, iVar4);
            if (1.0f <= 0.0d) {
                e2.a.a("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode2 = Long.hashCode(sVar.T);
            tlydtdl.compose.runtime.u1 u1VarM2 = sVar.m();
            p pVarX2 = j4.x(sVar, layoutWeightElement);
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, iVar);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM2, iVar2);
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode2))) {
                i.x(iHashCode2, sVar, iHashCode2, iVar3);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX2, iVar4);
            float f2 = 16;
            boolean z2 = eVar instanceof an0.e;
            int i4 = i2 & 14;
            aVar2 = aVar;
            i(aVar2, (xr0.a) dVar.a, tlydtdl.compose.foundation.layout.m.G(o2.d(mVar2, 1.0f), f2, f2, f2, z2 ? 0 : 24), sVar, i4);
            if (aVar2.e) {
                sVar.f0(-2141650941);
                g(aVar2, dVar, tlydtdl.compose.foundation.layout.x.a.b(tlydtdl.compose.foundation.layout.m.D(mVar2, f2), t3.c.i), sVar, (i3 & 112) | i4);
                z = false;
            } else {
                z = false;
                sVar.f0(-2145489671);
            }
            sVar.r(z);
            sVar.r(true);
            if (z2) {
                sVar.f0(1643018364);
                j(eVar, aVar2.g, dVar, sVar, i2 & 896);
            } else {
                sVar.f0(1638807603);
            }
            sVar.r(z);
            sVar.r(true);
            h(aVar2, dVar, sVar, (i3 & 112) | i4);
        } else {
            aVar2 = aVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a2.b1(i, 1, aVar2, p2Var, dVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(bb.b1 r23, of1.n r24, ld1.r r25, tlydtdl.compose.runtime.m r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.e.l(bb.b1, of1.n, ld1.r, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void m(eh0.g gVar, Function0 function0, Function0 function02, m mVar, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-34964322);
        int i2 = i | (sVar.i(gVar) ? 4 : 2) | (sVar.i(function0) ? 32 : 16) | (sVar.i(function02) ? 256 : 128);
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = tlydtdl.compose.runtime.a0.n(sVar);
                sVar.q0(objR);
            }
            a0 a0Var = (a0) objR;
            Object objR2 = sVar.R();
            qx1.d dVar = null;
            if (objR2 == x0Var) {
                objR2 = new uu0.b(tlydtdl.compose.runtime.a0.t(null), a0Var);
                sVar.q0(objR2);
            }
            uu0.b bVar = (uu0.b) objR2;
            boolean z = gVar.d;
            x10.r rVar = gVar.b;
            v vVar = gVar.c;
            eh0.e eVar = eh0.e.a;
            uu0.a aVar = new uu0.a(rVar, vVar, z, o81.b.e, function0, function02);
            bVar.getClass();
            t1 t1Var = bVar.c;
            if (t1Var != null) {
                t1Var.a((CancellationException) null);
            }
            bVar.c = c0.F(bVar.b, (qx1.i) null, (b0) null, new sm.a(bVar, aVar, dVar, 15), 3);
            hs1.d.a(bVar, o2.y(o2.e(t3.m.a, 1.0f), null, 3), (Function1) null, sVar, 48);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new a2.b1(i, 17, gVar, function0, function02);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(c51.j r26, t3.p r27, float r28, tlydtdl.compose.foundation.layout.e2 r29, tlydtdl.compose.runtime.m r30, int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.e.n(c51.j, t3.p, float, tlydtdl.compose.foundation.layout.e2, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void o(dg1.g gVar, boolean z, Function0 function0, m mVar, int i) {
        int i2;
        o.h(function0, "onClick");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-1113562126);
        int i3 = i & 6;
        n2 n2Var = n2.a;
        if (i3 == 0) {
            i2 = (sVar.g(n2Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(gVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.h(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar.i(function0) ? 2048 : 1024;
        }
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            rd1.n nVar = rd1.n.a;
            rd1.a0.a.getClass();
            com.facebook.appevents.h.c(gVar, nVar, rd1.w.b, n2Var.a(1.0f, t3.m.a, true), z, true, function0, sVar, ((i2 >> 3) & 14) | 1572864 | (57344 & (i2 << 6)) | ((i2 << 12) & 29360128), 32);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new m2.g0(gVar, z, function0, i, 3);
        }
    }

    public static final void p(eh0.i iVar, m mVar, int i) throws NoWhenBranchMatchedException {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1184077441);
        int i2 = (sVar.i(iVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            ny1.r2 r2Var = ((n8) iVar).e;
            y yVar = y.a;
            eh0.h hVar = (eh0.h) st.w0.r(r2Var, sVar, 384, 5).getValue();
            if (hVar instanceof eh0.f) {
                sVar.f0(-267905403);
                sVar.r(false);
            } else {
                if (!(hVar instanceof eh0.g)) {
                    throw com.ironsource.adqualitysdk.sdk.i.a0.q(sVar, -267906465, false);
                }
                sVar.f0(284907990);
                boolean zI = sVar.i(iVar) | sVar.i(hVar);
                Object objR = sVar.R();
                x0 x0Var = tlydtdl.compose.runtime.l.a;
                if (zI || objR == x0Var) {
                    objR = new t1.d(7, iVar, (eh0.g) hVar);
                    sVar.q0(objR);
                }
                Function0 function0 = (Function0) objR;
                boolean zI2 = sVar.i(iVar) | sVar.i(hVar);
                Object objR2 = sVar.R();
                if (zI2 || objR2 == x0Var) {
                    objR2 = new sf1.h(iVar, (eh0.g) hVar);
                    sVar.q0(objR2);
                }
                m((eh0.g) hVar, function0, (Function0) objR2, sVar, 0);
                sVar.r(false);
            }
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new uc0.b(iVar, i, 4);
        }
    }

    public static final boolean q(List list) {
        o.h(list, "<this>");
        if (list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((d10.b) it.next()).b != d10.c.a) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object r(my1.y r4, lmjxuqdtp.jvm.functions.Function0 r5, qx1.d r6) {
        /*
            boolean r0 = r6 instanceof my1.w
            if (r0 == 0) goto L13
            r0 = r6
            my1.w r0 = (my1.w) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            my1.w r0 = new my1.w
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            lmjxuqdtp.jvm.functions.Function0 r5 = r0.j
            O(r6)     // Catch: java.lang.Throwable -> L29
            goto L64
        L29:
            r4 = move-exception
            goto L6a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            O(r6)
            qx1.i r6 = r0.getContext()
            ky1.e1 r2 = ky1.e1.a
            qx1.g r6 = r6.get(r2)
            if (r6 != r4) goto L6e
            r0.j = r5     // Catch: java.lang.Throwable -> L29
            r0.l = r3     // Catch: java.lang.Throwable -> L29
            ky1.m r6 = new ky1.m     // Catch: java.lang.Throwable -> L29
            qx1.d r0 = di0.z.C(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.s()     // Catch: java.lang.Throwable -> L29
            ds0.f r0 = new ds0.f     // Catch: java.lang.Throwable -> L29
            r2 = 5
            r0.<init>(r2, r6)     // Catch: java.lang.Throwable -> L29
            my1.q r4 = (my1.q) r4     // Catch: java.lang.Throwable -> L29
            r4.i0(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.q()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L64
            return r1
        L64:
            r5.invoke()
            lx1.b0 r4 = lx1.b0.a
            return r4
        L6a:
            r5.invoke()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.e.r(my1.y, lmjxuqdtp.jvm.functions.Function0, qx1.d):java.lang.Object");
    }

    public static boolean s(Context context) {
        if (!a && b == null) {
            m80.b bVarH = m80.b.h(context);
            if (bVarH.n(4)) {
                Boolean boolJ = bVarH.j();
                a = boolJ != null ? boolJ.booleanValue() : false;
            } else {
                boolean z = a;
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle == null || !bundle.containsKey("io.branch.sdk.TestMode")) {
                        Resources resources = context.getResources();
                        z = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
                    } else {
                        z = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
                    }
                } catch (Exception unused) {
                }
                a = z;
            }
            b = Boolean.valueOf(a);
        }
        return a;
    }

    public static yt.a t(iw1.b bVar) {
        o.h(bVar, "context");
        return new yt.a(bVar, 21);
    }

    public static final lx1.n u(Throwable th) {
        o.h(th, "exception");
        return new lx1.n(th);
    }

    public static final boolean v(long j2, long j3) {
        return j2 == j3;
    }

    public static e0 w(String str) {
        o.h(str, "<this>");
        hy1.l lVarD = e0.e.d(0, str);
        if (lVarD == null) {
            throw new IllegalArgumentException(o6.c.i('\"', "No subtype found for: \"", str));
        }
        String str2 = (String) lVarD.a().get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        o.g(lowerCase, "toLowerCase(...)");
        String lowerCase2 = ((String) lVarD.a().get(2)).toLowerCase(locale);
        o.g(lowerCase2, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        int i = ((ey1.i) lVarD.b()).b;
        while (true) {
            int i2 = i + 1;
            if (i2 >= str.length()) {
                return new e0(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            hy1.l lVarD2 = e0.f.d(i2, str);
            if (lVarD2 == null) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(i2);
                o.g(strSubstring, "substring(...)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                throw new IllegalArgumentException(i.o(sb, str, '\"').toString());
            }
            hy1.k kVar = lVarD2.c;
            hy1.i iVarD = kVar.d(1);
            String str3 = iVarD != null ? iVarD.a : null;
            if (str3 == null) {
                i = ((ey1.i) lVarD2.b()).b;
            } else {
                hy1.i iVarD2 = kVar.d(2);
                String strSubstring2 = iVarD2 != null ? iVarD2.a : null;
                if (strSubstring2 == null) {
                    hy1.i iVarD3 = kVar.d(3);
                    o.e(iVarD3);
                    strSubstring2 = iVarD3.a;
                } else if (hy1.q.b1(strSubstring2, '\'') && hy1.q.C0(strSubstring2, '\'') && strSubstring2.length() > 2) {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                    o.g(strSubstring2, "substring(...)");
                }
                arrayList.add(str3);
                arrayList.add(strSubstring2);
                i = ((ey1.i) lVarD2.b()).b;
            }
        }
    }

    public static boolean x(Context context) {
        Boolean boolValueOf;
        m80.b bVarH = m80.b.h(context);
        if (((JSONObject) bVarH.b) == null) {
            return false;
        }
        Boolean bool = Boolean.TRUE;
        if (bVarH.n(6)) {
            try {
                boolValueOf = Boolean.valueOf(((JSONObject) bVarH.b).getBoolean("deferInitForPluginRuntime"));
            } catch (JSONException e) {
                Log.e("BranchJsonConfig", "Error parsing branch.json: " + e.getMessage());
                boolValueOf = Boolean.FALSE;
            }
        } else {
            boolValueOf = null;
        }
        return bool.equals(boolValueOf);
    }

    public static boolean y(Context context) {
        Boolean boolValueOf;
        m80.b bVarH = m80.b.h(context);
        if (((JSONObject) bVarH.b) == null) {
            return false;
        }
        Boolean bool = Boolean.TRUE;
        if (bVarH.n(5)) {
            try {
                boolValueOf = Boolean.valueOf(((JSONObject) bVarH.b).getBoolean("enableLogging"));
            } catch (JSONException e) {
                Log.e("BranchJsonConfig", "Error parsing branch.json: " + e.getMessage());
                boolValueOf = Boolean.FALSE;
            }
        } else {
            boolValueOf = null;
        }
        return bool.equals(boolValueOf);
    }

    public static final d10.b z(Activity activity, String str, Integer num) {
        return (num != null ? num.intValue() : f6.a.a(activity, str)) == 0 ? new d10.b(str, d10.c.a) : tlydtdl.core.app.b.g(activity, str) ? new d10.b(str, d10.c.b) : new d10.b(str, d10.c.c);
    }
}
