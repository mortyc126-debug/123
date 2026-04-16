package wz0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import ny1.p2;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public final String a;
    public final int b;
    public final of1.n c;
    public final ld1.r d;
    public final ld1.r e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ld1.r f671f;
    public final ld1.r g;
    public final h5.s h;
    public final p2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f672j;
    public final ld1.r k;
    public final Function1 l;
    public final Function1 m;
    public final Function1 n;
    public final Function0 o;
    public final Function0 p;

    public n0(String str, int i, of1.n nVar, ld1.r rVar, ld1.r rVar2, ld1.r rVar3, ld1.r rVar4, h5.s sVar, p2 p2Var, boolean z, ld1.r rVar5, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02) {
        lmjxuqdtp.jvm.internal.o.h(str, "caption");
        lmjxuqdtp.jvm.internal.o.h(nVar, "textStyle");
        lmjxuqdtp.jvm.internal.o.h(rVar, "textColor");
        lmjxuqdtp.jvm.internal.o.h(rVar5, "ellipsisColor");
        lmjxuqdtp.jvm.internal.o.h(function1, "onHashtagClick");
        lmjxuqdtp.jvm.internal.o.h(function12, "onMentionClick");
        lmjxuqdtp.jvm.internal.o.h(function13, "onUrlClick");
        this.a = str;
        this.b = i;
        this.c = nVar;
        this.d = rVar;
        this.e = rVar2;
        this.f671f = rVar3;
        this.g = rVar4;
        this.h = sVar;
        this.i = p2Var;
        this.f672j = z;
        this.k = rVar5;
        this.l = function1;
        this.m = function12;
        this.n = function13;
        this.o = function0;
        this.p = function02;
    }

    public static n0 a(n0 n0Var, int i, of1.n nVar, ld1.q qVar, ld1.q qVar2, ld1.q qVar3, h5.s sVar, ld1.q qVar4, int i2) {
        String str = n0Var.a;
        of1.n nVar2 = (i2 & 4) != 0 ? n0Var.c : nVar;
        ld1.r rVar = n0Var.d;
        ld1.q qVar5 = (i2 & 16) != 0 ? n0Var.e : qVar;
        ld1.q qVar6 = (i2 & 32) != 0 ? n0Var.f671f : qVar2;
        ld1.q qVar7 = (i2 & 64) != 0 ? n0Var.g : qVar3;
        h5.s sVar2 = (i2 & 128) != 0 ? n0Var.h : sVar;
        p2 p2Var = n0Var.i;
        boolean z = n0Var.f672j;
        ld1.q qVar8 = (i2 & 1024) != 0 ? n0Var.k : qVar4;
        Function1 function1 = n0Var.l;
        Function1 function12 = n0Var.m;
        Function1 function13 = n0Var.n;
        Function0 function0 = n0Var.o;
        Function0 function02 = n0Var.p;
        n0Var.getClass();
        lmjxuqdtp.jvm.internal.o.h(str, "caption");
        lmjxuqdtp.jvm.internal.o.h(nVar2, "textStyle");
        lmjxuqdtp.jvm.internal.o.h(rVar, "textColor");
        lmjxuqdtp.jvm.internal.o.h(qVar8, "ellipsisColor");
        lmjxuqdtp.jvm.internal.o.h(function1, "onHashtagClick");
        lmjxuqdtp.jvm.internal.o.h(function12, "onMentionClick");
        lmjxuqdtp.jvm.internal.o.h(function13, "onUrlClick");
        return new n0(str, i, nVar2, rVar, qVar5, qVar6, qVar7, sVar2, p2Var, z, qVar8, function1, function12, function13, function0, function02);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, n0Var.a) && this.b == n0Var.b && lmjxuqdtp.jvm.internal.o.c(this.c, n0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, n0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, n0Var.e) && lmjxuqdtp.jvm.internal.o.c(this.f671f, n0Var.f671f) && lmjxuqdtp.jvm.internal.o.c(this.g, n0Var.g) && lmjxuqdtp.jvm.internal.o.c(this.h, n0Var.h) && lmjxuqdtp.jvm.internal.o.c(this.i, n0Var.i) && this.f672j == n0Var.f672j && lmjxuqdtp.jvm.internal.o.c(this.k, n0Var.k) && lmjxuqdtp.jvm.internal.o.c(this.l, n0Var.l) && lmjxuqdtp.jvm.internal.o.c(this.m, n0Var.m) && lmjxuqdtp.jvm.internal.o.c(this.n, n0Var.n) && lmjxuqdtp.jvm.internal.o.c(this.o, n0Var.o) && lmjxuqdtp.jvm.internal.o.c(this.p, n0Var.p);
    }

    public final int hashCode() {
        int iF = com.gnacba.ads.interactivemedia.v3.internal.a.f(this.d, q2.i(this.c, s1.a.c(this.b, this.a.hashCode() * 31, 31), 31), 31);
        ld1.r rVar = this.e;
        int iHashCode = (iF + (rVar == null ? 0 : rVar.hashCode())) * 31;
        ld1.r rVar2 = this.f671f;
        int iHashCode2 = (iHashCode + (rVar2 == null ? 0 : rVar2.hashCode())) * 31;
        ld1.r rVar3 = this.g;
        int iHashCode3 = (iHashCode2 + (rVar3 == null ? 0 : rVar3.hashCode())) * 31;
        h5.s sVar = this.h;
        int i = (iHashCode3 + (sVar == null ? 0 : sVar.a)) * 31;
        p2 p2Var = this.i;
        int iB = q2.b(q2.b(q2.b(com.gnacba.ads.interactivemedia.v3.internal.a.f(this.k, s1.a.f((i + (p2Var == null ? 0 : p2Var.hashCode())) * 31, 31, this.f672j), 31), 31, this.l), 31, this.m), 31, this.n);
        Function0 function0 = this.o;
        int iHashCode4 = (iB + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function0 function02 = this.p;
        return iHashCode4 + (function02 != null ? function02.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbR = i.r("TextState(caption=", this.b, this.a, ", maxLines=", ", textStyle=");
        sbR.append(this.c);
        sbR.append(", textColor=");
        sbR.append(this.d);
        sbR.append(", hashtagColor=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sbR, this.e, ", mentionsColor=", this.f671f, ", linkColor=");
        sbR.append(this.g);
        sbR.append(", annotationsWeight=");
        sbR.append(this.h);
        sbR.append(", shouldTextCollapse=");
        sbR.append(this.i);
        sbR.append(", isTapEllipsisLabelOnly=");
        sbR.append(this.f672j);
        sbR.append(", ellipsisColor=");
        sbR.append(this.k);
        sbR.append(", onHashtagClick=");
        sbR.append(this.l);
        sbR.append(", onMentionClick=");
        sbR.append(this.m);
        sbR.append(", onUrlClick=");
        sbR.append(this.n);
        sbR.append(", onEllipsisClick=");
        sbR.append(this.o);
        sbR.append(", onCollapseClick=");
        sbR.append(this.p);
        sbR.append(")");
        return sbR.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public n0(java.lang.String r20, int r21, of1.n r22, ld1.q r23, ld1.q r24, ld1.q r25, ld1.q r26, h5.s r27, ny1.p2 r28, boolean r29, ld1.q r30, lmjxuqdtp.jvm.functions.Function1 r31, lmjxuqdtp.jvm.functions.Function1 r32, lmjxuqdtp.jvm.functions.Function1 r33, lmjxuqdtp.jvm.functions.Function0 r34, lmjxuqdtp.jvm.functions.Function0 r35, int r36) {
        /*
            r19 = this;
            r0 = r36
            r1 = r0 & 8
            if (r1 == 0) goto L11
            ld1.d r1 = ld1.r.Companion
            r2 = 2131099932(0x7f06011c, float:1.7812231E38)
            ld1.q r1 = i.u(r1, r2)
            r6 = r1
            goto L13
        L11:
            r6 = r23
        L13:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L1a
            r7 = r2
            goto L1c
        L1a:
            r7 = r24
        L1c:
            r1 = r0 & 32
            if (r1 == 0) goto L22
            r8 = r2
            goto L24
        L22:
            r8 = r25
        L24:
            r1 = r0 & 64
            if (r1 == 0) goto L2a
            r9 = r2
            goto L2c
        L2a:
            r9 = r26
        L2c:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L32
            r10 = r2
            goto L34
        L32:
            r10 = r27
        L34:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L3a
            r11 = r2
            goto L3c
        L3a:
            r11 = r28
        L3c:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L43
            r1 = 0
            r12 = r1
            goto L45
        L43:
            r12 = r29
        L45:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L54
            ld1.d r1 = ld1.r.Companion
            r3 = 2131099933(0x7f06011d, float:1.7812233E38)
            ld1.q r1 = i.u(r1, r3)
            r13 = r1
            goto L56
        L54:
            r13 = r30
        L56:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L6f
            r18 = r2
            r3 = r20
            r4 = r21
            r5 = r22
            r14 = r31
            r15 = r32
            r16 = r33
            r17 = r34
            r2 = r19
            goto L81
        L6f:
            r18 = r35
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r14 = r31
            r15 = r32
            r16 = r33
            r17 = r34
        L81:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wz0.n0.<init>(java.lang.String, int, of1.n, ld1.q, ld1.q, ld1.q, ld1.q, h5.s, ny1.p2, boolean, ld1.q, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function0, lmjxuqdtp.jvm.functions.Function0, int):void");
    }
}
