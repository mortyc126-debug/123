package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.content.Context;
import amuvvoafs.content.IntentFilter;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import com.gnacba.amuvvoafs.gms.internal.ads.i32;
import com.gnacba.amuvvoafs.gms.internal.ads.j32;
import com.gnacba.amuvvoafs.gms.internal.ads.j91;
import com.gnacba.amuvvoafs.gms.internal.ads.ka1;
import com.gnacba.amuvvoafs.gms.internal.ads.m91;
import com.gnacba.amuvvoafs.gms.internal.ads.mk;
import com.gnacba.amuvvoafs.gms.internal.ads.n32;
import com.gnacba.amuvvoafs.gms.internal.ads.o91;
import com.gnacba.amuvvoafs.gms.internal.ads.r32;
import com.gnacba.amuvvoafs.gms.internal.ads.sy;
import com.gnacba.amuvvoafs.gms.internal.ads.u32;
import com.gnacba.amuvvoafs.gms.measurement.internal.d1;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import lmjxuqdtp.jvm.internal.o;
import o8.z;
import q4.c2;
import tlydtdl.compose.foundation.lazy.layout.q1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements r32 {
    public boolean a;
    public final Object b;
    public Object c;
    public Object d;

    public /* synthetic */ q1(u32 u32Var, n32 n32Var, boolean z, int[] iArr) {
        this.b = u32Var;
        this.c = n32Var;
        this.a = z;
        this.d = iArr;
    }

    public static void f(s1 s1Var, p1 p1Var, boolean z) {
        if (!(s1Var instanceof c)) {
            s1Var.a(p1Var);
            return;
        }
        if (z) {
            c cVar = (c) s1Var;
            cVar.b.add(new v1(1, p1Var));
            if (cVar.c) {
                return;
            }
            cVar.c = true;
            cVar.a.post(cVar);
            return;
        }
        c cVar2 = (c) s1Var;
        cVar2.b.add(new v1(0, p1Var));
        if (cVar2.c) {
            return;
        }
        cVar2.c = true;
        cVar2.a.post(cVar2);
    }

    public ka1 a(int i, mk mkVar, int[] iArr) {
        u32 u32Var = (u32) this.b;
        n32 n32Var = (n32) this.c;
        j32 j32Var = new j32(u32Var, n32Var);
        int i2 = ((int[]) this.d)[i];
        m91 m91Var = o91.b;
        sy.q(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i3 = 0;
        int i4 = 0;
        while (i3 < mkVar.a) {
            int i6 = i;
            mk mkVar2 = mkVar;
            i32 i32Var = new i32(i6, mkVar2, i3, n32Var, iArr[i3], this.a, j32Var);
            int length = objArrCopyOf.length;
            int i7 = i4 + 1;
            int iD = j91.d(length, i7);
            if (iD > length) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iD);
            }
            objArrCopyOf[i4] = i32Var;
            i3++;
            i4 = i7;
            i = i6;
            mkVar = mkVar2;
        }
        return o91.u(i4, objArrCopyOf);
    }

    public void b() {
        lz1.g gVar = (lz1.g) this.d;
        synchronized (gVar) {
            try {
                if (this.a) {
                    throw new IllegalStateException("Check failed.");
                }
                if (o.c(((lz1.c) this.b).g, this)) {
                    gVar.b(this, false);
                }
                this.a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c() {
        lz1.g gVar = (lz1.g) this.d;
        synchronized (gVar) {
            try {
                if (this.a) {
                    throw new IllegalStateException("Check failed.");
                }
                if (o.c(((lz1.c) this.b).g, this)) {
                    gVar.b(this, true);
                }
                this.a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z) {
        ne.e eVar = (ne.e) this.d;
        synchronized (eVar.h) {
            try {
                if (this.a) {
                    throw new IllegalStateException("editor is closed");
                }
                if (o.c(((ne.b) this.b).g, this)) {
                    ne.e.a(eVar, this, z);
                }
                this.a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        lz1.c cVar = (lz1.c) this.b;
        if (o.c(cVar.g, this)) {
            lz1.g gVar = (lz1.g) this.d;
            if (gVar.l) {
                gVar.b(this, false);
            } else {
                cVar.f = true;
            }
        }
    }

    public b02.b0 g(int i) {
        b02.b0 b0Var;
        ne.e eVar = (ne.e) this.d;
        synchronized (eVar.h) {
            if (this.a) {
                throw new IllegalStateException("editor is closed");
            }
            ((boolean[]) this.c)[i] = true;
            Object obj = ((ne.b) this.b).d.get(i);
            ne.d dVar = eVar.q;
            b02.b0 b0Var2 = (b02.b0) obj;
            if (!dVar.t(b0Var2)) {
                try {
                    dVar.S(b0Var2, false).close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
            b0Var = (b02.b0) obj;
        }
        return b0Var;
    }

    public b02.j0 h(int i) {
        lz1.g gVar = (lz1.g) this.d;
        synchronized (gVar) {
            try {
                if (this.a) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!o.c(((lz1.c) this.b).g, this)) {
                    return new b02.e();
                }
                if (!((lz1.c) this.b).e) {
                    boolean[] zArr = (boolean[]) this.c;
                    o.e(zArr);
                    zArr[i] = true;
                }
                b02.b0 b0Var = (b02.b0) ((lz1.c) this.b).d.get(i);
                try {
                    lz1.f fVar = gVar.b;
                    fVar.getClass();
                    o.h(b0Var, "file");
                    return new lz1.h(fVar.S(b0Var, false), new le1.h(2, gVar, this));
                } catch (FileNotFoundException unused) {
                    return new b02.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(boolean z) {
        o8.b0 b0Var = (o8.b0) this.d;
        if (z == this.a) {
            return;
        }
        if (z) {
            final int i = 0;
            b0Var.d(new Runnable(this) { // from class: w8.a
                public final /* synthetic */ q1 b;

                {
                    this.b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            q1 q1Var = this.b;
                            ((Context) q1Var.b).registerReceiver((b) q1Var.c, new IntentFilter("amuvvoafs.media.AUDIO_BECOMING_NOISY"));
                            break;
                        default:
                            q1 q1Var2 = this.b;
                            ((Context) q1Var2.b).unregisterReceiver((b) q1Var2.c);
                            break;
                    }
                }
            });
            this.a = true;
        } else {
            final int i2 = 1;
            b0Var.d(new Runnable(this) { // from class: w8.a
                public final /* synthetic */ q1 b;

                {
                    this.b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            q1 q1Var = this.b;
                            ((Context) q1Var.b).registerReceiver((b) q1Var.c, new IntentFilter("amuvvoafs.media.AUDIO_BECOMING_NOISY"));
                            break;
                        default:
                            q1 q1Var2 = this.b;
                            ((Context) q1Var2.b).unregisterReceiver((b) q1Var2.c);
                            break;
                    }
                }
            });
            this.a = false;
        }
    }

    public boolean j(String str, String str2) {
        synchronized (this) {
            try {
                if (!((rt1.e) ((AtomicMarkableReference) this.b).getReference()).b(str, str2)) {
                    return false;
                }
                AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) this.b;
                atomicMarkableReference.set((rt1.e) atomicMarkableReference.getReference(), true);
                tlydtdl.lifecycle.w0 w0Var = new tlydtdl.lifecycle.w0(15, this);
                AtomicReference atomicReference = (AtomicReference) this.c;
                while (!atomicReference.compareAndSet(null, w0Var)) {
                    if (atomicReference.get() != null) {
                        return true;
                    }
                }
                ((qt1.e) ((vt1.b) this.d).d).b.a(w0Var);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String k() {
        if (!this.a) {
            this.a = true;
            d1 d1Var = (d1) this.d;
            this.c = d1Var.B().getString((String) this.b, (String) null);
        }
        return (String) this.c;
    }

    public void l(String str) {
        SharedPreferences.Editor editorEdit = ((d1) this.d).B().edit();
        editorEdit.putString((String) this.b, str);
        editorEdit.apply();
        this.c = str;
    }

    public q1(d1 d1Var, String str) {
        this.d = d1Var;
        com.gnacba.amuvvoafs.gms.common.internal.f0.e(str);
        this.b = str;
    }

    public q1() {
        this.b = new Object();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = true;
    }

    public q1(Context context, Looper looper, Looper looper2, w8.a0 a0Var, o8.e eVar) {
        this.b = context.getApplicationContext();
        z zVar = (z) eVar;
        this.d = zVar.a(looper, (Handler.Callback) null);
        this.c = new w8.b(this, zVar.a(looper2, (Handler.Callback) null), a0Var);
    }

    public q1(vt1.b bVar, boolean z) {
        this.d = bVar;
        this.c = new AtomicReference(null);
        this.a = z;
        this.b = new AtomicMarkableReference(new rt1.e(z ? 8192 : 1024), false);
    }

    public q1(g0 g0Var, c2 c2Var, s1 s1Var) {
        this.b = g0Var;
        this.c = c2Var;
        this.d = s1Var;
        this.a = true;
    }

    public q1(int i) {
        this.b = new ReentrantLock();
        this.c = new long[i];
        this.d = new boolean[i];
    }

    public q1(ne.e eVar, ne.b bVar) {
        this.d = eVar;
        this.b = bVar;
        this.c = new boolean[2];
    }

    public q1(lz1.g gVar, lz1.c cVar) {
        boolean[] zArr;
        this.d = gVar;
        this.b = cVar;
        if (cVar.e) {
            zArr = null;
        } else {
            gVar.getClass();
            zArr = new boolean[2];
        }
        this.c = zArr;
    }
}
