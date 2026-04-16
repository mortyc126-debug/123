package yo;

import bp.d;
import bp.l;
import hy1.x;
import i11.t;
import java.util.Locale;
import java.util.Set;
import lmjxuqdtp.jvm.internal.o;
import mx1.n;
import nx1.g;
import qs1.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final t a;
    public final Set b = n.C0(new l[]{l.b, l.c});
    public final String c;

    public b(String str, t tVar) {
        this.a = tVar;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        o.g(lowerCase, "toLowerCase(...)");
        this.c = x.r0(lowerCase, "-", "_");
    }

    public final g a(p pVar) {
        o.h(pVar, "auth");
        d dVarA = pVar.x().a();
        yk0.g gVar = new yk0.g(2, pVar, this);
        g gVar2 = new g();
        if (dVarA != null) {
            gVar2.put("grant_type", dVarA.a);
        }
        gVar2.put("scope", mx1.o.E0(this.b, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.c, 30));
        gVar2.put("client_id", this.c);
        gVar.invoke(gVar2);
        return gVar2.b();
    }
}
