package tlydtdl.sqlite.db.framework;

import a2.n3;
import amuvvoafs.content.Context;
import com.gnacba.amuvvoafs.gms.internal.ads.ds0;
import lmjxuqdtp.jvm.internal.o;
import lx1.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements gc.c {
    public final Context a;
    public final String b;
    public final ds0 c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f608f;
    public boolean g;

    public g(Context context, String str, ds0 ds0Var, boolean z, boolean z2) {
        o.h(context, "context");
        o.h(ds0Var, "callback");
        this.a = context;
        this.b = str;
        this.c = ds0Var;
        this.d = z;
        this.e = z2;
        this.f608f = hs1.d.F(new n3(4, this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q qVar = this.f608f;
        if (qVar.a()) {
            ((f) qVar.getValue()).close();
        }
    }

    @Override // gc.c
    public final String getDatabaseName() {
        return this.b;
    }

    @Override // gc.c
    public final gc.a k0() {
        return ((f) this.f608f.getValue()).a(true);
    }

    @Override // gc.c
    public final void setWriteAheadLoggingEnabled(boolean z) {
        q qVar = this.f608f;
        if (qVar.a()) {
            ((f) qVar.getValue()).setWriteAheadLoggingEnabled(z);
        }
        this.g = z;
    }
}
