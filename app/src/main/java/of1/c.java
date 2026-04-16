package of1;

import com.bandlab.uikit.compose.bottomsheet.j0;
import com.gnacba.amuvvoafs.gms.measurement.internal.a0;
import d5.y;
import java.util.LinkedHashMap;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import m2.f1;
import oz0.d1;
import se0.m;
import se0.q;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final LinkedHashMap a = new LinkedHashMap();

    public final void a(String str, long j2, long j3, int i, final Function2 function2) {
        lmjxuqdtp.jvm.internal.o.h(str, "key");
        lmjxuqdtp.jvm.internal.o.h(function2, "children");
        final int i2 = 1;
        this.a.put(str, new f1(new y(j2, j3, i), new q3.k(new Function3() { // from class: ct.c
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                switch (i2) {
                    case 0:
                        List list = (List) obj2;
                        q qVar = (q) obj3;
                        o.h(obj, "item");
                        o.h(list, "items");
                        o.h(qVar, "playlist");
                        if (obj instanceof d1) {
                            return (m) function2.invoke(a0.a((d1) obj, new gy1.a0(mx1.o.j0(list), new j0(4))), qVar);
                        }
                        throw new IllegalStateException(i.C(obj, "Unexpected item "));
                    default:
                        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        o.h((String) obj, "it");
                        s sVar = (s) mVar;
                        if (sVar.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                            function2.invoke(sVar, 0);
                        } else {
                            sVar.Z();
                        }
                        return b0.a;
                }
            }
        }, true, -1273437033)));
    }
}
