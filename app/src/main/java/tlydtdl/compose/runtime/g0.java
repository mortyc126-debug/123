package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends s3.c0 {
    public static final Object h = new Object();
    public long c;
    public int d;
    public q1.f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f531f;
    public int g;

    public g0(long j2) {
        super(j2);
        q1.f0 f0Var = q1.s0.a;
        lmjxuqdtp.jvm.internal.o.f(f0Var, "null cannot be cast to non-null type tlydtdl.collection.ObjectIntMap<K of tlydtdl.collection.ObjectIntMapKt.emptyObjectIntMap>");
        this.e = f0Var;
        this.f531f = h;
    }

    public final void a(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.DerivedSnapshotState.ResultRecord<T of tlydtdl.compose.runtime.DerivedSnapshotState.ResultRecord>");
        g0 g0Var = (g0) c0Var;
        this.e = g0Var.e;
        this.f531f = g0Var.f531f;
        this.g = g0Var.g;
    }

    public final s3.c0 b() {
        return new g0(s3.l.k().g());
    }

    public final s3.c0 c(long j2) {
        return new g0(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(tlydtdl.compose.runtime.h0 r7, s3.f r8) {
        /*
            r6 = this;
            java.lang.Object r0 = s3.l.c
            monitor-enter(r0)
            long r1 = r6.c     // Catch: java.lang.Throwable -> L1a
            long r3 = r8.g()     // Catch: java.lang.Throwable -> L1a
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L1c
            int r1 = r6.d     // Catch: java.lang.Throwable -> L1a
            int r4 = r8.h()     // Catch: java.lang.Throwable -> L1a
            if (r1 == r4) goto L18
            goto L1c
        L18:
            r1 = r3
            goto L1d
        L1a:
            r7 = move-exception
            goto L47
        L1c:
            r1 = r2
        L1d:
            monitor-exit(r0)
            java.lang.Object r4 = r6.f531f
            java.lang.Object r5 = tlydtdl.compose.runtime.g0.h
            if (r4 == r5) goto L2f
            if (r1 == 0) goto L30
            int r4 = r6.g
            int r7 = r6.e(r7, r8)
            if (r4 != r7) goto L2f
            goto L30
        L2f:
            r2 = r3
        L30:
            if (r2 == 0) goto L46
            if (r1 == 0) goto L46
            monitor-enter(r0)
            long r3 = r8.g()     // Catch: java.lang.Throwable -> L43
            r6.c = r3     // Catch: java.lang.Throwable -> L43
            int r7 = r8.h()     // Catch: java.lang.Throwable -> L43
            r6.d = r7     // Catch: java.lang.Throwable -> L43
            monitor-exit(r0)
            return r2
        L43:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L46:
            return r2
        L47:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.g0.d(tlydtdl.compose.runtime.h0, s3.f):boolean");
    }

    public final int e(h0 h0Var, s3.f fVar) throws Throwable {
        q1.f0 f0Var;
        int iIdentityHashCode;
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        s3.c0 c0VarH;
        synchronized (s3.l.c) {
            f0Var = this.e;
        }
        int i4 = 7;
        if (f0Var.e == 0) {
            return 7;
        }
        k3.e eVarO = a0.o();
        Object[] objArr = eVarO.a;
        int i6 = eVarO.c;
        for (int i7 = 0; i7 < i6; i7++) {
            ((r) objArr[i7]).b();
        }
        try {
            Object[] objArr2 = f0Var.b;
            int[] iArr = f0Var.c;
            long[] jArr3 = f0Var.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                iIdentityHashCode = 7;
                int i8 = 0;
                while (true) {
                    long j2 = jArr3[i8];
                    if ((((~j2) << i4) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8;
                        int i10 = 8 - ((~(i8 - length)) >>> 31);
                        int i11 = 0;
                        while (i11 < i10) {
                            if ((j2 & 255) < 128) {
                                int i12 = (i8 << 3) + i11;
                                Object obj = objArr2[i12];
                                i2 = i4;
                                int i13 = iArr[i12];
                                i3 = i9;
                                h0 h0Var2 = (s3.a0) obj;
                                if (i13 != 1) {
                                    jArr2 = jArr3;
                                } else {
                                    if (h0Var2 instanceof h0) {
                                        try {
                                            h0 h0Var3 = h0Var2;
                                            c0VarH = h0Var3.h((g0) s3.l.j(h0Var3.d, fVar), fVar, false, h0Var3.b);
                                        } catch (Throwable th) {
                                            th = th;
                                            Object[] objArr3 = eVarO.a;
                                            int i14 = eVarO.c;
                                            for (int i15 = 0; i15 < i14; i15++) {
                                                ((r) objArr3[i15]).a();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        c0VarH = s3.l.j(h0Var2.d(), fVar);
                                    }
                                    jArr2 = jArr3;
                                    iIdentityHashCode = (((iIdentityHashCode * 31) + System.identityHashCode(c0VarH)) * 31) + Long.hashCode(c0VarH.a);
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = i4;
                                i3 = i9;
                            }
                            j2 >>= i3;
                            i11++;
                            i4 = i2;
                            jArr3 = jArr2;
                            i9 = i3;
                        }
                        jArr = jArr3;
                        i = i4;
                        if (i10 != i9) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        i = i4;
                    }
                    if (i8 == length) {
                        i4 = iIdentityHashCode;
                        break;
                    }
                    i8++;
                    i4 = i;
                    jArr3 = jArr;
                }
            }
            iIdentityHashCode = i4;
            Object[] objArr4 = eVarO.a;
            int i16 = eVarO.c;
            for (int i17 = 0; i17 < i16; i17++) {
                ((r) objArr4[i17]).a();
            }
            return iIdentityHashCode;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
