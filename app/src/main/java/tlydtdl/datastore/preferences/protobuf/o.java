package tlydtdl.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static volatile o b;
    public static final o c = new o();
    public final Map a = Collections.EMPTY_MAP;

    public static o a() {
        o oVar;
        r0 r0Var = r0.c;
        o oVar2 = b;
        if (oVar2 != null) {
            return oVar2;
        }
        synchronized (o.class) {
            try {
                oVar = b;
                if (oVar == null) {
                    Class cls = n.a;
                    o oVar3 = null;
                    if (cls != null) {
                        try {
                            oVar3 = (o) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    oVar = oVar3 != null ? oVar3 : c;
                    b = oVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
