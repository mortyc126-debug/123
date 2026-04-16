package b31;

import az1.s0;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import nx1.g;
import wy1.a;
import xwfkdfdvbiz.serialization.SerializationException;
import yy1.h;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {
    public final a a;
    public final a b;
    public final s0 c;
    public final h d;

    public d(a aVar, a aVar2) {
        o.h(aVar, "keySerializer");
        o.h(aVar2, "valueSerializer");
        this.a = aVar;
        this.b = aVar2;
        s0 s0VarE = by1.b.e(aVar, aVar2);
        this.c = s0VarE;
        this.d = s0VarE.c;
    }

    public final Object deserialize(zy1.d dVar) {
        a aVar = this.b;
        h hVar = this.d;
        zy1.b bVarA = dVar.a(hVar);
        g gVar = new g();
        while (true) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                bVarA.b(hVar);
                return gVar.b();
            }
            try {
                gVar.put(bVarA.z(hVar, iC, this.a, (Object) null), bVarA.z(hVar, bVarA.C(hVar), aVar, (Object) null));
            } catch (SerializationException e) {
                try {
                    s02.d.a.getClass();
                    s02.b.y("Unknown value in a map key", e);
                    bVarA.E(hVar, bVarA.C(hVar), aVar, (Object) null);
                } catch (SerializationException e2) {
                    s02.d.a.getClass();
                    s02.b.s("Unknown value in a map value", e2);
                }
            }
        }
    }

    public final h getDescriptor() {
        return this.d;
    }

    public final void serialize(e eVar, Object obj) {
        Map map = (Map) obj;
        o.h(map, "value");
        this.c.serialize(eVar, map);
    }
}
