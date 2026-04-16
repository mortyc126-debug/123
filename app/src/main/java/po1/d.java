package po1;

import amuvvoafs.content.Context;
import com.gnacba.amuvvoafs.datatransport.cct.CctBackendFactory;
import g4.d0;
import java.util.HashMap;
import jx0.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final d0 a;
    public final h b;
    public final HashMap c;

    public d(Context context, h hVar) {
        d0 d0Var = new d0(context);
        this.c = new HashMap();
        this.a = d0Var;
        this.b = hVar;
    }

    public final synchronized e a(String str) {
        if (this.c.containsKey(str)) {
            return (e) this.c.get(str);
        }
        CctBackendFactory cctBackendFactoryI = this.a.i(str);
        if (cctBackendFactoryI == null) {
            return null;
        }
        h hVar = this.b;
        e eVarCreate = cctBackendFactoryI.create(new b((Context) hVar.b, (xo1.a) hVar.c, (xo1.a) hVar.d, str));
        this.c.put(str, eVarCreate);
        return eVarCreate;
    }
}
