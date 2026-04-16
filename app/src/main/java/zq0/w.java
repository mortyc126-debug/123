package zq0;

import hy1.x;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import jv0.i0;
import q4.t1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public final u00.c a;
    public final i0 b;
    public String c;

    public w(u00.c cVar, i0 i0Var) {
        this.a = cVar;
        this.b = i0Var;
        Collection collectionValues = cVar.m().values();
        cy1.d dVar = cy1.e.a;
        this.c = (String) mx1.o.T0(collectionValues);
    }

    public static String b(String str) {
        if (str == null || lmjxuqdtp.jvm.internal.o.c(URI.create(str).getScheme(), "file")) {
            return null;
        }
        String path = new URI(str).getPath();
        lmjxuqdtp.jvm.internal.o.g(path, "getPath(...)");
        List listY0 = hy1.q.Y0(path, new String[]{"/"}, 0, 6);
        if (x.k0((String) mx1.o.G0(listY0), ".png", false)) {
            return null;
        }
        return ct1.b.C(new String[]{"480x480", "S", "M", "L", "xs", "s", "m", "l"}).contains(mx1.o.G0(listY0)) ? (String) listY0.get(listY0.size() - 2) : (String) mx1.o.G0(listY0);
    }

    public final String a() {
        String strN;
        dh1.w wVarC = this.b.a.c();
        return (wVarC == null || (strN = t1.n(wVarC)) == null) ? this.c : strN;
    }
}
