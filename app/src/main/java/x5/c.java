package x5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.IntCompanionObject;
import v5.f;
import y5.m;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public int b;
    public boolean c;
    public final d d;
    public final int e;

    /* JADX INFO: renamed from: f */
    public c f686f;
    public f i;
    public HashSet a = null;
    public int g = 0;
    public int h = IntCompanionObject.MIN_VALUE;

    public c(d dVar, int i) {
        this.d = dVar;
        this.e = i;
    }

    public final void a(c cVar, int i) {
        b(cVar, i, IntCompanionObject.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i, int i2, boolean z) {
        if (cVar == null) {
            j();
            return true;
        }
        if (!z && !i(cVar)) {
            return false;
        }
        this.f686f = cVar;
        if (cVar.a == null) {
            cVar.a = new HashSet();
        }
        HashSet hashSet = this.f686f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public final void c(int i, ArrayList arrayList, m mVar) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                q8.c.o(((c) it.next()).d, i, arrayList, mVar);
            }
        }
    }

    public final int d() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.d.g0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (cVar = this.f686f) == null || cVar.d.g0 != 8) ? this.g : i;
    }

    public final c f() {
        int i = this.e;
        int iK = p.k(i);
        d dVar = this.d;
        switch (iK) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.K;
            case 2:
                return dVar.L;
            case 3:
                return dVar.I;
            case 4:
                return dVar.J;
            default:
                throw new AssertionError(s1.a.B(i));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f686f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(x5.c r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L5
            goto L65
        L5:
            x5.d r1 = r11.d
            int r11 = r11.e
            r2 = 6
            int r3 = r10.e
            r4 = 1
            if (r11 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r11 = r1.E
            if (r11 == 0) goto L65
            x5.d r11 = r10.d
            boolean r11 = r11.E
            if (r11 != 0) goto L63
            goto L65
        L1c:
            int r5 = z.p.k(r3)
            r6 = 4
            r7 = 2
            r8 = 9
            r9 = 8
            switch(r5) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            java.lang.String r0 = s1.a.B(r3)
            r11.<init>(r0)
            throw r11
        L33:
            if (r11 == r2) goto L65
            if (r11 == r9) goto L65
            if (r11 == r8) goto L65
            goto L63
        L3a:
            if (r11 == r7) goto L65
            if (r11 != r6) goto L63
            goto L65
        L3f:
            r2 = 3
            if (r11 == r2) goto L48
            r2 = 5
            if (r11 != r2) goto L46
            goto L48
        L46:
            r2 = r0
            goto L49
        L48:
            r2 = r4
        L49:
            boolean r1 = r1 instanceof x5.h
            if (r1 == 0) goto L52
            if (r2 != 0) goto L63
            if (r11 != r8) goto L65
            goto L63
        L52:
            return r2
        L53:
            if (r11 == r7) goto L5a
            if (r11 != r6) goto L58
            goto L5a
        L58:
            r2 = r0
            goto L5b
        L5a:
            r2 = r4
        L5b:
            boolean r1 = r1 instanceof x5.h
            if (r1 == 0) goto L64
            if (r2 != 0) goto L63
            if (r11 != r9) goto L65
        L63:
            return r4
        L64:
            return r2
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.i(x5.c):boolean");
    }

    public final void j() {
        HashSet hashSet;
        c cVar = this.f686f;
        if (cVar != null && (hashSet = cVar.a) != null) {
            hashSet.remove(this);
            if (this.f686f.a.size() == 0) {
                this.f686f.a = null;
            }
        }
        this.a = null;
        this.f686f = null;
        this.g = 0;
        this.h = IntCompanionObject.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public final void k() {
        f fVar = this.i;
        if (fVar == null) {
            this.i = new f(1);
        } else {
            fVar.c();
        }
    }

    public final void l(int i) {
        this.b = i;
        this.c = true;
    }

    public final String toString() {
        return this.d.h0 + ":" + s1.a.B(this.e);
    }
}
