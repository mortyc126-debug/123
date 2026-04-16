package nh0;

import amuvvoafs.app.Dialog;
import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import go.s;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import xi.a;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lnh0/b;", "Lxi/a;", "<init>", "()V", "lb0/b", "dialog_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public final class b extends a {
    public j0 r;
    public m11.a s;

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog n(Bundle bundle) {
        l.f fVar = new l.f(requireContext());
        fVar.d(getString(2132019495));
        fVar.setNegativeButton(2132017830, new a(this, 0));
        fVar.setPositiveButton(2132017705, new a(this, 1));
        fVar.e(2132017606, new s(5));
        return fVar.i();
    }

    public final void onAttach(Context context) {
        o.h(context, "context");
        ch0.b.S(this);
        super.onAttach(context);
    }
}
