package js0;

import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import lmjxuqdtp.jvm.functions.Function1;
import mx1.o;
import ny1.r2;
import ny1.z;
import okhttp3.HttpUrl;
import s02.b;
import s02.d;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public final ReentrantLock a = new ReentrantLock();
    public final int b;
    public final ArrayList c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f246f;
    public final r2 g;

    public h0(ArrayList arrayList, int i, int i2, boolean z) {
        this.b = Math.max(21, arrayList.size());
        this.c = arrayList;
        this.d = i;
        this.e = i2;
        this.f246f = z;
        this.g = z.c(new k0(o.z0(i, arrayList), c(), b()));
        b bVar = d.a;
        String str = "- UndoStack:: INIT: " + d();
        bVar.getClass();
        b.t(str);
        a("init", true);
    }

    public final boolean a(String str, boolean z) {
        ArrayList arrayList = this.c;
        lmjxuqdtp.jvm.internal.o.h(str, "operation");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            nx1.d dVarS = ct1.b.s();
            int size = arrayList.size();
            int i = this.d;
            if (i >= size) {
                dVarS.add("Expected statePointer < stateList.size, got statePointer = " + i + ", size = " + size + ", stateList.size = " + arrayList.size());
            }
            int i2 = this.e;
            int i3 = this.d;
            if (i2 > i3) {
                dVarS.add("Expected blockedLevel <= statePointer, got blockedLevel = " + i2 + ", statePointer = " + i3);
            }
            nx1.d dVarM = ct1.b.m(dVarS);
            if (!dVarM.isEmpty()) {
                IllegalStateException illegalStateException = new IllegalStateException(o.E0(dVarM, ". ", dVarM.b() + " errors on '" + str + "'. ", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60));
                if (z) {
                    throw illegalStateException;
                }
                bb.w wVar = new bb.w(2);
                ArrayList arrayList2 = wVar.a;
                wVar.a("CRITICAL");
                wVar.e(new String[]{"UndoStack"});
                DebugUtils.handleThrowable(new IllegalStateException(HttpUrl.FRAGMENT_ENCODE_SET, new TaggedException(illegalStateException, (String[]) arrayList2.toArray(new String[arrayList2.size()]))));
            }
            boolean zIsEmpty = dVarM.isEmpty();
            reentrantLock.unlock();
            return zIsEmpty;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b() {
        return this.d < this.c.size() - 1 && !this.f246f;
    }

    public final boolean c() {
        int i = this.d;
        return i > 0 && i > this.e;
    }

    public final String d() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = this.d;
        Object objZ0 = o.z0(i, arrayList);
        Integer numValueOf = objZ0 != null ? Integer.valueOf(objZ0.hashCode()) : null;
        StringBuilder sbI = p.i(size, i, "(size:", ") [ptr:", "] -> ");
        sbI.append(numValueOf);
        return sbI.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        throw r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final js0.h0 e(lmjxuqdtp.jvm.functions.Function1 r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.a
            r0.lock()
            r1 = 2
            r1 = r1 & 1
            if (r1 == 0) goto Lc
            r1 = 0
            goto Ld
        Lc:
            r1 = r8
        Ld:
            r2 = 0
            if (r1 == 0) goto L39
            java.util.concurrent.locks.ReentrantLock r3 = r1.a     // Catch: java.lang.Throwable -> L59
            java.util.ArrayList r4 = r1.c     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = "build"
            boolean r5 = r1.a(r5, r2)     // Catch: java.lang.Throwable -> L59
            if (r5 != 0) goto L1d
            goto L39
        L1d:
            r3.lock()     // Catch: java.lang.Throwable -> L59
            js0.h0 r5 = new js0.h0     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L34
            int r4 = r1.d     // Catch: java.lang.Throwable -> L34
            int r7 = r1.e     // Catch: java.lang.Throwable -> L34
            boolean r1 = r1.f246f     // Catch: java.lang.Throwable -> L34
            r5.<init>(r6, r4, r7, r1)     // Catch: java.lang.Throwable -> L34
            r3.unlock()     // Catch: java.lang.Throwable -> L59
            goto L44
        L34:
            r9 = move-exception
            r3.unlock()     // Catch: java.lang.Throwable -> L59
            throw r9     // Catch: java.lang.Throwable -> L59
        L39:
            js0.h0 r5 = new js0.h0     // Catch: java.lang.Throwable -> L59
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L59
            r1.<init>()     // Catch: java.lang.Throwable -> L59
            r3 = -1
            r5.<init>(r1, r3, r3, r2)     // Catch: java.lang.Throwable -> L59
        L44:
            java.util.ArrayList r1 = r5.c     // Catch: java.lang.Throwable -> L59
            java.util.ArrayList r9 = com.facebook.appevents.l.P(r1, r9)     // Catch: java.lang.Throwable -> L59
            r1.clear()     // Catch: java.lang.Throwable -> L59
            r1.addAll(r9)     // Catch: java.lang.Throwable -> L59
            java.lang.String r9 = "map"
            r5.a(r9, r2)     // Catch: java.lang.Throwable -> L59
            r0.unlock()
            return r5
        L59:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: js0.h0.e(lmjxuqdtp.jvm.functions.Function1):js0.h0");
    }
}
