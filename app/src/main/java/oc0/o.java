package oc0;

import b01.t;
import vb0.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends b01.i {
    public final a b;
    public final p c;
    public final wy1.a d;
    public final tc0.h e;

    /* JADX INFO: renamed from: f */
    public final b01.n f369f;
    public final b01.o g;

    public o(a aVar, p pVar) {
        lmjxuqdtp.jvm.internal.o.h(pVar, "listCursorsType");
        this.b = aVar;
        this.c = pVar;
        this.d = tc0.h.Companion.serializer();
        this.e = tc0.h.c;
        this.f369f = b01.n.a;
        this.g = b01.o.a;
    }

    @Override // b01.i
    public final Object b() {
        return this.e;
    }

    @Override // b01.i
    public final a c() {
        return this.b;
    }

    @Override // b01.i
    public final String d() {
        p pVar = this.c;
        return "list_type_cursor_v2_" + pVar.b + "_" + pVar.a;
    }

    @Override // b01.i
    public final wy1.a e() {
        return this.d;
    }

    @Override // b01.m
    public final b01.n f() {
        return this.f369f;
    }

    @Override // b01.m
    public final t g() {
        return this.g;
    }
}
