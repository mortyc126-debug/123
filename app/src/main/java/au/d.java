package au;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;
import lx1.j;
import o10.g3;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class d implements q {
    public static final c Companion = new c();

    /* JADX INFO: renamed from: j */
    public static final h[] f7j;
    public final x a;
    public final Integer b;
    public final g3 c;
    public final boolean d;
    public final Integer e;

    /* JADX INFO: renamed from: f */
    public final String f8f;
    public final String g;
    public final boolean h;
    public final String i;

    static {
        j jVar = j.a;
        f7j = new h[]{hs1.d.E(jVar, new g(18)), null, hs1.d.E(jVar, new g(19)), null, null, null, null, null, null};
    }

    public d(int i, x xVar, Integer num, g3 g3Var, boolean z, Integer num2, String str, String str2, boolean z2, String str3) {
        if (5 != (i & 5)) {
            b2.b(i, 5, b.a.getDescriptor());
            throw null;
        }
        this.a = xVar;
        if ((i & 2) == 0) {
            this.b = 6;
        } else {
            this.b = num;
        }
        this.c = g3Var;
        if ((i & 8) == 0) {
            this.d = true;
        } else {
            this.d = z;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = num2;
        }
        if ((i & 32) == 0) {
            this.f8f = null;
        } else {
            this.f8f = str;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str2;
        }
        if ((i & 128) == 0) {
            this.h = false;
        } else {
            this.h = z2;
        }
        if ((i & 256) == 0) {
            this.i = g3Var.toString();
        } else {
            this.i = str3;
        }
    }

    @Override // au.q
    public final Integer e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && o.c(this.b, dVar.b) && o.c(this.c, dVar.c) && this.d == dVar.d && o.c(this.e, dVar.e) && o.c(this.f8f, dVar.f8f) && o.c(this.g, dVar.g) && this.h == dVar.h;
    }

    @Override // au.q
    public final g3 f() {
        return this.c;
    }

    @Override // au.q
    public final String getId() {
        return this.i;
    }

    @Override // au.q
    public final x getType() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iF = s1.a.f((this.c.hashCode() + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31)) * 31, 31, this.d);
        Integer num2 = this.e;
        int iHashCode2 = (iF + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f8f;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return Boolean.hashCode(this.h) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Generic(type=" + this.a + ", limit=" + this.b + ", playlistSource=" + this.c + ", excludePurchased=" + this.d + ", offset=" + this.e + ", sort=" + this.f8f + ", filter=" + this.g + ", randomLocally=" + this.h + ")";
    }

    public d(x xVar, Integer num, g3 g3Var, boolean z, Integer num2, String str, String str2, boolean z2) {
        o.h(xVar, "type");
        o.h(g3Var, "playlistSource");
        this.a = xVar;
        this.b = num;
        this.c = g3Var;
        this.d = z;
        this.e = num2;
        this.f8f = str;
        this.g = str2;
        this.h = z2;
        this.i = g3Var.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ d(au.x r11, java.lang.Integer r12, o10.g3 r13, java.lang.String r14, int r15) {
        /*
            r10 = this;
            r0 = 4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r15 & 2
            if (r1 == 0) goto Le
            r12 = 6
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
        Le:
            r3 = r12
            r12 = r15 & 8
            r1 = 0
            r2 = 1
            if (r12 == 0) goto L17
            r5 = r2
            goto L18
        L17:
            r5 = r1
        L18:
            r12 = r15 & 16
            r4 = 0
            if (r12 == 0) goto L1f
            r6 = r4
            goto L20
        L1f:
            r6 = r0
        L20:
            r12 = r15 & 64
            if (r12 == 0) goto L26
        L24:
            r8 = r4
            goto L29
        L26:
            java.lang.String r4 = "RecentlyPlayed"
            goto L24
        L29:
            r12 = r15 & 128(0x80, float:1.8E-43)
            if (r12 == 0) goto L33
            r9 = r1
            r2 = r11
            r4 = r13
            r7 = r14
            r1 = r10
            goto L38
        L33:
            r9 = r2
            r1 = r10
            r4 = r13
            r7 = r14
            r2 = r11
        L38:
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.d.<init>(au.x, java.lang.Integer, o10.g3, java.lang.String, int):void");
    }
}
