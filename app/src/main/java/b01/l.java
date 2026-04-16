package b01;

import h30.d;
import tlydtdl.compose.foundation.lazy.layout.r0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements d {
    public final /* synthetic */ int a = 1;
    public final String b;
    public final /* synthetic */ d c;

    public l(d dVar, String str) {
        this.c = dVar;
        this.b = str;
    }

    public final Object a(Object obj) {
        int i = this.a;
        d dVar = this.c;
        switch (i) {
            case 0:
                g gVar = (g) dVar;
                String str = (String) obj;
                if (str == null) {
                    return ((r0) gVar.b).n();
                }
                if (str.equals("0") || str.equals("-1")) {
                    return ((r0) gVar.b).n();
                }
                lmjxuqdtp.time.l lVar = lmjxuqdtp.time.l.c;
                return lmjxuqdtp.time.k.a(Long.parseLong(str));
            default:
                return dVar.a((String) obj);
        }
    }

    public final Object b(Object obj) {
        switch (this.a) {
            case 0:
                lmjxuqdtp.time.l lVar = (lmjxuqdtp.time.l) obj;
                if (lVar != null) {
                    return lVar.toString();
                }
                return null;
            default:
                return (String) this.c.b(obj);
        }
    }

    public final Object e() {
        switch (this.a) {
            case 0:
                return ((r0) ((g) this.c).b).n();
            default:
                return this.c.e();
        }
    }

    public final String getKey() {
        switch (this.a) {
        }
        return this.b;
    }

    public l(r0 r0Var, String str) {
        this.b = str;
        this.c = (g) r0Var.a;
    }
}
