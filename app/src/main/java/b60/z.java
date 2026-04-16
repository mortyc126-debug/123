package b60;

import amuvvoafs.content.Context;
import amuvvoafs.net.Uri;
import amuvvoafs.text.TextUtils;
import amuvvoafs.util.Log;
import bb.z0;
import bn1.c;
import com.gnacba.amuvvoafs.gms.ads.internal.util.client.zzo;
import com.gnacba.amuvvoafs.gms.ads.internal.util.zzs;
import com.gnacba.amuvvoafs.gms.ads.internal.zzt;
import com.gnacba.amuvvoafs.gms.internal.ads.e70;
import com.gnacba.amuvvoafs.gms.internal.ads.ev0;
import com.gnacba.amuvvoafs.gms.internal.ads.fz1;
import com.gnacba.amuvvoafs.gms.internal.ads.gd1;
import com.gnacba.amuvvoafs.gms.internal.ads.ia1;
import com.gnacba.amuvvoafs.gms.internal.ads.ko0;
import com.gnacba.amuvvoafs.gms.internal.ads.m70;
import com.gnacba.amuvvoafs.gms.internal.ads.om0;
import com.gnacba.amuvvoafs.gms.internal.ads.wj;
import com.gnacba.amuvvoafs.gms.internal.ads.xu0;
import com.gnacba.amuvvoafs.gms.internal.ads.yj;
import com.gnacba.amuvvoafs.gms.internal.ads.yx0;
import com.gnacba.amuvvoafs.gms.internal.ads.zzdzv;
import dl.f;
import f3.f2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import jv0.p;
import k1.s;
import lmjxuqdtp.NoWhenBranchMatchedException;
import no1.g0;
import no1.h0;
import no1.j0;
import no1.v;
import okhttp3.HttpUrl;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import po1.d;
import tlydtdl.compose.foundation.lazy.layout.r1;
import uo1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f24f;
    public Object g;
    public Object h;
    public Object i;

    public /* synthetic */ z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f24f = obj6;
        this.g = obj7;
        this.h = obj8;
        this.i = obj9;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(b60.z r28, bm.c r29, k61.q r30, sx1.c r31) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b60.z.a(b60.z, bm.c, k61.q, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static final e b(z zVar, p pVar, List list) throws NoWhenBranchMatchedException {
        g gVar;
        int i = pVar == null ? -1 : p.$EnumSwitchMapping$0[pVar.ordinal()];
        if (i == -1) {
            gVar = g.b;
        } else if (i == 1) {
            gVar = g.d;
        } else if (i == 2) {
            gVar = g.e;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            gVar = g.c;
        }
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((e) next).a() == gVar) {
                obj = next;
                break;
            }
        }
        return (e) obj;
    }

    public static void g(String str, JSONObject jSONObject) {
        StringBuilder sbQ = i.q(str);
        sbQ.append(jSONObject.toString());
        String string = sbQ.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", string, (Throwable) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(yk.h r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof zl.b
            if (r0 == 0) goto L13
            r0 = r8
            zl.b r0 = (zl.b) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            zl.b r0 = new zl.b
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            lg.e.O(r8)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            goto L4b
        L27:
            r7 = move-exception
            goto L4e
        L29:
            r7 = move-exception
            goto L54
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            lg.e.O(r8)
            java.lang.Object r8 = r6.a     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            bm.e r8 = (bm.e) r8     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            lf.y r2 = new lf.y     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            r4 = 22
            r5 = 0
            r2.<init>(r6, r7, r5, r4)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            r0.l = r3     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            java.lang.Object r8 = r8.a(r2, r0)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            if (r8 != r1) goto L4b
            return r1
        L4b:
            yk.k r8 = (yk.k) r8     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29
            return r8
        L4e:
            yk.i r8 = new yk.i
            r8.<init>(r7)
            return r8
        L54:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b60.z.c(yk.h, sx1.c):java.lang.Object");
    }

    public xt1.a d(int i) throws Throwable {
        xt1.a aVar = null;
        try {
            if (!z.p.b(2, i)) {
                JSONObject jSONObjectE = ((f) this.e).e();
                if (jSONObjectE != null) {
                    xt1.a aVarT = ((vp1.b) this.c).t(jSONObjectE);
                    g("Loaded cached settings: ", jSONObjectE);
                    ((gm.t) this.d).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (z.p.b(3, i) || aVarT.c >= jCurrentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", (Throwable) null);
                            }
                            return aVarT;
                        } catch (Exception e) {
                            e = e;
                            aVar = aVarT;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return aVar;
                        }
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Cached settings have expired.", (Throwable) null);
                        return null;
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", (Throwable) null);
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public xt1.a e() {
        return (xt1.a) ((AtomicReference) this.h).get();
    }

    public void f(oo1.i iVar, int i) {
        byte[] bArr;
        long j2;
        vo1.j jVar;
        mo1.b bVar;
        po1.a aVar;
        String str;
        po1.a aVar2;
        int i2;
        fz1 fz1VarF;
        String str2;
        Integer numValueOf;
        Iterator it;
        vo1.j jVar2;
        mo1.b bVar2;
        no1.n nVar;
        z zVar;
        z zVar2 = this;
        oo1.i iVar2 = iVar;
        byte[] bArr2 = iVar2.b;
        vo1.j jVar3 = (wo1.b) zVar2.f24f;
        mo1.b bVarA = ((d) zVar2.b).a(iVar2.a);
        long jMax = 0;
        while (true) {
            vo1.j jVar4 = jVar3;
            if (!((Boolean) jVar4.j(new e(zVar2, iVar2, 0))).booleanValue()) {
                jVar4.j(new mt1.b(zVar2, iVar2, jMax));
                return;
            }
            Iterable iterable = (Iterable) jVar4.j(new e(zVar2, iVar2, 1));
            if (!iterable.iterator().hasNext()) {
                return;
            }
            if (bVarA == null) {
                c.q("Uploader", iVar2, "Unknown backend for %s, deleting event batch for it...");
                aVar2 = new po1.a(3, -1L);
                bArr = bArr2;
                j2 = jMax;
                jVar = jVar3;
                bVar = bVarA;
            } else {
                ArrayList<oo1.h> arrayList = new ArrayList();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((vo1.b) it2.next()).c);
                }
                if (bArr2 != null) {
                    vo1.c cVar = (vo1.c) zVar2.i;
                    Objects.requireNonNull(cVar);
                    ro1.a aVar3 = (ro1.a) jVar4.j(new z0(21, cVar));
                    dl.c cVar2 = new dl.c();
                    cVar2.g = new HashMap();
                    cVar2.e = Long.valueOf(((xo1.a) zVar2.g).c());
                    cVar2.f89f = Long.valueOf(((xo1.a) zVar2.h).c());
                    cVar2.b = "GDT_CLIENT_METRICS";
                    lo1.c cVar3 = new lo1.c("proto");
                    aVar3.getClass();
                    r1 r1Var = oo1.n.a;
                    r1Var.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        r1Var.i(aVar3, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    cVar2.d = new oo1.l(cVar3, byteArrayOutputStream.toByteArray());
                    arrayList.add(bVarA.a(cVar2.m()));
                }
                mo1.b bVar3 = bVarA;
                HashMap map = new HashMap();
                for (oo1.h hVar : arrayList) {
                    String str3 = hVar.a;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(hVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(hVar);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = map.entrySet().iterator();
                while (it3.hasNext()) {
                    Map.Entry entry = (Map.Entry) it3.next();
                    oo1.h hVar2 = (oo1.h) ((List) entry.getValue()).get(0);
                    j0 j0Var = j0.a;
                    long jC = bVar3.f.c();
                    long jC2 = bVar3.e.c();
                    no1.n nVar2 = new no1.n(new no1.l(Integer.valueOf(hVar2.b("sdk-version")), hVar2.a("model"), hVar2.a("hardware"), hVar2.a("device"), hVar2.a("product"), hVar2.a("os-uild"), hVar2.a("manufacturer"), hVar2.a("fingerprint"), hVar2.a("locale"), hVar2.a("country"), hVar2.a("mcc_mnc"), hVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused2) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it4 = ((List) entry.getValue()).iterator();
                    while (it4.hasNext()) {
                        Iterator it5 = it3;
                        oo1.h hVar3 = (oo1.h) it4.next();
                        byte[] bArr3 = bArr2;
                        oo1.l lVar = hVar3.c;
                        lo1.c cVar4 = lVar.a;
                        byte[] bArr4 = lVar.b;
                        long j3 = jMax;
                        if (cVar4.equals(new lo1.c("proto"))) {
                            zVar = new z();
                            zVar.e = bArr4;
                        } else if (cVar4.equals(new lo1.c("json"))) {
                            String str4 = new String(bArr4, Charset.forName(HTTP.UTF_8));
                            z zVar3 = new z();
                            zVar3.f24f = str4;
                            zVar = zVar3;
                        } else {
                            it = it4;
                            jVar2 = jVar3;
                            bVar2 = bVarA;
                            nVar = nVar2;
                            String strConcat = "TRuntime.".concat("CctTransportBackend");
                            if (Log.isLoggable(strConcat, 5)) {
                                Log.w(strConcat, "Received event of unsupported encoding " + cVar4 + ". Skipping...");
                            }
                            it4 = it;
                            nVar2 = nVar;
                            it3 = it5;
                            bArr2 = bArr3;
                            jMax = j3;
                            jVar3 = jVar2;
                            bVarA = bVar2;
                        }
                        byte[] bArr5 = hVar3.j;
                        zVar.a = Long.valueOf(hVar3.d);
                        zVar.d = Long.valueOf(hVar3.e);
                        String str5 = (String) hVar3.f.get("tz-offset");
                        zVar.g = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        it = it4;
                        zVar.h = new v((h0) h0.a.get(hVar3.b("net-type")), (g0) g0.a.get(hVar3.b("mobile-subtype")));
                        Integer num = hVar3.b;
                        if (num != null) {
                            zVar.b = num;
                        }
                        Integer num2 = hVar3.g;
                        if (num2 != null) {
                            s sVar = new s(28);
                            jVar2 = jVar3;
                            fo.n nVar3 = new fo.n(28);
                            bVar2 = bVarA;
                            nVar = nVar2;
                            h9.d dVar = new h9.d(23, false);
                            dVar.A(num2);
                            nVar3.F(dVar.t());
                            sVar.s(nVar3.q());
                            no1.z zVar4 = no1.z.a;
                            sVar.t();
                            zVar.c = sVar.a();
                        } else {
                            jVar2 = jVar3;
                            bVar2 = bVarA;
                            nVar = nVar2;
                        }
                        byte[] bArr6 = hVar3.i;
                        if (bArr6 != null || bArr5 != null) {
                            s sVar2 = new s(29);
                            if (bArr6 != null) {
                                sVar2.q(bArr6);
                            }
                            if (bArr5 != null) {
                                sVar2.r(bArr5);
                            }
                            zVar.i = sVar2.b();
                        }
                        String strC = ((Long) zVar.a) == null ? " eventTimeMs" : HttpUrl.FRAGMENT_ENCODE_SET;
                        if (((Long) zVar.d) == null) {
                            strC = strC.concat(" eventUptimeMs");
                        }
                        if (((Long) zVar.g) == null) {
                            strC = f2.C(strC, " timezoneOffsetSeconds");
                        }
                        if (!strC.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strC));
                        }
                        arrayList4.add(new no1.s(((Long) zVar.a).longValue(), (Integer) zVar.b, (no1.o) zVar.c, ((Long) zVar.d).longValue(), (byte[]) zVar.e, (String) zVar.f24f, ((Long) zVar.g).longValue(), (v) zVar.h, (no1.p) zVar.i));
                        it4 = it;
                        nVar2 = nVar;
                        it3 = it5;
                        bArr2 = bArr3;
                        jMax = j3;
                        jVar3 = jVar2;
                        bVarA = bVar2;
                    }
                    arrayList3.add(new no1.t(jC, jC2, nVar2, numValueOf, str2, arrayList4));
                    it3 = it3;
                }
                bArr = bArr2;
                j2 = jMax;
                jVar = jVar3;
                bVar = bVarA;
                no1.m mVar = new no1.m(arrayList3);
                URL urlB = bVar3.d;
                if (bArr != null) {
                    try {
                        mo1.a aVarA = mo1.a.a(bArr);
                        str = aVarA.b;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = aVarA.a;
                        if (str6 != null) {
                            urlB = mo1.b.b(str6);
                        }
                    } catch (IllegalArgumentException unused3) {
                        aVar = new po1.a(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    jx0.h hVar4 = new jx0.h(urlB, mVar, str, 11);
                    z0 z0Var = new z0(13, bVar3);
                    int i3 = 5;
                    do {
                        fz1VarF = z0Var.f(hVar4);
                        URL url = (URL) fz1VarF.c;
                        if (url != null) {
                            c.q("CctTransportBackend", url, "Following redirect to: %s");
                            hVar4 = new jx0.h(url, (no1.m) hVar4.c, (String) hVar4.d, 11);
                        } else {
                            hVar4 = null;
                        }
                        if (hVar4 == null) {
                            break;
                        } else {
                            i3--;
                        }
                    } while (i3 >= 1);
                    int i4 = fz1VarF.a;
                    if (i4 == 200) {
                        aVar2 = new po1.a(1, fz1VarF.b);
                    } else {
                        if (i4 >= 500 || i4 == 404) {
                            aVar = new po1.a(2, -1L);
                        } else if (i4 == 400) {
                            try {
                                aVar = new po1.a(4, -1L);
                            } catch (IOException e) {
                                e = e;
                                c.r(e, "CctTransportBackend", "Could not make request to the backend");
                                i2 = 2;
                                aVar2 = new po1.a(2, -1L);
                            }
                        } else {
                            aVar = new po1.a(3, -1L);
                        }
                        aVar2 = aVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            i2 = 2;
            int i6 = aVar2.a;
            if (i6 == i2) {
                jVar4.j(new uo1.f(this, iterable, iVar, j2));
                ((qu0.u) this.d).H(iVar, i + 1, true);
                return;
            }
            zVar2 = this;
            iVar2 = iVar;
            jMax = j2;
            jVar4.j(new bv1.a(8, zVar2, iterable));
            if (i6 == 1) {
                jMax = Math.max(jMax, aVar2.b);
                if (bArr != null) {
                    jVar4.j(new z0(22, zVar2));
                }
            } else if (i6 == 4) {
                HashMap map2 = new HashMap();
                Iterator it6 = iterable.iterator();
                while (it6.hasNext()) {
                    String str7 = ((vo1.b) it6.next()).c.a;
                    if (map2.containsKey(str7)) {
                        map2.put(str7, Integer.valueOf(((Integer) map2.get(str7)).intValue() + 1));
                    } else {
                        map2.put(str7, 1);
                    }
                }
                jVar4.j(new bv1.a(9, zVar2, map2));
            }
            bArr2 = bArr;
            jVar3 = jVar;
            bVarA = bVar;
        }
    }

    public LinkedHashMap h(LinkedHashMap linkedHashMap, Map map) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            String str3 = (String) linkedHashMap2.get(str);
            wj wjVar = (wj) ((HashMap) this.c).get(str);
            if (wjVar == null) {
                wjVar = wj.b;
            }
            linkedHashMap2.put(str, wjVar.a(str3, str2));
        }
        return linkedHashMap2;
    }

    public void i(xu0 xu0Var) {
        com.gnacba.common.util.concurrent.z zVarI;
        synchronized (this) {
            Iterator it = xu0Var.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zVarI = ia1.i(new zzdzv(3));
                    break;
                }
                om0 om0VarA = ((m70) this.c).a(xu0Var.b, (String) it.next());
                if (om0VarA != null && om0VarA.a((ev0) this.i, xu0Var)) {
                    zVarI = ia1.s(om0VarA.b((ev0) this.i, xu0Var), xu0Var.R, TimeUnit.MILLISECONDS, (ScheduledExecutorService) this.b);
                    break;
                }
            }
        }
        ((ko0) this.d).b((ev0) this.i, xu0Var, zVarI, (yx0) this.e);
        zVarI.addListener(new gd1(0, zVarI, new e70(this, xu0Var, false, 25)), (Executor) this.a);
    }

    public void j(LinkedHashMap linkedHashMap, yj yjVar) throws Throwable {
        Uri.Builder builderBuildUpon = Uri.parse((String) this.d).buildUpon();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (yjVar != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!TextUtils.isEmpty(yjVar.a())) {
                sb.append("&it=");
                sb.append(yjVar.a());
            }
            if (!TextUtils.isEmpty(yjVar.c())) {
                sb.append("&blat=");
                sb.append(yjVar.c());
            }
            string = sb.toString();
        }
        if (!((AtomicBoolean) this.h).get()) {
            zzt.zzc();
            zzs.zzP((Context) this.e, (String) this.f24f, string);
            return;
        }
        File file = (File) this.i;
        if (file == null) {
            zzo.zzi("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(string.getBytes());
                    fileOutputStream2.write(10);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    zzo.zzj("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    public z() {
        this.a = new ArrayBlockingQueue(100);
        this.b = new LinkedHashMap();
        this.c = new HashMap();
        this.g = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    }
}
