package es0;

import n30.k;
import ny1.b2;
import ny1.j2;
import st.w0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final gf0.g a;
    public final boolean b;
    public final z c;
    public final k d;
    public final k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f107f;
    public final k g;

    public e(gf0.g gVar, boolean z, z zVar) {
        this.a = gVar;
        this.b = z;
        this.c = zVar;
        b2 b2VarR = ny1.z.R(gVar.d(), i1.f(zVar), j2.a(3), gf0.i.a);
        b2 b2VarR2 = ny1.z.R(new d10.j(b2VarR, gVar.b(), new d(3, 0, null), 9), i1.f(zVar), j2.a(3), mx1.t.a);
        k kVarO0 = w0.o0(b2VarR2, new dr0.i(7));
        this.d = kVarO0;
        this.e = w0.o0(b2VarR2, new dr0.i(8));
        this.f107f = w0.o0(b2VarR, new dr0.j(2, this));
        this.g = w0.o0(kVarO0, new dr0.i(this));
    }
}
