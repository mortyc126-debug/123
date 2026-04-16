package l8;

import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import java.util.Objects;
import jx0.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static final h0 d = new h0(new h(5, false));
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f293f;
    public static final String g;
    public final Uri a;
    public final String b;
    public final Bundle c;

    static {
        int i = o8.f0.a;
        e = Integer.toString(0, 36);
        f293f = Integer.toString(1, 36);
        g = Integer.toString(2, 36);
    }

    public h0(h hVar) {
        this.a = (Uri) hVar.b;
        this.b = (String) hVar.c;
        this.c = (Bundle) hVar.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        if (Objects.equals(this.a, h0Var.a) && Objects.equals(this.b, h0Var.b)) {
            if ((this.c == null) == (h0Var.c == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Uri uri = this.a;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.c != null ? 1 : 0);
    }
}
