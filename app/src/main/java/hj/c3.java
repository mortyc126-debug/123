package hj;

import java.util.LinkedHashMap;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c3 {
    public final String a;
    public final b3 b;
    public final Map c;
    public final ij.j d;

    public c3(String str, b3 b3Var, Map map, ij.j jVar) {
        o.h(str, "id");
        o.h(b3Var, "properties");
        this.a = str;
        this.b = b3Var;
        this.c = map;
        this.d = jVar;
    }

    public static c3 a(c3 c3Var, b3 b3Var, LinkedHashMap linkedHashMap, ij.j jVar, int i) {
        String str = c3Var.a;
        if ((i & 2) != 0) {
            b3Var = c3Var.b;
        }
        Map map = linkedHashMap;
        if ((i & 4) != 0) {
            map = c3Var.c;
        }
        if ((i & 8) != 0) {
            jVar = c3Var.d;
        }
        o.h(str, "id");
        o.h(b3Var, "properties");
        return new c3(str, b3Var, map, jVar);
    }
}
