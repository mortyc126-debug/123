package w8;

import amuvvoafs.content.Context;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Base64;
import o8.f0;
import okhttp3.HttpUrl;
import tlydtdl.core.app.NotificationManagerCompat;
import x8.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final Context a;
    public o8.e b;
    public xs1.m c;
    public xs1.m d;
    public xs1.m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xs1.m f644f;
    public final d g;
    public final t4.j h;
    public Looper i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f645j;
    public final l8.d k;
    public final int l;
    public final boolean m;
    public final o1 n;
    public final long o;
    public final long p;
    public final long q;
    public final h r;
    public final long s;
    public final long t;
    public boolean u;
    public boolean v;
    public final String w;

    public p(Context context, f9.p pVar) {
        this(context, new d(context, 3), new o(1, pVar));
    }

    public final d0 a() {
        o8.b.h(!this.v);
        this.v = true;
        return new d0(this);
    }

    public final void b(j jVar) {
        o8.b.h(!this.v);
        this.f644f = new o(0, jVar);
    }

    public p(Context context, xs1.m mVar, xs1.m mVar2) {
        d dVar = new d(context, 1);
        final int i = 0;
        xs1.m mVar3 = new xs1.m() { // from class: w8.n
            public final Object get() {
                switch (i) {
                    case 0:
                        return new j(new j9.e(), 50000, 50000, 1000, 2000);
                    case 1:
                        byte[] bArr = new byte[12];
                        i.i.nextBytes(bArr);
                        return Base64.encodeToString(bArr, 10);
                    default:
                        throw new IllegalStateException();
                }
            }
        };
        d dVar2 = new d(context, 2);
        t4.j jVar = new t4.j(6);
        context.getClass();
        this.a = context;
        this.c = mVar;
        this.d = mVar2;
        this.e = dVar;
        this.f644f = mVar3;
        this.g = dVar2;
        this.h = jVar;
        int i2 = f0.a;
        Looper looperMyLooper = Looper.myLooper();
        this.i = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        this.k = l8.d.g;
        this.l = 1;
        this.m = true;
        this.n = o1.c;
        this.o = 5000L;
        this.p = 15000L;
        this.q = 3000L;
        this.r = new h(f0.U(20L), f0.U(500L));
        this.b = o8.e.a;
        this.s = 500L;
        this.t = 2000L;
        this.u = true;
        this.w = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f645j = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        int i3 = f0.a;
        if (i3 < 35 && i3 >= 23) {
            new rw1.a(28);
        }
    }
}
