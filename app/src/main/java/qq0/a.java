package qq0;

import a21.a0;
import a21.e;
import a21.k;
import a21.n;
import a21.t;
import a21.u;
import com.bandlab.revision.state.EffectDataChain;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import mx1.p;
import y11.d2;
import y11.n0;
import y11.o1;
import y11.o4;
import y11.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements qn0.a {
    @Override // qn0.a
    public final e a(e eVar) {
        o.h(eVar, "revision");
        List<u> list = eVar.b;
        ArrayList arrayList = new ArrayList(p.c0(list, 10));
        for (u uVarA : list) {
            n nVar = uVarA.o;
            String str = nVar.a;
            if (str != null && !str.equals("none") && !o.c(nVar.a, "custom") && nVar.b == null && !nVar.c.getChain().isEmpty()) {
                uVarA = u.a(uVarA, (String) null, (t) null, (k) null, (Map) null, 0.0d, (String) null, (o4) null, 0.0d, (n0) null, false, n.a(uVarA.o, "custom", (EffectDataChain) null, 6), 16383);
            }
            arrayList.add(uVarA);
        }
        return e.a(eVar, (String) null, arrayList, (String) null, (Map) null, (LinkedHashMap) null, (String) null, (d2) null, (o1) null, (r1) null, 0.0d, (ArrayList) null, (a0) null, 8189);
    }
}
