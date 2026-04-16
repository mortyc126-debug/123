package tlydtdl.core.app;

import a2.r2;
import amuvvoafs.app.PendingIntent;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.os.Bundle;
import com.facebook.internal.t0;
import com.gnacba.amuvvoafs.gms.internal.ads.oa;
import fz0.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import lx1.o;
import okhttp3.HttpUrl;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.s;
import tlydtdl.core.graphics.drawable.IconCompat;
import vb.c;
import vb.q;
import x10.v;
import y10.r;
import z10.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements v2.j {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f560f;
    public Object g;

    public m(je1.m mVar, boolean z, v vVar, boolean z2, Function3 function3, Function3 function32, e1 e1Var) {
        this.c = mVar;
        this.a = z;
        this.d = vVar;
        this.b = z2;
        this.e = function3;
        this.f560f = function32;
        this.g = e1Var;
    }

    public static final void a(m mVar, fc.a aVar) throws Throwable {
        b0 b0VarU;
        q7.e eVar = (q7.e) mVar.d;
        c cVar = (c) mVar.c;
        vb.t tVar = cVar.g;
        vb.t tVar2 = vb.t.c;
        if (tVar == tVar2) {
            d.q(aVar, "PRAGMA journal_mode = WAL");
        } else {
            d.q(aVar, "PRAGMA journal_mode = TRUNCATE");
        }
        if (cVar.g == tVar2) {
            d.q(aVar, "PRAGMA synchronous = NORMAL");
        } else {
            d.q(aVar, "PRAGMA synchronous = FULL");
        }
        c(aVar);
        fc.c cVarA0 = aVar.A0("PRAGMA user_version");
        try {
            cVarA0.w0();
            int i = (int) cVarA0.getLong(0);
            t0.o(cVarA0, (Throwable) null);
            int i2 = eVar.a;
            if (i != i2) {
                d.q(aVar, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        mVar.e(aVar);
                    } else {
                        mVar.f(aVar, i, i2);
                    }
                    d.q(aVar, "PRAGMA user_version = " + i2);
                    b0VarU = b0.a;
                } catch (Throwable th) {
                    b0VarU = lg.e.u(th);
                }
                if (!(b0VarU instanceof lx1.n)) {
                    d.q(aVar, "END TRANSACTION");
                }
                Throwable thA = o.a(b0VarU);
                if (thA != null) {
                    d.q(aVar, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            mVar.g(aVar);
        } finally {
        }
    }

    public static void c(fc.a aVar) {
        fc.c cVarA0 = aVar.A0("PRAGMA busy_timeout");
        try {
            cVarA0.w0();
            long j2 = cVarA0.getLong(0);
            t0.o(cVarA0, (Throwable) null);
            if (j2 < 3000) {
                d.q(aVar, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t0.o(cVarA0, th);
                throw th2;
            }
        }
    }

    @Override // v2.j
    public void D(q3.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        q3.k kVar2;
        s sVar = (s) mVar;
        sVar.h0(28322246);
        int i2 = (sVar.g(this) ? 32 : 16) | i;
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            kVar2 = kVar;
            r.e(((je1.m) this.c).a(), this.a, ((Boolean) ((e1) this.g).getValue()).booleanValue(), (v) this.d, this.b, (Function3) this.e, (Function3) this.f560f, kVar2, sVar, 12582912);
        } else {
            kVar2 = kVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new r2(this, kVar2, i, 24);
        }
    }

    public n b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<t0> arrayList3 = (ArrayList) this.g;
        if (arrayList3 != null) {
            for (t0 t0Var : arrayList3) {
                t0Var.getClass();
                arrayList2.add(t0Var);
            }
        }
        return new n((IconCompat) this.c, (CharSequence) this.d, (PendingIntent) this.e, (Bundle) this.f560f, arrayList2.isEmpty() ? null : (t0[]) arrayList2.toArray(new t0[arrayList2.size()]), arrayList.isEmpty() ? null : (t0[]) arrayList.toArray(new t0[arrayList.size()]), this.a, this.b);
    }

    public gc.c d() {
        vp1.b bVar;
        yb.b bVar2 = (xb.b) this.f560f;
        yb.b bVar3 = bVar2 instanceof yb.b ? bVar2 : null;
        if (bVar3 == null || (bVar = bVar3.a) == null) {
            return null;
        }
        return (gc.c) bVar.b;
    }

    public void e(fc.a aVar) {
        q7.e eVar = (q7.e) this.d;
        lmjxuqdtp.jvm.internal.o.h(aVar, "connection");
        fc.c cVarA0 = aVar.A0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cVarA0.w0()) {
                if (cVarA0.getLong(0) == 0) {
                    z = true;
                }
            }
            t0.o(cVarA0, (Throwable) null);
            eVar.a(aVar);
            if (!z) {
                oa oaVarG = eVar.g(aVar);
                if (!oaVarG.a) {
                    throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + ((String) oaVarG.b)).toString());
                }
            }
            d.q(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            d.q(aVar, qc0.b.l((String) eVar.b));
            eVar.c(aVar);
            Iterator it = ((List) this.e).iterator();
            while (it.hasNext()) {
                ((vb.s) it.next()).getClass();
                if (aVar instanceof yb.a) {
                    lmjxuqdtp.jvm.internal.o.h(((yb.a) aVar).a, "db");
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x00a8 A[EDGE_INSN: B:126:0x00a8->B:38:0x00a8 BREAK  A[LOOP:4: B:9:0x0031->B:130:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(fc.a r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.core.app.m.f(fc.a, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(fc.a r11) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.core.app.m.g(fc.a):void");
    }

    public m(c cVar, q7.e eVar) {
        int i;
        xb.e eVarL;
        vb.t tVar = cVar.g;
        gc.b bVar = cVar.c;
        String str = cVar.b;
        this.c = cVar;
        this.d = eVar;
        mx1.t tVar2 = cVar.e;
        this.e = tVar2 == null ? mx1.t.a : tVar2;
        fc.b bVar2 = cVar.t;
        if (bVar2 != null) {
            if (str == null) {
                eVarL = q30.n.M(new vb.a(this, bVar2));
            } else {
                vb.a aVar = new vb.a(this, bVar2);
                int[] iArr = vb.b.$EnumSwitchMapping$0;
                int i2 = iArr[tVar.ordinal()];
                if (i2 == 1) {
                    i = 1;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + tVar + '\'').toString());
                    }
                    i = 4;
                }
                int i3 = iArr[tVar.ordinal()];
                if (i3 != 1 && i3 != 2) {
                    throw new IllegalStateException(("Can't get max number of writers for journal mode '" + tVar + '\'').toString());
                }
                eVarL = q30.n.L(aVar, str, i);
            }
            this.f560f = eVarL;
        } else {
            if (bVar == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            Context context = cVar.a;
            lmjxuqdtp.jvm.internal.o.h(context, "context");
            this.f560f = new yb.b(new vp1.b(bVar.e(new p(context, str, new rd.d(this, eVar.a), false, false))));
        }
        boolean z = tVar == vb.t.c;
        gc.c cVarD = d();
        if (cVarD != null) {
            cVarD.setWriteAheadLoggingEnabled(z);
        }
    }

    public m(c cVar, uc0.a aVar) {
        this.c = cVar;
        this.d = new vb.p();
        List list = cVar.e;
        List list2 = mx1.t.a;
        this.e = list == null ? list2 : list;
        ArrayList arrayListS0 = mx1.o.S0(list == null ? list2 : list, new q(new sr0.d(26, this)));
        Context context = cVar.a;
        String str = cVar.b;
        gc.b bVar = cVar.c;
        b8.e eVar = cVar.d;
        boolean z = cVar.f;
        vb.t tVar = cVar.g;
        Executor executor = cVar.h;
        Executor executor2 = cVar.i;
        Intent intent = cVar.j;
        boolean z2 = cVar.k;
        boolean z3 = cVar.l;
        Set set = cVar.m;
        String str2 = cVar.n;
        File file = cVar.o;
        Callable callable = cVar.p;
        List list3 = cVar.q;
        List list4 = cVar.r;
        boolean z4 = cVar.s;
        fc.b bVar2 = cVar.t;
        qx1.i iVar = cVar.u;
        lmjxuqdtp.jvm.internal.o.h(context, "context");
        lmjxuqdtp.jvm.internal.o.h(eVar, "migrationContainer");
        lmjxuqdtp.jvm.internal.o.h(executor, "queryExecutor");
        lmjxuqdtp.jvm.internal.o.h(executor2, "transactionExecutor");
        lmjxuqdtp.jvm.internal.o.h(list3, "typeConverters");
        lmjxuqdtp.jvm.internal.o.h(list4, "autoMigrationSpecs");
        aVar.invoke(new c(context, str, bVar, eVar, arrayListS0, z, tVar, executor, executor2, intent, z2, z3, set, str2, file, callable, list3, list4, z4, bVar2, iVar));
        throw null;
    }

    public m(int i, PendingIntent pendingIntent, String str) {
        this(i != 0 ? IconCompat.b(null, HttpUrl.FRAGMENT_ENCODE_SET, i) : null, str, pendingIntent, new Bundle());
    }

    public m(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.a = true;
        this.b = true;
        this.c = iconCompat;
        this.d = t.b(charSequence);
        this.e = pendingIntent;
        this.f560f = bundle;
        this.g = null;
        this.a = true;
        this.b = true;
    }
}
