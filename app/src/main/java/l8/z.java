package l8;

import amuvvoafs.net.Uri;
import com.gnacba.common.collect.f1;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public String a;
    public Uri b;
    public String c;
    public String g;
    public y i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f313j;
    public n0 l;
    public a0 d = new a0();
    public ec.b e = new ec.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f312f = Collections.EMPTY_LIST;
    public com.gnacba.common.collect.k0 h = f1.e;
    public e0 m = new e0();
    public h0 n = h0.d;
    public long k = -9223372036854775807L;

    public final k0 a() {
        g0 g0Var;
        ec.b bVar = this.e;
        o8.b.h(((Uri) bVar.e) == null || ((UUID) bVar.d) != null);
        Uri uri = this.b;
        if (uri != null) {
            String str = this.c;
            ec.b bVar2 = this.e;
            g0Var = new g0(uri, str, ((UUID) bVar2.d) != null ? new d0(bVar2) : null, this.i, this.f312f, this.g, this.h, this.f313j, this.k);
        } else {
            g0Var = null;
        }
        String str2 = this.a;
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str3 = str2;
        a0 a0Var = this.d;
        a0Var.getClass();
        c0 c0Var = new c0(a0Var);
        e0 e0Var = this.m;
        e0Var.getClass();
        f0 f0Var = new f0(e0Var);
        n0 n0Var = this.l;
        if (n0Var == null) {
            n0Var = n0.K;
        }
        return new k0(str3, c0Var, g0Var, f0Var, n0Var, this.n);
    }

    public final void b(String str) {
        this.b = str == null ? null : Uri.parse(str);
    }
}
