package g4;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Log;
import com.amplitude.experiment.util.FetchException;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.gnacba.amuvvoafs.gms.internal.ads.cv0;
import com.gnacba.amuvvoafs.gms.internal.play_billing.z3;
import com.gnacba.amuvvoafs.gms.measurement.internal.j3;
import com.gnacba.amuvvoafs.gms.tasks.OnCompleteListener;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.gnacba.amuvvoafs.gms.tasks.TaskCompletionSource;
import f3.f2;
import iz1.q0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function5;
import p02.a1;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements iz1.k, lg0.b, pg.d, qq1.k0, r3.k, r6.u, OnCompleteListener, sw0.b {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public /* synthetic */ d0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static g4.d0 c(amuvvoafs.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L29 java.lang.Error -> L2c java.io.IOException -> L2e
            g4.d0 r2 = new g4.d0     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            r3 = 8
            r2.<init>(r3, r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            return r2
        L23:
            r2 = move-exception
            goto L38
        L25:
            r2 = move-exception
            goto L38
        L27:
            r2 = move-exception
            goto L38
        L29:
            r2 = move-exception
        L2a:
            r0 = r1
            goto L38
        L2c:
            r2 = move-exception
            goto L2a
        L2e:
            r2 = move-exception
            goto L2a
        L30:
            r2 = move-exception
        L31:
            r5 = r1
            r0 = r5
            goto L38
        L34:
            r2 = move-exception
            goto L31
        L36:
            r2 = move-exception
            goto L31
        L38:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            amuvvoafs.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L44
            r0.release()     // Catch: java.io.IOException -> L44
        L44:
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L49
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.c(amuvvoafs.content.Context):g4.d0");
    }

    public Function0 a() {
        return (fz0.o) this.b;
    }

    public Object b(r3.b bVar, Object obj) {
        return ((Function2) this.b).invoke(bVar, obj);
    }

    public Object d(Object obj) {
        return ((Function1) this.c).invoke(obj);
    }

    public void e() {
        String str = (String) this.b;
        try {
            vt1.b bVar = (vt1.b) this.c;
            bVar.getClass();
            new File((File) bVar.d, str).createNewFile();
        } catch (IOException e) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e);
        }
    }

    public void f(iz1.j jVar, q0 q0Var) throws FetchException {
        switch (this.a) {
            case 3:
                mg.a aVar = (mg.a) this.c;
                try {
                    lmjxuqdtp.jvm.internal.o.h("Received fetch variants response: " + q0Var, "msg");
                    if (q0Var.q) {
                        aVar.b(ig.f.a((ig.f) this.b, q0Var));
                        return;
                    }
                    throw new FetchException(q0Var.d, "fetch error response: " + q0Var);
                } catch (Exception e) {
                    aVar.c(e);
                    return;
                }
            default:
                p02.h hVar = (p02.h) this.b;
                p02.y yVar = (p02.y) this.c;
                try {
                    try {
                        hVar.e(yVar, yVar.d(q0Var));
                        return;
                    } catch (Throwable th) {
                        a1.q(th);
                        th.printStackTrace();
                        return;
                    }
                } catch (Throwable th2) {
                    a1.q(th2);
                    try {
                        hVar.l(yVar, th2);
                        return;
                    } catch (Throwable th3) {
                        a1.q(th3);
                        th3.printStackTrace();
                        return;
                    }
                }
        }
    }

    public void g(Object obj, sw0.j jVar, String str, String str2, sw0.a aVar, Function5 function5) {
        ke1.e eVar = (ke1.e) obj;
        lmjxuqdtp.jvm.internal.o.h(str, "key");
        lmjxuqdtp.jvm.internal.o.h(str2, "contentType");
        lmjxuqdtp.jvm.internal.o.h(function5, "itemContent");
        q3.k kVar = new q3.k(new fv0.a(function5, jVar, this, 4), true, -1643895346);
        ArrayList arrayList = eVar.d;
        lmjxuqdtp.jvm.internal.a0 a0Var = eVar.c;
        int iIntValue = ((Number) ((Function2) this.c).invoke(eVar.a, jVar)).intValue();
        int i = eVar.b;
        if (iIntValue > i) {
            iIntValue = i;
        }
        int i2 = i - (a0Var.a % i);
        if (iIntValue > i2) {
            arrayList.add(new ke1.b(i2, ke1.a.a));
            a0Var.a += i2;
        }
        arrayList.add(new ke1.b(iIntValue, new q3.k(new ke.x(1, kVar), true, -385603109)));
        a0Var.a += iIntValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h(ny1.m r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, rm.a r42, sx1.c r43) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.h(ny1.m, java.lang.String, java.lang.String, java.lang.String, rm.a, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.gnacba.amuvvoafs.datatransport.cct.CctBackendFactory i(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.i(java.lang.String):com.gnacba.amuvvoafs.datatransport.cct.CctBackendFactory");
    }

    public void j(iz1.j jVar, IOException iOException) {
        switch (this.a) {
            case 3:
                ((mg.a) this.c).c(iOException);
                break;
            default:
                try {
                    ((p02.h) this.b).l((p02.y) this.c, iOException);
                } catch (Throwable th) {
                    a1.q(th);
                    th.printStackTrace();
                    return;
                }
                break;
        }
    }

    public n9.m k(Object... objArr) {
        Constructor constructorF;
        synchronized (((AtomicBoolean) this.c)) {
            if (!((AtomicBoolean) this.c).get()) {
                try {
                    constructorF = ((com.facebook.appevents.n) this.b).f();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.c).set(true);
                    constructorF = null;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructorF = null;
        }
        if (constructorF == null) {
            return null;
        }
        try {
            return (n9.m) constructorF.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }

    public synchronized Map l() {
        try {
            if (((Map) this.c) == null) {
                this.c = Collections.unmodifiableMap(new HashMap((HashMap) this.b));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m(java.lang.String r6, so0.v r7, sx1.c r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.b
            zj.v1 r0 = (zj.v1) r0
            boolean r1 = r8 instanceof uo0.i
            if (r1 == 0) goto L17
            r1 = r8
            uo0.i r1 = (uo0.i) r1
            int r2 = r1.n
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.n = r2
            goto L1c
        L17:
            uo0.i r1 = new uo0.i
            r1.<init>(r5, r8)
        L1c:
            java.lang.Object r8 = r1.l
            rx1.a r2 = rx1.a.a
            int r3 = r1.n
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            so0.v r7 = r1.k
            java.lang.String r6 = r1.j
            lg.e.O(r8)
            goto L47
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            lg.e.O(r8)
            r1.j = r6
            r1.k = r7
            r1.n = r4
            java.lang.Object r8 = qb0.a.k(r0, r6, r7, r1)
            if (r8 != r2) goto L47
            return r2
        L47:
            ak.b2 r8 = r0.k
            zj.a2 r8 = (zj.a2) r8
            r8.a(r6)
            java.lang.Object r6 = r5.c
            uq0.i0 r6 = (uq0.i0) r6
            r6.a(r7)
            lx1.b0 r6 = lx1.b0.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.m(java.lang.String, so0.v, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:712:0x03ff A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(java.lang.String r39, java.util.ArrayList r40) {
        /*
            Method dump skipped, instruction units count: 1736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.n(java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0097  */
    @Override // r6.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public r6.z1 o(r6.z1 r20, amuvvoafs.view.View r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r0.b
            com.gnacba.amuvvoafs.gms.internal.measurement.o4 r3 = (com.gnacba.amuvvoafs.gms.internal.measurement.o4) r3
            java.lang.Object r4 = r0.c
            com.gnacba.amuvvoafs.gms.internal.ads.g r4 = (com.gnacba.amuvvoafs.gms.internal.ads.g) r4
            int r5 = r4.a
            int r6 = r4.b
            int r4 = r4.c
            r6.w1 r7 = r1.a
            r8 = 519(0x207, float:7.27E-43)
            i6.c r8 = r7.g(r8)
            r9 = 32
            i6.c r7 = r7.g(r9)
            java.lang.Object r9 = r3.c
            com.gnacba.amuvvoafs.material.bottomsheet.BottomSheetBehavior r9 = (com.gnacba.amuvvoafs.material.bottomsheet.BottomSheetBehavior) r9
            int r10 = r8.b
            int r11 = r8.c
            int r12 = r8.a
            r9.w = r10
            int r10 = r2.getLayoutDirection()
            r14 = 1
            if (r10 != r14) goto L37
            r10 = r14
            goto L38
        L37:
            r10 = 0
        L38:
            int r15 = r2.getPaddingBottom()
            int r16 = r2.getPaddingLeft()
            int r17 = r2.getPaddingRight()
            boolean r13 = r9.o
            if (r13 == 0) goto L4f
            int r15 = r1.a()
            r9.v = r15
            int r15 = r15 + r4
        L4f:
            boolean r4 = r9.p
            if (r4 == 0) goto L5a
            if (r10 == 0) goto L57
            r4 = r6
            goto L58
        L57:
            r4 = r5
        L58:
            int r16 = r4 + r12
        L5a:
            r4 = r16
            boolean r14 = r9.q
            if (r14 == 0) goto L66
            if (r10 == 0) goto L63
            goto L64
        L63:
            r5 = r6
        L64:
            int r17 = r5 + r11
        L66:
            r5 = r17
            amuvvoafs.view.ViewGroup$LayoutParams r6 = r2.getLayoutParams()
            amuvvoafs.view.ViewGroup$MarginLayoutParams r6 = (amuvvoafs.view.ViewGroup.MarginLayoutParams) r6
            boolean r10 = r9.s
            if (r10 == 0) goto L7b
            int r10 = r6.leftMargin
            if (r10 == r12) goto L7b
            r6.leftMargin = r12
            r18 = 1
            goto L7d
        L7b:
            r18 = 0
        L7d:
            boolean r10 = r9.t
            if (r10 == 0) goto L89
            int r10 = r6.rightMargin
            if (r10 == r11) goto L89
            r6.rightMargin = r11
            r18 = 1
        L89:
            boolean r10 = r9.u
            if (r10 == 0) goto L97
            int r10 = r6.topMargin
            int r8 = r8.b
            if (r10 == r8) goto L97
            r6.topMargin = r8
            r14 = 1
            goto L99
        L97:
            r14 = r18
        L99:
            if (r14 == 0) goto L9e
            r2.setLayoutParams(r6)
        L9e:
            int r6 = r2.getPaddingTop()
            r2.setPadding(r4, r6, r5, r15)
            boolean r2 = r3.b
            if (r2 == 0) goto Lad
            int r3 = r7.d
            r9.m = r3
        Lad:
            if (r13 != 0) goto Lb3
            if (r2 == 0) goto Lb2
            goto Lb3
        Lb2:
            return r1
        Lb3:
            r9.Q()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d0.o(r6.z1, amuvvoafs.view.View):r6.z1");
    }

    public void onBillingServiceDisconnected() {
        com.gnacba.amuvvoafs.gms.internal.play_billing.w.g("BillingClient", "Reconnection attempt failed.");
        try {
            ((z3) this.b).a(pg.d0.h);
        } catch (Throwable th) {
            com.gnacba.amuvvoafs.gms.internal.play_billing.w.i("BillingClient", "Exception setting completer.", th);
        }
        pg.c cVar = (pg.c) this.c;
        if (cVar.F != null) {
            o0.b bVar = new o0.b(8, this);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                bVar.run();
            } else {
                cVar.e.post(bVar);
            }
        }
    }

    public void onBillingSetupFinished(pg.j jVar) {
        com.gnacba.amuvvoafs.gms.internal.play_billing.w.g("BillingClient", "Reconnection finished with result: " + jVar.a);
        try {
            ((z3) this.b).a(jVar);
        } catch (Throwable th) {
            com.gnacba.amuvvoafs.gms.internal.play_billing.w.i("BillingClient", "Exception setting completer.", th);
        }
        pg.c cVar = (pg.c) this.c;
        if (cVar.F != null) {
            j3 j3Var = new j3(this, jVar, false, 6);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                j3Var.run();
            } else {
                cVar.e.post(j3Var);
            }
        }
    }

    public void onComplete(Task task) {
        tq1.f fVar = (tq1.f) this.b;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.c;
        synchronized (fVar.f) {
            fVar.e.remove(taskCompletionSource);
        }
    }

    public void p() {
        try {
            ((FileLock) this.c).release();
            ((FileChannel) this.b).close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }

    public lv0.i q(String str) {
        lmjxuqdtp.jvm.internal.o.h(str, "type");
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.c;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lmjxuqdtp.jvm.internal.o.g(lowerCase, "toLowerCase(...)");
        iw1.b bVar = (iw1.b) linkedHashMap.get(lowerCase);
        return bVar == null ? (nv0.a) this.b : (lv0.i) bVar.invoke();
    }

    public o8.a r() throws IOException {
        File file = (File) this.c;
        File file2 = (File) this.b;
        if (file2.exists()) {
            if (file.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file)) {
                o8.b.q("AtomicFile", "Couldn't rename file " + file2 + " to backup file " + file);
            }
        }
        try {
            return new o8.a(file2);
        } catch (FileNotFoundException e) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException(f2.i(file2, "Couldn't create "), e);
            }
            try {
                return new o8.a(file2);
            } catch (FileNotFoundException e2) {
                throw new IOException(f2.i(file2, "Couldn't create "), e2);
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public eu0.k zza() {
        return new eu0.k(24, (Application) ((je.i) this.b).b, (qq1.f) ((qq1.j0) this.c).zza());
    }

    public /* synthetic */ d0(Object obj, Object obj2, boolean z, int i) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public d0(Map map, nv0.a aVar) {
        this.a = 13;
        this.b = aVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap(mx1.z.R(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
            lmjxuqdtp.jvm.internal.o.g(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, entry.getValue());
        }
        if (map.size() != linkedHashMap.size()) {
            String str = "Duplicate notification handler keys: " + di0.z.I(map.keySet(), linkedHashMap.keySet());
            bb.w wVar = new bb.w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(str), (String[]) Arrays.copyOf(strArr, strArr.length)));
        }
        this.c = linkedHashMap;
    }

    public d0(v1 v1Var, uq0.i0 i0Var) {
        this.a = 27;
        lmjxuqdtp.jvm.internal.o.h(v1Var, "mixer");
        this.b = v1Var;
        this.c = i0Var;
    }

    public d0(yb0.j jVar, d01.k kVar) {
        this.a = 28;
        this.b = jVar;
        this.c = kVar.a(ut.b.c);
    }

    public d0(in0.b bVar) {
        this.a = 6;
        this.b = bVar;
        this.c = new ky1.s();
    }

    public d0(zi.c cVar, cv0 cv0Var) {
        this.a = 22;
        this.b = cv0Var;
        this.c = new dh0.b(cVar);
    }

    public d0(File file) {
        this.a = 14;
        this.b = file;
        this.c = new File(file.getPath() + ".bak");
    }

    public d0(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new Object();
                this.c = new LinkedHashMap();
                break;
            case 19:
                this.b = new HashMap();
                break;
            default:
                this.c = new float[64];
                break;
        }
    }

    public d0(Context context) {
        this.a = 17;
        this.c = null;
        this.b = context;
    }

    public d0(com.facebook.appevents.n nVar) {
        this.a = 12;
        this.b = nVar;
        this.c = new AtomicBoolean(false);
    }
}
