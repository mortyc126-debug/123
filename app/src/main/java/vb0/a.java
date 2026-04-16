package vb0;

import by1.b;
import bz1.c;
import bz1.m;
import bz1.p;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final h a;

    public a(h hVar) {
        this.a = hVar;
    }

    public final Object a(String str, wy1.a aVar) {
        o.h(aVar, "serializer");
        if (str == null || str.length() == 0 || str.equals("null")) {
            return null;
        }
        c cVar = (c) this.a.getValue();
        if (!aVar.getDescriptor().b()) {
            aVar = b.D(aVar);
        }
        return cVar.a(str, aVar);
    }

    public final String b(Object obj, wy1.a aVar) {
        o.h(aVar, "serializer");
        c cVar = (c) this.a.getValue();
        if (!aVar.getDescriptor().b()) {
            aVar = b.D(aVar);
        }
        return cVar.b(obj, aVar);
    }

    public final m c(String str) {
        o.h(str, "json");
        c cVar = (c) this.a.getValue();
        cVar.getClass();
        return (m) cVar.a(str, p.a);
    }
}
