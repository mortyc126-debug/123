package ij;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import mx1.t;
import mx1.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final List a;
    public final Map b;
    public final ArrayList c;
    public final ArrayList d;

    public m(List list, Map map, ArrayList arrayList, ArrayList arrayList2) {
        o.h(list, "key");
        this.a = list;
        this.b = map;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public /* synthetic */ m() {
        this(t.a, u.a, new ArrayList(), new ArrayList());
    }
}
