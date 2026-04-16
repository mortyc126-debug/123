package b8;

import java.util.LinkedHashMap;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    public f(c cVar) {
        o.h(cVar, "initialExtras");
        LinkedHashMap linkedHashMap = cVar.a;
        o.h(linkedHashMap, "initialExtras");
        this.a.putAll(linkedHashMap);
    }

    @Override // b8.c
    public final Object a(b bVar) {
        return this.a.get(bVar);
    }

    public /* synthetic */ f(int i) {
        this(a.b);
    }
}
