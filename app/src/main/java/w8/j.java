package w8;

import java.util.HashMap;
import java.util.Iterator;
import o8.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final j9.e a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f639f;
    public final long g;
    public final HashMap h;
    public long i;

    public j(j9.e eVar, int i, int i2, int i3, int i4) {
        a("bufferForPlaybackMs", i3, 0, "0");
        a("bufferForPlaybackAfterRebufferMs", i4, 0, "0");
        a("minBufferMs", i, i3, "bufferForPlaybackMs");
        a("minBufferMs", i, i4, "bufferForPlaybackAfterRebufferMs");
        a("maxBufferMs", i2, i, "minBufferMs");
        a("backBufferDurationMs", 0, 0, "0");
        this.a = eVar;
        this.b = f0.U(i);
        this.c = f0.U(i2);
        this.d = f0.U(i3);
        this.e = f0.U(i4);
        this.f639f = -1;
        this.g = f0.U(0);
        this.h = new HashMap();
        this.i = -1L;
    }

    public static void a(String str, int i, int i2, String str2) {
        o8.b.b(str + " cannot be less than " + str2, i >= i2);
    }

    public final int b() {
        Iterator it = this.h.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((i) it.next()).b;
        }
        return i;
    }

    public final boolean c(m0 m0Var) {
        int i;
        long j2 = this.c;
        i iVar = (i) this.h.get(m0Var.a);
        iVar.getClass();
        j9.e eVar = this.a;
        synchronized (eVar) {
            i = eVar.d * eVar.b;
        }
        boolean z = i >= b();
        long jMin = this.b;
        float f2 = m0Var.c;
        if (f2 > 1.0f) {
            jMin = Math.min(f0.B(jMin, f2), j2);
        }
        long jMax = Math.max(jMin, 500000L);
        long j3 = m0Var.b;
        if (j3 < jMax) {
            iVar.a = !z;
            if (z && j3 < 500000) {
                o8.b.q("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= j2 || z) {
            iVar.a = false;
        }
        return iVar.a;
    }

    public final void d() {
        if (!this.h.isEmpty()) {
            this.a.a(b());
            return;
        }
        j9.e eVar = this.a;
        synchronized (eVar) {
            if (eVar.a) {
                eVar.a(0);
            }
        }
    }
}
