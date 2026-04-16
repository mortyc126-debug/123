package xl;

import a21.t;
import a21.u;
import a80.d;
import bb.w;
import com.bandlab.audio.controller.api.smartCompose.SmartComposeService;
import com.bandlab.audio.controller.voiceTransfer.a0;
import com.bandlab.audiocore.generated.Transport;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.media.player.impl.r;
import com.facebook.appevents.p;
import com.gnacba.amuvvoafs.gms.internal.play_billing.o1;
import fy1.l;
import i11.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.time.v;
import mt.b;
import mx1.o;
import ny1.b2;
import ny1.r2;
import ny1.z;
import qi.y;
import vg0.e;
import vl.i;
import wk.j;
import wk.k;
import wk.n;
import y11.o4;
import zl.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements wk.g {
    public static final /* synthetic */ l[] s;
    public final d a;
    public final vl.d b;
    public final a0 c;
    public final c d;
    public final h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ky1.a0 f694f;
    public final y g;
    public final v h;
    public final q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final lx1.h f695j;
    public final b k;
    public final vt1.b l;
    public t1 m;
    public final r2 n;
    public final b2 o;
    public i p;
    public t1 q;
    public final b2 r;

    static {
        l vVar = new lmjxuqdtp.jvm.internal.v(g.class, "smartComposeService", "getSmartComposeService()Lcom/bandlab/audio/controller/api/smartCompose/SmartComposeService;", 0);
        d0.a.getClass();
        s = new l[]{vVar};
    }

    public g(d dVar, vl.d dVar2, a0 a0Var, c cVar, h hVar, ky1.a0 a0Var2, y yVar, v vVar, q qVar, lx1.h hVar2, i iVar, b bVar) {
        this.a = dVar;
        this.b = dVar2;
        this.c = a0Var;
        this.d = cVar;
        this.e = hVar;
        this.f694f = a0Var2;
        this.g = yVar;
        this.h = vVar;
        this.i = qVar;
        this.f695j = hVar2;
        this.k = bVar;
        vt1.b bVarA = iVar.a(new e(1, f(), SmartComposeService.class, "startRecomposeSession", "startRecomposeSession(Llmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 8), new e(1, f(), SmartComposeService.class, "getRemainingFreeRecomposeUsageTokens", "getRemainingFreeRecomposeUsageTokens(Llmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 9), new r(2, f(), SmartComposeService.class, "finishRecomposeSession", "finishRecomposeSession(Ljava/lang/String;Llmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 17));
        this.l = bVarA;
        r2 r2VarC = z.c(j.a);
        this.n = r2VarC;
        this.o = new b2(r2VarC);
        this.r = (b2) bVarA.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(xl.g r10, java.lang.String r11, sx1.c r12) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xl.g.a(xl.g, java.lang.String, sx1.c):java.lang.Object");
    }

    public static final o4 b(g gVar, o4 o4Var) {
        o4 o4VarC;
        dh0.j jVar = (dh0.j) gVar.a.d;
        i iVar = gVar.p;
        if (iVar != null && (o4VarC = iVar.c()) != null) {
            return o4VarC;
        }
        o4 o4VarA = jVar.a();
        return o4Var == o4VarA ? jVar.a() : o4VarA;
    }

    public static wk.l d(n nVar) {
        if (nVar instanceof wk.l) {
            return (wk.l) nVar;
        }
        return null;
    }

    public static String h(double d, float f2) {
        double d3 = (d * ((double) f2)) / ((double) 60);
        double d4 = 4;
        return (((int) (d3 / d4)) + 1) + "." + (((int) (d3 % d4)) + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(sx1.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof xl.c
            if (r0 == 0) goto L13
            r0 = r7
            xl.c r0 = (xl.c) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            xl.c r0 = new xl.c
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r7)
            goto L41
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L2f:
            lg.e.O(r7)
            zl.q r7 = r6.i
            hg0.d r7 = r7.a()
            r0.l = r3
            java.lang.Object r7 = ny1.z.B(r7, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            a80.d r7 = r6.a
            a21.e r7 = r7.E()
            java.util.List r7 = r7.b
            int r7 = r7.size()
            long r4 = (long) r7
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 >= 0) goto L59
            goto L5a
        L59:
            r3 = 0
        L5a:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: xl.g.c(sx1.c):java.lang.Object");
    }

    public final a21.c e() {
        return (a21.c) o.w0(this.a.E().e());
    }

    public final SmartComposeService f() {
        return (SmartComposeService) new jx0.h(d0.a(SmartComposeService.class), this.k).t(s[0]);
    }

    public final void g(k kVar) {
        String strD;
        r2 r2Var = this.n;
        wk.l lVarD = d((n) r2Var.getValue());
        if (lVarD == null) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Ready status is null"), (String[]) Arrays.copyOf(strArr, strArr.length)));
            return;
        }
        if (lVarD.f662j == kVar) {
            return;
        }
        i iVar = this.p;
        String strB = iVar != null ? iVar.b() : null;
        if (strB == null) {
            throw new IllegalStateException("originalTrackId is null");
        }
        boolean z = kVar == k.b;
        d dVar = this.a;
        dVar.N(strB, z);
        i iVar2 = this.p;
        if (iVar2 != null && (strD = iVar2.d()) != null) {
            dVar.N(strD, kVar == k.a);
        }
        while (true) {
            Object value = r2Var.getValue();
            wk.l lVarD2 = d((n) value);
            if (lVarD2 == null) {
                return;
            }
            k kVar2 = kVar;
            if (r2Var.d(value, wk.l.c(lVarD2, false, false, null, kVar2, 511))) {
                return;
            } else {
                kVar = kVar2;
            }
        }
    }

    public final void i(boolean z) {
        if (!p.D(this.a.E().f())) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Cannot edit track"), (String[]) Arrays.copyOf(strArr, strArr.length)));
            return;
        }
        t1 t1Var = this.m;
        if (t1Var != null && t1Var.isActive()) {
            w wVar2 = new w(2);
            ArrayList arrayList2 = wVar2.a;
            wVar2.a("CRITICAL");
            wVar2.e(new String[0]);
            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Compose job is already active"), (String[]) Arrays.copyOf(strArr2, strArr2.length)));
        }
        t1 t1Var2 = this.m;
        if (t1Var2 != null) {
            t1Var2.a((CancellationException) null);
        }
        this.m = c0.F(this.f694f, (qx1.i) null, (b0) null, new tlydtdl.compose.foundation.lazy.layout.w(this, z, (qx1.d) null), 3);
    }

    public final void j() {
        r2 r2Var;
        Object value;
        t1 t1Var = this.m;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        t1 t1Var2 = this.q;
        if (t1Var2 != null) {
            t1Var2.a((CancellationException) null);
        }
        c cVar = this.d;
        ((Transport) cVar.b).stop();
        cVar.x();
        this.e.d();
        c0.F(this.f694f, (qx1.i) null, (b0) null, new b(this, (qx1.d) null, 1), 3);
        do {
            r2Var = this.n;
            value = r2Var.getValue();
        } while (!r2Var.d(value, j.a));
    }

    public final void k(String str) {
        t tVar;
        try {
            u uVarF = this.a.E().f();
            y.k(this.g, "smart_recompose_complete", m8.d.o(new a3.i(this, str, o1.D(e()) > 1.0d, (uVarF == null || (tVar = uVarF.b) == null) ? null : tVar.c())), qi.h.e, 8);
        } catch (Exception e) {
            s02.d.a.g(e);
        }
    }
}
