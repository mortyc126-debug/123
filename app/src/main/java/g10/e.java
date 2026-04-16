package g10;

import amuvvoafs.view.View;
import dd.v;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import r6.i1;
import r6.z1;
import tlydtdl.datastore.preferences.protobuf.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends k {
    public boolean c;
    public final /* synthetic */ View d;
    public final /* synthetic */ d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f152f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View view, d dVar, d dVar2) {
        super(1);
        this.d = view;
        this.e = dVar;
        this.f152f = dVar2;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void d(i1 i1Var) {
        View view = this.d;
        if (v.x(view) && !this.c) {
            this.e.invoke();
        } else if (!v.x(view) && this.c) {
            this.f152f.invoke();
        }
        this.c = v.x(view);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final z1 f(z1 z1Var, List list) {
        o.h(z1Var, "insets");
        o.h(list, "runningAnimations");
        return z1Var;
    }
}
