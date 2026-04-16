package l8;

import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import com.facebook.internal.j;
import com.gnacba.common.collect.f1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import jx0.h;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public static final k0 g;
    public static final String h;
    public static final String i;

    /* JADX INFO: renamed from: j */
    public static final String f298j;
    public static final String k;
    public static final String l;
    public static final String m;
    public final String a;
    public final g0 b;
    public final f0 c;
    public final n0 d;
    public final c0 e;

    /* JADX INFO: renamed from: f */
    public final h0 f299f;

    static {
        a0 a0Var = new a0();
        com.gnacba.common.collect.h0 h0Var = com.gnacba.common.collect.k0.b;
        f1 f1Var = f1.e;
        List list = Collections.EMPTY_LIST;
        f1 f1Var2 = f1.e;
        e0 e0Var = new e0();
        g = new k0(HttpUrl.FRAGMENT_ENCODE_SET, new c0(a0Var), null, new f0(e0Var), n0.K, h0.d);
        h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f298j = Integer.toString(2, 36);
        k = Integer.toString(3, 36);
        l = Integer.toString(4, 36);
        m = Integer.toString(5, 36);
    }

    public k0(String str, c0 c0Var, g0 g0Var, f0 f0Var, n0 n0Var, h0 h0Var) {
        this.a = str;
        this.b = g0Var;
        this.c = f0Var;
        this.d = n0Var;
        this.e = c0Var;
        this.f299f = h0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.Cloneable] */
    /* JADX WARN: Type inference failed for: r1v55 */
    public static k0 b(Bundle bundle) {
        c0 c0Var;
        h0 h0Var;
        d0 d0Var;
        y yVarB;
        f1 f1VarS;
        f1 f1VarS2;
        g0 g0Var;
        String string = bundle.getString(h, HttpUrl.FRAGMENT_ENCODE_SET);
        string.getClass();
        Bundle bundle2 = bundle.getBundle(i);
        f0 f0VarB = bundle2 == null ? f0.f289f : f0.b(bundle2);
        Bundle bundle3 = bundle.getBundle(f298j);
        n0 n0VarB = bundle3 == null ? n0.K : n0.b(bundle3);
        Bundle bundle4 = bundle.getBundle(k);
        if (bundle4 == null) {
            c0Var = c0.p;
        } else {
            a0 a0Var = new a0();
            String str = b0.i;
            b0 b0Var = b0.h;
            long j2 = b0Var.a;
            long j3 = b0Var.d;
            long j4 = b0Var.b;
            long jU = o8.f0.U(bundle4.getLong(str, j2));
            o8.b.c(jU >= 0);
            a0Var.a = jU;
            a0Var.a(o8.f0.U(bundle4.getLong(b0.f283j, b0Var.c)));
            a0Var.c = bundle4.getBoolean(b0.k, b0Var.e);
            a0Var.d = bundle4.getBoolean(b0.l, b0Var.f284f);
            a0Var.e = bundle4.getBoolean(b0.m, b0Var.g);
            long j5 = bundle4.getLong(b0.n, j4);
            if (j5 != j4) {
                o8.b.c(j5 >= 0);
                a0Var.a = j5;
            }
            long j6 = bundle4.getLong(b0.o, j3);
            if (j6 != j3) {
                a0Var.a(j6);
            }
            c0Var = new c0(a0Var);
        }
        c0 c0Var2 = c0Var;
        Bundle bundle5 = bundle.getBundle(l);
        if (bundle5 == null) {
            h0Var = h0.d;
        } else {
            h hVar = new h(5, false);
            hVar.b = bundle5.getParcelable(h0.e);
            hVar.c = bundle5.getString(h0.f293f);
            hVar.d = bundle5.getBundle(h0.g);
            h0Var = new h0(hVar);
        }
        h0 h0Var2 = h0Var;
        Bundle bundle6 = bundle.getBundle(m);
        if (bundle6 == null) {
            g0Var = null;
        } else {
            Bundle bundle7 = bundle6.getBundle(g0.l);
            if (bundle7 == null) {
                d0Var = null;
            } else {
                String string2 = bundle7.getString(d0.i);
                string2.getClass();
                UUID uuidFromString = UUID.fromString(string2);
                Uri parcelable = bundle7.getParcelable(d0.f287j);
                String str2 = d0.k;
                Bundle bundle8 = Bundle.EMPTY;
                com.gnacba.common.collect.n0 n0VarD = o8.d.d(o8.d.v(bundle7, str2));
                boolean z = bundle7.getBoolean(d0.l, false);
                boolean z2 = bundle7.getBoolean(d0.m, false);
                boolean z3 = bundle7.getBoolean(d0.n, false);
                com.gnacba.common.collect.k0 k0VarO = com.gnacba.common.collect.k0.o(o8.d.y(bundle7, d0.o, new ArrayList()));
                byte[] byteArray = bundle7.getByteArray(d0.p);
                ec.b bVar = new ec.b();
                bVar.d = uuidFromString;
                bVar.e = parcelable;
                bVar.f = com.gnacba.common.collect.n0.a(n0VarD);
                bVar.a = z;
                bVar.c = z3;
                bVar.b = z2;
                bVar.g = com.gnacba.common.collect.k0.o(k0VarO);
                bVar.h = byteArray != null ? Arrays.copyOf(byteArray, byteArray.length) : 0;
                d0Var = new d0(bVar);
            }
            Bundle bundle9 = bundle6.getBundle(g0.m);
            if (bundle9 == null) {
                yVarB = null;
            } else {
                Uri parcelable2 = bundle9.getParcelable(y.b);
                parcelable2.getClass();
                yVarB = new j(parcelable2).b();
            }
            ArrayList parcelableArrayList = bundle6.getParcelableArrayList(g0.n);
            if (parcelableArrayList == null) {
                com.gnacba.common.collect.h0 h0Var3 = com.gnacba.common.collect.k0.b;
                f1VarS = f1.e;
            } else {
                f1VarS = o8.d.s(parcelableArrayList, new k(4));
            }
            f1 f1Var = f1VarS;
            ArrayList parcelableArrayList2 = bundle6.getParcelableArrayList(g0.p);
            if (parcelableArrayList2 == null) {
                com.gnacba.common.collect.h0 h0Var4 = com.gnacba.common.collect.k0.b;
                f1VarS2 = f1.e;
            } else {
                f1VarS2 = o8.d.s(parcelableArrayList2, new k(5));
            }
            f1 f1Var2 = f1VarS2;
            long j7 = bundle6.getLong(g0.q, -9223372036854775807L);
            Uri parcelable3 = bundle6.getParcelable(g0.f291j);
            parcelable3.getClass();
            g0Var = new g0(parcelable3, bundle6.getString(g0.k), d0Var, yVarB, f1Var, bundle6.getString(g0.o), f1Var2, null, j7);
        }
        return new k0(string, c0Var2, g0Var, f0VarB, n0VarB, h0Var2);
    }

    public static k0 c(Uri uri) {
        g0 g0Var;
        a0 a0Var = new a0();
        ec.b bVar = new ec.b();
        List list = Collections.EMPTY_LIST;
        f1 f1Var = f1.e;
        e0 e0Var = new e0();
        h0 h0Var = h0.d;
        o8.b.h(((Uri) bVar.e) == null || ((UUID) bVar.d) != null);
        d0 d0Var = null;
        if (uri != null) {
            if (((UUID) bVar.d) != null) {
                d0Var = new d0(bVar);
            }
            g0Var = new g0(uri, null, d0Var, null, list, null, f1Var, null, -9223372036854775807L);
        } else {
            g0Var = null;
        }
        return new k0(HttpUrl.FRAGMENT_ENCODE_SET, new c0(a0Var), g0Var, new f0(e0Var), n0.K, h0Var);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [byte[], java.lang.Cloneable] */
    public final z a() {
        ec.b bVar;
        z zVar = new z();
        zVar.d = this.e.a();
        zVar.a = this.a;
        zVar.l = this.d;
        zVar.m = this.c.a();
        zVar.n = this.f299f;
        g0 g0Var = this.b;
        if (g0Var != null) {
            zVar.g = g0Var.f292f;
            zVar.c = g0Var.b;
            zVar.b = g0Var.a;
            zVar.f312f = g0Var.e;
            zVar.h = g0Var.g;
            zVar.f313j = g0Var.h;
            d0 d0Var = g0Var.c;
            if (d0Var != null) {
                bVar = new ec.b();
                bVar.d = d0Var.a;
                bVar.e = d0Var.b;
                bVar.f = d0Var.c;
                bVar.a = d0Var.d;
                bVar.b = d0Var.e;
                bVar.c = d0Var.f288f;
                bVar.g = d0Var.g;
                bVar.h = d0Var.h;
            } else {
                bVar = new ec.b();
            }
            zVar.e = bVar;
            zVar.i = g0Var.d;
            zVar.k = g0Var.i;
        }
        return zVar;
    }

    public final Bundle d(boolean z) {
        g0 g0Var;
        Bundle bundle = new Bundle();
        String str = this.a;
        if (!str.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
            bundle.putString(h, str);
        }
        f0 f0Var = f0.f289f;
        f0 f0Var2 = this.c;
        if (!f0Var2.equals(f0Var)) {
            bundle.putBundle(i, f0Var2.c());
        }
        n0 n0Var = n0.K;
        n0 n0Var2 = this.d;
        if (!n0Var2.equals(n0Var)) {
            bundle.putBundle(f298j, n0Var2.c());
        }
        b0 b0Var = b0.h;
        c0 c0Var = this.e;
        if (!c0Var.equals(b0Var)) {
            Bundle bundle2 = new Bundle();
            long j2 = c0Var.a;
            if (j2 != b0Var.a) {
                bundle2.putLong(b0.i, j2);
            }
            long j3 = c0Var.c;
            if (j3 != b0Var.c) {
                bundle2.putLong(b0.f283j, j3);
            }
            long j4 = c0Var.b;
            if (j4 != b0Var.b) {
                bundle2.putLong(b0.n, j4);
            }
            long j5 = c0Var.d;
            if (j5 != b0Var.d) {
                bundle2.putLong(b0.o, j5);
            }
            boolean z2 = c0Var.e;
            if (z2 != b0Var.e) {
                bundle2.putBoolean(b0.k, z2);
            }
            boolean z3 = c0Var.f284f;
            if (z3 != b0Var.f284f) {
                bundle2.putBoolean(b0.l, z3);
            }
            boolean z4 = c0Var.g;
            if (z4 != b0Var.g) {
                bundle2.putBoolean(b0.m, z4);
            }
            bundle.putBundle(k, bundle2);
        }
        h0 h0Var = h0.d;
        h0 h0Var2 = this.f299f;
        if (!h0Var2.equals(h0Var)) {
            Bundle bundle3 = new Bundle();
            Uri uri = h0Var2.a;
            if (uri != null) {
                bundle3.putParcelable(h0.e, uri);
            }
            String str2 = h0Var2.b;
            if (str2 != null) {
                bundle3.putString(h0.f293f, str2);
            }
            Bundle bundle4 = h0Var2.c;
            if (bundle4 != null) {
                bundle3.putBundle(h0.g, bundle4);
            }
            bundle.putBundle(l, bundle3);
        }
        if (z && (g0Var = this.b) != null) {
            com.gnacba.common.collect.k0 k0Var = g0Var.g;
            List list = g0Var.e;
            Bundle bundle5 = new Bundle();
            bundle5.putParcelable(g0.f291j, g0Var.a);
            String str3 = g0Var.b;
            if (str3 != null) {
                bundle5.putString(g0.k, str3);
            }
            d0 d0Var = g0Var.c;
            if (d0Var != null) {
                String str4 = g0.l;
                com.gnacba.common.collect.k0 k0Var2 = d0Var.g;
                com.gnacba.common.collect.n0 n0Var3 = d0Var.c;
                Bundle bundle6 = new Bundle();
                bundle6.putString(d0.i, d0Var.a.toString());
                Uri uri2 = d0Var.b;
                if (uri2 != null) {
                    bundle6.putParcelable(d0.f287j, uri2);
                }
                if (!n0Var3.isEmpty()) {
                    bundle6.putBundle(d0.k, o8.d.M(n0Var3));
                }
                boolean z5 = d0Var.d;
                if (z5) {
                    bundle6.putBoolean(d0.l, z5);
                }
                boolean z6 = d0Var.e;
                if (z6) {
                    bundle6.putBoolean(d0.m, z6);
                }
                boolean z7 = d0Var.f288f;
                if (z7) {
                    bundle6.putBoolean(d0.n, z7);
                }
                if (!k0Var2.isEmpty()) {
                    bundle6.putIntegerArrayList(d0.o, new ArrayList((Collection) k0Var2));
                }
                byte[] bArr = d0Var.h;
                if (bArr != null) {
                    bundle6.putByteArray(d0.p, bArr);
                }
                bundle5.putBundle(str4, bundle6);
            }
            y yVar = g0Var.d;
            if (yVar != null) {
                String str5 = g0.m;
                Bundle bundle7 = new Bundle();
                bundle7.putParcelable(y.b, yVar.a);
                bundle5.putBundle(str5, bundle7);
            }
            if (!list.isEmpty()) {
                bundle5.putParcelableArrayList(g0.n, o8.d.N(list, new k(2)));
            }
            String str6 = g0Var.f292f;
            if (str6 != null) {
                bundle5.putString(g0.o, str6);
            }
            if (!k0Var.isEmpty()) {
                bundle5.putParcelableArrayList(g0.p, o8.d.N(k0Var, new k(3)));
            }
            long j6 = g0Var.i;
            if (j6 != -9223372036854775807L) {
                bundle5.putLong(g0.q, j6);
            }
            bundle.putBundle(m, bundle5);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return Objects.equals(this.a, k0Var.a) && this.e.equals(k0Var.e) && Objects.equals(this.b, k0Var.b) && Objects.equals(this.c, k0Var.c) && Objects.equals(this.d, k0Var.d) && Objects.equals(this.f299f, k0Var.f299f);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        g0 g0Var = this.b;
        return this.f299f.hashCode() + ((this.d.hashCode() + ((this.e.hashCode() + ((this.c.hashCode() + ((iHashCode + (g0Var != null ? g0Var.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }
}
