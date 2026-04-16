package zq0;

import am.p;
import c6.h;
import com.bandlab.mixeditor.presets.services.SavedPresetsService;
import com.bandlab.mixeditor.presets.services.SharedPresetsService;
import fy1.l;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import jv0.i0;
import lmjxuqdtp.io.i;
import lmjxuqdtp.jvm.internal.d0;
import mx1.t;
import ny1.r2;
import ny1.z;
import so0.c1;
import yr.y4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements to0.e {
    public static final /* synthetic */ l[] l = {new lmjxuqdtp.jvm.internal.v(h0.class, "savedPresetsService", "getSavedPresetsService()Lcom/bandlab/mixeditor/presets/services/SavedPresetsService;", 0), com.ironsource.adqualitysdk.sdk.i.a0.r(d0.a, h0.class, "sharedPresetsService", "getSharedPresetsService()Lcom/bandlab/mixeditor/presets/services/SharedPresetsService;", 0)};
    public final vb0.a a;
    public final i0 b;
    public final File c;
    public final y10.a d;
    public final mt.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final mt.b f750f;
    public final LinkedHashMap g = new LinkedHashMap();
    public final r2 h;
    public final AtomicBoolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f751j;
    public final r2 k;

    public h0(vb0.a aVar, i0 i0Var, File file, mt.b bVar, y10.a aVar2) {
        this.a = aVar;
        this.b = i0Var;
        this.c = file;
        this.d = aVar2;
        this.e = bVar;
        this.f750f = bVar;
        r2 r2VarC = z.c(t.a);
        this.h = r2VarC;
        this.i = new AtomicBoolean(false);
        this.f751j = new AtomicBoolean(false);
        this.k = r2VarC;
        z.J(aVar2, new p(20, ((or.q) i0Var).f, new y4(this, (qx1.d) null, 12)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(zq0.h0 r11, sx1.c r12) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.a(zq0.h0, sx1.c):java.lang.Object");
    }

    public final void b(c1 c1Var) {
        String str = c1Var.a;
        File fileG = g(str, true);
        try {
            i.N(fileG, this.a.b(c1Var, c1.Companion.serializer()));
        } catch (Throwable th) {
            s02.d.a.getClass();
            s02.b.s("Cannot dump created preset " + str + " into file", th);
            qm0.b.u(fileG);
        }
        this.g.put(str, c1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r17, y11.c1 r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, sx1.c r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r23
            boolean r3 = r2 instanceof zq0.b0
            if (r3 == 0) goto L19
            r3 = r2
            zq0.b0 r3 = (zq0.b0) r3
            int r4 = r3.l
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.l = r4
            goto L1e
        L19:
            zq0.b0 r3 = new zq0.b0
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.j
            rx1.a r4 = rx1.a.a
            int r5 = r3.l
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L36
            if (r5 != r6) goto L2e
            lg.e.O(r2)
            goto L7c
        L2e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L36:
            lg.e.O(r2)
            java.lang.String r9 = com.facebook.appevents.p.c0()
            java.lang.String r2 = "custom"
            boolean r2 = lmjxuqdtp.jvm.internal.o.c(r1, r2)
            if (r2 != 0) goto L54
            java.lang.String r2 = "none"
            boolean r2 = lmjxuqdtp.jvm.internal.o.c(r1, r2)
            if (r2 != 0) goto L54
            boolean r2 = hy1.q.L0(r1)
            if (r2 != 0) goto L54
            goto L55
        L54:
            r1 = r7
        L55:
            if (r1 != 0) goto L59
            r12 = r9
            goto L5a
        L59:
            r12 = r1
        L5a:
            com.bandlab.mixeditor.presets.services.SavedPresetsService r1 = r0.h()
            jv0.i0 r2 = r0.b
            java.lang.String r2 = dd.v.D(r2)
            wq0.i r8 = new wq0.i
            r11 = r17
            r10 = r18
            r14 = r20
            r13 = r21
            r15 = r22
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            r3.l = r6
            java.lang.Object r2 = r1.createPreset(r2, r8, r3)
            if (r2 != r4) goto L7c
            return r4
        L7c:
            so0.c1 r2 = (so0.c1) r2
            r0.b(r2)
            java.util.List r1 = r0.f()
            ny1.r2 r3 = r0.h
            r3.getClass()
            r3.i(r7, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.c(java.lang.String, y11.c1, java.lang.String, java.lang.String, java.lang.String, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zq0.c0
            if (r0 == 0) goto L13
            r0 = r6
            zq0.c0 r0 = (zq0.c0) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            zq0.c0 r0 = new zq0.c0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.String r5 = r0.j
            lg.e.O(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            lg.e.O(r6)
            com.bandlab.mixeditor.presets.services.SavedPresetsService r6 = r4.h()
            jv0.i0 r2 = r4.b
            java.lang.String r2 = dd.v.D(r2)
            r0.j = r5
            r0.m = r3
            java.lang.Object r6 = r6.deletePreset(r2, r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r6 = 0
            java.io.File r6 = r4.g(r5, r6)
            qm0.b.u(r6)
            java.util.LinkedHashMap r6 = r4.g
            r6.remove(r5)
            java.util.List r5 = r4.f()
            ny1.r2 r6 = r4.h
            r6.getClass()
            r0 = 0
            r6.i(r0, r5)
            lx1.b0 r5 = lx1.b0.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.d(java.lang.String, sx1.c):java.lang.Object");
    }

    public final c1 e(String str) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        k();
        return (c1) this.g.get(str);
    }

    public final List f() {
        return mx1.o.e1(this.g.values(), new h(5));
    }

    public final File g(String str, boolean z) {
        File file = this.c;
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return new File(file, str);
    }

    public final SavedPresetsService h() {
        return (SavedPresetsService) new jx0.h(d0.a(SavedPresetsService.class), this.e).t(l[0]);
    }

    public final SharedPresetsService i() {
        return (SharedPresetsService) new jx0.h(d0.a(SharedPresetsService.class), this.f750f).t(l[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.lang.String r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zq0.d0
            if (r0 == 0) goto L13
            r0 = r6
            zq0.d0 r0 = (zq0.d0) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            zq0.d0 r0 = new zq0.d0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r6)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            lg.e.O(r6)
            com.bandlab.mixeditor.presets.services.SharedPresetsService r6 = r4.i()
            jv0.i0 r2 = r4.b
            java.lang.String r2 = dd.v.D(r2)
            r0.l = r3
            java.lang.Object r6 = r6.regenerateLinkToken(r2, r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            so0.c1 r6 = (so0.c1) r6
            r4.b(r6)
            java.util.List r5 = r4.f()
            ny1.r2 r0 = r4.h
            r0.getClass()
            r1 = 0
            r0.i(r1, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.j(java.lang.String, sx1.c):java.lang.Object");
    }

    public final void k() {
        ArrayList arrayList;
        c1 c1Var;
        if (this.i.getAndSet(true)) {
            return;
        }
        File[] fileArrListFiles = this.c.listFiles();
        if (fileArrListFiles != null) {
            arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                try {
                    lmjxuqdtp.jvm.internal.o.e(file);
                    c1Var = (c1) this.a.a(i.L(file), c1.Companion.serializer());
                } catch (Throwable th) {
                    s02.b bVar = s02.d.a;
                    String str = "Saved preset with id " + file.getName() + " is broken";
                    bVar.getClass();
                    s02.b.s(str, th);
                    qm0.b.u(file);
                    c1Var = null;
                }
                if (c1Var != null) {
                    arrayList.add(c1Var);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = t.a;
        }
        LinkedHashMap linkedHashMap = this.g;
        linkedHashMap.clear();
        int iR = mx1.z.R(mx1.p.c0(arrayList, 10));
        if (iR < 16) {
            iR = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iR);
        for (Object obj : arrayList) {
            linkedHashMap2.put(((c1) obj).a, obj);
        }
        linkedHashMap.putAll(linkedHashMap2);
        List listF = f();
        r2 r2Var = this.h;
        r2Var.getClass();
        r2Var.i((Object) null, listF);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(java.lang.String r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zq0.f0
            if (r0 == 0) goto L13
            r0 = r6
            zq0.f0 r0 = (zq0.f0) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            zq0.f0 r0 = new zq0.f0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r6)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            lg.e.O(r6)
            com.bandlab.mixeditor.presets.services.SharedPresetsService r6 = r4.i()
            jv0.i0 r2 = r4.b
            java.lang.String r2 = dd.v.D(r2)
            r0.l = r3
            java.lang.Object r6 = r6.saveSharedPreset(r2, r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            so0.c1 r6 = (so0.c1) r6
            r4.b(r6)
            java.util.List r5 = r4.f()
            ny1.r2 r0 = r4.h
            r0.getClass()
            r1 = 0
            r0.i(r1, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.l(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.String r14, java.lang.String r15, y11.c1 r16, java.lang.String r17, java.lang.String r18, sx1.c r19) {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof zq0.g0
            if (r1 == 0) goto L15
            r1 = r0
            zq0.g0 r1 = (zq0.g0) r1
            int r2 = r1.l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.l = r2
            goto L1a
        L15:
            zq0.g0 r1 = new zq0.g0
            r1.<init>(r13, r0)
        L1a:
            java.lang.Object r0 = r1.j
            rx1.a r2 = rx1.a.a
            int r3 = r1.l
            r4 = 1
            if (r3 == 0) goto L31
            if (r3 != r4) goto L29
            lg.e.O(r0)
            goto L56
        L29:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L31:
            lg.e.O(r0)
            com.bandlab.mixeditor.presets.services.SavedPresetsService r0 = r13.h()
            jv0.i0 r3 = r13.b
            java.lang.String r3 = dd.v.D(r3)
            wq0.i r5 = new wq0.i
            r6 = 0
            r9 = 0
            r12 = 0
            r8 = r15
            r7 = r16
            r11 = r17
            r10 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r1.l = r4
            java.lang.Object r0 = r0.updatePreset(r3, r14, r5, r1)
            if (r0 != r2) goto L56
            return r2
        L56:
            so0.c1 r0 = (so0.c1) r0
            r13.b(r0)
            java.util.List r14 = r13.f()
            ny1.r2 r15 = r13.h
            r15.getClass()
            r1 = 0
            r15.i(r1, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.h0.m(java.lang.String, java.lang.String, y11.c1, java.lang.String, java.lang.String, sx1.c):java.lang.Object");
    }
}
