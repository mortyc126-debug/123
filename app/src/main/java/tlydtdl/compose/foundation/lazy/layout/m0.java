package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.text.SpannableStringBuilder;
import com.braze.storage.ICardStorageProvider;
import com.facebook.appevents.p;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import i5.w;
import i5.x;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.z;
import ny1.r2;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import q4.c2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.f3;
import tlydtdl.fragment.app.FragmentActivity;
import zi.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m0 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ m0(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj) throws NoWhenBranchMatchedException {
        Object obj2;
        nc0.j mVar;
        switch (this.a) {
            case 0:
                z0 z0Var = (z0) this.b;
                z0Var.c = new q1((g0) this.c, (c2) this.d, (s1) this.e);
                return new e0(1, z0Var);
            case 1:
                String str = (String) this.b;
                String str2 = (String) this.c;
                d31.a aVar = (d31.a) this.d;
                c31.d dVar = (c31.d) this.e;
                rd.h hVar = (rd.h) obj;
                o.h(hVar, "$this$execute");
                hVar.k(0, str);
                hVar.k(1, str2);
                hVar.k(2, (String) ((y30.a) ((ru1.c) dVar.b).b).b(aVar));
                return lx1.b0.a;
            case 2:
                cc.g gVar = (cc.g) this.b;
                lx1.b0 b0Var = (bv0.b) this.c;
                id1.a aVar2 = (id1.a) this.d;
                FragmentActivity fragmentActivity = (FragmentActivity) this.e;
                o.h((b8.c) obj, "$this$viewModel");
                o.h(gVar, "<this>");
                i iVar = new i(gVar);
                String strC0 = p.c0();
                if (!(aVar2 instanceof id1.c)) {
                    b0Var = null;
                }
                if (b0Var == null) {
                    b0Var = lx1.b0.a;
                }
                return new fv0.b(st.w0.z(aVar2, strC0, b0Var, fragmentActivity, gVar, iVar).a());
            case 3:
                m10.r rVar = (m10.r) this.b;
                zi.c cVar = (zi.c) ((dd.b) this.c).b;
                Function1 function1 = (Function1) this.d;
                Function1 function12 = (Function1) this.e;
                cd0.c cVar2 = (cd0.c) obj;
                o.h(cVar2, "$this$spannableText");
                SpannableStringBuilder spannableStringBuilder = cVar2.a;
                if (rVar != null) {
                    String str3 = rVar.b;
                    String str4 = rVar.e;
                    if (str4 != null && !hy1.q.L0(str4) && !hy1.q.L0(str3)) {
                        spannableStringBuilder.append(cd0.c.b(cd0.c.b(cVar.e(2132019965, str3, str4), ct1.b.B(new cd0.a(0, new g20.a(function1, rVar, 0))), str3), ct1.b.B(new cd0.a(0, new g20.a(function12, rVar, 1))), str4));
                    } else if (str4 == null || hy1.q.L0(str4)) {
                        long j2 = rVar.a;
                        if (j2 > 0) {
                            int i = (int) j2;
                            String strC = cVar.c(2131886097, i, Integer.valueOf(i));
                            cd0.c.a(cVar2, str3, new g20.a(function1, rVar, 3));
                            String strConcat = " + ".concat(strC);
                            o.h(strConcat, "content");
                            spannableStringBuilder.append(strConcat);
                        } else {
                            cd0.c.a(cVar2, str3, new g20.a(function1, rVar, 4));
                        }
                    } else {
                        cd0.c.a(cVar2, str4, new g20.a(function12, rVar, 2));
                    }
                }
                return lx1.b0.a;
            case 4:
                Set set = (Set) this.b;
                Object obj3 = this.c;
                Set set2 = (Set) this.d;
                e1 e1Var = (e1) this.e;
                set.add(obj3);
                return new hb.c(set, obj3, set2, e1Var);
            case 5:
                iu1.h hVar2 = (iu1.h) this.b;
                String str5 = (String) this.c;
                String str6 = (String) this.d;
                o7.f fVar = (o7.f) this.e;
                o7.b bVar = (o7.b) obj;
                if (((String) uz1.g.u(bVar, iu1.h.d, HttpUrl.FRAGMENT_ENCODE_SET)).equals(str5)) {
                    o7.f fVarC = hVar2.c(bVar, str5);
                    if (fVarC != null && !fVarC.a.equals(str6)) {
                        synchronized (hVar2) {
                            hVar2.d(bVar, str5);
                            HashSet hashSet = new HashSet((Collection) uz1.g.u(bVar, fVar, new HashSet()));
                            hashSet.add(str5);
                            bVar.g(fVar, hashSet);
                        }
                    }
                    return null;
                }
                o7.f fVar2 = iu1.h.c;
                long jLongValue = ((Long) uz1.g.u(bVar, fVar2, 0L)).longValue();
                if (jLongValue + 1 == 30) {
                    synchronized (hVar2) {
                        try {
                            long jLongValue2 = ((Long) uz1.g.u(bVar, fVar2, 0L)).longValue();
                            String str7 = HttpUrl.FRAGMENT_ENCODE_SET;
                            Set hashSet2 = new HashSet();
                            String str8 = null;
                            for (Map.Entry entry : bVar.a().entrySet()) {
                                if (entry.getValue() instanceof Set) {
                                    Set<String> set3 = (Set) entry.getValue();
                                    for (String str9 : set3) {
                                        if (str8 == null || str8.compareTo(str9) > 0) {
                                            str7 = ((o7.f) entry.getKey()).a;
                                            str8 = str9;
                                            hashSet2 = set3;
                                        }
                                    }
                                }
                            }
                            obj2 = null;
                            HashSet hashSet3 = new HashSet(hashSet2);
                            hashSet3.remove(str8);
                            bVar.g(un0.m.y0(str7), hashSet3);
                            jLongValue = jLongValue2 - 1;
                            bVar.f(iu1.h.c, Long.valueOf(jLongValue));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else {
                    obj2 = null;
                }
                HashSet hashSet4 = new HashSet((Collection) uz1.g.u(bVar, fVar, new HashSet()));
                hashSet4.add(str5);
                bVar.g(fVar, hashSet4);
                bVar.f(iu1.h.c, Long.valueOf(jLongValue + 1));
                bVar.f(iu1.h.d, str5);
                return obj2;
            case 6:
                m2.n1 n1Var = (m2.n1) this.b;
                x xVar = (x) this.c;
                w wVar = (w) this.d;
                i5.k kVar = (i5.k) this.e;
                if (n1Var.b()) {
                    n1Var.e = tlydtdl.compose.runtime.b.W(xVar, wVar, n1Var.d, kVar, n1Var.v, n1Var.w);
                }
                return new m2.v0();
            case 7:
                js0.t tVar = (js0.t) this.b;
                String str10 = (String) this.c;
                lmjxuqdtp.time.l lVar = (lmjxuqdtp.time.l) this.d;
                m80.b bVar2 = (m80.b) ((c31.d) this.e).b;
                rd.h hVar3 = (rd.h) obj;
                o.h(hVar3, "$this$execute");
                String str11 = null;
                hVar3.k(0, tVar != null ? (String) ((nd.a) bVar2.b).b(tVar) : null);
                hVar3.k(1, str10);
                if (lVar != null) {
                    bVar2.getClass();
                    str11 = j4.M(lVar).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    o.g(str11, "format(...)");
                }
                hVar3.k(2, str11);
                return lx1.b0.a;
            case 8:
                Function2 function2 = (Function2) this.b;
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.c;
                ArrayList arrayList = (ArrayList) this.d;
                Function2 function22 = (Function2) this.e;
                nc0.i iVar2 = (nc0.n) obj;
                o.h(iVar2, "listManagerState");
                List listB = iVar2.b();
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                for (Object obj4 : listB) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        ct1.b.X();
                        throw null;
                    }
                    Object objInvoke = function2.invoke(obj4, iVar2.b());
                    Object objInvoke2 = linkedHashMap.get(objInvoke);
                    if (objInvoke2 == null) {
                        objInvoke2 = function22.invoke(obj4, iVar2.b());
                        linkedHashMap.put(objInvoke, objInvoke2);
                    }
                    if (objInvoke2 != null) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                    if (objInvoke2 != null) {
                        arrayList2.add(objInvoke2);
                    }
                    i2 = i3;
                }
                if (iVar2 instanceof nc0.i) {
                    nc0.i iVar3 = iVar2;
                    return new nc0.i(arrayList2, iVar3.b, iVar3.c, iVar3.d, 16);
                }
                if (iVar2 instanceof nc0.j) {
                    mVar = new nc0.j(((nc0.j) iVar2).a, arrayList2);
                } else {
                    if (iVar2 instanceof nc0.k) {
                        return iVar2;
                    }
                    if (iVar2 instanceof nc0.l) {
                        mVar = new nc0.l(arrayList2);
                    } else {
                        if (!(iVar2 instanceof nc0.m)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        mVar = new nc0.m(arrayList2, ((nc0.m) iVar2).b);
                    }
                }
                return mVar;
            case 9:
                p81.d dVar2 = (p81.d) this.b;
                p81.f fVar3 = (p81.f) this.c;
                o81.c cVar3 = (o81.c) this.d;
                r2 r2Var = (r2) this.e;
                int iOrdinal = ((p81.a) obj).ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        dVar2.a = null;
                    } else if (fVar3.m(cVar3)) {
                        z10.d.G(r2Var);
                    } else {
                        cVar3.b();
                    }
                } else if (!fVar3.m(cVar3)) {
                    cVar3.b();
                }
                r2 r2Var2 = fVar3.c;
                Boolean boolValueOf = Boolean.valueOf(fVar3.m((o81.c) null));
                r2Var2.getClass();
                r2Var2.i((Object) null, boolValueOf);
                return lx1.b0.a;
            case 10:
                return com.braze.vmsrhfaqrb.h.a((com.braze.managers.h0) this.b, (ICardStorageProvider) this.c, (com.braze.analytics.b) this.d, (JSONArray) this.e, obj);
            case 11:
                t1.b bVar3 = (t1.b) this.b;
                t1.k kVar2 = (t1.k) this.c;
                Function1 function13 = (Function1) this.d;
                lmjxuqdtp.jvm.internal.y yVar = (lmjxuqdtp.jvm.internal.y) this.e;
                t1.i iVar4 = (t1.i) obj;
                t1.k kVar3 = bVar3.c;
                t1.c.u(iVar4, kVar3);
                tlydtdl.compose.runtime.n1 n1Var2 = iVar4.e;
                Object objC = bVar3.c(n1Var2.getValue());
                if (!o.c(objC, n1Var2.getValue())) {
                    kVar3.b.setValue(objC);
                    kVar2.b.setValue(objC);
                    if (function13 != null) {
                        function13.invoke(bVar3);
                    }
                    iVar4.a();
                    yVar.a = true;
                } else if (function13 != null) {
                    function13.invoke(bVar3);
                }
                return lx1.b0.a;
            case 12:
                e1 e1Var2 = (e1) this.b;
                t1.h0 h0Var = (t1.h0) this.c;
                z zVar = (z) this.d;
                ky1.a0 a0Var = (ky1.a0) this.e;
                long jLongValue3 = ((Long) obj).longValue();
                f3 f3Var = (f3) e1Var2.getValue();
                long jLongValue4 = f3Var != null ? ((Number) f3Var.getValue()).longValue() : jLongValue3;
                long j3 = h0Var.c;
                k3.e eVar = h0Var.a;
                if (j3 == Long.MIN_VALUE || zVar.a != t1.c.p(a0Var.getCoroutineContext())) {
                    h0Var.c = jLongValue3;
                    Object[] objArr = eVar.a;
                    int i4 = eVar.c;
                    for (int i6 = 0; i6 < i4; i6++) {
                        ((t1.f0) objArr[i6]).g = true;
                    }
                    zVar.a = t1.c.p(a0Var.getCoroutineContext());
                }
                float f2 = zVar.a;
                if (f2 == 0.0f) {
                    Object[] objArr2 = eVar.a;
                    int i7 = eVar.c;
                    for (int i8 = 0; i8 < i7; i8++) {
                        t1.f0 f0Var = (t1.f0) objArr2[i8];
                        f0Var.d.setValue(f0Var.e.c);
                        f0Var.g = true;
                    }
                } else {
                    long j4 = (long) ((jLongValue4 - h0Var.c) / f2);
                    Object[] objArr3 = eVar.a;
                    int i9 = eVar.c;
                    boolean z = true;
                    for (int i10 = 0; i10 < i9; i10++) {
                        t1.f0 f0Var2 = (t1.f0) objArr3[i10];
                        if (!f0Var2.f) {
                            f0Var2.i.b.setValue(Boolean.FALSE);
                            if (f0Var2.g) {
                                f0Var2.g = false;
                                f0Var2.h = j4;
                            }
                            long j5 = j4 - f0Var2.h;
                            f0Var2.d.setValue(f0Var2.e.f(j5));
                            f0Var2.f = f0Var2.e.c(j5);
                        }
                        if (!f0Var2.f) {
                            z = false;
                        }
                    }
                    h0Var.d.setValue(Boolean.valueOf(!z));
                }
                return lx1.b0.a;
            case 13:
                String str12 = (String) this.b;
                String str13 = (String) this.c;
                m10.w wVar2 = (m10.w) this.d;
                w90.b bVar4 = (w90.b) this.e;
                of1.j jVar = (of1.j) obj;
                o.h(jVar, "$this$withPointerInput");
                jVar.b(str12, new u51.d0(11, wVar2, bVar4));
                if (str13 != null) {
                    jVar.b(str13, new vq.b(12, bVar4));
                }
                return lx1.b0.a;
            default:
                f3 f3Var2 = (f3) this.b;
                y1.l lVar2 = (y1.l) this.c;
                Function2 function23 = (Function2) this.d;
                x2.y yVar2 = (x2.y) this.e;
                y1.g gVar2 = (y1.g) obj;
                int i11 = ((m2.r1) f3Var2.getValue()).a;
                com.facebook.appevents.h.f(gVar2, lVar2, function23, yVar2, m2.u1.d, (i11 & 4) == 4);
                com.facebook.appevents.h.f(gVar2, lVar2, function23, yVar2, m2.u1.e, (i11 & 1) == 1);
                com.facebook.appevents.h.f(gVar2, lVar2, function23, yVar2, m2.u1.f, (i11 & 2) == 2);
                com.facebook.appevents.h.f(gVar2, lVar2, function23, yVar2, m2.u1.g, (i11 & 8) == 8);
                com.facebook.appevents.h.f(gVar2, lVar2, function23, yVar2, m2.u1.h, (i11 & 16) == 16);
                return lx1.b0.a;
        }
    }
}
