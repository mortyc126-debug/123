package hk1;

import amuvvoafs.content.Context;
import amuvvoafs.net.Uri;
import i11.c;
import ik1.b;
import ik1.h;
import lk1.e;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import qx1.d;
import rx1.a;
import sx1.i;
import tlydtdl.compose.foundation.lazy.layout.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements e {
    public final Context a;
    public final h b;
    public final r1 c;
    public final c d;

    public p(Context context, h hVar, r1 r1Var, c cVar) {
        this.a = context;
        this.b = hVar;
        this.c = r1Var;
        this.d = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(hk1.p r4, java.io.File r5, java.io.File r6, amuvvoafs.graphics.Bitmap r7, amuvvoafs.util.Size r8, sx1.c r9) {
        /*
            boolean r0 = r9 instanceof hk1.j
            if (r0 == 0) goto L14
            r0 = r9
            hk1.j r0 = (hk1.j) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.m = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            hk1.j r0 = new hk1.j
            r0.<init>(r4, r9)
            goto L12
        L1a:
            java.lang.Object r4 = r9.k
            rx1.a r0 = rx1.a.a
            int r1 = r9.m
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.io.FileInputStream r5 = r9.j
            lg.e.O(r4)     // Catch: java.lang.Throwable -> L2b
            goto L58
        L2b:
            r0 = move-exception
            r4 = r0
            goto L67
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            lg.e.O(r4)
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r5)
            com.gnacba.amuvvoafs.gms.internal.ads.d1 r4 = new com.gnacba.amuvvoafs.gms.internal.ads.d1     // Catch: java.lang.Throwable -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L64
            java.io.FileDescriptor r5 = r1.getFD()     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = "getFD(...)"
            lmjxuqdtp.jvm.internal.o.g(r5, r3)     // Catch: java.lang.Throwable -> L64
            r9.j = r1     // Catch: java.lang.Throwable -> L64
            r9.m = r2     // Catch: java.lang.Throwable -> L64
            java.lang.Object r4 = com.gnacba.amuvvoafs.gms.internal.ads.d1.f(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L64
            if (r4 != r0) goto L57
            return r0
        L57:
            r5 = r1
        L58:
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L2b
            r4.getClass()     // Catch: java.lang.Throwable -> L2b
            r4 = 0
            mu0.u.j(r5, r4)
            lx1.b0 r4 = lx1.b0.a
            return r4
        L64:
            r0 = move-exception
            r4 = r0
            r5 = r1
        L67:
            throw r4     // Catch: java.lang.Throwable -> L68
        L68:
            r0 = move-exception
            r6 = r0
            mu0.u.j(r5, r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.b(hk1.p, java.io.File, java.io.File, amuvvoafs.graphics.Bitmap, amuvvoafs.util.Size, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(hk1.p r17, java.io.File r18, java.io.File r19, amuvvoafs.graphics.Bitmap r20, lk1.h r21, sx1.c r22) throws java.lang.Throwable {
        /*
            r0 = r17
            r1 = r22
            boolean r2 = r1 instanceof hk1.k
            if (r2 == 0) goto L17
            r2 = r1
            hk1.k r2 = (hk1.k) r2
            int r3 = r2.m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.m = r3
            goto L1c
        L17:
            hk1.k r2 = new hk1.k
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.k
            rx1.a r3 = rx1.a.a
            int r4 = r2.m
            lx1.b0 r5 = lx1.b0.a
            r6 = 1
            if (r4 == 0) goto L3a
            if (r4 != r6) goto L32
            java.io.File r2 = r2.j
            lg.e.O(r1)     // Catch: java.lang.Throwable -> L2f
            goto L9d
        L2f:
            r0 = move-exception
            goto Lad
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            lg.e.O(r1)
            boolean r1 = r19.exists()
            if (r1 != 0) goto L46
            r19.createNewFile()
        L46:
            amuvvoafs.net.Uri r8 = amuvvoafs.net.Uri.fromFile(r18)
            gx0.a r13 = new gx0.a
            r1 = 14
            r13.<init>(r1)
            java.io.File r1 = new java.io.File
            java.io.File r4 = r19.getParentFile()
            java.lang.String r7 = "temp_poster.png"
            r1.<init>(r4, r7)
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La3
            r4.<init>(r1)     // Catch: java.lang.Throwable -> La3
            amuvvoafs.util.Size r7 = r21.a()     // Catch: java.lang.Throwable -> La5
            r9 = r20
            amuvvoafs.graphics.Bitmap r7 = nk1.c.b(r9, r7)     // Catch: java.lang.Throwable -> La5
            amuvvoafs.graphics.Bitmap$CompressFormat r9 = amuvvoafs.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> La5
            r10 = 100
            r7.compress(r9, r10, r4)     // Catch: java.lang.Throwable -> La5
            r4.close()     // Catch: java.lang.Throwable -> La3
            i11.c r9 = r0.d     // Catch: java.lang.Throwable -> La3
            amuvvoafs.net.Uri r10 = amuvvoafs.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> La3
            amuvvoafs.util.Size r11 = r21.a()     // Catch: java.lang.Throwable -> La3
            r2.j = r1     // Catch: java.lang.Throwable -> La3
            r2.m = r6     // Catch: java.lang.Throwable -> La3
            mx1.t r14 = mx1.t.a     // Catch: java.lang.Throwable -> La3
            ry1.e r0 = ky1.m0.a     // Catch: java.lang.Throwable -> La3
            bg0.h r7 = new bg0.h     // Catch: java.lang.Throwable -> La3
            r15 = 0
            r16 = 8
            r12 = r19
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> La3
            java.lang.Object r0 = ky1.c0.R(r0, r7, r2)     // Catch: java.lang.Throwable -> La3
            if (r0 != r3) goto L98
            goto L99
        L98:
            r0 = r5
        L99:
            if (r0 != r3) goto L9c
            return r3
        L9c:
            r2 = r1
        L9d:
            qm0.b.u(r2)
            return r5
        La1:
            r2 = r1
            goto Lad
        La3:
            r0 = move-exception
            goto La1
        La5:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> La8
        La8:
            r0 = move-exception
            mu0.u.j(r4, r2)     // Catch: java.lang.Throwable -> La3
            throw r0     // Catch: java.lang.Throwable -> La3
        Lad:
            qm0.b.u(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.c(hk1.p, java.io.File, java.io.File, amuvvoafs.graphics.Bitmap, lk1.h, sx1.c):java.lang.Object");
    }

    @Override // lk1.e
    public final Object a(Uri uri, String str, boolean z, int i, int i2, float f2, Function1 function1, i iVar) throws Exception {
        Object objB = this.b.b(b.f, new g(this, uri, str, z, i, i2, f2, function1, (d) null), iVar);
        return objB == a.a ? objB : b0.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.io.File r10, lk1.b r11, amuvvoafs.util.Size r12, sx1.c r13) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.d(java.io.File, lk1.b, amuvvoafs.util.Size, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(1:(2:14|47)(2:15|16))(4:17|48|18|19))(1:22))(2:23|(1:(3:26|(1:29)|46)(2:36|37))(5:38|35|50|39|(1:46)(1:47)))|30|(2:33|31)|52|34|35|50|39|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x016f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
    
        r5 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.io.File r17, java.io.File r18, lk1.b r19, amuvvoafs.graphics.Bitmap r20, amuvvoafs.util.Size r21, sx1.c r22) {
        /*
            Method dump skipped, instruction units count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.e(java.io.File, java.io.File, lk1.b, amuvvoafs.graphics.Bitmap, amuvvoafs.util.Size, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable f(java.io.File r14, java.io.File r15, java.io.File r16, boolean r17, zj1.a r18, sx1.c r19) {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof hk1.m
            if (r1 == 0) goto L15
            r1 = r0
            hk1.m r1 = (hk1.m) r1
            int r2 = r1.l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.l = r2
            goto L1a
        L15:
            hk1.m r1 = new hk1.m
            r1.<init>(r13, r0)
        L1a:
            java.lang.Object r0 = r1.j
            rx1.a r2 = rx1.a.a
            int r3 = r1.l
            r4 = 1
            if (r3 == 0) goto L34
            if (r3 != r4) goto L2c
            lg.e.O(r0)     // Catch: java.lang.Throwable -> L29
            goto L53
        L29:
            r0 = move-exception
            r14 = r0
            goto L56
        L2c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L34:
            lg.e.O(r0)
            ik1.h r0 = r13.b     // Catch: java.lang.Throwable -> L29
            ik1.b r3 = ik1.b.c     // Catch: java.lang.Throwable -> L29
            hk1.n r5 = new hk1.n     // Catch: java.lang.Throwable -> L29
            r12 = 0
            r6 = r13
            r8 = r14
            r7 = r15
            r9 = r16
            r10 = r17
            r11 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L29
            r1.l = r4     // Catch: java.lang.Throwable -> L29
            java.lang.Object r0 = r0.b(r3, r5, r1)     // Catch: java.lang.Throwable -> L29
            if (r0 != r2) goto L53
            return r2
        L53:
            java.io.File r0 = (java.io.File) r0     // Catch: java.lang.Throwable -> L29
            return r0
        L56:
            lx1.n r14 = lg.e.u(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.f(java.io.File, java.io.File, java.io.File, boolean, zj1.a, sx1.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable g(al1.h0 r14, java.io.File r15, java.io.File r16, java.io.File r17, zj1.a r18, sx1.c r19) {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof hk1.o
            if (r1 == 0) goto L15
            r1 = r0
            hk1.o r1 = (hk1.o) r1
            int r2 = r1.l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.l = r2
            goto L1a
        L15:
            hk1.o r1 = new hk1.o
            r1.<init>(r13, r0)
        L1a:
            java.lang.Object r0 = r1.j
            rx1.a r2 = rx1.a.a
            int r3 = r1.l
            r4 = 1
            if (r3 == 0) goto L34
            if (r3 != r4) goto L2c
            lg.e.O(r0)     // Catch: java.lang.Throwable -> L29
            goto L53
        L29:
            r0 = move-exception
            r14 = r0
            goto L56
        L2c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L34:
            lg.e.O(r0)
            ik1.h r0 = r13.b     // Catch: java.lang.Throwable -> L29
            ik1.b r3 = ik1.b.c     // Catch: java.lang.Throwable -> L29
            hk1.l r5 = new hk1.l     // Catch: java.lang.Throwable -> L29
            r12 = 0
            r6 = r13
            r11 = r14
            r8 = r15
            r7 = r16
            r9 = r17
            r10 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L29
            r1.l = r4     // Catch: java.lang.Throwable -> L29
            java.lang.Object r0 = r0.b(r3, r5, r1)     // Catch: java.lang.Throwable -> L29
            if (r0 != r2) goto L53
            return r2
        L53:
            java.io.File r0 = (java.io.File) r0     // Catch: java.lang.Throwable -> L29
            return r0
        L56:
            lx1.n r14 = lg.e.u(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: hk1.p.g(al1.h0, java.io.File, java.io.File, java.io.File, zj1.a, sx1.c):java.io.Serializable");
    }
}
