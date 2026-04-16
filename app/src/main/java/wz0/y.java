package wz0;

import com.gnacba.amuvvoafs.gms.internal.ads.hb0;
import m10.a1;
import n30.k;
import ny1.p2;
import ny1.r2;
import o10.a4;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public final ct.f a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final a4 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f675f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f676j;
    public final boolean k;
    public final boolean l;
    public final p2 m;
    public final n10.a0 n;
    public final se0.q o;
    public final a1 p;
    public final hb0 q;
    public final lh1.a r;
    public final kh1.c s;
    public final Integer t;
    public final boolean u;
    public final boolean v;

    public y(ct.f fVar, boolean z, boolean z2, a4 a4Var, k kVar, boolean z3, boolean z4, boolean z5, boolean z6, p2 p2Var, r2 r2Var, n10.a0 a0Var, se0.q qVar, a1 a1Var, hb0 hb0Var, lh1.a aVar, kh1.c cVar, Integer num, int i) {
        se0.q qVar2;
        boolean z7 = (i & 2) != 0 ? true : z;
        boolean z8 = (i & 4) != 0 ? true : z2;
        boolean z9 = (i & 32) != 0;
        a4 a4Var2 = (i & 64) != 0 ? a4.E : a4Var;
        if ((i & 128) != 0) {
            ny1.z.c(Boolean.FALSE);
        }
        boolean z10 = (i & 256) != 0 ? false : z3;
        boolean z11 = (i & 512) != 0 ? false : z4;
        boolean z12 = (i & 1024) != 0;
        boolean z13 = (i & 2048) != 0 ? true : z5;
        boolean z14 = (i & 4096) != 0 ? false : z6;
        boolean z15 = (i & 8192) == 0;
        boolean z16 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        p2 p2VarC = (i & 32768) != 0 ? ny1.z.c((Object) null) : p2Var;
        if ((i & 65536) != 0) {
            ny1.z.c(Boolean.FALSE);
        }
        n10.a0 a0Var2 = (i & 131072) != 0 ? null : a0Var;
        if ((i & 262144) != 0) {
            se0.q.e2.getClass();
            qVar2 = se0.p.b;
        } else {
            qVar2 = qVar;
        }
        a1 a1Var2 = (i & 524288) != 0 ? null : a1Var;
        hb0 hb0Var2 = (i & 1048576) != 0 ? null : hb0Var;
        lh1.a aVar2 = (i & 2097152) != 0 ? null : aVar;
        kh1.c cVar2 = (i & 4194304) != 0 ? null : cVar;
        Integer num2 = (i & 8388608) != 0 ? null : num;
        boolean z17 = (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) == 0;
        boolean z18 = (i & 33554432) == 0;
        n10.a0 a0Var3 = a0Var2;
        lmjxuqdtp.jvm.internal.o.h(fVar, "postModel");
        lmjxuqdtp.jvm.internal.o.h(a4Var2, "source");
        lmjxuqdtp.jvm.internal.o.h(qVar2, "playlist");
        this.a = fVar;
        this.b = z7;
        this.c = z8;
        this.d = z9;
        this.e = a4Var2;
        this.f675f = z10;
        this.g = z11;
        this.h = z12;
        this.i = z13;
        this.f676j = z14;
        this.k = z15;
        this.l = z16;
        this.m = p2VarC;
        this.n = a0Var3;
        this.o = qVar2;
        this.p = a1Var2;
        this.q = hb0Var2;
        this.r = aVar2;
        this.s = cVar2;
        this.t = num2;
        this.u = z17;
        this.v = z18;
    }
}
