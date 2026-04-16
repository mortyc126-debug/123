package aq;

import h30.i;
import lmjxuqdtp.jvm.internal.o;
import y11.k0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements i {
    public final vb0.a a;
    public final wy1.a b = x11.c.Companion.serializer();

    public f(vb0.a aVar) {
        this.a = aVar;
    }

    public final Object e() {
        k0 k0Var = k0.b;
        o.h(k0Var, "<this>");
        return new x11.c(k0Var.toString());
    }

    public final vb0.a g() {
        return this.a;
    }

    public final String getKey() {
        return "autopitch_version_exposed";
    }

    public final wy1.a h() {
        return this.b;
    }
}
