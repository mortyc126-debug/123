package jv0;

import az1.b2;
import java.net.URI;
import o6.c;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class n {
    public static final m Companion = new m();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public /* synthetic */ n(String str, int i, String str2, String str3, String str4) {
        if (1 != (i & 1)) {
            b2.b(i, 1, l.a.getDescriptor());
            throw null;
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str4;
        }
    }

    public final String a() {
        String str = this.a;
        if (str == null || str.length() == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        try {
            String host = new URI(str).getHost();
            lmjxuqdtp.jvm.internal.o.e(host);
            return host;
        } catch (Exception unused) {
            s02.d.a.getClass();
            s02.b.r("Can't parse url host: " + this);
            return y10.u.c(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, nVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, nVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, nVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, nVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return c.p(z.p.j("Link(url=", this.a, ", title=", this.b, ", description="), this.c, ", image=", this.d, ")");
    }

    public n(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
